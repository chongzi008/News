package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fatcat.news_sys.entity.NewsManager;
import com.fatcat.news_sys.entity.PageBean;

public class MangerServlet extends BaseServlet {
	/**
	 * 显示所有的管理员+
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher showMangers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int currentPage = getCurrentPage(request);
		PageBean pageBean = newsMangerService.findByAlls(currentPage, 10);
		int size = pageBean.getPageBeanList().size();
		request.setAttribute("pagebean", pageBean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "all");
		return request.getRequestDispatcher("/BackgroundPage/manager_show.jsp");

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

	public RequestDispatcher findMangers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;
		String item = request.getParameter("findItem");
		PageBean pagebean = this.newsMangerService.findItem(currentPage,
				pageSize, item);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "page");
		request.setAttribute("condition", item);
		return request.getRequestDispatcher("/BackgroundPage/manager_show.jsp");
	}

	/**
	 * 删除管理员
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher deleteManger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 得到要删除对象的nMangerAccount
		String nMangerAccount = request.getParameter("nMangerAccount");
		this.newsMangerService.deleteByName(nMangerAccount);

		return request
				.getRequestDispatcher("/BackgroundPage/manger_delete_success.jsp");
	}

	public RequestDispatcher editManger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsManager newsManager = new NewsManager();
		try {
			BeanUtils.populate(newsManager, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 得到要修改的信息 封装到newsMange 的bean 对象中
		this.newsMangerService.update(newsManager);
		return showMangers(request, response);

	}
	
	public RequestDispatcher addManger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsManager manager=new NewsManager();
		try {
			BeanUtils.populate(manager, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.newsMangerService.save(manager);
		
		return request.getRequestDispatcher("/BackgroundPage/manger_add_success.jsp");
	}

}
