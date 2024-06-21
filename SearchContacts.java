import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

class SearchContacts extends JFrame{
    private JTextField txtSearch;
    private JTextField txtContactId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthDay;

    private JButton btnSearch;
    private JButton btnBackToHome;

    public SearchContacts(JFrame parent){
        setTitle("Search Contact");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int xOffset = -400;
        int yOffset = 100;
        Point parentLocation = parent.getLocation();
        setLocation(parentLocation.x + parent.getWidth() + xOffset, parentLocation.y + yOffset);

        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel lblTitle = new JLabel("Search Contact");
            lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
            lblTitle.setForeground(Color.BLUE);
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            titlePanel.add(lblTitle);

        add(titlePanel, BorderLayout.NORTH);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new EmptyBorder(10, 10, 10,10));

            JPanel searchPanel = new JPanel(new BorderLayout());
            searchPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

                txtSearch = new JTextField();
                txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
                txtSearch.setForeground(Color.BLACK);
                txtSearch.setHorizontalAlignment(JTextField.LEFT);
                txtSearch.setPreferredSize(new Dimension(350, 30));
                searchPanel.add(txtSearch, BorderLayout.WEST);

                btnSearch = new JButton("Search");
                btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
                btnSearch.setForeground(Color.BLUE);
                btnSearch.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String query = txtSearch.getText().toLowerCase();
                        int index = ContactController.searchContact(query);
                        if (index == -1) {
                            JOptionPane.showMessageDialog(
                                SearchContacts.this,
                                "Contact not found",
                                "Warning",
                                JOptionPane.ERROR_MESSAGE
                            );
                            return;
                        }
                        Contact contact = ContactController.getContact(query);
                        txtContactId.setText(contact.getContactId());
                        txtName.setText(contact.getName());
                        txtContactNumber.setText(contact.getPhoneNumber());
                        txtCompanyName.setText(contact.getCompanyName());
                        txtSalary.setText(String.valueOf(contact.getSalary()));
                        txtBirthDay.setText(contact.getBirthDay());
                    }
                });
                searchPanel.add(btnSearch, BorderLayout.EAST);

            panel1.add(searchPanel, BorderLayout.NORTH);

            JPanel contactPanel = new JPanel(new GridLayout(6, 2, 5, 5));
            contactPanel.setBorder(new EmptyBorder(10, 60, 10, 60));

                JLabel lblContactId = new JLabel("Contact Id");
                lblContactId.setFont(new Font("Arial", Font.BOLD, 14));
                lblContactId.setForeground(Color.BLUE);
                lblContactId.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblContactId);

                txtContactId = new JTextField();
                txtContactId.setFont(new Font("Arial", Font.PLAIN, 14));
                txtContactId.setForeground(Color.BLACK);
                txtContactId.setHorizontalAlignment(JTextField.LEFT);
                txtContactId.setEditable(false);
                contactPanel.add(txtContactId);

                JLabel lblName = new JLabel("Name");
                lblName.setFont(new Font("Arial", Font.BOLD, 14));
                lblName.setForeground(Color.BLUE);
                lblName.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblName);
                
                txtName = new JTextField();
                txtName.setFont(new Font("Arial", Font.PLAIN, 14));
                txtName.setForeground(Color.BLACK);
                txtName.setHorizontalAlignment(JTextField.LEFT);
                txtName.setEditable(false);
                contactPanel.add(txtName);

                JLabel lblContactNumber = new JLabel("Contact Number");
                lblContactNumber.setFont(new Font("Arial", Font.BOLD, 14));
                lblContactNumber.setForeground(Color.BLUE);
                lblContactNumber.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblContactNumber);

                txtContactNumber = new JTextField();
                txtContactNumber.setFont(new Font("Arial", Font.PLAIN, 14));
                txtContactNumber.setForeground(Color.BLACK);
                txtContactNumber.setHorizontalAlignment(JTextField.LEFT);
                txtContactNumber.setEditable(false);
                contactPanel.add(txtContactNumber);

                JLabel lblCompanyName = new JLabel("Company Name");
                lblCompanyName.setFont(new Font("Arial", Font.BOLD, 14));
                lblCompanyName.setForeground(Color.BLUE);
                lblCompanyName.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblCompanyName);

                txtCompanyName = new JTextField();
                txtCompanyName.setFont(new Font("Arial", Font.PLAIN, 14));
                txtCompanyName.setForeground(Color.BLACK);
                txtCompanyName.setHorizontalAlignment(JTextField.LEFT);
                txtCompanyName.setEditable(false);
                contactPanel.add(txtCompanyName);

                JLabel lblSalary = new JLabel("Salary");
                lblSalary.setFont(new Font("Arial", Font.BOLD, 14));
                lblSalary.setForeground(Color.BLUE);
                lblSalary.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblSalary);

                txtSalary = new JTextField();
                txtSalary.setFont(new Font("Arial", Font.PLAIN, 14));
                txtSalary.setForeground(Color.BLACK);
                txtSalary.setHorizontalAlignment(JTextField.LEFT);
                txtSalary.setEditable(false);
                contactPanel.add(txtSalary);

                JLabel lblBirthDay = new JLabel("Birth Day");
                lblBirthDay.setFont(new Font("Arial", Font.BOLD, 14));
                lblBirthDay.setForeground(Color.BLUE);
                lblBirthDay.setHorizontalAlignment(JLabel.LEFT);
                contactPanel.add(lblBirthDay);

                txtBirthDay = new JTextField();
                txtBirthDay.setFont(new Font("Arial", Font.PLAIN, 14));
                txtBirthDay.setForeground(Color.BLACK);
                txtBirthDay.setHorizontalAlignment(JTextField.LEFT);
                txtBirthDay.setEditable(false);
                contactPanel.add(txtBirthDay);
                
            panel1.add(contactPanel, BorderLayout.CENTER);

        add(panel1, BorderLayout.CENTER);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel4.setBorder(new EmptyBorder(10, 0, 10, 70));

            btnBackToHome = new JButton("Back to Home");
            btnBackToHome.setFont(new Font("Arial", Font.BOLD, 14));
            btnBackToHome.setForeground(Color.BLUE);
            btnBackToHome.setPreferredSize(new Dimension(148, 30));
            btnBackToHome.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtSearch.setText("");
                    txtContactId.setText("");
                    txtName.setText("");
                    txtContactNumber.setText("");
                    txtCompanyName.setText("");
                    txtSalary.setText("");
                    txtBirthDay.setText("");
                    dispose();
                }
            });
            panel4.add(btnBackToHome);

        add(panel4, BorderLayout.SOUTH);
    }
}