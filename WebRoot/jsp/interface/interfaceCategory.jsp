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
<script type="text/javascript">

	function addChild(categoryId) {
		//window.open('page.html', 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no') //该句写成一行代码
		window.open('${base }jsp/interface/addInterfaceCategory.jsp?categoryId='+categoryId+'&t='+new Date().getTime(),'添加接口类型页面', 'height=400, width=900, top=400, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=yes, location=no, status=no');
	}

	function addChild2(categoryId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLhttp");
		}
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {
				alert("XMLHTTP请求发送成功！");
			}
		};
		xmlHttp.open("post", "${base }tool/changeSql.do", true);
		xmlHttp.send();
	}
</script>
  </head>
  
  <body>
	<table cellpadding="30%" align="center" border="2px" cellspacing="10%">
		<tr>
			<th>接口类型</th>
		</tr>
		<c:if test="${not empty InterfacecategoryList}">
			<c:forEach items="${InterfacecategoryList}" var="interCategory" varStatus="status">
				<tr height="40px">
					<td>
						<input id="interfaceCategoryId" type="hidden" value="${interCategory.id}"/>
						<input id="parentId" type="hidden" value="${interCategory.parentId}"/>
						${interCategory.ActionName}
					</td>
					<td>${interCategory.type}</td>
					<td><input type="button" value="在其下添加子类型" onclick="addChild(${interCategory.id})"/></td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td>
				<input id="add" type="button" value="添加父接口类型" onclick="addChild(0);"/>
			</td>
		</tr>
	</table>
  </body>
</html>
