<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>企业信息</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"
	id="viewport" name="viewport">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="format-detection" content="telephone=no">
<meta name="”format-detection”" content="”telephone=no”">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>view/css/1.css">
</head>
<body>

	<!-- 输出内容 -->
	<div class="mainBox">
		<div class="liatBox">
			<div style="padding:0;">
				<!--header-->
				<header class="header headertitle">
					<a href="<%=path%>/servlet/GetIndex"><em>主页</em> </a>企业信息
				</header>
				<!--list-->
				<div class="list-box">
					<div class="title clearfix">
						<div class="left clearfix">
							<span>${user.tdname}</span>
						</div>

					</div>
					<div class="bottom clearfix">
						<p style="padding: 12px;text-indent:2em;">${user.introduce}</p>
					</div>
				</div>
				<div class="list-box">
					<div class="title clearfix">
						<div class="left clearfix">
							<span>摊位号|${user.tdno}</span>
						</div>

						<div class="right time">${user.tdcheck }</div>
					</div>
					<div class="bottom clearfix">
						<p style="padding: 12px;">${user.local }</p>
					</div>
				</div>

				<c:forEach items="${postlist}" var="postlist">
					<div class="list-box">
						<div class="title clearfix">
							<div class="left clearfix">
								<a href="#"><span>${postlist.postname}</span> </a>
							</div>
							<!-- <div class="right time">${postlist.postno}</div>-->
						</div>
						<div class="bottom clearfix">
							<div class="left" style="height: 40px;">
								<span></span><em>${postlist.postwages}元/月</em>
							</div>
							<div class="right adde">${postlist.postnum}人</div>
						</div>
						<div class="list-box d-list" style="margin:0px auto">
							<div class="clearfix">
								<span style="float: none;">工作内容：${postlist.postjob}</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=62072052" charset="UTF-8"></script>

</body>
</html>