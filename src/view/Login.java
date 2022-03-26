
package view;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Connection1;
import view.Main_frame;

/**
 *
 * @author Anis
 */
public class Login extends javax.swing.JFrame {
Connection1 co= new Connection1();
    Statement st;
    ResultSet rs;
   
    DefaultTableModel model= new DefaultTableModel();
    /**
     * Creates new form NewJFrame
     */
    public Login() {
        initComponents();
         icon();
        
    }
   void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("logo.png")));
    }
public int FindUser(String user, String password) {
        int re = 0;
        try {
            st = co.connecterBD().createStatement();
            String sql = "select * from user where id_user=1";
            rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("user").equals(user) && rs.getString("password").equals(password)) {
                    re = 1;
                } else {
                    re = 0;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de récuperation");
        }

        return re;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btncnx = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 34, 97));
        jLabel4.setText("Authentification");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 300, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 34, 97)), "Veuillez vous connecter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 24), new java.awt.Color(38, 34, 97))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Utilisateur");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 190, 40));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Mot de passe");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        btncnx.setBackground(new java.awt.Color(38, 34, 97));
        btncnx.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btncnx.setForeground(new java.awt.Color(38, 34, 97));
        btncnx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/aaa.png"))); // NOI18N
        btncnx.setText("Connexion");
        btncnx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncnxActionPerformed(evt);
            }
        });
        jPanel2.add(btncnx, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 190, -1));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 190, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 480, 360));
        jPanel2.getAccessibleContext().setAccessibleName("Veuillez vous connecter !");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/fond grand.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed
ConnectDB db=new ConnectDB();
    private void btncnxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncnxActionPerformed
        try{     
      if(  FindUser(jTextField1.getText().toString(), jPasswordField1.getText().toString())==1)
    {Main_frame mf=new Main_frame();mf.setVisible(true);
       this.setVisible(false);
    }else
      {
      JOptionPane.showMessageDialog(null, "Erreur, le nom d'utilisateur ou le mot de passe est incorrecte");
      }
}catch(Exception e){
     JOptionPane.showMessageDialog(null, "Erreur, vérifier vos données");
}
    }//GEN-LAST:event_btncnxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
db.ConnexionIntoDataBase();// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncnx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}