package com.demo.base;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreateEH {

	public static void create(String directory, String filename, String time, String ehfilename, String filetype, String trantype, String tranmain, String from, String to) throws Exception {
		String strTemp = "";
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(directory + ehfilename)));

		strTemp = "<" + filetype + "::传输说明 time='" + time + "'>";
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "@#顺序 属性名 属性值";
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#0 标识 '" + ehfilename + "'";
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#1 发送地址 " + from;
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#2 接收地址 " + to;
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#3 传输类型 " + trantype;
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#4 内容 " + tranmain;
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "#5 文件 '" + filename + "'";
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		strTemp = "</" + filetype + "::传输说明>";
		out.write(strTemp);
		out.write(System.getProperty("line.separator"));

		out.close();
	}

}

