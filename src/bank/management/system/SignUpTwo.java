package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {


    JTextField    pan, addhar;

    JButton next;

    JRadioButton syes, sno , eyes, eno;

    JComboBox religion,category,incomecategory,educationalvalues , occupation;

    String formno;

    SignUpTwo(String formnno) {

         this.formno = formnno;
        setLayout(null);

//        Random ran = new Random();
//        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        setTitle("New Account Application Form Page-2");


        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
        additionalDetails.setBounds(250, 80, 400, 30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Raleway", Font.BOLD, 15));
        Religion.setBounds(100, 140, 100, 30);
        add(Religion);

        String[] valReligion = {"Hindu" , "Muslim" , "Sikh" , "Christian" , "Other"};
         religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel Category = new JLabel("Category :");
        Category.setFont(new Font("Raleway", Font.BOLD, 15));
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        String[] valCategory = {"General" , "OBC" , "ST" , "SC" , "Other"};
         category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel Income = new JLabel("Income :");
        Income.setFont(new Font("Raleway", Font.BOLD, 15));
        Income.setBounds(100, 240, 100, 30);
        add(Income);

        String[] incomeCategory = {"NULL" , "<1,50,000" , "<2,50,000" , "<8,00,000" , ">8,00,000"};
         incomecategory = new JComboBox<>(incomeCategory);
        incomecategory.setBounds(300, 240, 400, 30);
        incomecategory.setBackground(Color.WHITE);
        add(incomecategory);

        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Raleway", Font.BOLD, 15));
        Educational.setBounds(100, 305, 100, 30);
        add(Educational);



        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 15));
        Qualification.setBounds(100, 330, 100, 30);
        add(Qualification);

        String[] educationalVals = {"Non-Graduate" , "Graduate" , "Post-Graduate" , "Doctrate" , "Other"};
         educationalvalues = new JComboBox<>(educationalVals);
        educationalvalues.setBounds(300, 315, 400, 30);
        educationalvalues.setBackground(Color.WHITE);
        add(educationalvalues);


        JLabel Occupation = new JLabel("Occupation :");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 15));
        Occupation.setBounds(100, 390, 220, 30);
        add(Occupation);

        String[] occupationValues = {"Salaried" , "Self-Employed" , "Bussiness" , "Student" , "Other"};
         occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel pannum = new JLabel("PAN:");
        pannum.setFont(new Font("Raleway", Font.BOLD, 15));
        pannum.setBounds(100, 440, 100, 30);
        add(pannum);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 15));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel adharnum = new JLabel("Addhar:");
        adharnum.setFont(new Font("Raleway", Font.BOLD, 15));
        adharnum.setBounds(100, 490, 100, 30);
        add(adharnum);

        addhar = new JTextField();
        addhar.setFont(new Font("Raleway", Font.BOLD, 15));
        addhar.setBounds(300, 490, 400, 30);
        add(addhar);

        JLabel SeniorC = new JLabel("Senior Citizen :");
        SeniorC.setFont(new Font("Raleway", Font.BOLD, 15));
        SeniorC.setBounds(100, 540, 200, 30);
        add(SeniorC);

        syes = new JRadioButton("Yes");
        syes.setBounds(300 , 540 , 100 , 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450 , 540 , 100 , 30);
        sno.setBackground(Color.white);
        add(sno);


        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);



        JLabel ExistingAcc = new JLabel("Existing Account:");
        ExistingAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        ExistingAcc.setBounds(100, 590, 200, 30);
        add(ExistingAcc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300 , 590 , 100 , 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450 , 590 , 100 , 30);
        eno.setBackground(Color.white);
        add(eno);


        ButtonGroup exisitingAcc = new ButtonGroup();
        exisitingAcc.add(eyes);
        exisitingAcc.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
//        String formno = "" ;// long
        String Religion = (String) religion.getSelectedItem();
        String Category = (String) category.getSelectedItem();
        String Income = (String) incomecategory.getSelectedItem();
        String Qualification = (String) educationalvalues.getSelectedItem();
        String Occupation = (String) occupation.getSelectedItem();


        String seniorCititzen = null;
        if (sno.isSelected()) {
            seniorCititzen = "No";
        } else if (syes.isSelected()) {
            seniorCititzen = "Yes";
        }


        String exisitingAcc = null;
        if (eyes.isSelected()) {
            exisitingAcc = "Yes";
        } else if (eno.isSelected()) {
            exisitingAcc = "No";
        }

        String pannum = pan.getText();
        String adharnum = addhar.getText();



        try {
            if (Occupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values ('" + formno + "', '" + Religion + "' , '" + Category + "' , '" + Income + "','" + Qualification + "', '" + Occupation + "' , '" + pannum + "' , '" + adharnum + "' ,'" + seniorCititzen + "' , '" + exisitingAcc + "'  )";
                c.s.executeUpdate(query);

                setVisible(false);
                new  SignUpThree(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
