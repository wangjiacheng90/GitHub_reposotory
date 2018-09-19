//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
/*laydate({
            elem: '#querydate',
            type: 'month',
            format: 'YYYY-MM',
            event: 'focus' 
        });*/
         
        //初始赋值      
         $('#querydate').val(getNowFormatDateJD());

        
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
        		
//        		height : ($(window).height()-110),
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			[
        				
        				{
            				field : 'field1',
            				title : '项目名称',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2,
             	            width:100
            	
            			},
            			{
            				field : 'field2',
            				title : '总补偿费用',
            				valign:"middle",
            	            align:"center",
            				colspan: 1,
            	            rowspan: 2,
             	            width:100
            			},{
            				/*field : 'field4',*/
            				title : '参与范围',
            				valign:"middle",
            	            align:"center",
            				colspan: 2,
            	            rowspan: 1,
             	            width:200
            			},{
            				field : 'field5',
            				title : '计量公式',
            				valign:"middle",
            	            align:"center",
            				colspan: 1,
            	            rowspan: 2,
             	            width:100
            			},{
            				field : 'field6',
            				title : '限价情况',
            				valign:"middle",
            	            align:"center",
            				colspan: 1,
            	            rowspan: 2,
             	            width:100
            			}
            			,{
            				field : 'field7',
            				title : '实际成交'+'<br>'+'均价',
            				valign:"middle",
            	            align:"center",
            				colspan: 1,
            	            rowspan: 2,
             	            width:100
            			}
      				
        			],
        			[
        				{
            				field : 'field3',
            				title : '电厂',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field4',
            				title : '用户',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			}			
        				
        			]			
        			
        			]
        		
     
        	});
        }

        
//查询方法========================================================       
        
        function query() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'jdbb3_query.action',
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
        	$('#dataList_table').tableExport({ type: 'excel', fileName: '表3-竞价选择电力辅助服务提供方费用明细表',worksheetName: 'sheet1', tableName: '信息', excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],  escape: 'false' })
        }

        
        
        
        function hz(){
        	var rq = $("#querydate").val(); 
       	 
        	$.ajax({
        		type : "POST",
        		url : 'jdbb3_hz.action',
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

