package com.demo1.springmvc.bwyx;

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
public class Fdxd {

//	非停指定的table查询
	@RequestMapping(value="/fdxd_query", method=RequestMethod.POST)
	public @ResponseBody Object querychartFdxd_query(String rq) {

		System.out.println("rq:"+rq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select rq,sname,xqgl,xhgl,qssj,zzsj,xddl from fdxd where rq like '" + rq + "%' and lx in (0,1) order by sname,rq";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object xdrq = sqlVec.get(i).get(0);
				Object sname = sqlVec.get(i).get(1);
				Object xqgl = sqlVec.get(i).get(2);
				Object xhgl = sqlVec.get(i).get(3);
				Object qssj = sqlVec.get(i).get(4);
				Object zzsj = sqlVec.get(i).get(5);
				Object xddl = sqlVec.get(i).get(6);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("rq", xdrq);
				jsonObject.put("dcmc", sname);
				jsonObject.put("xqgl", xqgl);
				jsonObject.put("xhgl", xhgl);
				jsonObject.put("qssj", qssj);
				jsonObject.put("zzsj", zzsj);
				jsonObject.put("xddl", xddl);
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
