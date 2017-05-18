<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>${requestScope.error.pagetitel}</title>
<link rel="stylesheet" href=" <%=basePath%>view/css/weui.css">
<link rel="stylesheet" href=" <%=basePath%>view/css/weui.min.css">
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript">
	function goback() {
		history.back();
	}

	$(document).ready(function() {
		window.setTimeout("goback()", 4000);

	});
</script>
</head>
<body>
	<div class="weui_msg">
		<div class="weui_icon_area">
			<i class="weui_icon_msg weui_icon_warn"></i>
		</div>
		<div class="weui_text_area">
			<h2 class="weui_msg_title">${requestScope.error.errortitle}</h2>
			<p class="weui_msg_desc">${requestScope.error.errorinfo}(${requestScope.error.errornum})</p>
		</div>
		<div class="weui_opr_area">
			<p class="weui_btn_area">
				<a id="btn" href="javascript:history.go(-1)"
					class="weui_btn weui_btn_primary">确定</a>
			</p>
		</div>
		<div class="weui_extra_area">
			<a href="">©招生就业办</a>
		</div>
	</div>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=62072052" charset="UTF-8"></script>

</body>
</html>