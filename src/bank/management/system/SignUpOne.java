package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

     long random;
     JTextField nameTextField , fnameTextField , dobTextField , emailTextField , addressTextField ,  cityTextField,
             stateTextField, pincodeTextField;

     JButton  next;

     JRadioButton male, female , married , unmarried , other;

    SignUpOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway" , Font.BOLD , 38));
        formno.setBounds(140 ,20, 600 ,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway" , Font.BOLD , 25));
        personalDetails.setBounds(250 ,80, 400 ,30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway" , Font.BOLD , 20));
        name.setBounds(100 ,140, 100 ,30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        nameTextField.setBounds(300,140 ,400 ,30);
        add(nameTextField);


        JLabel fname = new JLabel("Fathers Name :");
        fname.setFont(new Font("Raleway" , Font.BOLD , 20));
        fname.setBounds(100 ,190, 200 ,30);
        add(fname);

         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        fnameTextField.setBounds(300,190 ,400 ,30);
        add(fnameTextField);

        JLabel dob = new JLabel("DOB :");
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(100 ,240, 100 ,30);
        add(dob);

         dobTextField = new JTextField();
        dobTextField.setBounds(300,240 ,200 ,30);
        add(dobTextField);


        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        gender.setBounds(100 ,290, 100 ,30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBounds(300 , 290 , 60 , 30);
        male.setBackground(Color.white);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(450 , 290 , 100 , 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(100 ,340, 100 ,30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        emailTextField.setBounds(300,340 ,400 ,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway" , Font.BOLD , 20));
        marital.setBounds(100 ,390, 220 ,30);
        add(marital);

         married = new JRadioButton("Married");
        married.setBounds(300 , 390 , 100 , 30);
        married.setBackground(Color.white);
        add(married);

         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450 , 390 , 100 , 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

         other = new JRadioButton("Other");
        other.setBounds(630 , 390 , 100 , 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway" , Font.BOLD , 20));
        address.setBounds(100 ,440, 100 ,30);
        add(address);

         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        addressTextField.setBounds(300,440 ,400 ,30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway" , Font.BOLD , 20));
        city.setBounds(100 ,490, 100 ,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        cityTextField.setBounds(300,490 ,400 ,30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(100 ,540, 100 ,30);
        add(state);

         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        stateTextField.setBounds(300,540 ,400 ,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(100 ,590, 100 ,30);
        add(pincode);

         pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway" , Font.BOLD , 15));
        pincodeTextField.setBounds(300,590 ,400 ,30);
        add(pincodeTextField);

         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway" ,Font.BOLD , 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize (850 , 800);
        setLocation(350,100);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
      String formno = "" + random;// long
      String name = nameTextField.getText();
      String fname = fnameTextField.getText();
      String dob = dobTextField.getText();

      String gender = null;
      if(male.isSelected()){
          gender = "Male";
      }else if (female.isSelected()){
          gender = "Female";
      }

      String email = emailTextField.getText();
      String matrial = null;
      if(married.isSelected()){
          matrial = "Married";
      }else if (unmarried.isSelected()){
          matrial = "Unmarried";
      }else if(other.isSelected()){
          matrial = "Other";
      }

      String address = addressTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String pin = pincodeTextField.getText();

       try {
         if(name.equals("")){
             JOptionPane.showMessageDialog(null,"Name is required");
         }else {
             Conn c = new Conn();
             String query = "insert into signup1 values ('"+formno+"', '"+name+"' , '"+fname+"' , '"+dob+"','"+gender+"', '"+email+"' , '"+matrial+"' , '"+address+"' ,'"+city+"' , '"+state+"' , '"+pin+"' )";
             System.out.println(c);
             c.s.executeUpdate(query);

             setVisible(false);
             new SignUpTwo(formno).setVisible(true);

         }

       }catch (Exception e){
           System.out.println(e);
       }

    }

    public static void main (String args[]){
        new SignUpOne();
    }
}
