<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
<meta charset="utf-8" />
<title><sitemesh:write property="title" /></title>

<meta name="description" content="Dashboard" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" />-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${doadmin}/static/bootstrap/assets/img/favicon.png" type="image/x-icon">

<!--Basic Styles-->
<link href="${doadmin}/static/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${doadmin}/static/bootstrap/assets/css/font-awesome.min.css" rel="stylesheet" />
<link href="${doadmin}/static/bootstrap/assets/css/weather-icons.min.css" rel="stylesheet" />
<!--Fonts-->
<!--
<link href="${doadmin}/static/bootstrap/assets/css/skins/azure.min.css" rel="stylesheet" />
-->
<!--Beyond styles-->
<link href="${doadmin}/static/bootstrap/assets/css/beyond.min.css" rel="stylesheet" />
<link href="${doadmin}/static/bootstrap/assets/css/demo.min.css" rel="stylesheet" />
<link href="${doadmin}/static/bootstrap/assets/css/typicons.min.css" rel="stylesheet" />
<link href="${doadmin}/static/bootstrap/assets/css/animate.min.css" rel="stylesheet" />
<!-- 验证样式 -->
<link rel="stylesheet" href="${doadmin}/static/bootstrap/css/validate/validationEngine.jquery.css" type="text/css" />

<!--<script src="${doadmin}/static/bootstrap/js/common/jquery.min.js?v=2.1.4"></script>-->

<!--Beyond Scripts-->
<script src="${doadmin}/static/bootstrap/assets/js/skins.min.js"></script>
<!--Basic Scripts-->
<script src="${doadmin}/static/bootstrap/assets/js/jquery-2.0.3.min.js"></script>
<script src="${doadmin}/static/bootstrap/assets/js/bootstrap.min.js"></script>
<script src="${doadmin}/static/bootstrap/assets/js/beyond.min.js"></script>
<script src="${doadmin}/static/bootstrap/assets/js/bootbox/bootbox.js"></script>

<script src="${doadmin}/static/bootstrap/assets/js/toastr/toastr.js"></script>

<!-- alert -->
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/common/common.js"></script>
<!--
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/common/jquery.pager.js"></script>
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/common/formart.js"></script>
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/common/jquery_time.js"></script>
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/common/jquery-form.js"></script>
-->
<!--My97-->
<script type="text/javascript" src="${doadmin}/static/bootstrap/My97DatePicker/WdatePicker.js"></script>

<!-- 验证 -->
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${doadmin}/static/bootstrap/js/validate/jquery.validationEngine-zh_CN.js"></script>

<!--
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
-->

<sitemesh:write property="head" />

