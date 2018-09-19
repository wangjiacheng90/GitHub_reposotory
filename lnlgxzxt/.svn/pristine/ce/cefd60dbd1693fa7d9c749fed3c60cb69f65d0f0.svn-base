

//以下为时间格式的设定，需要自己封装时间格式 ---当前时刻的日期-----当前时刻的日期+时分秒 
//获取当前时间，格式YYYY-MM-DD
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }

    
  //获取当前时间，格式YYYY-MM
    function getNowFormatDateMonth() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month;
        return currentdate;
    }
    
    
    //获取当前时间，格式YYYY年M季度
    function getNowFormatDateJD() {
        var date = new Date();
        var seperator1 = "年";
        var seperator2 = "季度";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 3) {
            month = "1";
        }else if(month >= 4 && month <= 6){
        	
        	month = "2";
        }else if(month >= 7 && month <= 9){
        	
        	month = "3";
        }else if(month >= 10 && month <= 12){
        	
        	month = "4";
        }
        
        var currentdate = year + seperator1 + month+ seperator2;
        return currentdate;
    }

  
  /** 
   * 获取当前时间 格式：yyyy-MM-dd HH:MM
   */  
  function getCurrentTime() {  
      var date = new Date();//当前时间  
      var month = zeroFill(date.getMonth() + 1);//月  
      var day = zeroFill(date.getDate());//日  
      var hour = zeroFill(date.getHours());//时  
      var minute = zeroFill(date.getMinutes());//分  
      var second = zeroFill(date.getSeconds());//秒  
        
      //当前时间  
      var curTime = date.getFullYear() + "-" + month + "-" + day  
              + " " + hour + ":" + minute ;  
        
      return curTime;  
  }  
    
  /** 
   * 补零 
   */  
  function zeroFill(i){  
      if (i >= 0 && i <= 9) {  
          return "0" + i;  
      } else {  
          return i;  
      }  
  } 
  
  
//YYYY-MM  2018-07年月格式转成  2018年7月1日--2018年7月31日
  function getLastDay(nnyy)   

  {   

   var n=nnyy.split("-");

    year = n[0];
   month = n[1];

   var new_year = year;  //取当前的年份   
   var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）   
   if(month>12)      //如果当前大于12月，则年份转到下一年   
   {   
   new_month -=12;    //月份减   
   new_year++;      //年份增   
   }   
   var new_date = new Date(new_year,new_month,1);        //取当年当月中的第一天   
  //  return (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期   
   var lastday = (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期   
   month--;
   return year+'年'+month+'月'+'1日--'+month+'月'+lastday+'日';
  }  
  
  
//YYYY-MM  2018-07年月格式转成  2018年7月
  function getYYYYMM(nnyy)   

  {   

   var n=nnyy.split("-");

    year = n[0];
   month = n[1];

   var new_year = year;  //取当前的年份   
   var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）   

   month--;
   return year+'年'+month+'月';
  }  
  
  
//格式YYYY年M季度 >> 2018年1季度 格式转成 >> 2018年一季度
  function getYYYYJD(YYM)   

  {   

   var n=YYM.split("年");

    year = n[0];
   var m = n[1].split("季");
   
   jd = m[0];
	   
   if(jd == 1){
	   jd = "一";
   }else if(jd == 2){
	   jd = "二";
   }else if(jd == 3){
	   jd = "三";
   }else if(jd == 4){
	   jd = "四";
   }
   
   
   return year+'年'+jd+'季度';
  } 
  
