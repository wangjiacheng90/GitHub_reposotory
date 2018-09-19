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
public class Tfscyjg {
//	调峰市场月结果---(火电)table查询

	/*   <huodianchang_count>
@num	pname	recmoney	linerecmoney	stoprecmoney	changerecmoney	reccount	appmoney	lineappmoney	waterapportion	stopappmoney	changeappmoney	appcount	phmonthmoney	monthcount
//序号	电厂名称	1有偿调峰补偿金额	 2跨省支援金额	3启停补偿金额	4补偿修正金额	5补偿小计	6有偿调峰分摊金额
               7跨省分摊金额	8抽蓄分摊金额	9启停分摊金额	10分摊修正金额	11分摊小计	 12月滚动平衡	13月盈亏总计
               */
	@RequestMapping(value="/tfscyjg_hd_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscyjg_hd_table(String ksrq,String zzrq) {


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
					+ "sum(stoprecmoney),"
					+ "sum(changerecmoney),"
					+ "sum(reccount),"
					+ "sum(appmoney),"
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(stopappmoney),"
					+ "sum(changeappmoney),"
					+ "sum(appcount),"
					+ "sum(phmonthmoney),"
					+ "sum(monthcount)"
					+ " from dbtfdb.dbtfdb.t_monthhuodccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);


			double sumrecmoney = 0;
			double sumlinerecmoney = 0;
			double sumstoprecmoney = 0;
			double sumchangerecmoney = 0;
			double sumreccount = 0;
			double sumappmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumstopappmoney = 0;
			double sumchangeappmoney = 0;
			double sumappcount = 0;
			double sumphmonthmoney = 0;
			double summonthcount = 0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double recmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double linerecmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double stoprecmoney = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double changerecmoney = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double reccount = Double.parseDouble(sqlVec.get(i).get(5).toString());
				double appmoney = Double.parseDouble(sqlVec.get(i).get(6).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(7).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(8).toString());
				double stopappmoney = Double.parseDouble(sqlVec.get(i).get(9).toString());
				double changeappmoney = Double.parseDouble(sqlVec.get(i).get(10).toString());
				double appcount = Double.parseDouble(sqlVec.get(i).get(11).toString());
				double phmonthmoney = Double.parseDouble(sqlVec.get(i).get(12).toString());
				double monthcount = Double.parseDouble(sqlVec.get(i).get(13).toString());


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", recmoney);//1有偿调峰补偿金额
				jsonObject.put("field2", linerecmoney);//2跨省支援金额
				jsonObject.put("field3", stoprecmoney);//3启停补偿金额
				jsonObject.put("field4", changerecmoney);//4补偿修正金额
				jsonObject.put("field5", reccount);//5补偿小计
				jsonObject.put("field6", appmoney);//6有偿调峰分摊金额
				jsonObject.put("field7", lineappmoney);//7跨省分摊金额
				jsonObject.put("field8", waterapportion);//8抽蓄分摊金额
				jsonObject.put("field9", stopappmoney);//9启停分摊金额
				jsonObject.put("field10", changeappmoney);//10分摊修正金额
				jsonObject.put("field11", appcount);//11分摊小计
				jsonObject.put("field12", phmonthmoney);//12月滚动平衡
				jsonObject.put("field13", monthcount);//13月盈亏总计
				jsonArray.add(jsonObject);

				sumrecmoney += recmoney;
				sumlinerecmoney += linerecmoney;
				sumstoprecmoney += stoprecmoney;
				sumchangerecmoney += changerecmoney;
				sumreccount += reccount;
				sumappmoney += appmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumstopappmoney += stopappmoney;
				sumchangeappmoney += changeappmoney;
				sumappcount += appcount;
				sumphmonthmoney += phmonthmoney;
				summonthcount += monthcount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumrecmoney, 2));//1有偿调峰补偿金额
			jsonObject.put("field2", Utilities.round(sumlinerecmoney, 2));//2跨省支援金额
			jsonObject.put("field3", Utilities.round(sumstoprecmoney, 2));//3启停补偿金额
			jsonObject.put("field4", Utilities.round(sumchangerecmoney, 2));//4补偿修正金额
			jsonObject.put("field5", Utilities.round(sumreccount, 2));//5补偿小计
			jsonObject.put("field6", Utilities.round(sumappmoney, 2));//6有偿调峰分摊金额
			jsonObject.put("field7", Utilities.round(sumlineappmoney, 2));//7跨省分摊金额
			jsonObject.put("field8", Utilities.round(sumwaterapportion, 2));//8抽蓄分摊金额
			jsonObject.put("field9", Utilities.round(sumstopappmoney, 2));//9启停分摊金额
			jsonObject.put("field10", Utilities.round(sumchangeappmoney, 2));//10分摊修正金额
			jsonObject.put("field11", Utilities.round(sumappcount, 2));//11分摊小计
			jsonObject.put("field12", Utilities.round(sumphmonthmoney, 2));//12月滚动平衡
			jsonObject.put("field13", Utilities.round(summonthcount, 2));//13月盈亏总计
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


