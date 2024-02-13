package bank.management.system;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{


    JButton deposit , withDrawal , fastCash , miniStatement ,pinChange , balanceEnquiry , exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Selct Your Transaction :");
        text.setBounds(225,300,700,35);
        text.setFont(new Font("Calibri" , Font.BOLD , 16));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withDrawal = new JButton("Cash Withdrawal");
        withDrawal.setForeground(Color.black);
        withDrawal.setBounds(355,415,150,30);
        withDrawal.addActionListener(this);
        image.add(withDrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setForeground(Color.black);
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setForeground(Color.black);
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setForeground(Color.black);
        pinChange.setBounds(170,480,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setForeground(Color.black);
        balanceEnquiry.setBounds(355,480,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setForeground(Color.black);
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize( 900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
            else if (ae.getSource()==withDrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
          }
        else if (ae.getSource() == fastCash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BlanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }


    }


    public static void main(String[] args) {
        new Transactions("");
    }
}
