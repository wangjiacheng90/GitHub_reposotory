laydate({
            elem: '#querydate',

            event: 'focus' 
        });

//初始赋值
$('#querydate').val(getNowFormatDate);


//起始时间
var result_qxkhzd_qssj = [];
//终止时间
var result_qxkhzd_zzsj = [];
// 类型
var result_qxkhzd_lx = [];
//备注
var result_qxkhzd_bz = [];
// 初始化数据 和加载数据       
       function field_load(){
    	   
        result_qxkhzd_qssj=sj();
        
    	result_qxkhzd_zzsj=sj();
   	
       	result_qxkhzd_lx=lx();
       	
       	result_qxkhzd_bz = bz();
       	
       	
       }

//初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
window.onload = $(function(){
	field_load();  //初始化表头里内容的判断

	tableinit(); // 初始化表头
	query();	//查询
	
	tableinit_fd(); // 初始化表头
	
	tableinit_hdkh(); // 初始化表头
	
	tableinit_hdmkh(); // 初始化表头
	
	  init_hdkh();
		init_hdmkh();
		init_fd();
	 
	
//	 add_tip_fd();
	
//	add_tip_fd();
});

//初始化表头，其中包含了设定要编辑的列=============================================
function tableinit() {
	
	
	var table = $("#dataList_table");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		 search: false, 
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //是否启用点击选中行
		sortable: true,          //是否启用排序
		sortOrder: "asc",       //排序方式
		 showRefresh: false,                  //是否显示刷新按钮
//		height : 500,                           
		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		url: "",
		columns : [
			{
                checkbox: true
            },
            {
				field : 'jzmc',
				title : '机组名称',
				sortable : true
			}, 
			{
				field : 'qssj',
				title : '起始时间',
				sortable : true,
//				editable: {
//                    type: 'select',
//                    title: '起始时间',
                   
//                   source: result_qxkhzd_qssj
//                   
//                }
				
			}, {
				field : 'zzsj',
				title : '终止时间',
				sortable : true,
//				editable: {
//                    type: 'select',
//                    title: '起始时间',
//                  
//                   source: result_qxkhzd_zzsj
//                   
//                }
			}, {
				field : 'lx',
				title : '类型',
				editable: {
                    type: 'select',
                    title: '类型',
//                    source:[{value:"检修",text:"检修"},{value:"运行",text:"运行"},{value:"停机",text:"停机"}]
                   source: result_qxkhzd_lx
                   
                }
			}, {
				field : 'bzyy',
				title : '备注原因',
				sortable : true,
				editable: {
                    type: 'select',
                    title: '类型',
                   source: result_qxkhzd_bz
                   
                }
			}
		],
		
		onEditableSave: function (field, row, oldValue, $el) {
			var rq = $("#querydate").val(); 
			$('#dataList_table').bootstrapTable("resetView");
//			var rq = $("#querydate").val(); 
			 $.ajax({
         		type : "POST",
         		url : 'qxkhzd_table_save.action',
         		async: false, //如果不设置这里 将取不到值
         	    dataType: "json",
         		data : {
         			"rq" : rq,
         			"jzmc": row.jzmc,
         			"qssj":row.qssj,
         			"zzsj":row.zzsj,
         			"lx":row.lx,
         			"bzyy":row.bzyy,
         			"index":oldValue
         			
         		},
         		success : function(data) {
         			var str="";
        			layer.alert(str+=data+"！\r\n",{
        	            title: '提示框',				
        				icon:0,								
        			 }); 
         		},
         		 error: function () {

                     var str="";
         			layer.alert(str+="编辑失败！\r\n",{
         	            title: '提示框',				
         				icon:0,								
         			 }); 
                 }
             });
			
        }
	});
}


