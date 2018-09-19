package com.demo.base;

import java.util.Properties;
import java.io.*;

//import org.apache.log4j.*;

/**
 * 读取配置文件config.properties的内容
 *
 */
public class Env extends Properties {

	private static final long serialVersionUID = 1L;
	
	private static Env instance;

	/**
	 * 获取Env对象instance
	 * @return
	 * Env对象
	 */
	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	/**
	 * 设置Env对象instance
	 * @param instance
	 * Env对象
	 */
	public static void setInstance(Env instance) {
		Env.instance = instance;
	}

	/**
	 * 实例化Env对象instance
	 */
	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}

	/**
	 * 读取配置文件config.properties
	 */
	private Env() {
		InputStream is = getClass().getResourceAsStream("/config.properties");
		try {
			load(is);
		} catch (Exception e) {
			System.err.println("FILE 'config.properties' READ ERROR !");
		}
	}
	
}
