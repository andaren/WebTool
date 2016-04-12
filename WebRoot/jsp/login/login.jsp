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
    
    <title>欢迎！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
window.onload= function () {
	setTimeout("msgDisappear();", 1000);
};

function msgDisappear() {
	var msg = document.getElementById("msg").remove();
}
function login() {

}

function register() {
	window.location = "<%= basePath%>jsp/user/addUser.jsp";
	//window.location="http://www.w3school.com.cn";

}
</script>
  </head>
  
  <body>
    <form id="login" action="<%= basePath%>user/login.do" method="post">
   		<div>用户名：<input id="username" name="username" type="text" value="${username}"/></div>
   		<div>密码：<input id="password" name="password" type="password" value="${password}"/></div>
		<c:if test="${not empty msg}">
			<div id="msg">${msg}</div>
		</c:if>
    	<div><input type="submit" onclick="login();" value="登录"/><input type="button" onclick="register();" value="注册"/></div>
    </form>
  </body>
</html>
