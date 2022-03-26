
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ConnectDB {

    private final String User = "root";
    private final String password = "";
    String ipLocal = "localhost";

    private String url = "jdbc:mysql://" + ipLocal + ":3306/location";
    private Connection cnx;
    private Statement st, jt;
    private ResultSet rst;

 
    public void ConnexionIntoDataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            try {
                cnx = DriverManager.getConnection(url, User, password);
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " Erreur connexion ,activer le serveur ou vérifier "
                        + "\nle configuration de  serveur");

            } finally {
               
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int FindUser(String user, String pass) {
        int re = 0;
        try {
            st = cnx.createStatement();
            String sql = "select * from user where id_user=1";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user) && rst.getString("password").equals(pass)) {
                    re = 1;
                } else {
                    re = 0;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + "Erreur de récuperation");
        }

        return re;
    }}
