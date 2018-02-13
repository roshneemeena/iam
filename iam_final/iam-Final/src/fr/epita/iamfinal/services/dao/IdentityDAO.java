package fr.epita.iamfinal.services.dao;

import java.util.List;

import fr.epita.iamfinal.datamodel.Identity;
import fr.epita.iamfinal.exceptions.IdentityCreateException;
import fr.epita.iamfinal.exceptions.IdentitySearchException;

public interface IdentityDAO {

	//public static final Integer number = 0;

	public void create(Identity identity) throws IdentityCreateException;

	public List<Identity> search(Identity criteria) throws IdentitySearchException;

	public void update(Identity identity);

	public void delete(Identity identity);
	
}
