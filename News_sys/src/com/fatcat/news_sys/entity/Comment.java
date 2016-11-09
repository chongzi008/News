package com.fatcat.news_sys.entity;

import java.util.Date;

public class Comment {
 	private int ncId;//评论id
 	private Date ncTime;//评论时间
 	private String ncContent;//评论内容
 	private int nId;//新闻id
 	private int nuId;//评论用户id
	public int getNcId() {
		return ncId;
	}
	public void setNcId(int ncId) {
		this.ncId = ncId;
	}
	public Date getNcTime() {
		return ncTime;
	}
	public void setNcTime(Date ncTime) {
		this.ncTime = ncTime;
	}
	public String getNcContent() {
		return ncContent;
	}
	public void setNcContent(String ncContent) {
		this.ncContent = ncContent;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public int getNuId() {
		return nuId;
	}
	public void setNuId(int nuId) {
		this.nuId = nuId;
	}
 	
 	

}
