package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="blog_table")
public class BlogDataModel {

	@Id
	@Column(name="bid")
	private int blogId;
	
	@Column(name="btitle")
	private String blogTitle;
	
	@Column(name="bcontent")
	private String blogContent;
	
	@Column(name="bstatus")
	private String blogStatus;
	
	@Column(name="banName")
	private String bannerName;
	
	@Column(name="banSize")
	private double bannerSize;
	
	@Lob
	@Column(name="bandata")
	private byte[] bannerData;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public double getBannerSize() {
		return bannerSize;
	}

	public void setBannerSize(double bannerSize) {
		this.bannerSize = bannerSize;
	}

	public byte[] getBannerData() {
		return bannerData;
	}

	public void setBannerData(byte[] bannerData) {
		this.bannerData = bannerData;
	}

	@Override
	public String toString() {
		return "BlogDataModel [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent
				+ ", blogStatus=" + blogStatus + ", bannerName=" + bannerName
				+ ", bannerSize=" + bannerSize + ", bannerData="
				+ Arrays.toString(bannerData) + "]";
	}


	
}
