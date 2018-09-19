<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
       
            
        <link rel="stylesheet" href="font/css/font-awesome.min.css" />
      
	 	<script src="js/jquery-1.9.1.min.js"></script> 
		<script src="assets/layer/layer.js" type="text/javascript" ></script>         	
<!-- 		<link href="others/css/select.css" rel="stylesheet" type="text/css" /> -->
        <script type="text/javascript" src="others/js/select-ui.min.js"></script>
      <!--   <script src="assets/layDate-v5.0.9/laydate/laydate.js" type="text/javascript"></script> -->
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>

  
       <link rel="stylesheet" href="assets/bootstrap/bootstrap/css/bootstrap.css" type="text/css"></link>
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.css" type="text/css"></link>
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css" type="text/css"></link>
     <link rel="stylesheet" href="assets/bootstrap/bootstrap-select/dist/css/bootstrap-select.css" type="text/css"></link>
     

<!-- // 左右选择css -->
<link rel="stylesheet" type="text/css" href="assets/mybootstrap/duallistbox/src/prettify.css">
<link rel="stylesheet" type="text/css" href="assets/mybootstrap/duallistbox/src/bootstrap-duallistbox.css">


   <script type="text/javascript" src="assets/bootstrap/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
     <script type="text/javascript" src="assets/bootstrap/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

 <link href="assets/bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/bootstrap/bootstrap3-editable-1.5.1/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
<link href="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet" />
 <link rel="stylesheet" href="assets/css/ace.min.css" />

<!-- 引入手风琴 -->
        <link rel="stylesheet" type="text/css" href="assets/mybootstrap/collapse/css/zzsc-demo.css">
        <link rel="stylesheet" type="text/css" href="assets/mybootstrap/collapse/css/style.css">

 <link rel="stylesheet" href="css/style.css"/>  


<script src="assets/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/bootstrap/bootstrap3-editable-1.5.1/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/extensions/editable/bootstrap-table-editable.js"></script>
 
<!--  //左右选择 js -->
<script src="assets/mybootstrap/duallistbox/src/jquery.bootstrap-duallistbox.js"></script>
       
        <script type="text/javascript">
            $(document).ready(function(){
              $(".querybt").click(function(){
            	  query();
              }); 
              
                   
            });
            </script>
            

<title>曲线考核指定</title>
</head>

<body>
<div class="page-content clearfix">
 <div class="sort_style" >  
 <!-- 工具栏 -->
     <div class="border clearfix">
   
	   <div class="tools1">
    
    <ul class="seachform">
    <li><label class="l_f">日期：</label><input class="inline laydate-icon" id="querydate"  value=""></li>
     <!-- <li><label class="l_f">日期：</label><input class="inline laydate-icon" id="querydate" style=" border: 1px solid #ddd;margin-left:20px; height:30px;width:200px;font-family:Microsoft YaHei;" value=""></li>
    -->
    </ul>
			<ul class="toolbar">
			
			<li class="querybt"><span><img src="others/images/ico06.png" /></span>查询</li>
			<li class="addbt" id="addbt"><span><img src="others/images/t01.png" /></span>添加</li>


			<li class="deletebt" id="deletebt"><span><img src="others/images/t03.png" /></span>删除</li>
			
			</ul>
		
		</div>	 	 

     </div>
     
     
     <!--添加记录-->
<div id="add_ads_style1"  style="display:none;margin-bottom:30px;">
<div >

 <div class="add_adverts1" >
 
 <!--  <div class="" style="height: 40px ;width: 380px" style="display: true" > -->
 
 <form id="demoform" action="#" method="post">
      <select multiple="multiple" size="10" name="duallistbox_demo2" id="form-field-select-hdkh" class="demo2" style="height: 180px ;width: 180px" >
        <option value="option1" >Option 1</option>
        <option value="option2">Option 2</option>
        <option value="option3" selected="selected">Option 3</option>


      </select>
      
       </form>
       
    <!--     <br>
    <button type="submit" class="btn btn-default btn-block"  onclick="daya()" >1Submit data</button>
      -->
     
      <script>
      
      //测试用
      function daya(){
    	  var data_all = [];
    	  var temp_fd = $('[name="duallistbox_demo2"]').val()
    	  data_all=data_all.concat(temp_fd);
    	  
    	  var temp_hdkh = $('[name="duallistbox_demo3"]').val()
    	  data_all=data_all.concat(temp_hdkh);
    	  
    	  var temp_hdmkh = $('[name="duallistbox_demo4"]').val()
    	  data_all=data_all.concat(temp_hdmkh);
    	  
    	  alert(data_all);

      }
      
  
  </script>
           <br> 
           
           
        <select multiple="multiple" size="10" name="duallistbox_demo3" id="form-field-select-hdmkh" class="demo3" style="height:180px ;width: 180px" >
        <option value="option1" >Option 1</option>
        <option value="option2">Option 2</option>
        <option value="option3" selected="selected">Option 3</option>
 
      </select>
      <script>
      //火电免考核
      </script>
      <br> 
       <select multiple="multiple" size="10" name="duallistbox_demo4" id="form-field-select-fd" class="demo4" style="height: 180px ;width: 180px" >
        <option value="option1" >Option 1</option>
   
      </select>
      <script>
