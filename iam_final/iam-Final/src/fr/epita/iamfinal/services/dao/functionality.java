package fr.epita.iamfinal.services.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.derby.catalog.types.UDTAliasInfo;

import fr.epita.iamfinal.datamodel.Identity;

public class functionality extends IdentityJDBCDAO {
	
	IdentityJDBCDAO id = new IdentityJDBCDAO();
	Identity id3 = new Identity();
	//Identity id1 = new Identity();
	
	String lineBreak = "/n";
	String display_name;
	String email_id;
	String d_displayname;
	String d_email;
	String d_uid;
	String u_id;
	String update_display_name;
	String update_email_id;
	String update_u_id;
	
	JFrame frame = new JFrame("Functionality");
	JLabel displayLabel = new JLabel("DISPLAY NAME");
	JLabel emailLabel = new JLabel("EMAIL");
	JLabel uidLabel = new JLabel("UID");
	JLabel update_displayLabel = new JLabel("NEW DISPLAY NAME");
	JLabel update_emailLabel = new JLabel("NEW EMAIL");
	JLabel update_uidLabel = new JLabel("NEW UID");
			
	JTextField diaplayname = new JTextField(15);

	JTextField email = new JTextField(15);
	JTextField uid = new JTextField(15);
	JTextField update_diaplayname = new JTextField(15);

	JTextField update_email = new JTextField(15);
	JTextField update_uid = new JTextField(15);
	JButton createButton = new JButton("Create");
	JButton SearchBUtton = new JButton("Search:");
	JButton updateBUtton = new JButton("Update:");
	JButton deleteBUtton = new JButton("Delete:");
	JButton done = new JButton("DONE");
	
	
	
	
	
	 public functionality() {
		
	}
	
	
	public void function() {
		
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		
		
		
		
		panel.setVisible(true);
	    //panel.add(displayLabel);
		//panel.add(diaplayname);
		//panel.add(emailLabel);
		//panel.add(email);
		//panel.add(uidLabel);
		//panel.add(uid);
		panel.add(createButton);
		panel.add(SearchBUtton);
		panel.add(updateBUtton);
        panel.add(deleteBUtton);
        
        frame.add(panel);
        
        
       createButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == createButton)
				{
					JFrame createframe = new JFrame("Create");
					createframe.setSize(600, 400);
					createframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					createframe.setVisible(true);
					JPanel create_panel = new JPanel();
					create_panel.setVisible(true);
					create_panel.add(displayLabel);
					create_panel.add(diaplayname);
					create_panel.add(emailLabel);
					create_panel.add(email);
					create_panel.add(uidLabel);
					create_panel.add(uid);
					
					create_panel.add(done);
					createframe.add(create_panel);
				
					
					
					done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							display_name = diaplayname.getText();
							email_id = email.getText();
							u_id = uid.getText();
							id.create(display_name, email_id, u_id);
							
						}
					});
					
					//id.create(display_name, email_id, u_id);
					
					
				}
				
			}
		});
        
        SearchBUtton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			      if(e.getSource() == SearchBUtton)
			      {
			    	  JFrame searchFrame = new JFrame("Search");
						searchFrame.setSize(600, 400);
						searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						searchFrame.setVisible(true);
						JPanel search_panel = new JPanel();
						search_panel.setVisible(true);
						search_panel.add(displayLabel);
						search_panel.add(diaplayname);
						search_panel.add(emailLabel);
						search_panel.add(email);
						search_panel.add(uidLabel);
						search_panel.add(uid);
						search_panel.add(done);
						search_panel.add(search_panel);
					
						display_name = diaplayname.getText();
						email_id = email.getText();
						u_id = uid.getText();
						
						
			    	  id.search(display_name, email_id, u_id);
			      }
				
			}
		});
        
        updateBUtton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == updateBUtton)
				{
					JFrame updateFrame = new JFrame("Search");
					updateFrame.setSize(600, 400);
					updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					updateFrame.setVisible(true);
					JPanel updatePanel = new JPanel();
					updatePanel.setVisible(true);
					updatePanel.add(displayLabel);
					updatePanel.add(diaplayname);
					updatePanel.add(emailLabel);
					updatePanel.add(email);
					updatePanel.add(uidLabel);
					updatePanel.add(uid);
					updatePanel.add(update_displayLabel);
					updatePanel.add(update_diaplayname);
					updatePanel.add(update_emailLabel);
					updatePanel.add(update_email);
					updatePanel.add(update_uidLabel);
					updatePanel.add(update_uid);
					updatePanel.add(done);
					updateFrame.add(updatePanel);
					done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							display_name = diaplayname.getText();
							email_id = email.getText();
							u_id = uid.getText();
							update_display_name = update_diaplayname.getText();
							update_email_id = update_email.getText();
							update_u_id = update_uid.getText();
							id.update(update_display_name, update_email_id, update_u_id,display_name,email_id,u_id);
							
						}
					});
					
				}
				
			}
		});
        
        deleteBUtton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == deleteBUtton)
				{
				    
					JFrame deleteFrame = new JFrame("Delete");
					deleteFrame.setSize(600, 400);
					deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					deleteFrame.setVisible(true);
					JPanel deletePanel = new JPanel();
					deletePanel.setVisible(true);
					deletePanel.add(displayLabel);
					deletePanel.add(diaplayname);
					deletePanel.add(emailLabel);
					deletePanel.add(email);
					deletePanel.add(uidLabel);
					deletePanel.add(uid);
					deletePanel.add(done);
					deleteFrame.add(deletePanel);
					/*done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							d_displayname = diaplayname.getText();
							d_email = email.getText();
							d_uid = uid.getText();
							id.delete(d_displayname, d_email, d_uid);
							
						}
					});*/
                       done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							display_name = diaplayname.getText();
							email_id = email.getText();
							u_id = uid.getText();
							id.delete(display_name, email_id, u_id);
							
						}
					});
					
				}
				
			}
		});
		
	}

}