//	调峰市场月结果---(风电)table查询
	/*<fengdianchang_count>
@num	pname	appmoney	lineappmoney	waterapportion	stopappmoney	changeappmoney	phmonthmoney	monthcount
//序号	电厂名称	1有偿调峰分摊金额		2跨省分摊金额	3抽蓄分摊金额	4启停分摊金额	5分摊修正金额	6月滚动平衡		7月盈亏总计

	*/

	@RequestMapping(value="/tfscyjg_fd_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscyjg_fd_table(String ksrq,String zzrq ) {

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
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(stopappmoney),"
					+ "sum(changeappmoney),"
					+ "sum(phmonthmoney),"
					+ "sum(monthcount)"
					+ " from dbtfdb.dbtfdb.t_monthfdccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);


			double sumappmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumstopappmoney = 0;
			double sumchangeappmoney = 0;
			double sumphmonthmoney = 0;
			double summonthcount = 0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double appmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double stopappmoney = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double changeappmoney = Double.parseDouble(sqlVec.get(i).get(5).toString());
				double phmonthmoney = Double.parseDouble(sqlVec.get(i).get(6).toString());
				double monthcount = Double.parseDouble(sqlVec.get(i).get(7).toString());


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", appmoney);//1有偿调峰分摊金额
				jsonObject.put("field2", lineappmoney);//2跨省分摊金额
				jsonObject.put("field3", waterapportion);//3抽蓄分摊金额
				jsonObject.put("field4", stopappmoney);//4启停分摊金额
				jsonObject.put("field5", changeappmoney);//5分摊修正金额
				jsonObject.put("field6", phmonthmoney);//6月滚动平衡
				jsonObject.put("field7", monthcount);//7月盈亏总计
				jsonArray.add(jsonObject);

				sumappmoney += appmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumstopappmoney += stopappmoney;
				sumchangeappmoney += changeappmoney;
				sumphmonthmoney += phmonthmoney;
				summonthcount += monthcount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumappmoney, 2));//1有偿调峰分摊金额
			jsonObject.put("field2", Utilities.round(sumlineappmoney, 2));//2跨省分摊金额
			jsonObject.put("field3", Utilities.round(sumwaterapportion, 2));//3抽蓄分摊金额
			jsonObject.put("field4", Utilities.round(sumstopappmoney, 2));//4启停分摊金额
			jsonObject.put("field5", Utilities.round(sumchangeappmoney, 2));//5分摊修正金额
			jsonObject.put("field6", Utilities.round(sumphmonthmoney, 2));//6月滚动平衡
			jsonObject.put("field7", Utilities.round(summonthcount, 2));//7月盈亏总计
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

//	调峰市场月结果---(核电)table查询
	  /*  <hedianchang_count>
@num	pname	appmoney	lineappmoney	waterapportion	stopappmoney	changeappmoney	phmonthmoney	monthcount
//序号	电厂名称	1有偿调峰分摊金额		2跨省分摊金额	3抽蓄分摊金额	4启停分摊金额	5分摊修正金额	6月滚动平衡		7月盈亏总计
*/

	@RequestMapping(value="/tfscyjg_hed_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscyjg_hed_table(String ksrq,String zzrq) {

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
					+ "sum(lineappmoney),"
					+ "sum(waterapportion),"
					+ "sum(stopappmoney),"
					+ "sum(changeappmoney),"
					+ "sum(phmonthmoney),"
					+ "sum(monthcount)"
					+ " from dbtfdb.dbtfdb.t_monthhedccount"
					+ " where stime>='"+ksrq+"' and stime<='"+zzrq+"'"
					+ " group by pname";
			sqlVec = dbo.executeQuery(sql);


			double sumappmoney = 0;
			double sumlineappmoney = 0;
			double sumwaterapportion = 0;
			double sumstopappmoney = 0;
			double sumchangeappmoney = 0;
			double sumphmonthmoney = 0;
			double summonthcount = 0;


			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				double appmoney = Double.parseDouble(sqlVec.get(i).get(1).toString());
				double lineappmoney = Double.parseDouble(sqlVec.get(i).get(2).toString());
				double waterapportion = Double.parseDouble(sqlVec.get(i).get(3).toString());
				double stopappmoney = Double.parseDouble(sqlVec.get(i).get(4).toString());
				double changeappmoney = Double.parseDouble(sqlVec.get(i).get(5).toString());
				double phmonthmoney = Double.parseDouble(sqlVec.get(i).get(6).toString());
				double monthcount = Double.parseDouble(sqlVec.get(i).get(7).toString());


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc); //电厂名称
				jsonObject.put("field1", appmoney);//1有偿调峰分摊金额
				jsonObject.put("field2", lineappmoney);//2跨省分摊金额
				jsonObject.put("field3", waterapportion);//3抽蓄分摊金额
				jsonObject.put("field4", stopappmoney);//4启停分摊金额
				jsonObject.put("field5", changeappmoney);//5分摊修正金额
				jsonObject.put("field6", phmonthmoney);//6月滚动平衡
				jsonObject.put("field7", monthcount);//7月盈亏总计
				jsonArray.add(jsonObject);

				sumappmoney += appmoney;
				sumlineappmoney += lineappmoney;
				sumwaterapportion += waterapportion;
				sumstopappmoney += stopappmoney;
				sumchangeappmoney += changeappmoney;
				sumphmonthmoney += phmonthmoney;
				summonthcount += monthcount;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dcmc", "合计"); //电厂名称
			jsonObject.put("field1", Utilities.round(sumappmoney, 2));//1有偿调峰分摊金额
			jsonObject.put("field2", Utilities.round(sumlineappmoney, 2));//2跨省分摊金额
			jsonObject.put("field3", Utilities.round(sumwaterapportion, 2));//3抽蓄分摊金额
			jsonObject.put("field4", Utilities.round(sumstopappmoney, 2));//4启停分摊金额
			jsonObject.put("field5", Utilities.round(sumchangeappmoney, 2));//5分摊修正金额
			jsonObject.put("field6", Utilities.round(sumphmonthmoney, 2));//6月滚动平衡
			jsonObject.put("field7", Utilities.round(summonthcount, 2));//7月盈亏总计
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
