<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>组管理</title>
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
    		$("#arrayconfigNode").addClass("active");
    	});
    </script>

	<div class="page-content">
    		<!-- Page Breadcrumb -->
    		<div class="page-breadcrumbs">
    			<ul class="breadcrumb">
    				<li><i class="fa fa-home"></i> <a href="#">Home</a></li>
    				<li><a href="#">组管理</a></li>
    				<li class="active">组配置</li>
    			</ul>
    		</div>
    		<!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">

            <div class="row" id="add" style="display: none">
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget">
                        <div class="widget-header header-small">
                            <span class="widget-caption" id="title">增加组</span>
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
                                                <label class="control-label">组名称:</label>
                                            </div>
                                            <div class=" databox-right ">
                                                <input name="arrayName" class="input-sm form-control validate[required]" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
                                        <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                 style="color: #000;">
                                                <label class="control-label">规则:</label>
                                            </div>
                                            <div class="databox-right ">
												<select name="ruleId" id="myRule" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
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
                                            <input type="button" id="sendButton" class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="addArraySubmit()"/>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
			<!-- /增加组-->

			<div class="row" id="edit" style="display: none">
				<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="widget">
						<div class="widget-header header-small">
							<span class="widget-caption" id="titleEdit">编辑组</span>
							<div class="widget-buttons">
								<a href="#" data-toggle="config"> <i
										class="fa fa-cog yellow"></i>
								</a> <a href="#" data-toggle="maximize"> <i
									class="fa fa-expand pink"></i>
							</a> <a href="#" data-toggle="collapse"> <i
									class="fa fa-minus blue"></i>
							</a> <a href="#" onclick="$('#edit').hide();"> <i
									class="fa fa-times darkorange"></i>
							</a>
							</div>
						</div>
						<div class="widget-body" style="padding-bottom: 0px;">
							<form id="editForm" method="post">
								<input class="input-sm form-control" name="id" id="myArrayId" type="hidden"/>
								<!-- line 1 -->
								<div class="row">
									<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;">
												<label class="control-label">组名称:</label>
											</div>
											<div class=" databox-right ">
												<input name="arrayName" id="myArray" class="input-sm form-control validate[required]" />
											</div>
										</div>
									</div>
									<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;">
												<label class="control-label">规则:</label>
											</div>
											<div class="databox-right ">
												<select name="ruleId" id="myEditRule" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
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
											<input type="button"  class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="editArraySubmit()"/>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- /编辑组-->

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
									<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right "
												 style="color: #000; text-align: right; height: 50px;">
												<label class="control-label">组名称:</label>
											</div>
											<div class="databox-right " style="height: 60px;">
												<input  class="input-sm form-control" name="arrayName" id="arrayName"/>
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
								<a href="javascript:showAddArray();" class="btn btn-blue shiny">添加组</a>
								<a href="javascript:showEditArray();" class="btn btn-palegreen shiny">编辑组</a>
							</div>
							<table id="table"></table>
						</div>
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
            url : "array/list",
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
                    field : 'arrayName'
                    ,title : '组名称'
                    ,valign : 'middle'
                    ,align : 'center'
                },
                {
                    field : 'ruleName'
                    ,title : '规则名称'
                    ,align : 'center'
                    ,valign : 'middle'
                },
                {
                    field : 'rule'
                    ,title : '规则内容'
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
                    field : 'lastUpdateTime'
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
                query:{arrayName:$('#arrayName').val()}
            });
        }
        function showAddArray(){
            $("#add").show();
        }
		function showEditArray() {
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

        function findRule(){
            $.ajax({
                type: "GET",
                url:  "rule/all",
                dataType: 'json',
                success: function(result){
                    if(result.code == 0){
                        $.each(result.data, function (index, units) {
                            $("#myRule").append("<option value="+units.id+">" + units.name + "</option>");
                            $("#myEditRule").append("<option value="+units.id+">" + units.name + "</option>");
                        });

                    }
                }
            });

		};


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

        $(function() {
            $("#addForm").validationEngine();
            findRule();
        });
	</script>

</body>
</html>
