package fr.epita.iamfinal.services;
import fr.epita.iamfinal.exceptions.IdentityCreateException;
import fr.epita.iamfinal.exceptions.IdentityDeleteException;
import fr.epita.iamfinal.exceptions.IdentitySearchException;
import fr.epita.iamfinal.exceptions.IdentityUpdateException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.epita.logger.Logger;

import fr.epita.iamfinal.datamodel.Identity;


public class IdentityJDBCDAO implements IdentityDAO{
	
	//private static final String DB_Host = "dbURL";
	private static final String DB_Host= "db.host";
	private static final String DB_Pwd= "db.pwd";
	private static final String DB_User= "db.user";
	Logger LOGGER = new Logger(IdentityJDBCDAO.class);

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This create method is for inserting the identities entered by the user into the database.
	 * </p>
	 * <h3>utilisation</h3>
	 * <p>
	 * This method uses the IdentityCreateException class to throw exception if some problem occurs during insertion
	 * </p>
	 */

	@Override
	public void create(String display_name, String email, String uid) throws IdentityCreateException{
		
       
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LOGGER.info("The creation started");
		

		try {
			connection = getConnection();

			String insertTableSQL = "INSERT INTO IDENTITIESS(UID, EMAIL, DISPLAY_NAME) VALUES (? , ? ,?)";
			preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, display_name);
			preparedStatement.executeUpdate();
			System.out.println("the identity is insereted");
			LOGGER.info("Insertion successful");

		} catch (SQLException e) {
            
			System.out.println(e.getMessage());
			LOGGER.error("Error occured during insertion", e);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This search method is for searching the identities entered by the user into the database.
	 * </p>
	 * <h3>utilisation</h3>
	 * <p>
	 * This method uses the IdentitySearchException class to throw exception if some problem occurs during searching
	 * </p>
	 */
	@Override
	public List<String> search(String display_name, String email, String uid) throws IdentitySearchException {

		final List<String> result = new ArrayList<>();
		Connection connection = null;
		ResultSet rs;
		LOGGER.info("The search starts");
		try {
			connection = getConnection();
		
			String search = "SELECT DISPLAY_NAME, EMAIL, UID FROM IDENTITIESS WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			
			 PreparedStatement prstmt = connection.prepareStatement(search);
			 prstmt.setString(1, display_name);
			 prstmt.setString(2, email);
			 prstmt.setString(3, uid);
			rs = prstmt.executeQuery();
						if(rs.next()) {
			               while (rs.next()) {
				           String display = rs.getString("DISPLAY_NAME");
				           String email_id = rs.getString("EMAIL");
				           String u_id = rs.getString("UID");	
				           result.add(display);
				           result.add(email_id);
				           result.add(u_id);
				
							

			}
				}
			           else {
							System.out.println("the data is not available");
						}
			
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			
			LOGGER.error("The error occured during search");
			
		} 
		
        System.out.println(result);
        LOGGER.info("Search is successful");
		return result;
		

	}
    /**
     * <h3>Description</h3>
	 * <p>
	 * This update method is for updating the identities entered by the user into the database.
	 * </p>
	 * <h3>utilization</h3>
	 * <p>
	 * This method uses the IdentityUpdateException class to throw exception if some problem occurs during update
	 * </p>
     */
	@Override
	public void update(String display_name, String email, String uid , String display_name1, String email1, String uid1) throws IdentityUpdateException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		LOGGER.info("The update started");
		int check;
	
		try {
			connection = getConnection();
			String update = " UPDATE IDENTITIESS SET DISPLAY_NAME = ?, EMAIL = ?,  UID = ? WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			pstmt = connection.prepareStatement(update);
			pstmt.setString(1, display_name);
			pstmt.setString(2, email);
			pstmt.setString(3, uid);
		    pstmt.setString(4, display_name1);
			pstmt.setString(5, email1);
			pstmt.setString(6, uid1);
		
			check = pstmt.executeUpdate();
			if(check != 0)
			{
				System.out.println("updated");
			LOGGER.info("update is done successfully");
			}
			else
			{
				System.out.println("identity not available");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			LOGGER.error("Error occured during update");
		
		}
		finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This delete method is for deleting the identities entered by the user from the database.
	 * </p>
	 * <h3>utilization</h3>
	 * <p>
	 * This method uses the IdentityDeleteException class to throw exception if some problem occurs during deletion
	 * </p>
	 */
	@Override
	public void delete(String display_name, String email, String uid) throws IdentityDeleteException {
        PreparedStatement preparestmt = null;
		Connection connection = null;
		LOGGER.info("The delete has started");
		int check;
		try {
			connection = getConnection();
			String delete = "DELETE FROM IDENTITIESS WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			
			preparestmt = connection.prepareStatement(delete);
			preparestmt.setString(1, display_name);
			preparestmt.setString(2, email);
			preparestmt.setString(3, uid);
			check = preparestmt.executeUpdate();
			
			LOGGER.info("deletion is done successfully");
			if(check != 0)
			{
				System.out.println("deleted");
			
			}
			else
			{
				System.out.println(" identity not available");
			}

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("The error occired during deletion");
			e.printStackTrace();
		} 
		finally {

			if (preparestmt != null) {
				try {
					preparestmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
    /**<h3>Description</h3>
     * <p>
     * This method is for connecting the derby database to perform all the functionalities
     * </p>
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
	protected static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		
			Configuration confService = Configuration.getInstance();
			//String url = confService.getConfigurationValue(DB_Host);
			 String url = confService.getConfigurationValue(DB_Host);
			 String password = confService.getConfigurationValue(DB_Pwd);
			 String username = confService.getConfigurationValue(DB_User);
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			//connection = DriverManager.getConnection(url);
			connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

}