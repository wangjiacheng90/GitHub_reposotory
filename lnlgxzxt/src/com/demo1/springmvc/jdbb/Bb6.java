package com.demo1.springmvc.jdbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Bb6 {
	
//	季度报表5--table查询
	@RequestMapping(value="/jdbb6_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject1 = new JSONObject();  
		JSONObject jsonObject2 = new JSONObject();  
		
		JSONObject jsonObject3 = new JSONObject();  
		
		
		jsonObject1.put("field1", "1");// 序号
		jsonObject1.put("field2", "大连湾厂");//电厂名称
		jsonObject1.put("field3", 3);//机组类型
		jsonObject1.put("field4", 4);//装机容量		
		jsonObject1.put("field5", 5);//净收入
		jsonObject1.put("field6", 6649.429285);//补偿总费用
		jsonObject1.put("field7", 7);//补偿分摊费用
		jsonObject1.put("field8", 8);//其他费用	
		jsonObject1.put("field9", 6649.429285);//总上网电量
		jsonObject1.put("field10", 10);//核定上网电价
		jsonObject1.put("field11", 11);//总电费
		jsonObject1.put("field12", 12);//净收入占上网电费比例	
		jsonObject1.put("field13", 6649.429285);//参与直接交易电量
		jsonObject1.put("field14", 14);//直接交易买方平均负荷率

		
		
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
	@RequestMapping(value="/jdbb6_hz", method=RequestMethod.POST)
	public @ResponseBody 
	Object queryBwyxjs_hz(String rq) {
		
		System.out.println("rq:"+rq);
		
		String SUCESSMESSAGE = rq+"季度报表6--汇总计算完成";
		
		return SUCESSMESSAGE;
	}

}
