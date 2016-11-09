package com.fatcat.news_sys.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.utils.JdbcUtils;

public class test {
	@Test
	public void tes() {
		System.out.println("+++++");
		PageBean pageBean = findItem(1, 10, "谷歌");
		List<NewsItem> beanList = pageBean.getPageBeanList();
		for (NewsItem news : beanList) {
			System.out.println("++++"+news.getnContent());
		}
       System.out.println(pageBean.getTotalPage()+"++++");
	}

	public PageBean findItem(int currentPage, int pageSize, String item) {

		try {

			PageBean pagebean = new PageBean();
			pagebean.setCurrentPage(currentPage);
			pagebean.setPageSize(pageSize);

			String sql = "SELECT * FROM news WHERE ntitle LIKE ? ";
			List<NewsItem> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<NewsItem>(NewsItem.class), "%"+item+"%");
			int totalRecord = list.size();

			// 设置总页数
			pagebean.setTotalRecord(totalRecord);

			sql = "SELECT * FROM news WHERE ntitle LIKE ? limit ?,?";
			List PagebeanList = (List) JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<NewsItem>(NewsItem.class),
					new Object[] { "%"+item+"%", Integer.valueOf((currentPage - 1) * pageSize), Integer.valueOf(pageSize) });

			pagebean.setPageBeanList(PagebeanList);

			return pagebean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
