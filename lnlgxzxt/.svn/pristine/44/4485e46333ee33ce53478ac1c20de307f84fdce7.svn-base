//document.write("<script language=javascript src='js/mytool/getdate.js'></script>");


//以上为设定时间

// 日期定义 及初始化复制的js配置========================================
laydate({
            elem: '#querydate',
            type: 'month',
            format: 'YYYY-MM',
            event: 'focus'
        });

laydate({
    elem: '#add_date',

    event: 'focus'
});


        //初始赋值
           $('#querydate').val(getNowFormatDateMonth());
           $('#add_date').val(getNowFormatDate());


// 定义几个全局变量做为初始化用===用在table初始化表头时定义field用============================================
//           var row_rq ='';
//           var row_jzmc ='';
//           var row_zy = '';


        var result_zy = [];
        var result_bz = [];

        var yhmc = "";

        $("#form-field-select-zy").change(function(){
            //要触发的事件
//        	alert("改变了");
        	 bz_init();

           });




 // 初始化数据 和加载数据
        function field_load(){
    	    yhmc = getMyName();
//    	    alert(yhmc);
        	result_zy=zy(yhmc);//专业
        	result_bz =bz();//备注下拉框
        	bz_init();
        }


//初始化加载，注意涉及到为编辑数据的判断部分，要在 query查询之前来加载====================================
        window.onload = $(function(){
        	field_load();  //初始化表头里内容的判断

        	tableinit(); // 初始化表头
        	query();	//查询

        	queryJZMC();  //查询机组



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
        		sortable: true,          //是否启用排序
        		sortOrder: "asc",       //排序方式
        		 showRefresh: false,                  //是否显示刷新按钮
//        		height : '100%',
        		//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        		url: "",
        		columns : [
        			{
                        checkbox: true
                    },
                    {
        				field : 'rq',
        				title : '日期',
        				sortable : true
        			},
        			{
        				field : 'jzmc',
        				title : '机组',
        				sortable : true
        			}, {
        				field : 'zy',
        				title : '专业',

        			}, {
        				field : 'fz',
        				title : '分值',
        				sortable : true

        			}, {
        				field : 'bz',
        				title : '备注',
        				sortable : true

        			}, {
        				field : 'fj',
        				title : '附件',
        				sortable : true

        			}
        		]

        		  //如果想单击获取row，把onDblClickRow改为onClickRow，如下
//                onClickRow: function (row) {
//                	alert("日期"+row.rq);
//                	row_rq = row.rq;
//                  },


        	});
        }






 //查询方法========================================================
        function query() {

        	var rq = $("#querydate").val();
        	$.ajax({
        		type : "POST",
        		url : 'yxglpf_table.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			"zy" : $("#page-field-select-zy option:selected").val(),
        			"yhmc" : yhmc
        		},
        		success : function(data) {
        			$('#dataList_table').bootstrapTable('load', data);
        		}
        	});

        }


//        保存方法===================================================================
        function Save() {
        	var save_istrue = "";
        	var rq = $("#add_date").val();

//        	document.getElementById("123").innerHTML =  "123123";

        	$.ajax({
        		type : "POST",
        		//url : 'jzzt1.action',  //测试用
        		url : 'yxglpf_add_Save.action',
        	    dataType: "json",
        		data : {
        			"rq" : rq,
        			 "jzmc":$("#form-field-select-1 option:selected").val(),

        			 "zy":$("#form-field-select-zy option:selected").val(),

        			 "fz":$("#form-field-select-fz").val(),

        			 "bz":$("#bz_box").val(),

        			 "yhmc" : yhmc

        		},
        		success : function(data) {
//        			alert(data);
        			save_istrue = data;

        		    var flag = "aa";
        		    flag = data;

   	        	 if(flag.indexOf("error") != -1){

   	        		  /*alert("记录未生成，不进行传文件："+flag);*/
   	        	 }else{
   	        		 /* alert("记录生成，上传文件："+flag);*/
   	        		 upload();
   	        	 }

   	        	 var videoForm = document.getElementById("uploadfiles"); //获取表单对象
	        	  videoForm.reset();// 重置表单

        			var str="";
          			layer.alert(str+=data+"！\r\n",{
          				title: '提示框',
          				icon:0,
          			});
         		},
         		 error: function () {
                     alert('编辑失败');

        		}
        	});

        	return save_istrue;
        }



//查询类型的方法，本实例 用在了 机组名称、状态、类型等方法的的封装，可供“下拉框”及“tale判断用”=============================
        function queryJZMC() {

        	$.ajax({
        		type : "POST",
        		url : 'yxglpf_jzmc.action',
        	    dataType: "json",
        		data : {
        			"rq" : "2018-05-05",
        			"yhmc":yhmc
        		},
        		success : function(data) {

        			$('#jzmc').empty(); //初始化菜单栏

        			$('#form-field-select-1').empty();  //初始化添加栏

        			for(var i = 0; i < data.length; i++){
        				var name  = data[i]['jzmc'];

       				$('#jzmc').append('<option>'+name+'</option>');//初始化下拉框
       				$('#form-field-select-1').append('<option>'+name+'</option>');

        			}

        		}
        	});

        }






