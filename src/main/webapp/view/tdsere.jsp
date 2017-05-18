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
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>企业签到</title>
<link rel="stylesheet" href="<%=basePath%>view/css/weui.css">
<link rel="stylesheet" href="<%=basePath%>view/css/weui.min.css">
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>

<style type="text/css" media="screen">
body, html {
	overflow-x: hidden;
}
</style>
</head>
<body class="container">
	<div class="page">
		<div class="weui_panel_hd ">
			<h1 class="weui_cells_title">签到</h1>
			<p class="weui_cells_tips">请选择贵公司进行信息校对,红色标题为您所在的摊位。</p>
		</div>
		
		
		<div class="weui-cells">
		
			<c:forEach items="${tdusers}" var="user">
			<a href="<%=path%>/servlet/PostCheckTd?id=${user.id}" style="color:#000;">
			<div class="weui-cell weui-cell_access">
				<div class="weui-cell__bd">
					<span style="vertical-align: middle">${user.tdname}</span>
		<span class="weui-badge" style="margin-left: 5px;">${user.tdno}</span> 
				</div>
				<div class="weui-cell__ft"></div>
			</div>
			</a>
			</c:forEach>
			<div class="weui-cell weui-cell_access" style="text-align:center;">
				<div  class="weui-cell__bd">
					<span >没有更多数据</span>
					<!--          <span class="weui-badge" style="margin-left: 5px;">New</span> -->
				</div>
				<!-- <div class="weui-cell__ft"></div> -->
			</div>
		</div>
		
		
		
		
		
		
		<div class="weui_msg">
			<div class="weui_extra_area">
				<a href="">©招生就业办 Designed by zefeng</a>
			</div>

		</div>
	</div>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=62072052" charset="UTF-8"></script>

</body>
</html>