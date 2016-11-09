package com.fatcat.news_sys.exception;
/**
 * 姓名重复自定义异常类
 * @author FatCat
 *
 */
public class NameRepeatException extends Exception {

	public NameRepeatException(String msg){
		super(msg);
	}
}
