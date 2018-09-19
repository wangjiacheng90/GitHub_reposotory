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
        
<!-- 		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>      --> 
        <script src="assets/dist/echarts.js"></script>
        
<!--          <script type="text/javascript" src="js/H-ui.js"></script> 
        <script type="text/javascript" src="js/H-ui.admin.js"></script>  -->
        <!-- 上面这两个 会触发界面大小变化后 刷新界面 -->
        
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
            

<title>曲线考核</title>
<!--代替原来并网运行考核  -->
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
					<ul class="toolbar">
						<li class="computbt" id="computbt"><span><img src="others/images/comput.png" /></span> &nbsp计算</li>
					</ul>

				</div>  <!-- tools1 -->
					</div>  <!-- border clearfix -->
   
     <div class="type_title">曲线信息 
     <span class="top_show_btn Statistic_btn">显示</span> 
     <span class="Statistic_title Statistic_btn"><a title="隐藏" class="top_close_btn">隐藏</a></span>
     </div> 

      <!-- <div id="Statistics" class="Statistics"></div>  -->
      <!-- 曲线 -->
      <div id="Statistics" class="Statistics">
      <div id="main" style="height:420px; overflow:hidden; width:100%; overflow:auto" ></div> 
    </div>
    
      </div>



      <!--曲线数据列表样式-->
      <div class="grading_list">
       <div class="type_title">曲线数据列表</div>
         <div class="table_menu_list">

              <table class="table table-striped table-bordered table-hover" id="dataList_table">
             </table>
        </div>  <!-- ./table_menu_list -->
      </div>  <!--曲线数据列表样式---./grading_list  -->
  
   </div>  <!--右侧样式  -->
  </div>  <!-- category -->  
</div>



     <!--计算_弹出框   -->
<div id="history_add_style1"  style="display:none">

 <div  style="width:50%;float:left;margin-left:10px">
 <div class="add_adverts1">
  
    <ul >
    <li>
    <p >选择计算“开始日期”：</p>
		<span class="cont_style">
       <li> <input class="inline laydate-icon" id="add_comput_startdate" style=" margin-left:5px;" value=""></li>
            </span></li>

    <li>
    <p >选择计算“结束日期”：</p>
		<span class="cont_style">     
		<li> <input class="inline laydate-icon" id="add_comput_enddate" style=" margin-left:5px;" value=""></li>	
    </span></li>
   
     <span class="cont_style">

 <cite>如果是请点击确定按钮 ，否则请点取消。</cite> 
  </span> 
  
   </ul>
   
   
   
 </div>
<!--  <button  onclick="jd()" >  jindu</button> -->
 <!--  <button  onclick="comput1()" >  jindu</button> -->
 
 </div>  <!--left  -->
   <div style="width:42%;float:right;height:480px;margin-left:10px" >    
    <label id = "computMsg"> 计算开始：</label>      
    </div>
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
 
 $(function() { 
	$("#Statistic_pie").fix({
	  float: 'top',
		//minStatue : true, 
		skin : 'green',	
		durationTime :false,
		spacingw:0,
		spacingh:0,
		close_btn:'.top_close_btn',
		show_btn:'.top_show_btn',
		side_list:'.Statistics',
		close_btn_width:80,
		side_title:'.Statistic_title',
	});
});



</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()); 
 $(".page_right_style").width($(window).width()-220);
 //$(".table_menu_list").width($(window).width()-240);
  //当文档窗口发生改变时 触发   
    $(window).resize(function(){ 
	 $(".widget-box").height($(window).height()); 
	 $(".page_right_style").width($(window).width()-220);
	 $(".table_menu_list").width($(window).width()-240);
	 $(".main").width($(window).width()-220);
	 })  
/**************/

</script>
				

	<script type="text/javascript" src="js/mytool/laydate_data.js"></script> 
	<script type="text/javascript" src="js/mytool/getdate.js"></script> 
	<script type="text/javascript" src="js/main/bwyx/qxkh.js"></script> 
	
		<script>
	/*******计算*********/
	 $('#computbt').on('click', function(){
		 /* 初始化个数 */
		 num = parseInt("0");
		 msg ="";
		 
		  $('#add_comput_startdate').val($('#querydate').val());
		  $('#add_comput_enddate').val($('#querydate').val());
		  layer.open({
	        type: 1,
	        title: '曲线考核计算',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层 
	        area : ['480px' , '380px'],
	        content:$('#history_add_style1'),
			btn:['计算','关闭'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";


	  
			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 
	        	  comput(); 
	        		
				/*    layer.close(index);	 */
			  }		  		     				
			}
	    });


	})
	
	</script>
<!--***计算***   end***********************  -->
	

	
	<script>
	/*******添加记录******* **/
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

	
			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 /*  alert(options.val()+options2.val()+options3.val()); */
	        	  Save();
	        	 query();
				  layer.alert('添加成功！',{
	               title: '提示框',				
				icon:1,		
				  });
				   layer.close(index);	
			  }		  		     				
			}
	    });
	})
	
	</script>
	
		<script>
	/*******导入机组记录数据*********/
	 $('#add_dr_bt').on('click', function(){
		 
		  $('#dr_YYYY_MM_date').val($('#querydate').val());
	
		  layer.open({
	        type: 1,
	        title: '导入机组记录',
			maxmin: true, 
			shadeClose: false, //点击遮罩关闭层 
	        area : ['380px' , ''],
	        content:$('#dr_add_style1'),
			btn:['提交','取消'],
			yes:function(index,layero){	
			 var num=0;
			 var str="";

			  if(num>0){ num=0; return false;}	 	
	          else{
	        	 
	        	  add_drjzjl();  /*导入机组记录方法  */
	        	
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
	

