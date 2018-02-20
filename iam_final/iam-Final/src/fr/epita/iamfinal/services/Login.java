package fr.epita.iamfinal.services;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Login extends functionality{
	
	
	IdentityJDBCDAO identityJDBC = new IdentityJDBCDAO();
	JFrame frame = new JFrame("USER LOGIN");
	JLabel user_label = new JLabel("User Name :");
	JLabel password_label = new JLabel("PAssword:");
	JTextField user_text = new JTextField(15);
	JTextField pass_text = new JTextField(15);
	JButton login = new JButton("LOGIN");
	public int count = 0;
	public int count1;
	
	public Login() 
	{
		

	}
	/**
	 * <h3>Description</h3>
	 * <p>
	 * This method is for getting the user authentication.
	 * And check if the authentication match with the database
	 * If the credentials are correct it will proceed with the create, update , search and delete operations.
	 * </p>
	 * <h3> utilisation </h3>
	 * <p>
	 * This method uses the function method from functionality class to display the menu on authentication.
	 * </p>
	 */
	
	public void frame() {
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.add(user_label);
		panel.add(user_text);
		panel.add(password_label);
		panel.add(pass_text);
		panel.add(login);
		frame.add(panel);
	login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
			
				try {
					connection = getConnection();
					String user = user_text.getText().trim(); //to remove spaces
					String pwd = pass_text.getText().trim();
					String sql = "SELECT USER_NAME, PWD FROM LOGIN WHERE USER_NAME = '"+ user +"' AND PWD = '" + pwd + "'";
					PreparedStatement pre = connection.prepareStatement(sql);
					ResultSet rs = pre.executeQuery();
					
					while(rs.next())
					{
						count = count+1;
						
					}
										
					if (count == 1)
					{
						JOptionPane.showMessageDialog(null, "user found access granted");
						functionality fun = new functionality();
						fun.function();
						
						}
					else if (count >1) {
						
                        JOptionPane.showMessageDialog(null, "duplicate credentials", "Error", JOptionPane.ERROR_MESSAGE);
						
						}
					else {
						
						JOptionPane.showMessageDialog(null, "user not found", "Error", JOptionPane.ERROR_MESSAGE);
						
						
						}
					
					rs.close();
					pre.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			
			
			
				
		});
        
	   
       
	}
	
	

}
