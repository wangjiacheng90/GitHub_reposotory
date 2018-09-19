//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
laydate({
            elem: '#querydate',
        
            event: 'focus' 
        });
        
        laydate({
            elem: '#start',
        
            event: 'focus' 
        });

         laydate({
            elem: '#end',
        
            event: 'focus' 
        });
         
/*         laydate({
             elem: '#add_history_sdate',
         
             event: 'focus' 
         });*/

         laydate({
             elem: '#add_history_sdate',
         
             event: 'focus' 
         });
         
         laydate({
             elem: '#add_history_ddate',
         
             event: 'focus' 
         });
        
         
         
         var zt_date_time = {
        elem:'#zt_date',
        format:'YYYY-MM-DD hh:mm',
//        min:laydate.now(),//是否可以选择过去
        max:'2999-12-31 23:59',
        istime:true,//是否显示时分秒
        istoday:true,//是否显示【今天】的按钮
        isclear:true,//是否显示【清空】的按钮
        festival: true,//是否显示节日
        start: laydate.now(0,"YYYY-MM-DD hh:mm"),  // 开始日期
        fixed: false,   // 是否固定在可视区域
        zIndex: 10000,  // css控制图层的遮罩效果（效果不明显）
        choose: function(dates){  // 选择好日期的回调
        }
    }
    laydate(zt_date_time);
         
         
         var zt_date_add_time = {
     	        elem:'#zt_date_add',
     	        format:'YYYY-MM-DD hh:mm',
//     	        min:laydate.now(),//是否可以选择过去
     	        max:'2999-12-31 23:59',
     	        istime:true,//是否显示时分秒
     	        istoday:true,//是否显示【今天】的按钮
     	        isclear:true,//是否显示【清空】的按钮
     	        festival: true,//是否显示节日
     	        start: laydate.now(0,"YYYY-MM-DD hh:mm"),  // 开始日期
     	        fixed: false,   // 是否固定在可视区域
     	        zIndex: 10000,  // css控制图层的遮罩效果（效果不明显）
     	        choose: function(dates){  // 选择好日期的回调
     	        }
     	    }
     	    laydate(zt_date_add_time);

        //初始赋值
         
         $('#querydate').val(getNowFormatDate());
         $('#start').val(getNowFormatDate());
        $('#end').val(getNowFormatDate());
        $('#zt_date').val(getCurrentTime());
        $('#zt_date_add').val(getCurrentTime());
              
// 定义几个全局变量做为初始化用===用在table初始化表头时定义field用============================================     

        
        var result_lx = [];
        var result_jzdqzt = [];
 // 初始化数据 和加载数据       
        function field_load(){
       
    	result_lx=lx();
    	
    	result_jzdqzt=jzdqzt();
        }
        
        
 //初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
       
        window.onload = $(function(){
        	field_load();  //初始化表头里内容的判断

        	tableinit(); // 初始化表头
        	query();	//查询
        	queryJZMC();  //查询机组
        	queryJZZT();  //查询状态
        	queryJZLX();   //查询内容
        	
        });

 //初始化表头，其中包含了设定要编辑的列=============================================
        
        function tableinit() {
        	var table = $("#dataList_table");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: true, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
//        		height : 500, 
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
        			}, {
        				field : 'rl',
        				title : '容量',
        				sortable : true,
        				visible:false   //可以设置隐藏
        				/*editable: {
                            type: 'text',
                            title: '容量',
                            validate: function (v) {
                            	if (!v) return '容量不能为空';
                                if (isNaN(v)) return '容量必须是数字';
                                var age = parseInt(v);
                                if (age <= 0) return '容量必须是正整数';
                            }
                        }*/
        			}, {
        				field : 'dqzt',
        				title : '当前状态',
        				sortable : true,
        				editable: {
                            type: 'select',
                            title: '当前状态',
//                            source:[{value:"检修",text:"检修"},{value:"运行",text:"运行"},{value:"停机",text:"停机"}]
                           source: result_jzdqzt
                        }
        			}, {
        				field : 'lx',
        				title : '类型',
        				sortable : true,
        				editable: {
                            type: 'select',
                            title: '类型',
//                            source:[{value:"检修跳闸",text:"检修跳闸"},{value:"检修停机",text:"检修停机"}],
                            source: result_lx
                           
                        }
        				
        			}, {
        				field : 'rfdl',
        				title : '日发电量',
        				sortable : true,
        				visible:false
//        				editable: {
//                            type: 'text',
//                            title: '日发电量',
//                            validate: function (v) {
//                            	if (!v) return '容量不能为空';
//                                if (isNaN(v)) return '容量必须是数字';
//                                
//                            }
//                        }
        					
        			}, {
        				field : 'ztsj',
        				title : '状态发生时间',
        				sortable : true,
        				//获取日期列的值进行转换
        			    formatter: function (value, row, index) { 
        			        
        			        var aa = value;

                            return aa;
        			    },
        				 editable: {
        		                type: 'datetime',
        		                placement: 'left',
        		                title:'状态发生时间'  
        		                
        		            } 
        					
        			}
        		],
        		
        		onEditableSave: function (field, row, oldValue, $el) {
        			$('#dataList_table').bootstrapTable("resetView");
        			var rq = $("#querydate").val(); 
        			 $.ajax({
                 		type : "POST",
                 		url : 'jzztSave.action',
                 		async: false, //如果不设置这里 将取不到值
                 	    dataType: "json",
                 		data : {
                 			"rq" : rq,
                 			"jzmc": row.jzmc,
                 			"rl":row.rl,
                 			"dqzt":row.dqzt,
                 			"lx":row.lx,
                 			"rfdl":row.rfdl,
                 			"ztsj":row.ztsj,
                 			"index":oldValue
                 			
                 		},
                 		success : function(data) {
//                 			 alert(row.lx);
                 			var str="";
                			layer.alert(str+=data+"！\r\n",{
                	            title: '提示框',				
                				icon:0,								
                			 });
                 		},
                 		 error: function () {
//                             alert('编辑失败');
                         	var str="";
                			layer.alert(str+="编辑失败！\r\n",{
                	            title: '提示框',				
                				icon:0,								
                			 });
                         }
                     });
        			
                    /*$.ajax({
                        type: "post",
                        url: "/Editable/Edit",
                        data: row,
                        dataType: 'JSON',
                        success: function (data, status) {
                            if (status == "success") {
                                alert('提交数据成功');
                            }
                        },
                        error: function () {
                            alert('编辑失败');
                        },
                        complete: function () {

                        }

                    });*/
                }
        	});
        }

        
