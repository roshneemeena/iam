package fr.epita.iamfinal.exceptions;
import fr.epita.iamfinal.datamodel.Identity;

public class IdentitySearchException extends IdentityDataException{
	
	public IdentitySearchException(Exception cause, Identity invalidIdentity)
	{
		super(cause, invalidIdentity);
	}

	public String getMessage() {
		return " A problem occured when searching an the identity :" + invalidIdentity;
	}
}
