package com.demo.base;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 公用方法类，包含一般常用的方法
 *
 */
public class Utilities {


	/**
	 * 判断参数date是否在参数startdate至参数enddate日期之间
	 * @param startdate
	 * 起始日期，String型日期描述，格式：yyyy-MM-dd
	 * @param enddate
	 * 终止日期，String型日期描述，格式：yyyy-MM-dd
	 * @param date
	 * 需要判断的日期，String型日期描述，格式：yyyy-MM-dd
	 * @return
	 * 当date在startdate和enddate之间时返回true，否则返回false
	 */
	public static boolean IsStartAndEndTime(String startdate, String enddate, String date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = new Date();
		Date dt2 = new Date();
		Date dt3 = new Date();
		try {
			dt1 = sf.parse(startdate);
			dt2 = sf.parse(enddate);
			dt3 = sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (dt3.before(dt1) || dt3.after(dt2)) {
			return false;
		}

		return true;
	}

	public static boolean IsStartAndEndTime(String startdate, String enddate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = new Date();
		Date dt2 = new Date();
		try {
			dt1 = sf.parse(startdate);
			dt2 = sf.parse(enddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if ( dt1.after(dt2)||dt1.equals(dt2)) {
			return false;
		}

		return true;
	}
	/**
	 * 获取系统当前时间
	 * @return
	 * String型时间描述，格式：HH:mm:ss
	 */
	public static String getSysTime() {
		SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
		return sf.format(new Date());
	}

	/**
	 * 获取系统当前日期
	 * @return
	 * String型日期描述，格式： yyyy-MM-dd
	 */
	public static String getToday() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(new Date());
	}

	/**
	 * 获取昨日日期，参数格式yyyy-MM-dd
	 * @param today
	 * 当前日期，String型日期描述，格式：yyyy-MM-dd
	 * @return
	 * 昨日日期，String型日期描述，格式：yyyy-MM-dd
	 */
	public static String getYesterday(String today) {
		int tyear, tmonth, tday;
		StringTokenizer st = new StringTokenizer(today, "-");
		int year = Integer.parseInt(st.nextToken().trim());
		int month = Integer.parseInt(st.nextToken().trim());
		int day = Integer.parseInt(st.nextToken().trim());

		if (day == 1) {
			if (month == 1) {
				tyear = year - 1;
				tmonth = 12;
			} else {
				tyear = year;
				tmonth = month - 1;
			}
			tday = dayInmonth(tyear, tmonth);
		} else {
			tyear = year;
			tmonth = month;
			tday = day - 1;
		}
		String tmonthString = "";
		if (tmonth < 10)
			tmonthString = "0" + tmonth;
		else
			tmonthString = "" + tmonth;
		String tdayString = "";
		if (tday < 10)
			tdayString = "0" + tday;
		else
			tdayString = "" + tday;
		return tyear + "-" + tmonthString + "-" + tdayString;
	}

	/**
	 * 获取明日日期，参数格式yyyy-MM-dd
	 * @param today
	 * 当前日期，String型日期描述，格式：yyyy-MM-dd
	 * @return
	 * 明日日期，String型日期描述，格式：yyyy-MM-dd
	 */
	public static String getTomorrow(String today) {
		int tyear, tmonth, tday;
		StringTokenizer st = new StringTokenizer(today, "-");
		int year = Integer.parseInt(st.nextToken().trim());
		int month = Integer.parseInt(st.nextToken().trim());
		int day = Integer.parseInt(st.nextToken().trim());

		if (day == dayInmonth(year, month)) {
			if (month == 12) {
				tyear = year + 1;
				tmonth = 1;
			} else {
				tyear = year;
				tmonth = month + 1;
			}
			tday = 1;
		} else {
			tyear = year;
			tmonth = month;
			tday = day + 1;
		}
		String tmonthString = "";
		if (tmonth < 10)
			tmonthString = "0" + tmonth;
		else
			tmonthString = "" + tmonth;
		String tdayString = "";
		if (tday < 10)
			tdayString = "0" + tday;
		else
			tdayString = "" + tday;
		return tyear + "-" + tmonthString + "-" + tdayString;
	}

	/**
	 * 判断参数年月包含的天数
	 * @param Year
	 * int型年描述
	 * @param Month
	 * int型月描述
	 * @return
	 * int型天数
	 */
	public static int dayInmonth(int Year, int Month) {
		switch (Month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return (31);
		case 4:
		case 6:
		case 9:
		case 11:
			return (30);
		default:
			if (Year % 4 != 0) {
				return (28);
			} else if (Year % 100 != 0) {
				return (29);
			} else if (Year % 400 != 0) {
				return (28);
			} else {
				return (29);
			}
		}
	}

	/**
	 * 获取指定位数的随机字符串
	 * @param size
	 * int型字符串位数
	 * @return
	 * 参数位数的随机字符串
	 */
	public static String getRandomString(int size) {
		char[] c = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'q',
				'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
				'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n',
				'm', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A',
				'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V',
				'B', 'N', 'M' };
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(c[Math.abs(random.nextInt()) % c.length]);
		}
		return sb.toString();
	}

