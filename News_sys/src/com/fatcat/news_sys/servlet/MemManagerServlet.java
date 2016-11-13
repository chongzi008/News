package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fatcat.news_sys.entity.NewsUser;
import com.fatcat.news_sys.entity.PageBean;
import com.fatcat.news_sys.exception.newsUserException;

public class MemManagerServlet extends BaseServlet {
    
	/**
	 * 添加成员
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher addMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	  NewsUser newsUser=new NewsUser();
	  try {
		BeanUtils.populate(newsUser, request.getParameterMap());
		try {
			this.newsUserService.check(newsUser);
		} catch (newsUserException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/BackgroundPage/error.jsp");
		}
		this.newsUserService.save(newsUser);
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
	  
	
		
		return request.getRequestDispatcher("/BackgroundPage/mem_add_success.jsp"); 
	}
	/**
	 * 显示所有的成员+
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher showMems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;

		PageBean pagebean = this.newsUserService.findByAlls(currentPage,
				pageSize);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "all");
		return request.getRequestDispatcher("/BackgroundPage/mem_manager.jsp");
	}
	/**
	 * 查询成员
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher findMems(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;
		String item = request.getParameter("findItem");
		PageBean pagebean = this.newsUserService.findItem(currentPage,
				pageSize, item);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "page");
		request.setAttribute("condition", item);
		return request.getRequestDispatcher("/BackgroundPage/mem_manager.jsp");
	}

	
	/**
	 * 获取当前页码
	 * 
	 * @param request
	 * @return
	 */
	private int getCurrentPage(HttpServletRequest request) {
		String value = request.getParameter("pagecode");
		if ((value == null) || (value.trim().isEmpty())) {
			return 1;
		}
		return Integer.parseInt(value);
	}
	public RequestDispatcher deleteMem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nuAccount = request.getParameter("nuAccount");
		this.newsUserService.deleteByName(nuAccount);
		return showMems(request, response);
	}
	
	public RequestDispatcher eidtMem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsUser newsUser=new NewsUser();
		try {
			BeanUtils.populate(newsUser, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	   this.newsUserService.update(newsUser);
		
		return showMems(request, response);
	}
	
	public void checkAccount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String account = request.getParameter("account");
	
		if(account==null||account.trim()==null){

		}else{
			NewsUser newsUser=new NewsUser();
			newsUser.setNuAccount(account);
			NewsUser newsUser2 = this.newsUserService.findByName(newsUser);
			if(newsUser2!=null){
				response.getWriter().print("用户名已经存在");
			}
		}
	
		
	}
	
}
