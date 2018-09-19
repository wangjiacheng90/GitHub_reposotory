package com.demo1.springmvc.yxgl;

import java.sql.SQLException;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.base.Utilities;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Jzktdl {

//	机组可调电力table查询
	@RequestMapping(value="/jzktdl_table", method=RequestMethod.POST)
	public @ResponseBody Object queryJzktdl_table(String rq,String bc) {
// 日期 和 班次
		System.out.println("rq:"+rq);
		System.out.println("bc:"+bc);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();


		int nf = Integer.parseInt(rq.split("-")[0]);
		int yf = Integer.parseInt(rq.split("-")[1]);
		long daycount = Utilities.dayInmonth(nf, yf);

		try {
			dbo.connect("lgxzdb");

			sql = "select t1.sname,t1.bwrl";
			for (int i = 1; i <= daycount; i++) {
				sql += ",day" + i;
			}
			sql += " from";
			for (int i = 1; i <= daycount; i++) {
				if (i > 1) {
					sql += ",";
				}
				sql += " (select a.sname sname,bwrl,bwrl-isnull(v,0) day"+i+" from"
						+ " (select sname,bwrl from jzbm) a"
						+ " left join"
						+ " (select sname,(v1+v2+v3+v4+v5) v from jzyxcl where rq='"+rq+"-"+((i<10)?("0"+i):(""+i))+"' and stype='"+bc+"') b"
						+ " on a.sname=b.sname) t"+i;
			}
			sql += " where";
			for (int i = 1; i <= daycount; i++) {
				if (i > 1) {
					sql += " and";
				}
				sql += " t1.sname=t"+i+".sname";
			}
			sql += " order by sname";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Vector<Object> tmpVec = sqlVec.get(i);
				Object sname = tmpVec.get(0);
				Object bwrl = tmpVec.get(1);

				JSONObject jsonObject = new JSONObject();

				jsonObject.put("jzmc", sname);
				jsonObject.put("rl", bwrl);
				if (bc.equals("qy")) {
					jsonObject.put("bc", "前夜");
				} else if (bc.equals("bb")) {
					jsonObject.put("bc", "白班");
				} else if (bc.equals("hy")) {
					jsonObject.put("bc", "后夜");
				}
				for (int j = 2; j < tmpVec.size(); j++) {
					jsonObject.put("day"+(j-1), tmpVec.get(j));
				}

				System.out.println(jsonObject);
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
