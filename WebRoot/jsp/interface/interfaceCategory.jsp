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

	function deleteCategory(categoryId) {
		var xmlHttp;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.onreadystatechange = function() {
			if (2 == xmlHttp.readyState) {//2：请求已发送   但是并没有检查回应、页面是否正常返回（设置200&4 则失效）
			 	window.location = location;
			}
		};
		xmlHttp.open("get", "${base }interface/deleteCategory.do?categoryId="+categoryId+"&t="+new Date().getTime(), true);
		xmlHttp.send();
	}
	function addChild2(categoryId) {
		var xmlHttp;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {
				alert("XMLHTTP请求发送成功！");
			}
		};
		xmlHttp.open("post", "${base }interface/allCategory.do", true);
		xmlHttp.send();
	}
</script>
  </head>
  
  <body>
  	<fieldset style="margin-left: auto; margin-top: auto;">
  		<legend>接口类型</legend>
  		<table cellpadding="20%" border="1px" cellspacing="0px">
		<tr bgcolor="lightgreen" align="center">
			<td>Action名称</td>
			<td>接口类型</td>
			<td>操作</td>
		</tr>
		<c:if test="${not empty interfacecategoryList}">
			<c:forEach items="${interfacecategoryList}" var="interCategory" varStatus="status">
				<tr height="40px">
					<td>
						<input id="interfaceCategoryId" type="hidden" value="${interCategory.id}"/>
						<input id="parentId" type="hidden" value="${interCategory.parentId}"/>
						${interCategory.actionName}
					</td>
					<td>					
						<c:choose>
							<c:when test="${interCategory.type == 1}">
								家长端
							</c:when>
							<c:when test="${interCategory.type == 0}">
								老师端
							</c:when>
						</c:choose>							
					</td>
					<td>
						<input type="button" value="在其下添加子类型" onclick="addChild(${interCategory.id});"/>
						<input type="button" value="删除" onclick="deleteCategory(${interCategory.id});"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>		
	</table>
  	<div>
  		<input id="add" type="button" value="添加父接口类型" onclick="addChild(0);" style="margin-top: 20px;"/>
  	</div>
  	</fieldset>
	
  </body>
</html>
