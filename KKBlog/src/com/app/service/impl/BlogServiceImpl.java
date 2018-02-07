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
	
	@Override
	public int saveBlog(BlogDataModel bdm) {
		int blogId = dao.saveBlog(bdm);
		return blogId;
	}

	@Override
	public List<BlogDataModel> getAllBlogs() {
		List<BlogDataModel> bloglist = dao.getAllBlogs();
		return bloglist;
	}

	@Override
	public BlogDataModel getBlogById(int blogId) {
		BlogDataModel bdm = dao.getBlogById(blogId);
		return bdm;	
	}

	@Override
	public int deleteBlog(int blogId) {
		dao.deleteBlog(blogId);
		return blogId;
	}

	@Override
	public int updateBlog(BlogDataModel bdm) {
		int blogId = dao.updateBlog(bdm);
		return blogId;
	}

	@Override
	public List<Object[]> getBlogArray() {
		return dao.getBlogArray();
	}

	@Override
	public void updateStatus(int blogId) {
		dao.updateStatus(blogId);
	}

	@Override
	public List<Object[]> getPendingBlog() {
		return dao.getPendingBlog();
	}

	@Override
	public void doPublish(int blogId) {
		dao.doPublish(blogId);	
	}

	@Override
	public void doReject(int blogId) {
		dao.doReject(blogId);
	}

	@Override
	public void doPTD(int blogId) {
		dao.doPTD(blogId);		
	}
}
