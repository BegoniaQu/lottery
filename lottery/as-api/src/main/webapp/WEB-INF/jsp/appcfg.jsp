<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>

</head>
<body >
    <script type="text/javascript">
    	$(function() {
    		//选中菜单节点
    		$("#appNode").addClass("active open");
    		$("#appconfigNode").addClass("active");
    	});
    </script>

	<div class="page-content">
    		<!-- Page Breadcrumb -->
    		<div class="page-breadcrumbs">
    			<ul class="breadcrumb">
    				<li><i class="fa fa-home"></i> <a href="#">Home</a></li>
    				<li><a href="#">APP管理</a></li>
    				<li class="active">APP配置</li>
    			</ul>
    		</div>
    		<!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">

        APP配置
		</div>
		<!-- /Page Body -->
	</div>



</body>
</html>
