package fr.epita.iamfinal.services.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {
	

	private Properties properties;

	private static ConfigurationService instance;

	public ConfigurationService(String filePathToConfiguration) {
		
			properties = new Properties();
			try {
				properties.load(new FileInputStream(new File(filePathToConfiguration)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static ConfigurationService getInstance() {
		if (instance == null) {
			instance = new ConfigurationService(System.getProperty("conf"));
		}
		return instance;
	}

	public String getConfigurationValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
}

