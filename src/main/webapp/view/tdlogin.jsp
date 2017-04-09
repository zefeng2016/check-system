<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>企业签到</title>
<link rel="stylesheet" href="css/weui.css">
<link rel="stylesheet" href="css/weui.min.css">
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">

		$(document).ready(function(){
			//修改表单时清除报错
			$('input').bind('input propertychange', function() { 
				$(this).parent().parent().removeClass('weui_cell_warn name')
			});
		});
		//显示头部报错信息
		function showerror(mag){
			$("#fromerror").text(mag);
			$("#fromerror").css("display","block");
			$("#fromerror").show().delay(800).slideUp("slow");
		}
		//表单验证
		function check(form){
			if(form.td_name.value=='') {
				$("#tdname").addClass('weui_cell_warn');
				$("#tdname").find('input').focus();
				showerror("姓名不能为空");
				return false;
			}
			if(form.td_phone.value=='') {
				$("#tdphone").addClass('weui_cell_warn');
				$("#tdphone").find('input').focus();
				showerror("电话不能为空");
				return false;
			}
			return true;

		}


	</script>
</head>
<body class="container">
	<div class="page">
		<div class="weui_panel_hd ">
			<h1 class="weui_cells_title">签到</h1>
			<p class="weui_cells_tips">请根据企业信息进行填写</p>
		</div>
		<form action="<%=basePath%>/" method="post">
			<!-- <form action="http://113.107.254.7/default2.aspx"  method="post"> -->

			<div class="weui_cells_title">录入信息后点击签到</div>

			<div class="weui_cells weui_cells_form">
				<div id="fromerror" class="weui_toptips weui_warn js_tooltips"
					style="display:none;">信息错误</div>

				<div class="weui_cells weui_cells_form">

					<div id="tdname" class="weui_cell">
						<div class="weui_cell_hd">
							<label class="weui_label">姓名</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="text" name="td_name"
								placeholder="请输入姓名">
						</div>
						<div class="weui_cell_ft">
							<i class="weui_icon_warn"></i>
						</div>
					</div>
					<div id="tdphone" class="weui_cell">
						<div class="weui_cell_hd">
							<label class="weui_label">电话</label>
						</div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="text" name="td_phone"
								placeholder="请输入电话">
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
	</div>
</body>
</html>