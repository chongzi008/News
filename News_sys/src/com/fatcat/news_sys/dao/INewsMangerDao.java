package com.fatcat.news_sys.dao;

import com.fatcat.news_sys.entity.NewsManager;

public interface INewsMangerDao {


	NewsManager findByName(NewsManager newsManager);
	
	
	void save(NewsManager newsManager);
	

	void update(NewsManager newsManager);
	

	void deleteByName(String nMangerAccount);
	
	
}
