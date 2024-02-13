package bank.management.system;
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
          c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root" , "Baldev@2002#$%^&*");
          s= c.createStatement();
        }catch (SQLException e) {
            System.out.println("Error creating connection or statement: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
