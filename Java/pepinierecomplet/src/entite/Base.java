/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raed
 */
public class Base {
   private static Base instance;
    private Connection cnx ;
     final String url = "jdbc:mysql://127.0.0.1/pepiniere";
    final String login = "root";
    final String password = "";

    private Base(){
       try {    
           cnx = DriverManager.getConnection(url, login, password);
           System.out.println("Connected.");
       } catch (SQLException ex) {
           Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static  Base getInstance() throws SQLException{
        if(instance==null)
        instance = new Base();
        
        return instance;
    }
   
    
}

