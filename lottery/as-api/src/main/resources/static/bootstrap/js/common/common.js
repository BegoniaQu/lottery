$alert=function(message,title){
	if(!title){
		title='提示';
	}
	bootbox.alert(
        	{  
    	            buttons: {  
    	               ok: {  
    	                    label: '确认',  
    	                    className: 'btn-sm btn-success'
    	                }  
    	            },  
    	            message: message,
    	            title: title
    	        }
        	);
};
$confirm = function(message,callback,title){
	if(!title)titel = "确认信息";
	if(!message)message = "提示信息";
	bootbox.confirm({  
	    buttons: {  
	        confirm: {  
	            label: '确认',  
	            className: 'btn-sm btn-success'  
	        },  
	        cancel: {  
	            label: '取消',  
	            className: 'btn-sm btn-default'  
	        }  
	    },  
	    message: message,  
	    callback: callback,  
	    title: title
	    });  
}
/**
 * bootstrapTable refresh
 */
function TableRefresh(id){
	$("#"+id).bootstrapTable('refresh');
}
/**
 * 清空form表单
 * @param id
 */
function formClear(id){
	if(!id)return;
	id = '#' + id ;
    $(id).find(':input').each(  
        function(){  
            switch(this.type){  
                case 'passsword':  
                case 'select-multiple':  
                case 'select-one':  
                case 'text':  
                case 'textarea':  
                    $(this).val('');  
                    break;  
                case 'checkbox':  
                case 'radio':  
                    this.checked = false;  
            }  
        }     
    );  
}
/**
 * 表单数据转json
 * @param id
 * @returns
 */
function form2Json(id) {
	var disableArray=$("#"+id+" input[name][disabled]" );
    var arr = $("#" + id).serializeArray();
    for (var i = 0; i < disableArray.length; i++) {
    	if(disableArray[i].value){
    		arr.push({name:disableArray[i].name,value:disableArray[i].value});
    	}
        
    }
    var jsonStr = "";

    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
    	if(arr[i].value){
    		jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",';
    	}
    }
    jsonStr = jsonStr.substring(0, jsonStr.length>1?jsonStr.length-1:jsonStr.length).trim();
    jsonStr += '}';
	jsonStr=jsonStr.replace(/[\r\n]/g,"").replace(/[\\]/g,"\\");
    var json = JSON.parse(jsonStr);
    return json;
}
/**
 * form load 
 */
function formLoad(id,data){
	if(!id||!data)return;
	// input 
	var names = $('#'+id+ ' input');
	if(names&&names.length>0){
		for (var i = 0; i < names.length; i++) {
			if(data.hasOwnProperty(names[i].name)){
				names[i].value=data[names[i].name];
			}
		}
	}
	
	// select
	var selects = $('#'+id+ ' select');
	if(selects&&selects.length>0){
		for (var i = 0; i < selects.length; i++) {
			if(data.hasOwnProperty(selects[i].name)){
				selects[i].value=data[selects[i].name];
				$('#'+selects[i].id).val(data[selects[i].name]);
			}
		}
	}
}
/**
 * 获取地址栏参数
 * @param name
 * @returns
 */
function getQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
function getRow(id,rowIndex){
    return $("#"+id+" table tr").eq(rowIndex);
}
/**
 * 渠道下拉列表
 */
function initChannelSelect(id){
	$("#"+id).select2({
		  ajax: {
		    url: ctx+"/channel/select2.html",
		    dataType: 'json',
		    processResults: function (data) {
		    	try{
			       channelData = data;
		    	}catch(err){}
		        return {
		          results: data
		        };
		      },
		    cache: true
		  }
	});	
}
/**
 * 学校下拉列表
 * @param id
 */
function innitSchoolSelect(id){
	$("#"+id).select2({
		  ajax: {
		    url: ctx+"/data/school/Select2.html",
		    dataType: 'json',
		    data: function (params) {
		        return {
		        	schoolName: params.term,
		        };
		      },
		    processResults: function (data) {
		    	data.unshift({id:'',text:'请选择',title:''});
		        return {
		          results: data
		        };
		      },
		    cache: true
		  }
	});	
}
/**
 * 分成模式下拉列表
 */
var ProfitRuleSelectData;
function initProfitRuleSelect(id){
	if(!ProfitRuleSelectData){
		$.ajax({
            type: "POST",
            url:  ctx+"/profitRule/select2.html",
            async:false,
            dataType: 'json',
            success: function(result){
                     if(result){
                    	 ProfitRuleSelectData = result;
                    }
            }
       });
	}
	
	
	return $("#"+id).select2({
		    data: ProfitRuleSelectData,
		    width:'100%'
	});


}
