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
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
        		height : ($(window).height()-115),
//        		height : 500, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
        				field : 'xh',
        				title : ' 序 ',
        				sortable : true
        			},
        			 {
        				field : 'dcmc',
        				title : ' 电厂名称 ',
        				sortable : true
        			}, {
        				field : 'AGCfy',
        				title : ' AGC服务费用',
        				sortable : true	
       				
        			}, {
        				field : 'qttffy',
        				title : ' 启停调峰费用',
        				sortable : true	
       				
        			}, {
        				field : 'hqdfy',
        				title : '黑启动费用',
        				sortable : true	
       				
        			}, {
        				field : 'wgbcfy',
        				title : '无功补偿费用',
        				sortable : true	
       				
        			},
        			{
        				field : 'xzbyfy',
        				title : '旋转备用费用 ',
        				sortable : true
       			
        			},
        			{
        				field : 'hj',
        				title : ' 合计 ',
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
        		url : 'fzfwjs_table_query.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        			
        		}
        	});

        }

//输出Excel方法
        function exportExcel(){
        	$('#dataList_table').tableExport({ type: 'excel', fileName: '辽宁电网辅助服务结算清单',worksheetName: 'sheet1', tableName: '信息', excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],  escape: 'false' })
        }

        
  
   //   参数参考     function loadwindow(width,height,data1,data2,data3){
        function transToDwindow(dcmc,zy) {
        	var title_data = zy+"评分详细查询";
        	loadwindow(500,300,dcmc,zy,title_data);
        	
        }
        
//        封装的方法——被dwindow_title 调用
        function dwindow_content_datadiv(Data1,Data2){
        	
        	
        	tableinit_dwindow();
        	
        	query_dwindow(Data1,Data2);

        }
        
        function tableinit_dwindow() {
        	var table = $("#dataList_table1");

        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: false, 
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		 showRefresh : false, //是否显示刷新按钮
        		 height : 270, 
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			
        			{
        				field : 'rq',
        				title : '日期 ',
        				sortable : true,
        	
        				
        			}, {
        				field : 'zy',
        				title : '专业 ',
        				sortable : true
       				
        			}, {
        				field : 'dcmc',
        				title : ' 电厂名称',
        				sortable : true
        			}, {
        				field : 'fy',
        				title : ' 费用',
        				sortable : true	
       				
        			},
        			
        		],
        		
        	});
        	
        	/* $('#dataList_table1').bootstrapTable('resetView');*/
        }
        
        function query_dwindow(dcmc_dwindow,zy_dwindow) {
        	var rq = $("#querydate").val(); 
        	 
        	$.ajax({
        		type : "POST",
        		url : 'fzfwjs_dwtable_query.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			"dcmc":dcmc_dwindow,
        			"zy" : zy_dwindow
        		},
        		success : function(data) {
        			$('#dataList_table1').bootstrapTable('load', data);
        			
        		}
        	});

        }
        
        
        function hz(){
        	var rq = $("#querydate").val(); 
       	 
        	$.ajax({
        		type : "POST",
        		url : 'fzfwjs_hz.action',
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
        			
        		}
        	});
        	
        }
        
        
        
//      刷新=======================================================
        $(window).resize(function () {
            $('#dataList_table').bootstrapTable('resetView');
        });  
 
