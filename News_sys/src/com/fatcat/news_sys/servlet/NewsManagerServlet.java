package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fatcat.news_sys.entity.NewsItem;
import com.fatcat.news_sys.entity.PageBean;
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
	public RequestDispatcher findAllNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;

		PageBean pagebean = this.newsItemService.findByAlls(currentPage, pageSize);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));

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
  
	public RequestDispatcher Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsItem newsitembean = new NewsItem();
		int nid = Integer.parseInt(request.getParameter("nid"));
		String ntitle = request.getParameter("ntitle");
		String nauthor = request.getParameter("nauthor");
		String ncontent = request.getParameter("ncontent");
		String ntime = request.getParameter("ntime");
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(ntime);
		} catch (ParseException e) {
			throw new RuntimeException();
		}

		newsitembean.setnId(nid);
		newsitembean.setnTime(date);
		newsitembean.setnTitle(ntitle);
		newsitembean.setnAuthor(nauthor);
		newsitembean.setnContent(ncontent);
		newsItemService.update(newsitembean);
		return request.getRequestDispatcher("/BackgroundPage/news_update_success.jsp");
	}

	public RequestDispatcher newDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nid = Integer.parseInt(request.getParameter("nid"));
		
		newsItemService.deleteBynId(nid);

		return request.getRequestDispatcher("/BackgroundPage/news_delete_success.jsp");
	}

	public RequestDispatcher newsshow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 4;

		PageBean pagebean = this.newsItemService.findByAlls(currentPage, pageSize);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("moviePage", pagebean);
		request.setAttribute("size", Integer.valueOf(size));

		return request.getRequestDispatcher("/movie.jsp");
	}
	
	public RequestDispatcher findnews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = getCurrentPage(request);
		int pageSize = 10;
		String item = request.getParameter("findItem");
		PageBean pagebean = this.newsItemService.findItem(currentPage, pageSize,item);
		int size = pagebean.getPageBeanList().size();
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("size", Integer.valueOf(size));

		
		
		
		return request.getRequestDispatcher("/BackgroundPage/news_manager.jsp");
	}

}