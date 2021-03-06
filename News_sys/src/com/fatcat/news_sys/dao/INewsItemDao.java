package com.fatcat.news_sys.dao;

import java.util.List;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;

/**
 * 新闻dao设计
 * @author FatCat
 *
 */
public interface INewsItemDao {
	
	/**
	 * 根据新闻标题查找新闻
	 * @param ntitle
	 * @return
	 */
	List<NewsItem> findByTitle(String ntitle);
	
	/**
	 * 根据新闻栏目id查找新闻
	 * @param id
	 * @return
	 */
	List<NewsItem> findByNcId(int id);
	
	/**
	 * 插入新闻
	 * @param news
	 */
	void save(NewsItem news);
	
	/**
	 * 修改新闻
	 * @param news
	 */
	void update(NewsItem news);
	
	/**
	 * 根据新闻id删除新闻
	 * @param id
	 */
	void deleteBynId(int id);

	/**
	 * 查询所有
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean findByAllPages(int currentPage, int pageSize);
	
	/**
	 * 根据条件查询对应新闻
	 * @param item 
	 * @param item
	 * @return
	 */
	PageBean findItemPages(int currentPage, int pageSize, String item);

}
