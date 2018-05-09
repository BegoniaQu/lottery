	
	function onPsizeChange(){
		setCookie("mypageSizeForAudit",$("#customPageSize").val(),1);
		gotoPage('${pages.pageNumber}');
	}

	

	function detail(id) {
		location.href = ctx+'/tudigong/audit/detail/' + id + '/page.html';
	}
	function withdrawSend(ids,status){
			$.ajax({
				type : "post",
				url : ctx+"/tudigong/withdraw/withdrawBatch.html",
				data : {
					"ids" : ids,
					"status" :status
				},
				dataType : 'json',
				error : function() {
					$alert('请求错误，请稍后重试');
				},
				success : function(data) {
					if (data.type == 'success') {
						$alert(data.content);
						gotoPage($("#pageNumber").val());
					} else {
						$alert(data.content);
					}
				}
			});
		
	}
	function auditSend(ids,status) {
		if(status){//单个审核
			$.ajax({
				type : "post",
				url : ctx+"/tudigong/audit/audit.html",
				data : {
					"id" : ids,
					"status":status
				},
				dataType : 'json',
				error : function() {
					$alert('请求错误，请稍后重试');
				},
				success : function(data) {
					if (data.type == 'success') {
						gotoPage($("#pageNumber").val());
					} else {
						$alert(data.content);
					}
				}
			});
		}else{//批量
			$.ajax({
				type : "post",
				url : ctx+"/tudigong/audit/auditBatch.html",
				data : {
					"ids" : ids
				},
				dataType : 'json',
				error : function() {
					$alert('请求错误，请稍后重试');
				},
				success : function(data) {
					if (data.type == 'success') {
						gotoPage($("#pageNumber").val());
					} else {
						$alert(data.content);
					}
				}
			});
		}
		
	}

	function checkBox() {
		if ($("#switch").attr("checked")) {
			$("input[name='cb']:checkbox").each(function() {
				if ($(this).attr("disabled") != "disabled") {
					$(this).attr("checked", true);
				}
			})
		} else {
			$("input[name='cb']:checkbox").each(function() {
				$(this).attr("checked", false);
			})
		}
	}

	function getCheckedSet() {
		var str = "";
		$("input[name='cb']:checkbox").each(function() {
			if ($(this).attr("checked")) {
				str += $(this).val() + ",";
			}
		})
		str = str.substr(0, str.length - 1);
		if (str == '') {
			$alert('没有选中的记录');
			return null;
		}
		return str;
	}

	
	
	//审核
	function audit(id,status) {
		if(!id||!status){
			return;
		}
		bootbox.confirm("您确定操作此记录行吗?", function(result) {
			if (result) {
				auditSend(id,status); //提交
			}
		});
	}
	
	function download(){
		$('#myForm').submit();
	}