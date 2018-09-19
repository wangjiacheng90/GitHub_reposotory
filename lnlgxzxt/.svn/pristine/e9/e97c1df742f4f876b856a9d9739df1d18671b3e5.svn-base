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
      

        <script src="assets/My97DatePicker/WdatePicker_my.js" type="text/javascript" ></script>  <!-- 季度日期 -->
        
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
   
    <!-- 打印 -->
 <script src="assets/bootstrap/bootstrap-table-master/dist/extensions/export/bootstrap-table-export.js"></script>
 <!-- 表头和格式 -->
 <script type="text/javascript" src="js/main/jdbb/bb2_export_config.js"></script> 
 
 <script src="assets/bootstrap/bootstrap-table-master/dist/extensions/export/tableExport_my.js"></script>
 
 
        <script type="text/javascript">
            $(document).ready(function(){
              $(".querybt").click(function(){
            	  query();
              }); 
              
              $(".exportbt").click(function(){
            	  exportExcel();
              });
                   
            });
            </script>
            

<title>两个细则结算单</title>


<style type="text/css">
 

</style>

</head>

<body>
<div class="page-content clearfix">
 <div class="sort_style" >  
 <!-- 工具栏 -->
     <div class="border clearfix">
   
	   <div class="tools1">
    
    <ul class="seachform">
    <li><label class="l_f">日期：</label>
 <!--    <input class="inline laydate-icon" id="querydate"  value=""> -->
 <!--   /assets/My97DatePicker/WdatePicker.js -->
    
     <input id="querydate" class="inline laydate-icon" value="" 	onclick = "WdatePicker({dateFmt:'yyyy年M季度', isQuarter:true, isShowOK:false, disabledDates:['....-0[5-9]-..','....-1[0-2]-..'], startDate:'%y-01-01' })"  type="text" />   
      
    </li>

        
    </ul>
			<ul class="toolbar">
			
			<li class="querybt"><span><img src="others/images/ico06.png" /></span>查询</li>
			
			<li class="hzbt"><span><img src="others/images/t04.png" /></span>汇总</li>
			
			<li class="exportbt"><span><img src="images/down_load.jpg" /></span>导出Excel</li>

			</ul>
			
			
		
		</div>	 	 
<!-- 数据表格 -->
  <div class="sort_list">
    <table class="table table-striped table-bordered table-hover" id="dataList_table"   style="table-layout: fixed; width:70px; word-break:break-all; word-wrap:break-all;">

    </table>
  </div>    <!-- ./sort_list    数据表格-->
  
    <script type="text/javascript" src="js/mytool/table_cells.js"></script> <!-- 合并单元格 -->
  <script type="text/javascript" src="js/mytool/laydate_data.js"></script> 
	<script type="text/javascript" src="js/main/jdbb/bb2.js"></script>
<!-- 	<script type="text/javascript" src="js/mytool/dwindow_title_drag2.js"></script>  -->
     </div>
     
     </div>
     </div>



 <!--汇总统计_弹出框   -->
<div id="add_tip_hz"  style="display:none">
 <div class="add_tip_delete_style"> <!--  风格和删除一样高-->
  
    <ul >
    <li>
    <p >是否要进行数据汇总操作！</p>

 <cite>如果是请点击确定按钮 ，否则请点取消。</cite> 
  </span> 
  
   </ul>
   
 </div>
</div>   <!-- ./add_tip_hz  汇总统计_弹出框  -->

<script>
	/*******汇总按钮*********/
	 $(".hzbt").on('click', function(){
		 $
		  layer.open({
	        type: 1,
	        title: '数据汇总',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层 
	        area : ['380px' , ''],
	        content:$('#add_tip_hz'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";

			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 
	        	  hz();
	        	
				   layer.close(index);	
			  }		  		     				
			}
	    });

	})
	
	</script>	

</body>

</html>

