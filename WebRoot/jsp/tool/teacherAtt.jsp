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
    
    <title>老师考勤初始化参数设置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	
	function change(type) {
		var newType = parseInt(type);
		var appendStr = document.getElementById("addAppendStr").value;		
		var form = document.getElementById("SQLForm");
		if (newType == 0) {			
			form.submit();
		} else {
			if (appendStr.contains("append")){
				document.getElementById("changeType").value = newType;
				form.submit();
			}
		}
		
		
	}
</script>
  </head>
  
  <body>
  	<h3 align="center">考勤数据初始化</h3>
  	<form id="SQLForm" action="${base }tool/writeTestAttData.do">  		
  		<div>
  		<fieldset style="border-color: green;width: 160px; margin: auto;">
	  		<legend>
	  			参数设置
	  		</legend>
	  		<label>用户名：</label>
	  		<input type="text" value="5220" id="username" name="username"/>
	  		<label>老师ID：</label>
	  		<input type="text" value="2499" id="teacherId" name="teacherId"/>
	  		<label>学校代码：</label>
	  		<input type="text" value="600585" id="schoolId" name="schoolId"/>
	  		<label>考勤的月份：</label>
	  		<input type="text" value="2016-5" id="date" name="date"/>
	  		<input type="submit" value="提交参数"/>
	  	</fieldset>	  	
	  	</div>  	
	 </form>  	
  </body>
</html>