//初始化表头，其中包含了设定要编辑的列========风电站=====================================
function tableinit_fd() {
	var table = $("#dataList_table_fd");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		 search: false, 
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //是否启用点击选中行
		sortable: true,          //是否启用排序
		sortOrder: "asc",       //排序方式
		 showRefresh: false,                  //是否显示刷新按钮
//		height : 500, 
		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		url: "",
		columns : [
//            {
//				field : 'rq',
//				title : '日期',
//				sortable : true
//			}, 
			{
				field : 'jzmc',
				title : '风电站',
				sortable : true
			}
		]
	});
}



//初始化表头，其中包含了设定要编辑的列==========火电考核机组===================================
function tableinit_hdkh() {
	var table = $("#dataList_table_hdkh");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		 search: false, 
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //是否启用点击选中行
		sortable: true,          //是否启用排序
		sortOrder: "asc",       //排序方式
		 showRefresh: false,                  //是否显示刷新按钮
//		height : 500, 
		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		url: "",
		columns : [
//            {
//				field : 'rq',
//				title : '日期',
//				sortable : true
//			}, 
			{
				field : 'jzmc',
				title : '火电考核机组',
				sortable : true
			}
		]
	});
}



//初始化表头，其中包含了设定要编辑的列==========火电免考核机组===================================
function tableinit_hdmkh() {
	var table = $("#dataList_table_hdmkh");
	table.bootstrapTable({
		striped : true, //是否显示行间隔色
		 search: false, 
		// toolbar: '#toolbar',                //工具按钮用哪个容器
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //是否启用点击选中行
		sortable: true,          //是否启用排序
		sortOrder: "asc",       //排序方式
		 showRefresh: false,                  //是否显示刷新按钮
//		height : 500, 
		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		url: "",
		columns : [
//            {
//				field : 'rq',
//				title : '日期',
//				sortable : true
//			}, 
			{
				field : 'jzmc',
				title : '火电免考核机组',
				sortable : true
			}
		]
	});
}




//查询方法========================================================       
function query() {
	
	var rq = $("#querydate").val(); 
	$.ajax({
		type : "POST",
		url : 'qxkhzd_query.action',
	    dataType: "json",
		data : {
			"rq" : rq
		},
		success : function(data) {
			$('#dataList_table').bootstrapTable('load', data);
		}
	});
	
//	query_fd();

}





//删除方法==========且删除后查询============================================================ 
function delrow() {
	  var rq = $("#querydate").val(); 
		var table = $("#dataList_table");
		var a = table.bootstrapTable('getSelections');
		if (a.length == 0) {
//			alert("请选中要刪除的行");
			var str="";
			layer.alert(str+="请选中要刪除的行！\r\n",{
	            title: '提示框',				
				icon:0,								
			 }); 
			return false;
		}

//		var array = [];

		var data_all ='';
		for (var i = 0; i < a.length; i++) {
			var data = "";
			data += a[i].jzmc;

			if(i==0){
				data_all+= rq+"@"+a[i].jzmc+"@"+a[i].qssj+"@"+a[i].zzsj
	
			}else{
				data_all += "&" +rq+"@"+a[i].jzmc+"@"+a[i].qssj+"@"+a[i].zzsj
			}
		}
		
  	$.ajax({
  		type : "POST",
  		url : 'qxkhzd_delete.action',
  	    dataType: "json",
  		data : {
  			"rq":rq,
  			"data_all" : data_all
  
  		},
  		success : function(data) {

  			var str="";
  			layer.alert(str+=data+"！\r\n",{
  	            title: '提示框',				
  				icon:0,								
  			 }); 
   		},
   		 error: function () {
   			layer.alert(str+="删除失败！\r\n",{
  	            title: '提示框',				
  				icon:0,								
  			 });
           
  		}
  	});
		
		
		query();
	}


//曲线考核指定---类型===============================================================================  
function lx() {
    var result = [];
    $.ajax({
		type : "POST",
		url : 'qxkhzd_lx.action',
		async: false, //如果不设置这里 将取不到值
	    dataType: "json",
		data : {
			"rq" : "2018-05-01"
		},
		success : function(data) {
			$('#form-field-select-lx').empty();
			
			for(var i = 0; i < data.length; i++){       
				var ID  = data[i]['ID'];  
                var Name = data[i]['Name'];  
                result.push({ value:ID, text:Name });
                $('#form-field-select-lx').append('<option value='+ID+'>'+Name+'</option>');

			} 
		}
    });
                                    
    return result;
}


