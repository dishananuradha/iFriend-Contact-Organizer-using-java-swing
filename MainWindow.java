import java.awt.*;
import javax.swing.*;

class MainWindow extends JFrame{
	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewContacts;
	private JButton btnExit;
	
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

		JLabel lblHome = new JLabel("Home Page");
		lblHome.setFont(new Font("Arial", Font.BOLD, 18));
		lblHome.setForeground(Color.BLUE);
		lblHome.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(lblHome, BorderLayout.NORTH);

		JPanel panel2 = new JPanel(new GridLayout(5, 1, 5, 5));

		btnAddContact = new JButton("Add New Contact");
		btnAddContact.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddContact.setForeground(Color.BLUE);
		btnAddContact.setHorizontalAlignment(JButton.CENTER);
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

		panel1.add(panel2, BorderLayout.CENTER);

		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.setForeground(Color.BLUE);
		btnExit.setHorizontalAlignment(JButton.CENTER);
		panel3.add(btnExit);

		panel1.add(panel3, BorderLayout.SOUTH);

		add(panel1, BorderLayout.EAST);
	}
}