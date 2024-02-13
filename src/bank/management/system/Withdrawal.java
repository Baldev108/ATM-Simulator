
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{


    JTextField amount;
    JButton Withdraw, back;
    String pinnumber;



    Withdrawal(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To Withdraw ");
        text.setFont(new Font("Calibri" ,Font.BOLD ,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400,25);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,335,300,25);
        add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355,485 , 150,30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(355,520 , 150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Withdraw){

            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To Deposit");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values  ('"+pinnumber+"' , '"+date+"' , 'Withdraw' , '"+number+"' ) ";

                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null , "Rs "+number+" is Withdrawal Successfully ");

                    setVisible(false);
                    new Fastcash(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }


        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }
    }


    public static void main(String[] args) {
        new Withdrawal("");
    }
}