//曲线考核指定---备注原因===============================================================================  
function bz() {
    var result = [];
    $.ajax({
		type : "POST",
		url : 'qxkhzd_bz.action',
		async: false, //如果不设置这里 将取不到值
	    dataType: "json",
		data : {
			"rq" : "2018-05-01"
		},
		success : function(data) {
			$('#form-field-select-bzyy').empty();
			
			for(var i = 0; i < data.length; i++){       
				var ID  = data[i]['ID'];  
                var Name = data[i]['Name'];  
                result.push({ value:ID, text:Name });
                
                $('#form-field-select-bzyy').append('<option value='+ID+'>'+Name+'</option>');

			} 
		}
    });
                                    
    return result;
}

//曲线考核指定---时间===============================================================================  
function sd(){
	var result =[];
	result= ['00:15','00:30','00:45','01:00','01:15','01:30','01:45','02:00','02:15','02:30','02:45','03:00','03:15','03:30','03:45','04:00','04:15','04:30','04:45','05:00','05:15','05:30','05:45','06:00','06:15','06:30','06:45','07:00','07:15','07:30','07:45','08:00','08:15','08:30','08:45','09:00','09:15','09:30','09:45','10:00','10:15','10:30','10:45','11:00','11:15','11:30','11:45','12:00','12:15','12:30','12:45','13:00','13:15','13:30','13:45','14:00','14:15','14:30','14:45','15:00','15:15','15:30','15:45','16:00','16:15','16:30','16:45','17:00','17:15','17:30','17:45','18:00','18:15','18:30','18:45','19:00','19:15','19:30','19:45','20:00','20:15','20:30','20:45','21:00','21:15','21:30','21:45','22:00','22:15','22:30','22:45','23:00','23:15','23:30','23:45','24:00'];
	return result;
}


function sj() {
    var result = [];
    result.push({ value:'00:15', text:'00:15'});
    var result_sd = [];
    result_sd =sd();

    $('#form-field-select-qssj').empty();
    $('#form-field-select-zzsj').empty();
    for(var i = 0; i < 96; i++){       
    	 result.push({ value:result_sd[i], text:result_sd[i]});
    	 
    	 $('#form-field-select-qssj').append('<option>'+result_sd[i]+'</option>');
    	 $('#form-field-select-zzsj').append('<option>'+result_sd[i]+'</option>');
    	 
		} 
                                       
    return result;
}



//保存方法===================================================================

function Save() {
	var rq = $("#querydate").val(); 
	
	var data_all = [];
	  var temp_fd = $('[name="duallistbox_demo2"]').val()
	  data_all=data_all.concat(temp_fd);
	  
	  var temp_hdkh = $('[name="duallistbox_demo3"]').val()
	  data_all=data_all.concat(temp_hdkh);
	  
	  var temp_hdmkh = $('[name="duallistbox_demo4"]').val()
	  data_all=data_all.concat(temp_hdmkh);
	  
	  var qssj = $("#form-field-select-qssj option:selected").val();
	  var zzsj = $("#form-field-select-zzsj option:selected").val();

	  if(qssj > zzsj ){
		  var str="";
			layer.alert(str+="“起始时间 ” 不能大于   “终止时间 ” ，请从新选择！\r\n",{
				title: '提示框',				
				icon:0,								
			}); 
			return false;
	  }
	  
	  
	$.ajax({
		type : "POST",
		//url : 'jzzt1.action',  //测试用
		url : 'qxkhzd_add_Save.action',
	    dataType: "json",
		data : {
			"rq" : rq,
			 "jzmc_all":data_all,
			 "qssj":$("#form-field-select-qssj option:selected").val(),
			 "zzsj":$("#form-field-select-zzsj option:selected").val(),
			 "lx":$("#form-field-select-lx option:selected").val(),
			 "bzyy":$("#form-field-select-bzyy option:selected").val()
		},
		traditional: true,//属性在这里设置 可以传数组了
		success : function(data) {
//			alert(data);
			var str="";
			layer.alert(str+=data+"！\r\n",{
	            title: '提示框',				
				icon:0,								
			 }); 
			
			query();
			
 		},
 		 error: function () {

             var str="";
 			layer.alert(str+="编辑失败！\r\n",{
 	            title: '提示框',				
 				icon:0,								
 			 }); 
         
		}
	});

}



