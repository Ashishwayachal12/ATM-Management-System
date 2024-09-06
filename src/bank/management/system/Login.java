package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login() {

        // Set Nimbus Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // Load background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/background1.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel background = new JLabel(scaledBackgroundIcon);
        background.setBounds(0, 0, 800, 480);
        add(background);

        // Load and set the bank logo in the top-left corner
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 10, 100, 100);
        background.add(label);

        // Centering the text horizontally
        JLabel text = new JLabel("WELCOME TO ATM", SwingConstants.CENTER);
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setForeground(Color.red); // Set text color to red
        text.setBounds(0, 40, 800, 40); // Span the width of the window
        background.add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setForeground(Color.WHITE); // Set text color to white
        cardNo.setBounds(120, 150, 150, 30);
        background.add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        background.add(cardTextField);

        // Adding a key listener to enforce input constraints
        cardTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits and limit length to 12
                if (!Character.isDigit(c) || cardTextField.getText().length() >= 16) {
                    e.consume();  // Ignore this key event
                }
            }
        });

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setForeground(Color.WHITE); // Set text color to white
        pin.setBounds(120, 220, 230, 30);
        background.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        background.add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Montserrat", Font.BOLD, 14));
        login.setBounds(300, 300, 100, 30);
        background.add(login);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        clear.setFont(new Font("Lato", Font.BOLD, 14));
        clear.setBounds(430, 300, 100, 30);
        background.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.DARK_GRAY);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setFont(new Font("Roboto", Font.BOLD, 14));
        signup.setBounds(300, 350, 230, 30);
        background.add(signup);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
           String query = "SELECT * FROM login WHERE cardnumber='" + cardnumber + "' AND pinnumber='" + pinnumber + "';";

            try {
                conn conn = new conn();
                
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
