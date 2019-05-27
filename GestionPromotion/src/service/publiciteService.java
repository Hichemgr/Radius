/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entite.MyBD;
import entite.Produit;
import entite.Promotion;
import entite.publicite;
import entite.utlisteur;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author ASUS
 */
public class publiciteService {
    Connection cnx;
    
    public publiciteService() throws SQLException {
       cnx = MyBD.getInstance().getCnx();
    }
    
         public  int ajouterAlaBase(publicite pub,Produit po) throws SQLException {
         int sr=0 ; 
         String format = "dd/MM/yy H:mm:ss"; 

java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
java.util.Date date = new java.util.Date(); 

             java.util.Date date2=new java.sql.Date(pub.getDatepub().getTime());
             
             String req = "INSERT INTO `pub`(`nompublicite`, `datepub`, `nomproduit`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,pub.getNompublicite());
             pstm.setDate(2,new java.sql.Date(pub.getDatepub().getTime()));
             pstm.setString(3,po.getNomproduit());
          
             if(date.compareTo(date2)<0){
           
           sr=  pstm.executeUpdate();
             }
             return sr; 
        

    }
         
            public ArrayList<publicite> getAllPublicites() throws SQLException {
       
             ArrayList<publicite> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM pub ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           String nompublicite = resultat.getString("nompublicite");
           Date datepub=resultat.getDate("datepub") ;    
           String nomprod = resultat.getString("nomproduit");
           retour.add(new publicite(nompublicite, datepub, nomprod)) ; 
        }
            
        return retour;
    }
           
       public  int modifier(String nompublicite,Date datepub,String nomprod) throws SQLException {
          int sr=0 ; 
             
             System.out.println("Modification");
             Statement stm = cnx.createStatement();
             String req = "UPDATE `pub` SET   `datepub`='"+datepub+"'  , `nomproduit`='"+nomprod+"' where nompublicite='"+nompublicite+"' ";
           sr=  stm.executeUpdate(req);
           return sr ;
         
        }
       
          public  int supprimer(String nompublicite) throws SQLException {
         int sr=0 ; 
             
             System.out.println("suppression");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "DELETE FROM `pub` WHERE `nompublicite`= '"+nompublicite+"' ";
            sr= stm.executeUpdate(req);
            return sr ; 
         
    }
          
          
           public ObservableList<String> getNomproduit(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select nomproduit from  produit ;";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("nomproduit"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
           
           public  ArrayList<publicite> FindPub(String rech) throws SQLException  {
       ArrayList<publicite> listpub = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `pub` where `nompublicite` Like '%"+rech+"%'  or `datepub` Like '%"+rech+"%'  or `nomproduit`Like '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         
            
              String nompublicite = resultat.getString("nompublicite");
           Date datepub = resultat.getDate("datepub") ; 
           String nomproduit = resultat.getString("nomproduit");
              
           listpub.add(new publicite(nompublicite, datepub, nomproduit));
            }
     listpub.forEach(e->System.out.println(e));
 
      return listpub;
    } 
public ArrayList<utlisteur> getAllUser2() throws SQLException {
       ArrayList<utlisteur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           
           String adressemail = resultat.getString("adressemail");
            int telephone = resultat.getInt("telephone");
           
           retour.add(new utlisteur(adressemail,telephone)) ; 
            
        }
            
        return retour;
    }
    
}
