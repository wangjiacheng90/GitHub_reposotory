package com.demo1.springmvc.jdbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Bb4 {
	
//	季度报表1--table查询  -----7行固定
	@RequestMapping(value="/jdbb4_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject1 = new JSONObject();  //AGC
		JSONObject jsonObject2 = new JSONObject(); //调峰
		JSONObject jsonObject3 = new JSONObject(); //其中：有偿调峰
		JSONObject jsonObject4 = new JSONObject(); //启停调峰
		JSONObject jsonObject5 = new JSONObject(); //其他调峰
		JSONObject jsonObject6 = new JSONObject(); //备用
		JSONObject jsonObject7 = new JSONObject(); //其中：旋转备用
		JSONObject jsonObject8 = new JSONObject(); //冷备用
		JSONObject jsonObject9 = new JSONObject(); //其他备用
		JSONObject jsonObject10 = new JSONObject(); //调压
		JSONObject jsonObject11 = new JSONObject(); //其中：AVC
		JSONObject jsonObject12 = new JSONObject(); //其他调压
		JSONObject jsonObject13 = new JSONObject(); //黑启动
		JSONObject jsonObject14 = new JSONObject(); //合计
		
		
		jsonObject1.put("field1", "1");// 序号------固定
		jsonObject1.put("field2", "AGC");//项目名称------固定
		jsonObject1.put("field3", 51103.22);//补偿分摊费用
		jsonObject1.put("field4", 4);//减免费用
		jsonObject1.put("field5", 5);//新建机组差额资金
		jsonObject1.put("field6", 51103.22);//网外分摊
		jsonObject1.put("field7", " ");//网外收取
		jsonObject1.put("field8", 20424.07);//其它费用
		
		
		jsonObject2.put("field1", "2");// 序号------固定
		jsonObject2.put("field2", "调峰");//项目名称------固定
		
		jsonObject3.put("field1", "2");// 序号------固定
		jsonObject3.put("field2", "其中：有偿调峰");//项目名称------固定
		
		jsonObject4.put("field1", "2");// 序号------固定
		jsonObject4.put("field2", "启停调峰");//项目名称------固定
		
		jsonObject5.put("field1", "2");// 序号------固定
		jsonObject5.put("field2", "其他调峰");//项目名称------固定
		
		jsonObject6.put("field1", "3");// 序号------固定
		jsonObject6.put("field2", "备用");//项目名称------固定
		
		jsonObject7.put("field1", "3");// 序号------固定
		jsonObject7.put("field2", "其中：旋转备用");//项目名称------固定
		
		jsonObject8.put("field1", "3");// 序号------固定
		jsonObject8.put("field2", "冷备用");//项目名称------固定
		
		jsonObject9.put("field1", "3");// 序号------固定
		jsonObject9.put("field2", "其他备用");//项目名称------固定
		
		jsonObject10.put("field1", "4");// 序号------固定
		jsonObject10.put("field2", "调压");//项目名称------固定
		
		jsonObject11.put("field1", "4");// 序号------固定
		jsonObject11.put("field2", "其中：AVC");//项目名称
		
		jsonObject12.put("field1", "4");// 序号------固定
		jsonObject12.put("field2", "其他调压");//项目名称------固定
		
		jsonObject13.put("field1", "5");// 序号------固定
		jsonObject13.put("field2", "黑启动");//项目名称------固定
		
		jsonObject14.put("field1", " ");// 序号------固定
		jsonObject14.put("field2", "合计");//项目名称------固定

		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);
		jsonArray.add(jsonObject4);
		jsonArray.add(jsonObject5);
		jsonArray.add(jsonObject6);
		jsonArray.add(jsonObject7);
		jsonArray.add(jsonObject8);
		jsonArray.add(jsonObject9);
		jsonArray.add(jsonObject10);
		jsonArray.add(jsonObject11);
		jsonArray.add(jsonObject12);
		jsonArray.add(jsonObject13);
		jsonArray.add(jsonObject14);
	
		
		System.out.println(jsonArray);
		
		return jsonArray;
	}
	
//  季度报表1汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/jdbb4_hz", method=RequestMethod.POST)
	public @ResponseBody 
	Object queryBwyxjs_hz(String rq) {
		
		System.out.println("rq:"+rq);
		
		String SUCESSMESSAGE = rq+"季度报表4--汇总计算完成";
		
		return SUCESSMESSAGE;
	}

}
