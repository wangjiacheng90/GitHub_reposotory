//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间
laydate({
            elem: '#querydate',
        
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

         laydate({
             elem: '#add_date',
         
             event: 'focus' 
         });
         
         var time = {
        elem:'#zt_date',
        format:'YYYY-MM-DD hh:mm',
//        min:laydate.now(),//是否可以选择过去
        max:'2999-12-31 23:59',
        istime:true,//是否显示时分秒
        istoday:true,//是否显示【今天】的按钮
        isclear:true,//是否显示【清空】的按钮
        festival: true,//是否显示节日
        start: laydate.now(0,"YYYY-MM-DD hh:mm"),  // 开始日期
        fixed: false,   // 是否固定在可视区域
        zIndex: 10000,  // css控制图层的遮罩效果（效果不明显）
        choose: function(dates){  // 选择好日期的回调
        }
    }
    laydate(time);

        //初始赋值
         var mydate = new Date();
         
         $('#querydate').val(getNowFormatDate());
         $('#start').val(getNowFormatDate());
        $('#end').val(getNowFormatDate());
        $('#zt_date').val(getCurrentTime());
        $('#add_date').val(getNowFormatDate());


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
        		// toolbar: '#toolbar',                //工具按钮用哪个容器
        		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        		clickToSelect : true, //是否启用点击选中行
        		
        		height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
                        checkbox: true
                    },
        			{
        				field : 'jzmc',
        				title : '机组名称',
        				
        			}, {
        				field : 'rl',
        				title : '容量',
        				editable: {
                            type: 'text',
                            title: '容量',
                            validate: function (v) {
                            	if (!v) return '容量不能为空';
                                if (isNaN(v)) return '容量必须是数字';
                                var age = parseInt(v);
                                if (age <= 0) return '容量必须是正整数';
                            }
                        }
        			}, {
        				field : 'dqzt',
        				title : '当前状态',
        				editable: {
                            type: 'select',
                            title: '当前状态',
//                            source:[{value:"检修",text:"检修"},{value:"运行",text:"运行"},{value:"停机",text:"停机"}]
                           source: function () {
                                var result = [];
                                $.ajax({
                            		type : "POST",
                            		url : 'jzdqzt.action',
                            		async: false, //如果不设置这里 将取不到值
                            	    dataType: "json",
                            		data : {
                            			"rq" : "2018-05-01"
                            		},
                            		success : function(data) {
                            			for(var i = 0; i < data.length; i++){       
                            				var ID  = data[i]['ID'];  
                                            var Name = data[i]['Name'];  
                                            result.push({ value:ID, text:Name });

                            			} 
                            		}
                                });
                                                                
                                return result;
                            }
                        }
        			}, {
        				field : 'lx',
        				title : '类型',
        				editable: {
                            type: 'select',
                            title: '类型',
//                            source:[{value:"检修跳闸",text:"检修跳闸"},{value:"检修停机",text:"检修停机"}],
                            source: function () {
                                var result = [];
                                $.ajax({
                            		type : "POST",
                            		url : 'jzztlx.action',
                            		async: false, //如果不设置这里 将取不到值
                            	    dataType: "json",
                            		data : {
                            			"rq" : "2018-05-01"
                            		},
                            		success : function(data) {
                            			for(var i = 0; i < data.length; i++){       
                            				var ID  = data[i]['ID'];  
                                            var Name = data[i]['Name'];  
                                            result.push({ value:ID, text:Name });
                            			} 
                            		}
                                });
                                                                
                                return result;
                            }
                           
                        }
        				
        			}, {
        				field : 'rfdl',
        				title : '日发电量',
        				editable: {
                            type: 'text',
                            title: '日发电量',
                            validate: function (v) {
                            	if (!v) return '容量不能为空';
                                if (isNaN(v)) return '容量必须是数字';
                                
                            }
                        }
        					
        			}, {
        				field : 'ztsj',
        				title : '状态发生时间',
        				//获取日期列的值进行转换
        			    formatter: function (value, row, index) { 
        			        
        			        var aa = value;

                            return aa;
        			    },
        				 editable: {
        		                type: 'datetime',
        		                placement: 'left',
        		                title:'状态发生时间'  
        		                
        		            } 
        					
        			}
        		],
        		
        		onEditableSave: function (field, row, oldValue, $el) {
        			$('#dataList_table').bootstrapTable("resetView");
        			 $.ajax({
                 		type : "POST",
                 		url : 'jzzdSave.action',
                 		async: false, //如果不设置这里 将取不到值
                 	    dataType: "json",
                 		data : {
                 			"rq" : "2018-05-21",
                 			"jzmc": row.jzmc,
                 			"rl":row.rl,
                 			"dqzt":row.dqzt,
                 			"lx":row.lx,
                 			"rfdl":row.rfdl,
                 			"ztsj":row.ztsj,
                 			"index":oldValue
                 			
                 		},
                 		success : function(data) {
//                 			 alert(row.lx);
                 			alert(data);
                 		},
                 		 error: function () {
                             alert('编辑失败');
                         }
                     });
        			
                    /*$.ajax({
                        type: "post",
                        url: "/Editable/Edit",
                        data: row,
                        dataType: 'JSON',
                        success: function (data, status) {
                            if (status == "success") {
                                alert('提交数据成功');
                            }
                        },
                        error: function () {
                            alert('编辑失败');
                        },
                        complete: function () {

                        }

                    });*/
                }
        	});
        }

        function query() {
        	var rq = $("#querydate").val(); 
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


//  $(function(){
//可编辑 添加
//	   $('#dataList_table').editable('Disabled');
//	   //enable / disable
//	      
//  })
  
  
  
//获取当前时间，格式YYYY-MM-DD
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }

  
  /** 
   * 获取当前时间 格式：yyyy-MM-dd HH:MM
   */  
  function getCurrentTime() {  
      var date = new Date();//当前时间  
      var month = zeroFill(date.getMonth() + 1);//月  
      var day = zeroFill(date.getDate());//日  
      var hour = zeroFill(date.getHours());//时  
      var minute = zeroFill(date.getMinutes());//分  
      var second = zeroFill(date.getSeconds());//秒  
        
      //当前时间  
      var curTime = date.getFullYear() + "-" + month + "-" + day  
              + " " + hour + ":" + minute ;  
        
      return curTime;  
  }  
    
  /** 
   * 补零 
   */  
  function zeroFill(i){  
      if (i >= 0 && i <= 9) {  
          return "0" + i;  
      } else {  
          return i;  
      }  
  } 
