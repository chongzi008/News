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


#columnUpdateForm label.error {
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
        $("#columnUpdateForm").validate({
           rules:{
           "ncName":{
           required:true,
           checkAccount:true}
           },
           messages:{
           "ncName":"请输入正确的栏目名称，长度不低于1不大于20"
           }
        
        });
     
  
     
     //账号的插件验证
       $.validator.addMethod("checkAccount", function(value, element, params) {
       
       if(value.length<1||value.length>20){
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
			<form id="columnUpdateForm" action="${pageContext.request.contextPath}/NewsColumnServlet" method="post">
					 <legend>栏目信息编辑</legend>
					 
					 <input type="hidden" name="ncId" value="${param.ncId}"/> 
                     <label>栏目名称</label><input type="text"id="ncName" name="ncName"/><span id="err" style="font-size:18;color: red"></span>
                     <br>
                      <input type="hidden" name="method" value="editColumns">
                     <button class="btn" type="submit" >提交</button>
			</form>
		</div>
	</div>
</div>

  </body>
</html>
