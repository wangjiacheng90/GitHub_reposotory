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
public class Jzyxcl {

//	非停指定的table查询
	@RequestMapping(value="/jzyxcl_query", method=RequestMethod.POST)
	public @ResponseBody Object queryJzyxcl_query(String rq) {

		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		try {
			dbo.connect("lgxzdb");

			sql = "select sname,(case stype when 'qy' then '前夜' when 'hy' then '后夜' when 'bb' then '白班' end),v1,v2,v3,v4,v5"
					+ " from jzyxcl where rq='" + rq + "' order by sname,stype desc";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sname = sqlVec.get(i).get(0);
				Object bc = sqlVec.get(i).get(1);
				Object v1 = sqlVec.get(i).get(2);
				Object v2 = sqlVec.get(i).get(3);
				Object v3 = sqlVec.get(i).get(4);
				Object v4 = sqlVec.get(i).get(5);				Object v5 = sqlVec.get(i).get(6);


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc",sname);
				jsonObject.put("bc",bc);
				jsonObject.put("yxcl1",v1);
				jsonObject.put("yxcl2",v2);
				jsonObject.put("yxcl3",v3);
				jsonObject.put("yxcl4",v4);
				jsonObject.put("yxcl5",v5);
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
