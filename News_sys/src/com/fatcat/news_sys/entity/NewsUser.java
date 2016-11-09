package com.fatcat.news_sys.entity;

public class NewsUser {
	private int nuid; // INT PRIMARY KEY, //用户id
	private String nuAccount; // VARCHAR(20) NOT NULL, 用户账户
	private String nuPassword; // VARCHAR(20) NOT NULL, 用户密码
	private String nuGender; // VARCHAR(20) 用户性别

	public int getNuid() {
		return nuid;
	}

	public void setNuid(int nuid) {
		this.nuid = nuid;
	}

	public String getNuAccount() {
		return nuAccount;
	}

	public void setNuAccount(String nuAccount) {
		this.nuAccount = nuAccount;
	}

	public String getNuPassword() {
		return nuPassword;
	}

	public void setNuPassword(String nuPassword) {
		this.nuPassword = nuPassword;
	}

	public String getNuGender() {
		return nuGender;
	}

	public void setNuGender(String nuGender) {
		this.nuGender = nuGender;
	}

}
