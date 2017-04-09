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
<title>学生签到</title>
<link rel="stylesheet" href="<%=basePath%>view/css/weui.css">
<link rel="stylesheet" href="<%=basePath%>view/css/weui.min.css">
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//是否本校显示切换
		$("#isSchool").change(function(event) {
			if ($("#isSchool").is(':checked')) {
				$("#xibu").show();
				$("#banji").show();
				$("#stuno").show();
				$("#school").hide();
			} else {
				$("#xibu").hide();
				$("#banji").hide();
				$("#stuno").hide();
				$("#school").show();
			}
		});
		//修改表单时清除报错
		$('input').bind('input propertychange', function() {
			$(this).parent().parent().removeClass('weui_cell_warn name')
		});

	});

	//显示头部报错信息
	function showerror(mag) {
		$("#fromerror").text(mag);
		$("#fromerror").css("display", "block");
		$("#fromerror").show().delay(800).slideUp("slow");
	}

	//表单验证
	function check(form) {
		if ($("#isSchool").is(':checked')) {
			if (form.stu_name.value == '') {
				$("#stuname").addClass('weui_cell_warn');
				$("#stuname").find('input').focus();
				showerror("姓名不能为空");
				return false;
			}
			if (form.stu_no.value == '') {
				$("#stuno").addClass('weui_cell_warn');
				$("#stuno").find('input').focus();
				showerror("学号不能为空");
				return false;
			}
		} else {
			if (form.stu_schoolname.value == "") {
				$("#school").addClass('weui_cell_warn');
				$("#school").find('input').focus();
				showerror("学校不能为空");
				return false;
			}
			if (form.stu_schoolname.value == "广东环境保护工程职业学院") {
				$("#school").addClass('weui_cell_warn');
				$("#school").find('input').focus();
				showerror("学校不能为本校");
				return false;
			}
			if (form.stu_name.value == '') {
				$("#stuname").addClass('weui_cell_warn');
				$("#stuname").find('input').focus();
				showerror("学校不能为本校");
				return false;
			}
			return true;
		}
	}
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
			<p class="weui_cells_tips">请根据班级信息进行填写</p>
		</div>
		<form action="<%=basePath%>servlet/PostStuLogin" method="post">
			<div class="weui_cells_title">录入信息后点击签到</div>
			<div class="weui_cells weui_cells_form">
				<div id="fromerror" class="weui_toptips weui_warn js_tooltips"
					style="display:none;">信息错误</div>
				<div id="school_checkbox" class="weui_cells weui_cells_checkbox">
					<label class="weui_cell weui_check_label">
						<div class="weui_cell_hd">
							<input id="isSchool" type="checkbox" class="weui_check"
								name="checkbox" checked="true"> <i
								class="weui_icon_checked"></i>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<p>本校学生</p>
						</div>
					</label>
				</div>
				<div class="weui_cells weui_cells_form">
					<div id="xibu"
						class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" class="weui-label">系部</label>
						</div>
						<div class="weui-cell__bd">
							<select id="xibu_select" class="weui-select" name="stu_xibu">

							</select>
						</div>
					</div>

					<div id="banji"
						class="weui-cell weui-cell_select weui-cell_select-after">
						<div class="weui-cell__hd">
							<label for="" id="clazz" class="weui-label">班级</label>
						</div>
						<div class="weui-cell__bd">
							<select id="banji_select" class="weui-select" name="stu_banji">
							</select>
						</div>
					</div>
					<div id="school" class="weui_cell" style="display: none;">
						<div class="weui_cell_hd">
							<label class="weui_label">学校</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="text" name="stu_schoolname"
								value="广东环境保护工程职业学院" placeholder="请输入学校">
						</div>
						<div class="weui_cell_ft">
							<i class="weui_icon_warn"></i>
						</div>
					</div>
					<div id="stuname" class="weui_cell">
						<div class="weui_cell_hd">
							<label class="weui_label">姓名</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="text" name="stu_name"
								placeholder="请输入姓名">
						</div>
						<div class="weui_cell_ft">
							<i class="weui_icon_warn"></i>
						</div>
					</div>
					<div id="stuno" class="weui_cell">
						<div class="weui_cell_hd">
							<label class="weui_label">学号</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="number" name="stu_no"
								placeholder="请输入学号">
						</div>
						<div class="weui_cell_ft">
							<i class="weui_icon_warn"></i>
						</div>
					</div>
				</div>
			</div>
			<div class="weui_btn_area">
				<button id="showTooltips" name="Button1" value="" type="submit"
					onclick="return check(this.form)" class="weui_btn weui_btn_primary">签到</button>
			</div>

		</form>
		<div class="weui_msg">
			<div class="weui_extra_area">
				<a href="">©招生就业办 Designed by zefeng</a>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			var jsonStr = '${DcJSON}';
			var json = $.parseJSON(jsonStr);
			var $xibu_select = $('#xibu_select');
			var $banji_select = $('#banji_select');
			//初始化系
			$.each(json, function(i, item) {
				var opt = new Option(item.name, item.id);
				$(opt).attr('data-index', i);
				$xibu_select.append(opt);
			});

			$xibu_select.change(function() {
				var $this = $(this);
				var index = $this.find('option:selected').attr('data-index');
				$banji_select.html('');
				$.each(json[index].classes, function(i, item) {
					var opt = new Option(item.name, item.id);
					$banji_select.append(opt);
				});
			});

			$xibu_select.trigger('change');//触发默认选中
		});
	</script>
</body>
</html>