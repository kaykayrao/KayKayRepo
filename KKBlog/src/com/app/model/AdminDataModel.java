package com.app.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="usrstatus")
	private String userStatus;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="userIdFK")
	private Collection<BlogDataModel> blogs = new LinkedHashSet<BlogDataModel>();

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
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "AdminDataModel [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", userStatus=" + userStatus
				+ ", blogs=" + blogs + "]";
	}


	public Collection<BlogDataModel> getBlogs() {
		return blogs;
	}

	public void setBlogs(Collection<BlogDataModel> blogs) {
		this.blogs = blogs;
	}

	public void setBlogs(Set<BlogDataModel> blogs) {
		this.blogs = blogs;
	}

}
