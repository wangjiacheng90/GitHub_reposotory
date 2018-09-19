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
        		
        		height :($(window).height()-110),
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			/*{
                        checkbox: true
                    },
        			{
        				field : 'rq',
        				title : '日期',
        				sortable : true
        				
        			},*/
        			
        			{
        				field : 'jsdy',
        				title : '结算单元',
        		/*		colspan: 1,  
        				 rowspan: 2,*/
//        				sortable : true
        				 valign:"middle",
          	            align:"center",
          	            width:100
        			}, {
        				field : 'khdy',
        				title : '考核单元',
//        				sortable : true
        				 valign:"middle",
           	            align:"center",
           	            width:100
        			}, {
        				field : 'dl',
        				title : '电量',
//        				sortable : true	
        				 valign:"middle",
           	            align:"center",
           	            width:100
        				
        			}
        		]
        	});
        }

        
//查询方法========================================================       
        
        function query() {
        	var rq = $("#querydate").val(); 
        	$.ajax({
        		type : "POST",
        		url : 'yddl_query.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        			
        			var data = $('#dataList_table').bootstrapTable('getData', true);
                    //合并单元格
                    mergeCells(data, "khdy", 1, $('#dataList_table'));
        		},
        		
        	});

        }

    
   /*     $('#TableName').bootstrapTable('mergeCells', { index: 0, field: '类别名称', colspan: 0, rowspan: 1});

        index  是重第几行开始           colspan ： 跨几列    rowspan ： 跨几行*/

  
  
  /**
   * 合并单元格
   * @param data  原始数据（在服务端完成排序）
   * @param fieldName 合并属性名称
   * @param colspan   合并列
   * @param target    目标表格对象
   */
  function mergeCells(data,fieldName,colspan,target){
      //声明一个map计算相同属性值在data对象出现的次数和
      var sortMap = {};
      for(var i = 0 ; i < data.length ; i++){
          for(var prop in data[i]){
              if(prop == fieldName){
                  var key = data[i][prop]
                  if(sortMap.hasOwnProperty(key)){
                      sortMap[key] = sortMap[key] * 1 + 1;
                  } else {
                      sortMap[key] = 1;
                  }
                  break;
              } 
          }
      }
      for(var prop in sortMap){
          console.log(prop,sortMap[prop])
      }
      var index = 0;
      for(var prop in sortMap){
          var count = sortMap[prop] * 1;
          $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});   
          index += count;
      }
  }
