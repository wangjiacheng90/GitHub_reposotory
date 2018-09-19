package com.demo1.springmvc.yxgl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
public class Qxkhzd {



	HashMap<String, String> jzxnybmHM = new HashMap<String, String>();


	public Qxkhzd() {
		try {
			jzxnybmHM = Bm.getJzxnybm();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}



	//	曲线考核指定table查询方法------总表
	@RequestMapping(value="/qxkhzd_query", method=RequestMethod.POST)
	public @ResponseBody Object queryqxkhzd_query(String rq) {

		System.out.println("rq:"+rq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select sname,qssj,zzsj,khlx,bz from jhqxkhzd where rq='" + rq + "' order by sname,qssj";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sname = sqlVec.get(i).get(0);
				Object qssj = sqlVec.get(i).get(1);
				Object zzsj = sqlVec.get(i).get(2);
				Object khlx = sqlVec.get(i).get(3);
				Object bz = sqlVec.get(i).get(4);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc", sname);
				jsonObject.put("qssj", qssj);
				jsonObject.put("zzsj", zzsj);
				jsonObject.put("lx", khlx);
				jsonObject.put("bzyy", bz);
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


	//	曲线考核指定table查询方法----风电考核电站
	@RequestMapping(value="/qxkhzd_fd_query", method=RequestMethod.POST)
	public @ResponseBody Object Queryqxkhzd_fd_query(String rq) {

		System.out.println("rq:"+rq);



		JSONArray jsonArray = new JSONArray();

		try {
			HashMap<String, String> xnykhbm = Bm.getXnyKhbm();

			for (Map.Entry<String, String> entry: xnykhbm.entrySet()) {
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


	//	曲线考核指定table查询方法--火电考核机组--------
	@RequestMapping(value="/qxkhzd_hdkh_query", method=RequestMethod.POST)
	public @ResponseBody Object Queryqxkhzd_hdkh_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();

		try {
			HashMap<String, String> xnykhbm = Bm.getJzKhbm();

			for (Map.Entry<String, String> entry: xnykhbm.entrySet()) {
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


	//	曲线考核指定table查询方法--火电考核机组--------
	@RequestMapping(value="/qxkhzd_hdmkh_query", method=RequestMethod.POST)
	public @ResponseBody Object Queryqxkhzd_hdmkh_query(String rq) {

		System.out.println("rq:"+rq);

		JSONArray jsonArray = new JSONArray();

		try {
			HashMap<String, String> xnykhbm = Bm.getJzMKhbm();

			for (Map.Entry<String, String> entry: xnykhbm.entrySet()) {
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



	//	曲线考核指定  --类型的调用方法-----注意id和name 例子 1：跳闸，2：不按AGC指令
	@RequestMapping(value="/qxkhzd_lx", method=RequestMethod.POST)
	public @ResponseBody Object queryqxkhzd_lx(String rq) {

		System.out.println("rq:"+rq);



		JSONArray jsonArray = new JSONArray();


		try {
			HashMap<String, String> xnykhbm = Bm.getJhqxkhbm();

			for (Map.Entry<String, String> entry: xnykhbm.entrySet()) {
				String khlxid = entry.getKey();
				String khlxmc = entry.getValue();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ID", khlxid);
				jsonObject.put("Name", khlxmc);
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println(jsonArray);

		return jsonArray;
	}


	//	曲线考核指定  --备注原因的调用方法-----注意id和name 例子 1：跳闸，2：不按AGC指令
	@RequestMapping(value="/qxkhzd_bz", method=RequestMethod.POST)
	public @ResponseBody Object queryqxkhzd_bz(String rq) {

		System.out.println("rq:"+rq);

		Vector<Object> yyVec = new Vector<Object>();
		yyVec.add("根据电力调度指令临时被指定提供调频、调峰和调压服务");
		yyVec.add("系统事故、机组跳闸等紧急情况，机组按照调度指令紧急调整出力");
		yyVec.add("机组计划并网后3小时及计划解列前3小时之内");
		yyVec.add("新建发电机组调试运行");

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < yyVec.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ID", yyVec.get(i));
			jsonObject.put("Name", yyVec.get(i));
			jsonArray.add(jsonObject);
		}


		System.out.println(jsonArray);

		return jsonArray;
	}


	//	曲线考核指定---table中触发的保存
	@RequestMapping(value="/qxkhzd_table_save", method=RequestMethod.POST)
	public @ResponseBody
	Object qxkhzd_table_save
	(String rq,String jzmc,String qssj,String zzsj,String lx,String bzyy,Object index) {

		System.out.println("执行了曲线考核指定table中修改后的保存！");
		System.out.println("rq:"+rq);

		System.out.println("jzmc:"+jzmc);
		System.out.println("qssj:"+qssj);
		System.out.println("zzsj:"+zzsj);
		System.out.println("lx:"+lx);
		System.out.println("bzyy:"+bzyy);


		System.out.print("index:");
		System.out.println(index);
		//		System.out.println("index:"+index);


		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;


		try {
			dbo.connect("lgxzdb");

			sql = "update jhqxkhzd set khlx="+lx+",bz='"+bzyy+"' where sname='"+jzmc+"' and rq='"+rq+"' and qssj='"+qssj+"' and zzsj='"+zzsj+"'";
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

	//  删除方法
	@RequestMapping(value="/qxkhzd_delete", method=RequestMethod.POST)
	public @ResponseBody
	Object queryqxkhzd_delete(String data_all) {

		System.out.println("jzmc_all:"+data_all);



		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");



			String[] data_arr=data_all.split("&");
			for(int i=0;i<data_arr.length;i++){
				String[] datarow_arr = data_arr[i].split("@");
				String rq = datarow_arr[0];
				String sname = datarow_arr[1];
				String qssj = datarow_arr[2];
				String zzsj = datarow_arr[3];
				sql = "delete from jhqxkhzd where rq='" + rq + "' and sname='"+sname+"' and qssj='"+qssj+"' and zzsj='"+zzsj+"'";
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



	// 弹出添加框中的 保存方法
	@RequestMapping(value="/qxkhzd_add_Save", method=RequestMethod.POST)
	public @ResponseBody
	Object queryqxkhzd_add_Save
	(String rq,String[] jzmc_all,String qssj,String zzsj,String lx,String bzyy) {


		System.out.println("rq:"+rq);


		for(int i=0;i<jzmc_all.length;i++){

			System.out.println("jzmc:"+jzmc_all[i]);

			//		System.out.println("jzmc:");
		}


		System.out.println("qssj:"+qssj);
		System.out.println("zzsj:"+zzsj);
		System.out.println("lx:"+lx);
		System.out.println("bzyy:"+bzyy);

		int qssd = Utilities.sjtosd96(qssj);
		int zzsd = Utilities.sjtosd96(zzsj);



		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");



			for (int i = 0; i < jzmc_all.length; i++) {
				String string = jzmc_all[i];

				sql = "select * from jhqxkhzd where rq='" + rq + "' and sname='" + string + "' and qssd<='" + qssd + "' and zzsd>='" + qssd + "'";
				sqlVec = dbo.executeQuery(sql);
				if (sqlVec.size() > 0) {
					SUCESSMESSAGE = "以下数据已经存在，请勿重复添加";
					SUCESSMESSAGE += "\n" + sqlVec.get(0);
					return SUCESSMESSAGE;
				}
				sql = "select * from jhqxkhzd where rq='" + rq + "' and sname='" + string + "' and qssd<='" + zzsd + "' and zzsd>='" + zzsd + "'";
				sqlVec = dbo.executeQuery(sql);
				if (sqlVec.size() > 0) {
					SUCESSMESSAGE = "以下数据已经存在，请勿重复添加";
					SUCESSMESSAGE += "\n" + sqlVec.get(0);
					return SUCESSMESSAGE;
				}
			}


			for (int i = 0; i < jzmc_all.length; i++) {
				String sname = jzmc_all[i];

				if (sname.length() == 0) {
					continue;
				}


				String sid = this.jzxnybmHM.get(sname);

				sql = "insert into jhqxkhzd (rq,sid,sname,qssd,qssj,zzsd,zzsj,khlx,bz)"
						+ " values ('"+rq+"','"+sid+"','"+sname+"',"+qssd+",'"+qssj+"',"+zzsd+",'"+zzsj+"',"+lx+",'"+bzyy+"')";
				result += dbo.executeUpdate(sql);
			}
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



}
