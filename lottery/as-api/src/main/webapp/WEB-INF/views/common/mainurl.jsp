<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

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
			<!--Dashboard-->
			<li><a href="${doadmin}/index.html"> <i
					class="menu-icon glyphicon glyphicon-home"></i> <span
					class="menu-text"> 功能菜单 </span>
			</a></li>
			<shiro:hasPermission name="goods">
				<li id="goodsNode" class="node"><a href="#"
					class="menu-dropdown"> <i class="menu-icon fa fa-desktop"></i>
						<span class="menu-text">商品管理 </span> <i class="menu-expand"></i>
				</a>
					<ul class="submenu">
						<shiro:hasPermission name="goods/goods">
							<li id="goodsInfoNode"><a href="${doadmin}/goods/goods.html">
									<span class="menu-text">商品信息</span>
							</a></li>
						</shiro:hasPermission>
					</ul></li>
			</shiro:hasPermission>
			<%--<shiro:hasPermission name="order">--%>
				<%--<li id="orderNode" class="node"><a href="#"--%>
					<%--class="menu-dropdown"> <i class="menu-icon fa fa-desktop"></i>--%>
						<%--<span class="menu-text">订单管理 </span> <i class="menu-expand"></i>--%>
				<%--</a> <shiro:hasPermission name="order/order">--%>
						<%--<ul class="submenu">--%>
							<%--<li id="orderQNode"><a href="${doadmin}/order/order.html">--%>
									<%--<span class="menu-text">订单查询</span>--%>
							<%--</a></li>--%>
						<%--</ul>--%>
					<%--</shiro:hasPermission></li>--%>
			<%--</shiro:hasPermission>--%>
			<shiro:hasPermission name="profitShare">
				<li id="sailNode" class="node"><a href="#"
					class="menu-dropdown"> <i class="menu-icon fa fa-desktop"></i>
						<span class="menu-text">销售管理 </span> <i class="menu-expand"></i>
				</a>
					<ul class="submenu">
						<shiro:hasPermission name="profitShare/profitShare">
							<li id="profitShareNode"><a
								href="${doadmin}/profitShare/profitShare.html"> <span
									class="menu-text">分成统计</span></a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="profitShare/profitDetail">
							<li id="profitDetailNode"><a
								href="${doadmin}/profitShare/profitDetail.html"> <span
									class="menu-text">订单查询</span></a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="profitLog/profitLog">
							<li id="profitLogNode"><a
								href="${doadmin}/profitLog/profitLog.html"> <span
									class="menu-text">收益流水</span></a></li>
						</shiro:hasPermission>
					</ul></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="base">
				<li id="baseNode" class="node"><a href="#"
					class="menu-dropdown"> <i class="menu-icon fa fa-desktop"></i>
						<span class="menu-text">基础资料管理 </span> <i class="menu-expand"></i>
				</a>
					<ul class="submenu">
						<shiro:hasPermission name="channel/channel">
							<li id="channelNode"><a
								href="${doadmin}/channel/channel.html"> <span
									class="menu-text">渠道管理</span>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="profitRule/profitRule">
							<li id="profitRuleNode"><a
								href="${doadmin}/profitRule/profitRule.html"> <span
									class="menu-text">分成模式管理</span></a></li>
						</shiro:hasPermission>
					</ul></li>
			</shiro:hasPermission>
		</ul>
		<!-- /Sidebar Menu -->
	</div>
</div>
<script type="text/javascript">
	$('.node').click(function() {
		if ($(this).attr('class') === 'node active open') {
			$(this).attr('class', 'node');
		} else {
			$(this).attr('class', 'node active open');
		}

	});
</script>
<!-- /Page Sidebar -->