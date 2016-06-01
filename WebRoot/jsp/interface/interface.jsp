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

	function addInterface() {
		window.open('${base }interface/addInfos.do?t='+new Date().getTime(),'添加接口页面', 'height=600, width=900, top=300, left=200, toolbar=no, menubar=no, scrollbars=no, resizable=yes, location=no, status=no');
	}

	function deleteInterface(interfaceId) {
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
		xmlHttp.open("POST", "${base }interface/delete.do?interfaceId="+interfaceId+"&t="+new Date().getTime(), true);
		xmlHttp.send();
	}
	
	function testInterface(interfaceId) {
		window.open('${base }interface/testInterface.do?interfaceId='+interfaceId+'&t='+new Date().getTime(),'测试接口页面', 'height=300, width=500, top=300, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=yes, location=no, status=no');
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
  		<legend>接口一览</legend>
  		<table cellpadding="20%" border="1px" cellspacing="0px">
		<tr bgcolor="lightgreen" align="center">
			<td>接口名</td>
			<td>接口Action</td>
			<td>接口类型</td>
			<td>接口描述</td>			
			<td>请求路径</td>
			<td>请求参数</td>
			<td>提交人</td>
			<td>操作</td>
		</tr>
		<c:if test="${not empty inferfaceList}">
			<c:forEach items="${inferfaceList}" var="inter" varStatus="status">
				<tr height="40px">
					<td>
						<input id="interfaceCategoryId" type="hidden" value="${inter.interfaceId}"/>
						${inter.interfaceName}
					</td>
					<td>
						${inter.actionName}
					</td>
					<td>					
						<c:choose>
							<c:when test="${inter.interfaceType == 1}">
								家长端
							</c:when>
							<c:when test="${inter.interfaceType == 0}">
								老师端
							</c:when>
						</c:choose>							
					</td>
					<td>
						${inter.description}
					</td>
					<td>
						${inter.interfacePath}
					</td>
					<td>
						${inter.interfaceArgs}
					</td>
					<td>
						${inter.submitter}
					</td>
					<td>
						<div><input type="button" value="删除" onclick="deleteInterface(${inter.interfaceId});"/></div>
						<div><input type="button" value="测试连接" onclick="testInterface(${inter.interfaceId});"/></div>
					</td>
				</tr>
			</c:forEach>
		</c:if>		
	</table>
  	<div>
  		<input id="addInter" type="button" value="提交一个新接口" onclick="addInterface();" style="margin-top: 20px;"/>  	
  	</div>
  	</fieldset>
	
  </body>
</html>
