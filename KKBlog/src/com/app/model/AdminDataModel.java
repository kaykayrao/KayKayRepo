package com.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usrtab")
public class AdminDataModel {

	@Id
	@Column(name="usrid")
	@GeneratedValue
	private int userId;

	@Column(name="usrname")
	private String userName;

	@Column(name="usrpwd")
	private String userPwd;
	
	@OneToMany
	@JoinColumn(name="blogIdFK")
	private Set<BlogDataModel> blogs;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "AdminDataModel [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + "]";
	}

	public Set<BlogDataModel> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<BlogDataModel> blogs) {
		this.blogs = blogs;
	}

}
