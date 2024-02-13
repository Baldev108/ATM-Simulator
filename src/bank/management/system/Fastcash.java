package bank.management.system;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Fastcash extends JFrame implements ActionListener{


    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;

    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Selct Amount You Want To Withdraw :");
        text.setBounds(160,300,700,35);
        text.setFont(new Font("Calibri" , Font.BOLD , 16));
        text.setForeground(Color.white);
        image.add(text);

        hundred = new JButton("100");
        hundred.setForeground(Color.BLACK);
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton(" 500");
        fiveHundred.setForeground(Color.black);
        fiveHundred.setBounds(355,415,150,30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton(" 1000");
        thousand.setForeground(Color.black);
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("2000");
        twoThousand.setForeground(Color.black);
        twoThousand.setBounds(355,450,150,30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("5000");
        fiveThousand.setForeground(Color.black);
        fiveThousand.setBounds(170,480,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("10000");
        tenThousand.setForeground(Color.black);
        tenThousand.setBounds(355,480,150,30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize( 900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String number = ((JButton) ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber =   '"+pinnumber+"'");

                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("number")) ;
                    }else{
                        balance -= Integer.parseInt(rs.getString("number")) ;
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null, "Insufficient Amount ");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values  ('"+pinnumber+"' , '"+date+"' , 'Withdraw' , '"+number+"' ) ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs  "+ number +" Debited Successfully ");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);


            }catch ( Exception e){
                System.out.println(e);
            }

        }

    }


    public static void main(String[] args) {
        new Fastcash("");
    }
}
