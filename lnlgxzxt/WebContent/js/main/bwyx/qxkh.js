//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间

// 日期定义 及初始化复制的js配置========================================
laydate({
            elem: '#querydate',

            event: 'focus' 
        });

             
laydate({
    elem: '#add_comput_startdate',

    event: 'focus' 
});

laydate({
    elem: '#add_comput_enddate',

    event: 'focus' 
});

        //初始赋值
           $('#querydate').val(getNowFormatDate);
       
      
 // 定义几个全局变量做为初始化用===用在table初始化表头时定义field用============================================     

           var title_txt  = "2018-01-02  电厂曲线信息"
          
           var khfy_data = []; //考核费用曲线数据	  
           var jhz_data = []; //计划值曲线数据
           var sjz_data = []; //实际值曲线数据	 
           var sx_data = []; //上限值曲线数据
           var xx_data = []; //下限值曲线数据	 
           

//           // 初始化数据 和加载数据       
          function field_load(){
        	  
        		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");

               	var nodes = treeObj.getNodes()[0].children;
               	
               	if(nodes.length >0){
//               	alert(nodes[0].name+"  id :"+nodes[0].id+"nodes.length: "+nodes.length);
               		
//               	var firstDcmc = nodes[0].name;   //获取第一个支点
                   	
                 	var firstDcmc = (nodes[0].children)[0].name; //获取第一个子节点
                 	 var rq = $("#querydate").val();
                 	title_txt = rq+" "+firstDcmc;
                 	
               	queryTable(firstDcmc);
               	querychart(firstDcmc);
               	}
          }
          

           
           
           
        
//初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================        
           window.onload = $(function(){
        	      	   
        	   treeinit();//初始化 树结构
        	   
        	   tableinit(); // 初始化表头
        	   
//        	   treeinit1();//初始化 树结构
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
           		
//           		height : 50, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
           		url: "",
           		columns : [
           			{
                           checkbox: true
                       },
           			{
           				field : 'sj',
           				title : '时间',
           				sortable : true
           				
           			}, {
           				field : 'sd',
           				title : '时段',
           				sortable : true
           			}, {
           				field : 'khdl',
           				title : '考核电量',
           				sortable : true
           			}, {
           				field : 'khfy',
           				title : '考核费用',
           				sortable : true	
           				
           			}, {
           				field : 'agczt',
           				title : 'AGC状态'				
           			}, {
           				field : 'sjz',
           				title : '实际值'        					
           			},
           			{
           				field : 'jhz',
           				title : '计划值',
           				sortable : true
           			},
           			{
           				field : 'khlx',
           				title : '考核类型',
           				sortable : true
           			}
           		]
           	});
           }

           
