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
    
    <title>工具集页面</title>
    
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
  	<c:if test="${not empty user }">
  		<div>
  			<span> 用户：${user.username}!</span>
  		</div>
  	</c:if>
  	
    <div style="margin-left: 20%;margin-top: 5%"><a href="<%= basePath%>jsp/tool/changed.jsp"><img src="${base }image/changeSql.png" title="SQL替换"></a></div>
  	<div><a href="<%= basePath%>interface/allCategory.do">接口类型管理</a></div>
 	<div><a href="<%= basePath%>interface/allInterface.do">接口管理</a></div>
 	<div><a href="<%= basePath%>jsp/tool/teacherAtt.jsp">老师考勤测试数据导入</a></div>
  </body>
</html>
