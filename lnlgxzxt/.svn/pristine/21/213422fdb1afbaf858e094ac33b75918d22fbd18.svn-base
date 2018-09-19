
function getToday() {
	var myDate = new Date();
	
	var year = myDate.getFullYear();
	var month = myDate.getMonth() + 1;
	var day = myDate.getDate();
	
	var str = year + "-"
	if (month < 10) {
		str += "0" + month + "-";
	} else {
		str += month + "-";
	}
	if (day < 10) {
		str += "0" + day;
	} else {
		str += day;
	}
	
	return str;
} 	


function getYesterday(date) {
	var myDate = new Date(date);
	myDate.setTime(myDate.getTime() - 24*60*60*1000);
	
	var year = myDate.getFullYear();
	var month = myDate.getMonth() + 1;
	var day = myDate.getDate();
	
	var str = year + "-"
	if (month < 10) {
		str += "0" + month + "-";
	} else {
		str += month + "-";
	}
	if (day < 10) {
		str += "0" + day;
	} else {
		str += day;
	}
	
	return str;
}

function getTomorrow(date) {
	var myDate = new Date(date);
	myDate.setTime(myDate.getTime() + 24*60*60*1000);
	
	var year = myDate.getFullYear();
	var month = myDate.getMonth() + 1;
	var day = myDate.getDate();
	
	var str = year + "-"
	if (month < 10) {
		str += "0" + month + "-";
	} else {
		str += month + "-";
	}
	if (day < 10) {
		str += "0" + day;
	} else {
		str += day;
	}
	
	return str;
}


function getDaysAmount(strDateStart,strDateEnd){
	   var strSeparator = "-"; //日期分隔符
	   var oDate1;
	   var oDate2;
	   var iDays;
	   oDate1= strDateStart.split(strSeparator);
	   oDate2= strDateEnd.split(strSeparator);
	   var strDateS = new Date(oDate1[0], oDate1[1]-1, oDate1[2]);
	   var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
	   iDays = parseInt(Math.abs(strDateS - strDateE ) / 1000 / 60 / 60 /24)//把相差的毫秒数转换为天数 
	   return iDays ;
	}

