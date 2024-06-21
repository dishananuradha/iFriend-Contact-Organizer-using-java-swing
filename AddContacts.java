import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

class AddContacts extends JFrame{
    private JTextField txtContactId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthDay;

    private JButton btnAdd;
    private JButton btnCancel;
    private JButton btnBackToHome;

    public AddContacts(JFrame parent){
        setTitle("Add Contact");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int xOffset = -400;
        int yOffset = 100;
        Point parentLocation = parent.getLocation();
        setLocation(parentLocation.x + parent.getWidth() + xOffset, parentLocation.y + yOffset);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel lblTitle = new JLabel("Add Contact");
            lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
            lblTitle.setForeground(Color.BLUE);
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            panel1.add(lblTitle);

        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel(new GridLayout(6, 2, 5, 20));
        panel2.setBorder(new EmptyBorder(10, 60, 10, 60));

            JLabel lblContactId = new JLabel("Contact Id");
            lblContactId.setFont(new Font("Arial", Font.BOLD, 14));
            lblContactId.setForeground(Color.BLUE);
            lblContactId.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblContactId);

            txtContactId = new JTextField();
            txtContactId.setFont(new Font("Arial", Font.PLAIN, 14));
            txtContactId.setForeground(Color.BLACK);
            txtContactId.setHorizontalAlignment(JTextField.LEFT);
            txtContactId.setText(ContactController.generateContactId());
            txtContactId.setEditable(false);
            panel2.add(txtContactId);

            JLabel lblName = new JLabel("Name");
            lblName.setFont(new Font("Arial", Font.BOLD, 14));
            lblName.setForeground(Color.BLUE);
            lblName.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblName);
            
            txtName = new JTextField();
            txtName.setFont(new Font("Arial", Font.PLAIN, 14));
            txtName.setForeground(Color.BLACK);
            txtName.setHorizontalAlignment(JTextField.LEFT);
            txtName.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String name = txtName.getText().toLowerCase();
                    if (ContactController.isValidName(name)) {
                        txtContactNumber.requestFocus(); // Move focus to the next text field
                    } else {
                        int option = JOptionPane.showConfirmDialog(
                            AddContacts.this,
                            "Name cannot be empty. Do you want to input the name again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtName.setText(""); // Clear the text field
                            txtName.requestFocus(); // Request focus to the text field
                        } else {
                            ContactController.idCount--;
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
            panel2.add(txtName);

            JLabel lblContactNumber = new JLabel("Contact Number");
            lblContactNumber.setFont(new Font("Arial", Font.BOLD, 14));
            lblContactNumber.setForeground(Color.BLUE);
            lblContactNumber.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblContactNumber);

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
                            AddContacts.this,
                            "Invalid or empty phone number. Do you want to input phone number again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtContactNumber.setText("");
                            txtContactNumber.requestFocus(); // Request focus to let user re-enter
                        } else {
                            ContactController.idCount--;
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
                            AddContacts.this,
                            "Phone number is a duplicate. Do you want to input phone number again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtContactNumber.setText("");
                            txtContactNumber.requestFocus(); // Request focus to let user re-enter
                        } else {
                            ContactController.idCount--;
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
            panel2.add(txtContactNumber);
        

            JLabel lblCompanyName = new JLabel("Company Name");
            lblCompanyName.setFont(new Font("Arial", Font.BOLD, 14));
            lblCompanyName.setForeground(Color.BLUE);
            lblCompanyName.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblCompanyName);

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
                            AddContacts.this,
                            "Company name cannot be empty. Do you want to input the company name again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtCompanyName.setText(""); // Clear the text field
                            txtCompanyName.requestFocus(); // Request focus to the text field
                        } else {
                            ContactController.idCount--;
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
            panel2.add(txtCompanyName);

            JLabel lblSalary = new JLabel("Salary");
            lblSalary.setFont(new Font("Arial", Font.BOLD, 14));
            lblSalary.setForeground(Color.BLUE);
            lblSalary.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblSalary);

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
                            AddContacts.this,
                            "Salary cannot be negative. Do you want to input salary again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtSalary.setText("");
                            txtSalary.requestFocus(); // Request focus to let user re-enter
                        } else {
                            ContactController.idCount--;
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
            panel2.add(txtSalary);

            JLabel lblBirthDay = new JLabel("Birth Day");
            lblBirthDay.setFont(new Font("Arial", Font.BOLD, 14));
            lblBirthDay.setForeground(Color.BLUE);
            lblBirthDay.setHorizontalAlignment(JLabel.LEFT);
            panel2.add(lblBirthDay);

            txtBirthDay = new JTextField();
            txtBirthDay.setFont(new Font("Arial", Font.PLAIN, 14));
            txtBirthDay.setForeground(Color.BLACK);
            txtBirthDay.setHorizontalAlignment(JTextField.LEFT);
            txtBirthDay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    String birthDay = txtBirthDay.getText();
                    if (ContactController.isValidBirthDay(birthDay)) {
                        btnAdd.requestFocus(); // Move focus to the Add button
                    } else {
                        int option = JOptionPane.showConfirmDialog(
                            AddContacts.this,
                            "Invalid birth day. Do you want to input birth day again?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            txtBirthDay.setText(""); // Clear the text field
                            txtBirthDay.requestFocus(); // Request focus to the text field
                        } else {
                            ContactController.idCount--;
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
            panel2.add(txtBirthDay);    

        add(panel2, BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new GridLayout(2,1,5,5));
        panel3.setBorder(new EmptyBorder(10, 0, 10, 60));

            JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                btnAdd = new JButton("Add");
                btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
                btnAdd.setForeground(Color.BLUE);
                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String contactId = txtContactId.getText();
                        String name = txtName.getText().toLowerCase();
                        String phoneNumber = txtContactNumber.getText();
                        String companyName = txtCompanyName.getText();
                        double salary = Double.parseDouble(txtSalary.getText());
                        String birthDay = txtBirthDay.getText();

                        Contact contact = new Contact();
                        contact.setContactId(contactId);
                        contact.setName(name);
                        contact.setPhoneNumber(phoneNumber);
                        contact.setCompanyName(companyName);
                        contact.setSalary(salary);
                        contact.setBirthDay(birthDay);

                        ContactController.addContact(contact);

                        JOptionPane.showMessageDialog(
                            AddContacts.this,
                            "Contact added successfully",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                        
                        txtContactId.setText(ContactController.generateContactId());
                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompanyName.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                });
                panel4.add(btnAdd);

                btnCancel = new JButton("Cancel");
                btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
                btnCancel.setForeground(Color.BLUE);
                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompanyName.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                });
                panel4.add(btnCancel);

            panel3.add(panel4);

            JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                btnBackToHome = new JButton("Back to Home");
                btnBackToHome.setFont(new Font("Arial", Font.BOLD, 14));
                btnBackToHome.setForeground(Color.BLUE);
                btnBackToHome.setPreferredSize(new Dimension(148, 30));
                btnBackToHome.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        ContactController.idCount--;
                        txtName.setText("");
                        txtContactNumber.setText("");
                        txtCompanyName.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                        dispose();
                    }
                });
                panel5.add(btnBackToHome);

            panel3.add(panel5);

        add(panel3, BorderLayout.SOUTH);
    }
}