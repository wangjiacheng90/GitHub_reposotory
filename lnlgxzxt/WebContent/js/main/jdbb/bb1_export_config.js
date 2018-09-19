

function export_style_config(){
//	var docFile_style = null;
	var docFile_style ="<style type='text/css'>";
/*     docFile_style +="table,th,td";
     docFile_style +="{";
     docFile_style +="border:1px solid black;";
     docFile_style +="}";*/
     docFile_style +="</style>";
     
     return docFile_style;
}


function export_title_config(){
//	var docFile_title = null;
//	 docFile_title +=" <h4 align='left'>表六：</h4>";
	var rq = $("#querydate").val();
	
	var new_data =getYYYYMM(rq);  
	var docFile_title ="<div class='text' style='text-align:left;'>表一：</div> ";   

//	 docFile_title +="<h3 align='center'>2018年一季度</h3>";
	 docFile_title +=" <div class='text' style='text-align:center;'><b><font size='5'  face='宋体' color='black'>电力辅助服务基础数据表</font></b></div>"; 
	docFile_title +=" <div class='text' > &nbsp  </div>"
//     docFile_title +=" <div class='text' style=' text-align:center;'>2018年一季度</div>";
//     docFile_title +=" <div class='text' style=' text-align:right;'> 单位：万千瓦、万千瓦时、万元、元/兆瓦时、分、% </div> ";
//	docFile_title +="<div class='text' style='text-align:right;'>单位：元</div> ";    
     
	return docFile_title;
}

function export_tableStyle_config(){
	
	  var docData = '<table  border="1" width="50%" class="table table-hover" ><thead>';

      return docData;	  
}



function export_bottom_config(){
	
//	var docFile_bottom =" <h2 align='left'>  制表：               审核：                 批准：</h2>";
	var  docFile_bottom =" <div class='text' > &nbsp  </div>";
	 docFile_bottom =" <div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报单位：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 填报人:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 联系电话： </font></div>";
	 docFile_bottom +=" <div class='text' > &nbsp  </div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>填报说明：1.考核参数是指计量公式中涉及的考核参数，如AGC的响应时间等。 </font></div>";
	 docFile_bottom +="<div class='text' style='text-align:left;'> <font size='3'  face='宋体' color='black'>&nbsp&nbsp&nbsp&nbsp&nbsp 2.本表如无情况变化，只需首次填报。 </font></div>";

	return docFile_bottom;
}