	/**
	 * 获取指定位数的随机数字字符串
	 * @param size
	 * int型字符串位数
	 * @return
	 * 参数位数的随机数字字符串
	 */
	public static String getRandomNumber(int size) {
		char[] c = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(c[Math.abs(random.nextInt()) % c.length]);
		}
		return sb.toString();
	}

	/**
	 * 字符流转换成字符串
	 * @param in
	 * 输入字符流
	 * @param charset
	 * 返回的字符集
	 * @return
	 * 按照参数字符集转换参数字符流产生的字符串
	 */
	public static String stream2String(InputStream in, String charset) {
		StringBuffer sb = new StringBuffer();
		try {
			Reader r = new InputStreamReader(in, charset);
			int length = 0;
			for (char[] c = new char[1024]; (length = r.read(c)) != -1;) {
				sb.append(c, 0, length);
			}
			r.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 获取参数startdate至参数enddate日期之间的天数
	 * @param startDay
	 * 起始日期，String型日期描述，格式：yyyy-MM-dd
	 * @param endDay
	 * 终止日期，String型日期描述，格式：yyyy-MM-dd
	 * @return
	 * long型天数
	 */
	public static long getDayCount(String startDay, String endDay) {
		long dayCount = 0;

		String day = startDay;
		while (day.equals(endDay) == false) {
			day = getTomorrow(day);
			dayCount++;
		}

		return dayCount;
	}

	/**
	 * 96点时段转换为时间
	 * @param sd
	 * int型时段描述
	 * @return
	 * String型时间描述，格式HH:mm
	 */
	public static String sd96tosj(int sd) {
		String[] sjarr = {
				"00:00",
				"00:15","00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15","02:30","02:45","03:00",
				"03:15","03:30","03:45","04:00","04:15","04:30","04:45","05:00","05:15","05:30","05:45","06:00",
				"06:15","06:30","06:45","07:00","07:15","07:30","07:45","08:00","08:15","08:30","08:45","09:00",
				"09:15","09:30","09:45","10:00","10:15","10:30","10:45","11:00","11:15","11:30","11:45","12:00",
				"12:15","12:30","12:45","13:00","13:15","13:30","13:45","14:00","14:15","14:30","14:45","15:00",
				"15:15","15:30","15:45","16:00","16:15","16:30","16:45","17:00","17:15","17:30","17:45","18:00",
				"18:15","18:30","18:45","19:00","19:15","19:30","19:45","20:00","20:15","20:30","20:45","21:00",
				"21:15","21:30","21:45","22:00","22:15","22:30","22:45","23:00","23:15","23:30","23:45","24:00"
		};
		return sjarr[sd];
	}

	/**
	 * 288点时段转换为时间
	 * @param sd
	 * int型时段描述
	 * @return
	 * String型时间描述，格式HH:mm
	 */
	public static String sd288tosj(int sd) {
		String[] sjarr = {
				"00:00", 
				"00:05", "00:10", "00:15", "00:20", "00:25", "00:30", "00:35", "00:40", "00:45", "00:50", "00:55", "01:00", 
				"01:05", "01:10", "01:15", "01:20", "01:25", "01:30", "01:35", "01:40", "01:45", "01:50", "01:55", "02:00", 
				"02:05", "02:10", "02:15", "02:20", "02:25", "02:30", "02:35", "02:40", "02:45", "02:50", "02:55", "03:00", 
				"03:05", "03:10", "03:15", "03:20", "03:25", "03:30", "03:35", "03:40", "03:45", "03:50", "03:55", "04:00", 
				"04:05", "04:10", "04:15", "04:20", "04:25", "04:30", "04:35", "04:40", "04:45", "04:50", "04:55", "05:00", 
				"05:05", "05:10", "05:15", "05:20", "05:25", "05:30", "05:35", "05:40", "05:45", "05:50", "05:55", "06:00", 
				"06:05", "06:10", "06:15", "06:20", "06:25", "06:30", "06:35", "06:40", "06:45", "06:50", "06:55", "07:00", 
				"07:05", "07:10", "07:15", "07:20", "07:25", "07:30", "07:35", "07:40", "07:45", "07:50", "07:55", "08:00", 
				"08:05", "08:10", "08:15", "08:20", "08:25", "08:30", "08:35", "08:40", "08:45", "08:50", "08:55", "09:00", 
				"09:05", "09:10", "09:15", "09:20", "09:25", "09:30", "09:35", "09:40", "09:45", "09:50", "09:55", "10:00", 
				"10:05", "10:10", "10:15", "10:20", "10:25", "10:30", "10:35", "10:40", "10:45", "10:50", "10:55", "11:00", 
				"11:05", "11:10", "11:15", "11:20", "11:25", "11:30", "11:35", "11:40", "11:45", "11:50", "11:55", "12:00", 
				"12:05", "12:10", "12:15", "12:20", "12:25", "12:30", "12:35", "12:40", "12:45", "12:50", "12:55", "13:00", 
				"13:05", "13:10", "13:15", "13:20", "13:25", "13:30", "13:35", "13:40", "13:45", "13:50", "13:55", "14:00", 
				"14:05", "14:10", "14:15", "14:20", "14:25", "14:30", "14:35", "14:40", "14:45", "14:50", "14:55", "15:00", 
				"15:05", "15:10", "15:15", "15:20", "15:25", "15:30", "15:35", "15:40", "15:45", "15:50", "15:55", "16:00", 
				"16:05", "16:10", "16:15", "16:20", "16:25", "16:30", "16:35", "16:40", "16:45", "16:50", "16:55", "17:00", 
				"17:05", "17:10", "17:15", "17:20", "17:25", "17:30", "17:35", "17:40", "17:45", "17:50", "17:55", "18:00", 
				"18:05", "18:10", "18:15", "18:20", "18:25", "18:30", "18:35", "18:40", "18:45", "18:50", "18:55", "19:00", 
				"19:05", "19:10", "19:15", "19:20", "19:25", "19:30", "19:35", "19:40", "19:45", "19:50", "19:55", "20:00", 
				"20:05", "20:10", "20:15", "20:20", "20:25", "20:30", "20:35", "20:40", "20:45", "20:50", "20:55", "21:00", 
				"21:05", "21:10", "21:15", "21:20", "21:25", "21:30", "21:35", "21:40", "21:45", "21:50", "21:55", "22:00", 
				"22:05", "22:10", "22:15", "22:20", "22:25", "22:30", "22:35", "22:40", "22:45", "22:50", "22:55", "23:00", 
				"23:05", "23:10", "23:15", "23:20", "23:25", "23:30", "23:35", "23:40", "23:45", "23:50", "23:55", "24:00"
		};
		return sjarr[sd];
	}

	/**
	 * 1440点时段转换为时间
	 * @param sd
	 * int型时段描述
	 * @return
	 * String型时间描述，格式HH:mm
	 */
	public static String sd1440tosj(int sd) {
		int h = ((sd - 1) * 1) / 60;
		int m = ((sd - 1) * 1) % 60;
		String sh = "";
		String sm = "";

		if (h < 10) {
			sh = "0" + h;
		} else {
			sh = "" + h;
		}
		if (m < 10) {
			sm = "0" + m;
		} else {
			sm = "" + m;
		}


		return sh + ":" + sm + ":00";
	}

	/**
	 * 288点时间转换为时段
	 * @param sj
	 * String型时间描述，格式HH:mm
	 * @return
	 * int型时段描述
	 */
	public static int sjtosd288(String sj) {
		int h = Integer.parseInt(sj.split(":")[0]);
		int m = Integer.parseInt(sj.split(":")[1]);

		if (h == 0 && m < 5) {
			return 1;
		} else if (h == 23 && m > 55) {
			return 288;
		} else {
			if ((h * 60 + m) % 5 > 0) {
				return (h * 60 + m) / 5 + 1;
			} else {
				return (h * 60 + m) / 5;
			}
		}
	}

	/**
	 * 96点时间转换为时段
	 * @param sj
	 * String型时间描述，格式HH:mm
	 * @return
	 * int型时段描述
	 */
	public static int sjtosd96(String sj) {
		int h = Integer.parseInt(sj.split(":")[0]);
		int m = Integer.parseInt(sj.split(":")[1]);

		if (h == 0 && m < 15) {
			return 1;
		} else if (h == 23 && m > 45) {
			return 96;
		} else {
			if ((h * 60 + m) % 15 > 0) {
				return (h * 60 + m) / 15 + 1;
			} else {
				return (h * 60 + m) / 15;
			}
		}
	}

	/**
	 * 字符串字符集转换
	 * @param str
	 * 输入字符串
	 * @param fromcharset
	 * 原始字符串字符集
	 * @param tocharset
	 * 结果字符串字符集
	 * @return
	 * 经字符集转换后的字符串
	 */
	public static String strCharsetChange(String str, String fromcharset, String tocharset) {
		String fromchar = fromcharset;
		String tochar = tocharset;
		String resstr = "";
		try {
			if (fromchar.indexOf("auto_system") != -1) {
				fromchar = "GBK";
			}
			if (tochar.indexOf("auto_system") != -1) {
				tochar = Charset.defaultCharset().toString();
			}
			resstr = new String(str.getBytes(fromchar), tochar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resstr;
	}

	/**
	 * 保留指定位数的小数
	 * @param v
	 * 原始数字
	 * @param scale
	 * 需要保留的位数
	 * @return
	 * 结果数字
	 */
	public static double round(double v, int scale) {
		try {
			scale = Math.abs(scale);
			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		catch (Exception ex) {
			return 0.0;
		}
	}


	public static Vector<Vector<Object>> roundSQLResult(Vector<Vector<Object>> sqlVec) {
		Vector<Vector<Object>> resVec = new Vector<Vector<Object>>();
		Vector<Object> tmpResVec = new Vector<Object>();
		Object tmpResObj = null;

		for (int i = 0; i < sqlVec.size(); i++) {
			Vector<Object> tmpVec = sqlVec.get(i);
			tmpResVec = new Vector<Object>();

			for (int j = 0; j < tmpVec.size(); j++) {
				Object tmpObj = tmpVec.get(j);



				if (tmpObj == null || tmpObj.equals(null) || tmpObj.equals("null") || tmpObj == "null") {
					tmpResObj = " ";
				} else {
					if (isNumber(tmpObj.toString()) == true) {
						String [] tmpStrArray = tmpObj.toString().split("\\.");

						if (tmpStrArray.length == 1) {
							tmpResObj = tmpStrArray[0];
						} else {
							String tmpStr = "";

							char [] tmpCharArray = tmpStrArray[1].toCharArray();
							int m = tmpCharArray.length;
							int n = tmpCharArray.length;
							for (int k = tmpCharArray.length - 1; k >= 0; k--) {
								String tmpChar = String.valueOf(tmpCharArray[k]);
								if (Integer.parseInt(tmpChar) != 0) {
									m = k;
									break;
								}
								n = k;
							}

							if (n == 0) {
								tmpStr = tmpStrArray[0];
							} else {
								tmpStr = tmpStrArray[0] + ".";

								for (int k = 0; k <= m; k++) {
									tmpStr += String.valueOf(tmpCharArray[k]);
								}
							}

							tmpResObj = tmpStr;
						}
					} else {
						tmpResObj = tmpObj.toString();
					}
				}

				tmpResVec.add(tmpResObj);
			}

			resVec.add(tmpResVec);
		}


		return resVec;
	}


	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("^-?[0-9]+(.[0-9]*)?$");
		Matcher match=pattern.matcher(str);
		if(match.matches()) {
			return true;
		} else {
			return false;
		}
	}

	//////阿拉伯数字转换成罗马数字
	public static String a2r(int aNumber){
		if(aNumber < 1 || aNumber > 3999){
			return "-1";
		}
		int[] aArray = {90,80,70,60,50,40,30,20,10,9,8,7,6,5,4,3,2,1};
		String[] rArray = {"九十","八十","七十","六十","五十","四十","三十","二十","十","九","八","七","六","五","四","三","二","一"};
		String rNumber = "";
		for(int i=0; i<aArray.length; i++){
			while(aNumber >= aArray[i]){
				rNumber += rArray[i];
				aNumber -= aArray[i];
			}
		}
		return rNumber;
	}


	public static long dayCompare (String startDay, String endDay) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(sdf.parse(startDay));
		int day1 = aCalendar.get(Calendar.DATE);
		aCalendar.setTime(sdf.parse(endDay));
		int day2 = aCalendar.get(Calendar.DATE);
		return day2 - day1;
	}

	
	public static String turnURL(String url) {
		if (url == null) {
			return null;
		}

		if (url.length() == 0) {
			return null;
		}

		return url
				.replace("%", "%25") //一定要先转%，后面都带%
				.replace("+", "%2B")
				.replace(" ", "%20")
				.replace("/", "%2F")
				.replace("?", "%3F")
				.replace("#", "%23")
				.replace("&", "%26")
				.replace("=", "%3D");
	}
	
}