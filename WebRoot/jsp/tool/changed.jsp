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
    
    <title>SQL替换工具</title>
    
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
  	<h3 align="center">用于：拆分*组合 SQL</h3>
  	<form id="SQLForm" action="${base }tool/changeSql.do">
  		<input type="hidden" value="0" id="changeType" name="changeType"/>
  		<div>
  		<fieldset style="border-color: green;width: 200px; margin: auto;">
	  		<legend>
	  			包装的SQL
	  		</legend>
	  		<textarea id="sql" name="sql" rows="18" cols="100" onblur="change(0);">${sql }</textarea>
	  	</fieldset>
	  	</div>
	  	<div>
	    <fieldset style="border-color: red;width: 200px; margin: auto;">
	  		<legend>
	  			拆分的SQL
	  		</legend>
	  		<input style="margin: auto;width: 100%;" name="addAppendStr" id="addAppendStr" type="text" value="" onblur="change(1);"/>
	  		<textarea id="changedSqlInJsp" name="changedSqlInJsp" rows="18" cols="100">${changedSql }</textarea>
	  		<input style="margin: auto;width: 100%;" id="back" type="button" value="返回"  onclick="window.location='${base}jsp/mainTools.jsp'"/>
	  	</fieldset>
	  	</div>	  	
	 </form>  	
  </body>
</html>
