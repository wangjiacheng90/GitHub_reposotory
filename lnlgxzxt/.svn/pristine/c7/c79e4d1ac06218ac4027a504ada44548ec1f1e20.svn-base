package com.demo1.springmvc.jsgl;

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
public class Yddl {

//	月度电量table查询
	@RequestMapping(value="/yddl_query", method=RequestMethod.POST)
	public @ResponseBody Object queryYddl_query(String rq) {

		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		JSONArray jsonArray = new JSONArray();



		try {
			dbo.connect("lgxzdb");

			sql = "select a.jsdlmc,sname,dl"
					+ " from jsyddl a,(select sname,jsdlmc,px from dcbm union all select sname,jsdlmc,px from xnybm) b"
					+ " where b.jsdlmc like '%'||a.jsdlmc||'%' and rq='"+rq+"' and sname not in ('桓仁厂','回龙厂')"
					+ " union all"
					+ " select distinct a.jsdlmc,'桓仁厂,回龙厂' sname,dl"
					+ " from jsyddl a,(select sname,jsdlmc,px from dcbm union all select sname,jsdlmc,px from xnybm) b"
					+ " where b.jsdlmc like '%'||a.jsdlmc||'%' and rq='"+rq+"' and sname in ('桓仁厂','回龙厂')";
			sqlVec = dbo.executeQuery(sql);

			double sumdl = 0.0;

			for (int i = 0; i < sqlVec.size(); i++) {
				Object jsdlmc = sqlVec.get(i).get(0);
				Object sname = sqlVec.get(i).get(1);
				double dl = Double.parseDouble( sqlVec.get(i).get(2).toString() );

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jsdy", jsdlmc);
				jsonObject.put("khdy", sname);
				jsonObject.put("dl", dl);
				jsonArray.add(jsonObject);

				sumdl += dl;
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsdy", "合计");
			jsonObject.put("khdy", "合计");
			jsonObject.put("dl", sumdl);
			jsonArray.add(jsonObject);
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
