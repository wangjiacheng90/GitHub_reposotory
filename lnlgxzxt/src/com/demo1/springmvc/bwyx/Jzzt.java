package com.demo1.springmvc.bwyx;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.base.Utilities;
import com.demo.bm.Bm;
import com.demo.login.UserLogin;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Jzzt {


	HashMap<String, String> jzbmHM = new HashMap<String, String>();


	public Jzzt() {
		try {
			jzbmHM = Bm.getJzbm();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}


	@RequestMapping(value="/jzzt", method=RequestMethod.POST)
	public @ResponseBody Object querychartJzzt(String rq, String yhmc) {

		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select sname,zt,lx,sj from jzzt where rq='" + rq + "' order by sname";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sname = sqlVec.get(i).get(0);
				Object zt = sqlVec.get(i).get(1);
				Object lx = sqlVec.get(i).get(2);
				Object sj = sqlVec.get(i).get(3);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc", sname);
				jsonObject.put("rl", 0);
				jsonObject.put("dqzt", zt);
				jsonObject.put("lx", lx);
				jsonObject.put("rfdl", 0);
				jsonObject.put("ztsj", sj);
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


	@RequestMapping(value="/jzzt1", method=RequestMethod.POST)
	public @ResponseBody Object querychartJzzt1(String rq, String yhmc) {

//		System.out.println("rq:"+rq);
//		System.out.println("yhmc:"+yhmc);

		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();

		jsonObject.put("jzmc", "#9机组");
		jsonObject.put("rl", "60");
		jsonObject.put("dqzt", "运行");
		jsonObject.put("lx", "检修跳闸");
		jsonObject.put("rfdl", "2000");
		jsonObject.put("ztsj", "2018-05-09 09:00");
		jsonObject.put("id", "0");


		jsonObject2.put("jzmc", "#9机组");
		jsonObject2.put("rl", "60");
		jsonObject2.put("dqzt", "检修");
		jsonObject2.put("lx", "检修跳闸");
		jsonObject2.put("rfdl", "300");
		jsonObject2.put("ztsj", "2018-05-09 09:00");
		jsonObject2.put("id", "1");



		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject2);


		System.out.println(jsonArray);

		return jsonArray;
	}


	@RequestMapping(value="/jzzt_jzmc", method=RequestMethod.POST)
	public @ResponseBody Object querychartjzzt_Jzmc(String rq, String yhmc) {

		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);

		JSONArray jsonArray = new JSONArray();

		try {
			for (Map.Entry<String, String> entry: jzbmHM.entrySet()) {
				String sname = entry.getKey();
				String sid = entry.getValue();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc", sname);
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(jsonArray);


		return jsonArray;
	}


//	机组当前状态   注意  ID 要与 Name 一致
	@RequestMapping(value="/jzzt_dqzt", method=RequestMethod.POST)
	public @ResponseBody Object querychartJzzt_dqzt(String rq, String yhmc) {

		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);

		JSONArray jsonArray = new JSONArray();

		try {
			Vector<String> ztVec = Bm.getJzztbm();

			for (int i = 0; i < ztVec.size(); i++) {
				String sname = ztVec.get(i);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ID", sname);
				jsonObject.put("Name", sname);
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(jsonArray);


		return jsonArray;
	}


	@RequestMapping(value="/jzzt_lx", method=RequestMethod.POST)
	public @ResponseBody Object querychartJzztlx(String rq, String yhmc) {

		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);

		JSONArray jsonArray = new JSONArray();

		try {
			Vector<String> ztVec = Bm.getJzztlxbm();

			for (int i = 0; i < ztVec.size(); i++) {
				String sname = ztVec.get(i);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ID", sname);
				jsonObject.put("Name", sname);
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println(jsonArray);


		return jsonArray;
	}


	@RequestMapping(value="/jzztSave", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzdSave
	(String rq,String jzmc,String rl,String dqzt,String lx,String rfdl,String ztsj,Object index) {


		System.out.println("rq:"+rq);

		System.out.println("jzmc:"+jzmc);
		System.out.println("rl:"+rl);
		System.out.println("dqzt:"+dqzt);
		System.out.println("lx:"+lx);
		System.out.println("rfdl:"+rfdl);
		System.out.println("ztsj:"+ztsj);

		System.out.print("index:");
		System.out.println(index);
//		System.out.println("index:"+index);


		String SUCESSMESSAGE = null;

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");

			sql = "update jzzt set zt='" + dqzt + "',lx='" + lx + "',sj='" + ztsj + "' where rq='" + rq + "' and sname='" + jzmc + "'";
			result = dbo.executeUpdate(sql);
			dbo.commit();

			SUCESSMESSAGE = "修改成功了 " + result + " 条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "修改失败";
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


	@RequestMapping(value="/jzzt_add_Save", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzt_add_Save
	(String rq,String jzmc,String lx,String dqzt,String ztsj) {


		System.out.println("rq:"+rq);

		System.out.println("jzmc:"+jzmc);

		System.out.println("dqzt:"+dqzt);
		System.out.println("lx:"+lx);

		System.out.println("ztsj:"+ztsj);


		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");


			sql = "select * from jzzt where rq='" + rq + "' and sname='" + jzmc + "'";
			sqlVec = dbo.executeQuery(sql);

			if (sqlVec.size() > 0) {
				return "机组状态已存在";
			}

			sql = "insert into jzzt (rq,sid,sname,zt,lx,sj)"
					+ " values"
					+ " ('" + rq + "','" + this.jzbmHM.get(jzmc) + "','" + jzmc + "','" + dqzt + "','" + lx + "','" + ztsj + "')";
			result = dbo.executeUpdate(sql);
			dbo.commit();

			SUCESSMESSAGE = "添加成功了 " + result + " 条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "添加失败";
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


	@RequestMapping(value="/jzzt_update", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzt_update
	(String rq,String start_date,String end_date,String jzmc,String dqzt,String lx,String ztsj) {


		System.out.println("rq:"+rq);

		System.out.println("start_date:"+start_date);
		System.out.println("end_date:"+end_date);
		System.out.println("jzmc:"+jzmc);

		System.out.println("dqzt:"+dqzt);
		System.out.println("lx:"+lx);

		System.out.println("ztsj:"+ztsj);


		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");

			String d = start_date;
			while (d.equals(Utilities.getTomorrow(end_date)) == false) {
				sql = "update jzzt set zt='" + dqzt + "',lx='" + lx + "',sj='" + ztsj + "' where sname='" + jzmc + "' and rq='" + d + "'";
				result += dbo.executeUpdate(sql);
				d = Utilities.getTomorrow(d);
			}
			dbo.commit();

			SUCESSMESSAGE = "修改成功了 " + result + " 条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "修改失败";
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


	@RequestMapping(value="/jzzt_delete", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzt_delete
	(String rq,String jzmc_all) {


		System.out.println("rq:"+rq);
		System.out.println("jzmc_all:"+jzmc_all);

		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");



			String[] jzmc_arr=jzmc_all.split("&");
			for(int i=0;i<jzmc_arr.length;i++){
				String sname = jzmc_arr[i];
				sql = "delete from jzzt where rq='" + rq + "' and sname='"+sname+"'";
				result += dbo.executeUpdate(sql);
			}

			dbo.commit();

			SUCESSMESSAGE = "删除成功了 " + result + " 条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "删除失败";
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


	@RequestMapping(value="/jzzt_add_history", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzt_add_history
	(String rq,String history_date) {


		System.out.println("rq:"+rq);


		System.out.println("history_date"+history_date);


		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int resultd = 0;
		int result = 0;

		try {
			dbo.connect("lgxzdb");

			sql = "delete from jzzt where rq='"+rq+"'";
			resultd = dbo.executeUpdate(sql);
			dbo.commit();

			sql = "insert into jzzt select '"+rq+"',sid,sname,zt,lx,sj from jzzt where rq='" +history_date + "'";
			result = dbo.executeUpdate(sql);
			dbo.commit();

			SUCESSMESSAGE = "删除了"+resultd+"条数据，导入成功了 " + result + " 条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "导入失败";
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



}
