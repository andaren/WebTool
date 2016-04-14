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
    
    <title>用户注册界面</title>
    
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
		setTimeout("document.getElementById('msg').remove();", 1000);
	};
		function submitForm() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var Confirm = document.getElementById("Confirm").value;
			if (username == "" || username.length > 30) {
				alert("用户名为空，或者长度太长（不应超过30字符）");
				return false;
			} else if (password == "" || password.length > 10) {
				alert("用户密码为空，或者长度太长（不应超过10字符）");
				return false;
			} else if (Confirm != password) {
				alert("两次密码输入不一致，请确认后输入！");
				return false;
			} else {
				document.getElementById("userForm").submit();
			}
		}
	</script>
  </head>
  
  <body>
  	<form id="userForm" action="<%= basePath%>user/add.do" method="post" >
  		<input type="hidden" id="flag" name="flag" value="1"/>
  		<table>
  			<tr>
  				<td>用户名：<input id="username" name="username" type="text"/></td>
  				<c:if test="${not empty msg}">
  					<div id="msg">${msg}</div>
  				</c:if>
  			</tr>
  			<tr>
  				<td>密码：<input id="password" name="password" type="password"/></td>
  			</tr>
  			<tr>
  				<td>确认密码：<input id="Confirm" name="Confirm" type="password"/></td>
  			</tr>
  			<tr><td><input id="validate" type="button" value="注册" onclick="submitForm();"/></td></tr>
  		</table>
  	</form>
  </body>
</html>
