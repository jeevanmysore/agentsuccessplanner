package com.agentplannertool.backend.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class DBUtil {
	
	private static Logger log=Logger.getLogger(DBUtil.class);
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		DBUtil.driver = driver;
	}
	
	public static void setUrl(String url) {
		DBUtil.url = url;
	}
	
	public static void setUsername(String username) {
		DBUtil.username = username;
	}
	
	public static void setPassword(String password) {
		DBUtil.password = password;
	};
	
	@SuppressWarnings("finally")
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
				log.info("Exception in creating connection:"+e);
				log.error("Exception:"+e);
				System.out.println("Exception in creating connection:"+e);
		} finally {
			log.info("Connection is returned");
			System.out.println("Connection is returned");
			return con;
		}
	}
}
