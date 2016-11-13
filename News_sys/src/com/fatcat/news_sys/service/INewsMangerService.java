package com.fatcat.news_sys.service;

import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.NewsManager;
import com.fatcat.news_sys.entity.PageBean;

public interface INewsMangerService {

	NewsManager findByName(NewsManager newsManager);

	void save(NewsManager newsManager);

	void update(NewsManager newsManager);

	void deleteByName(String nMangerAccount);

	PageBean findByAlls(int currentPage, int pageSize);

	PageBean findItem(int currentPage, int pageSize, String item);
}
