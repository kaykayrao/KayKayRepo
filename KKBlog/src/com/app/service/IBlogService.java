package com.app.service;

import java.util.List;

import com.app.model.BlogDataModel;

public interface IBlogService {
	int saveBlog(BlogDataModel bdm);
	List<BlogDataModel> getAllBlogs();
	BlogDataModel getBlogById(int blogId);
	int deleteBlog(int blogId);
	int updateBlog(BlogDataModel bdm);
	List<Object[]> getBlogArray();
	void updateStatus(int blogId);
	List<Object[]> getPendingBlog();
	void doPublish(int blogId);
	void doReject(int blogId);
	void doPTD(int blogId);
}
