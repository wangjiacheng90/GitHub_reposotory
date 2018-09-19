//日期设置
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

//        		 height : 500, 
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
         				field : 'dqzt',
         				title : '当前状态',
         				sortable : true
         			}, {
         				field : 'lx',
         				title : '类型',
         				sortable : true
         			},
         			{
         				field : 'ztsj',
         				title : '状态发生时间',
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
        		 url : 'jzztbh_query.action',
        		 dataType: "json",
        		 data : {
        			 "rq" : rq
        		 },
        		 success : function(data) {
        			 $('#dataList_table').bootstrapTable('load', data);
        		 }
        	 });

             }
         
         
         