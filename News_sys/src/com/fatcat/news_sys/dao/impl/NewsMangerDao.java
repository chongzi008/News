package com.fatcat.news_sys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fatcat.news_sys.entity.NewsManager;

public class NewsMangerDao implements com.fatcat.news_sys.dao.INewsMangerDao {

	private QueryRunner qr = new QueryRunner();

	// 通过管理员账号查询得到对应的管理员
	@Override
	public NewsManager findByName(NewsManager newsManager) {

		try {
			String sql = "select * from newsmanger where NMangerAccount=?";
			return qr.query(sql,
					new BeanHandler<NewsManager>(NewsManager.class),
					newsManager.getnMangerAccount());
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	// 添加管理员
	@Override
	public void save(NewsManager newsManager) {

		try {
			String sql = "insert into newsmanger(NMangerId,NMangerAccount,NMangerPassword,NMangerAuthority)values(?,?,?,?);";
			qr.update(sql, newsManager.getnMangerId(),
					newsManager.getnMangerAccount(),
					newsManager.getnMangerPassword(),
					newsManager.getnMangerAuthority());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	// 修改管理员信息
	@Override
	public void update(NewsManager newsManager) {
		try {
			String sql = "update newsmanger set NMangerId=?,NMangerAccount=?,NMangerPassword=?,NMangerAuthority=?where NMangerAccount=?;";
			qr.update(sql, newsManager.getnMangerId(),
					newsManager.getnMangerAccount(),
					newsManager.getnMangerPassword(),
					newsManager.getnMangerAuthority(),newsManager.getnMangerAccount());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
  //删除管理员
	@Override
	public void deleteByName(String nMangerAccount) {
    
		try {
			String sql = "delete from newsmanger where NMangerAccount=?;";
			qr.update(sql, nMangerAccount);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
