package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
/**
 * 新闻的servlet
 * @author ChongZi007
 *
 */
public class NewsManagerServlet extends BaseServlet {
	/**
	 * 查询所有的新闻 并且显示到后台新闻管理页面上
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher findAllNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;

		PageBean pagebean = this.newsItemService.findByAlls(currentPage,
				pageSize);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "all");
		return request.getRequestDispatcher("/BackgroundPage/news_manager.jsp");
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

	/**
	 * 修改新闻
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher newsUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsItem newsitembean = new NewsItem();
		try {
			String time = request.getParameter("time");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			BeanUtils.populate(newsitembean, request.getParameterMap());
			newsitembean.setnTime(date);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		newsItemService.update(newsitembean);

		return request
				.getRequestDispatcher("/BackgroundPage/news_update_success.jsp");
	}

	/**
	 * 删除新闻
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher newDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nid = Integer.parseInt(request.getParameter("nId"));
         
		newsItemService.deleteBynId(nid);

		return request
				.getRequestDispatcher("/BackgroundPage/news_delete_success.jsp");
	}

	/**
	 * 根据标题查询新闻并显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public RequestDispatcher findnews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = getCurrentPage(request);

		int pageSize = 10;
		String item = request.getParameter("findItem");
		PageBean pagebean = this.newsItemService.findItem(currentPage,
				pageSize, item);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));
		request.setAttribute("flag", "page");
		request.setAttribute("condition", item);
		return request.getRequestDispatcher("/BackgroundPage/news_manager.jsp");
	}
	
	public RequestDispatcher addNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsItem item=new NewsItem();
		String time = request.getParameter("time");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			BeanUtils.populate(item, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		item.setnTime(date);
		this.newsItemService.save(item);
		 
		return request.getRequestDispatcher("/BackgroundPage/news_add_success.jsp");
	}

}