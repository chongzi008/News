<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <center><h3>新闻信息管理与发布系统前端</h3></center>
  <center>
  	<a href="${pageContext.request.contextPath }/Login.jsp">[登录]</a>
  	<a href="${pageContext.request.contextPath }/Register.jsp">[注册]</a>
  	<a href="${pageContext.request.contextPath }/NewsManagerServlet?method=newsshow">你要显示的新闻</a>
  	<c:forEach var="news" items="${requestScope.list}">
  	<p>新闻标题:${news.ntitle}</p>
  	<pre>新闻内容:${news.ncontent}</pre>
  	<h3>新闻作者${news.nauthor}</h3>
  	</c:forEach>
  	
  </center>
  
  
  
  
  
  
  
  
  
  
    

  </body>
</html>
