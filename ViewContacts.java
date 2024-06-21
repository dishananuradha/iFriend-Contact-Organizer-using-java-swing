import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

class ViewContacts extends JFrame{
	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthday;
	private JButton btnCancel;

    private ListByName listByName;
    private ListBySalary listBySalary;
    private ListByBirthday listByBirthday;
	
	public ViewContacts(JFrame parent){
		setTitle("View Contacts");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int xOffset = -400;
        int yOffset = 100;
        Point parentLocation = parent.getLocation();
        setLocation(parentLocation.x + parent.getWidth() + xOffset, parentLocation.y + yOffset);

        JLabel lblHome = new JLabel("View Contacts");

            lblHome.setFont(new Font("Arial", Font.BOLD, 24));
            lblHome.setForeground(Color.BLUE);
            lblHome.setHorizontalAlignment(JLabel.CENTER);
            lblHome.setBorder(new EmptyBorder(10, 0, 10, 0));

        add(lblHome, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(0, 60, 0, 60));

            btnListByName = new JButton("List By Name");
            btnListByName.setFont(new Font("Arial", Font.BOLD, 14));
            btnListByName.setForeground(Color.BLUE);
            btnListByName.setHorizontalAlignment(JButton.CENTER);
            btnListByName.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    if(listByName==null){
                        listByName=new ListByName(ViewContacts.this);
                    }
                    listByName.setVisible(true);
                }
            });
            buttonPanel.add(btnListByName);

            btnListBySalary = new JButton("Update Contact");
            btnListBySalary.setFont(new Font("Arial", Font.BOLD, 14));
            btnListBySalary.setForeground(Color.BLUE);
            btnListBySalary.setHorizontalAlignment(JButton.CENTER);
            btnListBySalary.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    if(listBySalary==null){
                        listBySalary=new ListBySalary(ViewContacts.this);
                    }
                    listBySalary.setVisible(true);
                }
            });
            buttonPanel.add(btnListBySalary);

            btnListByBirthday = new JButton("Search Contact");
            btnListByBirthday.setFont(new Font("Arial", Font.BOLD, 14));
            btnListByBirthday.setForeground(Color.BLUE);
            btnListByBirthday.setHorizontalAlignment(JButton.CENTER);
            btnListByBirthday.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    if(listByBirthday==null){
                        listByBirthday=new ListByBirthday(ViewContacts.this);
                    }
                    listByBirthday.setVisible(true);
                }
            });
            buttonPanel.add(btnListByBirthday);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel cancelPanel = new JPanel();
        cancelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        cancelPanel.setBorder(new EmptyBorder(10, 0, 10, 60));

            btnCancel = new JButton("Cancel");
            btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
            btnCancel.setForeground(Color.BLUE);
            btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    dispose();
                }
            });
            cancelPanel.add(btnCancel);

        add(cancelPanel, BorderLayout.SOUTH);
	}
}