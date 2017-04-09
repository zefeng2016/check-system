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
		<form action="<%=basePath%>servlet/PostTdSeRe" method="post">
			<div class="weui_cells_title">录入信息后点击搜索，支持模糊搜索</div>
			<div class="weui_cells weui_cells_form">
				<div id="fromerror" class="weui_toptips weui_warn js_tooltips"
					style="display:none;">信息错误</div>
		
				<div class="weui_cells weui_cells_form">
					
					
					<div id="stuname" class="weui_cell">
						<div class="weui_cell_hd">
							<label class="weui_label">企业名称</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="text" name="sousuoxinxi"
								placeholder="">
						</div>
						<div class="weui_cell_ft">
							<i class="weui_icon_warn"></i>
						</div>
					</div>
					
				</div>
			</div>
			<div class="weui_btn_area">
				<button id="showTooltips" name="Button1" value="" type="submit"
					onclick="return check(this.form)" class="weui_btn weui_btn_primary">搜索</button>
			</div>

		</form>
		<div class="weui_msg">
			<div class="weui_extra_area">
				<a href="">©招生就业办 Designed by zefeng</a>
			</div>

		</div>
	</div>

	</html>