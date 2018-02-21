package fr.epita.iamfinal.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Roshnee
 *
 */
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

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This is used to get the instance of the database connection
	 * </p>
	 * @return
	 */
	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

     /**
      * <h3> Description </h3>
      * <p>
      * This method is to take the values from the property file
      * </p>
      * @param propertyKey
      * @return
      */
	public String getConfigurationValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
}



