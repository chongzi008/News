package com.fatcat.news_sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fatcat.news_sys.dao.INewsItemDao;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.utils.JdbcUtils;

public class NewsItemDao implements INewsItemDao {

	@Override
	public PageBean findByAlls(int currentPage, int pageSize) {
		try {
			PageBean pagebean = new PageBean();
			pagebean.setCurrentPage(currentPage);
			pagebean.setPageSize(pageSize);

			String sql = "select count(*) from NewsItem";
			QueryRunner qr = JdbcUtils.getQuerrRunner();
			Number num = (Number) qr.query(sql, new ScalarHandler());
			int totalRecord = num.intValue();
			pagebean.setTotalRecord(totalRecord);

			sql = "select * from NewsItem limit ?,?";
			List PagebeanList = (List) qr.query(sql, new BeanListHandler<NewsItem>(NewsItem.class),
					new Object[] { Integer.valueOf((currentPage - 1) * pageSize), Integer.valueOf(pageSize) });

			pagebean.setPageBeanList(PagebeanList);

			return pagebean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean findItem(int currentPage, int pageSize, String item) {

		try {

			PageBean pagebean = new PageBean();
			pagebean.setCurrentPage(currentPage);
			pagebean.setPageSize(pageSize);

			String sql = "SELECT * FROM NewsItem WHERE NTitle LIKE ? ";
			List<NewsItem> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<NewsItem>(NewsItem.class),
					"%" + item + "%");
			int totalRecord = list.size();

			// 设置总页数
			pagebean.setTotalRecord(totalRecord);

			sql = "SELECT * FROM NewsItem WHERE NTitle LIKE ? limit ?,?";
			List<NewsItem> PagebeanList = (List<NewsItem>) JdbcUtils.getQuerrRunner().query(sql,
					new BeanListHandler<NewsItem>(NewsItem.class), new Object[] { "%" + item + "%",
							Integer.valueOf((currentPage - 1) * pageSize), Integer.valueOf(pageSize) });

			pagebean.setPageBeanList(PagebeanList);

			return pagebean;

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	@Override
	public List<NewsItem> findByNcId(int id) {
		String sql = "SELECT * FROM NewsItem WHERE NCId=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<NewsItem>(NewsItem.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsItem news) {
		String sql = "INSERT INTO NewsItem(NId,NTitle,NContent,NCImg,NAuthor,NTime,NKeyWord,NCId) VALUES(?,?,?,?,?,?,?,?)";
		try {
			JdbcUtils.getQuerrRunner().update(sql, new Object[] { news.getnId(), news.getnTitle(), news.getnContent(),
					news.getNcImg(), news.getnAuthor(), news.getnTime(), news.getnKeyWord(), news.getNcId() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsItem news) {
		String sql = "UPDATE NewsItem SET NTitle=?,NContent=?,NCImg=?,NAuthor=?,NTime=?,NKeyWord=?,NCId=? WHERE NId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, new Object[] { news.getnTitle(), news.getnContent(), news.getNcImg(),
					news.getnAuthor(), news.getnTime(), news.getnKeyWord(), news.getNcId(), news.getnId() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<NewsItem> findByTitle(String ntitle) {
		String sql = "SELECT * FROM NewsItem WHERE NTitle LIKE ?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<NewsItem>(NewsItem.class), ntitle);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBynId(int id) {
		String sql = "delete from NewsItem where NId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, Integer.valueOf(id));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	
}
