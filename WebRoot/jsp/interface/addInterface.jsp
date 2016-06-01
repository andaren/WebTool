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

	function addArg() {
		var argNum = document.getElementById("argNum");
		var nextNum = Number(argNum.value) + 1;
		argNum.value = nextNum;
		alert(argNum.value); 
		//参数设置<input id="+argNum+" name="+(argNum++)+" value='' type='text'/>
		var argValue = document.createElement("input");
		argValue.id = "args" + nextNum;
		argValue.name = "args" + nextNum;
		argValue.type= "text";
		argValue.style="width: 100px;";
		//参数名称节点
		var argName = document.createElement("input");
		argName.id = "argName" + nextNum;
		argName.name = "argName" + nextNum;
		argName.type= "text";
		argName.style="width: 100px;";
		var placeValue = window.document.getElementById("argDiv");
		var placeName = window.document.getElementById("argNameDiv");
		placeValue.appendChild(argValue);
		placeName.appendChild(argName);
	}
</script>
  </head>  
  <body>
  <form action="${base}interface/save.do" id="addInterfaceForm" method="post">
  	<input type="hidden" value="0" id="argNum" name="argNum"/>
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
							<option value="${category.id }">
								<c:choose>
									<c:when test="${category.type == 0}">
										家长端
									</c:when>
									<c:when test="${category.type == 1}">
										老师端
									</c:when>
								</c:choose>
								-${category.actionName }
							</option>
						</c:forEach>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>	
			<td>接口描述：
				<textarea id="description" name="description"></textarea>
			</td>	
		</tr>
		<tr>
			<td>接口路径：
				<input id="path" name="path" value="" type="text"/>
			</td>	
		</tr>
		<tr>
			<td>接口参数：<input value="添加参数" type="button" onclick="addArg();"/>
				<div id="argDiv">
					名称：<input id="args0" name="args0" value="" type="text" style="width: 100px;"/>
				</div>
				<div id="argNameDiv">
					描述：<input id="argName0" name="argName0" value="" type="text" style="width: 100px;"/>
				</div>				
			</td>
		</tr>
		<tr>
			<td>提交人：
				<select id="submitter" name="submitter">
					<c:if test="${not empty usernameList}">					
						<c:forEach items="${usernameList }" var="user" varStatus="statu">
							<option value="${user.id }">								
								${user.username }
							</option>
						</c:forEach>
					</c:if>
				</select>
				<input id="TiJiao" type="button" value="提交" onclick="validate();"/>
			</td>
		</tr>
	</table>	
  </form>
  </body>
</html>
