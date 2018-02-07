package com.app.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAdminDao;
import com.app.model.AdminDataModel;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveUser(AdminDataModel adm) {
		Serializable ob = ht.save(adm);
		int userId = (Integer)ob;
		return userId;	
	}

	@Override
	public List<AdminDataModel> getAllUsers() {
		List<AdminDataModel> userlist = ht.loadAll(AdminDataModel.class);
		return userlist;	}

	@Override
	public AdminDataModel getUserById(int userId) {
		AdminDataModel adm = ht.get(AdminDataModel.class, userId);
		return adm;	}

	@Override
	public int deleteUser(int userId) {
		AdminDataModel adm = new AdminDataModel();
		adm.setUserId(userId);
		ht.delete(adm);
		return userId;
	}

	@Override
	public int updateUser(AdminDataModel adm) {
		ht.update(adm);
		return adm.getUserId();	
	}

	@Override
	public List<Object[]> getUserArray() {
		String hql = "select userId,userName,userPwd from com.app.model.AdminDataModel";
		return ht.find(hql);
	}

	@Override
	public String updateStatus(int userId) {
		String hql = "update com.app.model.BlogDataModel set blogStatus='Published' where blogId=id";
		ht.bulkUpdate(hql);
		return "Status Changed";
	}

}
