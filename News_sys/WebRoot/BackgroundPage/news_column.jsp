<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap-combined.min.css">
<link rel="stylesheet" type="text/css" href="css/layoutit.css">
</head>

<body>
<div class="container-fluid">
	<div class="row-fluid">
		
		<div class="span10">
			<div class="page-header">
				<h1>
					新闻栏目管理
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
							新闻栏目
						</th>
						<th>
							提交者
						</th>
						<th>
							新闻栏目发布时间
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
							天气
						</td>
						<td>
							Default
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						
						<td>
							军事
						</td>
						<td>
							Approved
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						
						<td>
							哈哈
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						
						<td>
							生活
						</td>
						<td>
							Pending
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						
						<td>
							啊啊
						</td>
						<td>
							Call in to confirm
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="error">
						<td>
							5
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="success">
						<td>
							6
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="warning">
						<td>
							7
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="info">
						<td>
							8
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="error">
						<td>
							9
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
						</td>
					</tr>
                    <tr class="warning">
						<td>
							10
						</td>
						
						<td>
							新闻
						</td>
						<td>
							Declined
						</td>
                        <td>
							Default
						</td>
                        <td>
							<a href="新闻编辑.html">编辑 <a href="#">删除
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
