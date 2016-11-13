package com.fatcat.news_sys.service;

import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.exception.newsUserException;

public interface INewsUserService {

	/**
	 * ����û����ѯ
	 * 
	 * @param UserName
	 * @return
	 */
	NewsUser findByName(NewsUser newsUser);

	/**
	 * ����û�
	 * 
	 * @param newsUser
	 */
	void save(NewsUser newsUser);

	/**
	 * �����û�
	 * 
	 * @param newsUser
	 */
	void update(NewsUser newsUser);

	/**
	 * ����û���ɾ���û�
	 * 
	 * @param UserName
	 */
	void deleteByName(String NUAccount);
	
	PageBean findByAlls(int currentPage, int pageSize);

	PageBean findItem(int currentPage, int pageSize, String item);

	void check(NewsUser newsUser) throws newsUserException;
}
