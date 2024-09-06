package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dateChooser;
    JLabel pincode, state, city, address, marital, email, gender, dob, fname, name;

    SignupOne() {
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
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel background = new JLabel(scaledBackgroundIcon);
        background.setBounds(0, 0, 850, 800);
        add(background);

        // Load and set the bank logo in the top-left corner
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 10, 100, 100);
        background.add(label);

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random, SwingConstants.CENTER);
        formno.setFont(new Font("Segoe UI", Font.BOLD, 38));
        formno.setForeground(Color.red);
        formno.setBounds(140, 20, 600, 40);
        background.add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details", SwingConstants.CENTER);
        personalDetails.setFont(new Font("Segoe UI", Font.BOLD, 22));
        personalDetails.setForeground(Color.WHITE);
        personalDetails.setBounds(290, 80, 400, 30);
        background.add(personalDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Roboto", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        name.setBounds(100, 140, 100, 30);
        background.add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        background.add(nameTextField);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Roboto", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        fname.setBounds(100, 190, 200, 30);
        background.add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        background.add(fnameTextField);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Roboto", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        dob.setBounds(100, 240, 200, 30);
        background.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        background.add(dateChooser);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Roboto", Font.BOLD, 20));
        gender.setForeground(Color.WHITE);
        gender.setBounds(100, 290, 200, 30);
        background.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 80, 30);
        male.setBackground(Color.white);
        male.setForeground(Color.WHITE);
        background.add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        female.setBackground(Color.white);
        female.setForeground(Color.WHITE);
        background.add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Roboto", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        email.setBounds(100, 340, 200, 30);
        background.add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        background.add(emailTextField);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Roboto", Font.BOLD, 20));
        marital.setForeground(Color.WHITE);
        marital.setBounds(100, 390, 200, 30);
        background.add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        married.setForeground(Color.WHITE);
        background.add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.white);
        unmarried.setForeground(Color.WHITE);
        background.add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(600, 390, 100, 30);
        others.setBackground(Color.white);
        others.setForeground(Color.WHITE);
        background.add(others);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        address = new JLabel("Address:");
        address.setFont(new Font("Roboto", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        address.setBounds(100, 440, 200, 30);
        background.add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        background.add(addressTextField);

        city = new JLabel("City:");
        city.setFont(new Font("Roboto", Font.BOLD, 20));
        city.setForeground(Color.WHITE);
        city.setBounds(100, 490, 200, 30);
        background.add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        background.add(cityTextField);

        state = new JLabel("State:");
        state.setFont(new Font("Roboto", Font.BOLD, 20));
        state.setForeground(Color.WHITE);
        state.setBounds(100, 540, 200, 30);
        background.add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        background.add(stateTextField);

        pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Roboto", Font.BOLD, 20));
        pincode.setForeground(Color.WHITE);
        pincode.setBounds(100, 590, 200, 30);
        background.add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Roboto", Font.PLAIN, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        background.add(pinTextField);

        next = new JButton("Next");
        next.setBackground(new Color(0, 0, 0));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Roboto", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        background.add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (others.isSelected()) {
            marital = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                conn c = new conn();
                   String queryCon= "Select * from signup where email=email";
                boolean execute = c.s.execute(queryCon);
                if(execute){
                    System.out.println("User Found !");
                }
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + c + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new  SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
 