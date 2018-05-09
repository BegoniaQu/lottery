(function($){
    $.formatDate = function(pattern,date){
    	var lang="zh-CN";
        //如果不设置，默认为当前时间
        if(!date) date = new Date();
        if(typeof(date) ==="string"){
             if(date=="")  date = new Date();
              else  date = new Date(date.replace(/-/g,"/"));
        }   
        /*补00*/
        var toFixedWidth = function(value){
             var result = 100+value;
             return result.toString().substring(1);
        };
//        /*配置*/
//        var options = {
//                regeExp:/(yyyy|M+|d+|h+|m+|s+|ee+|ws?|p)/g,
//                months: ['January','February','March','April','May',
//                         'June','July', 'August','September',
//                          'October','November','December'],
//                weeks: ['Sunday','Monday','Tuesday',
//                        'Wednesday','Thursday','Friday',
//                            'Saturday']
//        };
//         
//        /*时间切换*/
//        var swithHours = function(hours){
//            return hours<12?"AM":"PM";
//        }; 
        /*配置*/
        var options = {
                regeExp:/(yyyy|M+|d+|h+|m+|s+|ee+|ws?|p)/g,
                months: ['一月','二月','三月','四月','五月',
                         '六月','七月', '八月','九月',
                          '十月','十一月','十二月'],
                weeks: ['星期日','星期一','星期二',
                        '星期三','星期四','星期五',
                            '星期六']
        };
        
        /*时间切换*/
        var swithHours = function(hours){
            return hours<12?"上午":"下午";
        };
         
        /*配置值*/
        var pattrnValue = {
                "yyyy":date.getFullYear(),                      //年份
                "MM":toFixedWidth(date.getMonth()+1),           //月份
                "dd":toFixedWidth(date.getDate()),              //日期
                "hh":toFixedWidth(date.getHours()),             //小时
                "mm":toFixedWidth(date.getMinutes()),           //分钟
                "ss":toFixedWidth(date.getSeconds()),           //秒
                "ee":options.months[date.getMonth()],           //月份名称
                "ws":options.weeks[date.getDay()],              //星期名称
                "M":date.getMonth()+1,
                "d":date.getDate(),
                "h":date.getHours(),
                "m":date.getMinutes(),
                "s":date.getSeconds(),
                "p":swithHours(date.getHours())
        };
         
        return pattern.replace(options.regeExp,function(){
               return  pattrnValue[arguments[0]];
        });
    };
     
})(jQuery);
function getLoactionTime(date){
	if(!date)date=new Date();
	return $.formatDate("yyyy年MM月dd日(ws) p hh:mm:ss",date);
}

function getDefaultTime(date){
	if(!date)date=new Date();
	return $.formatDate("yyyy-MM-dd hh:mm:ss",date);
}

var individuationTime = {
	now:'刚刚',
	nowVal:10000,
	oneMin:'1分钟前',
	oneMinVal:60000,
	fiveMin:'5分钟前',
	fiveMinVal:5*60000,
	tenMin:'10分钟前',
	tenMinVal:10*60000,
	halfHour:'半小时前',
	halfHourVal:30*60000,
	oneHour:'1小时前',
	oneHourVal:60*60000,
	twoHour:'2小时前',
	twoHourVal:120*60000,
	today:'今天',
	todayVal:300*60000,
	yesterday:'昨天',
	twoDay:'前天'
};

function individuationDate(date){
	if(!date)return individuationTime.now;
	var time = date.getTime();
	var newdate = new Date();
	var nowTime = newdate.getTime();
	if(nowTime-time<individuationTime.nowVal) {
		return individuationTime.now;
	}
	else if(nowTime-time<individuationTime.oneMinVal) {
		return individuationTime.now;
	}
	else if(nowTime-time<individuationTime.fiveMinVal) {
		return individuationTime.oneMin;
	}
	else if(nowTime-time<individuationTime.tenMinVal) {
		return individuationTime.fiveMin;
	}
	else if(nowTime-time<individuationTime.halfHourVal) {
		return individuationTime.tenMin;
	}
	else if(nowTime-time<individuationTime.oneHourVal) {
		return individuationTime.halfHour;
	}
	else if(nowTime-time<individuationTime.twoHourVal) {
		return individuationTime.oneHour;
	}
	else if(nowTime-time<individuationTime.todayVal) {
		return individuationTime.twoHour;
	}
	else if(newdate.getDate()-date.getDate()==0){
		return  individuationTime.today+$.formatDate(" (ws) p hh:mm:ss",date);
	}
	else if(newdate.getDate()-date.getDate()==1){
		return individuationTime.yesterday+$.formatDate(" (ws) p hh:mm:ss",date);
	}
	else if(newdate.getDate()-date.getDate()==2){
		return individuationTime.twoDay+$.formatDate(" (ws) p hh:mm:ss",date);
	}
	
	else{
		return getLoactionTime(date);
	}
	
	
}
