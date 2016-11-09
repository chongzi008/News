package com.fatcat.news_sys.service.impl;

import com.fatcat.news_sys.dao.INewsUserDao;
import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.factory.BeanFactory;
import com.fatcat.news_sys.service.INewsUserService;


public class NewsUserService implements INewsUserService {

	
	private INewsUserDao newsUserDao = BeanFactory.getInstance("newsUserDao",
			INewsUserDao.class);

	@Override
	public NewsUser findByName(NewsUser newsUser) {
		try {
			return newsUserDao.findByName(newsUser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsUser newsUser) {
		try {
			newsUserDao.save(newsUser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsUser newsUser) {
        this.newsUserDao.update(newsUser);
	}

	@Override
	public void deleteByName(String NUAccount) {
		try {
			newsUserDao.deleteByName(NUAccount);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
