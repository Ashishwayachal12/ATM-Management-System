
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    JButton deposit,Withdrowl,fastcash,ministatement,pinchange,balanceEnquiry,exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
      JLabel text = new JLabel("SELECT  WITHDRAWL AMOUNT");
      text.setBounds(220, 300, 700, 35);
      text.setForeground(Color.WHITE); // Sets the text color
      text.setFont(new Font("System", Font.BOLD, 16)); // Sets the font
      image.add(text);
     
       deposit=new JButton("Rs 100");
      deposit.setBounds(170,415,150,30);
      deposit.addActionListener(this);
      image.add(deposit);
      
       Withdrowl=new JButton("Rs 500");
      Withdrowl.setBounds(355,415,150,30);
      Withdrowl.addActionListener(this);
      image.add(Withdrowl);
      
       fastcash=new JButton("Rs 1000");
      fastcash.setBounds(170,450,150,30);
      fastcash.addActionListener(this);
      image.add(fastcash);
      
      
        ministatement=new JButton("Rs 2000");
      ministatement.setBounds(355,450,150,30);
      ministatement.addActionListener(this);
      image.add(ministatement);
      
       pinchange=new JButton(" Rs 5000");
      pinchange.setBounds(170,485,150,30);
      pinchange.addActionListener(this);
      image.add(pinchange);
      
        balanceEnquiry=new JButton(" Rs 10000");
      balanceEnquiry.setBounds(355,485,150,30);
      balanceEnquiry.addActionListener(this);
      image.add(balanceEnquiry);
      
        exit=new JButton(" Back");
      exit.setBounds(355,520,150,30);
      exit.addActionListener(this);
      image.add(exit);
        
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == exit){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    } else {
        // Dynamic amount extraction
        String amountStr = ((JButton) ae.getSource()).getText().substring(3); // Get the amount from the button text
        double amount = Double.parseDouble(amountStr); // Parse the amount as a double
        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE Pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("transaction_type").equals("deposit")){
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }

            if(ae.getSource() != exit && balance < amount){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
            c.s.executeUpdate(query);  // Use executeUpdate for INSERT/UPDATE/DELETE

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


    
    public static void main(String[]args){
        new Fastcash("");
    }
}
