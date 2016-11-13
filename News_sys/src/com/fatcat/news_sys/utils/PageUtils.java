package com.fatcat.news_sys.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;

/**
 * 分页工具
 * 
 * @author ChongZi007
 * 
 */
public class PageUtils {
	
	
	public static <T> PageBean findByAlls(int currentPage, int pageSize,
			String TableName, Class<T> beanNameClass) {
		try {
			PageBean pagebean = new PageBean();
			pagebean.setCurrentPage(currentPage);
			pagebean.setPageSize(pageSize);

			String sql = "select count(*) from " + TableName + ";";
			QueryRunner qr = JdbcUtils.getQuerrRunner();
			Number num = (Number) qr.query(sql, new ScalarHandler());
			int totalRecord = num.intValue();
			pagebean.setTotalRecord(totalRecord);

			sql = "select * from "+TableName+" limit ?,?";
			List PagebeanList = (List) qr.query(
					sql,
					new BeanListHandler<T>(beanNameClass),
					new Object[] {
							Integer.valueOf((currentPage - 1) * pageSize),
							Integer.valueOf(pageSize) });

			pagebean.setPageBeanList(PagebeanList);

			return pagebean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询并且分页
	 * @param <T>
	 * @param currentPage
	 * @param pageSize
	 * @param item
	 * @return
	 */
	public static <T> PageBean findItem(int currentPage, int pageSize, String item,String tableName,String filedName,Class<T>beanName) {

		try {

			PageBean pagebean = new PageBean();
			pagebean.setCurrentPage(currentPage);
			pagebean.setPageSize(pageSize);

			String sql = "SELECT * FROM "+ tableName+" WHERE "+filedName+" LIKE ? ;";
			List<T> list = JdbcUtils.getQuerrRunner().query(sql,
					new BeanListHandler<T>(beanName),
					"%" + item + "%");
			int totalRecord = list.size();

			// 设置总页数
			pagebean.setTotalRecord(totalRecord);

			sql = "SELECT * FROM "+ tableName+" WHERE "+ filedName+" LIKE ? limit ?,?;";
			List<T> PagebeanList = (List<T>) JdbcUtils
					.getQuerrRunner().query(
							sql,
							new BeanListHandler<T>(beanName),
							new Object[] {
									"%" + item + "%",
									Integer.valueOf((currentPage - 1)
											* pageSize),
									Integer.valueOf(pageSize) });

			pagebean.setPageBeanList(PagebeanList);

			return pagebean;

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

}
