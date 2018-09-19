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

        		height : ($(window).height()-120),
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			[
        				{
            				field : 'field1',
            				title : ' 序号 ',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2,
             	            width:100

            			},
        				{
            				field : 'field2',
            				title : '电厂',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2,
             	            width:100

            			},
            			{
            				field : 'field3',
            				title : '机组类型',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2,
             	            width:100

            			},{
            				field : 'field4',
            				title : '装机容量',
            				 valign:"middle",
             	            align:"center",
             	            colspan: 1,
             	            rowspan: 2,
             	            width:100

            			},
            			{
            				/*field : 'field4',*/
            				title : 'AGC补偿',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			},{
            				/*field : 'field4',*/
            				title : '调峰补偿(调峰+启停+修正)',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			},{
            				/*field : 'field4',*/
            				title : '备用补偿',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			},{
            				/*field : 'field4',*/
            				title : '无功补偿',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			},{
            				/*field : 'field4',*/
            				title : '黑启动补偿',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			},{
            				/*field : 'field4',*/
            				title : '合计',
            				valign:"middle",
            	            align:"center",
            				colspan: 4,
            	            rowspan: 1,
             	            width:400
            			}

        			],
        			[
        				{
            				field : 'field5',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field6',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field7',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field8',
            				title : '季度累计',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field9',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field10',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field11',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field12',
            				title : '季度累计',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field13',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field14',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field15',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field16',
            				title : '季度累计',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field17',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field18',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field19',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field20',
            				title : '季度累计',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field21',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field22',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field23',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field24',
            				title : '季度累计',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field25',
            				title : '季度首月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
        				{
            				field : 'field26',
            				title : '季度次月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},
            			{
            				field : 'field27',
            				title : '季度末月',
            				valign:"middle",
            	            align:"center",
             	            width:100
            			},{
            				field : 'field28',
            				title : '季度累计',
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
        		url : 'jdbb5_query.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        			var data = $('#dataList_table').bootstrapTable('getData', true);
                /*    //合并单元格
                    mergeCells(data, "field1", 1, $('#dataList_table'));*/
        		}
        	});

        }

//输出Excel方法
        function exportExcel(){
        	$('#dataList_table').tableExport({ type: 'excel', fileName: '表5-电力辅助服务补偿统计表',worksheetName: 'sheet1', tableName: '信息', excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],  escape: 'false' })
        }




        function hz(){
        	var rq = $("#querydate").val();

        	$.ajax({
        		type : "POST",
        		url : 'jdbb5_hz.action',
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

