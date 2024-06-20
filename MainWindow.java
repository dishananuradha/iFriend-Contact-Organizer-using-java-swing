import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

class MainWindow extends JFrame{
	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewContacts;
	private JButton btnExit;

	private AddContacts addContacts;
	
	public MainWindow(){
		setTitle("iFriend Contact Manager");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTitle = new JLabel("iFriend Contact Manager");

			lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
			lblTitle.setForeground(Color.BLACK);
			lblTitle.setBorder(new EmptyBorder(20, 20, 20, 20));
			lblTitle.setHorizontalAlignment(JLabel.CENTER);

		add(lblTitle, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

			JLabel lblHome = new JLabel("Home Page");

				lblHome.setFont(new Font("Arial", Font.BOLD, 18));
				lblHome.setForeground(Color.BLUE);
				lblHome.setHorizontalAlignment(JLabel.CENTER);
				lblHome.setBorder(new EmptyBorder(10, 0, 10, 0));

        	mainPanel.add(lblHome, BorderLayout.NORTH);

			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
			buttonPanel.setBorder(new EmptyBorder(0, 60, 0, 60));

				btnAddContact = new JButton("Add New Contact");
				btnAddContact.setFont(new Font("Arial", Font.BOLD, 14));
				btnAddContact.setForeground(Color.BLUE);
				btnAddContact.setHorizontalAlignment(JButton.CENTER);
				btnAddContact.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						if(addContacts==null){
							addContacts=new AddContacts(MainWindow.this);
						}
						addContacts.setVisible(true);
					}
				});
				buttonPanel.add(btnAddContact);

				btnUpdateContact = new JButton("Update Contact");
				btnUpdateContact.setFont(new Font("Arial", Font.BOLD, 14));
				btnUpdateContact.setForeground(Color.BLUE);
				btnUpdateContact.setHorizontalAlignment(JButton.CENTER);
				buttonPanel.add(btnUpdateContact);

				btnSearchContact = new JButton("Search Contact");
				btnSearchContact.setFont(new Font("Arial", Font.BOLD, 14));
				btnSearchContact.setForeground(Color.BLUE);
				btnSearchContact.setHorizontalAlignment(JButton.CENTER);
				buttonPanel.add(btnSearchContact);

				btnDeleteContact = new JButton("Delete Contact");
				btnDeleteContact.setFont(new Font("Arial", Font.BOLD, 14));
				btnDeleteContact.setForeground(Color.BLUE);
				btnDeleteContact.setHorizontalAlignment(JButton.CENTER);
				buttonPanel.add(btnDeleteContact);

				btnViewContacts = new JButton("View Contacts");
				btnViewContacts.setFont(new Font("Arial", Font.BOLD, 14));
				btnViewContacts.setForeground(Color.BLUE);
				btnViewContacts.setHorizontalAlignment(JButton.CENTER);
				buttonPanel.add(btnViewContacts);

			mainPanel.add(buttonPanel, BorderLayout.CENTER);

			JPanel exitPanel = new JPanel();
			exitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			exitPanel.setBorder(new EmptyBorder(10, 0, 0, 55));

				btnExit = new JButton("Exit");
				btnExit.setFont(new Font("Arial", Font.BOLD, 14));
				btnExit.setForeground(Color.RED);
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				exitPanel.add(btnExit);

			mainPanel.add(exitPanel, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);
	}
}