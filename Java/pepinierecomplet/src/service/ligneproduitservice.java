/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entite.MyDBcon;
import entite.ligneproduit;
import entite.panier;
import entite.Produit;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Hichem
 */
public class ligneproduitservice {
    Connection cnx;
    
    public ligneproduitservice() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
     }
    
        public void ajouterauligneproduit(ligneproduit l) {
         try {
             
             String req = "INSERT INTO `ligneproduit`(`idpanier`,`idproduit`,`quantite`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             //pstm.setInt(1, l.getIdligne());
             pstm.setInt(1, l.getIdpanier());
             pstm.setInt(2, l.getIdproduit());
              pstm.setInt(3, l.getQuantite());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<ligneproduit> getAllligneproduit() throws SQLException {
       ArrayList<ligneproduit> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM ligneproduit ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
           int idligne= resultat.getInt("idligne");
            int idpanier= resultat.getInt("idpanier");
            int idproduit= resultat.getInt("idproduit");
            int quantite= resultat.getInt("quantite");
            retour.add(new ligneproduit(id,idpanier,idproduit,quantite));
            
        }
            
        return retour;
    }
    
    public List<ligneproduit> getAllPersonnes() throws SQLException {

        List<ligneproduit> presonnes = new ArrayList<>();
        String req = "select * from ligneproduit";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            ligneproduit p = new ligneproduit(rst.getInt("idligne")
                    , rst.getInt("idpanier")
                    , rst.getInt("idproduit"),rst.getInt("quantite"));
            presonnes.add(p);
        }
        return presonnes;
    }
    
    public  void modifierqte(int idligne,int quantite) {
         try {
             
             System.out.println("modification ligne de produit");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `ligneproduit` SET `quantite`='"+quantite+"'  WHERE `idligne`= '"+idligne+"'";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
      public  void supprimerligneproduit(int idligne) {
         try {
             
             System.out.println("suppression ligne produit");
             Statement stm = cnx.createStatement();
             
             String req = "DELETE FROM `ligneproduit` WHERE `idligne`= '"+idligne+"' ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
      
        public ArrayList<Produit> afficherPanier(int id) throws SQLException {
        ArrayList<Produit> retour = new ArrayList<>();
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.nomproduit,produit.description,produit.prix,ligneproduit.quantite FROM `ligneproduit` ,`produit` ,`panier` WHERE panier.idpanier IN (select idpanier from panier where idutilisateur=?)and panier.idpanier=ligneproduit.idpanier and produit.idproduit=ligneproduit.idproduit and panier.etat=0");
        pt.setInt(1, id);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            //int id= resultat.getInt(1);
            //  int id_prod = resultat.getInt("id_prod");
            String nom = resultat.getString("nomproduit");
            int quantite = resultat.getInt("quantite");
            String description = resultat.getString("description");
            float prix = resultat.getFloat("prix");
            retour.add(new Produit(nom,description, quantite, prix));

        }

        return retour;
    }
        
        
         public float getprixtotale(int id) throws SQLException {
        ArrayList<Produit> retour = new ArrayList<>();
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.prix,ligneproduit.quantite FROM `ligneproduit` ,`produit` ,`panier` WHERE panier.idpanier IN (select idpanier from panier where idutilisateur=?)and panier.idpanier=ligneproduit.idpanier and produit.idproduit=ligneproduit.idproduit and panier.etat=0");
        pt.setInt(1, id);
        ResultSet resultat = pt.executeQuery();
        float prixtotale=0;
        while (resultat.next()) {
            //int id= resultat.getInt(1);
            //  int id_prod = resultat.getInt("id_prod");
            //String nom = resultat.getString("nomproduit");
            
           
            //String description = resultat.getString("description");
            float prix = resultat.getFloat("prix");
            int quantite= resultat.getInt("quantite");
          
           prixtotale+=quantite*prix;
            //retour.add(new produit(description, quantite, prix));
           

        }
          return prixtotale;
          
        
    }
        
        
        
       
        
        
        
        












}