//查询方法========================================================       
        
        function query() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'jzzt.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }


        function querya() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'jzzt.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }

        
        
//      保存方法===================================================================

        function Save() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'jzzt_add_Save.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			 "jzmc":$("#form-field-select-1 option:selected").val(),
        			 
        			 "dqzt":$("#form-field-select-2 option:selected").val(),
        			 
        			 "lx":$("#form-field-select-3 option:selected").val(),
        			 "ztsj":$("#zt_date_add").val()
        		},
        		success : function(data) {
//        			alert(data);
        			var str="";
        			layer.alert(str+=data+"！\r\n",{
        	            title: '提示框',				
        				icon:0,								
        			 }); 
        			
        			querya();
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
        
//      更新方法================================================================================

        function Update() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'jzzt_update.action',
        	    dataType: "json",
        		data : {
        			"rq":rq,
        			"start_date" : $('#start').val(),
        			"end_date":$('#end').val(),
        			 "jzmc":$("#jzmc").val(),
        			 "dqzt":$("#jzzt").val(),
        			 "lx":$("#jzlx").val(),	 
        			 "ztsj":$("#zt_date").val()
        		},
        		success : function(data) {
        			var str="";
        			layer.alert(str+=data+"！\r\n",{
          				title: '提示框',				
          				icon:0,								
          			}); 
         		},
         		 error: function () {
                     alert('编辑失败');
                 
        		}
        	});

        }
        
        

