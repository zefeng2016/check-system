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
<title>职位搜索</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" href="<%=basePath%>view/css/1.css">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- jQuery Js -->
<script src="<%=basePath%>view/assets/js/jquery-1.8.2.min.js"></script>
	<script>
	     $(function(){
    
                $("#info").attr('placeholder', '${select}');
            });
          
      
	</script>
</head>
<body>

	
	<div  class="mainBox">
		<div class="liatBox">
			<div style="padding:0;">
				<header class="header headertitle">
					<a href="<%=path%>/servlet/GetIndex"><em>主页</em> </a>搜索
				</header>
				
					<!-- 导航栏 -->
	<form style="background: f8f8f8;" action="<%=basePath%>servlet/PostselectInfo" method="post"
		role="search">
		<div class="row"
			style="padding-top:1em;padding-left:0.5em;padding-right:0.5em; margin: 0;">
			<div class="input-group">
				<input id="info" type="text" class="form-control" name="sousuoxinxi"
					placeholder="无搜索 "> <span
					class="input-group-btn">
					<button type="submit" class="btn btn-default">搜索</button> </span>
			</div>
		</div>
	</form>
				<!--list-->
					<!-- 内容 -->
	<div class="mainBox">
		<div class="liatBox ">
			<div style="padding:0;">
				<c:forEach items="${tdusers}" var="user">
					<div class="list-box d-list">
						<div class="clearfix">
							<em><img src="<%=basePath%>view/img/ic1.png" width="21">
							</em><span>摊位编号：${user.tdno}</span>
						</div>
						<div class="clearfix">
							<em><img src="<%=basePath%>view/img/ic4.png" width="21">
							</em><span>招聘企业：<a
								href="<%=path%>/servlet/LinkPostList?id=${user.id}">${user.tdname}</a>
							</span>
						</div>
						<div class="clearfix">
							<em><img src="<%=basePath%>view/img/ic2.png" width="21">
							</em><span>签到状态：${user.tdcheck }</span>
						</div>
						<div class="clearfix">
							<em><img src="<%=basePath%>view/img/ic8.png" width="21">
							</em><span>公司地址：${user.local }</span>
						</div>
						<div class="clearfix">
							<em><img src="<%=basePath%>view/img/ic3.png" width="21">
							</em><span>公司简介：${user.introduce}...</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
				
				
				

		<c:forEach items="${postlist}" var="postlist">
					<div class="list-box" href="<%=path%>/servlet/LinkPostList?id=${postlist.tdid}" >
						<div class="title clearfix">
							<div class="left clearfix">
								<a
								href="<%=path%>/servlet/LinkPostList?id=${postlist.tdid}"><span>${postlist.postname}</span> </a>
							</div>
							<div class="right time">${postlist.postno}</div>
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
				
				
<div class="list-box d-list" style="text-align: center;padding:16px;font-weight:bold;">没有更多结果</div>
			</div>
		</div>


	</div>
</body>
</html>