package com.fatcat.news_sys.dao;

import java.util.List;

import com.fatcat.news_sys.entity.Comment;

public interface INewsCommentDao {
	
	/**
	 * 通过id查找Comment
	 * @return
	 */
	List<Comment> findCommentById(int id);
	
	/**
	 * 查找全部Comment
	 * @return
	 */
	List<Comment> findCommentAll();
	
	/**
	 * 通过NewsId查找Comment
	 * @return
	 */
	List<Comment> findCommentByNewsId(int id);
	
	/**
	 * 通过UserId查找Comment
	 * @return
	 */
	List<Comment> findCommentByUserId(int id);
	
	/**
	 * 添加评论
	 * @param comment
	 */
	void save(Comment comment);
	
	/**
	 * 修改评论
	 * @param comment
	 */
	void update(Comment comment);
	
	/**
	 * 根据评论id删除评论
	 * @param id
	 */
	void deleteById(int id);
	
	/**
	 * 根据新闻id删除评论
	 * @param id
	 */
	void deleteByNewsId(int id);
	
	/**
	 * 根据用户id删除评论
	 * @param id
	 */
	void deleteByUserId(int id);
	
}
