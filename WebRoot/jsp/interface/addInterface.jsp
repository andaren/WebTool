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
	var argNum = 1;
	function addArg() {
		var place = window.document.getElementById("argDiv");
		place.append("<input id="+argNum+" name="+(argNum++)+" value='' type='text'/>");
	}
</script>
  </head>  
  <body>
  <form action="${base}interface/addInterface.do" id="addInterfaceForm">
  	<table cellpadding="30%" align="left">
		<tr>			
			<td>接口名称：
				<input id="name" name="name" value="" type="text"/>
			</td>
		</tr>
		<tr>
			<td>接口类型：
				<select id="categoryId" name="categoryId">				
					<c:if test="${not empty categoryList}">					
						<c:forEach items="${categoryList }" var="category" varStatus="statu">
							<option value="${category.id }">${category.actionName }-${category.type }</option>
						</c:forEach>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>	
			<td>接口描述：
				<input id="description" name="description" value="" type="text"/>
			</td>	
		</tr>
		<tr>
			<td>接口路径：
				<input id="path" name="path" value="" type="text"/>
			</td>	
		</tr>
		<tr>
			<td>接口参数：
				<div id="argDiv"><input id="args0" name="args0" value="" type="text"/></div><input value="添加参数" type="button" onclick="addArg();"/>				
			</td>
		</tr>
		<tr>
			<td>提交人：
				<input id="submitter" name="submitter" value="" type="text"/>
			</td>
		</tr>
	</table>
	<input id="TiJiao" type="button" value="提交" onclick="validate();"/>
  </form>
  </body>
</html>
