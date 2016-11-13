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
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/BackgroundPage"/>/css/screen.css" />
    <script src="${pageContext.request.contextPath }/BackgroundPage/jquery/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/BackgroundPage/jquery/jquery.validate.js" type="text/javascript"></script>
      <style type="text/css">


#mangerUpdateForm label.error {
	margin-left: 10px;
	width: auto;
	font-style:"Courier New";
	font-size:18px;
	color:red;
	display: inline;
}

</style>
  </head>
  <script type="text/javascript">
     $(function(){
        $("#mangerUpdateForm").validate({
           rules:{
           "nMangerAccount":{
           required:true,
           checkAccount:true
           },
           "nMangerPassword":{
            required:true,
            checkPassword:true
           },
           "nMangerAuthority":"required",
           
           },
           messages:{
        
           "nMangerAuthority":"请选择您的权限级别",
           "nMangerPassword":"请输入正确的密码，长度不低于6不大于20,并且只由数字以及字符和下划线组成!",
           "nMangerAccount":"请输入正确的用户名，长度不低于6不大于15,并且只由数字以及字符和下划线组成!"
           }
        
        });
     
      //value元素的值 element 元素本身 param 就是那个true 或者false那个地填的值
     $.validator.addMethod("checkPassword", function(value, element, params) {
       var reg = /^\w{6,20}$/; 
       if(reg.test(value)==false){
          return false;
       }else{
          return true;
       }
       
     });
     
     //账号的插件验证
       $.validator.addMethod("checkAccount", function(value, element, params) {
       var reg = /^\w{6,15}$/; 
       if(reg.test(value)==false){
          return false;
       }else{
          return true;
       }
       
     });
   
     
});
      
  </script>
  <body>
  
  <div class="container-fluid">
	<div class="row-fluid">
		<div class="span10">
			<form id="mangerUpdateForm" action="${pageContext.request.contextPath}/MangerServlet" method="post">
					 <legend>管理员信息编辑</legend>
					 
					 <input type="hidden" name="nMangerId" value="${param.nMangerId}"/> 
                     <label>管理员账号</label><input type="text"id="nMangerAccount" name="nMangerAccount"/><span id="err" style="font-size:18;color: red"></span>
                     <label>管理员密码</label><input type="text"id="nMangerPassword" name="nMangerPassword"/><br>
                     <input type="radio" name="nMangerAuthority" value="0">高级
                     <input type="radio" name="nMangerAuthority" value="1">一般
                      <label  style="display: none" for="nMangerAuthority" class="error">请选择您的权限级别</label>	
                     <br>
                      <input type="hidden" name="method" value="editManger">
                     <button class="btn" type="submit" >提交</button>
			</form>
		</div>
	</div>
</div>

  </body>
</html>
