import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

class ListByName extends JFrame{
    private JButton btnReload;
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;

    public ListByName(JFrame parent){
        setTitle("List By Name");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int xOffset = -400;
        int yOffset = 100;
        Point parentLocation = parent.getLocation();
        setLocation(parentLocation.x + parent.getWidth() + xOffset, parentLocation.y + yOffset);

        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel lblTitle = new JLabel("List By Name");
            lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
            lblTitle.setForeground(Color.BLUE);
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            titlePanel.add(lblTitle);

        add(titlePanel, BorderLayout.NORTH);

        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));

            btnReload = new JButton("Reload");
            btnReload.setFont(new Font("Arial", Font.BOLD, 14));
            btnReload.setForeground(Color.BLUE);
            btnReload.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    dtm.setRowCount(0);
                    Contact[] contacts = ContactController.sortByName();
                    for (int i = 0; i < contacts.length; i++) {
                        Contact contact = contacts[i];
                        Object[] row = {contact.getContactId(), contact.getName(), contact.getPhoneNumber(), contact.getCompanyName(), contact.getSalary(), contact.getBirthDay()};
                        dtm.addRow(row);
                    }
                }
            });
            panel1.add(btnReload);

        add(panel1, BorderLayout.SOUTH);

        String[] columnNames = {"Contact ID", "Name", "Phone Number", "Company Name", "Salary", "Birth Day"};
        dtm = new DefaultTableModel(columnNames, 10);
        tblCustomerDetails = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(tblCustomerDetails);
        add(scrollPane, BorderLayout.CENTER);
    }
}