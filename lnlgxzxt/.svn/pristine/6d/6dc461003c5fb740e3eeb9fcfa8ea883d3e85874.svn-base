package com.demo.bm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.demo.base.DBOperate;


public class Bm {


	public static HashMap<String, String> getJzMKhbm() throws Exception {
		return getJzKhMkhBm(0);
	}

	public static HashMap<String, String> getJzKhbm() throws Exception {
		return getJzKhMkhBm(1);
	}

	public static HashMap<String, String> getXnyKhbm() throws Exception {
		return getXnyJzDcBm("xnybm");
	}

	public static HashMap<String, String> getJzKhMkhBm(int qxkhmr) throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select sid,sname from jzbm where qxkhmr=" + qxkhmr + " order by sname";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sid = sqlVec.get(i).get(0).toString();
			String sname = sqlVec.get(i).get(1).toString();
			resHM.put(sname, sid);
		}
		dbo.close();
		return resHM;
	}




	public static HashMap<String, String> getJzbm() throws Exception {
		return getXnyJzDcBm("jzbm");
	}

	public static HashMap<String, String> getDcbm() throws Exception {
		return getXnyJzDcBm("dcbm");
	}

	public static HashMap<String, String> getXnybm() throws Exception {
		return getXnyJzDcBm("xnybm");
	}

	public static HashMap<String, String> getXnyJzDcBm(String table) throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select sid,sname from " + table + " order by sname";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sid = sqlVec.get(i).get(0).toString();
			String sname = sqlVec.get(i).get(1).toString();
			resHM.put(sname, sid);
		}
		dbo.close();
		return resHM;
	}




	public static HashMap<String, String> getJzxnybm() throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select sid,sname from (select sid,sname from jzbm union all select sid,sname from xnybm)";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sid = sqlVec.get(i).get(0).toString();
			String sname = sqlVec.get(i).get(1).toString();
			resHM.put(sname, sid);
		}
		dbo.close();
		return resHM;
	}



	public static HashMap<String, String> getDcxnybm() throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select sid,sname from (select sid,sname from dcbm union all select sid,sname from xnybm)";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sid = sqlVec.get(i).get(0).toString();
			String sname = sqlVec.get(i).get(1).toString();
			resHM.put(sname, sid);
		}
		dbo.close();
		return resHM;
	}



	public static HashMap<String, String> getJzxnylx() throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select sname,stype from (select sname,stype from jzbm union all select sname,stype from xnybm)";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sname = sqlVec.get(i).get(0).toString();
			String stype = sqlVec.get(i).get(1).toString();
			resHM.put(sname, stype);
		}
		dbo.close();
		return resHM;
	}



	public static HashMap<String, String> getJhqxkhbm() throws Exception {
		LinkedHashMap<String, String> resHM = new LinkedHashMap<String, String>();
		DBOperate dbo = new DBOperate(false, false);
		dbo.connect("lgxzdb");
		String sql = "select khlxid,khlxmc from jhqxkhbm where khlxid>=0 order by khlxid";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String khlxid = sqlVec.get(i).get(0).toString();
			String khlxmc = sqlVec.get(i).get(1).toString();
			resHM.put(khlxid, khlxmc);
		}
		dbo.close();
		return resHM;
	}



	public static Vector<String> getJzztbm() throws Exception {
		return getJzZtLXBm("zt");
	}

	public static Vector<String> getJzztlxbm() throws Exception {
		return getJzZtLXBm("lx");
	}

	public static Vector<String> getJzZtLXBm(String ztlx) throws Exception {
		Vector<String> resVec = new Vector<String>();
		DBOperate dbo = new DBOperate(false, true);
		dbo.connect("lgxzdb");
		String sql = "select sname from jzztbm where stype='" + ztlx + "' order by sname";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String sname = sqlVec.get(i).get(0).toString();
			resVec.add(sname);
		}
		dbo.close();
		return resVec;
	}


	public static Vector<String> getFtkhbm() throws Exception {
		Vector<String> resVec = new Vector<String>();
		DBOperate dbo = new DBOperate(false, true);
		dbo.connect("lgxzdb");
		String sql = "select ztlx from ftkhbm order by ztlx";
		Vector<Vector<Object>> sqlVec = dbo.executeQuery(sql);
		for (int i = 0; i < sqlVec.size(); i++) {
			String ztlx = sqlVec.get(i).get(0).toString();
			resVec.add(ztlx);
		}
		dbo.close();
		return resVec;
	}
}
