<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common.jsp"></jsp:include>
<!--/. NAV TOP  -->
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li><a href="<%=path%>/servlet/GetDataShow"><i
					class="fa fa-dashboard"></i> 数据统计</a></li>
			<li><a href="<%=path%>/servlet/GetTdInfo"><i
					class="fa fa-desktop"></i>企业管理</a></li>
			<li><a href="<%=path%>/servlet/GetStuInfo"><i
					class="fa fa-desktop"></i> 学生管理</a></li>
			<li><a href="system.jsp" class="active-menu"><i
					class="fa fa-desktop"></i> 系统设置</a></li>
		</ul>

	</div>

</nav>
<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row"></div>
		<!-- </body> -->
		<div id="modelbg" class="modal-backdrop fade in"
			style="display: none;"></div>
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">
					系统设置 <small><a onclick="window.location.reload();" href=""
						title="">刷新</a> </small>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" >
			<form role="form">
				<div class="form-group col-md-6">
					<label>登陆账号</label> <input id="admin_name"
						class="form-control" placeholder="请输入账号" value="${admin_name} ">
				</div>
				<div class="form-group col-md-6">
					<label>用户名</label> <input id="admin_username"
						class="form-control" placeholder="请输入新用户名" value="${admin_username}">
				</div>
				<div class="form-group col-md-6">
					<label>密码</label> <input type="password" id="admin_password"
						class="form-control" placeholder="请输入新密码">
				</div>
				<div class="form-group col-md-6">
					<label>重复</label> <input type="password" id="admin_againpassword"
						class="form-control" placeholder="请输入新密码">
				</div>
				<button id="save_admin" type="button" class="btn btn-primary col-md-2 " style="margin-left: 15px;">保存</button>
				</form>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>