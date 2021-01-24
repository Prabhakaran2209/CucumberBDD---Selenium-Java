package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	
	private Properties prop;
	
	//This method is used to load the properties from config.properties file
	//returns properties prop object
	
	public Properties init_prop() {
		Properties prop = new Properties();
		
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
