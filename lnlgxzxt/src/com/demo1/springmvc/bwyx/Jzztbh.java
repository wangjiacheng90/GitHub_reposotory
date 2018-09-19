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
public class Jzztbh {

	@RequestMapping(value="/jzztbh_query", method=RequestMethod.POST)
	public @ResponseBody Object queryJzztbh(String rq) {

		System.out.println("rq:"+rq);



		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select sname,zt,lx,sj from jzztjl where rq='" + rq + "' order by sname";
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

}
