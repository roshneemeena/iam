package fr.epita.iamfinal.services.dao;
import fr.epita.iamfinal.exceptions.IdentityCreateException;
import fr.epita.iamfinal.exceptions.IdentitySearchException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.epita.logger.Logger;

import fr.epita.iamfinal.datamodel.Identity;
import fr.epita.iamfinal.exceptions.IdentityCreateException;

public class IdentityJDBCDAO implements IdentityDAO{
	
	private static final Logger LOGGER = new Logger(IdentityJDBCDAO.class);
	
	private static final String DB_Host= "db.host";
	private static final String DB_Pwd= "db.pwd";
	private static final String DB_User= "db.user";
	@Override
	public void create(Identity identity) throws IdentityCreateException {
		
		LOGGER.info("creating identity" + identity);
				 
		Connection connetion = null;
		try {
			connetion = getConnection();
			final PreparedStatement prestmt = connetion
					.prepareStatement("INSERT INTO IDENTITIES(UID, EMAIL, DISPLAY_NAME) VALUES (? , ? ,?)");
			prestmt.setString(1, identity.getUid());
			prestmt.setString(2, identity.getEmail());
			prestmt.setString(3, identity.getDisplayName());
			prestmt.execute();
 
		} catch (final Exception e) {
			LOGGER.error("error in creating this identity " +identity);
			throw new IdentityCreateException(e, identity);
		}
		
		finally {
			
			if (connetion != null) {
				try {
					connetion.close();
				} catch (final SQLException e) {
					
				}
			}
		}
		
		}
	@Override
	public List<Identity> search(Identity criteria) throws IdentitySearchException {
		
		LOGGER.info("search of the identity :" + criteria);
		final List<Identity> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			final String search = 
				  "SELECT DISPLAY_NAME, EMAIL, UID FROM IDENTITIES " + "WHERE (? IS NULL OR DISPLAY_NAME LIKE ?)" +
			       "AND (? IS NULL OR EMAIL LIKE ?)" + " AND (? IS NULL OR UID = ?)";
			final PreparedStatement prstmt = connection.prepareStatement(search);
			prstmt.setString(1, criteria.getDisplayName());
			prstmt.setString(2, criteria.getDisplayName() + "%");
			prstmt.setString(3, criteria.getEmail());
			prstmt.setString(4, criteria.getEmail() + "%");
			prstmt.setString(5, criteria.getUid());
			prstmt.setString(6, criteria.getUid() + "%");
			final ResultSet rs = prstmt.executeQuery();
			while (rs.next()) 
			{
				final Identity currentIdentity = new Identity();
				currentIdentity.setDisplayName(rs.getString("Display_Name"));
				currentIdentity.setEmail(rs.getString("EMAIL"));
				currentIdentity.setUid(rs.getString("UID"));
				result.add(currentIdentity);
				
				
			}
			
					
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("Error while searching "+ criteria);
			throw new IdentitySearchException(e, criteria);
		}
		finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
		
	}
	@Override
	public void update(Identity identity) {
		LOGGER.info("The update starts for the identity" +identity);
		Connection connection = null;
		try {
			connection = getConnection();
			final String update = " UPDATE IDENTITIES SET DISPLAY_NAME = ? ," + "EMAIL = ? " + "UID = ? " ;
			final PreparedStatement pstmt = connection.prepareStatement(update);
			pstmt.setString(1, identity.getDisplayName());
			pstmt.setString(2,	identity.getEmail());
			pstmt.setString(3, identity.getUid());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error while updating the identity " + identity);
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(Identity identity) {
		LOGGER.info("The deletion of the begins for : " +identity);
	
		Connection connection = null;
		try {
			connection = getConnection();
			String delete = "DELETE FROM IDENTITIES WHERE DISPLAY_NAME = ?" + "EMAIL = ? " + "UID = ? ";
			PreparedStatement preparestmt = connection.prepareStatement(delete);
			preparestmt.setString(1, identity.getDisplayName());
			preparestmt.setString(2, identity.getEmail());
			preparestmt.setString(3, identity.getUid());
			preparestmt.executeUpdate();
			
            } catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("Error while deleting the identity " + identity);
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		final ConfigurationService confService = ConfigurationService.getInstance();

		final String url = confService.getConfigurationValue(DB_Host);
		final String password = confService.getConfigurationValue(DB_Pwd);
		final String username = confService.getConfigurationValue(DB_User);

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		//final Connection connection = DriverManager.getConnection(url, username, password);
		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
