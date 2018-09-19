//document.write("<script language=javascript src='js/getdate.js'></script>");

// 以上为设定时间
laydate({
            elem: '#cxdate',
        
            event: 'focus' 
        });
        
        laydate({
            elem: '#start',
        
            event: 'focus' 
        });

         laydate({
            elem: '#end',
        
            event: 'focus' 
        });

         var time = {
        elem:'#zt_date',
        format:'YYYY-MM-DD hh:mm:ss',
        min:laydate.now(),
        max:'2999-12-31 23:59:59',
        istime:true,//是否显示时分秒
        istoday:true,//是否显示【今天】的按钮
        isclear:true,//是否显示【清空】的按钮
        festival: true,//是否显示节日
        start: laydate.now(0,"YYYY-MM-DD hh:mm:ss"),  // 开始日期
        fixed: false,   // 是否固定在可视区域
        zIndex: 10000,  // css控制图层的遮罩效果（效果不明显）
        choose: function(dates){  // 选择好日期的回调
        }
    }
    laydate(time);

        //初始赋值
         $('#start').val('2018-02-05');
        $('#end').val('2018-02-06');
        $('#zt_date').val('2018-02-06');


 // 初始化数据 和加载数据       
        window.onload = $(function(){

        	tableinit();

        	query();
        	
        	queryJZ();
        	queryJZZT();
        	queryJZLX();
        	
        });

        function tableinit() {
        	var table = $("#dataList_table");
        	table.bootstrapTable({
        		striped : true, //是否显示行间隔色
        		 search: true, 
        		 toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
        		height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		columns : [
        			{
                        checkbox: true
                    },
        			{
        				field : 'jzmc',
        				title : '机组名称'
        				
        			}, {
        				field : 'rl',
        				title : '容量'
        			}, {
        				field : 'dqzt',
        				title : '当前状态'
        			}, {
        				field : 'lx',
        				title : '类型'
        			}, {
        				field : 'rfdl',
        				title : '日发电量'
        			}, {
        				field : 'ztsj',
        				title : '状态发生时间'
        					
        			}
        		]
        	});
        }

        function query() {
        	var rq = $("#datapickerinput").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'jzzt.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }


        function querya() {
        	var rq = $("#datapickerinput").val();
        	
        	document.getElementById("123").innerHTML =  "123123";
        	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'jzzt1.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }


        function queryJZ() {	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'jzzt1.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05"
        		},
        		success : function(data) {

        			$('#jzmc').empty();
        			for(var i = 0; i < data.length; i++){                         
        				var name  = data[i]['jzmc'];  
        				
        				$('#jzmc').append('<option>'+name+'</option>');
        			 
        			} 
        			
        		}
        	});

        }
        
        
  function queryJZZT() {	 
        	
        	$.ajax({
        		type : "POST",
        		url : 'jzzt1.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05"
        		},
        		success : function(data) {

        			$('#jzzt').empty();
        			for(var i = 0; i < data.length; i++){                         
        				var name  = data[i]['dqzt'];  
        				
        				$('#jzzt').append('<option>'+name+'</option>');
        			 
        			} 
        			
        		}
        	});

        }
  
  function queryJZLX() {	 
  	
  	$.ajax({
  		type : "POST",
  		url : 'jzzt1.action',
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-05"
  		},
  		success : function(data) {

  			$('#jzlx').empty();
  			for(var i = 0; i < data.length; i++){                         
  				var name  = data[i]['lx'];  
  				
  				$('#jzlx').append('<option>'+name+'</option>');
  			 
  			} 
  			
  		}
  	});

  }
  
  
  function delrow() {
//		var rq = $("#datapickerinput").val();
		
		var table = $("#dataList_table");
		var a = table.bootstrapTable('getSelections');
		if (a.length == 0) {
			alert("请选中要刪除的行");
			return;
		}

		var array = [];
		for (var i = 0; i < a.length; i++) {
			var data = "";
			data += a[i].jzmc;
			data += "&" + a[i].lx;
			array.push(data);
		}
//		$('#22').html='<p>'+array[0]+'</p>';
//		$('#22').append('<p>'+array[0]+'</p>');
		document.getElementById("22").innerHTML =  "要删除的机组"+array[0];
		
	}




