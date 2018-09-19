package com.demo1.springmvc.hztj;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
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
public class Bwyxjs {


//	并网运行结算的table查询
	@RequestMapping(value="/bwyxjs_table_query", method=RequestMethod.POST)
	public @ResponseBody Object queryBwyxjs_table_query(String rq) {

		System.out.println("rq:"+rq);

////	String putDwtable(String dcmc,String zy,double data) 电厂名称、专业、数值 double型



		DecimalFormat df = new DecimalFormat("#.##");

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");


			Vector<Double> sumVec = new Vector<Double>();

			sql = "select name from sysdba.syscolumns where id in (select id from sysdba.systables where name='YHZYXKH') and colid>=3 order by colid";
			Vector<Vector<Object>> colnameVec = dbo.executeQuery(sql);

			for (int i = 0; i < colnameVec.size(); i++) {
				sumVec.add(0.0);
			}



			sql = "select px,b.sname";
			for (int i = 0; i < colnameVec.size(); i++) {
				sql += "," + colnameVec.get(i).get(0);
			}
			sql += " from yhzyxkh a,(select sname,px from dcbm union all select sname,px from xnybm) b"
					+ " where rq='"+rq+"' and a.sname=b.sname order by px,b.sname";
			Vector<Vector<Object>> dataVec = dbo.executeQuery(sql);

			for (int i = 0; i < dataVec.size(); i++) {
				Vector<Object> tmpVec = dataVec.get(i);


				String px = tmpVec.get(0).toString();
				String sname = tmpVec.get(1).toString();

				JSONObject jsonObject = new JSONObject();


//				-序号
				jsonObject.put("xh", i + 1);

				jsonObject.put("dcmc", sname);

				double sumsz = 0.0;
				for (int j = 2; j < tmpVec.size(); j++) {
					int colindex = j - 2;
					int fieldindex = j - 1;

					String colname = colnameVec.get(colindex).get(0).toString();
					double sz = Double.parseDouble( tmpVec.get(j).toString() );

					if (sz == 0) {
						jsonObject.put("field"+fieldindex, df.format(sz));
					} else {
						jsonObject.put("field"+fieldindex, putDwtable(sname,colname,df.format(sz)));
					}

					sumsz += sz;

					sumVec.set(colindex, sumVec.get(colindex) + sz);
				}

				jsonObject.put("field"+18, df.format(sumsz));

				jsonArray.add(jsonObject);
			}




			JSONObject jsonObject = new JSONObject();
			jsonObject.put("xh", "");
			jsonObject.put("dcmc", "合计");

			double allsumsz = 0.0;

			for (int i = 0; i < sumVec.size(); i++) {
				int fieldindex = i + 1;
				double sz = sumVec.get(i);

				jsonObject.put("field"+fieldindex, df.format(sz));

				allsumsz += sz;
			}

			jsonObject.put("field"+18, df.format(allsumsz));
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
//
//		jsonObject.put("field1", putDwtable("华电瓦房店田屯风电场","AGC服务",1.0));
//		jsonObject.put("field2",putDwtable("华电瓦房店田屯风电场","安全管理",2.2));
//		jsonObject.put("field3", putDwtable("华电瓦房店田屯风电场","电厂高压侧电器设备",3));
//		jsonObject.put("field4", putDwtable("华电瓦房店田屯风电场","调度业务管理",4));
//		jsonObject.put("field5", putDwtable("华电瓦房店田屯风电场","曲线违约考核",5.0));
//		jsonObject.put("field6", putDwtable("华电瓦房店田屯风电场","非计划停机考核",6));
//		jsonObject.put("field7", putDwtable("华电瓦房店田屯风电场","调峰服务",7));
//		jsonObject.put("field8", putDwtable("华电瓦房店田屯风电场","风电预测考核",8));
//		jsonObject.put("field9", putDwtable("华电瓦房店田屯风电场","黑启动服务",9));
//		jsonObject.put("field10", putDwtable("华电瓦房店田屯风电场","机组检修",10));
//		jsonObject.put("field11", putDwtable("华电瓦房店田屯风电场","继电保护",11));
//		jsonObject.put("field12", putDwtable("华电瓦房店田屯风电场","励磁和PSS装置管理",12));
//		jsonObject.put("field13", putDwtable("华电瓦房店田屯风电场","水库调度",13));
//		jsonObject.put("field14", putDwtable("华电瓦房店田屯风电场","通信",14));
//		jsonObject.put("field15", putDwtable("华电瓦房店田屯风电场","无功调节服务",15));
//		jsonObject.put("field16", putDwtable("华电瓦房店田屯风电场","一次调频服务",16));
//		jsonObject.put("field17", putDwtable("华电瓦房店田屯风电场","自动化",17));
//		jsonObject.put("field18", 180000);
//
//
//
//
//		jsonObject2.put("dcmc", "彰北风电场");
//		jsonObject2.put("field1", 39);
//		jsonObject2.put("field2", 45);
//		jsonObject2.put("field3", 20);
//		jsonObject2.put("field4", 30);
//		jsonObject2.put("field5", 210);
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
	@RequestMapping(value="/bwyxjs_dwtable_query", method=RequestMethod.POST)
	public @ResponseBody Object queryBwyxjs_dwtable_query(String rq,String dcmc,String zy) {

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

			if (zy.equals("计划曲线考核")) {
				sql = "select rq,'计划曲线考核',sname,sum(khfy),'' from jhqxkhfy where sname in (select sname from jzbm where ssdcmc='"+dcmc+"') and rq like '"+rq+"%' group by rq,sname order by sname,rq";
			} else if (zy.equals("非计划停机考核")) {
				sql = "select rq,'非计划停机考核',sname,khfy,'' from ftkhfy where sname in (select sname from jzbm where ssdcmc='"+dcmc+"') and rq like '"+rq+"%' order by rq";
			} else {
				sql = "select rq,zy,sname,fz,bz||' '||yh||' '||sj from yxglpf where sname='"+dcmc+"' and rq like '"+rq+"%' and zy='"+zy+"' order by rq";
			}

			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object date = sqlVec.get(i).get(0);
				Object type = sqlVec.get(i).get(1);
				Object name = sqlVec.get(i).get(2);
				Object fz = sqlVec.get(i).get(3);
				Object bz = sqlVec.get(i).get(4);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("rq", date);
				jsonObject.put("zy", type);
				jsonObject.put("dcmc", name);
				jsonObject.put("fy", fz);
				jsonObject.put("bz", bz);
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
	@RequestMapping(value="/bwyxjs_hz", method=RequestMethod.POST)
	public @ResponseBody
	Object queryBwyxjs_hz(String rq) {

		System.out.println("rq:"+rq);

		String SUCESSMESSAGE = "";

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "delete from yhzyxkh where rq='"+rq+"'";
			dbo.executeUpdate(sql);
			dbo.commit();

			sql = "insert into yhzyxkh (rq,sid,sname,调度业务管理,AGC服务,调峰服务,安全管理,继电保护,水库调度,机组检修,非计划停机考核,计划曲线考核,风电预测考核,通信,无功调节服务,一次调频服务,黑启动服务,电厂高压侧电气设备,励磁和PSS装置管理,自动化)"
					+ " select '"+rq+"',sid,sname,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 from dcbm where tcrq<='"+rq+"-"+Utilities.dayInmonth(Integer.parseInt(rq.split("-")[0]), Integer.parseInt(rq.split("-")[1]))+"'"
					+ " union all"
					+ " select '"+rq+"',sid,sname,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 from xnybm where tcrq<='"+rq+"-"+Utilities.dayInmonth(Integer.parseInt(rq.split("-")[0]), Integer.parseInt(rq.split("-")[1]))+"'";
			dbo.executeUpdate(sql);
			dbo.commit();



			sql = "select ssdcid,sum(khfy) from ftkhfy a,jzbm b where rq like '"+rq+"%' and a.sid=b.sid group by ssdcid";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				Object fy = sqlVec.get(i).get(1);

				sql = "update yhzyxkh set 非计划停机考核=" + fy + " where rq='"+rq+"' and sid='"+sid+"'";
				dbo.executeUpdate(sql);
			}
			dbo.commit();



			sql = "select ssdcid,sum(khfy) from jhqxkhfy a,jzbm b where rq like '"+rq+"%' and a.sid=b.sid group by ssdcid";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				Object fy = sqlVec.get(i).get(1);

				sql = "update yhzyxkh set 计划曲线考核=" + fy + " where rq='"+rq+"' and sid='"+sid+"'";
				dbo.executeUpdate(sql);
			}
			dbo.commit();



			sql = "select sid,zy,sum(fz*1000) from yxglpf where rq like '"+rq+"%' group by sid,zy";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				String zy = sqlVec.get(i).get(1).toString();
				Object fy = sqlVec.get(i).get(2);

				sql = "update yhzyxkh set "+zy+"=" + fy + " where rq='"+rq+"' and sid='"+sid+"'";
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
