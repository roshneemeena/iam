package fr.epita.iamfinal.services.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Configuration {
	
	private static Configuration instance;
	private Properties properties;


	private Configuration() {
		
			properties = new Properties();
			try {
				String file=System.getProperty("conf");
				FileInputStream fileInputStream= new FileInputStream(file);
				properties.load(fileInputStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	public String getConfigurationValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
}



