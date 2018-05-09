<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${empty pages.list and empty pages.ja}">
	<div class="alert alert-warning fade in radius-bordered alert-shadowed">
	    <button data-dismiss="alert" class="close">
	        ×
	    </button>
	    <span class="badge badge-success graded">
	        0
	    </span>
	    <strong>No data</strong> 未查询到您想要的数据!
	</div>
</c:if>


<c:if test="${not empty pages.list or not empty pages.ja}">

<script type="text/javascript">
$().ready( function() {
	var $pager = $("#pager");
	$pager.pager({
		pagenumber: '${pages.pageNumber}',
		pagecount:  '${pages.pageCount}',
		buttonClickCallback: gotoPage
	});
});

$("#customPageSize").val('${pages.pageSize}');
</script>

<br/>
	<div class="row DTTTFooter">
		<div class="col-sm-6" >
			<div class="col-sm-2" style="padding-left:0px;width:75px;">
			<select name="pSize" class="form-control input-sm" id="customPageSize" onchange="onPsizeChange()">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="200">200</option>
				</select>
			</div>
			<div class="col-sm-4" id="simpledatatable_info" role="alert" aria-live="polite" aria-relevant="all" style="height:30px;padding-top:5px;padding-left:0px;">
			<span>共${pages.totalCount}条记录,共${pages.pageCount}页</span>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="dataTables_paginate paging_bootstrap" style="text-align: right;" id="pager">
			</div>
		</div>
	</div>

	<input type="hidden" name="pageNumber" id="pageNumber" value="${pages.pageNumber}" />
</c:if>