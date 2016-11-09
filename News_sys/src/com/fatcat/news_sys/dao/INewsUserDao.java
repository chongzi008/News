package com.fatcat.news_sys.dao;

import com.fatcat.news_sys.entity.NewsUser;
/**
 * �û�ģ�� dao�ӿ����
 * @author FatCat
 *
 */
public interface INewsUserDao {
	

	/**
	 * ����û����ѯ
	 * @param UserName
	 * @return
	 */
	NewsUser findByName(NewsUser newsUser);
	
	/**
	 * ����û�
	 * @param newsUser
	 */
	void save(NewsUser newsUser);
	
	/**
	 * �����û�
	 * @param newsUser
	 */
	void update(NewsUser newsUser);
	
	/**
	 * ����û���ɾ���û�
	 * @param UserName
	 */
	void deleteByName(String NUAccount);
	
	
}
