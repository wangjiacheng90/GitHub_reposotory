package com.demo.login;

import java.sql.SQLException;
import java.util.Vector;

import com.demo.base.DBOperate;


public class UserLogin {

	public String uid = "";
	public String uname = "";
	public String role = "";
	
	public boolean iscanLogin(String uid, String pwd) {
		boolean key = false;
		
		DBOperate dbo = new DBOperate(false, true);
		String sql = "";
		Vector<Vector<Object>> sqlVec = null;
		
		try {
			dbo.connect("xhscdb");
			
			sql = "select yhid,yhmc,dlpw,jsbm from yhbm_n";
			sqlVec = dbo.executeQuery(sql);
			for (int i = 0; i < sqlVec.size(); i++) {
				String yhid = sqlVec.get(i).get(0).toString();
				String yhmc = sqlVec.get(i).get(1).toString();
				String dlpw = sqlVec.get(i).get(2).toString();
				String jsbm = sqlVec.get(i).get(3).toString();
				
				if (yhid.equals(uid) && dlpw.equals(pwd)) {
					key = true;
					this.uid = yhid;
					this.uname = yhmc;
					this.role = jsbm;
					
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return key;
	}

}
