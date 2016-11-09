package com.fatcat.news_sys.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fatcat.news_sys.dao.INewsColumnDao;
import com.fatcat.news_sys.entity.NewsColumn;
import com.fatcat.news_sys.utils.JdbcUtils;

public class NewsColumnDao implements INewsColumnDao {

	@Override
	public List<NewsColumn> findAll() {
		String sql = "select * from newscolumn";
		try {
			return JdbcUtils.getQuerrRunner().query(sql,
					new BeanListHandler<NewsColumn>(NewsColumn.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsColumn newsColumn) {
		String sql = "INSERT INTO NewsColumn(NCId,NCName) VALUES(?,?)";
		try {
			JdbcUtils.getQuerrRunner().update(sql, newsColumn.getNcId(),
					newsColumn.getNcName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsColumn newsColumn) {
		String sql = "UPDATE NewsColumn SET NCName='?' WHERE NCId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, newsColumn.getNcName(),newsColumn.getNcId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from newscolumn where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
