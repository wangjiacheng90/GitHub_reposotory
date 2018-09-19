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
      <!--   <script src="assets/layDate-v5.0.9/laydate/laydate.js" type="text/javascript"></script> -->
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
       <!--   <link rel="stylesheet" href="assets/css/ace.min.css" />
         <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
        <script src="js/lrtk.js" type="text/javascript" ></script> -->

  
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
            

<title>调峰市场报价</title>

<style>
.table thead tr {
     color: #777770; 
  
}
</style>

</head>

<body>
<div class="page-content clearfix">
 
     <div class="border clearfix">
   <!-- 工具栏 -->
			<div class="tools1">

				<ul class="seachform">
					<li><label class="l_f">日期：</label><input
						class="inline laydate-icon" id="querydate" value=""></li>
				</ul>
				<ul class="toolbar">

					<li class="querybt"><span><img
							src="others/images/ico06.png" /></span>查询</li>
				</ul>

			</div>
			<!-- ./tools1 -->

			<!-- 分页tab---start -->
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<!-- <ul class="nav nav-pills" id="myTab"> -->
					<!-- 可更改成胶囊样式tab -->
					<li class="active"><a data-toggle="tab" href="#1"><i
							class="green fa fa-home bigger-110"></i>&nbsp;运行调峰</a></li>

					<li class=""><a data-toggle="tab" data-toggle="dropdown"
						class="dropdown-toggle" href="#2">开停调峰</a></li>
					<li class=""><a data-toggle="tab" data-toggle="dropdown"
						class="dropdown-toggle" href="#3">出力限制</a></li>
					<li class=""><a data-toggle="tab" data-toggle="dropdown"
						class="dropdown-toggle" href="#4">最后报价</a></li>
				</ul>
				<!-- tab里内容 -->
				<div class="tab-content">
					<div id="1" class="tab-pane active">
						<!-- 数据表格 ------>
						<table class="table table-striped table-bordered table-hover"
							id="dataList_table1">
						</table>
						<!-- ./sort_list----数据表格-->
					</div>
					<div id="2" class="tab-pane ">
					<!-- 数据表格 ------>
						<table class="table table-striped table-bordered table-hover"
							id="dataList_table2">
						</table>
						<!-- ./sort_list----数据表格-->
					</div>
					
					<div id="3" class="tab-pane">
					<!-- 数据表格 ------>
						<table class="table table-striped table-bordered table-hover"
							id="dataList_table3">
						</table>
						<!-- ./sort_list----数据表格-->
					</div>
					<div id="4" class="tab-pane">
					<!-- 数据表格 ------>
						<table class="table table-striped table-bordered table-hover"
							id="dataList_table4">
						</table>
						<!-- ./sort_list----数据表格-->
					</div>
				</div><!-- ./tab里内容  --- end  -->

			</div>
			<!-- ./分页tab --end   -->


     
     
     
  
  <script type="text/javascript" src="js/mytool/laydate_data.js"></script> 
	<script type="text/javascript" src="js/main/fzfw/tfscbj.js"></script>
	
	
	
     </div>
     
     
     </div>


	

</body>

</html>

