<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.fatcat.news_sys.entity.NewsItem" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/layoutit.css">
  </head>
  
  <body>
  
  <div class="container-fluid">
	<div class="row-fluid">
		<div class="span10">
			<form action="${pageContext.request.contextPath}/NewsManagerServlet?method=Update" method="post">
				<fieldset>
					 <legend>新闻编辑</legend> 
					 <label>新闻ID</label><input type="text" />
                     <label>新闻标题</label><input type="text" /> 
                     <label>新闻作者</label><input type="text" />
                     <label>新闻时间</label><input type="text" />
                     
                     <label>编辑新闻内容</label><textarea rows="10" ></textarea>
                     <label class="checkbox"></label>
                     
                     <button class="btn" type="submit">提交</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>

  </body>
</html>
