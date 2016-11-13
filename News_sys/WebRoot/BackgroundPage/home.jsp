<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/layoutit.css">
  </head>
<body >
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
			<ul class="nav nav-list">
				<li class="nav-header">
					网站栏目
				</li>
				<li >
					<a href="<c:url value="/BackgroundPage"/>/home.jsp" target="homeframe" >首页</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/NewsManagerServlet?method=findAllNews" target="homeframe">新闻管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/BackgroundPage/news_add.jsp" target="homeframe">添加新闻</a>
				</li>
				<li>
					<a href="<c:url value="/BackgroundPage"/>/column_add.jsp" target="homeframe">添加新闻栏目</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/NewsColumnServlet?method=showColumns" target="homeframe">新闻栏目管理</a>
				</li>
				
				<li class="nav-header">
					成员管理
				</li>
				<li>
					<a href="<c:url value="/BackgroundPage"/>/mem_add.jsp" target="homeframe">添加用户</a>
				</li>
				<li>
					<a href="<c:url value="/BackgroundPage"/>/manger_add.jsp" target="homeframe">添加管理员</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/MemManagerServlet?method=showMems" target="homeframe">用户管理</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/MangerServlet?method=showMangers" target="homeframe">管理员管理</a>
				</li>
                <li class="divider">&nbsp;</li>
				<li><a href="javascript:void(0)" onclick="logout();">
                退出登录</a>
                </li>
				
			</ul>
		</div>
		
	</div>
</div>
</body>
</html>
