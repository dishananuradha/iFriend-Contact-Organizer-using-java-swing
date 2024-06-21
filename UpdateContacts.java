import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

class UpdateContacts extends JFrame{
    private JTextField txtSearch;
    private JTextField txtContactId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthDay;

    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JButton btnBackToHome;

    public UpdateContacts(JFrame parent){
        setTitle("Update Contact");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int xOffset = -400;
        int yOffset = 100;
        Point parentLocation = parent.getLocation();
        setLocation(parentLocation.x + parent.getWidth() + xOffset, parentLocation.y + yOffset);

        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel lblTitle = new JLabel("Update Contact");
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
                                UpdateContacts.this,
                                "Contact not found",
                                "Not Found",
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
                txtName.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String name = txtName.getText();
                        if (ContactController.isValidName(name)) {
                            txtContactNumber.requestFocus(); // Move focus to the next text field
                        } else {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Name cannot be empty or invalid. Do you want to input the name again?",
                                "Invalid Name",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtName.setText(""); // Clear the text field
                                txtName.requestFocus(); // Request focus to the text field
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                        }
                    }
                });
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
                txtContactNumber.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String phoneNumber = txtContactNumber.getText();

                        // Check if the phone number is valid
                        if (!ContactController.isValidPhoneNumber(phoneNumber)) {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Invalid phone number. Do you want to input phone number again?",
                                "Invalid Phone Number",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtContactNumber.setText("");
                                txtContactNumber.requestFocus(); // Request focus to let user re-enter
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                            return; // Exit the actionPerformed method
                        }

                        // Check if the phone number is a duplicate
                        if (ContactController.isDuplicate(phoneNumber)) {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Phone number is a duplicate. Do you want to input phone number again?",
                                "Duplicate Phone Number",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtContactNumber.setText("");
                                txtContactNumber.requestFocus(); // Request focus to let user re-enter
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                            return; // Exit the actionPerformed method
                        }

                        // If the phone number is valid and not a duplicate, move focus to the next text field
                        txtCompanyName.requestFocus();
                    }
                });
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
                txtCompanyName.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String companyName = txtCompanyName.getText();
                        if (ContactController.isValidCompanyName(companyName)) {
                            txtSalary.requestFocus(); // Move focus to the next text field
                        } else {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Company name cannot be empty. Do you want to input the company name again?",
                                "Invalid Company Name",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtCompanyName.setText(""); // Clear the text field
                                txtCompanyName.requestFocus(); // Request focus to the text field
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                        }
                    }
                });
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
                txtSalary.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        double salary = Double.parseDouble(txtSalary.getText());
                        if (ContactController.isValidSalary(salary)) {
                            txtBirthDay.requestFocus(); // Move focus to the next text field
                        } else {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Salary cannot be negative. Do you want to input salary again?",
                                "Invalid Salary",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtSalary.setText("");
                                txtSalary.requestFocus(); // Request focus to let user re-enter
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                        }
                    }
                });
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
                txtBirthDay.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String birthDay = txtBirthDay.getText();
                        if (ContactController.isValidBirthDay(birthDay)) {
                            btnUpdate.requestFocus(); // Move focus to the Add button
                        } else {
                            int option = JOptionPane.showConfirmDialog(
                                UpdateContacts.this,
                                "Invalid birth day. Do you want to input birth day again?",
                                "Invalid Birth Day",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                txtBirthDay.setText(""); // Clear the text field
                                txtBirthDay.requestFocus(); // Request focus to the text field
                            } else {
                                txtSearch.setText("");
                                txtContactId.setText("");
                                txtName.setText("");
                                txtContactNumber.setText("");
                                txtCompanyName.setText("");
                                txtSalary.setText("");
                                txtBirthDay.setText("");
                                dispose(); // Close the window
                            }
                        }
                    }
                });
                contactPanel.add(txtBirthDay);
                
            panel1.add(contactPanel, BorderLayout.CENTER);

        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new GridLayout(2,1,5,5));
        panel2.setBorder(new EmptyBorder(10, 0, 10, 70));

            JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                btnUpdate = new JButton("Update");
                btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
                btnUpdate.setForeground(Color.BLUE);
                btnUpdate.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String name = txtName.getText().toLowerCase();
                        String phoneNumber = txtContactNumber.getText();
                        String companyName = txtCompanyName.getText();
                        double salary = Double.parseDouble(txtSalary.getText());

                        String query = txtSearch.getText().toLowerCase();
                        Contact contact = ContactController.getContact(query);
                        contact.setName(name);
                        contact.setPhoneNumber(phoneNumber);
                        contact.setCompanyName(companyName);
                        contact.setSalary(salary);

                        JOptionPane.showMessageDialog(
                            UpdateContacts.this,
                            "Contact updated successfully",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                        
                        txtSearch.setText("");
                        txtContactId.setText("");
                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompanyName.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                });
                panel3.add(btnUpdate);

                btnCancel = new JButton("Cancel");
                btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
                btnCancel.setForeground(Color.BLUE);
                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        txtContactId.setText("");
                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompanyName.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                });
                panel3.add(btnCancel);

            panel2.add(panel3);

            JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

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

            panel2.add(panel4);

        add(panel2, BorderLayout.SOUTH);
    }
}