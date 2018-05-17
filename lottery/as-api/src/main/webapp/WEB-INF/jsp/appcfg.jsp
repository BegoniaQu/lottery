<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>
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
				<li class="active">APP信息</li>
			</ul>
		</div>
		<!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">
			<div class="row">
				<div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
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
									<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right "
												 style="color: #000; text-align: right; height: 50px;">
												<label class="control-label">APPID:</label>
											</div>
											<div class="databox-right " style="height: 60px;">
												<input  class="input-sm form-control" id="q_appId"/>
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right "
												 style="color: #000; text-align: right; height: 50px;">
												<label class="control-label">组:</label>
											</div>
											<div class="databox-right " style="height: 60px;">
												<select  id="q_arrayId" class="select-sm form-control" >
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right "
												 style="color: #000; text-align: right; height: 50px;">
												<label class="control-label">分类:</label>
											</div>
											<div class="databox-right " style="height: 60px;">
												<select  id="q_categoryId" class="select-sm form-control" >
													<option value="">--请选择--</option>
												</select>
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
								<a href="javascript:showAddAPP();" class="btn btn-blue shiny">添加APP</a>
								<a href="javascript:showEditAPP();" class="btn btn-palegreen shiny">编辑APP</a>
							</div>
							<table id="table"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /Page Body -->
	<!-- loading -->
	<script type="text/javascript">

        $("#table").bootstrapTable({
            url : "appbase/list",
            search : false,
            pagination : true,
            showRefresh : true,
            showToggle : true,
            showColumns : true,
            pagination : true,
            pageSize : 10,
            pageNumber : 1,
            singleSelect : true,
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
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'appId'
                    ,title : 'APPID'
                    ,valign : 'middle'
                    ,align : 'center'
                },
                {
                    field : 'appName'
                    ,title : '名称'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'arrayName'
                    ,title : '所属组'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'categoryName'
                    ,title : '所属分类'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'announceContent'
                    ,title : '公告'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'homePageUrl'
                    ,title : '首页图片'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'operator'
                    ,title : '操作人'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'operateTime'
                    ,title : '操作时间'
                    ,align : 'center'
                    ,valign : 'middle'
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
                query:{appId:$('#q_appId').val(), arrayId:$('#q_arrayId').val(), categoryId:$('#q_categoryId').val()}
            });
        }
        function showAddAPP(){
            $("#add").show();
        }
        function showEditAPP() {
            $("#editForm").validationEngine();
            var id = getSelection();
            if(id == null){
                $alert("请选择一条记录");return;
            }
            $.ajax({
                type: "GET",
                url: 'array/show?id=' + id,
                dataType:'json',
                success: function(result){
                    if(result.code == 0){
                        $("#myArray").val(result.data.arrayName);
                        $("#myEditRule").val(result.data.ruleId);
                        $("#myArrayId").val(result.data.id);
                        $("#edit").show();
                    }else{
                        Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                    }
                }
            });
        }

        function addArraySubmit(){
            if($("#addForm").validationEngine('validate')){
                $.ajax({
                    type: "POST",
                    url: 'array/add',
                    data:form2Json('addForm'),
                    dataType:'json',
                    success: function(result){
                        if(result.code == 0){
                            document.getElementById("addForm").reset();
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

        function editArraySubmit(){
            if($("#editForm").validationEngine('validate')){
                $.ajax({
                    type: "POST",
                    url: 'array/edit',
                    data:form2Json('editForm'),
                    dataType:'json',
                    success: function(result){
                        if(result.code == 0){
                            document.getElementById("editForm").reset();
                            $("#edit").hide();
                            TableRefresh('table');
                            Notify('更新成功', 'top-right', '4000', 'success', 'fa-check', true);
                        }else{
                            Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                        }
                    }
                });
            }
        }

        function getSelection(){
            var selections = $("#table").bootstrapTable('getSelections');
            if(selections == null || selections == ''){
                return null;
            }
            return selections[0].id;
        }

        function findArrayAll(){
            $.ajax({
                type: "GET",
                url:  "array/all",
                dataType: 'json',
                success: function(result){
                    if(result.code == 0){
                        $.each(result.data, function (index, units) {
                            $("#q_arrayId").append("<option value="+units.id+">" + units.name + "</option>");
                        });

                    }
                }
            });
        };
        function findCategoryAll(){
            $.ajax({
                type: "GET",
                url:  "category/all",
                dataType: 'json',
                success: function(result){
                    if(result.code == 0){
                        $.each(result.data, function (index, units) {
                            $("#q_categoryId").append("<option value="+units.id+">" + units.name + "</option>");
                        });

                    }
                }
            });
        };

        $(function() {
            findArrayAll();
            findCategoryAll();
            $("#addForm").validationEngine();

        });
	</script>

</body>
</html>
