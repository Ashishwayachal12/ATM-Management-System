package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    // Constructor to accept the PIN number
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber; // Initialize the PIN number
        setLayout(null);
        
        // Set up the ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Database connection and balance calculation
        conn c = new conn();
        int balanceEnquiry = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE Pin = '" + pinnumber + "'");
            
            // Loop through the transactions and calculate the balance
            while (rs.next()) {
                if (rs.getString("transaction_type").equals("deposit")) {
                   balanceEnquiry += Double.parseDouble(rs.getString("amount"));
                } else {
                   balanceEnquiry -= Double.parseDouble(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        // Display the balance
        JLabel balanceText = new JLabel("Your Current Account Balance is Rs " + balanceEnquiry);
        balanceText.setBounds(170, 300, 400, 30);
        balanceText.setForeground(Color.WHITE);
        balanceText.setFont(new Font("System", Font.BOLD, 16));
        image.add(balanceText);

        // Back button
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    // Handle button clicks (Back button)
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);  // Close this window
        new Transactions(pinnumber).setVisible(true);  // Open the Transactions window
    }

    // Main method to launch the BalanceEnquiry window
    public static void main(String[] args) {
        new BalanceEnquiry("");  // Example PIN number (replace with actual PIN)
    }
}
