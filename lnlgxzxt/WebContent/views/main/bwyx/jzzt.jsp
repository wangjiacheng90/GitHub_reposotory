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
		<link href="others/css/select.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="others/js/select-ui.min.js"></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
         
        <script src="js/lrtk.js" type="text/javascript" ></script> 

  
       <link rel="stylesheet" href="assets/bootstrap/bootstrap/css/bootstrap.css" type="text/css"></link>
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.css" type="text/css"></link>
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css" type="text/css"></link>
     <link rel="stylesheet" href="assets/bootstrap/bootstrap-select/dist/css/bootstrap-select.css" type="text/css"></link>
     

   <script type="text/javascript" src="assets/bootstrap/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
     <script type="text/javascript" src="assets/bootstrap/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>


 
 
 <link href="assets/bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/bootstrap/bootstrap3-editable-1.5.1/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
<link href="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
 <link rel="stylesheet" href="css/style.css"/>  

 <!-- <script src="js/jquery-1.9.1.min.js"></script>  -->
<script src="assets/bootstrap/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/bootstrap/bootstrap3-editable-1.5.1/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/bootstrap-table.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.js"></script>
<script src="assets/bootstrap/bootstrap-table-master/dist/extensions/editable/bootstrap-table-editable.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
              $(".querybt").click(function(){
            	  query();
              }); 
       
            });
            </script>
            

<title>机组指定</title>
</head>

<body>
<div class="page-content clearfix">
 <div class="sort_style">
     <div class="border clearfix">
   
	   <div class="tools1">
    
    <ul class="seachform">
    <li><label class="l_f">日期：</label><input class="inline laydate-icon" id="querydate" style=" margin-left:20px;" value=""></li>
    
    </ul>
			<ul class="toolbar">
			
			<li class="querybt"><span><img src="others/images/ico06.png" /></span>查询</li>
			<li class="addbt" id="addbt"><span><img src="others/images/t01.png" /></span>添加</li>
			<li class="addHistorybt"  id="addHistorybt"><span><img src="others/images/time.png" /></span>导入历史</li>
<!-- 			<li class="changebt"><span><img src="others/images/t02.png" /></span>修改</li> -->
			<li class="deletebt" id = "deletebt" ><span><img src="others/images/t03.png" /></span>删除</li>
			<!-- <li class="click" display="none"><span><img src="others/images/t04.png" /></span>统计</li> -->
			</ul>
			
			<ul class="toolbar1">
<!-- 			<li><span><img src="others/images/t05.png" /></span>设置</li> -->
			</ul>
		
		</div>
		<div class="tools1" >

				<ul class="seachform">
						<li><label class="l_f">起始日期：</label><input class="inline laydate-icon" id="start" style=" margin-left:20px;" value=""></li>
						<li><label class="l_f">终止日期：</label><input class="inline laydate-icon" id="end" style=" margin-left:20px;" value=""></li>
						<li><label class="l_f"> &nbsp机组：    &nbsp&nbsp</label>  
						
						<select class="vocation" id="jzmc">
	                    <option>大开厂1号机</option>
						</select>
						
						</li>
			  </ul>
			
		 </div>
		 
		 
		 	<div class="tools1" >
			  
			  <ul class="seachform">
						
						<li><label class="l_f">状态：     &nbsp</label>  
						
						<select class="vocation" id="jzzt">
	                    <option>并</option>
						</select>
						
						</li>
						
						<li style ="height:50px;" ><label class="l_f"> 类型：    &nbsp</label>  
						
						<select class="vocation" id="jzlx">
	                    <option>A级检修</option>
						</select>
						
						</li>
						
						<li class="fa fa-clock-o"><label class="l_f">状态发生时间：</label><input class="inline laydate-icon" id="zt_date" style=" margin-left:5px;" value=""></li>
												
						<li><label>&nbsp;</label><input name="" type="button" class="scbtn" onclick ="Update()" value="更新确定"/></li>
			  </ul>
			
		 </div>
		 

     </div>

     
     <!--添加记录_弹出框   -->
