package fr.epita.iamfinal.exceptions;

import fr.epita.iamfinal.datamodel.Identity;

public class IdentityUpdateException extends IdentityDataException {
	/**<h3>Description </h3>
	 * <p>
	 *  This throws exception when something goes wrong during update.
	 *  </p3>
	 * @param cause
	 * @param invalidIdentity
	 */
	
	public IdentityUpdateException(Exception cause, Identity invalidIdentity)
	{
		super(cause, invalidIdentity);
	}

	public String getMessage() {
		return " A problem occured when searching an the identity :" + invalidIdentity;
	}


}
