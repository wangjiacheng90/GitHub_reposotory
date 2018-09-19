package com.demo1.springmvc.jsgl;

import java.sql.SQLException;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.base.Utilities;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Lgxzjsd {

//	两个细则结算单table查询
	@RequestMapping(value="/lgxzjs_query", method=RequestMethod.POST)
	public @ResponseBody Object queryLgxzjs_query(String rq) {

		System.out.println("rq:"+rq);







		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select c.sname,b.dl,khfy,fhfy,b.jsfy,bcfy,ftfy,a.jsfy,a.jsfy+b.jsfy"
					+ " from jsddfzfw a,jsddyxkh b,(select sid,sname,px from dcbm union all select sid,sname,px from xnybm) c"
					+ " where a.rq=b.rq and a.sid=c.sid and a.sid=b.sid and a.rq='"+rq+"'"
					+ " order by px,c.sname";
			sqlVec = dbo.executeQuery(sql);


			double sumdl = 0.0;
			double sumkhfy = 0.0;
			double sumfhfy = 0.0;
			double sumyxkhjsfy = 0.0;
			double sumbcfy = 0.0;
			double sumftfy = 0.0;
			double sumfzfwjsfy = 0.0;
			double sumzjsfy = 0.0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object sname = sqlVec.get(i).get(0);
				double dl = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double khfy = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double fhfy = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double yxkhjsfy = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double bcfy = Double.parseDouble(sqlVec.get(i).get(5).toString());
				double ftfy = Double.parseDouble(sqlVec.get(i).get(6).toString());
				double fzfwjsfy = Double.parseDouble(sqlVec.get(i).get(7).toString());
				double zjsfy = Double.parseDouble(sqlVec.get(i).get(8).toString());

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("field1", i + 1);//序
				jsonObject.put("field2", sname);//单元
				jsonObject.put("field3", dl);//上网电量(MWh)
				jsonObject.put("field4", khfy);//运行考核(元)--考核
				jsonObject.put("field5", fhfy);//运行考核(元)--返还
				jsonObject.put("field6", yxkhjsfy);//运行考核(元)--结算
				jsonObject.put("field7", bcfy);//辅助服务（元）--补偿
				jsonObject.put("field8", ftfy);//辅助服务（元）--分摊
				jsonObject.put("field9", fzfwjsfy);//辅助服务（元）--结算
				jsonObject.put("field10", zjsfy); //结算合计（元）
				jsonArray.add(jsonObject);

				sumdl += dl;
				sumkhfy += khfy;
				sumfhfy += fhfy;
				sumyxkhjsfy += yxkhjsfy;
				sumbcfy += bcfy;
				sumftfy += ftfy;
				sumfzfwjsfy += fzfwjsfy;
				sumzjsfy += zjsfy;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("field1", "");//序
			jsonObject.put("field2", "合计");//单元
			jsonObject.put("field3", Utilities.round(sumdl, 2));//上网电量(MWh)
			jsonObject.put("field4", Utilities.round(sumkhfy, 2));//运行考核(元)--考核
			jsonObject.put("field5", Utilities.round(sumfhfy, 2));//运行考核(元)--分摊
			jsonObject.put("field6", Utilities.round(sumyxkhjsfy, 2));//运行考核(元)--结算
			jsonObject.put("field7", Utilities.round(sumbcfy, 2));//辅助服务（元）--补偿
			jsonObject.put("field8", Utilities.round(sumftfy, 2));//辅助服务（元）--分摊
			jsonObject.put("field9", Utilities.round(sumfzfwjsfy, 2));//辅助服务（元）--结算
			jsonObject.put("field10", Utilities.round(sumzjsfy, 2)); //结算合计（元）
			jsonArray.add(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(jsonArray);






//
//		JSONArray jsonArray = new JSONArray();
//
//		JSONObject jsonObject1 = new JSONObject();
//		JSONObject jsonObject2 = new JSONObject();
//		JSONObject jsonObject3 = new JSONObject();
//
//
//		jsonObject1.put("field1", 1);//序
//		jsonObject1.put("field2", "单元1");//单元
//		jsonObject1.put("field3", 3);//上网电量(MWh)
//		jsonObject1.put("field4", 4);//运行考核(元)--考核
//		jsonObject1.put("field5", 5);//运行考核(元)--分摊
//		jsonObject1.put("field6", 6);//运行考核(元)--结算
//		jsonObject1.put("field7", 7);//辅助服务（元）--补偿
//		jsonObject1.put("field8", 8);//辅助服务（元）--分摊
//		jsonObject1.put("field9", 9);//辅助服务（元）--结算
//		jsonObject1.put("field10", 10); //结算合计（元）
//
//		jsonObject2.put("field1", 1);//序
//		jsonObject2.put("field2","单元2");//单元
//		jsonObject2.put("field3", 3);//上网电量(MWh)
//		jsonObject2.put("field4", 4);//运行考核(元)--考核
//		jsonObject2.put("field5", 5);//运行考核(元)--分摊
//		jsonObject2.put("field6", 6);//运行考核(元)--结算
//		jsonObject2.put("field7", 7);//辅助服务（元）--补偿
//		jsonObject2.put("field8", 8);//辅助服务（元）--分摊
//		jsonObject2.put("field9", 9);//辅助服务（元）--结算
//		jsonObject2.put("field10", 10); //结算合计（元）
//
//		jsonObject3.put("field1", "");//序
//		jsonObject3.put("field2", "合计");//单元
//		jsonObject3.put("field3", 30);//上网电量(MWh)
//		jsonObject3.put("field4", 40);//运行考核(元)--考核
//		jsonObject3.put("field5", 50);//运行考核(元)--分摊
//		jsonObject3.put("field6", 60);//运行考核(元)--结算
//		jsonObject3.put("field7", 70);//辅助服务（元）--补偿
//		jsonObject3.put("field8", 80);//辅助服务（元）--分摊
//		jsonObject3.put("field9", 90);//辅助服务（元）--结算
//		jsonObject3.put("field10", 100); //结算合计（元）
//
//
//		jsonArray.add(jsonObject1);
//		jsonArray.add(jsonObject2);
//		jsonArray.add(jsonObject3);

		return jsonArray;
	}


//  两个细则结算单汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/lgxzjs_hz", method=RequestMethod.POST)
	public @ResponseBody
	Object queryBwyxjs_hz(String rq) {

		System.out.println("rq:"+rq);

		String SUCESSMESSAGE = rq+"两个细则结算--汇总计算完成";

		return SUCESSMESSAGE;
	}


//  两个细则结算单——计算——_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/lgxzjs_comput", method=RequestMethod.POST)
	public @ResponseBody
	Object queryBwyxjs_comput(String rq) {
		System.out.println("rq:"+rq);


		String res = com.lgxz.compute.ftjsjs.Main.run(rq);

		String SUCESSMESSAGE = rq+" "+res;

		return SUCESSMESSAGE;
	}

}
