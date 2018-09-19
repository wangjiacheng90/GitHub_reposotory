package com.demo.base;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import com.jcraft.jsch.*;

public class MySFTP {

	private String ip;
	private int port;
	private String user;
	private String password;
	private ChannelSftp sftp;


	public MySFTP(String ip, int port, String user, String password) {
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	public void connect() {
		try {
			JSch jsch = new JSch();
			Session sshSession = jsch.getSession(user, ip, port);
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.setServerAliveInterval(92000);
			sshSession.connect();
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			
			//jsch-0.1.41.jar支持转码
			//sftp.setFilenameEncoding("gbk");

			//jsch-0.1.54.jar不支持转码，使用反射
			Field fEncoding = sftp.getClass().getDeclaredField("fEncoding");
			fEncoding.setAccessible(true);
			fEncoding.set(sftp, "GBK");
			Field isEncoding = sftp.getClass().getDeclaredField("fEncoding_is_utf8");
			isEncoding.setAccessible(true);
			isEncoding.set(sftp, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnected() {
		try {
			if (sftp != null)
				sftp.getSession().disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload(String directory, String uploadFile) {
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			sftp.put(new FileInputStream(file), file.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void download(String directory, String downloadFile, String saveFile) {
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String directory, String deleteFile) {
		try {
			sftp.cd(directory);
			sftp.rm(deleteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector getFileList(String directory) throws Exception {
		return sftp.ls(directory);
	}

	public boolean rename(String directory, String fromFile, String tofile) {
		try {
			sftp.cd(directory);
			sftp.rename(fromFile, tofile);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
