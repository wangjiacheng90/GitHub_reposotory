//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
laydate({
            elem: '#querydate',

            event: 'focus' 
        });
         
        //初始赋值      
         $('#querydate').val(getNowFormatDate());

        
 //初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
       
        window.onload = $(function(){

        	tableinit(); // 初始化表头
        	query();	//查询
        	
        });

 //初始化表头，其中包含了设定要编辑的列=============================================
        function tableinit() {
        	 tableinit1();
        	 tableinit2();
        	 tableinit3();
        	 tableinit4();
        }
        
//        运行调峰表头
        function tableinit1() {
        	var table = $("#dataList_table1");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			
        			{
        				field : 'dcmc',
        				title : '电厂名称',
        				sortable : true
        			}, {
        				field : 'bj1',
        				title : '第一档报价',
        				sortable : true
        			}, {
        				field : 'bj2',
        				title : '第二档报价',
        				sortable : true	
        				
        			}
        		]
        	});
        }

//      开停调峰表头
        function tableinit2() {
        	var table = $("#dataList_table2");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
        				field : 'jzmc',
        				title : '机组名称',
        				sortable : true
        			}, {
        				field : 'bj',
        				title : '报价',
        				sortable : true
        			}
        		]
        	});
        }
        
//      出力限制表头
        function tableinit3() {
        	var table = $("#dataList_table3");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
        				field : 'mc',
        				title : '名称',
        				sortable : true
        			}, {
        				field : 'ktsx',
        				title : '可调上限',
        				sortable : true
        			}, {
        				field : 'ktxx',
        				title : '可调下限',
        				sortable : true	
        				
        			}
        		]
        	});
        }
        
        
//      最后报价表头
        function tableinit4() {
        	var table = $("#dataList_table4");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
        				field : 'sj',
        				title : '时间',
        				sortable : true
        			},
        			{
        				field : 'dcmc',
        				title : '电厂名称',
        				sortable : true
        			}, {
        				field : 'bj1',
        				title : '第一档报价',
        				sortable : true
        			}, {
        				field : 'bj2',
        				title : '第二档报价',
        				sortable : true	
        				
        			}
        		]
        	});
        }
        
//查询方法========================================================    
        function query(){
        	query1();
        	query2();
        	query3();
        	query4();
        }
        
//        运行调峰查询
        function query1() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'tfscbj_yxtf_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table1').bootstrapTable('load', data);
        		}
        	});

        }
        
//      开停调峰查询
        function query2() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'tfscbj_kttf_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table2').bootstrapTable('load', data);
        		}
        	});

        }
        
//      出力限制
        function query3() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'tfscbj_clxz_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table3').bootstrapTable('load', data);
        		}
        	});

        }

//      最后报价
        function query4() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'tfscbj_zhbj_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table4').bootstrapTable('load', data);
        		}
        	});

        }
    

  
 