//   查询曲线        
           function queryTable(dcmc) {
           	var rq = $("#querydate").val(); 
           	$.ajax({
           		type : "POST",
           		url : 'qxkh_table.action',
           	    dataType: "json",
           		data : {
           			"rq" : rq,
           			"dcmc":dcmc
           		},
           		success : function(data) {
           			$('#dataList_table').bootstrapTable('load', data);
           		}
           	});

           }
           
   //查询方法========================================================       
           
           function query() {
        	   
                     zNodes1 = tree_data();
        	   
        	   /**  
                * 删除选中节点  
                */  
               
                   var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
                   //选中节点  
//                   var nodes = treeObj.getSelectedNodes();  
                   var nodes =  treeObj.getNodes();  
                   for (var i=0, l=nodes.length; i < l; i++)   
                   {  
                       //删除选中的节点  
                       treeObj.removeNode(nodes[i]);  
                   }  
                   
                   var t1 =  $("#treeDemo");
                   t1 = $.fn.zTree.init(t1, setting, zNodes1);
                   var zTree1 = $.fn.zTree.getZTreeObj("tree");
                   
                   
//                   初始化点击第一个
                   field_load();
           }


  //=======数结构=============================================================================
           /*******树状图*******/
           var setting = {
           	view: {
           		dblClickExpand: false,
           		showLine: false,
           		selectedMulti: false
           	},
           	data: {
           		simpleData: {
           			enable:true,
           			idKey: "id",
           			pIdKey: "pId",
           			rootPId: ""
           		}
           	},
           	callback: {
           		beforeClick: function(treeId, treeNode) {
           			var zTree = $.fn.zTree.getZTreeObj("tree");
           			if (treeNode.isParent) {
//           				zTree.expandNode(treeNode);
//           			如果使用上面会报错	
           				return false;
           			} else {
           				demoIframe.attr("src",treeNode.file + ".html");
           				return true;
           			}
           		},
           		// onclick 方法==========start==========================
           	 onClick: function(treeId, treeNode) {  
                 var treeObj = $.fn.zTree.getZTreeObj(treeNode);  
                 var selectedNode = treeObj.getSelectedNodes()[0];  
                 
             	var dc_rq = $("#querydate").val(); 
    
                 title_txt = dc_rq+" "+selectedNode.name;
              
                 querychart(selectedNode.name);
                 queryTable(selectedNode.name);
             } 
           	// onclick 方法============end======================
           		
           	}
           };

           var zNodes =[
           	{ id:1, pId:0, name:"厂站分类列表", open:true},
           	{ id:11, pId:1, name:"火电厂",open:true},
           	{ id:111, pId:11, name:"A火电"},
           	{ id:112, pId:11, name:"B火电"},
           	{ id:113, pId:11, name:"C火电"},
           	{ id:114, pId:11, name:"D火电"},
           	{ id:115, pId:11, name:"E火电"},
           	{ id:12, pId:1, name:"核电站"},
           	{ id:121, pId:12, name:"A核电 "},
           	{ id:122, pId:12, name:"B核电 "},
           	{ id:13, pId:1, name:"风电站"},
           	{ id:131, pId:13, name:"A风电"},
           	{ id:122, pId:13, name:"B风电 "},
           	{ id:14, pId:1, name:"光伏电站"},
           	{ id:141, pId:14, name:"A光伏 "},
           	{ id:42, pId:14, name:"B光伏 "},
           ];
           		
           var code;
           		
           function showCode(str) {
           	if (!code) code = $("#code");
           	code.empty();
           	code.append("<li>"+str+"</li>");
           }
           			
           
           //初始化数
           function treeinit(){
        	   var t = $("#treeDemo");
           	t = $.fn.zTree.init(t, setting, zNodes);
           	demoIframe = $("#testIframe");

           	var zTree = $.fn.zTree.getZTreeObj("tree");  //获取ztree对象
         
      	   
           }
           
           
           
           
           function tree_data() {
        	      var result = [];
        	      var rq = $("#querydate").val();
        	      $.ajax({
        	  		type : "POST",
        	  		url : 'qxkh_tree.action',
        	  		async: false, //如果不设置这里 将取不到值
        	  	    dataType: "json",
        	  		data : {
        	  			"rq" : rq
        	  		},
        	  		success : function(data) {
        	  			result = data;
        	  			
        	  		}
        	      });
        	                                      
        	      return result;
        	  }
        	   
        	          	
           var zNodes1 =[];
              		
           
           
 //=======树结构====end===================================================================
  
           
  //===========查询曲线数据源=========start=============================================================
           function getchart_data(tdmc) {
        	   var rq = $("#querydate").val(); 
     	      var result = [];
     	      $.ajax({
     	  		type : "POST",
     	  		url : 'qxkh_chartdata.action',
     	  		async: false, //如果不设置这里 将取不到值
     	  	    dataType: "json",
     	  		data : {
     	  			"rq" : rq,
     	  			"dcmc":tdmc
     	  		},
     	  		success : function(data) {
     	  			result = data[0].data1;
     	  			
     	  		 khfy_data = data[0].data1; //考核费用曲线数据	  
     	           jhz_data = data[0].data2; //计划值曲线数据
     	           sjz_data =data[0].data3; //实际值曲线数据	 
     	           sx_data = data[0].data4; //上限值曲线数据
     	           xx_data = data[0].data5; //下限值曲线数据	
     	  			
     	  		}
     	      });
                    
     	      return result;
     	  }
           
    //===========查询曲线数据源======end================================================================
      
           
//  ===========================曲线版面初始化=======start=====内容已经去掉=========================   
       //  ===========================曲线版面初始化======end=============================== 
       
