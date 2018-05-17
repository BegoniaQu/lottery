<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>账户信息</title>
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="${doadmin}/static/bootstrap/assets/js/datetime/bootstrap-datepicker.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
        //选中菜单节点
        $("#contentNode").addClass("active open");
        $("#lhtjNode").addClass("active");
    });
</script>

<div class="page-content">
    <!-- Page Breadcrumb -->
    <div class="page-breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
            <li><a href="#">APP管理</a></li>
            <li class="active">六合推荐</li>
        </ul>
    </div>
    <!-- /Page Breadcrumb -->

    <!-- Page Body -->
    <div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
            <!-- 六合推荐增加-->
            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                <div class="widget">
                    <div class="widget-header header-small">
                        <span class="widget-caption" id="title">添加推荐</span>
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
                                            <label class="control-label">日期:</label>
                                        </div>
                                        <div class="databox-right">
                                            <div class="input-group">
                                                <input class="input-sm form-control date-picker validate[required]"
                                                       id="time" name="time" data-date-format="yyyy-mm-dd">
                                                <span class="input-group-addon">
                                                       <i class="fa fa-calendar"></i>
                                                    </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">期号:</label>
                                        </div>
                                        <div class="databox-right">
                                            <input class="input-sm form-control validate[custom[integer]] validate[required]"
                                                   id="num" name="num">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 2px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">推荐内容:</label>
                                        </div>
                                        <div class="databox-right ">
                                            <textarea class="form-control validate[required]" rows="3" name="content"
                                                      placeholder="多个请逗号分隔,‘中’请括号包含，如：正五:單(中),正二:合雙"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                     style="float: right; margin-right: 5px;">
                                    <div class="databox-left"
                                         style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                        <input type="button" id="sendButton" class="btn btn-success" value="提交"
                                               style="margin-right: 5px;" onclick="addRecommendSubmit()"/>
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
                                <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right "
                                             style="color: #000; text-align: right; height: 50px;">
                                            <label class="control-label">年份:</label>
                                        </div>
                                        <div class=" databox-right " style="height: 60px;">
                                            <input class="input-sm form-control" name="yer" id="yer"
                                                   placeholder="例如：2018"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">期数:</label>
                                        </div>
                                        <div class="databox-right ">
                                            <input name="periodNum" id="periodNum" class="input-sm form-control"
                                                   placeholder="例如：40"/>
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
                                           class="btn btn-blue" value="查询" style="margin-right: 5px;"/>
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
                            <a href="javascript:showAddRecommend();" class="btn btn-blue shiny">添加</a>
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
        url: "recommend/list",
        search: false,
        pagination: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        sidePagination: "server",
        classes: 'table table-hover table-striped table-bordered',
        iconSize: "outline",
        toolbar: "#toolbar",
        columns: [
            {
                field: 'id'
                , title: 'ID'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'time'
                , title: '时间'
                , valign: 'middle'
                , align: 'center'
            },
            {
                field: 'periodNum'
                , title: '期数'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'content'
                , title: '推荐内容'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'createTime'
                , title: '创建日期'
                , align: 'center'
                , valign: 'middle'
            }
        ],
        responseHandler: function (res) {
            return {
                "total": res.data.total,//总数
                "rows": res.data.page_list   //数据
            };
        }
        ,
        icons: {
            refresh: "glyphicon-repeat",
            toggle: "glyphicon-list-alt",
            columns: "glyphicon-list"
        }
    });

    function query() {
        $("#table").bootstrapTable('refresh', {
            query: {
                periodNum: escape($('#periodNum').val()),
                year: escape($('#yer').val())
            }
        });
    }

    function showAddRecommend() {
        $("#add").show();
    }

    function addRecommendSubmit() {
        if ($("#addForm").validationEngine('validate')) {
            $.ajax({
                type: "POST",
                url: 'recommend/add',
                data: form2Json('addForm'),
                dataType: 'json',
                success: function (result) {
                    if (result.code == 0) {
                        document.getElementById("addForm").reset();
                        $("#add").hide();
                        TableRefresh('table');
                        Notify('添加成功', 'top-right', '4000', 'success', 'fa-check', true);
                    } else {
                        Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                    }
                }
            });
        }
    }


    $(function () {
        $("#addForm").validationEngine();
        $('.date-picker').datepicker();
    });
</script>

</body>
</html>
