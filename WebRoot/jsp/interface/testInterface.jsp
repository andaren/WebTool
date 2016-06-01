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
	function testThis(type) {
		var path = "";
		if(type == 0) {
			path = "http://www.zxjy360.com/StudyTeach";
		} else if (type == 1) {
			path = "http://120.26.83.12/StudyTeach";
		} else if (type == 2) {
			path = "http://"+'${IP}' + ":8080/StudyTeach";
		} 
		path += '${path}';
		var count = parseInt('${argCount}');
		for (var i = 0; i < count; i++) {
			var ele = window.document.getElementById(i);
			var name = ele.name;
			if (ele.value.trim() == "") {
				alert(ele.name + "输入不能为空");
				return;
			}
			if (i == 0) {
				path += "?"+name+"=" + ele.value;
			} else if (i == count - 1) {
				path += "&"+name+"=" + ele.value + "&t=" + new Date().getTime();
			} else {
				path += "&"+name+"=" + ele.value;
			}			
		}
		/* window.location = path;
		setTimeout(1000);
		var bodyEle = window.document.body;
		var jsonStr = bodyEle.innerHTML;
		alert(jsonStr);
		bodyEle.innerHTML="dsds";
		window.location.reload(); */
		var xmlHttp;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.status == 0 && xmlHttp.readyState == 4) {
				alert(1);
				var str = xmlHttp.responseText;
				alert(str);
				alert(2);
			}
		};
		xmlHttp.open("post", path, true);
		xmlHttp.send();
	}
</script>
  </head>  
  <body>
  	<table cellpadding="2px" align="center">
  		<c:forEach items="${argList}" var="arg" varStatus="statu">
  			<tr>			
				<td>${arg.argDes}
					<div><input id="${arg.count}" name="${arg.argName}" value="" type="text"/></div>
				</td>
			</tr>
  		</c:forEach>
  		<tr>			
			<td>
				<input value="在正式环境测试" type="button" onclick="testThis(0);"/>
				<input value="在测试环境测试" type="button" onclick="testThis(1);"/>
				<input value="在提交者本地测试" type="button" onclick="testThis(2);"/>
			</td>
		</tr>		
	</table>	
  </body>
</html>
