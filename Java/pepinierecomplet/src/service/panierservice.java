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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Hichem
 */
public class panierservice {
    Connection cnx;
    
    public panierservice() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

   public  void ajouterAlaBase(panier p) throws SQLException {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void ajouterAlaBase2(panier p)throws SQLException  {
         try {
             
             String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur`,`etat`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, p.getIdpanier());
             pstm.setInt(2, p.getIdutilisateur());
             pstm.setInt(3, p.getEtat());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<panier> getAllPanier() throws SQLException {
       ArrayList<panier> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM panier ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
            int idpanier= resultat.getInt("idpanier");
           int idutilisateur= resultat.getInt("idutilisateur");
           int etat= resultat.getInt("etat");
           retour.add(new panier(idpanier, idutilisateur,etat));
            
        }
            
        return retour;
    }
    
    public  void modifier(int idpanier,int idutilisateur,int etat) {
         try {
             
             System.out.println("modif");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `panier` SET `idutilisateur`='"+idutilisateur+"' ,`etat`='"+etat+"'  WHERE `idpanier`= '"+idpanier+"'";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public  void supprimer(int idpanier) {
         try {
             
             System.out.println("suppression");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "DELETE FROM `panier` WHERE `idpanier`= '"+idpanier+"' ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    
      public int rechercherutilisateur(int idutilisateur) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM panier WHERE `idutilisateur`='"+idutilisateur+"' and `etat`='0'";
        ResultSet resultat = stm.executeQuery(req);
         while(resultat.next())
         {
             return resultat.getInt("idpanier");
         }
         
           return 0;
         
         
    }
      
        public int rechercheridutili(String nom,String prenom) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur WHERE `nom`='"+nom+"' and `prenom`='"+prenom+"'";
        ResultSet resultat = stm.executeQuery(req);
         while(resultat.next())
         {
             return resultat.getInt("idutilisateur");
         }
         
           return 0;
         
         
    }
        
          public boolean rechercherproduit(int id,int idprod) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        //String req = "SELECT * FROM produit WHERE `idproduit`='"+id+"' ";
       String req = "select idproduit from ligneproduit where idpanier='"+id+"' and  idproduit='"+idprod+"' ";
        ResultSet resultat = stm.executeQuery(req);
         
         
            // return resultat.next();
         while(resultat.next())
         {
             //return resultat.getInt("idproduit");
             return true;
         }
         
           return false;
         
         
           
         
         
    }
          
          
          
          
          
          
          
           public  void videpanierbase(int idp) {
         try {
             
             System.out.println("suppression ligne produit");
             Statement stm = cnx.createStatement();
             
             String req = "DELETE FROM `ligneproduit` WHERE `idpanier`= '"+idp+"'";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
           
           
               public  void supprimeridproduit(int idprod,int idpa) {
         try {
             
             System.out.println("suppression ligne produit");
             Statement stm = cnx.createStatement();
             
             String req = "DELETE FROM `ligneproduit` WHERE `idproduit`= '"+idprod+"' and `idpanier`= '"+idpa+"' ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
               
               
                public  void modifierquantite(int idpanier,int nouv,int idprod) {
         try {
             
             System.out.println("modif");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `ligneproduit` SET `quantite`='"+nouv+"' WHERE `idpanier`= '"+idpanier+"' and`idproduit`= '"+idprod+"' " ;
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
                
                
                
                 public List<panier> getback() throws SQLException {

        List<panier> pan = new ArrayList<>();
        String req = "select * from panier";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            panier p = new panier(rst.getInt("idpanier")
                    , rst.getInt("idutilisateur")
                    , rst.getInt("etat"));
            pan.add(p);
        }
        return pan;
    }
                 
                     public List<ligneproduit> getbackprod() throws SQLException {

        List<ligneproduit> pan = new ArrayList<>();
        String req = "select * from ligneproduit";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            ligneproduit p = new ligneproduit(rst.getInt("idligne")
                    , rst.getInt("idpanier")
                    , rst.getInt("idproduit"), rst.getInt("quantite"));
            pan.add(p);
        }
        return pan;
    }
                        public List<panier> rechercherpanier(String rech) throws SQLException {

        List<panier> pan = new ArrayList<>();
String req = "SELECT * FROM panier where idpanier Like '%"+rech+"%' or idutilisateur Like '%"+rech+"%' or`etat` Like '%"+rech+"%' ";     
//  String req = "select * from panier";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            panier p = new panier(rst.getInt("idpanier")
                    , rst.getInt("idutilisateur")
                    , rst.getInt("etat"));
            pan.add(p);
        }
        return pan;
    }
                        
                           public List<ligneproduit> rechercherligne(String rech) throws SQLException {

        List<ligneproduit> pan = new ArrayList<>();
        //String req = "select * from ligneproduit";
        String req = "SELECT * FROM ligneproduit where idligne Like '%"+rech+"%' or idpanier Like '%"+rech+"%' or`idproduit` Like '%"+rech+"%' "; 
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            ligneproduit p = new ligneproduit(rst.getInt("idligne")
                    , rst.getInt("idpanier")
                    , rst.getInt("idproduit"), rst.getInt("quantite"));
            pan.add(p);
        }
        return pan;
    }
                           
      
                           
         public  void validercommande(int idp) {
         try {
             
             System.out.println("validation commande");
             Statement stm = cnx.createStatement();
                String req = "UPDATE `panier` SET `etat`='1' WHERE `idpanier`= '"+idp+"' " ;
             //String req = "DELETE FROM `ligneproduit` WHERE `idpanier`= '"+idp+"'";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
         
         
      /*   public ObservableList<Integer> getquantite(int id){
        ObservableList<Integer> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select quantite from  produit where idproduit='"+id+"' ";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getInt("quantite"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }*/
         
        /*  public ArrayList<produit> getAllProduit() throws SQLException {
       ArrayList<produit> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM produit ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
            int idpanier= resultat.getInt("idproduit");
           int quantite= resultat.getInt("quantite");
          // int etat= resultat.getInt("prix");
           retour.add(new produit(idpanier,quantite));
            
        }
            
        return retour;
    }*/
         public int rechercherquantite(int id) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM produit WHERE `idproduit`='"+id+"' ";
        ResultSet resultat = stm.executeQuery(req);
         while(resultat.next())
         {
             return resultat.getInt("quantite");
         }
         
           return 0;
         
         
    }
    
    
}
