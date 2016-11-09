<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>æ æ é¢ææ¡£</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap-combined.min.css">
<link rel="stylesheet" type="text/css" href="css/layoutit.css">
</head>
<body>
<form>

				<fieldset>
				
					  <legend>评论管理</legend>  
					 <input class="input-medium search-query" type="text" /> <button class="btn" type="submit">查找</button>
                     <label>评论1 用户：</label><textarea rows="10"></textarea><button class="btn" type="submit">删除</button>
					 <label>评论2 用户：</label><textarea rows="10"></textarea><button class="btn" type="submit">删除</button>
					 <label>评论3 用户：</label><textarea rows="10"></textarea><button class="btn" type="submit">删除</button>
					 <label>评论4 用户：</label><textarea rows="10"></textarea><button class="btn" type="submit">删除</button>
                     <label class="checkbox">
                     
                     <button class="btn" type="submit">提交</button>
				</fieldset>
			</form>

</body>
</html>
