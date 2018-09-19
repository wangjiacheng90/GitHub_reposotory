package com.demo1.springmvc.fzfw;



import java.sql.SQLException;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class JzAgc {


	@RequestMapping(value="/jzAGC_tree", method=RequestMethod.POST)
	public @ResponseBody Object queryjzAGC_tree(String rq) {

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


			sql = "select sid,sname from jzbm where agcid is not null order by sname";
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




//  表格数据
	@RequestMapping(value="/jzAGC_table", method=RequestMethod.POST)
	public @ResponseBody Object queryjzAGC_table(String rq, String jzmc) {

		System.out.println("rq:"+rq);
		System.out.println("dcmc:"+jzmc);



		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			sql = "select sname,sj,zt,gl,mbz from agcdb.agcdb.agcgl_" + rq.replace("-", "") + " where sname='" +jzmc+ "' and rq='"+rq+"' order by sj";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sname = sqlVec.get(i).get(0);
				Object sj = sqlVec.get(i).get(1);
				Object zt = sqlVec.get(i).get(2);
				Object gl = sqlVec.get(i).get(3);
				Object mbz = sqlVec.get(i).get(4);


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc",sname);
				jsonObject.put("sj",sj);
				jsonObject.put("zt",zt);
				jsonObject.put("yhgl",gl);
				jsonObject.put("mbz",mbz);
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



}