//初始化弹出框里的 左右选择列

//火电考核
function init_hdkh(){
    
    $('#form-field-select-hdkh').empty();
   //火电考核机组序列
 //   var result_hdjzkh = [];
    $.ajax({
		type : "POST",
		url : 'qxkhzd_hdkh_query.action',
		async: false, //如果不设置这里 将取不到值
	    dataType: "json",
		data : {
			"rq" : "2018-05-01"
		},
		success : function(data) {
			$('#dataList_table_hdkh').bootstrapTable('load', data);
//			$('#form-field-select-hdkh').empty();
			for(var i = 0; i < data.length; i++){       
			//	var ID  = data[i]['ID'];  
                var Name = data[i]['jzmc'];  
          
               $('#form-field-select-hdkh').append(' <option value="'+Name+'" >'+Name+'</option>');           

			} 
		}
    });
    
       var demo2 = $('.demo2').bootstrapDualListbox({
        nonSelectedListLabel: '<font color="#428bca">火电考核机组</font>',
        selectedListLabel: '已选',
       /* preserveSelectionOnMove: 'moved',*/
        moveOnSelect: false,

      }); 
       
    }

//火电免考核

function init_hdmkh(){
    
    $('#form-field-select-hdmkh').empty();
    //火电考核机组序列
  //   var result_hdjzkh = [];
     $.ajax({
 		type : "POST",
 		url : 'qxkhzd_hdmkh_query.action',
 		async: false, //如果不设置这里 将取不到值
 	    dataType: "json",
 		data : {
 			"rq" : "2018-05-01"
 		},
 		success : function(data) {
 			$('#dataList_table_hdmkh').bootstrapTable('load', data);
// 			$('#form-field-select-hdkh').empty();
 			for(var i = 0; i < data.length; i++){       
 			//	var ID  = data[i]['ID'];  
                 var Name = data[i]['jzmc'];  
           
                $('#form-field-select-hdmkh').append(' <option value="'+Name+'" >'+Name+'</option>');           

 			} 
 		}
     });
    
      var demo2 = $('.demo3').bootstrapDualListbox({
        nonSelectedListLabel: '<font color="#428bca">火电默认不考核机组</font>',
        selectedListLabel: '已选',
        preserveSelectionOnMove: 'moved',
        moveOnSelect: false,
    
      });
      
    }

//风电考核列


function init_fd(){
$('#form-field-select-fd').empty();
//火电考核机组序列
//   var result_hdjzkh = [];
 $.ajax({
		type : "POST",
		url : 'qxkhzd_fd_query.action',
		async: false, //如果不设置这里 将取不到值
	    dataType: "json",
		data : {
			"rq" : "2018-05-01"
		},
		success : function(data) {
			$('#dataList_table_fd').bootstrapTable('load', data);
//			$('#form-field-select-hdkh').empty();
			for(var i = 0; i < data.length; i++){       
			//	var ID  = data[i]['ID'];  
             var Name = data[i]['jzmc'];  
       
            $('#form-field-select-fd').append(' <option value="'+Name+'" >'+Name+'</option>');           

			} 
		}
 });
 
 
  var demo2 = $('.demo4').bootstrapDualListbox({
    nonSelectedListLabel: '<font color="#428bca">风电站</font>',
    selectedListLabel: '已选',
    preserveSelectionOnMove: 'moved',
    moveOnSelect: false,
   /*  nonSelectedFilter: 'ion ([7-9]|[1][0-2])' */
  });
  
}
