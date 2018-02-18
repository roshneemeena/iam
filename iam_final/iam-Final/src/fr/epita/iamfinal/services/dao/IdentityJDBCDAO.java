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


public class IdentityJDBCDAO implements IdentityDAO{
	
	//private static final String DB_Host = "dbURL";
	private static final String DB_Host= "db.host";
	private static final String DB_Pwd= "db.pwd";
	private static final String DB_User= "db.user";

	@Override
	public void create(String display_name, String email, String uid) {
		

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();

			String insertTableSQL = "INSERT INTO IDENTITIESS(UID, EMAIL, DISPLAY_NAME) VALUES (? , ? ,?)";
			preparedStatement = connection.prepareStatement(insertTableSQL);
			//preparedStatement.setString(1, identity.getUid());
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, display_name);
			//preparedStatement.setString(2, identity.getEmail());
			//preparedStatement.setString(3, identity.getDisplayName());
			// execute insert SQL statement
			preparedStatement.executeUpdate();
			System.out.println("the identity is insereted");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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

	@Override
	public List<Identity> search(String display_name, String email, String uid) {

		final List<Identity> result = new ArrayList<>();
		Connection connection = null;
		ResultSet rs;
		try {
			connection = getConnection();
			 String search = "SELECT DISPLAY_NAME, EMAIL, UID FROM IDENTITIESS "
					+ "WHERE (? IS NULL OR DISPLAY_NAME LIKE ?)" + "AND (? IS NULL OR EMAIL LIKE ?)"
					+ " AND (? IS NULL OR UID = ?)";
			
			 PreparedStatement prstmt = connection.prepareStatement(search);
			//prstmt.setString(1, criteria.getDisplayName());
			//prstmt.setString(2, criteria.getDisplayName() + "%");
			//prstmt.setString(3, criteria.getEmail());
			//prstmt.setString(4, criteria.getEmail() + "%");
			//prstmt.setString(5, criteria.getUid());
			//prstmt.setString(6, criteria.getUid() + "%");
			 prstmt.setString(1, display_name);
			 prstmt.setString(2, display_name + "%");
			 prstmt.setString(3, email);
			 prstmt.setString(4, email + "%");
			 prstmt.setString(5, uid);
			 prstmt.setString(6, uid + "%");
			rs = prstmt.executeQuery();
						
			while (rs.next()) {
				Identity currentIdentity = new Identity();
				currentIdentity.setDisplayName(rs.getString("DISPLAY_NAME"));
				currentIdentity.setDisplayName(rs.getString("DISPLAY_NAME"));
				currentIdentity.setEmail(rs.getString("EMAIL"));
				currentIdentity.setUid(rs.getString("UID"));
				System.out.println(currentIdentity.getDisplayName());
				System.out.println(currentIdentity.getEmail());
				result.add(currentIdentity);
							

			}
			
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("search is done");

		return result;
		

	}

	@Override
	public void update(String display_name, String email, String uid , String display_name1, String email1, String uid1) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			//String update = " UPDATE IDENTITIESS SET DISPLAY_NAME = ? AND EMAIL = ? AND UID = ? WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			String update = " UPDATE IDENTITIESS SET DISPLAY_NAME = ?, EMAIL = ?,  UID = ? WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			 pstmt = connection.prepareStatement(update);
			/*pstmt.setString(1, identity.getDisplayName());
			pstmt.setString(2, identity.getEmail());
			pstmt.setString(3, identity.getUid());
			pstmt.setString(4, identity1.getDisplayName());
			pstmt.setString(5, identity1.getEmail());
			pstmt.setString(6, identity1.getUid());*/
			pstmt.setString(1, display_name);
			pstmt.setString(2, email);
			pstmt.setString(3, uid);
		    pstmt.setString(4, display_name1);
			pstmt.setString(5, email1);
			pstmt.setString(6, uid1);
		
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void delete(String display_name, String email, String uid) {
        PreparedStatement preparestmt = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String delete = "DELETE FROM IDENTITIESS WHERE DISPLAY_NAME = ? AND EMAIL = ? AND UID = ?";
			
			preparestmt = connection.prepareStatement(delete);
			/*preparestmt.setString(1, identity.getDisplayName());
			preparestmt.setString(2, identity.getEmail());*/
			//preparestmt.setString(3, identity.getUid());
			preparestmt.setString(1, display_name);
			preparestmt.setString(2, email);
			preparestmt.setString(3, uid);
			preparestmt.executeUpdate();
			System.out.println("deleted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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

	protected static Connection getConnection()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
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