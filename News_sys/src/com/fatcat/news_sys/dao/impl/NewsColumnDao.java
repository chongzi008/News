package com.fatcat.news_sys.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fatcat.news_sys.dao.INewsColumnDao;
import com.fatcat.news_sys.entity.NewsColumn;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.utils.JdbcUtils;
import com.fatcat.news_sys.utils.PageUtils;

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
		String sql = "UPDATE newscolumn SET NCName=? WHERE NCId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, newsColumn.getNcName(),newsColumn.getNcId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from newscolumn where NCId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean findByAllPages(int currentPage, int pageSize) {
		
		return PageUtils.findByAlls(currentPage, pageSize, "newscolumn", NewsColumn.class);
	}

	@Override
	public PageBean findItemPages(int currentPage, int pageSize, String item) {
		return PageUtils.findItem(currentPage, pageSize, item, "newscolumn", "NCName", NewsColumn.class);
	}

}
