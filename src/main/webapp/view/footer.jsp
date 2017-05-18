<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ page isELIgnored="false"%>
</div>
<footer>
	<h4>
		Copyright &copy; 2016.<a>zhenzefeng</a> All rights reserved.
	</h4>
</footer>
</div>
<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- Bootstrap Js -->
<script src="<%=basePath%>view/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="<%=basePath%>view/assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script
	src="<%=basePath%>view/assets/js/dataTables/jquery.dataTables.js"></script>
<script
	src="<%=basePath%>view/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=62072052" charset="UTF-8"></script>

</body>
</html>