package com.demo1.springmvc.bwyx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		querychartJzzt("22","33");

	}
	
	
	public static Object querychartJzzt(String rq, String yhmc) {
		
		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonArrayNodes = new JSONObject();
		
		jsonObject.put("id", "0");
		jsonObject.put("text", "首页");
		jsonObject.put("icon", "icon-cog");
		jsonObject.put("url", "homePage.jsp");
		
		jsonArrayNodes.put("id", "00");
		jsonArrayNodes.put("text", "首页");
		jsonArrayNodes.put("icon", "icon-glass");
		jsonArrayNodes.put("url", "homePage.jsp");
		

		
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonArrayNodes1 = new JSONObject();
		
		jsonObject1.put("id", "1");
		jsonObject1.put("text", "系统设置");
		jsonObject1.put("icon", "icon-cog");
		jsonObject1.put("url", "homePage.jsp");
		
		jsonArrayNodes1.put("id", "11");
		jsonArrayNodes1.put("text", "表单示例");
		jsonArrayNodes1.put("icon", "icon-glass");
		jsonArrayNodes1.put("url", "homePage.jsp");
		

		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject1);
		
		
		System.out.println(jsonArray);
		
		return jsonArray;
	}

}
