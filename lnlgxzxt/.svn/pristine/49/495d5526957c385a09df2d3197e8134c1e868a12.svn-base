package com.demo1.springmvc.jdbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Bb3 {
	
//	季度报表1--table查询  -----7行固定
	@RequestMapping(value="/jdbb3_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject1 = new JSONObject();  //AGC
		JSONObject jsonObject2 = new JSONObject(); //调峰
		JSONObject jsonObject3 = new JSONObject(); //备用
		JSONObject jsonObject4 = new JSONObject(); //调压
		JSONObject jsonObject5 = new JSONObject(); //黑启动
		JSONObject jsonObject6 = new JSONObject(); //其他
	


		jsonObject1.put("field1", "调峰");// 项目名称------固定
		jsonObject1.put("field2", 71527.29);//总补偿费用
		jsonObject1.put("field3", "29个火电厂，<br>1个核电厂，<br>75个风电场");//参与范围---电厂
		jsonObject1.put("field4", " ");//参与范围--用户
		jsonObject1.put("field5", "火电厂实时<br>深度调峰费用=<br>∑_(i=1)^2▒〖<br>(第i档有偿调峰电量<br>×第i档实际出清电价)〗");//计量公式
		jsonObject1.put("field6", "第一档，0-400元/千千瓦时；第二档，400-1000元/千千瓦时");//限价情况
		jsonObject1.put("field7", 610);//实际成交均价

		jsonObject2.put("field1", " ");// 项目名称------固定
		
		jsonObject3.put("field1", " ");// 项目名称------固定
		
		jsonObject4.put("field1", " ");// 项目名称------固定
		
		jsonObject5.put("field1", " ");// 项目名称------固定
		
		jsonObject6.put("field1", " ");// 项目名称------固定
		



		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);
		jsonArray.add(jsonObject4);
		jsonArray.add(jsonObject5);
		jsonArray.add(jsonObject6);

	
		
		System.out.println(jsonArray);
		
		return jsonArray;
	}
	
	
//  季度报表1汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/jdbb3_hz", method=RequestMethod.POST)
	public @ResponseBody 
	Object queryBwyxjs_hz(String rq) {
		
		System.out.println("rq:"+rq);
		
		String SUCESSMESSAGE = rq+"季度报表3--汇总计算完成";
		
		return SUCESSMESSAGE;
	}

}
