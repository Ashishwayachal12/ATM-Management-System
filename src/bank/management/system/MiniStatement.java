package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exitButton;
    JLabel transactionsLabel, cardLabel, balanceLabel;
    
    MiniStatement(String pinnumber) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);  // Custom layout without using layout manager
        
        // Bank name label
        JLabel bankLabel = new JLabel("Scoti Bank");
        bankLabel.setBounds(130, 20, 200, 30);
        bankLabel.setFont(new Font("Arial", Font.BOLD, 18));  // Larger and bold font
        add(bankLabel);
        
        // Card number label
        cardLabel = new JLabel();
        cardLabel.setBounds(20, 60, 350, 30);
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(cardLabel);
        
        // Transactions label
        transactionsLabel = new JLabel();
        transactionsLabel.setVerticalAlignment(SwingConstants.TOP);  
        transactionsLabel.setBounds(20, 100, 350, 300);  
        transactionsLabel.setFont(new Font("Arial", Font.PLAIN, 12));  
        add(transactionsLabel);
        
        // Balance label
        balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 420, 350, 30);  // Align balance towards the bottom
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));  // Bold font for balance
        add(balanceLabel);
        
        // Exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(150, 480, 100, 30);
        add(exitButton);
        exitButton.addActionListener(this);
        
        // Database connection and data fetching
        conn c = new conn();
        
        try {
            // Fetch card number based on PIN number
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pinnumber = '" + pinnumber + "'");
            if (rs.next()) {
                cardLabel.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // Fetch transactions
            double balanceEnquiry = 0;
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder("<html>");
            
            while (rs.next()) {
                String date = rs.getString("date");
                String transactionType = rs.getString("transaction_type");
                String amount = rs.getString("amount");

                // Append transaction details in HTML format for proper display
                statement.append(date)
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(transactionType)
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(amount)
                         .append("<br><br>");
                
                // Correctly handle the balance calculation
                if (transactionType.equalsIgnoreCase("Deposit")) {
                    balanceEnquiry += Double.parseDouble(amount);
                } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
                    balanceEnquiry -= Double.parseDouble(amount);
                }
            }
            
            statement.append("</html>");
            
            // Set the transactions and balance text
            transactionsLabel.setText(statement.toString());
            balanceLabel.setText("Your current account balance is Rs " + balanceEnquiry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);  
    }
    
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
