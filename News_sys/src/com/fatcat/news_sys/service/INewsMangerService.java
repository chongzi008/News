package com.fatcat.news_sys.service;

import com.fatcat.news_sys.entity.NewsManager;

public interface INewsMangerService {

	NewsManager findByName(NewsManager newsManager);

	void save(NewsManager newsManager);

	void update(NewsManager newsManager);

	void deleteByName(String nMangerAccount);

}
