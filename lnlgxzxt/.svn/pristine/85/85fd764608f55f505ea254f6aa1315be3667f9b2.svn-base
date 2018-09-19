

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
	
	var new_data = "("+getLastDay(rq)+")";
	
//	var docFile_title =" <h2 align='center'>辽宁电网并网运行考核结算清单</h2>";
//	 docFile_title +="<h3 align='center'>2018年一季度</h3>";
	var docFile_title ="<div class='text' style='text-align:center;'><b><font size='5'  face='SimSun' color='black'>辽宁电网并网运行考核结算清单</font></b></div>"; 
    docFile_title +="<div class='text' style='text-align:center;'><b><font size='4'  face='SimSun' color='black'>"
    	            +new_data+"</font></b></div>"; 

//     docFile_title +=" <div class='text' style=' text-align:center;'>2018年一季度</div>";
//     docFile_title +=" <div class='text' style=' text-align:right;'> 单位：万千瓦、万千瓦时、万元、元/兆瓦时、分、% </div> ";
	docFile_title +="<div class='text' style='text-align:right;'>单位：元</div> ";    
     
	return docFile_title;
}

function export_tableStyle_config(){
	
	  var docData = '<table  border="1" width="80%" class="table table-hover" ><thead>';

    return docData;	  
}


function export_bottom_config(){
	
	var docFile_bottom =" <h2 align='left'>  制表：               审核：                 批准：</h2>";
	return docFile_bottom;
}

