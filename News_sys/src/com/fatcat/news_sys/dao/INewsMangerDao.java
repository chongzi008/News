package com.fatcat.news_sys.dao;

import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.NewsManager;
import com.fatcat.news_sys.entity.PageBean;

public interface INewsMangerDao {

	NewsManager findByName(NewsManager newsManager);

	void save(NewsManager newsManager);

	void update(NewsManager newsManager);

	void deleteByName(String nMangerAccount);

	PageBean<NewsItem> findByAllPages(int currentPage, int pageSize);

	PageBean findItemPages(int currentPage, int pageSize, String item);
}
