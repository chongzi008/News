package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fatcat.news_sys.entity.NewsColumn;
import com.fatcat.news_sys.entity.NewsManager;
import com.fatcat.news_sys.entity.PageBean;

public class NewsColumnServlet extends BaseServlet {
	/**
	 * 显示所有栏目
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher showColumns(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		PageBean pageBean = this.newsColumnService.findByAlls(currentPage, 10);
		int size = pageBean.getPageBeanList().size();
		request.setAttribute("pagebean", pageBean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "all");
		return request.getRequestDispatcher("/BackgroundPage/news_column.jsp");

	}
     
	public RequestDispatcher findColumns(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
       
		int currentPage = getCurrentPage(request);
		int pageSize = 10;
		String item = request.getParameter("findItem");
		PageBean pagebean = this.newsColumnService.findItem(currentPage,
				pageSize, item);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "page");
		request.setAttribute("condition", item);
		return request.getRequestDispatcher("/BackgroundPage/news_column.jsp");

	}
	/**
	 * 添加栏目
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher addColumn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsColumn newsColumn=new NewsColumn();
		try {
			BeanUtils.populate(newsColumn, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.newsColumnService.save(newsColumn);
		 
		return showColumns(request, response);

	}

	/**
	 * 编辑栏目
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher editColumns(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	     NewsColumn newsColumn=new NewsColumn();
		try {
			BeanUtils.populate(newsColumn, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 得到要修改的信息 封装到newsMange 的bean 对象中
		this.newsColumnService.update(newsColumn);
		return showColumns(request, response);
	}

	/**
	 * 删除栏目
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */

	public RequestDispatcher deleteColumns(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String ncId = request.getParameter("ncId");
		this.newsColumnService.delete(Integer.valueOf(ncId));

		return request
				.getRequestDispatcher("/BackgroundPage/column_delete_success.jsp");

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
}
