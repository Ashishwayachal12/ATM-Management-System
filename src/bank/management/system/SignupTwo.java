package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    // Declare global variables
    JTextField Pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, Category, occupation, education, income;
    String formno;

    // Constructor to initialize the form with the passed form number
    SignupTwo(String formno) {
        this.formno = formno;

        // Set Nimbus Look and Feel for a consistent appearance
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Set frame title and layout
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE: 2");
        setLayout(null);

        // Load and set background image
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

        // Add page title label
        JLabel additionalDetails = new JLabel("Page 2: Additional Details", SwingConstants.CENTER);
        additionalDetails.setFont(new Font("Segoe UI", Font.BOLD, 22));
        additionalDetails.setForeground(Color.red);
        additionalDetails.setBounds(290, 80, 400, 30);
        background.add(additionalDetails);

        // Religion label and dropdown
        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Roboto", Font.BOLD, 20));
        Religion.setForeground(Color.WHITE);
        Religion.setBounds(100, 140, 100, 30);
        background.add(Religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        background.add(religion);

       
JLabel categoryLabel = new JLabel("Category:");
categoryLabel.setFont(new Font("Roboto", Font.BOLD, 20));
categoryLabel.setForeground(Color.WHITE);
categoryLabel.setBounds(100, 190, 200, 30);
background.add(categoryLabel);

String[] valCategory = {"General", "OBC", "SC", "ST", "Others"};
JComboBox<String> categoryComboBox = new JComboBox<>(valCategory);
categoryComboBox.setBounds(300, 190, 400, 30);
background.add(categoryComboBox);


       
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Roboto", Font.BOLD, 20));
        Income.setForeground(Color.WHITE);
        Income.setBounds(100, 240, 200, 30);
        background.add(Income);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30); 
        background.add(income);

        
        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Roboto", Font.BOLD, 20));
        Educational.setForeground(Color.WHITE);
        Educational.setBounds(100, 290, 200, 30);
        background.add(Educational);

        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Roboto", Font.BOLD, 20));
        Qualification.setForeground(Color.WHITE);
        Qualification.setBounds(100, 315, 200, 30);
        background.add(Qualification);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30); 
        background.add(education);

       
        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Roboto", Font.BOLD, 20));
        Occupation.setForeground(Color.WHITE);
        Occupation.setBounds(100, 390, 200, 30);
        background.add(Occupation);

        String occupationValues[] = {"Salaried", "Self-employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30); 
        background.add(occupation);

        
        JLabel pannumber = new JLabel("PAN Number:");
        pannumber.setFont(new Font("Roboto", Font.BOLD, 20));
        pannumber.setForeground(Color.WHITE);
        pannumber.setBounds(100, 440, 200, 30);
        background.add(pannumber);

        Pan = new JTextField();
        Pan.setFont(new Font("Roboto", Font.PLAIN, 14));
        Pan.setBounds(300, 440, 400, 30);
        background.add(Pan);

        // Aadhar Number label and text field
        JLabel AadharNumber = new JLabel("Aadhar Number:");
        AadharNumber.setFont(new Font("Roboto", Font.BOLD, 20));
        AadharNumber.setForeground(Color.WHITE);
        AadharNumber.setBounds(100, 490, 200, 30);
        background.add(AadharNumber);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Roboto", Font.PLAIN, 14));
        aadhar.setBounds(300, 490, 400, 30);
        background.add(aadhar);

        // Senior Citizen label and radio buttons
        JLabel SeniorCitizen = new JLabel("Senior Citizen:");
        SeniorCitizen.setFont(new Font("Roboto", Font.BOLD, 20));
        SeniorCitizen.setForeground(Color.WHITE);
        SeniorCitizen.setBounds(100, 540, 200, 30);
        background.add(SeniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        syes.setForeground(Color.white);
        background.add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        sno.setForeground(Color.white);
        background.add(sno);

        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

      
        JLabel ExistingAccount = new JLabel("Existing Account:");
        ExistingAccount.setFont(new Font("Roboto", Font.BOLD, 20));
        ExistingAccount.setForeground(Color.WHITE);
        ExistingAccount.setBounds(100, 590, 200, 30);
        background.add(ExistingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        eyes.setForeground(Color.white);
        background.add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        eno.setForeground(Color.white);
        background.add(eno);

        // Group Existing Account radio buttons
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        // Next button to proceed to the next form
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Roboto", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        background.add(next);

        // Set frame size, location, and visibility
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    // ActionListener method to handle the Next button click
    public void actionPerformed(ActionEvent ae) {
        // Retrieve form data
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) Category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;

        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = Pan.getText();
        String saadhar = aadhar.getText();

        // Save the form data to the database
        try {
            conn c = new conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" + existingaccount + "')";
            c.s.executeUpdate(query);
            
            // Proceed to the next signup form
            setVisible(false);
            new signupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
