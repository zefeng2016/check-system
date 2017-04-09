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
					class="fa fa-dashboard"></i> 数据统计</a>
			</li>
			<li><a class="active-menu" href="<%=path%>/servlet/GetTdInfo"><i
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
			<div id="modelbg" class="modal-backdrop fade in"
				style="display: none;"></div>
			<!-- <div id="page-inner"> -->
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						企业管理 <small><a onclick="window.location.reload();" href=""
							title="">刷新</a> </small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">企业列表</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th style="display: none;">id</th>
											<th>摊位</th>
											<th>企业名称</th>
											<th>企业联系人</th>
											<th>电话</th>
											<th>签到状态</th>
										</tr>
									</thead>
									<tbody>
										<!--  <tr class="gradeA">
                                        <td class="1">A21</td>
                                        <td class="2">广东有限公司</td>
                                        <td class="3">郑泽丰</td>
                                        <td class="center 4">13106755097</td>
                                        <td class="center 5">已签到</td>
                                    </tr> -->
										<c:forEach items="${tdusers}" var="user">
											<tr class="gradeA">
												<td class="0" style="display: none;">${user.id}</td>
												<td class="1">${user.tdno}</td>
												<td class="2">${user.tdname}</td>
												<td class="3">${user.tduser }</td>
												<td class="4">${user.tdphone }</td>
												<td class="center 5">${user.tdcheck }</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!--End Advanced Tables -->
					<div class="panel panel-primary">
					<!-- 	<div class="panel-heading">企业信息</div> -->
				<!-- 		<div class="panel-body"> -->
							<div class="panel-group" id="accordion">
								<div class="panel panel-success">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo">企业信息</a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse in"
										style="height: auto;">
										<div class="panel-body">
											<div class="col-md-12 row">
												<div class="form-group col-md-2 col-xs-9 col-sm-4">
													<p style="display:none;" id="tdid">null</p>
													<label>摊位</label> <input id="fromtanwei"
														class="form-control col-md-10" id="disabledInput"
														type="text" placeholder="摊位">
												</div>
												<div class="form-group col-md-10 col-xs-9 col-sm-8">
													<label>企业名称</label> <input id="formname"
														class="form-control" placeholder="企业名称">
												</div>
												<div class="form-group col-md-3 col-xs-6 col-sm-3">
													<label>企业联系人</label> <input id="fromuser"
														class="form-control col-xs-6" placeholder="企业联系人">
												</div>
												<div class="form-group col-md-3 col-xs-6 col-sm-3">
													<label>企业电话</label> <input id="fromphone"
														class="form-control" placeholder="企业电话">
												</div>
												<div class="form-group col-md-3 col-xs-6 col-sm-3">
													<label>签到状态</label> <select id="fromcheck"
														class="form-control">
														<option id="checktrue">已签到</option>
														<option id="checkflase">未签到</option>
													</select>
												</div>
												<div class="form-group col-md-3 col-sm-3">
													<label>工作地址</label> <input id="fromlocal"
														class="form-control" placeholder="工作地址">
												</div>
												<div class="form-group col-md-12 col-xs-18 col-sm-12">
													<label>公司简介</label>
													<textarea id="fromintroduce" class="form-control"
														placeholder="公司介绍" rows="3"></textarea>
												</div>
												<button id="newpost" type="button"
													class="btn disabled btn-success col-md-1 col-sm-2 col-md-offset-6 col-sm-offset-2">新增岗位</button>
												<button id="newtd" type="button" style="margin-left: 8px;"
													class="btn btn-success  col-md-1 col-sm-2">新增企业</button>
												<button id="savetd" type="button" style="margin-left: 8px;"
													class="btn btn-primary col-md-2 col-sm-3 disabled">保存</button>
												<button id="deltd" type="button" style="margin-left: 8px;"
													class="btn btn-danger col-md-1 col-sm-2  col-md-offset-8 col-sm-offset-8 disabled">删除</button>
											</div>
										</div>
									</div>
									<div class="panel panel-success">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseThree" class="collapsed">岗位信息</a> <span
													id="isNewPost" style="display: none;">1</span>
											</h4>
										</div>
										<!-- Advanced Tables -->
										<div id="collapseThree" class="panel-collapse collapse">
											<div id="postgroud" class="panel-body">
												<div class="table-responsive">
													<table
														class="table table-striped table-bordered table-hover">
														<thead>
															<tr>
																<th style="display: none;">岗位ID</th>
																<th>岗位编号</th>
																<th>岗位名称</th>
																<th>招聘人数</th>
																<th>工资</th>
																<th>工作介绍</th>
															</tr>
														</thead>
														<tbody id="postlistBody">
															<tr class="gradeB">
																<td class='0' style="display: none;">-</td>
																<td class='1'>无</td>
																<td class='2'>——</td>
																<td class='3'>——</td>
																<td class='center 4'>——</td>
																<td class='center 5'>——</td>
															</tr>

														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- </div> -->
			<!-- 显示岗位面板 -->
			<!-- panle -->
			<div id="panel" class="modal fade " id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close closepanel"
								data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">岗位信息浏览</h4>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<span id="getPostID" style="display: none;"></span> <label>岗位编号</label>
									<input id="postnopanel" class="form-control "
										placeholder="岗位编号">
								</div>
								<div class="form-group">
									<label>岗位名称</label> <input id="postnamepanel"
										class="form-control" placeholder="岗位名称">
								</div>
								<div class="form-group">
									<label>工资</label> <input id="postwagespanel"
										class="form-control" placeholder="工资">
								</div>
								<div class="form-group">
									<label>人数</label> <input id="postnumpanel" type="number"
										class="form-control" placeholder="人数">
								</div>
								<div class="form-group">
									<label>工作介绍</label>
									<textarea id="postinfopanel" class="form-control"
										placeholder="工资介绍" rows="3"></textarea>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default closepanel"
								data-dismiss="modal">关闭</button>
							<button id="savepostpanel" type="button" class="btn btn-primary">保存</button>
							<button id="delpost" type="button" class="btn btn-danger">删除岗位</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 显示面板stop -->

			<jsp:include page="footer.jsp"></jsp:include>