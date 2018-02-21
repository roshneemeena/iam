package fr.epita.iamfinal.exceptions;
import fr.epita.iamfinal.datamodel.Identity;
/**
 * 
 * @author Roshnee
 *
 */

public class IdentityCreateException extends IdentityDataException{
	/**<h3>Description </h3>
	 * <p>
	 * This throws exception when something goes wrong during insertion.
	 * </p>
	 * @param e
	 * @param identity
	 */
	
	public IdentityCreateException(Exception e, Identity identity)
	{
		super(e, identity);
	}
	
	public String getMessage()
	{
		return "A problem occured while creating identity :" +invalidIdentity;
	}

}
