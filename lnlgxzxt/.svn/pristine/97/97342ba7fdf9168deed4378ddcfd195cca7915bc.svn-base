package com.demo1.springmvc.mainframe.handlers;

import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.DBOperate;
import com.demo.login.UserLogin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Mainframe {

	@RequestMapping("/testDemo")
	public String test1(){
		System.out.println("testDemo");
//	    return "pages/scucess";
	    return "test/1";
	}

	@RequestMapping("/2")
	public String test2(){
		System.out.println("2");
//	    return "pages/scucess";
	    return "main/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String uid, String pwd, HttpSession session) {
		UserLogin userLogin = new UserLogin();
		if (userLogin.iscanLogin(uid, pwd)) {
			System.out.println("login sussess : " + uid + " : " + pwd);
			session.setAttribute("uid", userLogin.uid);
			session.setAttribute("uname", userLogin.uname);
			session.setAttribute("role", userLogin.role);
			return "main/maiFrame";
		} else {
			System.out.println("login error : " + uid + " : " + pwd);
			return "main/login";
		}
	}



	@RequestMapping(value="/jmenu", method=RequestMethod.POST)
	public @ResponseBody Object querychart(String rq, String yhid) {

		System.out.println("rq:"+rq);
		System.out.println("yhid:"+yhid);

		JSONArray jsonArray = new JSONArray();

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		try {
			dbo.connect("lgxzdb");

			sql = "select js from yhbm_dd where yhid='" + yhid + "'";
			String js = (dbo.executeQuery(sql)).get(0).get(0).toString();


			sql = "select id,txt,icon,gx from menu_qx where qx like '%" + js + "%' and jb=1 order by sx";
			Vector<Vector<Object>> firstVec = dbo.executeQuery(sql);

			for (int i = 0; i < firstVec.size(); i++) {
				String id = firstVec.get(i).get(0).toString();
				String txt = firstVec.get(i).get(1).toString();
				String icon = firstVec.get(i).get(2).toString();
				String gx = firstVec.get(i).get(3).toString();


				JSONObject jsonObject = new JSONObject();
				JSONArray jsonArrayNodes = new JSONArray();

				jsonObject.put("id", id);
				jsonObject.put("text", txt);
				jsonObject.put("icon", icon);
				jsonObject.put("url", null);


				sql = "select id,txt,icon,url from menu_qx where qx like '%" + js + "%' and jb=2 and gx='" + gx + "' order by sx";
				Vector<Vector<Object>> secondVec = dbo.executeQuery(sql);

				for (int j = 0; j < secondVec.size(); j++) {
					String idNodes = secondVec.get(j).get(0).toString();
					String txtNodes = secondVec.get(j).get(1).toString();
					String iconNodes = secondVec.get(j).get(2).toString();
					String urlNodes = secondVec.get(j).get(3).toString();

					JSONObject jsonNodes = new JSONObject();
					jsonNodes.put("id", idNodes);
					jsonNodes.put("text", txtNodes);
					jsonNodes.put("icon", iconNodes);
					jsonNodes.put("url", urlNodes);
					jsonArrayNodes.add(jsonNodes);
				}


				jsonObject.put("menus", jsonArrayNodes);
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
