package fr.epita.iamfinal.exceptions;

import fr.epita.iamfinal.datamodel.Identity;
/**<h3>Description </h3>
 * <p>
 * This is the base class that is inherited by the exception classes to show the cause for the exception
 * </p>
 * @author Roshnee
 *
 */

public class IdentityDataException extends Exception {
	
	protected final Identity invalidIdentity;
	
	public IdentityDataException(Exception cause, Identity invalidIdentity)
	{
		initCause(cause);
		this.invalidIdentity = invalidIdentity;
	}
	

}
