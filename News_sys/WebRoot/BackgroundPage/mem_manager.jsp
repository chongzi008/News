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
    
    <title>My JSP 'mem_manager.jsp' starting page</title>
    
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
			<div class="page-header">
				<h1>
					会员管理
				</h1>
			</div>
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button class="btn" type="submit">查找</button>
			</form>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							会员名
						</th>
						<th>
							注册时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							0
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑 </a><a href="#">删除</a>
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
                    <tr class="success">
						<td>
							5
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑 </a><a href="#">删除</a>
						</td>
					</tr>
                    <tr class="info">
						<td>
							6
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
                    <tr class="error">
						<td>
							7
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
                    <tr class="warning">
						<td>
							8
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
                    <tr class="success">
						<td>
							9
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
                    <tr class="info">
						<td>
							10
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<a href="会员编辑.html">编辑</a> <a href="#">删除</a>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
  </body>
  
</html>
