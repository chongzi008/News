package com.fatcat.news_sys.entity;

/**
 * 管理员实体类
 * 
 * @author ChongZi007
 * 
 */
public class NewsManager {
	private int nMangerId;
	private String nMangerAccount;
	private String nMangerPassword;
	private int nMangerAuthority;

	public int getnMangerId() {
		return nMangerId;
	}

	public void setnMangerId(int nMangerId) {
		this.nMangerId = nMangerId;
	}

	public String getnMangerAccount() {
		return nMangerAccount;
	}

	public void setnMangerAccount(String nMangerAccount) {
		this.nMangerAccount = nMangerAccount;
	}

	public String getnMangerPassword() {
		return nMangerPassword;
	}

	public void setnMangerPassword(String nMangerPassword) {
		this.nMangerPassword = nMangerPassword;
	}

	public int getnMangerAuthority() {
		return nMangerAuthority;
	}

	public void setnMangerAuthority(int nMangerAuthority) {
		this.nMangerAuthority = nMangerAuthority;
	}

}
