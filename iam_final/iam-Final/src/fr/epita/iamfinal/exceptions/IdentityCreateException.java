package fr.epita.iamfinal.exceptions;
import fr.epita.iamfinal.datamodel.Identity;

public class IdentityCreateException extends IdentityDataException{
	
	
	public IdentityCreateException(Exception e, Identity identity)
	{
		super(e, identity);
	}
	
	public String getMessage()
	{
		return "A problem occured while creating identity :" +invalidIdentity;
	}

}
