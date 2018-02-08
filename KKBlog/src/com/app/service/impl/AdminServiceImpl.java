package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.model.AdminDataModel;
import com.app.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;

	public int saveUser(AdminDataModel adm) {
		int userId = dao.saveUser(adm);
		return userId;	
	}

	public List<AdminDataModel> getAllUsers() {
		List<AdminDataModel> userlist = dao.getAllUsers();
		return userlist;
	}

	public AdminDataModel getUserById(int userId) {
		AdminDataModel adm = dao.getUserById(userId);
		return adm;	
	}

	public int deleteUser(int userId) {
		dao.deleteUser(userId);
		return userId;	
	}

	public int updateUser(AdminDataModel adm) {
		int userId = dao.updateUser(adm);
		return userId;	
	}

	public List<Object[]> getUserArray() {
		return dao.getUserArray();
	}

	public String updateStatus(int userId) {
		return dao.updateStatus(userId);
	}

	public void suspendUser(int userId) {
		dao.suspendUser(userId);
		
	}

	public void reactUsr(int userId) {
		dao.reactUsr(userId);
		
	}

	
}
