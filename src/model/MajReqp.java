/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MajReqp {
    Connection1 c= new Connection1();
    PreparedStatement prs;
    ResultSet rs;
    
    public List<String> getIdClient() throws SQLException
    {
        List<String> s = new ArrayList<String>();
        prs=c.connecterBD().prepareStatement("select numpermis from client");
        rs=prs.executeQuery();
        while (rs.next()) {            
            s.add(rs.getString("numpermis"));
        }
    
    return s;
    }

    public List<String> getIdVehicule() throws SQLException
    {
        List<String> s = new ArrayList<String>();
        prs=c.connecterBD().prepareStatement("select matricule from vehicule");
        rs=prs.executeQuery();
        while (rs.next()) {            
            s.add(rs.getString("matricule"));
        }
    
    return s;
    }
    
}
