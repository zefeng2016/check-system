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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>招聘会管理系统</title>
<!-- Bootstrap Styles-->
<link href="<%=basePath%>view/assets/css/bootstrap.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="<%=basePath%>view/assets/css/custom-styles.css"
	rel="stylesheet" />
<!-- jQuery Js -->
<script src="<%=basePath%>view/assets/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>view/assets/js/td.js"></script>
<%--  <script src="<%=basePath%>view/assets/js/stu.js"></script> --%>
<!-- FontAwesome Styles-->
<link href="<%=basePath%>view/assets/css/font-awesome.css"
	rel="stylesheet" />
</head>
<script type="text/javascript">
	var url = "<%=basePath%>";
</script>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=path%>/servlet/GetIndex">招聘会管理系统</a>
			</div>

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong>John Doe</strong> <span class="pull-right text-muted">
										<em>Today</em> </span>
								</div>
								<div>Lorem Ipsum has been the industry's standard dummy
									text ever since the 1500s...</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>John Smith</strong> <span class="pull-right text-muted">
										<em>Yesterday</em> </span>
								</div>
								<div>Lorem Ipsum has been the industry's standard dummy
									text ever since an kwilnw...</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>John Smith</strong> <span class="pull-right text-muted">
										<em>Yesterday</em> </span>
								</div>
								<div>Lorem Ipsum has been the industry's standard dummy
									text ever since the...</div> </a>
						</li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>Read
									All Messages</strong> <i class="fa fa-angle-right"></i> </a>
						</li>
					</ul> <!-- /.dropdown-messages -->
				</li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i> </a>
					<ul class="dropdown-menu dropdown-tasks">
						<li><a href="#">
								<div>
									<p>
										<strong>内存</strong> <span class="pull-right text-muted">60%
											使用率</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (success)</span>
										</div>
									</div>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>CPU</strong> <span class="pull-right text-muted">28%
											使用率</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="28" aria-valuemin="0" aria-valuemax="100"
											style="width: 28%">
											<span class="sr-only">28% Complete</span>
										</div>
									</div>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>磁盘使用率</strong> <span class="pull-right text-muted">60%
											使用率</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>数据库</strong> <span class="pull-right text-muted">85%
											使用率</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="85" aria-valuemin="0"
											aria-valuemax="100" style="width: 85%">
											<span class="sr-only">85% Complete (danger)</span>
										</div>
									</div>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>查看全部数据</strong>
								<i class="fa fa-angle-right"></i> </a>
						</li>
					</ul> <!-- /.dropdown-tasks -->
				</li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i> </a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> <%=System.getProperty("os.name") %> <span
										class="pull-right text-muted small">OS</span>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-twitter fa-fw"></i><%=System.getProperty("os.arch") %> <span
										class="pull-right text-muted small">Arch</span>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-envelope fa-fw"><%=System.getProperty("os.version") %></i>  <span
										class="pull-right text-muted small">Version</span>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-tasks fa-fw"></i><%=System.getProperty("user.name")%> <span
										class="pull-right text-muted small">UserName</span>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-upload fa-fw"></i><%=System.getProperty("user.dir") %><span
										class="pull-right text-muted small">Dir</span>
								</div> </a>
						</li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>服务器信息</strong></a>
						</li>
					</ul> <!-- /.dropdown-alerts -->
				</li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i> </a>
					<ul class="dropdown-menu dropdown-user">
						<li><a id="myinfo"><i class="fa fa-user fa-fw"></i>我的信息</a>
						</li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
						</li>
						<li class="divider"></li>
						<li><a href="<%=basePath%>servlet/GetOutLogin"><i
								class="fa fa-sign-out fa-fw"></i>退出登录</a></li>
					</ul> <!-- /.dropdown-user -->
				</li>
				<!-- /.dropdown -->
			</ul>
		</nav>