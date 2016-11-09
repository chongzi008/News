package com.fatcat.news_sys.service.impl;

import java.util.List;

import com.fatcat.news_sys.dao.INewsItemDao;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.factory.BeanFactory;
import com.fatcat.news_sys.service.INewsItemService;

public class NewsItemService implements INewsItemService {
	
	private INewsItemDao newsItemDao = (INewsItemDao) BeanFactory.getInstance("newsItemDao", INewsItemDao.class);

	@Override
	public List<NewsItem> findByTitle(String ntitle) {
		try {
			return this.newsItemDao.findByTitle(ntitle);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<NewsItem> findByNcId(int id) {
		try {
			return this.newsItemDao.findByNcId(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsItem news) {
		try {
			this.newsItemDao.save(news);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsItem news) {
		try {
			this.newsItemDao.update(news);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBynId(int id) {
		try {
			this.newsItemDao.deleteBynId(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean<NewsItem> findByAlls(int currentPage, int pageSize) {
		return this.newsItemDao.findByAlls(currentPage, pageSize);
	}

	@Override
	public PageBean findItem(int currentPage, int pageSize, String item) {
		return this.newsItemDao.findItem(currentPage, pageSize,item);
	}

}
