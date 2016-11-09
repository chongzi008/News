package com.fatcat.news_sys.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fatcat.news_sys.factory.BeanFactory;
import com.fatcat.news_sys.service.INewsColumnService;
import com.fatcat.news_sys.service.INewsItemService;
import com.fatcat.news_sys.service.INewsMangerService;
import com.fatcat.news_sys.service.INewsUserService;
import com.fatcat.news_sys.utils.WebUtils;

/**
 * ��Ŀ��ͨ�õ�Servlet��ϣ�����е�servlet���̳д���
 * 
 * @author FatCat
 * 
 */
public abstract class BaseServlet extends HttpServlet {
	// Service

	protected INewsColumnService newsColumnService = BeanFactory.getInstance(
			"newsColumnService", INewsColumnService.class);
	protected INewsUserService newsUserService = BeanFactory.getInstance(
			"newsUserService", INewsUserService.class);
	protected INewsMangerService newsMangerService = BeanFactory.getInstance(
			"newsMangerService", INewsMangerService.class);
	protected INewsItemService newsItemService = BeanFactory.getInstance(
			"newsItemService", INewsItemService.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// (������ת����Դ) ��������ֵ
		Object returnValue = null;

		// ��ȡ��������; ��Լ�� > �׳ɣ� �������͵�ֵ�������Ӧservlet�еķ������ơ�
		String methodName = request.getParameter("method"); // listTable

		try {
			// 1. ��ȡ��ǰ��������ֽ���
			Class clazz = this.getClass();
			// 2. ��ȡ��ǰִ�еķ�����Method����
			Method method = clazz.getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			// 3. ִ�з���
			returnValue = method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "/error/error.jsp";
		}

		// ��ת
		WebUtils.goTo(request, response, returnValue);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
