package com.demo1.springmvc.mainframe.handlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Login {
	
	
//	登录的方法  -------注意id要与name一致
	@RequestMapping(value="/loginiscanRun", method=RequestMethod.POST)
	public @ResponseBody Object queryloginiscanRun(String id, String pwd, HttpSession session) {

		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);

		session.setAttribute("uid", id);
		session.setAttribute("uname", "管理员");

        
        System.out.println("登录判断");
        boolean SUCESSMESSAGE = true;
		
		return SUCESSMESSAGE;
	}

}
