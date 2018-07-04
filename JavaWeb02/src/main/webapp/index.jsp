<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
 	<script type="text/javascript">
 	$(function(){
 		initData();
 	})	
 	function initData(){
 			$.ajax({
 				type:"post",
 				data:{
 					
 				},
 				dataType:"json",
 				url:"/JavaWeb02/book/getBooks.do",
 				success:function(data){
 					var bookTypes = $("select[name=type]");
 					$.each(data["bookTypes"],function(i,v){
 						bookTypes.append("<option value="+v["id"]+">"+v["type_name"]+"</option>")
 					})
 				},
 				error:function(){
 					alert("请求失败");
 				}
 			})
 		}
 	</script>
  </head>
  <body>
	<form action="/JavaWeb02/book/getBooks.do" method="post">
		<select name="type">
			<option value="-1">--请选择--</option>
		</select>
		<input name="bookname"/>
		<select name="isBorrow">
			<option value="-1">--请选择--</option>
			<option value="1">为借阅</option>
			<option value="2">已借阅</option>
		</select>
		<input type="submit"/>
	</form>
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>类型</td>
				<td>书名</td>
				<td>出版社</td>
				<td>是否借阅</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${pageUtil.books}">
				<tr>
					<th>${book.book_code }</th>
					<th>${book.book_type }</th>
					<th>${book.book_name }</th>
					<th>${book.publish_press }</th>
					<th>${book.is_borrow }</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="/JavaWeb02/book/getBooks.do?index=1" >首页</a>
		<a href="/JavaWeb02/book/getBooks.do?index=${pageUtil.index-1 }">上一页</a>
		<a href="/JavaWeb02/book/getBooks.do?index=${pageUtil.index+1 }">下一页</a>
		<a href="/JavaWeb02/book/getBooks.do?index=${pageUtil.totalPage}">尾页</a>
	</p>
  </body>
</html>
