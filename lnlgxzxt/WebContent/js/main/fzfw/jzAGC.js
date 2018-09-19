//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间

// 日期定义 及初始化复制的js配置========================================
laydate({
            elem: '#querydate',

            event: 'focus' 
        });

             

        //初始赋值
           $('#querydate').val(getNowFormatDate);
       
      
 // 定义几个全局变量做为初始化用===用在table初始化表头时定义field用============================================     

 
           

//           // 初始化数据 和加载数据       
          function field_load(){
        	  
        		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");

               	var nodes = treeObj.getNodes()[0].children;
               	
               	if(nodes.length >0){
//               	alert(nodes[0].name+"  id :"+nodes[0].id+"nodes.length: "+nodes.length);
               		
               	var firstDcmc = nodes[0].name;
               	queryTable(firstDcmc);

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
           			/*{
                           checkbox: true
                       },*/
           			{
           				field : 'jzmc',
           				title : '机组名称',
           				sortable : true
           				
           			},
           			{
           				field : 'sj',
           				title : '时间',
           				sortable : true
           				
           			},  {
           				field : 'zt',
           				title : '状态',
           				sortable : true
           			}, {
           				field : 'yhgl',
           				title : '有功功率',
           				sortable : true	
           				
           			}, {
           				field : 'mbz',
           				title : '目标值',
           				sortable : true	
           			}
           		]
           	});
           }

           
//   查询曲线        
           function queryTable(jzmc) {
           	var rq = $("#querydate").val(); 
           	$.ajax({
           		type : "POST",
           		url : 'jzAGC_table.action',
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
                 
             	/*var dc_rq = $("#querydate").val(); */
    
               /*  title_txt = dc_rq+" "+selectedNode.name;*/
              
   
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
        	  		url : 'jzAGC_tree.action',
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
  
                    

               

      
