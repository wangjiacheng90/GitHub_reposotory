package com.demo1.springmvc.jdbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Bb5 {

	
//	季度报表5--table查询
	@RequestMapping(value="/jdbb5_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject1 = new JSONObject();  
		JSONObject jsonObject2 = new JSONObject();  
		
		JSONObject jsonObject3 = new JSONObject();  
		
		
		jsonObject1.put("field1", "1");// 序号
		jsonObject1.put("field2", "大连湾厂");//电厂
		jsonObject1.put("field3", 3);//机组类型
		jsonObject1.put("field4", 4);//装机容量		
		jsonObject1.put("field5", 5);//AGC补偿--季度首月
		jsonObject1.put("field6", 6);//AGC补偿--季度次月
		jsonObject1.put("field7", 7);//AGC补偿--季度末月
		jsonObject1.put("field8", 8);//AGC补偿--季度累计		
		jsonObject1.put("field9", 9);//调峰补偿(调峰+启停+修正)--季度首月
		jsonObject1.put("field10", 10);//调峰补偿(调峰+启停+修正)--季度次月
		jsonObject1.put("field11", 11);//调峰补偿(调峰+启停+修正)--季度末月
		jsonObject1.put("field12", 12);//调峰补偿(调峰+启停+修正)--季度累计	
		jsonObject1.put("field13", 13);//备用补偿--季度首月
		jsonObject1.put("field14", 14);//备用补偿--季度次月
		jsonObject1.put("field15", 15);//备用补偿--季度末月
		jsonObject1.put("field16", 16);//备用补偿--季度累计
		jsonObject1.put("field17", 17);//无功补偿--季度首月
		jsonObject1.put("field18", 18);//无功补偿--季度次月
		jsonObject1.put("field19", 19);//无功补偿--季度末月
		jsonObject1.put("field20", 20);//无功补偿--季度累计		
		jsonObject1.put("field21", 21);//黑启动补偿--季度首月
		jsonObject1.put("field22", 22);//黑启动补偿--季度次月
		jsonObject1.put("field23", 23);//黑启动补偿--季度末月
		jsonObject1.put("field24", 24);//黑启动补偿--季度累计
		jsonObject1.put("field25", 25);//合计--季度首月
		jsonObject1.put("field26", 26);//合计--季度次月
		jsonObject1.put("field27", 27);//合计--季度末月
		jsonObject1.put("field28", 28);//合计--季度累计
		
		
		jsonObject2.put("field1", "2");// 序号
		jsonObject2.put("field2", "丹东厂");//电厂
		jsonObject2.put("field3", 3);//机组类型
		
		jsonObject3.put("field1", " ");// 合计 ---前4项为空
		jsonObject3.put("field2", " ");// 合计 ---前4项为空
		jsonObject3.put("field3", " ");// 合计 ---前4项为空
		jsonObject3.put("field4", " ");// 合计 ---前4项为空
		jsonObject3.put("field5", 500);// 合计 ---前4项为空
		jsonObject3.put("field6", 1000 );// 合计 ---前4项为空
		
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);

		
		System.out.println(jsonArray);
		
		return jsonArray;
	}
	
//  季度报表1汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/jdbb5_hz", method=RequestMethod.POST)
	public @ResponseBody 
	Object queryBwyxjs_hz(String rq) {
		
		System.out.println("rq:"+rq);
		
		String SUCESSMESSAGE = rq+"季度报表5--汇总计算完成";
		
		return SUCESSMESSAGE;
	}
	
	
	
}
