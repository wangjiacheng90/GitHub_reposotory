package com.demo1.springmvc.yxgl;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.demo.base.DBOperate;
import com.demo.base.Env;
import com.demo.bm.Bm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class Yxglpf {

	HashMap<String, String> dcxnybmHM = new HashMap<String, String>();

	public Yxglpf() {
		try {
			dcxnybmHM = Bm.getDcxnybm();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}


	String file_directory = Env.getInstance().getProperty("yxglpf.file.path");

//	运行管理评分的table查询
	@RequestMapping(value="/yxglpf_table", method=RequestMethod.POST)
	public @ResponseBody Object queryYxglpf_table(String rq,String zy,String yhmc) {


		System.out.println("执行查询操作=================");
		System.out.println("rq:"+rq);
		System.out.println("zy:"+zy);
		System.out.println("yhmc:"+yhmc);


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select rq,sname,zy,fz,bz from yxglpf where rq like '%"+rq+"%' and zy='"+zy+"' order by rq,sname";
			sqlVec = dbo.executeQuery(sql);

			for (int i = 0; i < sqlVec.size(); i++) {
				Object date = sqlVec.get(i).get(0);
				Object sname = sqlVec.get(i).get(1);
				Object type = sqlVec.get(i).get(2);
				Object fz = sqlVec.get(i).get(3);
				Object bz = sqlVec.get(i).get(4);

				JSONObject jsonObject = new JSONObject();

				jsonObject.put("rq", date);
				jsonObject.put("jzmc", sname);
				jsonObject.put("zy", type);
				jsonObject.put("fz",fz);
				jsonObject.put("bz",bz);

				String filetemp1 = date+"_"+sname+"_"+type;  // 组合文件名
				String file_download_url1 = URL_file(filetemp1,file_directory,"yxglpf_download_file"); // 1不带后缀的名 + 2路径+ 3 ActionName

				jsonObject.put("fj",file_download_url1);

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



	@RequestMapping(value="/yxglpf_jzmc", method=RequestMethod.POST)
	public @ResponseBody Object queryYxglpf_jzmc(String rq, String yhmc) {


		System.out.println("执行了机组名称查询==================");
		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);

		JSONArray jsonArray = new JSONArray();

		try {
			for (Map.Entry<String, String> entry: dcxnybmHM.entrySet()) {
				String sname = entry.getKey();
				String sid = entry.getValue();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jzmc", sname);
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(jsonArray);


		return jsonArray;
	}

//	运行管理评分——专业下拉框的方法  -------注意id要与name一致
	@RequestMapping(value="/yxglpf_zy", method=RequestMethod.POST)
	public @ResponseBody Object queryYxglpf_zy(String rq, String yhmc) {
		System.out.println("执行了获下拉框数据（专业）===========================");
		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);



		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select bm from yhbm_dd where yhid='"+yhmc+"'";
			Object bm = (dbo.executeQuery(sql)).get(0).get(0);

			sql = "select zy from yxglzybm where bm like '%"+bm+"%'";
			sqlVec = dbo.executeQuery(sql);


			for (int i = 0; i < sqlVec.size(); i++) {
				Object zy = sqlVec.get(i).get(0);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ID", zy);
				jsonObject.put("Name", zy);
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



//	运行管理评分——备注下拉框的方法  -------注意id要与name一致
	@RequestMapping(value="/yxglpf_bz", method=RequestMethod.POST)
	public @ResponseBody Object queryYxglpf_bz(String rq, String yhmc) {

		System.out.println("执行了下拉框——备注action=========================");
		System.out.println("rq:"+rq);
		System.out.println("yhmc:"+yhmc);



		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		JSONArray jsonArray = new JSONArray();

		try {
			dbo.connect("lgxzdb");

			sql = "select bm from yhbm_dd where yhid='"+yhmc+"'";
			Object bm = (dbo.executeQuery(sql)).get(0).get(0);

			sql = "select zy,bz from yxglbzbm where zy in (select zy from yxglzybm where bm like '%"+bm+"%')";
			sqlVec = dbo.executeQuery(sql);


			for (int i = 0; i < sqlVec.size(); i++) {
				Object zy = sqlVec.get(i).get(0);
				Object bz = sqlVec.get(i).get(1);

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ID", zy);
				jsonObject.put("Name", bz);
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




//	添加弹出框中__保存
	@RequestMapping(value="/yxglpf_add_Save", method=RequestMethod.POST)
	public @ResponseBody
	Object queryYxglpf_add_Save
	(String rq,String jzmc,String zy,String fz,String bz,String yhmc) {

		System.out.println("执行了弹出框的保存！====================");

		System.out.println("rq:"+rq);
		System.out.println("jzmc:"+jzmc);
		System.out.println("zy:"+zy);
		System.out.println("fz:"+fz);

		System.out.println("bz:"+bz);

		System.out.println("yhmc:"+yhmc);


		String SUCESSMESSAGE = "";


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();


		try {
			dbo.connect("lgxzdb");

			sql = "select * from yxglpf where rq='"+rq+"' and sname='"+jzmc+"' and zy='"+zy+"'";
			sqlVec = dbo.executeQuery(sql);
			if (sqlVec.size() > 0) {
				return "error:记录已存在"; //error给前台判断是否上传文件用
			}


			sql = "insert into yxglpf (rq,sid,sname,zy,fz,bz,yh,sj)"
					+ " values ('"+rq+"','"+dcxnybmHM.get(jzmc)+"','"+jzmc+"','"+zy+"',"+fz+",'"+bz+"','"+yhmc+"','"+sdf.format(new Date())+"')";
			dbo.executeUpdate(sql);
			dbo.commit();




			SUCESSMESSAGE = "运行管理评分修改成功";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return SUCESSMESSAGE;
	}

//  删除方法
	@RequestMapping(value="/yxglpf_delete", method=RequestMethod.POST)
	public @ResponseBody
	Object queryYxglpf_delete(String data_all,String yhmc ) {

		System.out.println("执行了删除================");
		System.out.println("jzmc_all:"+data_all);
		System.out.println("yhmc:"+yhmc);

//		删除文件-----------
		Map<String,String> file_map = getFileNamemap(file_directory);


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String SUCESSMESSAGE = "";


		DBOperate dbo = new DBOperate(false, true);

		String sql = "";
		Vector<Vector<Object>> sqlVec = new Vector<Vector<Object>>();

		int result = 0;

		try {
			dbo.connect("lgxzdb");

			String [] data_arr = data_all.split("&");
			for (int i = 0; i < data_arr.length; i++) {
				String data = data_arr[i];
				String date = data.split("@")[0];
				String sname = data.split("@")[1];
				String type = data.split("@")[2];

				sql = "insert into yxglpfbak"
						+ " select rq,sid,sname,zy,fz,bz,yh,sj,'"+yhmc+"','"+sdf.format(new Date())+"'"
						+ " from yxglpf"
						+ " where rq='"+date+"' and sname='"+sname+"' and zy='"+type+"'";
				dbo.executeUpdate(sql);

				sql = "delete from yxglpf where rq='"+date+"' and sname='"+sname+"' and zy='"+type+"'";
				result += dbo.executeUpdate(sql);

				String fileName = date+"_"+sname+"_"+type;
				deleteProcess(fileName,file_directory,file_map);
			}
			dbo.commit();

			SUCESSMESSAGE = "删除了"+result+"条数据";
		} catch (Exception e) {
			SUCESSMESSAGE = "删除失败";
			e.printStackTrace();
		} finally {
			try {
				dbo.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return SUCESSMESSAGE;
	}





	/*
	   *上传__可以 上传多个文件
	   */
	  @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
	  public @ResponseBody
	  boolean uploadFiles(@RequestParam("file_upload") MultipartFile [] files,@RequestParam(value="filename_upload") String filename_upload) {

		  String fileName = null;
		try {
			fileName = java.net.URLDecoder.decode(filename_upload,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  System.out.println("上传文件名："+fileName);

		  boolean result = false;
	    String realPath;
	    for(int i=0;i<files.length;i++){
	      if (!files[i].isEmpty()) {
	         try{
	        	 String uniqueName=files[i].getOriginalFilename();//得到文件名

	        	 String suffix  = uniqueName.substring(uniqueName.lastIndexOf(".")+1);//获取文件名后缀
	        	 System.out.println("文件后缀名suffix："+suffix);

//	          realPath=file_directory+File.separator+uniqueName;//文件上传的路径这里为E盘
	          realPath=file_directory+File.separator+fileName+"."+suffix;

	          File filepath = new File(realPath,uniqueName);
	          if (!filepath.getParentFile().exists()) {
	                filepath.getParentFile().mkdirs();
	            }

	          files[i].transferTo(new File(realPath));  // 转存文件
	          result = true;
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }else{
	    	  System.out.println("没有文件");
	      }
	    }
	    return result;
	  }


//	  table里文件下载---测试
	  @RequestMapping("download_file_demo")

		public ResponseEntity<byte[]> download_file(HttpSession session,@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age) throws IOException{

			System.out.println("testRequestParam" + " username:" + username + " age:" +age);

			byte[] body = null;
			ServletContext servletContext = session.getServletContext();
			InputStream in = servletContext.getResourceAsStream("E:/upload/123.txt");
			body = new byte[in.available()];
			in.read(body);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename="+username+".txt");
			HttpStatus statusCode = HttpStatus.OK;
			ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
			return response;
		}


//		  table里文件下载
		@RequestMapping("yxglpf_download_file")

//		public ResponseEntity<byte[]> testResponseEntity_demo(HttpSession session,@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age) throws IOException{

		public ResponseEntity<byte[]> testResponseEntity_demo(HttpSession session,@RequestParam(value="name") String name) throws IOException{

			String Name = java.net.URLDecoder.decode(name,"UTF-8");


			System.out.println("下载文件名RequestParam" + " name:" + Name);


			byte[] body = null;
			ServletContext servletContext = session.getServletContext();
			try {

//该方法用来调用tomcat文件夹	InputStream in = servletContext.getResourceAsStream("E:/upload/123.txt");

				File file = new File(file_directory+name); //该方法调用任意路径
				InputStream in = new BufferedInputStream(new FileInputStream(file));;
				body = new byte[in.available()];
				in.read(body);

				in.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HttpHeaders headers = new HttpHeaders();
//			headers.add("Content-Disposition", "attachment;filename="+Name);
			headers.add("Content-Disposition", "attachment;filename="+new String( Name.getBytes("gb2312"), "ISO8859-1" ));//解决中文乱码
			HttpStatus statusCode = HttpStatus.OK;
			ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);

			return response;
//					.write("<script>alert('文件已过期');</script>");
		}

//		解决文件名汉字乱码
		public static class EncodingTool {
		    public static String encodeStr(String str) {
		        try {
		            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		}


//		获取文件名的hashmap
		public static Map<String,String> getFileNamemap(String path)
	    {

		 Map<String,String> map=new HashMap<String,String>();

	        File file = new File(path);
	        String [] fileName = file.list();

	        for(int i=0;i<fileName.length;i++){
	        	String  filename_prefix = fileName[i].substring(0,fileName[i].lastIndexOf("."));
	        	//获取文件名后缀全名
	        	String  filename_suffix = fileName[i];
	        	map.put(filename_prefix, filename_suffix);

	        }
	        return map;
	    }

//		下载附件的方法
		public static String URL_file(String filename,String File_Directory,String ActionName){
			Map<String,String> file_map = getFileNamemap(File_Directory);
			String filetemp = filename;
			String file_download_url = "";
			if(file_map.containsKey(filetemp)){

				String file_download_url_name = file_map.get(filetemp);
//				file_download_url = "<a href='yxglpf_download_file.action?name="+file_download_url_name+"' id='download_file'>下载附件</a><br/>";
				file_download_url = "<a href='"+ActionName+".action?name="+file_download_url_name+"' id='download_file'>下载附件</a><br/>";
			}else{
				file_download_url = "没有附件";
			}

			return file_download_url;
		}

		/**
	     * 删除单个文件
	     *
	     * @param fileName
	     *            要删除的文件的文件名
	     * @return 单个文件删除成功返回true，否则返回false
	     */
	    public static boolean deleteFile(String fileName,String directory) {
	        File file = new File(directory+fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }
	    }

	    public static String deleteProcess(String filename,String File_Directory,Map<String,String> File_map){
	    	Map<String,String> file_map = File_map;
	    	String filetemp = filename;
	    	String MESSAGE = "";

	    	if(file_map.containsKey(filetemp)){

				String filenameAndSuffix = file_map.get(filetemp);

				deleteFile(filenameAndSuffix,File_Directory);

				MESSAGE = "";
			}else{
				MESSAGE = "没有文件";
			}

	    	return MESSAGE;
	    }
}
