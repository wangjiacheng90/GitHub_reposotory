document.write("<script language=javascript src='js/getdate.js'></script>");

window.onload = $(function(){
	$("#datapickerinput").val(getTomorrow(getToday()));
	tableinit();
	infodatainit();
	query();
});




function infodatainit() {
	var table = $("#infoList_table");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		columns : [
			{
				field : 'title',
				title : '申报信息'
			}, {
				field : 'info',
				title : ''
			}
		]
	});
}



function queryinfodata() {
	var rq = $("#datapickerinput").val();
	$.ajax({
		type : "POST",
		url : 'jjsb_rq_queryinfodata.action',
		dataType : "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			$('#infoList_table').bootstrapTable('load', data);
		}
	});
}




function tableinit() {
	var table = $("#dataList_table");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //是否启用点击选中行
		height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		columns : [
			{
				field : 'sf',
				title : '省份'
			}, {
				field : 'lx',
				title : '买卖类型'
			}, {
				field : 'qssd',
				title : '起始时段'
			}, {
				field : 'zzsd',
				title : '终止时段'
			}, {
				field : 'qssj',
				title : '起始时间'
			}, {
				field : 'zzsj',
				title : '终止时间'
			}, {
				field : 'gl',
				title : '功率(MW)'
			}, {
				field : 'dj',
				title : '电价(元/MWH)'
			}
		]
	});
}



function query() {
	var rq = $("#datapickerinput").val();
	$.ajax({
		type : "POST",
		url : 'jjsb_rq_query.action',
	    dataType: "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			$('#dataList_table').bootstrapTable('load', data);
		}
	});
	
	queryinfodata();
}

function czbjnh() {
	var rq = $("#datapickerinput").val();

	$.ajax({
		url : "jjsb_rq_czbjnh.action",
		type : "POST",
		dataType : "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			alert(data[0].info);
			query();
		}
	});
}

function send() {
	var rq = $("#datapickerinput").val();

	$.ajax({
		url : "jjsb_rq_send.action",
		type : "POST",
		dataType : "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			alert(data[0].info);
			query();
		}
	});
	
	senddb();
}


function senddb() {
	var rq = $("#datapickerinput").val();
	
	$.ajax({
		url : "jjsb_rq_senddb.action",
		type : "POST",
		dataType : "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			alert(data[0].info);
			query();
		}
	});
}
