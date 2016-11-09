package com.fatcat.news_sys.entity;

import java.util.Date;

public class NewsItem {
	private int nId;// 新闻id
	private String nTitle;// 新闻标题
	private String nContent;// 新闻内容
	private String ncImg;// 新闻图片路径
	private String nAuthor;// 新闻作者
	private Date nTime;// 新闻发布时间
	private String nKeyWord;// 新闻关键词
	private int ncId;// 新闻栏目id

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getNcImg() {
		return ncImg;
	}

	public void setNcImg(String ncImg) {
		this.ncImg = ncImg;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	public Date getnTime() {
		return nTime;
	}

	public void setnTime(Date nTime) {
		this.nTime = nTime;
	}

	public String getnKeyWord() {
		return nKeyWord;
	}

	public void setnKeyWord(String nKeyWord) {
		this.nKeyWord = nKeyWord;
	}

	public int getNcId() {
		return ncId;
	}

	public void setNcId(int ncId) {
		this.ncId = ncId;
	}

}
