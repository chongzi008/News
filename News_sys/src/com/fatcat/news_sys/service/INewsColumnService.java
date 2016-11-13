package com.fatcat.news_sys.service;

import java.util.List;

import com.fatcat.news_sys.entity.NewsColumn;
import com.fatcat.news_sys.entity.PageBean;

public interface INewsColumnService {
	

	/**
	 * 查找所有栏目
	 * @return
	 */
	List<NewsColumn> findAll();
	
	/**
	 * 插入新的新闻栏目
	 * @param newsColumn
	 */
	void save(NewsColumn newsColumn);
	
	/**
	 * 更新新闻栏目
	 * @param newsColumn
	 */
	void update(NewsColumn newsColumn);
	
	/**
	 * 通过id删除新闻栏目
	 * @param id
	 */
	void delete(int id);
	
	PageBean findByAlls(int currentPage, int pageSize);

	PageBean findItem(int currentPage, int pageSize, String item);
}
