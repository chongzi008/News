package com.fatcat.news_sys.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.utils.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import junit.framework.TestCase;

public class MyTestCase extends TestCase {

	private Connection conn;

	ComboPooledDataSource dataSource;
	
	
	@Test
	//1. 硬编码方式，使用C3P0连接池管理连接
	public void testCode() throws Exception {
		// 创建连接池核心工具类
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/new_sys");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		
		// ---> 从连接池对象中，获取连接对象
		Connection con = dataSource.getConnection();
		// 执行更新
		con.prepareStatement("delete from newsuser where uid=2").executeUpdate();
		// 关闭
		con.close();
	}

	@Test
	public void testXML() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		// 获取连接
		Connection con = dataSource.getConnection();
		// 执行更新
		con.prepareStatement("delete from newsuser where uid=2")
				.executeUpdate();
		// 关闭
		con.close();

	}

	@Test
	void testdelete() throws SQLException {
		
		String sql = "delete from newsuser where uname=?";
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// 获取连接
		Connection con = dataSource.getConnection();
		// 执行更新
		con.prepareStatement("delete from newsuser where uname='uname1'")
				.executeUpdate();
		// 关闭
		con.close();

	}

}
