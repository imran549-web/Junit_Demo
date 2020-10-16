package com.org.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Loading properties */
public class LoadProperties {

	private static final Logger logger = LoggerFactory.getLogger(LoadProperties.class);
	static String defaultPropertiesFile = "config.properties";

	private static Properties confProperties = new Properties();

	private static void loadPropFromResource(String fileName) {
		try {
			InputStream inputStream1 = new FileInputStream(fileName);
			confProperties.load(inputStream1);
			logger.info("Loading property file - from " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Failed to load property files -- " + e);

		}
	}
	public static String readConfigProperty(String key) {
		String value = null;
		try {
			loadPropFromResource(defaultPropertiesFile);
			value = confProperties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to find property - " + key + " check the properties file" + "---" + e);
		}

		return value;
	}

	public static String getAppUrl() {
		String appUrl = null;
		appUrl = readConfigProperty("appUrl");
		return appUrl;
	}


	public static String getAppUserName() {
		return readConfigProperty("username");
	}
	public static String getAppPassword() {
		return readConfigProperty("password");
	}



}