package com.app.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.AdminDataModel;
import com.app.service.IAdminService;
import com.app.service.IBlogService;

@Controller
public class AdminController {

	@Autowired
	private IBlogService sblog;

	@Autowired
	private IAdminService service;

	@RequestMapping("/admin")
	public String welcomePage()
	{
		return "AdminHome";
	}

	@RequestMapping("/usr")
	public String userPage()
	{
		return "CreateUser";
	}

	@RequestMapping(value="manageuser", method=RequestMethod.GET)
	public String viewUsers(ModelMap m)
	{
		List<Object[]> l = service.getUserArray();
		Iterator i = l.listIterator();
		m.addAttribute("msg",l);
		return "AdminHome";
	}

	//================================================================
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String saveData(@ModelAttribute("adminDataModel")AdminDataModel adm,ModelMap m)
	{
		adm.setUserStatus("Active");
		int userId = service.saveUser(adm);
		String msg = "Registered User with id: "+userId+" Details: "+service.getUserById(userId);
		m.addAttribute("msg", msg);
		return "CreateUser";
	}
	//================================================================
	@RequestMapping(value="deleteuser" , method=RequestMethod.GET)
	public String deleteUser(@RequestParam("userid")int id,ModelMap m)
	{
		service.deleteUser(id);
		return "redirect:manageuser";
	}
	//================================================================
	@RequestMapping(value="pendingapproval", method=RequestMethod.GET)
	public String getPendingBlog(ModelMap m)
	{
		List<Object[]> l = sblog.getPendingBlog();
		Iterator i = l.listIterator();
		m.addAttribute("list",l);
		return "AdminHome";
	}
	//================================================================
	@RequestMapping(value="approveblog",method=RequestMethod.GET)
	public String approve(@RequestParam("blogid")int id,ModelMap m)
	{
		sblog.doPublish(id);
		return "redirect:pendingapproval";
	}
	//================================================================
	@RequestMapping(value="rejectblog",method=RequestMethod.GET)
	public String reject(@RequestParam("blogid")int id,ModelMap m)
	{
		sblog.doReject(id);
		return "redirect:pendingapproval";
	}
	//================================================================
		@RequestMapping(value="setblogdate",method=RequestMethod.GET)
		public String setptd(@RequestParam("blogid")int id,ModelMap m)
		{
			sblog.doPTD(id);
			return "redirect:pendingapproval";
		}
	//================================================================
		@RequestMapping(value="suspenduser",method=RequestMethod.GET)
		public String suspendUsr(@RequestParam("userid")int id,ModelMap m)
		{
			service.suspendUser(id);
			return "redirect:manageuser";
		}
		
	//================================================================
		@RequestMapping(value="reactuser",method=RequestMethod.GET)
		public String reactiveUsr(@RequestParam("userid")int id,ModelMap m)
		{
			service.reactUsr(id);
			return "redirect:manageuser";
		}
		
}
