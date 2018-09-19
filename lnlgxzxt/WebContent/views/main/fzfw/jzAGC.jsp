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


        <!--添加树结构及曲线  =================================================-->
        <link rel="stylesheet" href="Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
        <link href="Widget/icheck/icheck.css" rel="stylesheet" type="text/css" /> 
        

        <script src="assets/dist/echarts.js"></script>
        

        
        <script type="text/javascript" src="Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
        <script src="js/lrtk.js" type="text/javascript" ></script>
        <!--添加树结构及曲线 ===================================== -->

        
        <script type="text/javascript">
            $(document).ready(function(){
              $(".querybt").click(function(){
            	  query(); 
   
              }); 
                   
            });
            </script>
            

<title>机组AGC</title>

</head>

<body>

				
	<div class="grading_style">  
    <!-- 主体div  -->
<div id="category">

        <div id="scrollsidebar" class="left_Treeview">
                <div class="show_btn" id="rightArrow"><span></span></div>
                <div class="widget-box side_content" >
                 <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
                 <div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">厂站机组列表</h4></div>
                 <div class="widget-body">
                  <div class="widget-main padding-8"><div id="treeDemo" class="ztree"></div></div>
                </div>
               </div>
              </div>  
             </div>



  <!--右侧样式-->
   <div class="page_right_style right_grading">
   <div class="Statistics_style" id="Statistic_pie">
   
   <!-- 工具栏 -->
			<div class="border" style=" margin-bottom:0;">
				<div class="tools1">

					<ul class="seachform">
						<li><label class="l_f">日期：</label><input class="inline laydate-icon" id="querydate" value=""></li>
					</ul>
					<ul class="toolbar">
						<li class="querybt"><span><img src="others/images/ico06.png" /></span>查询</li>
					</ul>


				</div>  <!-- tools1 -->
					</div>  <!-- border clearfix -->



    
      </div>



      <!--曲线数据列表样式-->
      <div class="grading_list">
       <div class="type_title">机组AGC数据列表</div>
         <div class="table_menu_list">

              <table class="table table-striped table-bordered table-hover" id="dataList_table">
             </table>
        </div>  <!-- ./table_menu_list -->
      </div>  <!--曲线数据列表样式---./grading_list  -->
  
   </div>  <!--右侧样式  -->
  </div>  <!-- category -->  
</div>




</body>
</html>




<script type="text/javascript">  
 $(function() { 
	$("#category").fix({
	 float: 'left',  
		//minStatue : true, 
		skin : 'green',	
		durationTime :false,
		spacingw:20,
		spacingh:240,
		set_scrollsidebar:'.right_grading',
	});
});
 




</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()-15); 
 $(".page_right_style").width($(window).width()-220);
 //$(".table_menu_list").width($(window).width()-240);
  //当文档窗口发生改变时 触发   
    $(window).resize(function(){ 
	 $(".widget-box").height($(window).height()); 
	 $(".page_right_style").width($(window).width()-220);
	 $(".table_menu_list").width($(window).width()-240);
	/*  $(".main").width($(window).width()-220); */
	 })  
/**************/

</script>
				

	<script type="text/javascript" src="js/mytool/laydate_data.js"></script> 
	<script type="text/javascript" src="js/mytool/getdate.js"></script> 
	<script type="text/javascript" src="js/main/fzfw/jzAGC.js"></script> 
	


	

