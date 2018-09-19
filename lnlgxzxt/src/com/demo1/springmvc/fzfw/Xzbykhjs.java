package com.demo1.springmvc.fzfw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Xzbykhjs {

	//树结构---电厂--机组  树干节点加jsonObject1.put("isParent", "true");
	@RequestMapping(value="/xzbykhjs_tree", method=RequestMethod.POST)
	public @ResponseBody Object queryAGCkhjs_tree(String rq) {


		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();


		jsonObject = new JSONObject();
		jsonObject.put("id", "0");
		jsonObject.put("pId", "0");
		jsonObject.put("name", "旋转备用机组");
		jsonObject.put("open", "true");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);


		try {
			dbo.connect("lgxzdb");


			sql = "select distinct sid,sname from xzbybcfy where rq='"+rq+"' order by sname";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				String sid = sqlVec.get(i).get(0).toString();
				String sname = sqlVec.get(i).get(1).toString();

				jsonObject = new JSONObject();
				jsonObject.put("id", sid);
				jsonObject.put("pId", 0);
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


	@RequestMapping(value="/xzbykhjs_chartdata", method=RequestMethod.POST)
	public @ResponseBody Object querychart_data(String rq,String dcmc) {

		System.out.println("曲线数据:");
		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+dcmc);




		ArrayList<Object> fyArr = new ArrayList<Object>();
		ArrayList<Object> sjzArr = new ArrayList<Object>();
		ArrayList<Object> zdktArr = new ArrayList<Object>();


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			HashMap<Object, Object> ddbcHM = new HashMap<Object, Object>();
			sql = "select sd,bc from ddbcbm";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Vector<Object> tmpVec =  sqlVec.get(i);
				ddbcHM.put(tmpVec.get(0), tmpVec.get(1));
			}



			HashMap<Object, Object> ktglHM = new HashMap<Object, Object>();

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+dcmc+"' and stype='qy') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("qy", sqlVec.get(0).get(0));

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+dcmc+"' and stype='bb') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("bb", sqlVec.get(0).get(0));

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+dcmc+"' and stype='hy') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("hy", sqlVec.get(0).get(0));



			sql = "select a.sj,a.sd,isnull(bcdl,0),isnull(bcfy,0),gl from"
					+ " (select sd,sj,gl from sjgldb.sjgldb.sjgl_" + rq.replace("-", "") + " where rq='"+rq+"' and sname='"+dcmc+"') a"
					+ " left join"
					+ " (select sd,sj,bcdl,bcfy from xzbybcfy where rq='"+rq+"' and sname='"+dcmc+"') b"
					+ " on a.sd=b.sd"
					+ "	order by a.sd";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sj = sqlVec.get(i).get(0);
				Object sd = sqlVec.get(i).get(1);
				Object bcdl = sqlVec.get(i).get(2);
				Object bcfy = sqlVec.get(i).get(3);
				Object sjz = sqlVec.get(i).get(4);

				fyArr.add(bcfy);
				sjzArr.add(sjz);
				zdktArr.add(ktglHM.get(ddbcHM.get(sd)));
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








		JSONObject jsonObject = new JSONObject();

		jsonObject.put("data1", fyArr.toArray());// 费用
		jsonObject.put("data2", sjzArr.toArray());//有功
		jsonObject.put("data3", zdktArr.toArray());//最大可调

		jsonArray.add(jsonObject);



		System.out.println("tree_data:======================"+jsonArray);

		return jsonArray;
	}


	//  表格数据——table里面数据
	@RequestMapping(value="/xzby_table", method=RequestMethod.POST)
	public @ResponseBody Object queryAGC_table(String rq, String jzmc) {

		System.out.println("rq:"+rq);
		System.out.println("jzmc:"+jzmc);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");


			HashMap<Object, Object> ddbcHM = new HashMap<Object, Object>();
			sql = "select sd,bc from ddbcbm";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Vector<Object> tmpVec =  sqlVec.get(i);
				ddbcHM.put(tmpVec.get(0), tmpVec.get(1));
			}



			HashMap<Object, Object> ktglHM = new HashMap<Object, Object>();

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+jzmc+"' and stype='qy') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("qy", sqlVec.get(0).get(0));

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+jzmc+"' and stype='bb') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("bb", sqlVec.get(0).get(0));

			sql = "select bwrl-isnull(v,0) from"
					+ " (select sname,bwrl from jzbm) a,"
					+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"' and sname='"+jzmc+"' and stype='hy') b"
					+ " where a.sname=b.sname";
			sqlVec = dbo.executeQuery(sql);
			ktglHM.put("hy", sqlVec.get(0).get(0));



			sql = "select a.sj,a.sd,isnull(bcdl,0),isnull(bcfy,0),gl from"
					+ " (select sd,sj,gl from sjgldb.sjgldb.sjgl_" + rq.replace("-", "") + " where rq='"+rq+"' and sname='"+jzmc+"') a"
					+ " left join"
					+ " (select sd,sj,bcdl,bcfy from xzbybcfy where rq='"+rq+"' and sname='"+jzmc+"') b"
					+ " on a.sd=b.sd"
					+ "	order by a.sd";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sj = sqlVec.get(i).get(0);
				Object sd = sqlVec.get(i).get(1);
				Object bcdl = sqlVec.get(i).get(2);
				Object bcfy = sqlVec.get(i).get(3);
				Object sjz = sqlVec.get(i).get(4);


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("sj", sj);
				jsonObject.put("sd", sd);
				jsonObject.put("bcdl", bcdl);
				jsonObject.put("bcfy", bcfy);
				jsonObject.put("sjgl", sjz);
				jsonObject.put("zdkt", ktglHM.get(ddbcHM.get(sd)));
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


	//  AGC考核结果_返回值（   返回例子：2018-05-01 计算完成  或 其他信息）
	@RequestMapping(value="/comput_xzbykh_data", method=RequestMethod.POST)
	public @ResponseBody
	Object queryComput_AGCkh_data(String rq) {

		System.out.println("rq:"+rq);


		String res = com.lgxz.compute.xzbyfzfw.Main.run(rq);

		String SUCESSMESSAGE = rq+" "+res;

		return SUCESSMESSAGE;
	}
}
