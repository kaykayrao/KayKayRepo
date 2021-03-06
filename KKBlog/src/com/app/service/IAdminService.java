package com.app.service;

import java.util.List;

import com.app.model.AdminDataModel;

public interface IAdminService {
	int saveUser(AdminDataModel adm);
	List<AdminDataModel> getAllUsers();
	AdminDataModel getUserById(int userId);
	int deleteUser(int userId);
	int updateUser(AdminDataModel adm);
	List<Object[]> getUserArray();
	String updateStatus(int userId);
	void suspendUser(int userId);
	void reactUsr(int userId);
}
