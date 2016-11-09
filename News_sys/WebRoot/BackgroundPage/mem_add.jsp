<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mem_add.jsp' starting page</title>
    
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
		<div class="span10">
			<form action='<c:url value='/MemManagerServlet'/>' method="post">
				<fieldset>
					 <legend>添加会员</legend> 
                     <label>用户名</label><input type="text" name="uname"/> 
                     <label>密码</label><input type="text" name="upassword"/>
                     <br>
                     <input type="radio" name="upower" value="管理员">管理员
                     <input type="radio" name="upower" value="会员">会员
                     <br> 
                     <input type="hidden" name="method" value="memAdd">
                     <button class="btn" type="submit">提交</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
 </body>
</html>
