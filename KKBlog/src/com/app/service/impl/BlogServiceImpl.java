package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBlogDao;
import com.app.model.BlogDataModel;
import com.app.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService {

	@Autowired
	private IBlogDao dao;

	public int saveBlog(BlogDataModel bdm) {
		int blogId = dao.saveBlog(bdm);
		return blogId;
	}

	public List<BlogDataModel> getAllBlogs() {
		List<BlogDataModel> bloglist = dao.getAllBlogs();
		return bloglist;
	}

	public BlogDataModel getBlogById(int blogId) {
		BlogDataModel bdm = dao.getBlogById(blogId);
		return bdm;
	}

	public int deleteBlog(int blogId) {
		dao.deleteBlog(blogId);
		return blogId;
	}

	public int updateBlog(BlogDataModel bdm) {
		int blogId = dao.updateBlog(bdm);
		return blogId;
	}

	public List<Object[]> getBlogArray() {
		return dao.getBlogArray();
	}

	public void updateStatus(int blogId) {
		dao.updateStatus(blogId);
		
	}

	public List<Object[]> getPendingBlog() {
		return dao.getPendingBlog();
	}

	public void doPublish(int blogId) {
		dao.doPublish(blogId);	
		
	}

	public void doReject(int blogId) {
		dao.doReject(blogId);
	}

	public void doPTD(int blogId) {
		dao.doPTD(blogId);
		
	}
	
	
}
