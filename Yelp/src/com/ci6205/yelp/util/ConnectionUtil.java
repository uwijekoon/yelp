package com.ci6205.yelp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static String url = Properties.getProperty("DATABASE_URL");
	public static String dbdriver = Properties.getProperty("DATABASE_DRIVER");
	public static String username = Properties.getProperty("DATABASE_USERNAME");
	public static String password = Properties.getProperty("DATABASE_PASSWORD");

	public static Connection createConnection() throws Exception{
		Connection con = null;
		try {
			Class.forName(dbdriver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println("Exception in ConnectionUtil.createConnection(): " + ex);
			throw new Exception("Couldn't open connection to database: " +
					ex.getMessage());
		}
		return con;
	}
}

