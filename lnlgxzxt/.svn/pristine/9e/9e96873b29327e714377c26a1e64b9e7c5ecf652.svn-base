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
        	var table = $("#dataList_table");
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
        			/*{
                        checkbox: true
                    },
        			{
        				field : 'rq',
        				title : '日期',
        				sortable : true
        				
        			},*/
        			
        			{
        				field : 'jzmc',
        				title : '机组名称',
        		/*		colspan: 1,  
        				 rowspan: 2,*/
//        				sortable : true
        			}, {
        				field : 'bc',
        				title : '班次',
//        				sortable : true
        			}, {
        				field : 'yxcl1',
        				title : '影响出力1',
//        				sortable : true	
        				
        			}, {
        				field : 'yxcl2',
        				title : '影响出力2'				
        			}, {
        				field : 'yxcl3',
        				title : '影响出力3'        					
        			},
        			{
        				field : 'yxcl4',
        				title : '影响出力4',
        			},
        			{
        				field : 'yxcl5',
        				title : '影响出力5',
        			}
        		]
        	});
        }

        
//查询方法========================================================       
        
        function query() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'jzyxcl_query.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        			
        			var data = $('#dataList_table').bootstrapTable('getData', true);
                    //合并单元格
                    mergeCells(data, "jzmc", 1, $('#dataList_table'));
        		},
        		
        	});

        }

    
   /*     $('#TableName').bootstrapTable('mergeCells', { index: 0, field: '类别名称', colspan: 0, rowspan: 1});

        index  是重第几行开始           colspan ： 跨几列    rowspan ： 跨几行*/

  
  

