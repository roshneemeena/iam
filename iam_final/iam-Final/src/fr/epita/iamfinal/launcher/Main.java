package fr.epita.iamfinal.launcher;

import fr.epita.iamfinal.datamodel.Identity;
import fr.epita.iamfinal.services.dao.ConfigurationService;
import fr.epita.iamfinal.services.dao.IdentityJDBCDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String confFile = args [0];
		if(confFile == null || confFile.isEmpty()) {
			System.out.println("no configuration file argument");
		}
		else
		{
	     new ConfigurationService(confFile);
	     
		}
		
		final Identity id1 = new Identity();
		id1.setEmail("roshneemeena0312@gmail.com");
		id1.setDisplayName("Roshnee Meena");
		id1.setUid("210");
		System.out.println(id1);
		final IdentityJDBCDAO idjdbc = new IdentityJDBCDAO();
		idjdbc.create(id1);
		
		

	}

}
