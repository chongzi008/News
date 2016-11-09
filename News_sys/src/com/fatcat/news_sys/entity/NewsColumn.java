package com.fatcat.news_sys.entity;

import java.util.Date;

public class NewsColumn {

	private int ncId;// INT PRIMARY KEY AUTO_INCREMENT, -- ����
	
	private String ncName;// VARCHAR(20) NOT NULL, -- ������Ŀ����

	public int getNcId() {
		return ncId;
	}

	public void setNcId(int ncId) {
		this.ncId = ncId;
	}

	public String getNcName() {
		return ncName;
	}

	public void setNcName(String ncName) {
		this.ncName = ncName;
	}
	
	
	
}
