package fr.epita.iamfinal.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			
	JTextField displayname_text = new JTextField(15);

	JTextField email_text = new JTextField(15);
	JTextField uid_text = new JTextField(15);
	JTextField update_diaplayname = new JTextField(15);
    JTextField update_email = new JTextField(15);
	JTextField update_uid = new JTextField(15);
	JButton createButton = new JButton("Create");
	JButton SearchBUtton = new JButton("Search");
	JButton updateBUtton = new JButton("Update");
	JButton deleteBUtton = new JButton("Delete");
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
					create_panel.add(displayname_text);
					create_panel.add(emailLabel);
					create_panel.add(email_text);
					create_panel.add(uidLabel);
					create_panel.add(uid_text);
					
					create_panel.add(done);
					createframe.add(create_panel);
				
					
					
					done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							display_name = displayname_text.getText();
							email_id = email_text.getText();
							u_id = uid_text.getText();
							id.create(display_name, email_id, u_id);
							JOptionPane.showMessageDialog(null, "INSERTION SUCCESSFUL");
							function();
							
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
						search_panel.add(displayname_text);
						search_panel.add(emailLabel);
						search_panel.add(email_text);
						search_panel.add(uidLabel);
						search_panel.add(uid_text);
						search_panel.add(done);
						searchFrame.add(search_panel);
						done.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stubdisplay_name = diaplayname.getText();
								display_name = displayname_text.getText();
								email_id = email_text.getText();
								u_id = uid_text.getText();
								
								
					    	  id.search(display_name, email_id, u_id);
					    	  JOptionPane.showMessageDialog(null, "SEARCH SUCCESSFUL");
					    	  function();
								
							}
						});
					
						
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
					updatePanel.add(displayname_text);
					updatePanel.add(emailLabel);
					updatePanel.add(email_text);
					updatePanel.add(uidLabel);
					updatePanel.add(uid_text);
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
							display_name = displayname_text.getText();
							email_id = email_text.getText();
							u_id = uid_text.getText();
							update_display_name = update_diaplayname.getText();
							update_email_id = update_email.getText();
							update_u_id = update_uid.getText();
							id.update(update_display_name, update_email_id, update_u_id,display_name,email_id,u_id);
							JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL");
							function();
							
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
					deletePanel.add(displayname_text);
					deletePanel.add(emailLabel);
					deletePanel.add(email_text);
					deletePanel.add(uidLabel);
					deletePanel.add(uid_text);
					deletePanel.add(done);
					deleteFrame.add(deletePanel);
					
                       done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							display_name = displayname_text.getText();
							email_id = email_text.getText();
							id.delete(display_name, email_id, u_id);
							JOptionPane.showMessageDialog(null, "DELETION SUCCESSFUL");
							function();
							
						}
					});
					
				}
				
			}
		});
		
	}

}
