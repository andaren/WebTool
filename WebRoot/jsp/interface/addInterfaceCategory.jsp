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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function validate() {
		window.document.getElementById("addInterfaceForm").submit();
		setTimeout(1000);
		//window.parent.location.reload(); 为什么不行(因为不是iframe)
		window.opener.location.reload(); 
		window.close();		
	}
</script>
  </head>  
  <body>
  <form action="${base}interface/addCategory.do" id="addInterfaceForm">
 	<input id="parentId" name="parentId" type="hidden" value="${param.categoryId}"/>
  	<table cellpadding="30%" align="center" border="2px" cellspacing="10%">
		<tr>			
			<td>接口类型：
				<select id="type" name="type">
					<option value="0">家长端</option>
					<option value="1">老师端</option>
				</select>
			</td>
			<td>接口对应Action的名称：<input id="actionName" name="actionName" type="text" value=""/></td>
			<td><input id="TiJiao" type="button" value="提交" onclick="validate();"/></td>
		</tr>
	</table>
  </form>
  </body>
</html>
