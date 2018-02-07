package com.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.BlogDataModel;
import com.app.service.IBlogService;

@Controller
public class BlogController {

	@Autowired
	private IBlogService service;

	@RequestMapping("/editor")
	public String welcomePage()
	{
		return "EditorHome";
	}

	@RequestMapping("/blog")
	public String blogPage()
	{
		return "CreateBlog";
	}

	//================================================================
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public String saveData(@ModelAttribute("blogDataModel")BlogDataModel bdm,ModelMap m, @RequestParam("doc")CommonsMultipartFile file)
	{
		long fileSizeInKB = file.getSize()/1024;
		long fileSizeInMB = fileSizeInKB / 1024;
		if(service.getBlogById(bdm.getBlogId())!=null)
		{
			String s="Blog with id:"+bdm.getBlogId()+" already registered. plz try with other ID";
			m.addAttribute("msg", s);
			return "CreateBlog";
		}
		if(fileSizeInMB>=5)
		{
			String s="File size exeeds more than 5MB. please use lesser size ";
			m.addAttribute("msg", s);
			return "CreateBlog";
		}
		else{	
			bdm.setBannerData(file.getBytes());
			bdm.setBannerSize(file.getSize());
			bdm.setBannerName(file.getOriginalFilename());
			int blogId = service.saveBlog(bdm);
			String msg = "Registered Blog with id: "+blogId+" Details: "+service.getBlogById(bdm.getBlogId());
			m.addAttribute("msg", msg);
			System.out.println(file.getSize());
			return "CreateBlog";
		}
	}
	//================================================================
	@RequestMapping("/viewallll")
	public ModelAndView viewBlogData()
	{
		ModelAndView mav=new ModelAndView();
		try{
			List<BlogDataModel> bloglist = service.getAllBlogs();
			String s ="";
			String s1="";
			if(bloglist == null)
			{
				s = "No Blogs to display";
			}
			else
			{
				s = "Listed Blogs are: "+bloglist;
			}
			mav.addObject("bloglist",s);
			mav.setViewName("BlogView");
		}catch(Exception e)
		{
			System.err.println(e);
		}
		return mav;
	}
	//================================================================
	@RequestMapping(value="/managedata",method=RequestMethod.GET)
	public String manageData(ModelMap m)
	{
		List<Object[]> l = service.getBlogArray();

		Iterator i = l.listIterator();

		m.addAttribute("listmsg", l);
		return "BlogView";
	}

	//================================================================
	@RequestMapping(value="/deleteblog", method=RequestMethod.GET)
	public String deleteFile(@RequestParam("blogid")int bid,ModelMap m)
	{
		service.deleteBlog(bid);
		return "redirect:managedata";
	}
	//================================================================

	@RequestMapping(value="/dlbanner", method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse res,@RequestParam("blogid")int id,ModelMap m)
	{
		BlogDataModel ob = service.getBlogById(id);
		res.addHeader("Content-Disposition", "attachment;filename="+ob.getBannerName());
		try{
			FileCopyUtils.copy(ob.getBannerData(), res.getOutputStream());
		}catch(Exception e)
		{
			System.err.println(e);
		}
	}
	//================================================================
	@RequestMapping(value="settopublish",method=RequestMethod.GET)
	public String setToPublish(@RequestParam("blogid")int id,ModelMap m)
	{
		service.updateStatus(id);
		return "redirect:managedata";
	}
	//================================================================
		
	@RequestMapping(value="editblog",method=RequestMethod.GET)
	public String editBlog(@RequestParam("blogid")int id,ModelMap m)
	{
		BlogDataModel bdm = service.getBlogById(id);
		m.addAttribute("x", id);
		m.addAttribute("y",bdm.getBlogTitle());
		m.addAttribute("z", bdm.getBlogContent());
		m.addAttribute("p", bdm.getBlogStatus());
		return "EditBlog";
	}
	
	@RequestMapping("update")
	public String updateBlog(@RequestParam("blogId")int id,@RequestParam("blogContent")String content,@RequestParam("blogTitle")String title,ModelMap m)
	{
		BlogDataModel bdm = new BlogDataModel();
		bdm.setBlogId(id);
		bdm.setBlogContent(content);
		bdm.setBlogTitle(title);
		bdm.setBlogStatus(service.getBlogById(id).getBlogStatus());
		bdm.setBannerData(service.getBlogById(id).getBannerData());
		bdm.setBannerName(service.getBlogById(id).getBannerName());
		bdm.setBannerSize(service.getBlogById(id).getBannerSize());
		service.updateBlog(bdm);
		return "redirect:managedata";
	}
	//================================================================

	@RequestMapping(value="preview",method=RequestMethod.GET)
	public String previewBlog(@RequestParam("blogid")int id,ModelMap m)
	{
		BlogDataModel bdm = service.getBlogById(id);
		m.addAttribute("x", id);
		m.addAttribute("y",bdm.getBlogTitle());
		m.addAttribute("z", bdm.getBlogContent());
		return "PreviewBlog";
	}
}
