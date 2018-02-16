package fr.epita.iamfinal.services.dao;
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




public class Login extends IdentityJDBCDAO{
	
	
	IdentityJDBCDAO identityJDBC = new IdentityJDBCDAO();
	JFrame f = new JFrame("USER LOGIN");
	JLabel label = new JLabel("User Name :");
	JLabel label1 = new JLabel("PAssword:");
	JTextField t = new JTextField(15);
	JTextField t1 = new JTextField(15);
	JButton b = new JButton("LOGIN");
	public int count = 0;
	public int count1;
	
	public Login() 
	{
		
		//frame();
	}
	
	public void frame() {
		
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JPanel p = new JPanel();
		p.setVisible(true);
		p.add(label);
		p.add(t);
		p.add(label1);
        p.add(t1);
        p.add(b);
        f.add(p);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
			
				try {
					connection = getConnection();
					String user = t.getText().trim(); //to remove spaces
					String pwd = t1.getText().trim();
					String sql = "SELECT USER_NAME, PWD FROM LOGIN WHERE USER_NAME = '"+ user +"' AND PWD = '" + pwd + "'";
					PreparedStatement pre = connection.prepareStatement(sql);
					ResultSet rs = pre.executeQuery();
					
					while(rs.next())
					{
						count = count+1;
					}
										
					if (count == 1)
					{
						//JOptionPane.showMessageDialog(null, "user found access granted");
						JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
						
						
				
						f.dispose();
						System.exit(0);
						
						
					}
					else if (count >1) {
						//JOptionPane.showMessageDialog(p, "duplicate user Access denied",sql, JOptionPane.ERROR_MESSAGE);;
						
                         //JOptionPane.showMessageDialog(null, "DUPLICATE", f, JOptionPane.ERROR_MESSAGE);

						JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
						f.dispose();
						System.exit(1);
						
					
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
						f.dispose();
						System.exit(-1);
						
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
