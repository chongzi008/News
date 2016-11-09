package com.fatcat.news_sys.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.fatcat.news_sys.dao.INewsCommentDao;
import com.fatcat.news_sys.entity.Comment;
import com.fatcat.news_sys.utils.JdbcUtils;

public class NewsCommentDao implements INewsCommentDao {

	@Override
	public List<Comment> findCommentById(int id) {
		String sql = "SELECT * FROM NewsComment WHERE NCId=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Comment>(Comment.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Comment> findCommentAll() {
		String sql = "SELECT * FROM NewsComment";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Comment> findCommentByNewsId(int id) {
		String sql = "SELECT * FROM NewsComment WHERE NId=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Comment>(Comment.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Comment> findCommentByUserId(int id) {
		String sql = "SELECT * FROM NewsComment WHERE NUId=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Comment>(Comment.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Comment comment) {
		String sql = "INSERT INTO NewsComment(NCId,NCTime,NCContent,NId,NUId) VALUES(?,?,?,?)";
		try {
			JdbcUtils.getQuerrRunner().update(sql, new Object[] { comment.getNcId(), comment.getNcTime(),
					comment.getNcContent(), comment.getnId(), comment.getNuId() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void update(Comment comment) {
		String sql = "UPDATE NewsComment SET NCTime=?, NCContent=?,NId=?,NUId=? WHERE NCId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, new Object[] { comment.getNcTime(), comment.getNcContent(),
					comment.getNcId(), comment.getNuId(), Integer.valueOf(comment.getNcId()) });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from NewsComment where NCId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, Integer.valueOf(id));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteByNewsId(int id) {
		String sql = "delete from NewsComment where NUId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, Integer.valueOf(id));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteByUserId(int id) {
		String sql = "delete from NewsComment where NId=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, Integer.valueOf(id));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
