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



<!-- <link rel="stylesheet" href="assets/mybootstrap/FileInputDemo/css/fileinput.min.css" /> -->

<!-- <script type="text/javascript" src="assets/mybootstrap/FileInputDemo/js/jquery-3.2.1.js" ></script> -->

<!-- <script type="text/javascript" src="assets/mybootstrap/FileInputDemo/js/fileinput.min.js"></script>
<script type="text/javascript" src="assets/mybootstrap/FileInputDemo/js/zh.js"></script>
 <script type="text/javascript" src="assets/mybootstrap/FileInputDemo/js/my1.js" ></script>  -->

        <script type="text/javascript">
            $(document).ready(function(){
              $(".querybt").click(function(){
            	  query();
              });

              /* $(".computbt").click(function(){
            	  comput();
              });  */

            });
            </script>

          <script type="text/javascript">
          //获取用户名
	       function getMyName(){
	   　     　     var myName="<%=session.getAttribute("uid")%>";
	   　 /* 　alert(myName);    */
	      return myName;
	　          　}

	    </script>


        <script language="JavaScript" type="text/javascript">
        //判断输入只能是数字
           function clearNoNum(obj)
                 {
                //先把非数字的都替换掉，除了数字和.
                  obj.value = obj.value.replace(/[^\d.]/g,"");
                //必须保证第一个为数字而不是.
                  obj.value = obj.value.replace(/^\./g,"");
                //保证只有出现一个.而没有多个.
                  obj.value = obj.value.replace(/\.{2,}/g,".");
                //保证.只出现一次，而不能出现两次以上
                  obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
                 }
            </script>
<title>运行管理评分</title>

<style type="text/css">
a:link {color: #3498db;text-decoration: underline}  /* 未被访问的链接 */
a:visited {color:#3498db}  /* 已被访问的链接 */
a:hover {color: blue}  /* 鼠标指针移动到链接上 */
a:active {color: blue}  /* 正在被点击的链接 */
a {text-decoration: underline}
</style>
</head>

<body>
<div class="page-content clearfix">
 <div class="sort_style" >
 <!-- 工具栏 -->
     <div class="border clearfix">

	   <div class="tools1">

    <ul class="seachform">
    <li><label class="l_f">日期：</label><input class="inline laydate-icon" id="querydate"  value=""></li>

    <li sytle=" margin-top: 4px;"><label class="l_f"> &nbsp&nbsp 专业：</label>

	<select class="vocation" id="page-field-select-zy" >
	      <option value="xt">系统</option>
	     <option value="jh">计划</option>
	     <option value="xny">新能源</option>
	</select>
	</li>

    </ul>

			<ul class="toolbar">

			<li class="querybt"><span><img src="others/images/ico06.png" /></span>查询</li>
			<li class="addbt" id="addbt"><span><img src="others/images/t01.png" /></span>添加</li>


			<li class="deletebt" id="deletebt"><span><img src="others/images/t03.png" /></span>删除</li>


			</ul>

		</div>

     </div>


     <!--添加记录-->
<div id="add_ads_style1"  style="display:none">
 <div class="add_adverts1">

 <ul>
  <li>
     <label class=""> &nbsp &nbsp &nbsp&nbsp选择日期&nbsp</label>
           <input class="inline laydate-icon" id="add_date"  value="">
     </li>
  <li>
  <label class="label_name">选择机组</label>
  <span class="cont_style">
    <select class="form-control" id="form-field-select-1" name="机组">
       <option value="">选择分类</option>
       <option value="#1机组">#1机组</option>
       <option value="#2机组">#2机组</option>
    </select></span>
  </li>

  <li>
	<label class="label_name">专&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp业</label>
	<span class="cont_style">
	   <select class="form-control" id="form-field-select-zy">

	   </select></span>
	</li>

	  <li>
	<label class="label_name">分&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp值</label>
	<span class="cont_style">
       <input type="text" id="form-field-select-fz" onkeyup="clearNoNum(this)" style="width:220px;height:32px;" value=0>

	</li>

	  <li>
	<label class="label_name">备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注</label>
	<span class="cont_style">
	   <select class="form-control" id="form-field-select-bz" onchange="this.parentNode.nextSibling.value=this.value;">
	       <option value="">选择备注</option>
	       <option value="2">2 </option>
	       <option value="5">5</option>

	   </select></span><input name="bz_box" id="bz_box" style="width:200px;height:32px;position:absolute;left:106px;">
	</li>

	  <li>
	<label class="label_name">上传文件 </label>
	<span class="cont_style">
	<form id="uploadfiles" enctype="multipart/form-data">
    <input type="file" multiple="multiple" id="file_upload" name="file_upload" />

   </form>
	   </span>
	</li>


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

 <!--删除按钮_弹出框   -->



 </div>
</div>

<!-- 数据表格 -->


   <div   class="sort_list" >
		<table class="table table-striped table-bordered table-hover"
			id="dataList_table">
		</table>
	</div>

	<div>


	<br>
<!-- 	新方法 -->

	</div>


	<!-- <a href="download_file.action?name=2018-06-01_1机组_1专业.jpg" id="testJson">test_download_error</a><br/>
	 -->

<script type="text/javascript" src="js/mytool/laydate_data.js"></script>
	<script type="text/javascript" src="js/main/yxgl/yxglpf.js"></script>

	<script>
	/*******添加记录*********/
	 $('#addbt').on('click', function(){
		  layer.open({
	        type: 1,
	        title: '添加记录',
			maxmin: true,
			shadeClose: false, //点击遮罩关闭层
	        area : ['560px' , '60%'],
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
	        /* 	  Save(); */
	              Save();

	        	 /*  var videoForm = document.getElementById("uploadfiles"); //获取表单对象
	        	  videoForm.reset();// 重置表单 */

	        	/*  query(); */
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

		  layer.open({
	        type: 1,
	        title: '删除',
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

