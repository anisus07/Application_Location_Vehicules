
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Connection1 {
   static Connection con;
    Connection connect;
   
    
    public   Connection1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de connexion au serveur");
        }
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de connexion à la BDD");
        }
    }

    public static Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "");
    
           
        
    }catch(Exception ex){
    System.out.println(""+ex);
    
    }
    return con;
    }
    
    
     public Connection connecterBD(){
        return connect;
    }
     
    
    public static void main(String[] args) {
        Connection1 c= new Connection1();
        c.connecterBD();
        
    }

}