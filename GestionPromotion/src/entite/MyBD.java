/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import entite.*;
import gestionpromotion.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class MyBD {
 
/**
 *
 * 
 */

   private static MyBD instance;
    private Connection cnx ;
    
     final String url = "jdbc:mysql://127.0.0.1/pepiniere";
    final String login = "root";
    final String password = "";

    private MyBD(){
       try {    
           cnx = DriverManager.getConnection(url, login, password);
           System.out.println("connexion établie!!!!");
       } catch (SQLException ex) {
           Logger.getLogger(MyBD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static  MyBD getInstance() throws SQLException{
        if(instance==null)
        instance = new MyBD();
        
        return instance;
    }
   
    
}