//   查询电厂曲线= start=====================================    
           function querychart(tdmc) {
        	   
        	    getchart_data(tdmc);
        	   
        	   
//        		   [200, 200, 200, 200, 200, 59, 59, 59, 59, 59, 59, 59,59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59]
        	   
               require.config({
                   paths: {
                       echarts: './assets/dist'
                   }
               });

               
               require(
                       [
                           'echarts', 
                           'echarts/theme/macarons',
                           'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                           'echarts/chart/bar'
                       ],
                       function (ec,theme) {
                           var myChart = ec.init(document.getElementById('main'),theme);

                            myChart.showLoading({  
                                    text: "图表数据正在努力加载..."  
                                });

                          option = {
               title : {
                   text: title_txt, 
                   subtext: '实时曲线信息'
               },
               tooltip : {
                   trigger: 'axis'
               },
               legend: {
                   data:['考核费用','计划值','实际值','上限','下限']
               },
               toolbox: {
                   show : true,
                   feature : {
                       mark : {show: true},
                       dataView : {show: true, readOnly: false},
                       magicType : {show: true, type: ['line', 'bar']},
                       restore : {show: true},
                       saveAsImage : {show: true}
                   }
               },
               calculable : true,
               xAxis : [
                   {
                       type : 'category',
                         data : [ '00:15', '00:30', '00:45', '01:00',
        				'01:15', '01:30', '01:45', '02:00', '02:15', '02:30', '02:45', '03:00',
        				'03:15', '03:30', '03:45', '04:00', '04:15', '04:30', '04:45', '05:00',
        				'05:15', '05:30', '05:45', '06:00', '06:15', '06:30', '06:45', '07:00',
        				'07:15', '07:30', '07:45', '08:00', '08:15', '08:30', '08:45', '09:00',
        				'09:15', '09:30', '09:45', '10:00', '10:15', '10:30', '10:45', '11:00',
        				'11:15', '11:30', '11:45', '12:00', '12:15', '12:30', '12:45', '13:00',
        				'13:15', '13:30', '13:45', '14:00', '14:15', '14:30', '14:45', '15:00',
        				'15:15', '15:30', '15:45', '16:00', '16:15', '16:30', '16:45', '17:00',
        				'17:15', '17:30', '17:45', '18:00', '18:15', '18:30', '18:45', '19:00',
        				'19:15', '19:30', '19:45', '20:00', '20:15', '20:30', '20:45', '21:00',
        				'21:15', '21:30', '21:45', '22:00', '22:15', '22:30', '22:45', '23:00',
        				'23:15', '23:30', '23:45', '24:00' ] 
                   }
               ],
               yAxis : [
                   {
                    type : 'value',
                        name : '有功值',
                        axisLabel : {
                            formatter: '{value} (MW)'
                        }
                   }
                   ,
                    {
                        type : 'value',
                        name : '费用',
                        axisLabel : {
                            formatter: '{value} 元'
                        }
                    }
               ],
               series : [
                          {
                       name:'考核费用',
                       type:'bar',
                       yAxisIndex: 1,
                       data:khfy_data    
                      
                         },
                   {
                       name:'计划值',
                       symbol:'none',  //这句就是去掉点的  
                       smooth:true,  //这句就是让曲线变平滑的 
                       type:'line',
//                       yAxisIndex: 1,
                       data:jhz_data,
//                    	   [120, 49, 70, 232, 256, 767, 136, 122, 326, 200,164, 133,120, 49, 70, 232, 256, 767, 156, 122, 326, 200,164, 133],
                       markPoint : {
                           data : [
                            //    {type : 'max', name: '最大值'},
                            //    {type : 'min', name: '最小值'}
                           ]
                       }           
                   },
                   {
                       name:'实际值',
                       symbol:'none',  //这句就是去掉点的  
                       smooth:true,  //这句就是让曲线变平滑的 
                       type:'line',
                       data:sjz_data
//                    	   [26, 59, 30, 84, 27, 77, 176, 182, 487, 188, 60, 23,26, 59, 30, 84, 27, 77, 176, 182, 487, 188, 60, 23],

                      
                       
                   }
                   , {
                       name:'上限',
                       symbol:'none',  //这句就是去掉点的  
                       smooth:true,  //这句就是让曲线变平滑的 
                       type:'line',
                       data:sx_data
//                    	   [548, 548, 548, 548, 548, 548, 548, 548, 548, 548, 548, 548,548, 548, 548, 548, 548, 548, 548, 548, 548, 548, 548, 548],

                      
                   }
                   , {
                       name:'下限',
                       symbol:'none',  //这句就是去掉点的  
                       smooth:true,  //这句就是让曲线变平滑的 
                       type:'line',
                       data:xx_data
//                    	   [59, 599, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59],         
                      
                   }
                   
               ]
            };
                             myChart.hideLoading();   
                           myChart.setOption(option);
                       }
                   );
               

        		
           }
           
//   查询电厂曲线==end====================================    
           
