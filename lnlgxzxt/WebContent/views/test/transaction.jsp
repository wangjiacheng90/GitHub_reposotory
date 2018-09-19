<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="../../css/style.css"/>
        <link rel="stylesheet" href="../../assets/css/font-awesome.min.css" />
        <link href="../../assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="../../font/css/font-awesome.min.css" />
     
		<script src="../../assets/js/ace-extra.min.js"></script>

		<script src="../../js/jquery-1.9.1.min.js" type="text/javascript"></script>       
		
        <script src="../../assets/dist/echarts.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        
         <!-- 日历 -->
         <link rel="stylesheet" href="../../assets/css/ace.min.css" />
         <script src="../../assets/layer/layer.js" type="text/javascript" ></script>
         <script src="../../assets/laydate/laydate.js" type="text/javascript"></script>
        
        <!-- 表格-->
         <script src="../../assets/js/typeahead-bs2.min.js"></script>
		
		<script src="../../assets/js/jquery.dataTables.min.js"></script>
		<script src="../../assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="../../js/H-ui.js"></script> 
        <script type="text/javascript" src="../../js/H-ui.admin.js"></script> 
         <script src="../../js/lrtk.js" type="text/javascript" ></script>
        
<title>交易</title>
</head>

<body>
<div class=" page-content clearfix">
<div id="products_style">
	<div class="search_style">

		<ul class="search_content clearfix">
			<li><label class="l_f">产品名称</label><input name="" type="text"
				class="text_add" placeholder="输入品牌名称" style="width: 250px" /></li>
			<li><label class="l_f">添加时间</label><input
				class="inline laydate-icon" id="start" style="margin-left: 10px;"></li>
			<li style="width: 90px;"><button type="button"
					class="btn_search">
					<i class="icon-search"></i>查询
				</button></li>
		</ul>
	</div>
	</div>
</div>


	<div class="t_Record">
		<div id="main"
			style="height: 400px; overflow: hidden; width: 100%; overflow: auto"></div>
	     </div>
	</div>

	<div class=" page-content clearfix">
 <div class="transaction_style">
   <ul class="state-overview clearfix">
    <li class="Info">
     <span class="symbol red"><i class="fa fa-jpy"></i></span>
     <span class="value"><h4>预测总量</h4><p class="Quantity color_red">34565.68</p></span>
    </li>
     <li class="Info">
     <span class="symbol  blue"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>实际总量</h4><p class="Quantity color_red">5656</p></span>
    </li>
     <li class="Info">
     <span class="symbol terques"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>历史总量</h4><p class="Quantity color_red">34565</p></span>
    </li>
     <li class="Info">
     <span class="symbol yellow"><i class="fa fa-shopping-cart"></i></span>
     <span class="value"><h4>修正总量</h4><p class="Quantity color_red">34</p></span>
    </li>
     <li class="Info">
     <span class="symbol darkblue"><i class="fa fa-jpy"></i></span>
     <span class="value"><h4>全部量</h4><p class="Quantity color_red">3441.68</p></span>
    </li>
   </ul>
 

 </div>
 
  <div class="h_products_list clearfix">
  
  <div class="table_menu_list" id="testIframe">
  <table class="table table-striped table-bordered table-hover" id="sample-table">
   <thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80px">电厂编号</th>
				<th width="250px">电厂名称</th>
				<th width="100px">原价格</th>
				<th width="100px">现价</th>
                <th width="100px">所属地区/国家</th>				
				<th width="180px">加入时间</th>
                <th width="80px">审核状态</th>
				<th width="70px">状态</th>                
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
     <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">A电厂</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
       <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">A电厂</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">辽宁</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">A电厂</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">吉林</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">A电厂</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">黑龙江</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">A电厂</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">东北</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	  
     

    </tbody>
  </table>
 
 </div>
 
 
 <div id="products_style" >