// 风电考核
      </script>
   <!--  </div> -->
   
  
 <ul>
 
 
  <li>
  <label class="label_name">开始时间：</label>
  <span class="cont_style">
  <select class="form-control" id="form-field-select-qssj" name="起始时间" >
    <option value="">选择时间</option>
    <option value="00:15">00:15</option>
    <option value="00:30">00:30</option>
  </select></span>
  
  </li>
  
    <li>
  <label class="label_name">结束时间：</label>
  <span class="cont_style">
  <select class="form-control" id="form-field-select-zzsj" name="终止时间" >
    <option value="">选择时间</option>
    <option value="00:15">00:15</option>
    <option value="00:30">00:30</option>
  </select></span>
  
  </li>
  
    <li>
  <label class="label_name">考核类型：</label>
  <span class="cont_style">
  <select class="form-control" id="form-field-select-lx" name="类型" >
    <option value="">选择类型</option>
    <option value="1">不按指令发电</option>
    <option value="2">非停</option>
  </select></span>
  
  </li> 
  
  <li>
  <label class="label_name">备注原因：</label>
  <span class="cont_style">
  <select class="form-control" id="form-field-select-bzyy" name="备注原因" >
    <option value="">选择原因</option>
    <option value="1">曲线考核</option>
    <option value="2">非停考核</option>
  </select></span>
  
  </li> 


  
 </ul>
 </div>
  </div>
 
</div>   <!--添加记录 add_ads_style1  end  -->



 <!--删除按钮_弹出框   -->
<div id="add_tip_delete"  style="display:none">
 <div class="add_tip_delete_style">
  
    <ul >
    <li>
    <p >是否要删除选中数据：</p>

 <cite>如果是请点击确定按钮 ，否则请点取消。</cite> 
  </span> 
  
   </ul>
   
 </div>
</div>   <!-- ./add_tip_delete  删除按钮_弹出框  -->

 
 
  
 </div>
 
 <div class="">
<!-- 数据表格 -->
  <div   style="width:75%;float:left;margin-left:10px">  
    <table class="table table-striped table-bordered table-hover" id="dataList_table"  >
    曲线考核指定</table>   
  </div>
  
    <div  style="width:23%;float:right;margin-left:2px">
    考核列表
		<section class="">
		<div class="">
			<div class="col-md-12">
	
				<div class="panel-group wrap" id="bs-collapse">

					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#" href="#one">
									风电站 </a>
							</h4>
						</div>
						<div id="one" class="panel-collapse collapse">
							<div>
								<table class="table table-striped table-bordered table-hover"
									id="dataList_table_fd"></table>
							</div>
						</div>

					</div>
					<!-- end of panel -->

					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#" href="#two">
									火电考核机组 </a>
							</h4>
						</div>
						<div id="two" class="panel-collapse collapse">
						<div>
								<table class="table table-striped table-bordered table-hover"
									id="dataList_table_hdkh"></table>
							</div>

						</div>
					</div>
					<!-- end of panel -->

					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#" href="#three">
									火电免考核机组 </a>
							</h4>
						</div>
						<div id="three" class="panel-collapse collapse in">
							<div>
								<table class="table table-striped table-bordered table-hover"
									id="dataList_table_hdmkh"></table>
							</div>
					</div>
					<!-- end of panel -->

				</div>
				<!-- end of #bs-collapse  -->

			</div>



		</div>
		<!-- end of container --> </section>


	</div>

</div>


</div>


	<script type="text/javascript" src="js/mytool/laydate_data.js"></script> 

	<script type="text/javascript" src="js/main/yxgl/qxkhzd.js"></script> 
	
	<script>
	/*******添加记录*********/
	 $('#addbt').on('click', function(){
		//2018-06-22初始化 使左右选择的选项初始化
		 $('.removeall').click();
		  layer.open({
	        type: 1,
	        title: '添加记录',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层
	        area : ['470px' , '95%'],
	        content:$('#add_ads_style1'),
	        
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";

			 

		//   add_tip_fd();
	
			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 /*  alert(options.val()+options2.val()+options3.val()); */
	        	 
	        	  Save();
	        	 
				  /* layer.alert('添加成功！',{
	               title: '提示框',				
				icon:1,		
				  }); */
				   layer.close(index);	
			  }		  		     				
			}
	    });
		 
		  
	 })
	
	</script>
	

	
<script>
	/*******删除数据*********/
	 $('#deletebt').on('click', function(){
		 $
		  layer.open({
	        type: 1,
	        title: '导入历史数据',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层 
	        area : ['380px' , ''],
	        content:$('#add_tip_delete'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";

			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 
	        	  delrow();
	        	
				   layer.close(index);	
			  }		  		     				
			}
	    });

	})
	
	</script>

</body>

</html>

