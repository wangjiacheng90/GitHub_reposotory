

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
	var docFile_title =" <div class='text' style='text-align:left;'><font size='3'  face='宋体' color='black'>表四：</font></div> ";   

//	 docFile_title +="<h3 align='center'>2018年一季度</h3>";
	 docFile_title +=" <div class='text' style='text-align:center;'><b><font size='5'  face='宋体' color='black'>电力辅助服务资金来源表</font></b></div>"; 
//	 docFile_title +=" <div class='text' > &nbsp  </div>"
     docFile_title +=" <div class='text' style=' text-align:center;'><font size='3'  face='宋体' color='black'>"+rq+"</font></div>";
//     docFile_title +=" <div class='text' style=' text-align:right;'> 单位：万千瓦、万千瓦时、万元、元/兆瓦时、分、% </div> ";
	docFile_title +="<div class='text' style='text-align:right;'>单位：万元、%</div> ";    
     
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
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报说明：  1.减免费用是指因未按照电量（电费）公平分摊、直接交易发用曲线一致等情况减免的费用。 </font></div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>&nbsp&nbsp&nbsp&nbsp&nbsp  2.其他费用是指考核、结余费用等。 </font></div>";
	 
	return docFile_bottom;
}

