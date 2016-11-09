package com.fatcat.news_sys.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fatcat.news_sys.dao.INewsUserDao;
import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.utils.JdbcUtils;

public class NewsUserDao implements INewsUserDao {

	@Override
	public NewsUser findByName(NewsUser newsUser) {
		String sql = "select * from newsuser where NUAccount=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql,
					new BeanHandler<NewsUser>(NewsUser.class), newsUser.getNuAccount());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsUser newsUser) {
		String sql = "INSERT INTO newsuser(NUid,NUAccount,NUPassword,NUGender) VALUES(?,?,?,?);";
		try {
			JdbcUtils.getQuerrRunner().update(sql, newsUser.getNuid(),
					newsUser.getNuAccount(),newsUser.getNuPassword(),newsUser.getNuGender());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsUser newsUser) {
		String sql = "update newsuser set NUId=?,NUAccount=?,NUPassword=?,NUGender=? where Nuid=?;";
		try {
			JdbcUtils.getQuerrRunner().update(sql, newsUser.getNuid(),
					newsUser.getNuAccount(),newsUser.getNuPassword(),newsUser.getNuGender(),newsUser.getNuid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteByName(String NUAccount) {
		String sql = "delete from newsuser where NUAccount=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, NUAccount);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
