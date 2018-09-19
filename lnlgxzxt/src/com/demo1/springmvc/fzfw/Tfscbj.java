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
public class Tfscbj {
//	调峰市场报价---(运行调峰)table查询
	@RequestMapping(value="/tfscbj_yxtf_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscbj_yxtf_table(String rq) {

		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select dcmc,firstlevel,secondlevel from dbtfdb.dbtfdb.t_sdtfycfzfw where rq='"+rq+"' order by dcmc";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object dcmc = sqlVec.get(i).get(0);
				Object bj1 = sqlVec.get(i).get(1);
				Object bj2 = sqlVec.get(i).get(2);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("dcmc", dcmc);
				jsonObject.put("bj1", bj1);
				jsonObject.put("bj2", bj2);
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


//	调峰市场报价---(开停调峰)table查询
	@RequestMapping(value="/tfscbj_kttf_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscbj_kttf_table(String rq) {

		System.out.println("rq:"+rq);

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select jzmc,bjje from dbtfdb.dbtfdb.t_qttffzfw where rq='"+rq+"' order by jzmc";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object jzmc = sqlVec.get(i).get(0);
				Object bj = sqlVec.get(i).get(1);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc", jzmc);
				jsonObject.put("bj", bj);
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

//	调峰市场报价---(出力限制)table查询
	@RequestMapping(value="/tfscbj_clxz_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscbj_clxz_table(String rq) {

		System.out.println("rq:"+rq);




		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select jzmc,ktsx,ktxx from dbtfdb.dbtfdb.t_sdtfktqj where rq='"+rq+"' order by jzmc";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object mc = sqlVec.get(i).get(0);
				Object ktsx = sqlVec.get(i).get(1);
				Object ktxx = sqlVec.get(i).get(2);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("mc", mc);
				jsonObject.put("ktsx", ktsx);
				jsonObject.put("ktxx", ktxx);
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


//	调峰市场报价---(最后报价)table查询
	@RequestMapping(value="/tfscbj_zhbj_table", method=RequestMethod.POST)
	public @ResponseBody Object queryTfscbj_zhbj_table(String rq) {

		System.out.println("rq:"+rq);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select a.rq rq,a.dcmc dcmc,a.firstlevel bj1,a.secondlevel bj2 from dbtfdb.dbtfdb.t_sdtfycfzfw a,"
					+ " (select max(rq) rq,dcmc from dbtfdb.dbtfdb.t_sdtfycfzfw where rq<='"+rq+"' group by dcmc) b"
					+ " where a.rq=b.rq and a.dcmc=b.dcmc AND A.DCMC!='null'"
					+ " order by a.rq,a.dcmc";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object sj = sqlVec.get(i).get(0);
				Object dcmc = sqlVec.get(i).get(1);
				Object bj1 = sqlVec.get(i).get(2);
				Object bj2 = sqlVec.get(i).get(3);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("sj", sj);
				jsonObject.put("dcmc", dcmc);
				jsonObject.put("bj1", bj1);
				jsonObject.put("bj2", bj2);
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
