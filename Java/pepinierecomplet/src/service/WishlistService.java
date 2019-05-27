/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Base;
import entite.Wishlist;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raedm
 */
public class WishlistService  {
    
    

    Connection cnx;
    
    public WishlistService() throws SQLException {
       cnx = Base.getInstance().getCnx();
       
        
    }

   public  void ajouterWAlaBase(Wishlist w, long cin) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `wishlist`( `nom`,`prix`,`cin`,`dateajout` ) VALUES ('"+w.getNom_prod()+"','"+w.getPrix_prod()+"','"+cin+"','"+w.getDateajout_wish()+"')  ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(WishlistService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public ArrayList<Wishlist> getWishlist() throws SQLException {
       ArrayList<Wishlist> lwishlist = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM wishlist ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_wish= resultat.getInt(1);
            
            String nom_prod=resultat.getString("nom");
           float prix_prod= resultat.getFloat("prix");
           long cin= resultat.getLong("cin");
            String dateajout_wish=resultat.getString("dateajout");
           lwishlist.add(new Wishlist(id_wish,nom_prod,prix_prod,cin,dateajout_wish));
            
        }
            
        return lwishlist;
    }
    
    public  void ModifierWishlist(int id_wish, int ref_prod, String nom_prod, float prix_prod, long cin, String dateajout_wish) {
         try {
             
             System.out.println("modif");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `wishlist`( `idwishlist`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdwishlist()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `wishlist` SET `reference`= '"+ref_prod+"' ,`nom`= '"+nom_prod+"',`prix`= '"+prix_prod+"',`cin`='"+cin+"',`dateajout`= '"+dateajout_wish+"'  WHERE `idwishlist`= '"+id_wish+"'";
             stm.executeUpdate(req);
         } 
         catch (SQLException ex) {
             Logger.getLogger(WishlistService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public  void SupprimerWishlist(long cin,String nom) {
         try {
             
             System.out.println("suppression");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `wishlist`( `idwishlist`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdwishlist()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "DELETE FROM `wishlist` WHERE (`cin`= '"+cin+"' AND `nom`= '"+nom+"') ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(WishlistService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public  ArrayList<Wishlist> FindWishlist(String rech, int cin_user) throws SQLException  {
       ArrayList<Wishlist> listprod = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `wishlist` WHERE (cin='"+cin_user+"' AND( `nom` Like '%"+rech+"%' or `prix` Like '%"+rech+"%' or`dateajout` Like '%"+rech+"%'))  ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         //int ref_prod= resultat.getInt("idproduit");
            String nom= resultat.getString("nom");
           
              int prix= resultat.getInt("prix");
              String date=resultat.getString("dateajout");
              
           listprod.add(new Wishlist(nom,prix,date));
            }
     listprod.forEach(e->System.out.println(e));
 
      return listprod;
    } 
}
