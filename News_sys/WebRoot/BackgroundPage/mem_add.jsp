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

#memform label.error {
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
        $("#memform").validate({
           rules:{
           "nuAccount":{
           required:true,
           checkAccount:true
           },
           "nuPassword":{
            required:true,
            checkPassword:true
           },
           "nuGender":"required",
           
           },
           messages:{
        
           "nuGender":"请选择您的性别",
           "nuPassword":"请输入正确的密码，长度不低于6不大于15,并且只由数字以及字符和下划线组成!",
           "nuAccount":"请输入正确的用户名，长度不低于6不大于20,并且只由数字以及字符和下划线组成!"
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
     //对账号进行验证
     $("#nuAccount").blur(function(){
         var json={
         method:"checkAccount",
         account:$("#nuAccount").val()
                  };
        $.post("<c:url value='/MemManagerServlet'/>",json,function(data,textStatus){
            $("#err").text(data);
        
        });
     });
   
     
});
 </script>

 <body >
 		<form id="memform" action='<c:url value='/MemManagerServlet'/>' method="post">
				
					 <legend>添加用户</legend>
                     
                     <label>用户账号</label><input type="text"id="nuAccount" name="nuAccount"/><span id="err" style="font-size:18;color: red"></span>
                     
                      
                     <label>用户密码</label><input type="text"id="nuPassword" name="nuPassword"/><br>
                     <input type="radio" name="nuGender" value="男">男
                     <input type="radio" name="nuGender" value="女">女
                      <label  style="display: none" for="nuGender" class="error">请选择您的性别</label>	
                     <br>
                   
                     <input type="hidden" name="method" value="addMem">
                     <button class="btn" type="submit" >提交</button>
				
			</form>

 </body>
</html>
