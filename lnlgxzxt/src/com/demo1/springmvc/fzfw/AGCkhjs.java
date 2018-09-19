package com.demo1.springmvc.fzfw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class AGCkhjs {

	//树结构---电厂--机组  树干节点加jsonObject1.put("isParent", "true");
	@RequestMapping(value="/AGCkhjs_tree", method=RequestMethod.POST)
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
		jsonObject.put("name", "AGC机组");
		jsonObject.put("open", "true");
		jsonObject.put("isParent", "true");
		jsonArray.add(jsonObject);


		try {
			dbo.connect("lgxzdb");


			sql = "select distinct sid,sname from agcbcfy where rq='"+rq+"' order by sname";
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



	@RequestMapping(value="/AGCkhjs_chartdata", method=RequestMethod.POST)
	public @ResponseBody Object querychart_data(String rq,String dcmc) {

		System.out.println("曲线数据:");
		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+dcmc);



		ArrayList<Object> fyArr = new ArrayList<Object>();
		ArrayList<Object> sjzArr = new ArrayList<Object>();
		ArrayList<Object> mbzArr = new ArrayList<Object>();


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			sql = "select a.sj,isnull(bcdl,0),isnull(bcfy,0),zt,gl,mbz from"
					+ " (select sj,zt,gl,mbz from agcdb.agcdb.agcgl_" + rq.replace("-", "") + " where rq='"+rq+"' and sname='"+dcmc+"') a"
					+ " left join"
					+ " (select sj,bcdl,bcfy from agcbcfy where rq='"+rq+"' and sname='"+dcmc+"') b"
					+ " on a.sj=b.sj"
					+ " order by a.sj";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sj = sqlVec.get(i).get(0);
				Object bcdl = sqlVec.get(i).get(1);
				Object bcfy = sqlVec.get(i).get(2);
				Object zt = sqlVec.get(i).get(3);
				Object sjz = sqlVec.get(i).get(4);
				Object mbz = sqlVec.get(i).get(5);

				fyArr.add(bcfy);
				sjzArr.add(sjz);
				mbzArr.add(mbz);
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

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("data1", fyArr.toArray());// 费用
		jsonObject.put("data2", sjzArr.toArray());//有功
		jsonObject.put("data3", mbzArr.toArray());//目标值

		jsonArray.add(jsonObject);



		System.out.println("tree_data:======================"+jsonArray);

		return jsonArray;
	}


//  表格数据——table里面数据
	@RequestMapping(value="/AGC_table", method=RequestMethod.POST)
	public @ResponseBody Object queryAGC_table(String rq, String jzmc) {

		System.out.println("rq:"+rq);
		System.out.println("jzmc:"+jzmc);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			sql = "select a.sj,isnull(bcdl,0),isnull(bcfy,0),zt,gl,mbz from"
					+ " (select sj,zt,gl,mbz from agcdb.agcdb.agcgl_" + rq.replace("-", "") + " where rq='"+rq+"' and sname='"+jzmc+"') a"
					+ " left join"
					+ " (select sj,bcdl,bcfy from agcbcfy where rq='"+rq+"' and sname='"+jzmc+"') b"
					+ " on a.sj=b.sj"
					+ " order by a.sj";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sj = sqlVec.get(i).get(0);
				Object bcdl = sqlVec.get(i).get(1);
				Object bcfy = sqlVec.get(i).get(2);
				Object zt = sqlVec.get(i).get(3);
				Object sjz = sqlVec.get(i).get(4);
				Object mbz = sqlVec.get(i).get(5);


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("sj", sj); //时间
				jsonObject.put("bcdl", bcdl);//补偿费用
				jsonObject.put("bcfy", bcfy);//补偿费用
				jsonObject.put("zt", zt);//状态
				jsonObject.put("sjz", sjz);//实际值
				jsonObject.put("mbz", mbz);//目标值
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
	@RequestMapping(value="/comput_AGCkh_data", method=RequestMethod.POST)
	public @ResponseBody
	Object queryComput_AGCkh_data(String rq) {

		System.out.println("rq:"+rq);


		String res = com.lgxz.compute.agcfzfw.Main.run(rq);

		String SUCESSMESSAGE = rq+" "+res;

		return SUCESSMESSAGE;
	}
}
