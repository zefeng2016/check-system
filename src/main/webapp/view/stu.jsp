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
			<li><a class="active-menu" href="<%=path%>/servlet/GetStuInfo"><i
					class="fa fa-desktop"></i> 学生管理</a></li>
				<li><a href="<%=path%>/servlet/GetSetting"><i class="fa fa-desktop"></i> 系统设置</a>
			</li>
		</ul>

	</div>

</nav>
<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<!-- </body> -->
			<div id="modelbg" class="modal-backdrop fade in"
				style="display: none;"></div>
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						签到学生列表 <small><a onclick="window.location.reload();"
							href="" title="">刷新</a> </small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">学生列表</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<!-- 	<th>id</th> -->
											<th>学校</th>
											<th>学号</th>
											<th>系部</th>
											<th>班级</th>
											<th>姓名</th>
											<th>学历</th>
											<!-- 	<th>签到状态</th> -->
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${users}" var="user">
											<tr class="">
												<%-- <td class="">${user.id}</td> --%>
												<td class="">${user.stuschool}</td>
												<td class="1">${user.stuno}</td>
												<td class="2">${user.stuxibu }</td>
												<td class="3">${user.stubanji }</td>
												<td class="center 4">${user.stuname }</td>
												<td class ="center 5" >${user.education}</td>
												<!-- 	<td class="center 5">已签到</td> -->
											</tr>
										</c:forEach>
										<!-- 
                            <tr class="gradeA">
                                <td>1405050107</td>
                                <td>机电工程系</td>
                                <td>14移动互联网应用与测试1班</td>
                                <td class="center">郑泽丰</td>
                                <td class="center">已签到</td>
                            </tr> -->

									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!--End Advanced Tables -->
					<!-- panle -->
					<div id="panel" class="modal fade " id="myModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close closepanel"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">企业信息浏览</h4>
								</div>
								<div class="modal-body">
									<form role="form">
										<div class="form-group">
											<label>学号</label> <input id="stunopanel"
												class="form-control " placeholder="学号">
										</div>
										<div class="form-group">
											<label>系部</label> <select id="xibu_select"
												class="form-control" name="stu_xibu"></select>
										</div>

										<div class="form-group">
											<label>班级</label> <select id="banji_select"
												class="form-control" name="stu_banji">
											</select>

										</div>
										<div class="form-group">
											<label>姓名</label> <input id="stunamepanel"
												class="form-control" placeholder="姓名">
										</div>
										<div class="form-group">
											<label>签到状态</label> <select class="form-control">
												<option id="checktrue">已签到</option>
												<option id="checkflase">未签到</option>
											</select>
										</div>
									</form>
								</div>


								<div class="modal-footer">
									<button type="button" class="btn btn-default closepanel"
										data-dismiss="modal">关闭</button>
									<button id="ajax-panel" type="button" class="btn btn-primary">保存修改</button>
								</div>
							</div>
						</div>
					</div>




				</div>
			</div>

			<!-- /. PAGE INNER  -->
		</div>

		<jsp:include page="footer.jsp"></jsp:include>