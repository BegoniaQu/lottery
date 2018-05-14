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
    		$("#appNode").addClass("active open");
    		$("#xjjnNode").addClass("active");
    	});
    </script>

	<div class="page-content">
        <!-- Page Breadcrumb -->
        <div class="page-breadcrumbs">
            <ul class="breadcrumb">
                <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
                <li><a href="#">APP管理</a></li>
                <li class="active">玄机锦囊</li>
            </ul>
        </div>
        <!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
                <!-- 玄机锦囊增加-->
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget">
                        <div class="widget-header header-small">
                            <span class="widget-caption" id="title">添加锦囊</span>
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
                                    <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                        <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                style="color: #000;">
                                                <label class="control-label">期号:</label>
                                            </div>
                                            <div class=" databox-right ">
                                                <input name="period" class="input-sm form-control validate[required]" placeholder="例如：2018040"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
					            <div class="row">
                                    <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                                        <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                style="color: #000;">
                                                <label class="control-label">锦囊内容:</label>
                                            </div>
                                            <div class="databox-right ">
                                                <textarea class="form-control validate[required]" rows="3" name="content" placeholder="内容中如需换行，请添加'\r\n' 例如：為感君王輾轉思，遂教方士殷勤覓。\r\n排空馭氣奔如電，升天入地求之遍。"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                        style="float: right; margin-right: 5px;">
                                        <div class="databox-left"
                                            style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                            <input type="button" id="sendButton" class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="addBrocadesacSubmit()"/>
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
                                            <label class="control-label">期号:</label>
                                        </div>
                                        <div class=" databox-right " style="height: 60px;">
                                            <input  class="input-sm form-control" name="perd" id="perd"
                                                placeholder="例如：2018040"/>
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
                                <a href="javascript:showAddBrocadesac();" class="btn btn-blue shiny">添加</a>
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
            		url : "brocadesac/list",
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
                            {
                                 field : 'id'
                                ,title : 'ID'
                                ,align : 'center'
                                ,valign : 'middle'
                            },
                            {
                                 field : 'period'
                                ,title : '期号'
                                ,valign : 'middle'
                                ,align : 'center'
                            },
                            {
                                 field : 'content'
                                ,title : '锦囊内容'
                                ,align : 'center'
                                ,valign : 'middle'
                            },
                            {
                                field : 'createTime'
                               ,title : '创建时间'
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
                			query:{period:escape($('#perd').val())}
                		});
                }
                function showAddBrocadesac(){
                    $("#add").show();
                }
                function addBrocadesacSubmit(){
                    if($("#addForm").validationEngine('validate')){
                        $.ajax({
                            type: "POST",
                            url: 'brocadesac/add',
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


           $(function() {
            $("#addForm").validationEngine();
          });
        </script>

</body>
</html>
