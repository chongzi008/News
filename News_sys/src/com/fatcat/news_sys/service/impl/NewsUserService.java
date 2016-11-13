package com.fatcat.news_sys.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.fatcat.news_sys.dao.INewsUserDao;
import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.exception.newsUserException;
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

	@Override
	public PageBean findByAlls(int currentPage, int pageSize) {
		return this.newsUserDao.findByAllPages(currentPage, pageSize);
	}

	@Override
	public PageBean findItem(int currentPage, int pageSize, String item) {
		return this.newsUserDao.findItemPages(currentPage, pageSize, item);
	}

	@Override
	public void check(NewsUser newsUser) throws newsUserException {
		String account=newsUser.getNuAccount();
		
		if(account.trim()==null||account==null){
	         //如果用户账号不符合格式我们就抛出异常吧
			throw new newsUserException("用户名不能为空");
		}
		
		if(account.length()<6||account.length()>15){
			throw new newsUserException("用户名长度不符合格式要求");
		}
		
		
		
	}

}
