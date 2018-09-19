document.write("<script language=javascript src='js/mytool/sj.js'></script>");


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

           var fy_data = []; //费用曲线数据

           var sjz_data = []; //实际值曲线数据
           var zdkt_data = []; //最大可调曲线数据



//           // 初始化数据 和加载数据
          function field_load(){

        		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");

               	var nodes = treeObj.getNodes()[0].children;

               	if(nodes.length >0){
//               	alert(nodes[0].name+"  id :"+nodes[0].id+"nodes.length: "+nodes.length);

               	var firstDcmc = nodes[0].name;   //获取第一个支点
                   	
//                 	var firstDcmc = (nodes[0].children)[0].name; //获取第一个子节点(当两层支点结构时使用)
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

           			},{
           				field : 'sd',
           				title : '时段',
           				sortable : true

           			},  {
           				field : 'bcdl',
           				title : '补偿电量',
           				sortable : true

           			},
           			{
           				field : 'bcfy',
           				title : '补偿费用',
           				sortable : true
           			}, {
           				field : 'sjgl',
           				title : '实际功率'
           			},
           			{
           				field : 'zdkt',
           				title : '最大可调出力',
           				sortable : true
           			}
           		]
           	});
           }


//   查询曲线表格
           function queryTable(jzmc) {
           	var rq = $("#querydate").val();
           	$.ajax({
           		type : "POST",
           		url : 'xzby_table.action',
           	    dataType: "json",
           		data : {
           			"rq" : rq,
           			"jzmc":jzmc
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
        	  		url : 'xzbykhjs_tree.action',
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
     	  		url : 'xzbykhjs_chartdata.action',
     	  		async: false, //如果不设置这里 将取不到值
     	  	    dataType: "json",
     	  		data : {
     	  			"rq" : rq,
     	  			"dcmc":tdmc
     	  		},
     	  		success : function(data) {
     	  			result = data[0].data1;

     	  		 fy_data = data[0].data1; //费用曲线数据
     	           sjz_data = data[0].data2; //实际值曲线数据
     	           zdkt_data =data[0].data3; //最大可调曲线数据


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

                   data:['考核费用','实际功率','最大可调出力']
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
                         data : sj96data
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
                       data:fy_data

                         },
                   {
                       name:'实际功率',
                       symbol:'none',  //这句就是去掉点的
                       smooth:true,  //这句就是让曲线变平滑的
                       type:'line',
//                       yAxisIndex: 1,
                       data:sjz_data,
//                    	   [120, 49, 70, 232, 256, 767, 136, 122, 326, 200,164, 133,120, 49, 70, 232, 256, 767, 156, 122, 326, 200,164, 133],
                       markPoint : {
                           data : [
                            //    {type : 'max', name: '最大值'},
                            //    {type : 'min', name: '最小值'}
                           ]
                       }
                   },
                   {
                       name:'最大可调出力',
                       symbol:'none',  //这句就是去掉点的
                       smooth:true,  //这句就是让曲线变平滑的
                       type:'line',
                       data:zdkt_data
//                    	   [26, 59, 30, 84, 27, 77, 176, 182, 487, 188, 60, 23,26, 59, 30, 84, 27, 77, 176, 182, 487, 188, 60, 23],



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

         		msg_comput =msg_comput+ comput_xzbykh_data(startdate) +" \r\n  <br>";
         		document.getElementById('computMsg').innerHTML = msg_comput;

         		for (var i=0;i<days;i++)
         		{


         			dayinit = getTomorrow(dayinit)
         			msg_comput =msg_comput+ comput_xzbykh_data(dayinit) +" \r\n  <br>";
         			document.getElementById('computMsg').innerHTML = msg_comput;
         		}

         		msg_comput =msg_comput+ "计算完成，共完成了" +(parseInt(daysAmount)+1)+"天的计算 \r\n  <br>";
         		document.getElementById('computMsg').innerHTML = msg_comput;

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


        function comput_xzbykh_data(rq){
        	var result = '';
        	 $.ajax({
     	  		type : "POST",
     	  		url : 'comput_xzbykh_data.action',
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


