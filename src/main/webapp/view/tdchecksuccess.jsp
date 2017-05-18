<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>签到状态</title>
<link rel="stylesheet" href=" <%=basePath%>view/css/weui.css">
</head>
<body>
	<div class="weui_msg">
		<div class="weui_icon_area">
			<i class="weui_icon_success weui_icon_msg"></i>
		</div>
		<div class="weui_text_area">
			<h2 class="weui_msg_title">签到成功</h2>
			<p class="weui_msg_desc">3秒后将自动跳转到企业主页</p>
		</div>
		<div class="weui_opr_area">
			<p class="weui_btn_area">
				<a href="<%=basePath%>servlet/LinkPostList?id=${id}"
					class="weui_btn weui_btn_primary">确定</a>
			</p>
		</div>
		<div class="weui_extra_area">
			<a href="">©招生就业办 Designed by zefeng</a>
		</div>
	</div>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=62072052" charset="UTF-8"></script>

</body>
</html>