package com.app.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IBlogDao;
import com.app.model.BlogDataModel;

@Repository
public class BlogDaoImpl implements IBlogDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private SessionFactory sf;

	@Override
	public int saveBlog(BlogDataModel bdm) {
		Serializable ob = ht.save(bdm);
		int blogId = (Integer)ob;
		return blogId;
	}

	@Override
	public List<BlogDataModel> getAllBlogs() {
		List<BlogDataModel> bloglist = ht.loadAll(BlogDataModel.class);
		return bloglist;
	}

	@Override
	public BlogDataModel getBlogById(int blogId) {
		BlogDataModel bdm = ht.get(BlogDataModel.class, blogId);
		return bdm;
	}

	@Override
	public int deleteBlog(int blogId) {
		BlogDataModel bdm = new BlogDataModel();
		bdm.setBlogId(blogId);
		ht.delete(bdm);
		return blogId;
	}

	@Override
	public int updateBlog(BlogDataModel bdm) {
		ht.update(bdm);
		return bdm.getBlogId();
	}

	@Override
	public List<Object[]> getBlogArray() {
		String hql = "select blogId,blogTitle,blogContent,blogStatus from com.app.model.BlogDataModel";
		return ht.find(hql);


	}

	@Override
	public void updateStatus(int id) {
		Session s = sf.openSession();
		String sql = "update blog_table set bstatus='ReadyToPublish' where bid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, id);
		q.executeUpdate();
	}

	@Override
	public List<Object[]> getPendingBlog() {
		String hql = "select blogId,blogTitle,blogStatus from com.app.model.BlogDataModel where blogStatus='ReadyToPublish'";
		return ht.find(hql);
	}

	@Override
	public void doPublish(int id) {
		Session s = sf.openSession();
		String sql = "update blog_table set bstatus='Publish' where bid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, id);
		q.executeUpdate();
	}

	@Override
	public void doReject(int blogId) {
		Session s = sf.openSession();
		String sql = "update blog_table set bstatus='Reject' where bid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, blogId);
		q.executeUpdate();
	}

	@Override
	public void doPTD(int blogId) {
		Session s = sf.openSession();
		String sql = "update blog_table set bstatus='Publish To Date' where bid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, blogId);
		q.executeUpdate();
	}



}
