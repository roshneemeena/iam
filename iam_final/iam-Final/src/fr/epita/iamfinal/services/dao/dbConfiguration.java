package fr.epita.iamfinal.services.dao;

import java.io.File;

public class dbConfiguration {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("re run the program with a configuration location as the first argument");
			return;
		}
			final String pathname = args[0];
			
			final File file = new File(pathname);
			if (!file.exists()) {
				System.out.println("the configuration file does not exist");
				return;
			}

			
			final Configuration configService = Configuration.getInstance();
			final String dbHost = configService.getConfigurationValue("db.host");

			
			if (dbHost == null) {
				System.out.println("failure");
			} else {
				System.out.println(dbHost);
				System.out.println("success");
			}
		}
		}