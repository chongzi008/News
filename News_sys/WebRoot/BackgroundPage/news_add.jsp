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
  </head>
  
<style type="text/css">

   #newsForm label.error {
	margin-left: 10px;
	width: auto;
	font-style:"Courier New";
	font-size:18px;
	color:red;
	display: inline;
}

</style>
    <script type="text/javascript">

$(function(){
     function getDate()
           {
                var today = new Date(); 
                var date; 
                date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate() + " " + today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();  
                return date;
                             };
 document.getElementById("time").value = getDate();
        $("#newsForm").validate({
           rules:{
           "nAuthor":{
           required:true,
           checkAccount:true
           } ,
           "nTitle":{
            required:true,
            checkTitle:true
           },
           "ncImg":{
            required:true,
           },
           "time":"required",
           "nKeyWord":{
           required:true,
           checkKeyWord:true
           },
           "ncId":{
           required:true,
           checkcId:true
           },
           "nContent":{
           required:true,
           checkContent:true
           } 
           
           },
           messages:{
           "nTitle":"请输入正确的标题，长度不低于1不大于20",
           "nAuthor":"请输入正确的作者名，长度不低于1不大于10",
           "ncImg":"路径不能为空",
           "time":"不能为空",
           "nKeyWord":"长度不能小于1或者大于10",
           "ncId":"请输入正确的格式,只能输纯数字组成",
           "nContent":"长度不能小于1或者大于2000"
           }
        
        });
     
      //value元素的值 element 元素本身 param 就是那个true 或者false那个地填的值
     $.validator.addMethod("checkTitle", function(value, element, params) {
      
       if(value.length<1||value.length>20){
          return false;
       }else{
          return true;
       }
       
     });
     
     //账号的插件验证
       $.validator.addMethod("checkAccount", function(value, element, params) {
      
       if(value.length<1||value.length>10){
          return false;
       }else{
          return true;
       }
       
     });
     
         $.validator.addMethod("checkKeyWord", function(value, element, params) {
      
       if(value.length<1||value.length>10){
          return false;
       }else{
          return true;
       }
       
     });
     
       $.validator.addMethod("checkcId", function(value, element, params) {
     
       if(value.length<1||value.length>2000){
          return false;
       }else{
          return true;
       }
       
     });
     
       $.validator.addMethod("checkContent", function(value, element, params) {
       var regax=/^\d+$/;
       if(regax.test(value)==false){
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
			<form id ="newsForm" action="${pageContext.request.contextPath}/NewsManagerServlet?method=addNews" method="post">
				
					 <legend>新闻编辑</legend> 
					 <input type="hidden" name="nId"/>
                     <label>新闻标题</label><input type="text" id="nTitle" name="nTitle" /> 
                     <label>新闻图片路径</label><input type="text" id="ncImg" name="ncImg" /> 
                     <label>新闻作者</label><input type="text" id="nAuthor" name="nAuthor" />
                     <label>新闻发布时间</label><input type="text" id="time" name="time"/>
                     <label>新闻关键词</label><input type="text" id="nKeyWord" name="nKeyWord"/>
                     <label>新闻栏目id</label><input type="text" id="ncId" name="ncId"/>
                     <label>编辑新闻内容</label><textarea rows="10" id="nContent" name="nContent"></textarea><br>
                     <button class="btn" type="submit">提交</button>
				
			</form>
		</div>
	</div>
</div>

  </body>
</html>