//====================计算功能=====开始===================       
           
        function comput(){

        	 var startdate =$('#add_comput_startdate').val();
         	  var enddate =$("#add_comput_enddate").val();
         	  
         	  var rq = startdate;
         	  

         		 if(startdate > enddate){
         		var str="";
     			layer.alert(str+="“开始日期 ” 不能大于   “结束日期 ” 相同，请从新选择日期 ！\r\n",{
     				title: '提示框',				
     				icon:0,								
     			}); 
     			return false;
         		} 
         		 
         		var daysAmount = getDaysAmount(startdate,enddate);
//         		alert("  调试中...参与计算的天数有:"+(parseInt(daysAmount)+1));
//         		alert(getTomorrow(startdate));
         		 
         		 var msg_comput = "计算开始： \r\n  <br>";
         		 var days = parseInt(daysAmount);
         		 var dayinit = startdate
         		
         		msg_comput =msg_comput+ comput_qxkh_data(startdate) +" \r\n  <br>";
         		document.getElementById('computMsg').innerHTML = msg_comput;
         		 
         		for (var i=0;i<days;i++)
         		{
         			
         			
         			dayinit = getTomorrow(dayinit)
         			msg_comput =msg_comput+ comput_qxkh_data(dayinit) +" \r\n  <br>";
         			document.getElementById('computMsg').innerHTML = msg_comput;
         		}
         		
         		msg_comput =msg_comput+ "计算完成，共完成了" +(parseInt(daysAmount)+1)+"天的计算 \r\n  <br>";
         		document.getElementById('computMsg').innerHTML = msg_comput;
        	
        } 
        
        function comput1(){


       	 var startdate =$('#add_comput_startdate').val();
        	  var enddate =$("#add_comput_enddate").val();
        	  
        	  var rq = startdate;
        	  

        		 if(startdate > enddate){
        		var str="";
    			layer.alert(str+="“开始日期 ” 不能大于   “结束日期 ” 相同，请从新选择日期 ！\r\n",{
    				title: '提示框',				
    				icon:0,								
    			}); 
    			return false;
        		} 
        		 
        		var daysAmount = getDaysAmount(startdate,enddate);
        		alert("  调试中...参与计算的天数有:"+(parseInt(daysAmount)+1));
//        		alert(getTomorrow(startdate));
        		 
        		 var msg_comput = "计算开始： \r\n  <br>";
        		 var days = parseInt(daysAmount);
        		 var dayinit = startdate
        		
        		msg_comput =msg_comput+ comput_qxkh_data(startdate) +" \r\n  <br>";
        		document.getElementById('computMsg').innerHTML = msg_comput;
        		 
        		for (var i=0;i<days;i++)
        		{
        			
        			/*(function(i){
        	
        				dayinit = getTomorrow(dayinit)
             			msg_comput =msg_comput+ comput_qxkh_data(dayinit) +" \r\n  <br>";
             			document.getElementById('computMsg').innerHTML = msg_comput;
             			alert("msg_comput");
             			
        			alert("msg_comput");
        			})(i)*/
        			
        			setTimeout(function(){
        		        /*fun2();*/
        				dayinit = getTomorrow(dayinit)
             			msg_comput =msg_comput+ comput_qxkh_data(dayinit) +" \r\n  <br>";
             			document.getElementById('computMsg').innerHTML = msg_comput;
        		    },1000);
        			alert("msg_comput");
        		}
        		
//        		msg_comput =msg_comput+ "计算完成，共完成了" +(parseInt(daysAmount)+1)+"天的计算 \r\n  <br>";
//        		document.getElementById('computMsg').innerHTML = msg_comput;
       	
       
        
        }
        
        
        //测试 jd button 调用============start==========================================
        var numdata = parseInt("1");
        var msg = "计算完成 \r\n  <br>";
       //  进度数据功能
        function jd(){

        	 msg = msg+ "第"+numdata+"条记录 "+"\r\n  <br>"
        	 document.getElementById('computMsg').innerHTML = msg;
        	 
      		numdata++;

        }
        
        //测试 jd button 调用============end=========================================
        
        
        function comput_qxkh_data(rq){
        	var result = '';
        	 $.ajax({
     	  		type : "POST",
     	  		url : 'comput_qxkh_data.action',
     	  		async: false, //如果不设置这里 将取不到值
     	  	    dataType: "json",
     	  		data : {
     	  			"rq" : rq
     	  		},
     	  		success : function(data) {
     	  			result = data;  	  			
     	  		}
     	      });
     	                
     	      return result;
        	
        }
        
        
           
 //====================计算功能======结束==================     

      
