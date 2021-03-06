<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>规则管理</title>
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-editable.css" rel="stylesheet">
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
    <script src="${doadmin}/static/bootstrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

</head>
<body>
<script type="text/javascript">
    $(function () {
        //选中菜单节点
        $("#appNode").addClass("active open");
        $("#ruleNode").addClass("active");
    });
</script>

<div class="page-content">
    <!-- Page Breadcrumb -->
    <div class="page-breadcrumbs">
        <ul class="breadcrumb">
            <li><i class="fa fa-home"></i> <a href="#">Home</a></li>
            <li><a href="#">规则管理</a></li>
            <li class="active">规则配置</li>
        </ul>
    </div>
    <!-- /Page Breadcrumb -->

    <!-- Page Body -->
    <div class="page-body" id="my_content">

        <div class="row" id="add" style="display: none">
            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                <div class="widget">
                    <div class="widget-header header-small">
                        <span class="widget-caption" id="title">增加配置</span>
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
                                            <label class="control-label">名称:</label>
                                        </div>
                                        <div class=" databox-right ">
                                            <input name="ruleName" class="input-sm form-control validate[required]"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 2px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">规则:</label>
                                        </div>
                                        <div class="databox-right ">
                                            <textarea class="form-control validate[required]" rows="3" name="content"
                                                      placeholder=""></textarea>
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
                                               style="margin-right: 5px;" onclick="addRuleSubmit()"/>
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
                        <span class="widget-caption" id="titleEdit">编辑规则</span>
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
                            <input class="input-sm form-control" name="id" id="myRuleId" type="hidden"/>
                            <!-- line 1 -->
                            <div class="row">
                                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 0px; height: 50px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">名称:</label>
                                        </div>
                                        <div class=" databox-right ">
                                            <input name="ruleName" id="myRuleName"
                                                   class="input-sm form-control validate[required]"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
                                    <div class="databox" style="margin-bottom: 2px;">
                                        <div class="databox-left no-padding-right no-padding-left"
                                             style="color: #000;">
                                            <label class="control-label">规则:</label>
                                        </div>
                                        <div class="databox-right ">
                                            <textarea class="form-control validate[required]" rows="3" id="myCnt"
                                                      name="content"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12"
                                     style="float: right; margin-right: 5px;">
                                    <div class="databox-left"
                                         style="margin-bottom: 5px; margin-right: 0px; text-align: right;">
                                        <input type="button" class="btn btn-success" value="提交"
                                               style="margin-right: 5px;" onclick="editRuleSubmit()"/>
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
                                            <label class="control-label">名称:</label>
                                        </div>
                                        <div class="databox-right " style="height: 60px;">
                                            <input class="input-sm form-control" name="ruleName" id="ruleName"/>
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
                            <a href="javascript:showAddRule();" class="btn btn-blue shiny">添加配置</a>
                            <a href="javascript:showEditRule();" class="btn btn-palegreen shiny">编辑配置</a>
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
        url: "rule/list",
        search: false,
        pagination: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        singleSelect: true,
        sidePagination: "server",
        classes: 'table table-hover table-striped table-bordered',
        iconSize: "outline",
        toolbar: "#toolbar",
        columns: [
            {
                field: 'ck'
                , checkbox: true
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'id'
                , title: 'ID'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'name'
                , title: '名称'
                , valign: 'middle'
                , align: 'center'
            },
            {
                field: 'content'
                , title: '规则'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'operator'
                , title: '操作人'
                , align: 'center'
                , valign: 'middle'
            },
            {
                field: 'lastModifiedTime'
                , title: '操作时间'
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
            query: {ruleName: $('#ruleName').val()}
        });
    }

    function showAddRule() {
        $("#add").show();
    }

    function showEditRule() {
        $("#editForm").validationEngine();
        var id = getSelection();
        if (id == null) {
            $alert("请选择一条记录");
            return;
        }
        $.ajax({
            type: "GET",
            url: 'rule/show?id=' + id,
            dataType: 'json',
            success: function (result) {
                if (result.code == 0) {
                    $("#myRuleName").val(result.data.ruleName);
                    $("#myCnt").val(result.data.content);
                    $("#myRuleId").val(result.data.id);
                    $("#edit").show();
                } else {
                    Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                }
            }
        });
    }


    function addRuleSubmit() {
        if ($("#addForm").validationEngine('validate')) {
            $.ajax({
                type: "POST",
                url: 'rule/add',
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

    function editRuleSubmit() {
        if ($("#editForm").validationEngine('validate')) {
            $.ajax({
                type: "POST",
                url: 'rule/edit',
                data: form2Json('editForm'),
                dataType: 'json',
                success: function (result) {
                    if (result.code == 0) {
                        document.getElementById("editForm").reset();
                        $("#edit").hide();
                        TableRefresh('table');
                        Notify('更新成功', 'top-right', '4000', 'success', 'fa-check', true);
                    } else {
                        Notify(result.msg, 'top-right', '4000', 'danger', 'fa-bolt', true);
                    }
                }
            });
        }
    }

    function getSelection() {
        var selections = $("#table").bootstrapTable('getSelections');
        if (selections == null || selections == '') {
            return null;
        }
        return selections[0].id;
    }

    $(function () {
        $("#addForm").validationEngine();
    });
</script>

</body>
</html>
