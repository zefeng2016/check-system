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
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
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
			<p class="weui_cells_tips">欢迎访问招聘会企业签到</p>
		</div>
	
			<div class="weui_cells_title">请核对信息，无误请点击确定，如若有疑问，请联系工作人员。</div>
			<div class="weui_cells weui_cells_form">
				<div id="fromerror" class="weui_toptips weui_warn js_tooltips"
					style="display:none;">信息错误</div>

				<div class="weui_cells weui_cells_form">

					<div class="weui-cell">
						<div class="weui-cell__bd">
							<p>${user.tdname}</p>
						</div>
						<!-- <div class="weui-cell__ft">说明文字</div> -->
					</div>
					<div class="weui-cell">
						<div class="weui-cell__bd">
							<p>摊位号</p>
						</div>
						<div class="weui-cell__ft">${user.tdno}</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__bd">
							<p>联系人</p>
						</div>
						<div class="weui-cell__ft">${user.tduser }</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__bd">
							<p>联系方式</p>
						</div>
						<div class="weui-cell__ft">${user.tdphone}</div>
					</div>


				</div>
			</div>
			<div class="weui_opr_area">
			<p class="weui_btn_area">
				<a href="<%=basePath%>servlet/PostTdLogin?id=${user.id}"
					class="weui_btn weui_btn_primary">确定</a>
			</p>
		</div>

	
		<div class="weui_msg">
			<div class="weui_extra_area">
				<a href="">©招生就业办 Designed by zefeng</a>
			</div>

		</div>
	</div>


</body>
</html>