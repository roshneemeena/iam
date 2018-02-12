package fr.epita.iamfinal.services.dao;

import java.util.List;

import fr.epita.iamfinal.datamodel.Identity;

public interface IdentityDAO {

	//public static final Integer number = 0;

	public void create(Identity identity);

	public List<Identity> search(Identity criteria);

	public void update(Identity identity);

	public void delete(Identity identity);
	
}
