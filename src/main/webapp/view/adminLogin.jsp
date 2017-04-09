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
<title>login</title>
<link rel="stylesheet" href="">
<!-- Bootstrap Styles-->
<link href="<%=basePath%>view/assets/css/bootstrap.css" rel="stylesheet" />
<!-- jQuery Js -->
<script src="<%=basePath%>view/assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){ 
	$("#flowPw").click(function(event) {
		alert("请联系站点管理员在数据库进行修改");
	});
	$("#login").click(function(event) {
		/* Act on the event */
		var name = $("#username").val(); 
		var pw = $("#password").val();
		if (name==""||pw=="") {
			alert("用户名或密码为空");
		}else{
			$.ajax(
		{
			type : "get",
			url : "<%=basePath%>servlet/PostAdminLogin",
			data : {
				"username" : name,
				"password" : pw
			},
			success : function(msg) {
				if (msg == "error") {
					alert("用户名或密码错误");
				} else {
					window.location.href="<%=basePath%>servlet/GetDataShow"; 
				}
			}
		}).fail(function() {
			alert("网络错误，请检查网络连接状态");
		});
			
		}
	});
}); 
</script>
</head>
<style type="text/css" media="screen">
body {
	background-color: #09192A;
}
</style>
<body>
	<div class="row" style="margin-top: 10%">


		<div class=" col-md-offset-3 col-xs-12 col-sm-6 col-md-6 ">
			<div class="well">
				<h4>登录系统</h4>
				<p>
					<from>
					<div class="form-group">
						<label>管理员账号</label> <input id="username" class="form-control"
							placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<label>管理员密码</label> <input id="password" class="form-control"
							placeholder="请输入密码" type="password">
					</div>
					<a id="login" class="btn btn-primary btn-lg">登录</a> <a id="flowPw"
						style="vertical-align: bottom; margin-left:10px;">忘记密码</a> </from>
				</p>
			</div>
		</div>
	</div>
</body>
</html>