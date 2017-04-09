<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>未登录</title>
<!-- jQuery Js -->
<script src="<%=basePath%>view/assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
		$(function(){ 
			alert("请先登录！");
			window.location.href="<%=basePath%>view/adminLogin.jsp"; 
			});	
	</script>
</head>
<body>
	<h1>请先登录</h1>
</body>
</html>