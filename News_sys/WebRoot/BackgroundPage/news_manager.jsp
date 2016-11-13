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
    
    <title>My JSP 'news_manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage/"/>css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/BackgroundPage/"/>css/layoutit.css">

  </head>
  
  <body>
    <div class="container-fluid">
	<div class="row-fluid">
		<div class="span10">
			<div class="page-header">
				<h1>
					新闻管理
				</h1>
			</div>
			<form class="form-search" action="${pageContext.request.contextPath}/NewsManagerServlet" method="post" >
				<input class="input-medium search-query" type="text" name="findItem" />
				<input type="hidden" name="method" value="findnews">
				 <button class="btn" type="submit">查找</button>
			</form>
			
			<c:choose>
			  <c:when test="${ pagebean.pageBeanList[0]eq NULL }">
			    <h1 align="center" style="color: red">不好意思，你查询的结果，不存在</h1>
			  </c:when>
			  <c:otherwise>
			  
	 <c:choose>
			<c:when test="${requestScope.flag == 'all'}">
			<c:set var="m" value="findAllNews" ></c:set>
			</c:when>
			<c:otherwise>
			<c:set var="m" value="findnews"></c:set>
			</c:otherwise> 
	 </c:choose>
			
			<table style="table-layout:fixed;" class="table">
				<thead>
					<tr>
						<th>
						   新闻ID
						</th>
						<th>
							标题
						</th>
                        <th>
							内容
						</th>
						 <th>
							图片
						</th>
						<th>
							作者
						</th>
						<th>
							发布时间
						</th>
						<th>
							关键词
						</th>
						<th>
							栏目id
						</th>
                        <th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach var="bean" items="${pagebean.pageBeanList}" varStatus="vs">
                                                    
                          <tr class="error">
                          <td>${bean.nId}</td>
                          <td>${bean.nTitle}</td>
                          <td width="200px" style="text-overflow:ellipsis; white-space:nowrap; overflow:hidden; ">${bean.nContent }</td>
                          <td>${bean.ncImg}</td>
                          <td>${bean.nAuthor}</td>
                          <td>${bean.nTime}</td>
                          <td>${bean.nKeyWord}</td>
                          <td>${bean.ncId}</td>
                          <c:set var="vs.index" value="${bean}" scope="session"></c:set>
                          <td><a href="${pageContext.request.contextPath}/BackgroundPage/news_update.jsp?nId=${bean.nId}" onclick ="return(confirm('确定编辑吗？'));">编辑</a> <a href='<c:url value="/NewsManagerServlet"><c:param name='method' value='newDelete'/> <c:param name='nId' value='${bean.nId}'/></c:url>' onclick ="return(confirm('确定删除吗？'));">删除</a> <a href="${pageContext.request.contextPath}/BackgroundPage/remark.jsp">评论</a>  </td>
                          </tr>
                      </c:forEach>
         
				</tbody>
			</table>
			<div class="pagination">
				<ul>
				    <li>
						<label>第${pagebean.currentPage}页/共${pagebean.totalPage}页</label>
					</li>
				
					<li>
						 <a href="${pageContext.request.contextPath}/NewsManagerServlet?method=${m}&findItem=${condition}&pagecode=1">首页</a>
					</li>
					
						 <c:if test="${pagebean.currentPage>1}"> 
					<li>	                                             
 <a href="${pageContext.request.contextPath}/NewsManagerServlet?method=${m}&findItem=${condition}&pagecode=${pagebean.currentPage-1}">上一页</a>
                    </li>
                        </c:if> 
                        		
					<!-- 通过计算得到当前的页码表开始和结束数字 -->
 <c:choose>
   <c:when test="${pagebean.totalPage<=10}">
     <c:set var="begin" value="1"></c:set>
     <c:set var="end" value="${pagebean.totalPage}"></c:set>
   </c:when>
   <c:otherwise>
    <c:set var="begin" value="${pagebean.currentPage-5}"></c:set>
    <c:set var="end" value="${pagebean.currentPage+4}"></c:set>
   <!--注意头溢出  -->
   <c:if test="${begin <1}">
   <c:set var="begin" value="${1}"></c:set>
    <c:set var="end" value="${10}"></c:set>
   </c:if>
   <!--尾溢出也要处理  -->
   <c:if test="${end>pagebean.totalPage}">
    <c:set var="end" value="${pagebean.totalPage}"></c:set>
    <c:set var="begin" value="${pagebean.totalPage-9}"></c:set>
   </c:if>
   </c:otherwise>
 </c:choose>
<!--这里根据计算的页码数开始插入-->
<c:forEach var="i" begin="${begin}" end="${end}">

  <li>
  <a href="${pageContext.request.contextPath}/NewsManagerServlet?method=${m}&findItem=${condition}&pagecode=${i}">[${i}]</a>
  </li>   
 

 </c:forEach>					
					
						<c:if test="${pagebean.currentPage<pagebean.totalPage}">
						   <li>
 <a href="${pageContext.request.contextPath}/NewsManagerServlet?method=${m}&findItem=${condition}&pagecode=${pagebean.currentPage+1}">下一页</a>
                           </li>
                        </c:if>
                     <li>
                      <a href="${pageContext.request.contextPath}/NewsManagerServlet?method=${m}&findItem=${condition}&pagecode=${pagebean.totalPage}">尾页</a>
                     </li>   
				
			
				</ul>
			</div>
			 
			  </c:otherwise>
			</c:choose>
			
		</div>
	</div>
</div>

  </body>
</html>
