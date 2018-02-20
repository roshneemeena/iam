package fr.epita.iamfinal.exceptions;

import fr.epita.iamfinal.datamodel.Identity;

/**
 * <h3>Description </h3>
 * <p>
 *  This throws exception when something goes wrong during deletion.
 *  </p3>
 * @author Roshnee
 *
 */
public class IdentityDeleteException extends IdentityDataException {
	public IdentityDeleteException(Exception cause, Identity invalidIdentity)
	{
		super(cause, invalidIdentity);
	}

	public String getMessage() {
		return " A problem occured when searching an the identity :" + invalidIdentity;
	}

}
