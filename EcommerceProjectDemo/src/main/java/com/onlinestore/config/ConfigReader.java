package com.onlinestore.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	public static Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("file configuration load failed:" + e.getMessage());
			// TODO: handle exception
		}
		return prop;
	}
		
		 public static String getProperty(String key) {
		        if (prop == null) {
		            initProperties();
		        }
		        return prop.getProperty(key);
		    }
	
	

}
