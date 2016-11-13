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
    
    <title>用户添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage"/>/css/layoutit.css">
    <!-- jquery-validation -->
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/BackgroundPage"/>/css/screen.css" />
    <script src="${pageContext.request.contextPath }/BackgroundPage/jquery/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/BackgroundPage/jquery/jquery.validate.js" type="text/javascript"></script>
      <style type="text/css">


#addColumnform label.error {
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
        $("#addColumnform").validate({
           rules:{
           "ncName":{
            required:true,
            checkName:true
           },
           
           },
           messages:{
        
           "ncName":"请输入正确的栏目名称，长度不低于1不大于20",
           }
        
        });
     
   
     
     //账号的插件验证
       $.validator.addMethod("checkName", function(value, element, params) {
       if(value.length<1||value.length>20){
          return false;
       }else{
          return true;
       }
       
     });
   
     
});
      
  </script>

 <body >
 		<form id="addColumnform" action='<c:url value='/NewsColumnServlet'/>' method="post">
				
					 <legend>添加新闻栏目</legend>
                     
                     <label>栏目名称</label><input type="text"id="ncName" name="ncName"/><br>
                     <br>
                   
                     <input type="hidden" name="method" value=addColumn>
                     <button class="btn" type="submit" >提交</button>
				
			</form>

 </body>
</html>
