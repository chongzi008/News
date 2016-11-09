package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fatcat.news_sys.entity.NewsUser;

public class MemManagerServlet extends BaseServlet {
    
	
	public RequestDispatcher memAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String upower = request.getParameter("upower");
		NewsUser newsUser=new NewsUser();
		try {
			BeanUtils.populate(newsUser, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		newsUserService.save(newsUser);
		return request.getRequestDispatcher("/BackgroundPage/mem_add_success.jsp"); 
	}
}