//      导入历史==============================================================

      function add_history() {
    	/*  var rq = $("#querydate").val(); */
   
    	  var rq =$('#add_history_ddate').val();
      	  var history_date =$("#add_history_sdate").val();
      	  
      	 
      		 if(rq == history_date){
      		var str="";
  			layer.alert(str+="“源数据日期 ” 不能与   “目的日期 ” 相同，请从新选择日期 ！\r\n",{
  				title: '提示框',				
  				icon:0,								
  			}); 
  			return false;
      		} 
      	  
      	      	
      	$.ajax({
      		type : "POST",
      		//url : 'jzzt1.action',  //测试用
      		url : 'jzzt_add_history.action',
      	    dataType: "json",
      		data : {
      			"rq" : rq,
      			"history_date":history_date

      		},
      		success : function(data) {
      			var str="";
      			layer.alert(str+=data+"！\r\n",{
      				title: '提示框',				
      				icon:0,								
      			}); 
       		},
       		 error: function () {
                   alert('编辑失败');
               
      		}
      	});

      }
        
        
        
    //查询类型的方法，本实例 用在了 机组名称、状态、类型等方法的的封装，可供“下拉框”及“tale判断用”=============================

        function queryJZMC() {	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'jzzt_jzmc.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05"
        		},
        		success : function(data) {

        			$('#jzmc').empty(); //初始化菜单栏
        			
        			$('#form-field-select-1').empty();  //初始化添加栏
        			
        			for(var i = 0; i < data.length; i++){                         
        				var name  = data[i]['jzmc'];  
        				
       				$('#jzmc').append('<option>'+name+'</option>');
       				$('#form-field-select-1').append('<option>'+name+'</option>');
        			 
        			} 
        			
        		}
        	});

        }
        
        
  function queryJZZT() {	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'jzzt_dqzt.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05"
        		},
        		success : function(data) {

        			$('#jzzt').empty();
        			$('#form-field-select-2').empty();
        			for(var i = 0; i < data.length; i++){                         
        				var name  = data[i]['Name'];  
        				
        				$('#jzzt').append('<option>'+name+'</option>');
        				$('#form-field-select-2').append('<option>'+name+'</option>');
        			 
        			} 
        			
        		}
        	});

        }
  
  function queryJZLX() {	 
  	
  	$.ajax({
  		type : "POST",
  		url : 'jzzt_lx.action',
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-05"
  		},
  		success : function(data) {

  			$('#jzlx').empty();
  			$('#form-field-select-3').empty();
  			for(var i = 0; i < data.length; i++){                         
  				var name  = data[i]['Name'];  
  				
 				$('#jzlx').append('<option >'+name+'</option>');
 				$('#form-field-select-3').append('<option >'+name+'</option>');
  				
  			 
  			} 
  			
  		}
  	});

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

		var array = [];
		var jzmc_all ='';
		for (var i = 0; i < a.length; i++) {
			var data = "";
			data += a[i].jzmc;
//			data += "&" + a[i].lx;
			array.push(data);
			if(i==0){
				jzmc_all += a[i].jzmc;
			}else{
			jzmc_all += "&" +a[i].jzmc;
			}
		}
		
    	$.ajax({
    		type : "POST",
    		url : 'jzzt_delete.action',
    	    dataType: "json",
    		data : {
    			"rq":rq,
    			"jzmc_all" : jzmc_all
    
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
		
		
//    更新提示栏信息
//		$('#delete_message').empty();
//		document.getElementById("delete_message").innerHTML = "<p> 删除共 "+a.length+"条 机组 信息 </p>";
//		$("#tip_delete").fadeIn(200);
		
		query();
	}


//  $(function(){
//可编辑 添加
//	   $('#dataList_table').editable('Disabled');
//	   //enable / disable
//	      
//  })
  
  
  function lx() {
      var result = [];
      $.ajax({
  		type : "POST",
  		url : 'jzzt_lx.action',
  		async: false, //如果不设置这里 将取不到值
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-01"
  		},
  		success : function(data) {
  			for(var i = 0; i < data.length; i++){       
  				var ID  = data[i]['ID'];  
                  var Name = data[i]['Name'];  
                  result.push({ value:ID, text:Name });
  			} 
  		}
      });
                                      
      return result;
  }
  
  
  function jzdqzt() {
      var result = [];
      $.ajax({
  		type : "POST",
  		url : 'jzzt_dqzt.action',
  		async: false, //如果不设置这里 将取不到值
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-01"
  		},
  		success : function(data) {
  			for(var i = 0; i < data.length; i++){       
  				var ID  = data[i]['ID'];  
                  var Name = data[i]['Name'];  
                  result.push({ value:ID, text:Name });

  			} 
  		}
      });
                                      
      return result;
  }
  
  
//以下为时间格式的设定，需要自己封装时间格式 ---当前时刻的日期-----当前时刻的日期+时分秒 
  
//获取当前时间，格式YYYY-MM-DD
  function getNowFormatDate() {
      var date = new Date();
      var seperator1 = "-";
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var strDate = date.getDate();
      if (month >= 1 && month <= 9) {
          month = "0" + month;
      }
      if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
      }
      var currentdate = year + seperator1 + month + seperator1 + strDate;
      return currentdate;
  }


/** 
 * 获取当前时间 格式：yyyy-MM-dd HH:MM
 */  
function getCurrentTime() {  
    var date = new Date();//当前时间  
    var month = zeroFill(date.getMonth() + 1);//月  
    var day = zeroFill(date.getDate());//日  
    var hour = zeroFill(date.getHours());//时  
    var minute = zeroFill(date.getMinutes());//分  
    var second = zeroFill(date.getSeconds());//秒  
      
    //当前时间  
    var curTime = date.getFullYear() + "-" + month + "-" + day  
            + " " + hour + ":" + minute ;  
      
    return curTime;  
}  
  
/** 
 * 补零 
 */  
function zeroFill(i){  
    if (i >= 0 && i <= 9) {  
        return "0" + i;  
    } else {  
        return i;  
    }  
} 
