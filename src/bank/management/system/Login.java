package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements  ActionListener{

        JButton login , clear , signup;
        JTextField cardTextField;
        JPasswordField pinTextField;
        Login() {
            setTitle("ATM");
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel jLabel = new JLabel(i3);
            add(jLabel);
            jLabel.setBounds(70, 10, 100, 100);

            JLabel text = new JLabel("Welcome to ATM");
            text.setFont(new Font("Osward", Font.BOLD, 35));
            text.setBounds(200, 40, 400, 40);
            add(text);

            JLabel Cardno = new JLabel("Card No.");
            Cardno.setFont(new Font("Raleway", Font.BOLD, 25));
            Cardno.setBounds(90, 150, 150, 30);
            add(Cardno);

            cardTextField = new JTextField();
            cardTextField.setBounds(210, 150, 250, 30);
            cardTextField.setFont(new Font("Arial" , Font.BOLD , 15));
            add(cardTextField);

            JLabel Pin = new JLabel("Pin");
            Pin.setFont(new Font("Raleway", Font.BOLD, 25));
            Pin.setBounds(90, 220, 150, 30);
            add(Pin);

            pinTextField = new JPasswordField();
            pinTextField.setBounds(210, 220, 250, 30);
            pinTextField.setFont(new Font("Arial" , Font.BOLD , 15));
            add(pinTextField);

             login = new JButton("Login");
            login.setBounds(300, 280, 100, 30);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);

            clear = new JButton("Clear");
            clear.setBounds(420, 280, 100, 30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
            add(clear);

            signup = new JButton("Sign Up");
            signup.setBounds(350, 320, 100, 30);
            signup.setBackground(Color.BLACK);
            signup.setForeground(Color.WHITE);
            signup.addActionListener(this);
            add(signup);


            getContentPane().setBackground(Color.WHITE);

            setSize(800, 400);
            setVisible(true);
            setLocation(380, 200);
        }


    public void actionPerformed(ActionEvent ae){

            if (ae.getSource() == clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }
            else if (ae.getSource() == login){
              Conn conn = new Conn();
              String cardNumber = cardTextField.getText();
              String pinnumber = pinTextField.getText();
              String query = "select * from login where cardnumber = '" +cardNumber+"' and pinnumber = '"+pinnumber+"'";
              try {
                  ResultSet rs = conn.s.executeQuery(query);
                  if (rs.next()){
                      setVisible(false);
                      new Transactions(pinnumber).setVisible(true);
                  }
                  else {
                      JOptionPane.showMessageDialog(null , "Incorrect Card number or Pin");
                  }
              }catch (Exception e){
                  System.out.println(e);
              }
            }
            else if (ae.getSource() == signup) {
                 setVisible(false);
                 new SignUpOne().setVisible(true);
            }
            else if (ae.getSource() == signup) {
                setVisible(false);
                new SignUpOne().setVisible(true);
            }

    }

    public static void main(String[] args) {
       new Login();
    }


}
