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
    
    <title>用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<table cellpadding="30%" align="center" border="2px" cellspacing="10%">
		<tr>
			<th>用户名</th><th>密码</th>
		</tr>
		<c:if test="${not empty userList}">
			<c:forEach items="${userList}" var="user" varStatus="status">
				<tr height="40px">
					<td>${user.username}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
  </body>
</html>