// 删除方法==========且删除后查询============================================================
  function delrow() {
	  var rq = $("#querydate").val();
		var table = $("#dataList_table");
		var a = table.bootstrapTable('getSelections');
		if (a.length == 0) {
//			alert("请选中要刪除的行");
			var str="";
			layer.alert(str+="请选中要刪除的行！\r\n",{
	            title: '提示框',
				icon:0,
			 });
			return false;
		}

//		var array = [];

		var data_all ='';
		for (var i = 0; i < a.length; i++) {
			var data = "";
			data += a[i].jzmc;

			if(i==0){
				data_all+= a[i].rq+"@"+a[i].jzmc+"@"+a[i].zy

			}else{
				data_all += "&" +a[i].rq+"@"+a[i].jzmc+"@"+a[i].zy
			}
		}

    	$.ajax({
    		type : "POST",
    		url : 'yxglpf_delete.action',
    	    dataType: "json",
    		data : {
    			"rq":rq,
    			"data_all" : data_all,
    			"yhmc" : yhmc

    		},
    		success : function(data) {

    			var str="";
    			layer.alert(str+=data+"！\r\n",{
    	            title: '提示框',
    				icon:0,
    			 });
     		},
     		 error: function () {
     			layer.alert(str+="删除失败！\r\n",{
    	            title: '提示框',
    				icon:0,
    			 });

    		}
    	});


		query();
	}



//运行考核管理评分---专业=下拉框==============================================================================
  function zy(name) {
      var result = [];
      $.ajax({
  		type : "POST",
  		url : 'yxglpf_zy.action',
  		async: false, //如果不设置这里 将取不到值
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-01",
  			"yhmc" : name
  		},
  		success : function(data) {
  			$('#page-field-select-zy').empty();
  			$('#form-field-select-zy').empty();
  			for(var i = 0; i < data.length; i++){
  				var ID  = data[i]['ID'];
                  var Name = data[i]['Name'];
                  result.push({ value:ID, text:Name });
                  $('#form-field-select-zy').append('<option>'+Name+'</option>');
                  $('#page-field-select-zy').append('<option>'+Name+'</option>');

  			}
  		}
      });

      return result;
  }



//运行考核管理评分---备注=下拉框=只获取列=============================================================================
  function bz() {
      var result = [];
      $.ajax({
  		type : "POST",
  		url : 'yxglpf_bz.action',
  		async: false, //如果不设置这里 将取不到值
  	    dataType: "json",
  		data : {
  			"rq" : "2018-05-01",
  			"yhmc" : yhmc
  		},
  		success : function(data) {
  			/*$('#form-field-select-bz').empty();*/
  			for(var i = 0; i < data.length; i++){
  				var ID  = data[i]['ID'];
                  var Name = data[i]['Name'];
                  result.push({ value:ID, text:Name });
                /*  $('#form-field-select-bz').append('<option>'+Name+'</option>');*/

                  /*if(i==0){
                	  $('#bz_box').val(Name);
                  }*/

  			}
  		}
      });

      return result;
  }

//运行考核管理评分---备注=下拉框=获取列后赋值=============================================================================
//备注初始化
  function bz_init(){

  	var zy_select_value = $("#form-field-select-zy option:selected").val();
  	$('#form-field-select-bz').empty();
  	 $('#bz_box').val("");
  	var num = 0;
  	for(var i = 0; i < result_bz.length; i++){
			var ID  = result_bz[i]['value'];
            var Name = result_bz[i]['text'];

            if(zy_select_value == ID){

          	  $('#form-field-select-bz').append('<option>'+Name+'</option>');
            }
		}

  	//获取select下拉框中第一个值
  	 var selectId = document.getElementById("form-field-select-bz");
		var selectValue = selectId.options[0].value;
 	    $('#bz_box').val(selectValue);

  }


  /*
   * 上传文件
   */
  function upload(){
		var rq = $("#add_date").val();;
		var jzmc=$("#form-field-select-1 option:selected").val();
		var zy=$("#form-field-select-zy option:selected").val();

    var formData = new FormData($( "#uploadfiles" )[0]);
    var filename_upload = "";

    filename_upload =rq+"_"+jzmc+"_"+zy;
    var url_file = "upload.action?filename_upload="+filename_upload;


     $.ajax({
        type: "post",
        url: url_file,
        dataType: "json",
        data: formData,
        /**
         *必须false才会自动加上正确的Content-Type
         */
        contentType : false,
        /**
         * 必须false才会避开jQuery对 formdata 的默认处理
         * XMLHttpRequest会对 formdata 进行正确的处理
         */
        processData : false,
        success: function(data){//从后端返回数据进行处理
         if(data){
//           alert("文件上传成功！");
         }else{
//           alert("没有文件上传！");
         }
        },
        error: function(err) {//提交出错
          $("#msg").html(JSON.stringify(err));//打出响应信息
          alert("文件过大导入服务器无响应！");
         }
       });


  }


