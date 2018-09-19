

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
	rq = getYYYYJD(rq);
//	var new_data =getYYYYMM(rq);  
	var docFile_title =" <div class='text' style='text-align:left;'><font size='3'  face='宋体' color='black'>表六：</font></div> ";   

//	 docFile_title +="<h3 align='center'>2018年一季度</h3>";
	 docFile_title +=" <div class='text' style='text-align:center;'><b><font size='5'  face='宋体' color='black'>并网运行考核和辅助服务补偿结算汇总表</font></b></div>"; 
//	 docFile_title +=" <div class='text' > &nbsp  </div>"
     docFile_title +=" <div class='text' style=' text-align:center;'><font size='3'  face='宋体' color='black'>"+rq+"</font></div>";
//     docFile_title +=" <div class='text' style=' text-align:right;'> 单位：万千瓦、万千瓦时、万元、元/兆瓦时、分、% </div> ";
	docFile_title +="<div class='text' style='text-align:right;'><font size='3'  face='宋体' color='black'>单位：万千瓦、万千瓦时、万元、元/兆瓦时、%</font></div> ";    
     
	return docFile_title;
}

function export_tableStyle_config(){
	
	  var docData = '<table  border="1" width="100%" class="table table-striped table-bordered table-hover" ><thead>';

      return docData;	  
}



function export_bottom_config(){
	
//	var docFile_bottom =" <h2 align='left'>  制表：               审核：                 批准：</h2>";
	var  docFile_bottom =" <div class='text' > &nbsp  </div>";
	 docFile_bottom =" <div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报单位：&nbsp&nbsp&nbsp&nbsp  国网辽宁省电力有限公司 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 填报人:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 联系电话： </font></div>";
	 docFile_bottom +=" <div class='text' > &nbsp  </div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报说明：  1.占总补偿费用比例，是指单项辅助服务补偿费用（如AGC），占总补偿费用的比例。 </font></div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>&nbsp&nbsp&nbsp&nbsp&nbsp  2.占当期电费比例，是指对应单项补偿费用与当期电费的比例。 </font></div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>&nbsp&nbsp&nbsp&nbsp&nbsp  3.各地可根据实际增加项目和细化项目。 </font></div>";
	 
	 docFile_bottom = "";
	return docFile_bottom;
}

