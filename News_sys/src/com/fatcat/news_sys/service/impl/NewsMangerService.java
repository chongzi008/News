package com.fatcat.news_sys.service.impl;

import com.fatcat.news_sys.dao.impl.NewsMangerDao;
import com.fatcat.news_sys.entity.NewsManager;
import com.fatcat.news_sys.factory.BeanFactory;
import com.fatcat.news_sys.service.INewsMangerService;

public class NewsMangerService implements INewsMangerService {
	private NewsMangerDao mangerDao = BeanFactory.getInstance(
			"newsMangerDao", NewsMangerDao.class);

	@Override
	public NewsManager findByName(NewsManager newsManager) {
		return mangerDao.findByName(newsManager);
	}

	@Override
	public void save(NewsManager newsManager) {
         this.mangerDao.save(newsManager);
	}

	@Override
	public void update(NewsManager newsManager) {
          this.mangerDao.update(newsManager);
	}

	@Override
	public void deleteByName(String nMangerAccount) {
          this.mangerDao.deleteByName(nMangerAccount);
	}

}
