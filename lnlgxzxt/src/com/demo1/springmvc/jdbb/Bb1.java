package com.demo1.springmvc.jdbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Bb1 {

//	季度报表1--table查询  -----7行固定
	@RequestMapping(value="/jdbb1_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject1 = new JSONObject();  //AGC
		JSONObject jsonObject2 = new JSONObject(); //调峰
		JSONObject jsonObject3 = new JSONObject(); //备用
		JSONObject jsonObject4 = new JSONObject(); //调压
		JSONObject jsonObject5 = new JSONObject(); //黑启动
		JSONObject jsonObject6 = new JSONObject(); //其他
		JSONObject jsonObject7 = new JSONObject(); //合计


		jsonObject1.put("field1", "AGC");// 项目名称------固定
		jsonObject1.put("field2", " ");//详细计量公式
		jsonObject1.put("field3", 0);//考核参数
		jsonObject1.put("field4", 0);//补偿标准--容量
		jsonObject1.put("field5", 0);//补偿标准--电量
		jsonObject1.put("field6", 0);//确定提供方的方式--择优
		jsonObject1.put("field7", 0);//确定提供方的方式--竞价

		jsonObject2.put("field1", "调峰");// 项目名称------固定
		jsonObject2.put("field2", " ");//详细计量公式
		jsonObject2.put("field3", 0);//考核参数
		jsonObject2.put("field4", 0);//补偿标准--容量
		jsonObject2.put("field5", 0);//补偿标准--电量
		jsonObject2.put("field6", 0);//确定提供方的方式--择优
		jsonObject2.put("field7", 0);//确定提供方的方式--竞价

		jsonObject3.put("field1", "备用");// 项目名称------固定
		jsonObject3.put("field2", " ");//详细计量公式
		jsonObject3.put("field3", 0);//考核参数
		jsonObject3.put("field4", 0);//补偿标准--容量
		jsonObject3.put("field5", 0);//补偿标准--电量
		jsonObject3.put("field6", 0);//确定提供方的方式--择优
		jsonObject3.put("field7", 0);//确定提供方的方式--竞价

		jsonObject4.put("field1", "调压");// 项目名称------固定
		jsonObject4.put("field2", " ");//详细计量公式
		jsonObject4.put("field3", 0);//考核参数
		jsonObject4.put("field4", 0);//补偿标准--容量
		jsonObject4.put("field5", 0);//补偿标准--电量
		jsonObject4.put("field6", 0);//确定提供方的方式--择优
		jsonObject4.put("field7", 0);//确定提供方的方式--竞价

		jsonObject5.put("field1", "黑启动");// 项目名称------固定
		jsonObject5.put("field2", " ");//详细计量公式
		jsonObject5.put("field3", 0);//考核参数
		jsonObject5.put("field4", 0);//补偿标准--容量
		jsonObject5.put("field5", 0);//补偿标准--电量
		jsonObject5.put("field6", 0);//确定提供方的方式--择优
		jsonObject5.put("field7", 0);//确定提供方的方式--竞价

		jsonObject6.put("field1", "其他");// 项目名称------固定
		jsonObject6.put("field2", " ");//详细计量公式
		jsonObject6.put("field3", 0);//考核参数
		jsonObject6.put("field4", 0);//补偿标准--容量
		jsonObject6.put("field5", 0);//补偿标准--电量
		jsonObject6.put("field6", 0);//确定提供方的方式--择优
		jsonObject6.put("field7", 0);//确定提供方的方式--竞价

		jsonObject7.put("field1", "合计");// 项目名称------固定
		jsonObject7.put("field2", " ");//详细计量公式
		jsonObject7.put("field3", 0);//考核参数
		jsonObject7.put("field4", 0);//补偿标准--容量
		jsonObject7.put("field5", 0);//补偿标准--电量
		jsonObject7.put("field6", 0);//确定提供方的方式--择优
		jsonObject7.put("field7", 0);//确定提供方的方式--竞价



		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);
		jsonArray.add(jsonObject4);
		jsonArray.add(jsonObject5);
		jsonArray.add(jsonObject6);
		jsonArray.add(jsonObject7);


		System.out.println(jsonArray);

		return jsonArray;
	}


//  季度报表1汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/jdbb1_hz", method=RequestMethod.POST)
	public @ResponseBody
	Object queryBwyxjs_hz(String rq) {

		System.out.println("rq:"+rq);

		String SUCESSMESSAGE = rq+"季度报表1--汇总计算完成";

		return SUCESSMESSAGE;
	}

}
