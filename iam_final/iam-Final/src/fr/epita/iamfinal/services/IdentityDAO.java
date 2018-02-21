package fr.epita.iamfinal.services;

import java.util.List;

import fr.epita.iamfinal.datamodel.Identity;
import fr.epita.iamfinal.exceptions.IdentityCreateException;
import fr.epita.iamfinal.exceptions.IdentityDeleteException;
import fr.epita.iamfinal.exceptions.IdentitySearchException;
import fr.epita.iamfinal.exceptions.IdentityUpdateException;
/**
 * 
 * @author Roshnee
 *
 */
public interface IdentityDAO {

	//public static final Integer number = 0;

	public void create(String display_name , String email, String uid) throws IdentityCreateException;

	public List<String> search(String display_name, String email, String uid) throws IdentitySearchException;

	public void update(String display_name, String email, String uid , String display_name1, String email1, String uid1) throws IdentityUpdateException;

	public void delete(String display_name, String email, String uid) throws IdentityDeleteException;
	
}
