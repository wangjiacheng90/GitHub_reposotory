package com.demo1.springmvc.fzfw;

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
public class Tfscrjg {
//	调峰市场日结果---(火电)table查询

	/*   辅助服务文件  -----<huodianchang_count>
    @num	pname	recmoney	linerecmoney	changerecmoney	reccount	appmoney	changeappmoney	lineappmoney	waterapportion	appcount	daycount
    //序号	电厂名称	有偿调峰补偿金额	跨省支援补偿金额	补偿修正金额	补偿小计	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计	日盈亏合计
*/
	@RequestMapping(value="/tfscrjg_hd_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscrjg_hd_table(String ksrq,String zzrq) {


		System.out.println("ksrq:"+ksrq);
		System.out.println("zzrq:"+zzrq);



		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select pname,"
					+ "sum(recmoney),"
					+ "sum(linerecmoney),"
					+ "sum(changerecmoney),"
					+ "sum(reccount),"
					+ "sum(appmoney),"
					+ "sum(changeappmoney),"
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(appcount),"
					+ "sum(daycount)"
					+ " from dbtfdb.dbtfdb.t_dayhuodccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);



			double sumrecmoney = 0;
			double sumlinerecmoney = 0;
			double sumchangerecmoney = 0;
			double sumreccount = 0;
			double sumappmoney = 0;
			double sumchangeappmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumappcount = 0;
			double sumdaycount = 0;



			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double recmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double linerecmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double changerecmoney = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double reccount = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double appmoney = Double.parseDouble(sqlVec.get(i).get(5).toString());
				double changeappmoney = Double.parseDouble(sqlVec.get(i).get(6).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(7).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(8).toString());
				double appcount = Double.parseDouble(sqlVec.get(i).get(9).toString());
				double daycount = Double.parseDouble(sqlVec.get(i).get(10).toString());


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", recmoney);//有偿调峰补偿金额
				jsonObject.put("field2", linerecmoney);//跨省支援补偿金额
				jsonObject.put("field3", changerecmoney);//补偿修正金额
				jsonObject.put("field4", reccount);//补偿小计
				jsonObject.put("field5", appmoney);//有偿调峰分摊金额
				jsonObject.put("field6", changeappmoney);//分摊修正金额
				jsonObject.put("field7", lineappmoney);//跨省分摊金额
				jsonObject.put("field8", waterapportion);//抽蓄分摊金额
				jsonObject.put("field9", appcount);//分摊小计
				jsonObject.put("field10", daycount);//日盈亏合计
				jsonArray.add(jsonObject);

				sumrecmoney += recmoney;
				sumlinerecmoney += linerecmoney;
				sumchangerecmoney += changerecmoney;
				sumreccount += reccount;
				sumappmoney += appmoney;
				sumchangeappmoney += changeappmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumappcount += appcount;
				sumdaycount += daycount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumrecmoney, 2));//有偿调峰补偿金额
			jsonObject.put("field2", Utilities.round(sumlinerecmoney, 2));//跨省支援补偿金额
			jsonObject.put("field3", Utilities.round(sumchangerecmoney, 2));//补偿修正金额
			jsonObject.put("field4", Utilities.round(sumreccount, 2));//补偿小计
			jsonObject.put("field5", Utilities.round(sumappmoney, 2));//有偿调峰分摊金额
			jsonObject.put("field6", Utilities.round(sumchangeappmoney, 2));//分摊修正金额
			jsonObject.put("field7", Utilities.round(sumlineappmoney, 2));//跨省分摊金额
			jsonObject.put("field8", Utilities.round(sumwaterapportion, 2));//抽蓄分摊金额
			jsonObject.put("field9", Utilities.round(sumappcount, 2));//分摊小计
			jsonObject.put("field10", Utilities.round(sumdaycount, 2));//日盈亏合计
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

		return jsonArray;
	}


//	调峰市场日结果---(风电)table查询
	/*<fengdianchang_count>
	@num	pname	appmoney	changeappmoney	lineappmoney	waterapportion	appcount
	//序号	电厂名称	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计
	*/

	@RequestMapping(value="/tfscrjg_fd_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscrjg_fd_table(String ksrq,String zzrq ) {

		System.out.println("ksrq:"+ksrq);
		System.out.println("zzrq:"+zzrq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select pname,"
					+ "sum(appmoney),"
					+ "sum(changeappmoney),"
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(appcount)"
					+ " from dbtfdb.dbtfdb.t_dayfdccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);


			double sumappmoney = 0;
			double sumchangerecmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumappcount = 0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double appmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double changerecmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double appcount = Double.parseDouble(sqlVec.get(i).get(5).toString());

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", appmoney);//有偿调峰分摊金额
				jsonObject.put("field2", changerecmoney);//分摊修正金额
				jsonObject.put("field3", lineappmoney);//跨省分摊金额
				jsonObject.put("field4", waterapportion);//抽蓄分摊金额
				jsonObject.put("field5", appcount);//分摊小计
				jsonArray.add(jsonObject);

				sumappmoney += appmoney;
				sumchangerecmoney += changerecmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumappcount += appcount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumappmoney, 2));//有偿调峰分摊金额
			jsonObject.put("field2", Utilities.round(sumchangerecmoney, 2));//补偿修正金额
			jsonObject.put("field3", Utilities.round(sumlineappmoney, 2));//跨省分摊金额
			jsonObject.put("field4", Utilities.round(sumwaterapportion, 2));//抽蓄分摊金额
			jsonObject.put("field5", Utilities.round(sumappcount, 2));//分摊小计
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

		return jsonArray;
	}

//	调峰市场日结果---(核电)table查询
	  /*  <hedianchang_count>
	   *  @num	pname	appmoney	changeappmoney	lineappmoney	waterapportion	appcount
    //序号	电厂名称	有偿调峰分摊金额	分摊修正金额	跨省分摊金额	抽蓄分摊金额	分摊小计
*/

	@RequestMapping(value="/tfscrjg_hed_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscrjg_hed_table(String ksrq,String zzrq) {

		System.out.println("ksrq:"+ksrq);
		System.out.println("zzrq:"+zzrq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select pname,"
					+ "sum(appmoney),"
					+ "sum(changeappmoney),"
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(appcount)"
					+ " from dbtfdb.dbtfdb.t_dayhedccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);


			double sumappmoney = 0;
			double sumchangerecmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumappcount = 0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double appmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double changerecmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double appcount = Double.parseDouble(sqlVec.get(i).get(5).toString());

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", appmoney);//有偿调峰分摊金额
				jsonObject.put("field2", changerecmoney);//分摊修正金额
				jsonObject.put("field3", lineappmoney);//跨省分摊金额
				jsonObject.put("field4", waterapportion);//抽蓄分摊金额
				jsonObject.put("field5", appcount);//分摊小计
				jsonArray.add(jsonObject);

				sumappmoney += appmoney;
				sumchangerecmoney += changerecmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumappcount += appcount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumappmoney, 2));//有偿调峰分摊金额
			jsonObject.put("field2", Utilities.round(sumchangerecmoney, 2));//补偿修正金额
			jsonObject.put("field3", Utilities.round(sumlineappmoney, 2));//跨省分摊金额
			jsonObject.put("field4", Utilities.round(sumwaterapportion, 2));//抽蓄分摊金额
			jsonObject.put("field5", Utilities.round(sumappcount, 2));//分摊小计
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


		return jsonArray;
	}

}
