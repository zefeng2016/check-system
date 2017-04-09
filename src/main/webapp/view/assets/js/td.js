
$(document).ready(function() {
	//展开企业信息面板
	function showTdPanel() {
		$("#collapseTwo").addClass('in');
		$("#collapseTwo").attr('height', 'auto');
	}
	// 展开岗位信息面板
	function showPostPanel() {
		$("#collapseThree").addClass('in');
		$("#collapseThree").attr('height', 'auto');
	}
	// 获取企业岗位列表
	function getPostList(id) {
		showPostPanel();
		$
		.ajax(
		{
			type : "get",
			url : url + "servlet/GetPostList",
			data : {
				"tdid" : id
			},
			success : function(msg) {
				if (msg == "null") {
					alert("获取岗位列表失败");
				} else {
					var postlist = jQuery.parseJSON(msg);
					var post = postlist.postlist;
					var $tbody = $("#postlistBody");
					$tbody.html('');
					if (post.length != 0) {
						for ( var i = 0; i < post.length; i++) {
							var a = "<tr class='gradeB'><td class= '0' style='display: none;'>"
							+ post[i].id
							+ "</td><td class= '1'>"
							+ post[i].postno
							+ "</td><td class='2'>"
							+ post[i].postname
							+ "</td><td class='3'>"
							+ post[i].postnum
							+ "</td><td class='center 4'>"
							+ post[i].postwages
							+ "</td><td class='center 5'>"
							+ post[i].postjob
							+ "</td></tr>"
							$tbody.append(a);
						}
					} else {
						var b = "<tr class='gradeB'><td class= '0' style='display: none;'>-</td><td class= '1'>无</td><td class='2'>——</td><td class='3'>——</td><td class='center 4'>——</td><td class='center 5'>——</td></tr>"
						$tbody.append(b);
					}
				}
			}
		}).fail(function() {
			alert("获取岗位列表失败");
		});
	}

	// 显示隐藏岗位对话框
	function showpanel() {
		$("#panel").css("display", "block");
		$("#panel").attr("aria-hidden", "flase");
		$("body").addClass('modal-open');
		$("#panel").addClass('in')
		$("#modelbg").css('display', 'block');
	}
	function hidepanel() {
		$("#panel").css("display", "none");
		$("#panel").attr("aria-hidden", "true");
		$("body").removeClass('modal-open');
		$("#panel").removeClass('in');
		$("#modelbg").css('display', 'none');
	}
	// 关闭面板
	$(".closepanel").click(function(event) {
		hidepanel();

	});

	// 点击岗位列表，显示岗位面板
	$('#postlistBody').on('click', '.gradeB', function() {
		$("#isNewPost").text("0");
		var id = $(this).children('td.0').text();
		var postno = $(this).children('td.1').text();
		var postname = $(this).children('td.2').text();
		var postnum = $(this).children('td.3').text();
		var postwages = $(this).children('td.4').text();
		var job = $(this).children('td.5').text();
		$("#getPostID").text(id);
		$("#postnopanel").val(postno);
		$("#postnamepanel").val(postname);
		$("#postwagespanel").val(postwages);
		$("#postnumpanel").val(postnum);
		$("#postinfopanel").val(job);
		$("#delpost").removeClass('disabled');
		showpanel();

	})

	// 点击更新企业信息面板数据
	$(".gradeA").click(function(event) {
		var id = $(this).children('td.0').text();
		var tdtanwei = $(this).children('td.1').text();
		var tdname = $(this).children('td.2').text();
		var tduser = $(this).children('td.3').text();
		var tdphone = $(this).children('td.4').text();
		var tdcheck = $(this).children('td.5').text();
		$("#tdid").text(id);
		$("#fromtanwei").val(tdtanwei);
		$("#formname").val(tdname);
		$("#fromuser").val(tduser);
		$("#fromphone").val(tdphone);
		$("#fromintroduce").val("获取企业简介,请稍后");
		if (tdcheck == "已签到") {
			$("#checktrue").attr("selected", "true");
			$("#checkflase").removeAttr('selected');
		} else {
			$("#checkflase").attr("selected", "true");
			$("#checktrue").removeAttr('selected');
		}
		$.ajax({
			type : "get",
			url : url + "servlet/GetTdIntroduce",
			data : {
				"id" : id
			},
			success : function(msg) {
				if (msg == "null") {
					$("#fromintroduce").val("获取企业简介失败");
				} else {
					var obj = jQuery.parseJSON(msg);
					$("#fromintroduce").val(obj.user.introduce);
					$("#fromlocal").val(obj.user.local);
				}
			}
		}).fail(function() {
			$("#fromintroduce").val("获取企业简介失败");
		});
		showTdPanel();
		showPostPanel();
		getPostList(id);
		$("#savetd").removeClass('disabled');
		$("#deltd").removeClass('disabled');
		$("#newpost").removeClass('disabled');
	});

	// 新增岗位
	$("#newpost").click(function(event) {
		$("#delpost").addClass('disabled');
		$("#isNewPost").text("1");
		if ($("#tdid").text() != "00") {
			$("#postnopanel").val("");
			$("#postnamepanel").val("");
			$("#postwagespanel").val("");
			$("#postnumpanel").val("");
			$("#postinfopanel").val("");
			showpanel();
			$("#delpost").addClass('disabled');
		} else {
			alert("无法获取企业ID，请查看是否选择企业,或先保存新增企业");
		}
	});

	// 保存岗位
	$("#savepostpanel").click(function(event) {
		if ($("#fromtanwei").val() != "") {
			$.ajax({
				type : "POST",
				url : url + "servlet/PostNewPost",
				data : {
					"isNewPost" : $("#isNewPost").text(),
					"postID" : $("#getPostID").text(),
					"tdno" : $("#tdid").text(),
					"postno" : $("#postnopanel").val(),
					"postname" : $("#postnamepanel").val(),
					"postwages" : $("#postwagespanel").val(),
					"postnum" : $("#postnumpanel").val(),
					"postjob" : $("#postinfopanel").val()
				},
				success : function(msg) {
					if (msg == "success") {
						alert("保存成功");
						showpanel();
						getPostList($("#tdid").text());
						$("#delpost").removeClass('disabled');
					} else {
						alert("保存失败")
					}
				}
			}).fail(function() {
				alert("网络错误");

			});
		} else {
			alert("无法获取企业ID，请查看企业信息表单里面有没有信息");
		}
	});

	// 删除岗位
	$("#delpost").click(function(event) {

		var postid = $("#getPostID").text();
		$.ajax({
			type : "POST",
			url : url + "servlet/PostDelPost",
			data : "postid=" + postid,
			success : function(msg) {
				if (msg == "success") {
					alert("删除成功");
					getPostList($("#tdid").text());
					hidepanel();
				} else {
					alert("删除失败");
				}
			}
		}).fail(function() {
			alert("网络错误");
		});
		
	});

	// 新增企业
	$("#newtd").click(function(event) {
		alert("请在企业信息表格上填写相关信息");
		$("#tdid").text("00");
		$("#fromtanwei").val("");
		$("#formname").val("");
		$("#fromuser").val("");
		$("#fromphone").val("");
		$("#fromlocal").val("");
		$("#fromintroduce").val("");
		$("#savetd").removeClass('disabled');
		$("#deltd").removeClass('disabled');
		$("#newpost").removeClass('disabled');
		var $tbody = $("#postlistBody");
		$tbody.html('');
	});

	// 保存企业信息
	$("#savetd").click(function(event) {
		if ($("#tdid").text() != "") {
			var id = $("#tdid").text();
			var tanwei = $("#fromtanwei").val();
			var name = $("#formname").val();
			var user = $("#fromuser").val();
			var phone = $("#fromphone").val();
			var local = $("#fromlocal").val();
			var introduce = $("#fromintroduce").val();
			var checkinfo = $("#fromcheck option:selected").text();

			$.ajax({
				type : 'POST',
				datetype : 'text',
				url : url + 'servlet/postSaveTdInfo',
				data : {
					"tdid" : id,
					"tangwei" : tanwei,
					"name" : name,
					"user" : user,
					"phone" : phone,
					"local" : local,
					"checkinfo" : checkinfo,
					"introduce" : introduce
				},

				success : function(msg) {
					if (msg == "error") {
						alert("保存失败！");
					} else {
						if ($("#tdid").text() == "00") {
							$("#tdid").text(msg);
							alert("保存成功！");
						} else {
							alert("保存成功！");
						}

					}
				}
			}).fail(function() {
				alert("网络错误");
			});
		} else {
			alert("请选择一个企业后进行删除!");
		}

	});

	// 删除企业
	$("#deltd").click(function(event) {
		var id = $("#tdid").text();
		if ($("#fromtanwei").val() != "") {
			$.ajax({
				url : url + "servlet/PostDelTd",
				type : 'POST',
				data : {
					"tdid" : id
				},
				success : function(msg) {
					if (msg == "success") {
						alert("删除成功！");
						window.location.reload();

					} else {
						alert("数据库写入失败，请重试！")
					}
				}
			}).fail(function() {
				alert("网络错误");
			});
		} else {
			alert("未选择企业！");
		}

	});
	

	$("#myinfo").click(function(event) {
		$.ajax(
			{
				type : "get",
				url : url + "servlet/GetAdminInfo",
				
				success : function(msg) {
					if (msg == "null") {
						alert("获取我的信息失败");
					} else {
						alert("欢迎您："+msg);
					}
				}
			}).fail(function() {
				alert("网络错误");
			});
	});
	
	
	//修改账户信息
	$("#save_admin").click(function(event) {
		var admin_name = $("#admin_name").attr("value");
		var admin_username = $("#admin_username").attr("value");
		var admin_password = $("#admin_password").attr("value");
		var admin_againpassword = $("#admin_againpassword").attr("value");

		if ((admin_password != admin_againpassword)||admin_password == '') {
			alert("密码为空或者两次密码输入不一致！");
		}else{
			$.ajax({
				url : url + "servlet/GetSetting",
				type : 'POST',
				data : {
					"admin_username" : admin_username,
					"admin_name" : admin_name,
					"admin_password" : admin_password
				},
				success : function(msg) {
					if (msg == "success") {
						alert("修改成功");
						window.location.reload();

					} else {
						alert("数据库写入失败，请重试！")
					}
				}
			}).fail(function() {
				alert("网络错误");
			});
		} 

	});
	
});
