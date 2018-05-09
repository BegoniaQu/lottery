/**
 * Long 日期格式化
 */
var LoactionFormatter = function(value){
	if(value){
		try{
			var val = new Number(value).valueOf();
			return getDefaultTime(new Date(val));
		}catch(err){
			return value;
		}
		
	}
}
/**
 * Boolean 生效/失效 格式化
 */
var effectiveFormatter = function(value){
	if(value == true){
		return '生效'
	}else if(value == false){
		return '失效'
	}else{
		return '-'
	}
}
/**
 * 渠道分成模式类型
 */ 
var prifitRuleTypeFormatter = function(value){
	if(value == 1){
		return '固定分成'
	}else if(value == 2){
		return '比例分成'
	}else{
		return '-'
	}
}
/**
 * 上下架
 */
var SMTFormatter = function(value){
	if(value == true){
		return '上架'
	}else if(value == false){
		return '下架'
	}else{
		return '-'
	}
}
/**
 * 投放状态
 */
var ThreowStateFormatter = function(value){
	if(value == true){
		return '已投放'
	}else if(value == false){
		return '未投放'
	}else{
		return '-'
	}
}
/**
 * 收益金额入账状态
 */
var profitInputStateFormartter = function(value){
	if(value == 0){
		return '未到账'
	}else if(value == 1){
		return '已到帐'
	}else if(value == -1){
		return '失败'
	}else{
		return '-'
	}
}
var logTypeFormartter = function(val){
	if(val == 1){return '收益分成'}
	else if(val == 2){return '退款分成扣除'}
	else{return '-'}
}

/**
 * orderStatus 订单状态
 */
function orderStatusFormatter(orderStatus) {
	if (orderStatus == null || orderStatus == undefined)
		return "";

	else if (orderStatus == 50) {
		return "待付款";
	} else if (orderStatus == 100) {
		return "待发货";
	} else if (orderStatus == 150) {
		return "待收货";
	} else if (orderStatus == 500) {
		return "已完成";
	} else if (orderStatus == 600) {
		return "售后中";
	} else if (orderStatus == 800) {
		return "钱包退款中";
	} else if (orderStatus == 900) {
		return "已退款";
	} else if (orderStatus == 950) {
		return "退款失败";
	} else if (orderStatus == 1000) {
		return "已取消";
	}

	return orderStatus;
}
