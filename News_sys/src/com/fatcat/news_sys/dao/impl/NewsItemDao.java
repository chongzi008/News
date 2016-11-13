package com.fatcat.news_sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fatcat.news_sys.dao.INewsItemDao;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.utils.JdbcUtils;
import com.fatcat.news_sys.utils.PageUtils;

public class NewsItemDao implements INewsItemDao {
	/**
	 * 分页显示所有新闻到页面上
	 */

	@Override
	public PageBean findByAllPages(int currentPage, int pageSize) {

		return PageUtils.findByAlls(currentPage, pageSize, "NewsItem",
				NewsItem.class);
	}

	/**
	 * 根绝新闻标题查询
	 */
	@Override
	public PageBean findItemPages(int currentPage, int pageSize, String item) {

		return PageUtils.findItem(currentPage, pageSize, item, "newsitem",
				"NTitle", NewsItem.class);

	}

	@Override
	public List<NewsItem> findByNcId(int id) {
		String sql = "SELECT * FROM NewsItem WHERE NCId=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql,
					new BeanListHandler<NewsItem>(NewsItem.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(NewsItem news) {
		String sql = "INSERT INTO NewsItem(NId,NTitle,NContent,NCImg,NAuthor,NTime,NKeyWord,NCId) VALUES(?,?,?,?,?,?,?,?)";
		try {
			JdbcUtils.getQuerrRunner().update(
					sql,
					new Object[] { news.getnId(), news.getnTitle(),
							news.getnContent(), news.getNcImg(),
							news.getnAuthor(), news.getnTime(),
							news.getnKeyWord(), news.getNcId() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(NewsItem news) {
		String sql = "UPDATE NewsItem SET NTitle=?,NContent=?,NCImg=?,NAuthor=?,NTime=?,NKeyWord=?,NCId=? WHERE NId=?";
		try {
			JdbcUtils.getQuerrRunner().update(
					sql,
					new Object[] { news.getnTitle(), news.getnContent(),
							news.getNcImg(), news.getnAuthor(),
							news.getnTime(), news.getnKeyWord(),
							news.getNcId(), news.getnId() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<NewsItem> findByTitle(String ntitle) {
		String sql = "SELECT * FROM NewsItem WHERE NTitle LIKE ?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql,
					new BeanListHandler<NewsItem>(NewsItem.class), ntitle);
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
