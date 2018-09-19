package com.demo1.springmvc.hztj;

import java.sql.SQLException;
import java.text.DecimalFormat;
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
public class Fzfwjs {

//	并网运行结算的table查询
	@RequestMapping(value="/fzfwjs_table_query", method=RequestMethod.POST)
	public @ResponseBody Object queryFzfwjs_table_query(String rq) {

		System.out.println("rq:"+rq);


////	String putDwtable(String dcmc,String zy,double data) 电厂名称、专业、数值 double型




		DecimalFormat df = new DecimalFormat("#.##");

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");



			double sumagc = 0.0;
			double sumxzby = 0.0;

			sql = "select px,b.sname,agc,xzby from yhzfzfw a,(select sname,px from dcbm union all select sname,px from xnybm) b"
					+ " where rq='"+rq+"' and a.sname=b.sname order by px,b.sname";
			Vector<Vector<Object>> dataVec = dbo.executeQuery(sql);

			for (int i = 0; i < dataVec.size(); i++) {
				Vector<Object> tmpVec = dataVec.get(i);
				String px = tmpVec.get(0).toString();
				String sname = tmpVec.get(1).toString();
				double agc = Double.parseDouble(tmpVec.get(2).toString());
				double xzby = Double.parseDouble(tmpVec.get(3).toString());
				double sumsz = agc + xzby;

				JSONObject jsonObject = new JSONObject();


//				-序号
				jsonObject.put("xh", i + 1);
				jsonObject.put("dcmc", sname);
				if (agc == 0) {
					jsonObject.put("AGCfy", df.format(agc));
				} else {
					jsonObject.put("AGCfy", putDwtable(sname,"AGC费用",df.format(agc)));
				}

				jsonObject.put("qttffy", 0);
				jsonObject.put("hqdfy", 0);
				jsonObject.put("wgbcfy", 0);

				if (xzby == 0) {
					jsonObject.put("xzbyfy",df.format(xzby));
				} else {
					jsonObject.put("xzbyfy",putDwtable(sname,"xzbyfy",df.format(xzby)));
				}
				jsonObject.put("hj", df.format(sumsz));
				jsonArray.add(jsonObject);

				sumagc += agc;
				sumxzby += xzby;
			}



			double allsumsz = sumagc + sumxzby;

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("xh", "");
			jsonObject.put("dcmc", "合计");
			jsonObject.put("AGCfy", df.format(sumagc));
			jsonObject.put("qttffy", 0);
			jsonObject.put("hqdfy", 0);
			jsonObject.put("wgbcfy", 0);
			jsonObject.put("xzbyfy",df.format(sumxzby));
			jsonObject.put("hj",df.format(allsumsz));
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












//		JSONArray jsonArray = new JSONArray();
//
//		JSONObject jsonObject = new JSONObject();
//		JSONObject jsonObject2 = new JSONObject();
//
//		jsonObject.put("dcmc", "华电瓦房店田屯风电场");
//
//
////		String putDwtable(String dcmc,String zy,double data) 电厂名称、专业、数值 double型
//		jsonObject.put("AGCfy", putDwtable("华电瓦房店田屯风电场","AGC费用",1.0));
//		jsonObject.put("xzbyfy",putDwtable("华电瓦房店田屯风电场","xzbyfy",2.2));
//
//		jsonObject.put("hj", 180000);
//
//
//
//
//		jsonObject2.put("dcmc", "彰北风电场");
//		jsonObject2.put("AGCfy", 39);
//		jsonObject2.put("xzbyfy", 45);
//		jsonObject2.put("hj", 2000);
//
//
//
//
//
//		jsonArray.add(jsonObject);
//		jsonArray.add(jsonObject2);


		System.out.println(jsonArray);

		return jsonArray;
	}


//	并网运行结算详细——弹出的table查询
	@RequestMapping(value="/fzfwjs_dwtable_query", method=RequestMethod.POST)
	public @ResponseBody Object queryFzfwjs_dwtable_query(String rq,String dcmc,String zy) {

	System.out.println("执行了弹出框===弹出=============");

		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+dcmc);
		System.out.println("zy:"+zy);






		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			if (zy.equals("AGC费用")) {
				sql = "select rq,'AGC补偿费用',sname,sum(bcfy) from agcbcfy where sname in (select sname from jzbm where ssdcmc='"+dcmc+"') and rq like '"+rq+"%' group by rq,sname order by sname,rq";
			} else if (zy.equals("xzbyfy")) {
				sql = "select rq,'旋转备用补偿费用',sname,sum(bcfy) from xzbybcfy where sname in (select sname from jzbm where ssdcmc='"+dcmc+"') and rq like '"+rq+"%' group by rq,sname order by sname,rq";
			}

			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object date = sqlVec.get(i).get(0);
				Object type = sqlVec.get(i).get(1);
				Object name = sqlVec.get(i).get(2);
				Object fz = sqlVec.get(i).get(3);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("rq", date);
				jsonObject.put("zy", type);
				jsonObject.put("dcmc", name);
				jsonObject.put("fy", fz);
				jsonArray.add(jsonObject);
			}
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



//  并网运行汇总_执行（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/fzfwjs_hz", method=RequestMethod.POST)
	public @ResponseBody
	Object queryFzfwjs_hz(String rq) {

		System.out.println("rq:"+rq);

		String SUCESSMESSAGE = "";

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "delete from yhzfzfw where rq='"+rq+"'";
			dbo.executeUpdate(sql);
			dbo.commit();

			sql = "insert into yhzfzfw (rq,sid,sname,agc,xzby)"
					+ " select '"+rq+"',sid,sname,0,0 from dcbm where tcrq<='"+rq+"-"+Utilities.dayInmonth(Integer.parseInt(rq.split("-")[0]), Integer.parseInt(rq.split("-")[1]))+"'"
					+ " union all"
					+ " select '"+rq+"',sid,sname,0,0 from xnybm where tcrq<='"+rq+"-"+Utilities.dayInmonth(Integer.parseInt(rq.split("-")[0]), Integer.parseInt(rq.split("-")[1]))+"'";
			dbo.executeUpdate(sql);
			dbo.commit();



			sql = "select ssdcid,sum(bcfy) from agcbcfy a,jzbm b where rq like '"+rq+"%' and a.sid=b.sid group by ssdcid";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				Object fy = sqlVec.get(i).get(1);

				sql = "update yhzfzfw set agc=" + fy + " where rq='"+rq+"' and sid='"+sid+"'";
				dbo.executeUpdate(sql);
			}
			dbo.commit();



			sql = "select ssdcid,sum(bcfy) from xzbybcfy a,jzbm b where rq like '"+rq+"%' and a.sid=b.sid group by ssdcid";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				Object fy = sqlVec.get(i).get(1);

				sql = "update yhzfzfw set xzby=" + fy + " where rq='"+rq+"' and sid='"+sid+"'";
				dbo.executeUpdate(sql);
			}
			dbo.commit();


			SUCESSMESSAGE = rq+"汇总完成";
		} catch (Exception e) {
			SUCESSMESSAGE = rq+"汇总错误";
			e.printStackTrace();
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



		return SUCESSMESSAGE;
	}






	public static String putDwtable(String dcmc,String zy,Object data){
		String tabledata = "";

		tabledata = "<a id='drevi2'  onclick ='transToDwindow(\""
				+ dcmc
				+ "\",\""
				+ zy
				+ "\")' >"
				+ data
				+ "</a>";

		return tabledata;
	}


}