</head>
<!-- /Head -->
<!-- Body -->
<body>
	<!-- Loading Container -->
	<div class="loading-container">
		<div class="loading-progress">
			<div class="rotator">
				<div class="rotator">
					<div class="rotator colored">
						<div class="rotator">
							<div class="rotator colored">
								<div class="rotator colored"></div>
								<div class="rotator"></div>
							</div>
							<div class="rotator colored"></div>
						</div>
						<div class="rotator"></div>
					</div>
					<div class="rotator"></div>
				</div>
				<div class="rotator"></div>
			</div>
			<div class="rotator"></div>
		</div>
	</div>

	<!--  /Loading Container -->
	<!-- Navbar -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="navbar-container">
				<!-- Navbar Barnd-->
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<img src="${doadmin}/static/bootstrap/assets/img/logo.png" alt="" />
						</small>
					</a>
				</div>

				<!-- /Navbar Barnd -->

				<!-- Sidebar Collapse -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="collapse-icon fa fa-bars"></i>
				</div>

				<!-- /Sidebar Collapse -->
				<!-- Account Area and Settings --->
				<div class="navbar-header pull-right">
					<div class="navbar-account">
						<ul class="account-area">
							<li>
							<a class="login-area dropdown-toggle" data-toggle="dropdown">
                                <div class="avatar" title="系统图标" style="border-left: 0;">
                                    <img src="${doadmin}/static/bootstrap/assets/img/cat.png">
                                </div>
                                <section>
                                    <h2>
                                        <span class="profile"><span>Hi: ${sessionScope.loginUser.userName}</span></span>
                                    </h2>
                                </section>
							</a>
							<!--Login Area Dropdown-->
                            <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                <li class="email"><a>
                                        </a></li>
                                <!--Avatar Area-->
                                <li>
                                    <div class="avatar-area">
                                        <img
                                            src="${doadmin}/static/bootstrap/assets/img/avatars/Stephanie-Walter.jpg"
                                            class="avatar">
                                    </div>
                                </li>
                                <!--/Theme Selector Area-->
                                <li class="dropdown-footer"><a href="exit"> 退出 </a></li>
                            </ul>
                            <a style="float:right;margin-top:5px;height:35px;" href="javascript:void(0);" class="btn btn-azure" id="editBtn">修改密码</a>
                            <!--/Login Area Dropdown-->
                            </li>

							<!-- /Account Area -->
							<!--Note: notice that setting div must start right after account area list.
                            no space must be between these elements-->
							<!-- Settings -->
						</ul>
						<!-- Settings -->
					</div>
				</div>
				<!-- /Account Area and Settings -->
			</div>
		</div>
	</div>
	<!-- /Navbar -->
	<!-- Main Container -->
	<div class="main-container container-fluid">
		<!-- Page Container -->
		<div class="page-container">
			<!-- Page Sidebar -->
			<div class="page-sidebar" id="sidebar">
				<!-- Page Sidebar Header-->
				<div class="sidebar-header-wrapper">
					<input type="text" class="searchinput" /> <i
						class="searchicon fa fa-search"></i>
					<div class="searchhelper">搜索您想点击的目标</div>
				</div>
				<!-- /Page Sidebar Header -->
				<!-- Sidebar Menu -->
				<ul class="nav sidebar-menu" id="menu">
					<li>
						<a href="#"> <i class="menu-icon glyphicon glyphicon-home"></i>
							<span class="menu-text"> 功能菜单 </span>
						</a>
					</li>

					<li id="accountMgrNode" class="node">
						<a href="#" class="menu-dropdown">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">账户管理 </span>
							<i class="menu-expand"></i>
						</a>
						<ul class="submenu">
							<li id="accountInfoNode">
								<a href="/mgr/userinfo.html">
									<span class="menu-text">账户信息</span>
								</a>
							</li>
						</ul>
					</li>
					<li id="appNode" class="node">
						<a href="#" class="menu-dropdown">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">APP管理</span>
							<i class="menu-expand"></i>
						</a>
						<ul class="submenu">
						    <li id="awardNode"><a href="/mgr/award.html"> <span class="menu-text">开奖信息</span></a></li>
							<li id="appconfigNode"><a href="/mgr/appcfg.html"> <span class="menu-text">APP配置</span></a></li>
							<li id="sxNode"><a href="/mgr/sxcfg.html"> <span class="menu-text">生肖信息</span></a></li>
							<li id="lhtjNode"><a href="/mgr/recommend.html"> <span class="menu-text">六合推荐</span></a></li>
							<li id="xjjnNode"><a href="/mgr/brocadesac.html"> <span class="menu-text">玄机锦囊</span></a></li>
						</ul>
					</li>
				</ul>
				<!-- /Sidebar Menu -->
			</div>
		</div>
		<!-- /Page Sidebar -->
		<!-- Page Content -->
		<sitemesh:write property="body" />
		<!-- /Page Content -->
	</div>
	<!-- /Page Container -->
	<!-- Main Container -->
</body>
<!--  /Body -->
<script type="text/javascript">
	$('.node').click(function() {
		if ($(this).attr('class') == 'node active open') {
			$(this).attr('class', 'node');
		} else {
			$(this).attr('class', 'node active open');
		}

	});

	$("#editBtn").on('click', function () {
                bootbox.prompt("请输入新密码", function (result) {
                    if (result === null) {
                    } else {
                        $.ajax({
                                type: "GET",
                                url: '/mgr/pwd/edit',
                                data: "pwd=" + result,
                                dataType:'json',
                                success: function(result){
                                    if(result.code == 0){
                                        Notify('修改成功', 'top-right', '4000', 'success', 'fa-check', true);
                                    }else{
                                        Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true)
                                    }

                                }
                            });
                    }
                });
            });
</script>

</html>
