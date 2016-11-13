package com.fatcat.news_sys.service.impl;

import java.util.List;

import com.fatcat.news_sys.dao.INewsColumnDao;
import com.fatcat.news_sys.entity.NewsColumn;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.factory.BeanFactory;
import com.fatcat.news_sys.service.INewsColumnService;

public class NewsColumnService implements INewsColumnService {

	// 
	private INewsColumnDao newsColumnDao = BeanFactory.getInstance(
			"newsColumnDao", INewsColumnDao.class);

	@Override
	public List<NewsColumn> findAll() {
		try {
			return newsColumnDao.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsColumn newsColumn) {
		try {
			newsColumnDao.save(newsColumn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsColumn newsColumn) {
		try {
			newsColumnDao.update(newsColumn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			newsColumnDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean findByAlls(int currentPage, int pageSize) {
		
		return this.newsColumnDao.findByAllPages(currentPage, pageSize);
	}

	@Override
	public PageBean findItem(int currentPage, int pageSize, String item) {
		
		return this.newsColumnDao.findItemPages(currentPage, pageSize, item);
	}

}
