package com.fatcat.news_sys.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 封装常用的操作
 * 
 * @author FatCat
 * 
 */
public class JdbcUtils {

	// 初始化连接池
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 创建DbUtils常用工具类对象
	 */
	public static QueryRunner getQuerrRunner() {
		return new QueryRunner(dataSource);
	}
	
	/**
	 * 关闭
	 */
	public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close(); // 快速异常捕获 Alt + shift + z
				rs = null; // 建议垃圾回收期回收资源
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null && !con.isClosed()) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
