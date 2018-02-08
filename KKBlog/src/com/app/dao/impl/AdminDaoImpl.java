package com.app.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAdminDao;
import com.app.model.AdminDataModel;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private SessionFactory sf;
	
	private Session s;

	public int saveUser(AdminDataModel adm) {
		Serializable ob = ht.save(adm);
		int userId = (Integer)ob;
		return userId;	
	}

	public List<AdminDataModel> getAllUsers() {
		List<AdminDataModel> userlist = ht.loadAll(AdminDataModel.class);
		return userlist;
	}

	public AdminDataModel getUserById(int userId) {
		AdminDataModel adm = ht.get(AdminDataModel.class, userId);
		return adm;
	}

	public int deleteUser(int userId) {
		AdminDataModel adm = new AdminDataModel();
		adm.setUserId(userId);
		ht.delete(adm);
		return userId;
	}

	public int updateUser(AdminDataModel adm) {
		ht.update(adm);
		return adm.getUserId();	
	}

	public List<Object[]> getUserArray() {
		String hql = "select userId,userName,userPwd,userStatus from com.app.model.AdminDataModel";
		return ht.find(hql);
	}

	public String updateStatus(int userId) {
		String hql = "update com.app.model.BlogDataModel set blogStatus='Published' where blogId=id";
		ht.bulkUpdate(hql);
		return "Status Changed";
	}

	public void suspendUser(int userId) {
		s = sf.openSession();
		String sql = "update usrtab set usrstatus='Suspended' where usrid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, userId);
		q.executeUpdate();		
	}

	public void reactUsr(int userId) {
		s = sf.openSession();
		String sql = "update usrtab set usrstatus='Active' where usrid=?";
		SQLQuery q = s.createSQLQuery(sql);
		q.setParameter(0, userId);
		q.executeUpdate();		
	}

	

}
