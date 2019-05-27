/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import  java.sql.PreparedStatement ;
import  java.sql.ResultSet ;
import  java.util.ArrayList ;
import Utils.MyDBcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDBcon;
import entites.Question;
import entites.Reclamation;
import entites.RendezVous;
import entites.Vote;
import entites.Reponse;
import entites.utiliobjet;


/**
 *
 * @author pc hp
 */
public class UtiliseObjetService {
    Connection cnx;
    
    public  UtiliseObjetService () throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
   
   
    
      public ArrayList < utiliobjet >  getiduserdb () throws SQLException {
       ArrayList < utiliobjet > retour =  new  ArrayList <> ();
       Statement stm = cnx.createStatement();
        String req =  " select id_questiondb, id_reponsedb, id_userdb FROM utiliobjet LIMIT 1 " ;
        ResultSet resultat = stm . executeQuery (req);
        while (resultat . next ()) {
           int id_userdb = resultat . getInt ( " id_userdb " );
           int id_questiondb = resultat . getInt ( " id_questiondb " );
           int id_reponsedb = resultat . getInt ( " id_reponsedb " );
           retour . add ( new  utiliobjet (id_questiondb, id_reponsedb, id_userdb));
            
        }
        return retour;
            
       
    
   }
  
    public void setiduserdb(int id)
    {
        try {
            String req = "UPDATE utiliobjet set top 1 id_userdb=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
             
    
   public ArrayList<utiliobjet> getidquestiondb() throws SQLException {
       ArrayList<utiliobjet> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "select id_questiondb,id_reponsedb,id_userdb FROM utiliobjet LIMIT 1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_userdb= resultat.getInt("id_userdb");
           int id_questiondb= resultat.getInt("id_questiondb");
           int id_reponsedb= resultat.getInt("id_reponsedb");
           retour.add(new utiliobjet(id_questiondb,id_reponsedb,id_userdb));
            
        }
            
        return retour;
    
   }
    
    
    public void setidquestiondb(int id)
    {
        try {
            String req = "UPDATE utiliobjet set id_questiondb=? LIMIT 1";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
    public ArrayList<utiliobjet> getidreponsedb() throws SQLException {
       ArrayList<utiliobjet> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "select id_questiondb,id_reponsedb,id_userdb FROM utiliobjet LIMIT 1";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_userdb= resultat.getInt("id_userdb");
           int id_questiondb= resultat.getInt("id_questiondb");
           int id_reponsedb= resultat.getInt("id_reponsedb");
           retour.add(new utiliobjet(id_questiondb,id_reponsedb,id_userdb));
            
        }
            
        return retour;
    
   }
    
   public void setidreponsedb(int id)
    {
        try {
            String req = "UPDATE utiliobjet set id_reponsedb=? LIMIT 1";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtiliseObjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
}
