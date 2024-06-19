import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MainWindow extends JFrame{
	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewContacts;
	private JButton btnExit;

	//private AddContacts addContacts;
	
	public MainWindow(){
		setTitle("iFriend Contact Manager");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTitle = new JLabel("iFriend Contact Manager");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add(lblTitle, BorderLayout.WEST);

		JPanel panel1 = new JPanel(new BorderLayout());
		add(panel1, BorderLayout.EAST);

		JLabel lblHome = new JLabel("Home Page");
		lblHome.setFont(new Font("Arial", Font.BOLD, 18));
		lblHome.setForeground(Color.BLUE);
		lblHome.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(lblHome, BorderLayout.NORTH);

		JPanel panel2 = new JPanel(new GridLayout(5, 1, 5, 5));
		panel1.add(panel2, BorderLayout.CENTER);

		btnAddContact = new JButton("Add New Contact");
		btnAddContact.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddContact.setForeground(Color.BLUE);
		btnAddContact.setHorizontalAlignment(JButton.CENTER);
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				/*if(addContacts==null){
					addContacts=new AddContacts();
				}*/
				new AddContacts().setVisible(true);
			}
		});
		panel2.add(btnAddContact);

		btnUpdateContact = new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdateContact.setForeground(Color.BLUE);
		btnUpdateContact.setHorizontalAlignment(JButton.CENTER);
		panel2.add(btnUpdateContact);

		btnSearchContact = new JButton("Search Contact");
		btnSearchContact.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearchContact.setForeground(Color.BLUE);
		btnSearchContact.setHorizontalAlignment(JButton.CENTER);
		panel2.add(btnSearchContact);

		btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeleteContact.setForeground(Color.BLUE);
		btnDeleteContact.setHorizontalAlignment(JButton.CENTER);
		panel2.add(btnDeleteContact);

		btnViewContacts = new JButton("View Contacts");
		btnViewContacts.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewContacts.setForeground(Color.BLUE);
		btnViewContacts.setHorizontalAlignment(JButton.CENTER);
		panel2.add(btnViewContacts);

		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1.add(panel3, BorderLayout.SOUTH);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.setForeground(Color.BLUE);
		panel3.add(btnExit);
	}
}