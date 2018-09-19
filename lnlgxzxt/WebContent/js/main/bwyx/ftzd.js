//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间

// 日期定义 及初始化复制的js配置========================================
laydate({
            elem: '#querydate',
            type: 'month',
            format: 'YYYY-MM',
            event: 'focus' 
        });

laydate({
    elem: '#dr_YYYY_MM_date',
    type: 'month',
    format: 'YYYY-MM',
    event: 'focus' 
});

//laydate.render({
//	  elem: '#querydate' //指定元素
//	   ,type: 'month',
//	   event: 'focus' 
//	   
//	});

var zt_date_add_time = {
	        elem:'#zt_date_add',
	        format:'YYYY-MM-DD hh:mm',
//	        min:laydate.now(),//是否可以选择过去
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
           $('#querydate').val(getNowFormatDateMonth);
           $('#zt_date_add').val(getCurrentTime());
         

// 定义几个全局变量做为初始化用===用在table初始化表头时定义field用============================================     

        var result_ftzdzt = [];
 // 初始化数据 和加载数据       
        function field_load(){
    	
        	result_ftzdzt=ftzt();
        }
        
        
//初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
        window.onload = $(function(){
        	field_load();  //初始化表头里内容的判断

        	tableinit(); // 初始化表头
        	query();	//查询
        	
        	tableinit1(); // 初始化表头
        	
        	tableinit2()
        	
        	
        	query_ftbm();
        	queryJZMC();  //查询机组
        	
//        	queryFTZT();  //查询弹出添加框里的非停状态
//        	queryJZLX();   //查询类型
        	
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
//        		height : 500,                           
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
                        checkbox: true
                    },
                    {
        				field : 'rq',
        				title : '日期',
        				sortable : true
        			}, 
        			{
        				field : 'jzmc',
        				title : '机组',
        				sortable : true
        			}, {
        				field : 'ftzt',
        				title : '非停状态',
        				editable: {
                            type: 'select',
                            title: '非停状态',
//                            source:[{value:"检修",text:"检修"},{value:"运行",text:"运行"},{value:"停机",text:"停机"}]
                           source: result_ftzdzt
                        }
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
//        			var rq = $("#querydate").val(); 
        			 $.ajax({
                 		type : "POST",
                 		url : 'ftzd_table_save.action',
                 		async: false, //如果不设置这里 将取不到值
                 	    dataType: "json",
                 		data : {
                 			"rq" : row.rq,
                 			"jzmc": row.jzmc,
                 			"ftzt":row.ftzt,
                 			"ztsj":row.ztsj,
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

//非停状态编码_表头定义        
        function tableinit1() {
        	var table = $("#dataList_table1");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		sortable: true,      //是否启用排序
        		sortOrder: "asc",     //排序方式
        		 showRefresh: false,      //是否显示刷新按钮
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			
        			{
        				field : 'ftztmc',
        				title : '非停状态名称',
        				
        			}, {
        				field : 'fz',
        				title : '考核分值',
        				editable: {
                            type: 'text',
                            title: '考核分值',
                            validate: function (v) {
                            	if (!v) return '容量不能为空';
                                if (isNaN(v)) return '容量必须是数字';
                                var age = parseInt(v);
                                if (age <= 0) return '容量必须是正整数';
                            }
                        }
        			}
        		],
        		
        		onEditableSave: function (field, row, oldValue, $el) {
        			$('#dataList_table1').bootstrapTable("resetView");
        			var rq = $("#querydate").val(); 
        			 $.ajax({
                 		type : "POST",
                 		url : 'ftzdbm_table_save.action',
                 		async: false, //如果不设置这里 将取不到值
                 	    dataType: "json",
                 		data : {
                 			"ftztmc": row.ftztmc,
                 			"fz":row.fz,
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

        
 //初始化表头，其中包含了设定要编辑的列=============================================
        function tableinit2() {
        	var table = $("#dataList_table2");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		sortable: true,          //是否启用排序
        		sortOrder: "asc",       //排序方式
        		 showRefresh: false,                  //是否显示刷新按钮
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
                        checkbox: true
                    },
                    {
        				field : 'rq',
        				title : '日期',
        				sortable : true
        			}, 
        			{
        				field : 'jzmc',
        				title : '机组',
        				sortable : true
        			}, {
        				field : 'khfy',
        				title : '考核费用'
        			},
        		]
        	});
        }
        
        
        
 //查询方法========================================================       
        function query() {
        	
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'ftzd.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});
        	
        	query_khfy();

        }

//   查询非停编码
        function query_ftbm() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'ftzd_ftztbm.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table1').bootstrapTable('load', data);
        		}
        	});

        }
        
        
        //查询考核费用
        function query_khfy() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'ftzd_khfy.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table2').bootstrapTable('load', data);
        		}
        	});

        }

//        保存方法===================================================================
        function Save() {
        	var rq = $("#querydate").val(); 
        	
//        	document.getElementById("123").innerHTML =  "123123";
        	      	
        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'ftzd_add_Save.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			 "jzmc":$("#form-field-select-1 option:selected").val(),
        			 
        			 "ftzt":$("#form-field-select-2 option:selected").val(),
        			
        			 "ztsj":$("#zt_date_add").val()
        		},
        		success : function(data) {
//        			alert(data);
        			
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
      
      
//    导入机组记录==============================================================
      function add_drjzjl() {
    	/*  var rq = $("#querydate").val(); */
   
    	  var rq =$('#dr_YYYY_MM_date').val();
      	  
      	      	
      	$.ajax({
      		type : "POST",
      		//url : 'jzzt1.action',  //测试用
      		url : 'ftzd_add_drjzjl.action',
      	    dataType: "json",
      		data : {
      			"rq" : rq

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
        				
       				$('#jzmc').append('<option>'+name+'</option>');//初始化下拉框
       				$('#form-field-select-1').append('<option>'+name+'</option>');
        			 
        			} 
        			
        		}
        	});

        }
        
    
//        非停指定下拉框
  function queryFTZT() {	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'ftzd_ftzt.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05"
        		},
        		success : function(data) {

        		
        			$('#form-field-select-2').empty();
        			for(var i = 0; i < data.length; i++){                         
        				var name  = data[i]['Name'];  
        				
//        				
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
  
// 删除方法==========且删除后查询============================================================ 
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
				data_all+= a[i].rq+"@"+a[i].jzmc+"@"+a[i].ztsj
	
			}else{
				data_all += "&" +a[i].rq+"@"+a[i].jzmc+"@"+a[i].ztsj
			}
		}
		
    	$.ajax({
    		type : "POST",
    		url : 'ftzd_delete.action',
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
  
  
  
  //查询方法========================================================       
  function comput() {
  	
  	var rq = $("#querydate").val(); 
  	$.ajax({
  		type : "POST",
  		url : 'ftzd_comput.action',
  	    dataType: "json",
  		data : {
  			"rq" : rq
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
  	
  	
  	query_khfy();

  }



  

  
//非停指定---非停状态方法=下拉框==============================================================================  
  function ftzt() {
      var result = [];
      $.ajax({
  		type : "POST",
  		url : 'ftzd_ftzt.action',
  		async: false, //如果不设置这里 将取不到值
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-01"
  		},
  		success : function(data) {
  			$('#form-field-select-2').empty();
  			for(var i = 0; i < data.length; i++){       
  				var ID  = data[i]['ID'];  
                  var Name = data[i]['Name'];  
                  result.push({ value:ID, text:Name });
                  $('#form-field-select-2').append('<option>'+Name+'</option>');

  			} 
  		}
      });
                                      
      return result;
  }
  
  
    

  
