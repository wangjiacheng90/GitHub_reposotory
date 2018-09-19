//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
laydate({
            elem: '#querydate',
            type: 'month',
            format: 'YYYY-MM',
            event: 'focus' 
        });
         
        //初始赋值      
         $('#querydate').val(getNowFormatDateMonth());

        
 //初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
       
        window.onload = $(function(){

        	tableinit(); // 初始化表头
        	query();	//查询
        	
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
        				field : 'rq',
        				title : '日期',
        				sortable : true
        				
        			}, {
        				field : 'dcmc',
        				title : '电厂名称',
        				sortable : true
        			}, {
        				field : 'xqgl',
        				title : '限前功率',
        				sortable : true
        			}, {
        				field : 'xhgl',
        				title : '限后功率',
        				sortable : true	
        				
        			}, {
        				field : 'qssj',
        				title : '起始时间'				
        			}, {
        				field : 'zzsj',
        				title : '终止时间'        					
        			},
        			{
        				field : 'xddl',
        				title : '限电电量',
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
        		url : 'fdxd_query.action',
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

        function Save() {}
        
//      更新方法================================================================================

        function Update() {}
        
        

//      导入历史==============================================================

      function add_history() {}
        
        
        
    //查询类型的方法，笨实例 用在了 机组名称、状态、类型等方法的的封装，可供“下拉框”及“tale判断用”=============================

        function queryJZMC() {}
        
        
  function queryJZZT() {}
  
  function queryJZLX() {}
  
  
  
//删除方法==========且删除后查询============================================================ 
 
  function delrow() {}

  
  
  function lx() {}
  
  
  function jzdqzt() {}
  
  
 
