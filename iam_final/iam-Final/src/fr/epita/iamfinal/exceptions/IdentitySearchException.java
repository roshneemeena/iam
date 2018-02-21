package fr.epita.iamfinal.exceptions;
import fr.epita.iamfinal.datamodel.Identity;
/**
 * 
 * @author Roshnee
 *
 */

public class IdentitySearchException extends IdentityDataException{
	/**<h3>Description </h3>
	 * <p>
	 *  This throws exception when something goes wrong during search.
	 *  </p>
	 * @param cause
	 * @param invalidIdentity
	 */
	
	public IdentitySearchException(Exception cause, Identity invalidIdentity)
	{
		super(cause, invalidIdentity);
	}

	public String getMessage() {
		return " A problem occured when searching an the identity :" + invalidIdentity;
	}
}
