package com.demo1.springmvc.bwyx;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.base.Utilities;
import com.demo.bm.Bm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Qxkh {

	HashMap<String, String> lxHM = new HashMap<String, String>();



	public Qxkh() {
		try {
			lxHM = Bm.getJzxnylx();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@RequestMapping(value="/qxkh_tree", method=RequestMethod.POST)
	public @ResponseBody Object queryQxkh_tree(String rq) {

		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();


		jsonObject = new JSONObject();
		jsonObject.put("id", "0");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "厂站");
		jsonObject.put("open", "true");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);

		jsonObject = new JSONObject();
		jsonObject.put("id", "hd");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "火电厂");
		jsonObject.put("open", "true");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);

		jsonObject = new JSONObject();
		jsonObject.put("id", "fd");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "风电场");
		jsonObject.put("open", "false");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);

		jsonObject = new JSONObject();
		jsonObject.put("id", "sd");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "水电厂");
		jsonObject.put("open", "false");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);

		jsonObject = new JSONObject();
		jsonObject.put("id", "he");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "核电厂");
		jsonObject.put("open", "false");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);

		try {
			dbo.connect("lgxzdb");


			sql = "select distinct sid,sname from jhqxkhfy where rq='" + rq + "' order by sname";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				String sname = sqlVec.get(i).get(1).toString();
				String stype = lxHM.get(sname);

				jsonObject = new JSONObject();
				jsonObject.put("id", sid);
				jsonObject.put("pId", stype);
				jsonObject.put("name", sname);
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

		System.out.println("tree_data:======================"+jsonArray);

		return jsonArray;
	}



	@RequestMapping(value="/qxkh_chartdata", method=RequestMethod.POST)
	public @ResponseBody Object querychart_data(String rq, String dcmc) {

		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+dcmc);


		if (dcmc.equals("厂站") || dcmc.equals("火电厂") || dcmc.equals("风电场") || dcmc.equals("水电厂") || dcmc.equals("核电厂")) {
			return null;
		}


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		ArrayList<Object> fyArr = new ArrayList<Object>();
		ArrayList<Object> sjzArr = new ArrayList<Object>();
		ArrayList<Object> jhzArr = new ArrayList<Object>();
		ArrayList<Object> sxArr = new ArrayList<Object>();
		ArrayList<Object> xxArr = new ArrayList<Object>();



		for (int i = 0; i < 96; i++) {
			fyArr.add(0.0);
			sjzArr.add(0.0);
			jhzArr.add(0.0);
			sxArr.add(0.0);
			xxArr.add(0.0);
		}


		try {
			dbo.connect("lgxzdb");


			sql = "select cssz from xtcs where csid='qxkhpc'";
			sqlVec = dbo.executeQuery(sql);
			double qxkhpc = Double.parseDouble(sqlVec.get(0).get(0).toString());

			sql = "select cssz from xtcs where csid='qxkhxnypc'";
			sqlVec = dbo.executeQuery(sql);
			double qxkhxnypc = Double.parseDouble(sqlVec.get(0).get(0).toString());


			sql = "select sd,khfy from jhqxkhfy where rq='" + rq + "' and sname='"+dcmc+"' order by sd";
			sqlVec = dbo.executeQuery(sql);
			for (int i = 0; i < sqlVec.size(); i++) {
				int index = Integer.parseInt( sqlVec.get(i).get(0).toString() ) - 1;
				Object khfy = sqlVec.get(i).get(1);
				fyArr.set(index, khfy);
			}

			sql = "select sd,gl from sjgldb.sjgldb.sjgl_" + rq.replace("-", "") + " where rq='" + rq + "' and sname='"+dcmc+"' order by sd";
			sqlVec = dbo.executeQuery(sql);
			for (int i = 0; i < sqlVec.size(); i++) {
				int index = Integer.parseInt( sqlVec.get(i).get(0).toString() ) - 1;
				Object gl = sqlVec.get(i).get(1);
				sjzArr.set(index, gl);
			}

			sql = "select sd,gl from sjgldb.sjgldb.sjgl_" + rq.replace("-", "") + " where rq='" + rq + "' and sname='"+dcmc+"' order by sd";
			sqlVec = dbo.executeQuery(sql);
			for (int i = 0; i < sqlVec.size(); i++) {
				int index = Integer.parseInt( sqlVec.get(i).get(0).toString() ) - 1;
				Object gl = sqlVec.get(i).get(1);
				sjzArr.set(index, gl);
			}


			String lx = lxHM.get(dcmc);

			if (lx.equals("fd")) {
				sql = "select qssj,zzsj,xhgl from fdxd where lx in (0,1) and sname='" + dcmc + "' and rq='" + rq + "'";
				sqlVec = dbo.executeQuery(sql);

				for (int i = 0; i < sqlVec.size(); i++) {
					String qssj = sqlVec.get(i).get(0).toString();
					String zzsj = sqlVec.get(i).get(1).toString();
					double xhgl = Double.parseDouble(sqlVec.get(i).get(2).toString());

					int qssd = Utilities.sjtosd96(qssj);
					int zzsd = Utilities.sjtosd96(zzsj);
					for (int k = qssd; k <= zzsd; k++) {
						int index = k - 1;

						jhzArr.set(index, xhgl);
						double sx = Utilities.round(xhgl * (1 + qxkhxnypc), 3);
						double xx = Utilities.round(xhgl * (1 - qxkhxnypc), 3);
						sxArr.set(index, sx);
						xxArr.set(index, xx);
					}
				}
			} else if (lx.equals("hd") || lx.equals("he") || lx.equals("sd")) {
				sql = "select sd,gl from rqjhdb.rqjhdb.rqjh_" + rq.replace("-", "") + " where rq='" + rq + "' and sname='"+dcmc+"' order by sd";
				sqlVec = dbo.executeQuery(sql);

				for (int i = 0; i < sqlVec.size(); i++) {
					int index = Integer.parseInt( sqlVec.get(i).get(0).toString() ) - 1;
					double gl = Double.parseDouble(sqlVec.get(i).get(1).toString());
					jhzArr.set(index, gl);

					double pc = 0.0;
					if (lx.equals("hd") || lx.equals("he")) {
						pc = qxkhpc;
					} else if (lx.equals("sd")) {
						pc = qxkhxnypc;
					}

					double sx = Utilities.round(gl * (1 + pc), 3);
					double xx = Utilities.round(gl * (1 - pc), 3);
					sxArr.set(index, sx);
					xxArr.set(index, xx);
				}
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


		jsonObject.put("data1", fyArr.toArray());
		jsonObject.put("data2", jhzArr.toArray());
		jsonObject.put("data3", sjzArr.toArray());
		jsonObject.put("data4", sxArr.toArray());
		jsonObject.put("data5", xxArr.toArray());
		jsonArray.add(jsonObject);

		System.out.println("tree_data:======================"+jsonArray);

		return jsonArray;
	}

	//  表格数据
	@RequestMapping(value="/qxkh_table", method=RequestMethod.POST)
	public @ResponseBody Object queryqxkh_table(String rq, String dcmc) {

		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+dcmc);


		if (dcmc.equals("厂站") || dcmc.equals("火电厂") || dcmc.equals("风电场") || dcmc.equals("水电厂") || dcmc.equals("核电厂")) {
			return null;
		}


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			sql = "select sj,sd,khdl,khfy,agczt,sjgl,jhgl,khlxmc from jhqxkhfy,jhqxkhbm where rq='" + rq + "' and sname='"+dcmc+"' and khlxid=khlx";
			sqlVec = dbo.executeQuery(sql);
			for (int i = 0; i < sqlVec.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("sj", sqlVec.get(i).get(0));
				jsonObject.put("sd", sqlVec.get(i).get(1));
				jsonObject.put("khdl", sqlVec.get(i).get(2));
				jsonObject.put("khfy", sqlVec.get(i).get(3));
				jsonObject.put("agczt", sqlVec.get(i).get(4));
				jsonObject.put("sjz", sqlVec.get(i).get(5));
				jsonObject.put("jhz", sqlVec.get(i).get(6));
				jsonObject.put("khlx", sqlVec.get(i).get(7));
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


	//  曲线考核结果_返回值（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/comput_qxkh_data", method=RequestMethod.POST)
	public @ResponseBody
	Object queryComput_qxkh_data(String rq) {

		System.out.println("rq:"+rq);


		String res = com.lgxz.compute.jhqxkh.Main.run(rq);

		String SUCESSMESSAGE = rq+" "+res;

		return SUCESSMESSAGE;
	}
}
