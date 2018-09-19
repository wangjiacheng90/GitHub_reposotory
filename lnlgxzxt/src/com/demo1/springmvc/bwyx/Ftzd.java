package com.demo1.springmvc.bwyx;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.bm.Bm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Ftzd {

	HashMap<String, String> jzbmHM = new HashMap<String, String>();


	public Ftzd() {
		try {
			jzbmHM = Bm.getJzbm();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

//	非停指定的table查询
	@RequestMapping(value="/ftzd", method=RequestMethod.POST)
	public @ResponseBody Object querychartFtzd(String rq) {

		System.out.println("rq:"+rq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select rq,sname,ztlx,substr(sj,0,16) from ftkhzd where rq like '" + rq + "%' order by sname,rq";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object ztrq = sqlVec.get(i).get(0);
				Object sname = sqlVec.get(i).get(1);
				Object ztlx = sqlVec.get(i).get(2);
				Object ztsj = sqlVec.get(i).get(3);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("rq", ztrq);
				jsonObject.put("jzmc", sname);
				jsonObject.put("ftzt", ztlx);
				jsonObject.put("ztsj", ztsj);
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

//	非停指定编码table曲线查询
	@RequestMapping(value="/ftzd_ftztbm", method=RequestMethod.POST)
	public @ResponseBody Object querychartFtzd_ftztbm(String rq) {

		System.out.println("rq:"+rq);


		JSONArray jsonArray = new JSONArray();

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();



		try {
			dbo.connect("lgxzdb");

			sql = "select ztlx,khjg from ftkhbm order by ztlx";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String ztlx = sqlVec.get(i).get(0).toString();
				String khjg = sqlVec.get(i).get(1).toString();

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ftztmc", ztlx);
				jsonObject.put("fz", khjg);
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


//	非停指定的table查询
	@RequestMapping(value="/ftzd_khfy", method=RequestMethod.POST)
	public @ResponseBody Object queryFtzd_khfy(String rq) {

		System.out.println("rq:"+rq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select rq,sname,khfy from ftkhfy where rq like '" + rq + "%' order by sname,rq";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object ztrq = sqlVec.get(i).get(0);
				Object sname = sqlVec.get(i).get(1);
				Object khfy = sqlVec.get(i).get(2);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("rq", ztrq);
				jsonObject.put("jzmc", sname);
				jsonObject.put("khfy", khfy);
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

//	非停指定_非停状态类型的方法  -------注意id要与name一致
	@RequestMapping(value="/ftzd_ftzt", method=RequestMethod.POST)
	public @ResponseBody Object querychartFtzd_ftzt(String rq, String yhmc) {

		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);


		JSONArray jsonArray = new JSONArray();

		try {
			Vector<String> ztVec = Bm.getFtkhbm();

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

//	非停指定---table中触发的保存
	@RequestMapping(value="/ftzd_table_save", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartFtzd_table_save
	(String rq,String jzmc,String ftzt,String ztsj,Object index) {

		System.out.println("执行了非停指定table中修改后的保存！");
		System.out.println("rq:"+rq);

		System.out.println("jzmc:"+jzmc);
		System.out.println("dqzt:"+ftzt);
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

			ztsj = ztsj + ":00";

			sql = "update ftkhzd set ztlx='" + ftzt + "',sj='" + ztsj + "' where rq='" + rq + "' and sname='" + jzmc + "'";
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


//	非停编码table中触发的保存
	@RequestMapping(value="/ftzdbm_table_save", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartFtzdbm_table_save
	(String ftztmc,String fz,Object index) {

		System.out.println("执行了非停指定table中修改后的保存！");

		System.out.println("jzmc:"+ftztmc);
		System.out.println("dqzt:"+fz);

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

			sql = "update ftkhbm set khjg='" + fz + "' where ztlx='" + ftztmc + "'";
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


//	添加弹出框中__保存
	@RequestMapping(value="/ftzd_add_Save", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartFtzdzd_add_Save
	(String rq,String jzmc,String ftzt,String ztsj,Object index) {

		System.out.println("执行了非停指定table中修改后的保存！");

		System.out.println("rq:"+rq);
		System.out.println("jzmc:"+jzmc);
		System.out.println("ftzt:"+ftzt);
		System.out.println("ztsj:"+ztsj);

		System.out.print("index:");
		System.out.println(index);

		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");

			ztsj = ztsj + ":00";

			sql = "select * from ftkhzd where rq='" + ztsj.split(" ")[0] + "' and sname='" + jzmc + "' and sj='"+ztsj+"'";
			sqlVec = dbo.executeQuery(sql);

			if (sqlVec.size() > 0) {
				return "非停状态已存在";
			}

			sql = "insert into ftkhzd (rq,sid,sname,ztlx,sj)"
					+ " values"
					+ " ('" + ztsj.split(" ")[0] + "','" + this.jzbmHM.get(jzmc) + "','" + jzmc + "','" + ftzt + "','" + ztsj + "')";
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

//  删除方法
	@RequestMapping(value="/ftzd_delete", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartJzzt_add_delete(String data_all) {

		System.out.println("jzmc_all:"+data_all);



		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");

			String [] data_arr = data_all.split("&");
			for (int i = 0; i < data_arr.length; i++) {
				String data = data_arr[i];
				String rq = data.split("@")[0];
				String jz = data.split("@")[1];
				String sj = data.split("@")[2] + ":00";
				sql = "delete from ftkhzd where rq='"+rq+"' and sname='"+jz+"' and sj='"+sj+"'";
				result += dbo.executeUpdate(sql);
			}
			dbo.commit();

			SUCESSMESSAGE = "删除了"+result+"条数据";
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

//  导入机组记录
	@RequestMapping(value="/ftzd_add_drjzjl", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartFtzd_drjzjl(String rq) {

		System.out.println("rq:"+rq);




		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int resultd = 0;
		int result = 0;

		try {
			dbo.connect("lgxzdb");

			sql = "delete from ftkhzd where rq like '" + rq + "%'";
			resultd = dbo.executeUpdate(sql);
			dbo.commit();


			sql = "select ztlx from ftkhbm";
			Vector<Vector<Object>> ftbmVec = dbo.executeQuery(sql);

			sql = "select rq,sid,sname,lx,sj from jzztjl where rq like '" + rq + "%'";
			Vector<Vector<Object>> jzjlVec = dbo.executeQuery(sql);

			for (int i = 0; i < jzjlVec.size(); i++) {
				String jlrq = jzjlVec.get(i).get(0).toString();
				String sid = jzjlVec.get(i).get(1).toString();
				String sname = jzjlVec.get(i).get(2).toString();
				String lx = jzjlVec.get(i).get(3).toString();
				String sj = jzjlVec.get(i).get(4).toString();

				for (int j = 0; j < ftbmVec.size(); j++) {
					String ztlx = ftbmVec.get(j).get(0).toString();
					if (lx.equals(ztlx)) {
						sql = "insert into ftkhzd (rq,sid,sname,ztlx,sj)"
								+ " values ('" + jlrq + "','" + sid + "','" + sname + "','" + ztlx + "','" + sj + "')";
						result += dbo.executeUpdate(sql);
						break;
					}
				}
			}
			dbo.commit();

			SUCESSMESSAGE = "删除了"+resultd+"条数据，插入了"+result+"条数据";
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

//  计算按钮
	@RequestMapping(value="/ftzd_comput", method=RequestMethod.POST)
	public @ResponseBody
	Object querychartftzd_comput(String rq) {
		System.err.println("rq:"+rq);

		String res = com.lgxz.compute.fjhtjkh.Main.run(rq);

		String SUCESSMESSAGE = rq+" "+res;

		return SUCESSMESSAGE;
	}


}
