<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>APP管理</title>
	<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
	<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">
	<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
	<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
	<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<link href="${doadmin}/static/bootstrap/fileupload/fileinput.css" rel="stylesheet">
	<script src="${doadmin}/static/bootstrap/fileupload/fileinput.js"></script>
	<script src="${doadmin}/static/bootstrap/fileupload/fileinput_zh.js"></script>

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
			<!-- 图片上传-->
			<div class="modal modal-primary fade" id="imgModal" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title">图片上传</h4>
						</div>
						<div class="modal-body">
							<input type="file" id="myImg" name="file"/>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" onclick="closeModal()">取消</button>
							<button type="button" class="btn btn-default" onclick="imgOk()">完成</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			<!-- /图片上传-->

			<!-- 增加分类-->
			<div class="modal modal-primary fade" id="categoryModal" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title">新增分类</h4>
						</div>
						<div class="modal-body">
							<form action="" method="post" id="cateForm">
								<div class="row">
									<div class="col-lg-6 col-sm-6 col-xs-6">
										<div class="databox" style="margin-bottom: 0px;height: 50px;">
											<div class="databox-left no-padding-right "
												 style="color: #000; text-align: left; height: 50px;width:50px;">
												<label class="control-label">名称:</label>
											</div>
											<div class="databox-right " style="height: 50px;">
												<input name="name" id="myCategoryName" class="input-sm form-control validate[required]" />
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-default" onclick="addCategory()">确定</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			<!-- /增加分类-->

			<!-- 增加APP-->
			<div class="row" id="add" style="display: none">
				<div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
					<div class="widget">
						<div class="widget-header header-small">
							<span class="widget-caption" id="title">增加APP</span>
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
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">APPID:</label>
											</div>
											<div class=" databox-right ">
												<input name="appId" class="input-sm form-control validate[required]" />
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">app名称:</label>
											</div>
											<div class="databox-right ">
												<input name="appName" class="input-sm form-control" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">组:</label>
											</div>
											<div class=" databox-right ">
												<select id="a_arrayId" name="arrayId" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">分类:</label>
											</div>
											<div class="databox-right ">
												<select id="a_categoryId" name="categoryId" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">首图:</label>
											</div>
											<div class=" databox-right ">
												<input class="input-sm form-control validate[required]" id="imgPath" name="homePageUrl" placeholder="图片地址" style="width:80%;float:left;"/>
												<a href="#" class="btn btn-yellow shiny" data-toggle="modal" data-target="#imgModal" style="float:right;width:20%;height:30px;">上传</a>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">公告:</label>
											</div>
											<div class=" databox-right ">
												<textarea class="form-control" rows="1" name="announceCtn"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
										 style="float: right; margin-right: 5px;">
										<div class="databox-left"
											 style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
											<input type="button"  class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="addAppSubmit()"/>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!--/增加APP-->
			<!--编辑APP-->
			<div class="row" id="edit" style="display: none">
				<div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
					<div class="widget">
						<div class="widget-header header-small">
							<span class="widget-caption" id="edittitle">编辑APP</span>
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
								<input class="input-sm form-control" name="id" id="myAppPId" type="hidden"/>
								<!-- line 1 -->
								<div class="row">
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">APPID:</label>
											</div>
											<div class=" databox-right ">
												<input id="myAppId" name="appId" class="input-sm form-control validate[required]" />
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">app名称:</label>
											</div>
											<div class="databox-right ">
												<input id="myAppName" name="appName" class="input-sm form-control" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">组:</label>
											</div>
											<div class=" databox-right ">
												<select id="e_arrayId" name="arrayId" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">分类:</label>
											</div>
											<div class="databox-right ">
												<select id="e_categoryId" name="categoryId" class="select-sm form-control validate[required]" style="height: 30px;">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">首图:</label>
											</div>
											<div class=" databox-right ">
												<input class="input-sm form-control validate[required]" id="e_imgPath" name="homePageUrl" placeholder="图片地址" style="width:80%;float:left;"/>
												<a href="#" class="btn btn-yellow shiny" data-toggle="modal" data-target="#imgModal" style="float:right;width:20%;height:30px;">上传</a>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
										<div class="databox" style="margin-bottom: 0px; height: 50px;">
											<div class="databox-left no-padding-right no-padding-left"
												 style="color: #000;text-align: right;">
												<label class="control-label">公告:</label>
											</div>
											<div class=" databox-right ">
												<textarea class="form-control" rows="1" name="announceCtn" id="myAnnounceCtn"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
										 style="float: right; margin-right: 5px;">
										<div class="databox-left"
											 style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
											<input type="button"  class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="editAppSubmit()"/>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!--/编辑APP-->

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
											<div class="databox-right " style="height: 50px;">
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
											<div class="databox-right " style="height: 50px;">
												<select  id="q_arrayId" class="select-sm form-control" style="height: 30px;">
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
											<div class="databox-right " style="height: 50px;">
												<select  id="q_categoryId" class="select-sm form-control" style="height: 30px;">
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
								<a href="#" class="btn btn-yellow shiny" data-toggle="modal" data-target="#categoryModal">新增分类</a>
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
                url: 'app/show?id=' + id,
                dataType:'json',
                success: function(result){
                    if(result.code == 0){
                        $("#myAppPId").val(result.data.id);
                        $("#myAppId").val(result.data.appId);
                        $("#myAppName").val(result.data.appName);
                        $("#e_arrayId").val(result.data.arrayId);
                        $("#e_categoryId").val(result.data.categoryId);
                        $("#e_imgPath").val(result.data.homePageUrl);
                        $("#myAnnounceCtn").val(result.data.announceCtn);
                        $("#edit").show();
                    }else{
                        Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                    }
                }
            });
        }
        function addAppSubmit(){
            if($("#addForm").validationEngine('validate')){
                $.ajax({
                    type: "POST",
                    url: 'app/add',
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
        function editAppSubmit(){
            if($("#editForm").validationEngine('validate')){
                $.ajax({
                    type: "POST",
                    url: 'app/edit',
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

        function addCategory() {
            if($("#cateForm").validationEngine('validate')){
                $.ajax({
                    type: "POST",
                    url: 'category/add',
                    data:form2Json('cateForm'),
                    dataType:'json',
                    success: function(result){
                        if(result.code == 0){
                            document.getElementById("cateForm").reset();
                            $("#categoryModal").modal('hide');
                            Notify('添加成功', 'top-right', '4000', 'success', 'fa-check', true);
                        }else{
                            Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                        }
                    }
                });
            }
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
                            $("#a_arrayId").append("<option value="+units.id+">" + units.name + "</option>");
                            $("#e_arrayId").append("<option value="+units.id+">" + units.name + "</option>");
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
                            $("#a_categoryId").append("<option value="+units.id+">" + units.name + "</option>");
                            $("#e_categoryId").append("<option value="+units.id+">" + units.name + "</option>");
                        });

                    }
                }
            });
        };

        function imgOk() {
            $('#myImg').fileinput('destroy'); //摧毁
            initUpload(); //重新初始化上传
            $("#imgModal").modal('hide');
        }
        function closeModal() {
            $('#myImg').fileinput('destroy'); //摧毁
            initUpload(); //重新初始化上传
            $("#imgModal").modal('hide');
        }


		function initUpload (){
            $("#myImg").fileinput({
                language: 'zh', //设置语言
                uploadUrl: 'img/upload',
                enctype: 'multipart/form-data',
                showUpload: true,
                dropZoneEnabled: false,
                maxFileSize : 10000,//上传文件最大的尺寸
                maxFilesNum : 1,//
                dropZoneEnabled: false,//是否显示拖拽区域
                browseClass: "btn btn-primary" //按钮样式
            }).on("fileuploaded", function(event, data) {
                if(data.response.code == 0){
                    var myAppPId = $('#myAppPId').val();
                    console.log('lllll: ' + myAppPId);
                    if(myAppPId == null || myAppPId == ''){
                        $("#imgPath").val(data.response.data);
					}else{
                        $("#e_imgPath").val(data.response.data);
					}
				}else{
                    Notify('文件上传失败！'+data.response.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
				}
            }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
                Notify('文件上传失败！'+msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
            });;
		}

        $(function() {
            findArrayAll();
            findCategoryAll();
            $("#addForm").validationEngine();
            initUpload();
        });
	</script>

</body>
</html>
