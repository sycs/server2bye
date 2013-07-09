package com.server2bye.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class URLConfig {

	private Properties prop;
	
	public final String url2bye;
	
	public URLConfig() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		url2bye = prop.getProperty("URL2BYE");
	}
	
}
