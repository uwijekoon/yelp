package com.ci6205.yelp.util;

import java.io.IOException;
import java.io.InputStream;

public class Properties {
	private static java.util.Properties prop = new java.util.Properties();

	static{
		init();
	}

	private static void init(){
		InputStream inStream = null;
		try {
			inStream = Properties.class.getClassLoader().getResourceAsStream("yelp.properties");
			prop.load(inStream);		
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static String getProperty(String key){
		return prop.getProperty(key);
	}
	
	
}
