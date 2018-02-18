package fr.epita.iamfinal.launcher;
import fr.epita.iamfinal.datamodel.Identity;
import fr.epita.iamfinal.exceptions.IdentityCreateException;
import fr.epita.iamfinal.services.IdentityJDBCDAO;
import fr.epita.iamfinal.services.Login;
import fr.epita.iamfinal.services.functionality;


public class Main {

	public static void main(String[] args) throws IdentityCreateException {
		//final String confFile = args [0];
		/*if(confFile == null || confFile.isEmpty()) {
			System.out.println("no configuration file argument");
		}
		else
		{
	     new ConfigurationService(confFile);
	     
		}*/
		Login login = new Login();
		login.frame();
		
		//functionality fun = new functionality();
		//fun.function();
	    
		/*Identity id1 = new Identity();
		Identity id2 = new Identity();
		id2.setDisplayName("Meena");
		id2.setEmail("roshneemeenagmail.com");
		id2.setUid("211");
		id1.setDisplayName("titu");
		id1.setEmail("titu@gmail.com");
		id1.setUid("218");
		functionality fun = new functionality();
		fun.function(id1, id2);*/
		//fun.create(id1);
		//System.out.println(id1);
		//System.out.println(id1.getDisplayName());
	     //System.out.println(id1.getEmail());
		//System.out.println(id1.getUid());
		//System.out.println("success");
		//IdentityJDBCDAO idjdbc = new IdentityJDBCDAO();
		//idjdbc.create(id2);
		//System.out.println(id1.getDisplayName());
		//idjdbc.delete(id2);
		//idjdbc.update(id1,id2);
		//idjdbc.search(id1);
		}
}
		
	
		
		


	
