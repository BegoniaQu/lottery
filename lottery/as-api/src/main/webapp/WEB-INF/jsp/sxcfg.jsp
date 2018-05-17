<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>生肖信息</title>
<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">

<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.js"></script>
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
<script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body >
    <script type="text/javascript">
    	$(function() {
    		//选中菜单节点
    		$("#contentNode").addClass("active open");
    		$("#sxNode").addClass("active");
    	});
    </script>

	<div class="page-content">
        <!-- Page Breadcrumb -->
        <div class="page-breadcrumbs">
            <ul class="breadcrumb">
                <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
                <li><a href="#">APP管理</a></li>
                <li class="active">生肖信息</li>
            </ul>
        </div>
        <!-- /Page Breadcrumb -->

		<!-- Page Body -->
		<div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
                <!-- 增加生肖配置-->
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget">
                        <div class="widget-header header-small">
                            <span class="widget-caption" id="title">生肖配置</span>
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
                                        <div class="databox" style="margin-bottom: 0px;">
                                            <div class="databox-left no-padding-right no-padding-left"
                                                style="color: #000;">
                                                <label class="control-label">年份:</label>
                                            </div>
                                            <div class=" databox-right ">
                                                <input name="year" class="input-sm form-control validate[custom[integer]]" />
                                            </div>
                                        </div>
                                    </div>
                                </div>

					            <div class="row">
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="馬" name="sxMa" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                        placeholder="请填写号码如：01 21 32" name="numMa"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>

                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="龍" name="sxLong" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numLong"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="羊" name="sxYang" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numYang"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="狗" name="sxGou" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numGou"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="豬" name="sxZhu" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numZhu"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="雞" name="sxGi" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numGi"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="兔" name="sxTu" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numTu"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="牛" name="sxNiu" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numNiu"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="蛇" name="sxShe" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numShe"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="猴" name="sxHou" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numHou"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="鼠" name="sxShu" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numShu"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>
                                <div class="row" >
                                       <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                                           <div class="databox" style="margin-bottom: 0px; ">
                                               <div class="databox-left no-padding-right no-padding-left"
                                                   style="color: #000;">
                                                   <label class="control-label">生肖:</label>
                                               </div>
                                              <div class="databox-right">
                                               <input class="input-sm form-control" value="虎" name="sxHu" readonly/>
                                              </div>
                                           </div>
                                       </div>
                                       <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                            <div class="databox" style="margin-bottom: 1px; ">
                                                <div class="databox-left no-padding-right no-padding-left"
                                                    style="color: #000;">
                                                    <label class="control-label">号码:</label>
                                                </div>
                                                <div class="databox-right">
                                                    <input class="input-sm form-control validate[required]"
                                                         name="numHu"/>
                                                </div>

                                            </div>
                                       </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                        style="float: right; margin-right: 5px;">
                                        <div class="databox-left"
                                            style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                            <input type="button" id="sendButton" class="btn btn-success" value="提交" style="margin-right: 5px;" onclick="addSxSubmit()"/>
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
                                            <label class="control-label">年份:</label>
                                        </div>
                                        <div class=" databox-right " style="height: 60px;">
                                            <input  class="input-sm form-control" name="yr" id="yr"
                                                placeholder="请输入年份如：2018 "/>
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
                            <a href="javascript:showAddSx();" class="btn btn-blue shiny">添加</a>
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
            		url : "sx/list",
            		search : false,
            		pagination : true,
            		showRefresh : true,
            		showToggle : true,
            		showColumns : true,
            		pagination : true,
            		pageSize : 12,
            		pageNumber : 1,
            		sidePagination: "server",
            		classes:'table table-hover table-striped table-bordered',
            		iconSize : "outline",
            		toolbar : "#toolbar",
            		onEditableSave: function (field, row, oldValue, $el) {
                        $.ajax({
                                type: "POST",
                                url: 'sxcfg/'+ row.id +'/edit',
                                data: 'num=' + row.num,
                                dataType:'json',
                                success: function(result){
                                    if(result.code == 0){
                                         Notify('修改成功', 'top-right', '4000', 'success', 'fa-check', true);
                                    }else{
                                         Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                                    }
                                }
                            });
                    },
            		columns : [
                            {
                                 field : 'id'
                                ,title : 'ID'
                                ,width : 20
                                ,align : 'center'
                                ,valign : 'middle'
                            },
                            {
                                 field : 'year'
                                ,title : '年份'
                                ,width : 20
                                ,align : 'center'
                            },
                            {
                                 field : 'sx'
                                ,title : '生肖'
                                ,width : 20
                                ,align : 'center'
                            },
                            {
                                 field : 'num'
                                ,title : '号码'
                                ,width : 20
                                ,align : 'center'
                                ,editable : {
                                        type : 'text',
                                        title:'号码编辑'
                                 }
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
                			query:{year:escape($('#yr').val())}
                		});
                }
                function showAddSx(){
                    $("#add").show();
                }
                function addSxSubmit(){
                    if($("#addForm").validationEngine('validate')){
                        $.ajax({
                            type: "POST",
                            url: 'sxcfg/add',
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

          $(function() {
            $("#addForm").validationEngine();
          });
        </script>

</body>
</html>
