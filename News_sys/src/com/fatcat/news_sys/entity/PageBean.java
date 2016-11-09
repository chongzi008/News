package com.fatcat.news_sys.entity;

import java.util.List;

public class PageBean<T> {
	private int currentPage;
	private int totalPage;
	private int totalRecord;
	private int pageSize;
	private List<T> pageBeanList;
	private String url;

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		int totalpages = this.totalRecord / this.pageSize;
		return this.totalRecord % this.pageSize == 0 ? totalpages : totalpages + 1;
	}

	public int getTotalRecord() {
		return this.totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getPageBeanList() {
		return this.pageBeanList;
	}

	public void setPageBeanList(List<T> pageBeanList) {
		this.pageBeanList = pageBeanList;
	}
}
