<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>开奖信息</title>
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">

    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="${doadmin}/static/bootstrap/assets/js/datetime/bootstrap-datepicker.js"></script>
    <script src="${doadmin}/static/bootstrap/assets/js/datetime/bootstrap-timepicker.js"></script>
    <!--Bootstrap Date Range Picker-->
    <script src="${doadmin}/static/bootstrap/assets/js/datetime/moment.js"></script>
    <script src="${doadmin}/static/bootstrap/assets/js/datetime/daterangepicker.js"></script>

    <style type="text/css">
        .red_ball {
            list-style: none;
            text-align: center;
            display: inline-block;
            width: 32px;
            height: 32px;
            background-image: url(${doadmin}/static/bootstrap/assets/img/hongse-qiu.png);
            background-size: 32px 32px;
            line-height: 30px;
            cursor: pointer;
        }

        .green_ball {
            text-align: center;
            display: inline-block;
            width: 32px;
            height: 32px;
            background-image: url(${doadmin}/static/bootstrap/assets/img/lvse-qiu.png);
            background-size: 32px 32px;
            line-height: 30px;
            cursor: pointer;
        }

        .blue_ball {
            text-align: center;
            display: inline-block;
            width: 32px;
            height: 32px;
            background-image: url(${doadmin}/static/bootstrap/assets/img/lanse-qiu.png);
            background-size: 32px 32px;
            line-height: 30px;
            cursor: pointer;
        }
    </style>

</head>
<body>
<script type="text/javascript">
    $(function () {
        //选中菜单节点
        $("#contentNode").addClass("active open");
        $("#awardNode").addClass("active");
    });
</script>

<div class="page-content">
    <!-- Page Breadcrumb -->
    <div class="page-breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
            <li><a href="#">APP管理</a></li>
            <li class="active">开奖信息</li>
        </ul>
    </div>
    <!-- /Page Breadcrumb -->

    <!-- Page Body -->
    <div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
            <!-- 最新开奖-->
            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                <div class="widget">
                    <div class="widget-header header-small">
                        <span class="widget-caption" id="title">最新开奖添加/编辑</span>
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
                                <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">期数:</label>
                                        </div>
                                        <div class="databox-right ">
                                            <input id="termNum" name="termNum"
                                                   class="input-sm form-control validate[custom[integer]] validate[required]"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">下次开奖日期:</label>
                                        </div>
                                        <div class=" databox-right ">
                                            <div class="input-group">
                                                <input class="input-sm form-control date-picker validate[required]"
                                                       id="nextDate" name="nextDate" data-date-format="yyyy-mm-dd">
                                                <span class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                             </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px;padding-left:0px;height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">时间:</label>
                                        </div>
                                        <div class=" databox-right ">
                                            <div class="input-group">
                                                <input class="input-sm form-control validate[required]" id="timepicker1"
                                                       name="nextTime">
                                                <span class="input-group-addon">
                                                <i class="fa fa-clock-o"></i>
                                             </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-left" style="color: #000;">
                                            <label class="control-label">开奖号码:</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum1" name="awardNum1"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum2" name="awardNum2"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum3" name="awardNum3"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum4" name="awardNum4"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum5" name="awardNum5"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum6" name="awardNum6"></div>
                                    </div>
                                </div>
                                <div class="col-xs-1">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-right"><input
                                                class="input-sm form-control validate[max[49]] validate[min[1]] validate[required]"
                                                id="awardNum7" name="awardNum7"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12"
                                     style="float: right; margin-right: 5px;">
                                    <div class="databox-left"
                                         style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                        <input type="button" id="sendButton" class="btn btn-success" value="提交"
                                               style="margin-right: 5px;" onclick="addAwardSubmit()"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /增加-->

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
                                            <input class="input-sm form-control" name="yr" id="yr"
                                                   placeholder="请输入年份 "/>
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
                            <a href="javascript:showAddAward();" class="btn btn-blue shiny">添加</a>
                            <a href="javascript:showEditAward();" class="btn btn-palegreen shiny">编辑最新开奖</a>
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
        url: "award/list",
        search: false,
        pagination: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        sidePagination: "server",
        classes: 'table table-hover table-striped table-bordered table-responsive',
        iconSize: "outline",
        toolbar: "#toolbar",
        columns: [
            {
                field: 'period'
                , title: '期号'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'balls'
                , title: '开奖号码'
                , align: 'center'
                , formatter: function (value, row, index) {
                    var balls = row.balls;
                    var tag = "<ul style='list-style:none;padding-left:0px;'>";
                    for (i in balls) {
                        if (balls[i].bs == '红') {
                            tag = tag + "<li class='red_ball'>" + balls[i].num + "</li>&nbsp;&nbsp;";
                        } else if (balls[i].bs == '绿') {
                            tag = tag + "<li class='green_ball'>" + balls[i].num + "</li>&nbsp;&nbsp;";
                        } else if (balls[i].bs == '蓝') {
                            tag = tag + "<li class='blue_ball'>" + balls[i].num + "</li>&nbsp;&nbsp;";
                        }
                    }
                    tag = tag + "</ul>";
                    return tag;
                }
            },
            {
                field: 'sx'
                , title: '生肖'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'wx'
                , title: '五行'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'jy'
                , title: '家禽野兽'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'ws'
                , title: '尾数大小'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'zh'
                , title: '总和数'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'zhSingle'
                , title: '总和单双'
                , align: 'center'
                , valign: 'middle'
                , formatter: function (value, row, index) {
                    if (row.zhSingle == 1) {
                        return '单';
                    } else if (row.zhSingle == 2) {
                        return '双';
                    }
                }
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
            query: {year: escape($('#yr').val())}
        });
    }

    function showAddAward() {
        $("#add").show();
    }

    function showEditAward() {
        $.ajax({
            type: "GET",
            url: 'latestaward/show',
            dataType: 'json',
            success: function (result) {
                if (result.code == 0) {
                    $("#termNum").val(result.data.termNum);
                    $("#nextDate").val(result.data.nextDate);
                    $("#timepicker1").val(result.data.nextTime);
                    $("#awardNum1").val(result.data.awardNum1);
                    $("#awardNum2").val(result.data.awardNum2);
                    $("#awardNum3").val(result.data.awardNum3);
                    $("#awardNum4").val(result.data.awardNum4);
                    $("#awardNum5").val(result.data.awardNum5);
                    $("#awardNum6").val(result.data.awardNum6);
                    $("#awardNum7").val(result.data.awardNum7);
                    $("#add").show();
                } else {
                    Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                }
            }
        });
    }

    function addAwardSubmit() {
        if ($("#addForm").validationEngine('validate')) {
            $.ajax({
                type: "POST",
                url: 'award/add',
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
        $('#timepicker1').timepicker();

    });
</script>

</body>
</html>