<div id="add_ads_style1"  style="display:none">
 <div class="add_adverts1">
 <ul>
  <li>
  <label class="label_name">选择机组</label>
  <span class="cont_style">
  <select class="form-control" id="form-field-select-1" name="机组">
    <option value="">选择分类</option>
    <option value="#1机组">#1机组</option>
    <option value="#2机组">#2机组</option>
    <option value="#3机组">#3机组</option>
    <option value="#4机组">#4机组</option>
    <option value="#5机组">#5机组</option>
  </select></span>
  </li>

  <li>
	<label class="label_name">状态</label>
	<span class="cont_style">
	<select class="form-control" id="form-field-select-2">
	  <option value="">选择分类</option>
	  <option value="检修">检修 </option>
	  <option value="停运">停运</option>
	
	</select></span>
	</li>

	
	<li>
		<label class="label_name">类型</label>
		<span class="cont_style">
		<select class="form-control" id="form-field-select-3">
		  <option value="">选择分类</option>
		  <option value="机组跳闸">机组跳闸</option>
		  <option value="检修停机">检修停机</option>
	
		</select></span>
		</li>
    <ul class="seachform">

   <li class="fa fa-clock-o"><label class="l_f">状态发生时间：</label><input class="inline laydate-icon" id="zt_date_add" style=" margin-left:5px;" value=""></li>
   </ul>
  
 </ul>
 </div>
</div>

     <!--导入历史数据_弹出框   -->
<div id="history_add_style1"  style="display:none">
 <div class="add_adverts1">
  
    <ul >
    <li>
    <p >选择历史“数据源日期”：</p>
		<span class="cont_style">
       <li> <input class="inline laydate-icon" id="add_history_sdate" style=" margin-left:5px;" value="">
            </span></li>

    <li>
    <p >选择导入数据“目的日期”：</p>
		<span class="cont_style">     
		<li> <input class="inline laydate-icon" id="add_history_ddate" style=" margin-left:5px;" value=""></li>	
    </span></li>
   
     <span class="cont_style">

 <cite>如果是请点击确定按钮 ，否则请点取消。</cite> 
  </span> 
  
   </ul>
   
 </div>
</div>


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



<!-- 数据表格 -->
  <div class="sort_list">
    <table class="table table-striped table-bordered table-hover" id="dataList_table">

    </table>
  </div>    <!-- ./sort_list    数据表格-->
  
  
 </div>
</div>


	<script type="text/javascript" src="js/main/bwyx/jzzt.js"></script>
	
	<script>
	/*******添加记录*********/
	 $('#addbt').on('click', function(){
		  layer.open({
	        type: 1,
	        title: '添加记录',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层
	        area : ['500px' , ''],
	        content:$('#add_ads_style1'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";

		   
		   var options=$("#form-field-select-1 option:selected");
		   if(options.val() ==""){
			num++;
			layer.alert(str+="机组不能为空！\r\n",{
	            title: '提示框',				
				icon:0,								
			 }); 
			 
		   }

		    var options2=$("#form-field-select-2 option:selected");
		   if(options2.val() ==""){
			num++;
			layer.alert(str+="类型不能为空！\r\n",{
	            title: '提示框',				
				icon:0,								
			 }); 
			
		   }

		    var options3=$("#form-field-select-3 option:selected");
		   if(options3.val() ==""){
			num++;
			layer.alert(str+="状态不能为空！\r\n",{
	            title: '提示框',				
				icon:0,								
			 }); 
			 
		   }

	  
			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 /*  alert(options.val()+options2.val()+options3.val()); */
	        	  Save();
	        	/*  querya(); */
	/* 			  layer.alert('添加成功！',{
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
	/*******导入历史数据*********/
	 $('#addHistorybt').on('click', function(){
		 
		  $('#add_history_sdate').val($('#querydate').val());
		  $('#add_history_ddate').val($('#querydate').val());
		  layer.open({
	        type: 1,
	        title: '导入历史数据',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层 
	        area : ['380px' , ''],
	        content:$('#history_add_style1'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";


	  
			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 
	        	  add_history();
	        	
				/*   layer.alert('添加成功！',{
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
		 
		  layer.open({
	        type: 1,
	        title: '删除数据',
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

