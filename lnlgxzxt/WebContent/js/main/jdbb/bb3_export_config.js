

function export_style_config(){
//	var docFile_style = null;
	var docFile_style ="<style type='text/css'>";
     docFile_style +=" thead tr th";
     docFile_style +="{";
//     docFile_style +="border:1px solid black;";
     docFile_style +="font-size : 1.2em;";
      
     docFile_style +="} ";
     
     docFile_style += "thead tr th{height:35px;}";
     
     
     docFile_style +=" tbody tr td";
     docFile_style +="{";
//   docFile_style +="border:1px solid black;";
   docFile_style +="font-size : 1.2em;";
   
   docFile_style +="}";
     
     docFile_style +="</style> ";
     
     return docFile_style;
}


function export_title_config(){
//	var docFile_title = null;
//	 docFile_title +=" <h4 align='left'>表六：</h4>";
	var rq = $("#querydate").val();
	rq = getYYYYJD(rq) ;
//	var new_data =getYYYYMM(rq);  
	var docFile_title =" <div class='text' style='text-align:left;'><font size='3'  face='宋体' color='black'>表三：</font></div> ";   

//	 docFile_title +="<h3 align='center'>2018年一季度</h3>";
	 docFile_title +=" <div class='text' style='text-align:center;'><b><font size='5'  face='宋体' color='black'>竞价选择电力辅助服务提供方费用明细表</font></b></div>"; 
//	 docFile_title +=" <div class='text' > &nbsp  </div>"
     docFile_title +=" <div class='text' style=' text-align:center;'><font size='3'  face='宋体' color='black'>"+rq+"</font></div>";
//     docFile_title +=" <div class='text' style=' text-align:right;'> 单位：万千瓦、万千瓦时、万元、元/兆瓦时、分、% </div> ";
	docFile_title +="<div class='text' style='text-align:right;'>单位：万元、元/千千瓦时</div> ";    
     
	return docFile_title;
}

function export_tableStyle_config(){
	
	  var docData = '<table  border="1" width="40%" class="table table-striped table-bordered table-hover" ><thead>';

	  //引入style可以去掉excel背景格
/*	  style="table-layout: fixed; width:40px; word-break:break-all; word-wrap:break-all;"*/ 
      return docData;	  
}



function export_bottom_config(){
	
//	var docFile_bottom =" <h2 align='left'>  制表：               审核：                 批准：</h2>";
	var  docFile_bottom =" <div class='text' > &nbsp  </div>";
	 docFile_bottom =" <div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报单位：&nbsp 国网辽宁省电力有限公司 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 填报人:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 联系电话： </font></div>";
	 docFile_bottom +=" <div class='text' > &nbsp  </div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报说明：  参与范围应简单描述参与电厂个数、装机容量、占统调电厂比例；用户个数、用电量、占全社会用电量比例等。 </font></div>";
 
	return docFile_bottom;
}

