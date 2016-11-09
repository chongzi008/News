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
	//1. Ӳ���뷽ʽ��ʹ��C3P0���ӳع�������
	public void testCode() throws Exception {
		// �������ӳغ��Ĺ�����
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// �������Ӳ�����url���������û����롢��ʼ�����������������
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/new_sys");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		
		// ---> �����ӳض����У���ȡ���Ӷ���
		Connection con = dataSource.getConnection();
		// ִ�и���
		con.prepareStatement("delete from newsuser where uid=2").executeUpdate();
		// �ر�
		con.close();
	}

	@Test
	public void testXML() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		// ��ȡ����
		Connection con = dataSource.getConnection();
		// ִ�и���
		con.prepareStatement("delete from newsuser where uid=2")
				.executeUpdate();
		// �ر�
		con.close();

	}

	@Test
	void testdelete() throws SQLException {
		
		String sql = "delete from newsuser where uname=?";
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// ��ȡ����
		Connection con = dataSource.getConnection();
		// ִ�и���
		con.prepareStatement("delete from newsuser where uname='uname1'")
				.executeUpdate();
		// �ر�
		con.close();

	}

}
