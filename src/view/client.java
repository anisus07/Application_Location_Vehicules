/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Connection1;

/**
 *
 * @author Hanafi
 */
public class client extends javax.swing.JFrame {
Connection1 co= new Connection1();
    Statement st;
    ResultSet rs;
    DefaultTableModel model= new DefaultTableModel();
    
    public client() {
         initComponents();
         icon();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setResizable(false);
      try { 
         st=co.connecterBD().createStatement();
            rs=st.executeQuery("select*from client");
            // l'ajout des collonnes au modele 
            model.addColumn("numpermis");
            model.addColumn("nom");
            model.addColumn("prenom");
            model.addColumn("datenaiss");
            model.addColumn("adresse");
            model.addColumn("numtel");
           
            
            // l'ajout des lignes dans le model 
            while (rs.next() ) {                
                model.addRow(new Object[]{rs.getObject("numpermis"),
                    rs.getObject("nom"),
                    rs.getObject("prenom"),
                    rs.getObject("datenaiss"),
                    rs.getObject("adresse"),
                    rs.getObject("numtel"),
                    }); 
                
                
            }
            tableSt.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("logo.png")));
    }
    public void actualisation(){
        model.setRowCount(0);
        model.setColumnCount(0);
        try { 
         st=co.connecterBD().createStatement();
            rs=st.executeQuery("select*from client");
            // l'ajout des collonnes au modele 
            model.addColumn("numpermis");
            model.addColumn("nom");
            model.addColumn("prenom");
            model.addColumn("datenaiss");
            model.addColumn("adresse");
            model.addColumn("numtel");
           
            
            // l'ajout des lignes dans le model 
            while (rs.next() ) {                
                model.addRow(new Object[]{rs.getObject("numpermis"),
                    rs.getObject("nom"),
                    rs.getObject("prenom"),
                    rs.getObject("datenaiss"),
                    rs.getObject("adresse"),
                    rs.getObject("numtel"),
                    }); 
                
                
            }
            tableSt.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }public void affiche(int l){
        nump.setText(tableSt.getValueAt(l, 0).toString());
        nom.setText(tableSt.getValueAt(l, 1).toString());
        prenom.setText(tableSt.getValueAt(l, 2).toString());
        datenais.setText(tableSt.getValueAt(l, 3).toString());
        adresse.setText(tableSt.getValueAt(l, 4).toString());
       numtel.setText(tableSt.getValueAt(l, 5).toString());
       ;
    }
     public void viderFormulaire() {
        nump.setText(null);
        nom.setText(null);
        prenom.setText(null);
        datenais.setText(null);
        adresse.setText(null);
        numtel.setText(null);
        
        
        
    }
      public void FindClient(JComboBox combo) {
        try {
            st = co.connecterBD().createStatement();
            String sql = "select numpermis  from client";
            rs = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rs.next()) {

                ar.add(rs.getString("numpermis").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }

 ArrayList<String> Rplace(ArrayList<String> ar) {
        ArrayList<String> rpl = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < ar.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (ar.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(ar.get(K));
            }
            K++;
        }

        return rpl;
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        trech = new javax.swing.JTextField();
        ajout = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        modif = new javax.swing.JButton();
        numtel = new javax.swing.JTextField();
        sup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        datenais = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nump = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSt = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1320, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel8.setText("Liste Clients:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 162, 33));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel4.setText("Adresse");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 292, 120, -1));

        adresse.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresseActionPerformed(evt);
            }
        });
        getContentPane().add(adresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 290, 260, 37));

        trech.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        trech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trechActionPerformed(evt);
            }
        });
        trech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                trechKeyReleased(evt);
            }
        });
        getContentPane().add(trech, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 300, 36));

        ajout.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        ajout.setForeground(new java.awt.Color(0, 153, 153));
        ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/addd.png"))); // NOI18N
        ajout.setText("Ajouter");
        ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutActionPerformed(evt);
            }
        });
        getContentPane().add(ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 181, 50));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel9.setText("Numéro Téléphone");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 338, -1, -1));

        modif.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        modif.setForeground(new java.awt.Color(0, 153, 153));
        modif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/modifier.png"))); // NOI18N
        modif.setText("Modifier");
        modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifActionPerformed(evt);
            }
        });
        getContentPane().add(modif, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 50));

        numtel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        numtel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtelActionPerformed(evt);
            }
        });
        getContentPane().add(numtel, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 338, 260, 33));

        sup.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        sup.setForeground(new java.awt.Color(0, 153, 153));
        sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/supprimer.png"))); // NOI18N
        sup.setText("Supprimer");
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });
        getContentPane().add(sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, 50));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel6.setText("Nom");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 174, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel2.setText("Prenom");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 214, -1, -1));

        prenom.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 214, 260, 32));

        datenais.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        datenais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datenaisActionPerformed(evt);
            }
        });
        getContentPane().add(datenais, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 252, 260, 32));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel3.setText("Date de naissance");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 252, -1, -1));

        nom.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 176, 260, 33));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel1.setText("Numéro permis");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 134, -1, -1));

        nump.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        nump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numpActionPerformed(evt);
            }
        });
        getContentPane().add(nump, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 138, 260, 29));

        tableSt.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        tableSt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 650, 324));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel5.setText("Recherche:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel7.setText("Veuillez renseignez les champs suivant:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 78, 570, 45));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresseActionPerformed

    private void ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutActionPerformed
 try {
            st=co.connecterBD().createStatement();
            st.executeUpdate ("insert into client(numpermis,nom,prenom,datenaiss,adresse,numtel)values('"+
                    nump.getText()
                +"','"+ nom.getText()+"','"+
                prenom.getText()+"','"+datenais.getText()+"','"+adresse.getText()+"','"+numtel.getText()+"')");
            JOptionPane.showMessageDialog(this,"Ajout fait avec succés");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Echec de L'ajout"+ex.getMessage());
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualisation();
        viderFormulaire();
    }//GEN-LAST:event_ajoutActionPerformed

    private void modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifActionPerformed
