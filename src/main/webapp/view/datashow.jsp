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
			<li><a class="active-menu" href="<%=path%>/servlet/GetDataShow"><i
					class="fa fa-dashboard"></i> 数据统计</a>
			</li>
			<li><a href="<%=path%>/servlet/GetTdInfo"><i
					class="fa fa-desktop"></i>企业管理</a>
			</li>
			<li><a href="<%=path%>/servlet/GetStuInfo"><i
					class="fa fa-desktop"></i> 学生管理</a>
			</li>
			<li><a href="<%=path%>/servlet/GetSetting"><i class="fa fa-desktop"></i> 系统设置</a>
			</li>
		</ul>
	</div>
</nav>
<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			</body>
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						统计面板 <small><a onclick="window.location.reload();" href=""
							title="">刷新</a> </small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div
						class="panel panel-primary text-center no-boder bg-color-green">
						<div class="panel-body">
							<i class="fa fa-bar-chart-o fa-5x"></i>
							<h3>${tdcnt}</h3>
						</div>
						<div class="panel-footer back-footer-green">企业签到</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-blue">
						<div class="panel-body">
							<i class="fa fa-shopping-cart fa-5x"></i>
							<h3>${ourStu }</h3>
						</div>
						<div class="panel-footer back-footer-blue">本校学生</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-red">
						<div class="panel-body">
							<i class="fa fa fa-comments fa-5x"></i>
							<h3>${otherStu }</h3>
						</div>
						<div class="panel-footer back-footer-red">外校学生</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div
						class="panel panel-primary text-center no-boder bg-color-brown">
						<div class="panel-body">
							<i class="fa fa-users fa-5x"></i>
							<h3>${tdcnt+ourStu+otherStu}</h3>
						</div>
						<div class="panel-footer back-footer-brown">人员总计</div>
					</div>
				</div>
			</div>
			<!-- 
<div class="row">
	<div class="col-md-4 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-heading">学生信息</div>
			<div class="panel-body">
				<div class="list-group">
					<a href="#" class="list-group-item"> <span class="badge">10:00</span>
						<i class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a> <a href="#"
						class="list-group-item"> <span class="badge">10:00</span> <i
						class="fa fa-fw fa-user"></i>机电工程系 郑泽丰 </a>
				</div>
				<div class="text-right">
					<a href="#">查看更多<i class="fa fa-arrow-circle-right"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-8 col-sm-12 col-xs-12">

		<div class="panel panel-default">
			<div class="panel-heading">企业信息</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>摊位号</th>
								<th>企业名称</th>
								<th>联系人</th>
								<th>电话</th>
								<th>签到</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>John</td>
								<td>Doe</td>
								<td>John15482</td>
								<td>是</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Kimsila</td>
								<td>Marriye</td>
								<td>Kim1425</td>
								<td>否</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Rossye</td>
								<td>Nermal</td>
								<td>Rossy1245</td>
								<td>否</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Richard</td>
								<td>Orieal</td>
								<td>Rich5685</td>
								<td>是</td>
							</tr>
							<tr>
								<td>5</td>
								<td>Jacob</td>
								<td>Hielsar</td>
								<td>Jac4587</td>
								<td>是</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Wrapel</td>
								<td>Dere</td>
								<td>Wrap4585</td>
								<td>否</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</div> -->
			<!-- /. ROW  -->
			<jsp:include page="footer.jsp"></jsp:include>