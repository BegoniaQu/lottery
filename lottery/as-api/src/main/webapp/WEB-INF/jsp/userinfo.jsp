<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>账户信息</title>
<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body >
    <script type="text/javascript">
    	$(function() {
    		//选中菜单节点
    		$("#accountMgrNode").addClass("active open");
    		$("#accountInfoNode").addClass("active");
    	});
    </script>

	<div class="page-content">
        <!-- Page Breadcrumb -->
        <div class="page-breadcrumbs">
            <ul class="breadcrumb">
                <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
                <li><a href="#">账户管理</a></li>
                <li class="active">账户信息</li>
            </ul>
        </div>
        <!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
                <!-- 增加用户-->
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget">
                        <div class="widget-header header-small">
                            <span class="widget-caption" id="title">增加账户</span>
                            <div class="widget-buttons">
                                <a href="#" data-toggle="config"> <i
                                    class="fa fa-cog yellow"></i>
                                </a> <a href="#" data-toggle="maximize"> <i
                                    class="fa fa-expand pink"></i>
                                </a> <a href="#" data-toggle="collapse"> <i
                                    class="fa fa-minus blue"></i>
                                </a> <a href="#" onclick="$('#add').hide();"> <i
                                    class="fa fa-times darkorange"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body" style="padding-bottom: 0px;">
                            <form id="addForm" method="post">
                                <!-- line 1 -->
                                <div class="row">
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                        <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                style="color: #000;">
                                                <label class="control-label">手机号码:</label>
                                            </div>
                                            <div class=" databox-right ">
                                                <input name="phoneNum" class="input-sm form-control validate[custom[phone]] validate[required]" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
                                        <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                style="color: #000;">
                                                <label class="control-label">姓名:</label>
                                            </div>
                                            <div class="databox-right ">
                                                <input name="userName" class="input-sm form-control validate[required]"  />
                                            </div>
                                        </div>
                                    </div>
                                </div>

					            <div class="row">
                                        <div class="col-lg-6 col-md-8 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">角色:</label>
                                                </div>
                                                <div class=" databox-right ">
                                                    <select name="type" id="type" class="select-sm form-control validate[required]" >
                                                        <option value="">--请选择--</option>
                                                        <option value="1">管理员</option>
                                                        <option value="0">普通用户</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                            style="float: right; margin-right: 5px;">
                                            <div class="databox-left"
                                                style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                                <input type="button" id="sendButton" class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="addUserSubmit()"/>
                                            </div>
                                        </div>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <!-- /增加用户-->




            <div class="row">
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget">
                        <div class="widget-header header-small">
                            <span class="widget-caption">条件查询</span>

                            <div class="widget-buttons">
                                <a href="#" data-toggle="config"> <i
                                    class="fa fa-cog yellow"></i>
                                </a> <a href="#" data-toggle="maximize"> <i
                                    class="fa fa-expand pink"></i>
                                </a> <a href="#" data-toggle="collapse"> <i
                                    class="fa fa-minus blue"></i>
                                </a> <a href="#" data-toggle="dispose"> <i
                                    class="fa fa-times darkorange"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body" style="padding-bottom: 0px;">
                            <form id="form">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right "
                                            style="color: #000; text-align: right; height: 50px;">
                                            <label class="control-label">手机号码:</label>
                                        </div>
                                        <div class=" databox-right " style="height: 60px;">
                                            <input  class="input-sm form-control" name="phe" id="phe"
                                                placeholder="请输入号码 "/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            </form>
                            <div class="row">
                                <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                    style="float: right; margin-right: 5px;">
                                    <div class="databox-right"
                                        style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                        <input type="button" onclick="query();"
                                            class="btn btn-blue" value="查询" style="margin-right: 5px;" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-xs-12 col-md-12">
                    <div class="widget">
                        <div class="widget-header  with-footer">
                            <div class="widget-buttons">
                                <a href="#" data-toggle="maximize"> <i class="fa fa-expand"></i></a>
                                <a href="#" data-toggle="collapse"> <i class="fa fa-minus"></i></a>
                                <a href="#" data-toggle="dispose"> <i class="fa fa-times"></i></a>
                            </div>

                        </div>
                        <div class="widget-body">
                            <div id="toolbar">
                            <c:if test="${sessionScope.loginUser.admin == true}">
                                <a href="javascript:showAddUser();" class="btn btn-blue shiny">添加</a>
                                <a href="javascript:resetPwd();" class="btn btn-palegreen shiny">密码重置</a>
                            </c:if>
                            </div>
                            <table id="table"></table>
                        </div>
                    </div>
                </div>
            </div>
		</div>
		<!-- /Page Body -->
	</div>
   <!-- loading -->
     <script type="text/javascript">

        	$("#table").bootstrapTable({
            		url : "user/list",
            		search : false,
            		pagination : true,
            		showRefresh : true,
            		showToggle : true,
            		showColumns : true,
            		pagination : true,
            		pageSize : 10,
            		pageNumber : 1,
            		sidePagination: "server",
            		classes:'table table-hover table-striped table-bordered',
            		iconSize : "outline",
            		toolbar : "#toolbar",
            		columns : [
                            {    field : 'ck'
                                ,checkbox : true
                                ,align : 'center'
                                ,valign : 'middle'
                              },
                            {
                                 field : 'id'
                                ,title : 'ID'
                                ,width : 20
                                ,align : 'center'
                                ,valign : 'middle'
                            },
                            {
                                 field : 'username'
                                ,title : '姓名'
                                ,width : 20
                                ,align : 'center'
                            },
                            {
                                 field : 'phone'
                                ,title : '手机号码'
                                ,width : 20
                                ,align : 'center'
                            },
                            {
                                   field : 'role'
                                  ,title : '角色'
                                  ,width : 20
                                  ,align : 'center'
                              },
                              {
                                 field : 'operator'
                                ,title : '操作人'
                                ,width : 20
                                ,align : 'center'
                            },
                            {
                                   field : 'createTime'
                                  ,title : '操作时间'
                                  ,width : 20
                                  ,align : 'center'
                              }
                     ],
            		responseHandler: function(res) {
                                    return {
                                        "total": res.data.total,//总数
                                        "rows": res.data.page_list   //数据
                                     };
                                }
                                ,
            		icons : {
            			refresh : "glyphicon-repeat",
            			toggle : "glyphicon-list-alt",
            			columns : "glyphicon-list"
            		}
            	});

            	function query(){
                		$("#table").bootstrapTable('refresh',{
                			query:{phone:escape($('#phe').val())}
                		});
                }
                function showAddUser(){
                    $("#add").show();
                }
                function addUserSubmit(){
                    if($("#addForm").validationEngine('validate')){
                        $.ajax({
                            type: "POST",
                            url: 'user/add',
                            data:form2Json('addForm'),
                            dataType:'json',
                            success: function(result){
                                if(result.code == 0){
                                    $("#add").hide();
                                    TableRefresh('table');
                                     Notify('添加成功', 'top-right', '4000', 'success', 'fa-check', true);
                                }else{
                                     Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                                }
                            }
                        });
                    }
                }

                function resetPwd(){
                var ids = getSelections() + '';
                ids = ids.substring(0, ids.length - 1);
                    if(ids == '' || ids == null){
                        $alert('请选择一个账户');
                    }else{
                        $.ajax({
                                type: "GET",
                                url: 'pwd/reset',
                                data:'ids=' + ids,
                                dataType:'json',
                                success: function(result){
                                    if(result.code == 0){
                                         Notify('密码已重置', 'top-right', '4000', 'success', 'fa-check', true);
                                    }else{
                                         Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                                    }
                                }
                            });
                    }
                }
                function getSelections(){
                    return $.map($("#table").bootstrapTable('getSelections'), function (row) {return row.id + ','});
                }

           $(function() {
            $("#addForm").validationEngine();
          });
        </script>

</body>
</html>
