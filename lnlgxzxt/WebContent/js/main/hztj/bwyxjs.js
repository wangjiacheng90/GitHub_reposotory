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
        		
        		height : ($(window).height()-110),
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			[
        				{
            				field : 'xh',
            				title : ' 序 ',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            	
            			},
        				{
            				field : 'dcmc',
            				title : ' &nbsp &nbsp 电厂名称 &nbsp &nbsp',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            	
            			}, {
            				field : 'field1',
            				title : 'AGC服务',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            	
            			}, {
            				field : 'field2',
            				title : '安全管理',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            		
            			}, {
            				field : 'field3',
            				title : '电厂高压侧'+'<br>'+'电器设备',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			},
            			
            			{
            				/*field : 'field4',*/
            				title : '调度管理',
            				valign:"middle",
            	            align:"center",
            				colspan: 3,
            	            rowspan: 1
            			},
            			
            /*			{
            				field : 'field4',
            				title : '调度业务'+'<br>'+'管理'        					
            			},
            			{
            				field : 'field5',
            				title : '曲线违约考核',
            			},
            			{
            				field : 'field6',
            				title : '非计划停机'+'<br>'+'考核',
            			}
            			,*/
            			{
            				field : 'field7',
            				title : '调峰服务',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field8',
            				title : '风电考核',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field9',
            				title : '黑启动服务',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field10',
            				title : '机组检修',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			},
            			{
            				field : 'field11',
            				title : '继电保护',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			},
            			{
            				field : 'field12',
            				title : '励磁和'+'<br>'+'PSS装置'+'<br>'+'管理',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field13',
            				title : '水库调度',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field14',
            				title : '通信管理',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field15',
            				title : '无功调节',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
            			,
            			{
            				field : 'field16',
            				title : '一次调频',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			},
            			{
            				field : 'field17',
            				title : '自动化管理',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			},
            			{
            				field : 'field18',
            				title : ' &nbsp &nbsp 合计 &nbsp &nbsp',
            				valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2
            			}
        				
        			],
        		/*	[
        				{
            				field : 'field4',
            				title : '调度业务'+'<br>'+'管理',
            				colspan: 1,
             	            rowspan: 2
            			},
            			{
            				field : 'field5',
            				title : '计划曲线考核',
            				valign:"middle",
            	            align:"center",
            	            colspan: 2,
            	            rowspan: 1
            			}
        			],*/
        			[
        				{
            				field : 'field4',
            				title : '调度业务'+'<br>'+'管理',
            				valign:"middle",
            	            align:"center"
            			},
        				{
            				field : 'field5',
            				title : '曲线'+'<br>'+'考核',
            				valign:"middle",
            	            align:"center"
            			},
            			{
            				field : 'field6',
            				title : '非停'+'<br>'+'考核',
            				valign:"middle",
            	            align:"center"
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
        		url : 'bwyxjs_table_query.action',
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
        	$('#dataList_table').tableExport({ type: 'excel', fileName: '辽宁电网并网运行考核结算清单',worksheetName: 'sheet1', tableName: '信息', excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],  escape: 'false' })
        }

        
  
   //   参数参考     function loadwindow(width,height,data1,data2,data3){
        function transToDwindow(dcmc,zy) {
        	var title_data = zy+"评分详细查询";
        	loadwindow(500,300,dcmc,zy,title_data);
        	
        }
        
//        封装的方法——被dwindow_title 调用
        function dwindow_content_datadiv(Data1,Data2){
        	
        	/*tableinit_dwindow();
        	query_pop();*/
        	
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
        				title : '费用',
        				sortable : true	
       				
        			},
        			{
        				field : 'bz',
        				title : '备注 ',
        				sortable : true
       			
        			}
        		],
        		
        	});
        	
        	/* $('#dataList_table1').bootstrapTable('resetView');*/
        }
        
        function query_dwindow(dcmc_dwindow,zy_dwindow) {
        	var rq = $("#querydate").val(); 
        	 
        	$.ajax({
        		type : "POST",
        		url : 'bwyxjs_dwtable_query.action',
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
        		url : 'bwyxjs_hz.action',
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

