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
        		 showColumns: false, //是否显示所有的列
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		fixedColumns: true,
        		 fixedNumber:3,
        		 minimumCountColumns: 3, //最少允许的列数
        		
//        		height : 500, 
        		height :($(window).height()-100),
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			
        			{
        				field : 'jzmc',
        				title : '机组',
//        				sortable : true
        				
        			}, {
        				field : 'rl',
        				title : '容量',
        			
        			}, {
        				field : 'bc',
        				title : '&nbsp班次&nbsp',
//        				sortable : true
        			}, {
        				field : 'day1',
        				title : '&nbsp&nbsp1日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day2',
        				title : '2日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day3',
        				title : '3日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day4',
        				title : '4日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day5',
        				title : '5日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day6',
        				title : '6日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day7',
        				title : '7日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day8',
        				title : '8日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day9',
        				title : '9日&nbsp&nbsp',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day10',
        				title : '10日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day11',
        				title : '11日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day12',
        				title : '12日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day13',
        				title : '13日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day14',
        				title : '14日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day15',
        				title : '15日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day16',
        				title : '16日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day17',
        				title : '17日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day18',
        				title : '18日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day19',
        				title : '19日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day20',
        				title : '20日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day21',
        				title : '21日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day22',
        				title : '22日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day23',
        				title : '23日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day24',
        				title : '24日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day25',
        				title : '25日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day26',
        				title : '26日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day27',
        				title : '27日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day28',
        				title : '18日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day29',
        				title : '29日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			, {
        				field : 'day30',
        				title : '30日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}, {
        				field : 'day31',
        				title : '31日',
        				formatter: function (value, row, index) {
              				//通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
              		        	var a = "";
              			        	if(value < row.rl) {  //如果大于其中指定列数据则调用变色
              			        		var a = '<span style="color:#FF0000">'+value+'</span>'; //
              			        	}else{
              			        		var a = '<span>'+value+'</span>';
              			        	}
              						return a;
            				}
        			}
        			
        		]
        	});
        }

        
//查询方法========================================================       
        
        function query() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'jzktdl_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			"bc" :$("#bc").val()
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }

//    刷新=======================================================
        $(window).resize(function () {
            $('#dataList_table').bootstrapTable('resetView');
        });  

  
  

  
 