<!--  <div class="h_products_list clearfix" id="products_list"> -->
   <div class=" page-content clearfix">
   <div class="h_products_list clearfix" id="products_list">
    
         <div class="table_menu_list" id="testIframe" style="height: 400px; overflow: hidden; width: 100%; overflow: auto">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80px">产品编号</th>
				<th width="250px">产品名称</th>
				<th width="100px">原价格</th>
				<th width="100px">现价</th>
                <th width="100px">所属地区/国家</th>				
				<th width="180px">加入时间</th>
                <th width="80px">审核状态</th>
				<th width="70px">状态</th>                
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
     <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">小米 Max 全网通 高配版 3GB内存 64GB ROM 金色 移动联通电信4G手机Y</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
       <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">小米 Max 全网通 高配版 3GB内存 64GB ROM 金色 移动联通电信4G手机Y</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">小米 Max 全网通 高配版 3GB内存 64GB ROM 金色 移动联通电信4G手机Y</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">小米 Max 全网通 高配版 3GB内存 64GB ROM 金色 移动联通电信4G手机Y</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
	   <tr>
        <td width="25px"><label><input type="checkbox" class="ace" ><span class="lbl"></span></label></td>
        <td width="80px">45631</td>               
        <td width="250px"><u style="cursor:pointer" class="text-primary" onclick="">小米 Max 全网通 高配版 3GB内存 64GB ROM 金色 移动联通电信4G手机Y</u></td>
        <td width="100px">5467</td>
        <td width="100px">4525</td> 
        <td width="100px">法国</td>         
        <td width="180px">2014-6-11 11:11:42</td>
        <td class="text-l">通过</td>
        <td class="td-status"><span class="label label-success radius">已启用</span></td>
        <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
        <a title="删除" href="javascript:;"  onclick="member_del(this,'1')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
       </td>
	  </tr>
     

    </tbody>
    </table>
    </div>     
  </div>
 </div>
<!--  </div> -->
</div> 

</body>
</html>
<script type="text/javascript">
     $(document).ready(function(){
		 
		  $(".t_Record").width($(window).width()-60);
		  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
		 $(".t_Record").width($(window).width()-60);
		});
 });
	 
	 
        require.config({
            paths: {
                echarts: '../../assets/dist'
            }
        });
        require(
            [
                'echarts',
				'echarts/theme/macarons',
                'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/bar'
            ],
            function (ec,theme) {
                var myChart = ec.init(document.getElementById('main'),theme);
               option = {
    title : {
        text: '电力曲线',
        subtext: '实时获取电力信息'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        /* data:['所有订单','待付款','已付款','代发货'] */
        data:['预测','实际','历史','修正曲线'] 
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'预测',
            type:'bar',
            data:[120, 49, 70, 232, 256, 767, 1356, 1622, 326, 200,164, 133],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            }           
        },
        {
            name:'实际',
            type:'bar',
            data:[26, 59, 30, 84, 27, 77, 176, 1182, 487, 188, 60, 23],
            markPoint : {
                data : [
                    {name : '年最高', value : 1182, xAxis: 7, yAxis: 1182, symbolSize:18},
                    {name : '年最低', value : 23, xAxis: 11, yAxis: 3}
                ]
            },
           
			
        }
		, {
            name:'历史',
            type:'bar',
            data:[26, 59, 60, 264, 287, 77, 176, 122, 247, 148, 60, 23],
            markPoint : {
                data : [
                    {name : '年最高', value : 172, xAxis: 7, yAxis: 172, symbolSize:18},
                    {name : '年最低', value : 23, xAxis: 11, yAxis: 3}
                ]
            },
           
		}
		, {
            name:'修正曲线',
            type:'bar',
            data:[26, 59, 80, 24, 87, 70, 175, 1072, 48, 18, 69, 63],
            markPoint : {
                data : [
                    {name : '年最高', value : 1072, xAxis: 7, yAxis: 1072, symbolSize:18},
                    {name : '年最低', value : 22, xAxis: 11, yAxis: 3}
                ]
            },
           
		}
    ]
};
                    
                myChart.setOption(option);
            }
        );
    </script> 
  <script>
jQuery(function($) {
	
	var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,8,9]}// 制定列不参与排序
		] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			});
 laydate({
    elem: '#start',
    event: 'focus' 
});
 
 $(function() { 
		$("#products_style").fix({
			float : 'left',
			//minStatue : true,
			skin : 'green',	
			durationTime :false,
			spacingw:30,//设置隐藏时的距离
		    spacingh:260,//设置显示时间距
		});
	});

 </script> 
 
 <script type="text/javascript">
//初始化宽度、高度  
/*  $(".widget-box").height($(window).height()-215);  */
$(".table_menu_list").width($(window).width()-260);
 $(".table_menu_list").height($(window).height()-215);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-215);
	 $(".table_menu_list").width($(window).width()-260);
	  $(".table_menu_list").height($(window).height()-215);
	})