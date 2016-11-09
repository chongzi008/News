<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'basehome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <frameset rows="10%,*">
           <frame src="${pageContext.request.contextPath }/BackgroundPage/top.jsp" name="top" noresize="noresize" frameborder="0"  scrolling="no" marginwidth="0" marginheight="0" />
      <frameset cols="15%,*">
           <frame src="<c:url value="/BackgroundPage"/>/home.jsp" name="left" noresize="noresize" frameborder="0" scrolling="no" marginwidth="0" marginheight="0"/>
           <frame src="<c:url value="/BackgroundPage"/>/main.jsp" name="homeframe" frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" />
      </frameset>
  </frameset>
  <noframes></noframes>
</html>
