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

	@Override
	public int saveUser(AdminDataModel adm) {
		int userId = dao.saveUser(adm);
		return userId;	
	}

	@Override
	public List<AdminDataModel> getAllUsers() {

		List<AdminDataModel> userlist = dao.getAllUsers();
		return userlist;	
	}

	@Override
	public AdminDataModel getUserById(int userId) {
		AdminDataModel adm = dao.getUserById(userId);
		return adm;		
	}

	@Override
	public int deleteUser(int userId) {
		dao.deleteUser(userId);
		return userId;	}

	@Override
	public int updateUser(AdminDataModel adm) {
		int userId = dao.updateUser(adm);
		return userId;	

	}

	@Override
	public List<Object[]> getUserArray() {
		return dao.getUserArray();
	}

	@Override
	public String updateStatus(int userId) {
		return dao.updateStatus(userId);
	}

}
