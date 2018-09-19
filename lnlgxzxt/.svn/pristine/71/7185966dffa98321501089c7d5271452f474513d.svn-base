//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
laydate({
            elem: '#querydate1',

            event: 'focus' 
        });

laydate({
	        elem: '#querydate2',

	        event: 'focus' 
        });

        //初始赋值      
         $('#querydate1').val(getNowFormatDate());
         $('#querydate2').val(getNowFormatDate());

        
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

        }
        
//        火电table表头
        
        /*   辅助服务文件  -----<huodianchang_count>
        @num	pname	recmoney	linerecmoney	changerecmoney	reccount	appmoney	changeappmoney	lineappmoney	waterapportion	appcount	daycount
        //序号	电厂名称	有偿调峰补偿金额	跨省支援补偿金额	补偿修正金额	补偿小计	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计	日盈亏合计
*/        function tableinit1() {
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
        				field : 'field1',
        				title : '有偿调峰补偿金额',
        				sortable : true
        			}, {
        				field : 'field2',
        				title : '跨省支援补偿金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field3',
        				title : '补偿修正金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field4',
        				title : '补偿小计',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field5',
        				title : '有偿调峰分摊金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field6',
        				title : '分摊修正金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field7',
        				title : '跨省分摊金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field8',
        				title : '抽蓄分摊金额',
        				sortable : true	
        				
        			}
        			, {
        				field : 'field9',
        				title : '分摊小计',
        				sortable : true			
        			}
        			, {
        				field : 'field10',
        				title : '日盈亏合计',
        				sortable : true	
        				
        			}
        			
        		]
        	});
        }

//      风电table表头
/*<fengdianchang_count>
@num	pname	appmoney	changeappmoney	lineappmoney	waterapportion	appcount
//序号	电厂名称	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计
*/        
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
        				field : 'dcmc',
        				title : '电厂名称',
        				sortable : true
        			}, {
        				field : 'field1',
        				title : '有偿调峰分摊金额',
        				sortable : true
        			}, {
        				field : 'field2',
        				title : '分摊修正金额',
        				sortable : true	
        			}
        			, {
        				field : 'field3',
        				title : '跨省分摊金额',
        				sortable : true	
        			}
        			, {
        				field : 'field4',
        				title : '抽蓄分摊金额',
        				sortable : true	
        			}
        			, {
        				field : 'field5',
        				title : '分摊小计',
        				sortable : true	
        			}
        			
        		]
        	});
        }
        
//      核电table表头
        
     /*   @num	pname	appmoney	changeappmoney	lineappmoney	waterapportion	appcount
      //序号	电厂名称	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计
*/        
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
        				field : 'dcmc',
        				title : '电厂名称',
        				sortable : true
        			}, {
        				field : 'field1',
        				title : '有偿调峰分摊金额',
        				sortable : true
        			}, {
        				field : 'field2',
        				title : '分摊修正金额',
        				sortable : true	
        			}
        			, {
        				field : 'field3',
        				title : '跨省分摊金额',
        				sortable : true	
        			}
        			, {
        				field : 'field4',
        				title : '抽蓄分摊金额',
        				sortable : true	
        			}
        			, {
        				field : 'field5',
        				title : '分摊小计',
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
      
        }
        
//        火查询
        function query1() {
        	var ksrq = $("#querydate1").val(); 
        	var zzrq = $("#querydate2").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'tfscrjg_hd_table.action',
        	    dataType: "json",
        		data : {
        			"ksrq" : ksrq,
        			"zzrq":zzrq
        		},
        		success : function(data) {
        			$('#dataList_table1').bootstrapTable('load', data);
        		}
        	});

        }
        
//      风电查询
        function query2() {
        	var ksrq = $("#querydate1").val(); 
        	var zzrq = $("#querydate2").val();
        	$.ajax({
        		type : "POST",
        		url : 'tfscrjg_fd_table.action',
        	    dataType: "json",
        		data : {
        			"ksrq" : ksrq,
        			"zzrq":zzrq
        		},
        		success : function(data) {
        			$('#dataList_table2').bootstrapTable('load', data);
        		}
        	});

        }
        
//      核电
        function query3() {
        	var ksrq = $("#querydate1").val(); 
        	var zzrq = $("#querydate2").val();
        	$.ajax({
        		type : "POST",
        		url : 'tfscrjg_hed_table.action',
        	    dataType: "json",
        		data : {
        			"ksrq" : ksrq,
        			"zzrq":zzrq
        		},
        		success : function(data) {
        			$('#dataList_table3').bootstrapTable('load', data);
        		}
        	});

        }


    

  
 