if (JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment Modifier",
                "Confirme",   JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            try {
                st=co.connecterBD().createStatement();
                st.executeUpdate(" Update client set numpermis= '"+nump.getText() +"',Nom='"+nom.getText()
                        + "',prenom='" + prenom.getText()+"' , datenaiss='" +datenais.getText()+"' , Adresse='" +adresse.getText()+"' , numtel='" +numtel.getText()+
                        "' where numpermis= '"+tableSt.getValueAt(tableSt.getSelectedRow(),0 )+ "'");
                  JOptionPane.showMessageDialog(this, "Modification avec succés");
           actualisation();
                  viderFormulaire();
           
            } catch (SQLException ex) {
                   JOptionPane.showConfirmDialog(this, "Echec de la modification"+ex.getMessage());
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
    }//GEN-LAST:event_modifActionPerformed

    private void numtelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numtelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numtelActionPerformed

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
 if (JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment Supprimer","Confirme",
                JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION) {
              try {
            st=co.connecterBD().createStatement();
            st.executeUpdate("Delete from client where numpermis= '"+
         tableSt.getValueAt(tableSt.getSelectedRow(),0) + "'"); 
            JOptionPane.showMessageDialog(this, "Suppression réussi");
             actualisation();
             viderFormulaire();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, "Echec de la suppression"+ex.getMessage());
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
            
        }
    }//GEN-LAST:event_supActionPerformed

    private void datenaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datenaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datenaisActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void numpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numpActionPerformed

    private void tableStMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStMouseClicked
       affiche(tableSt.getSelectedRow());
    }//GEN-LAST:event_tableStMouseClicked

    private void trechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trechKeyReleased
       DefaultTableModel table =(DefaultTableModel)tableSt.getModel();
       
        String search=trech.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(table);
        tableSt.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_trechKeyReleased

    private void trechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trechActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JButton ajout;
    private javax.swing.JTextField datenais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modif;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nump;
    private javax.swing.JTextField numtel;
    private javax.swing.JTextField prenom;
    private javax.swing.JButton sup;
    private javax.swing.JTable tableSt;
    private javax.swing.JTextField trech;
    // End of variables declaration//GEN-END:variables
}
