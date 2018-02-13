package fr.epita.iamfinal.exceptions;

import fr.epita.iamfinal.datamodel.Identity;

public class IdentityDataException extends Exception {
	
	protected final Identity invalidIdentity;
	
	public IdentityDataException(Exception cause, Identity invalidIdentity)
	{
		initCause(cause);
		this.invalidIdentity = invalidIdentity;
	}
	

}
