package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrowl extends JFrame implements ActionListener {
    JTextField amount;
    JButton Withdrowl, back;
    String pinnumber;

    Withdrowl(String pinnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;

        // Load the ATM image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        if (i1.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Image not found, please check the path.");
        }
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Add text label
        JLabel text = new JLabel("Enter the amount you want to Withdrowl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Add input field for amount
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        // Add Deposit button
        Withdrowl = new JButton("Withdrow");
        Withdrowl.setBounds(355, 485, 150, 30);
        Withdrowl.addActionListener(this);
        image.add(Withdrowl);

        // Add Back button
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Set JFrame properties
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Withdrowl) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    conn c = new conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrowl','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrow successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrowl("");
    }
}
