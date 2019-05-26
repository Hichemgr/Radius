/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Utils.MyDBcon;
import entites.Produit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc hp
 */
public class ProduitService {

     Connection cnx;
    
 
 
    public ProduitService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

   public void ajouterAlaBase(Produit p) {
         try {
             int i=0;
             System.out.println("Ajout Connected.");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO produit`( `nomproduit, prix, quantite, note, description, datevalidite) VALUES ('"+p.getNom_prod()+"','"+p.getPrix_prod()+"','"+p.getQuantite_prod()+"','"+p.getRating_prod()+"','"+p.getDescription_prod()+"','"+p.getDatev_prod()+"')";
             stm.executeUpdate(req);
             i++;
             if(i!=0)
              System.out.println("Ajout Done.");
             } catch (SQLException ex) {
             Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public  ArrayList<Produit> getAllProduit() throws SQLException  {
       ArrayList<Produit> listprod = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM produit ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         //int ref_prod= resultat.getInt("reference");
            String nom_prod= resultat.getString("nomproduit");
         
              
           listprod.add(new Produit(nom_prod));
            }
      return listprod;
    } 
      
      public  void ModifierProduit( String nom_prod_modif,String nom_prod,float prix_prod, int quantite_prod, int rating_prod, String description_prod, Date datev_prod) {
         
          try {
             
             System.out.println("Modification");
             Statement stm = cnx.createStatement();
             String req = "UPDATE produit SET nomproduit`='"+nom_prod+"' ,prix`='"+prix_prod+"', quantite`='"+quantite_prod+"', `note`='"+rating_prod+"' ,description`='"+description_prod+"', `datevalidite`='"+datev_prod+"'  where nomproduit='"+nom_prod_modif+"' ";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public  void SupprimerProduit( String nom_prod) throws SQLException {
         
             
            
             Statement stm = cnx.createStatement();
             String req = "DELETE FROM produit WHERE nomproduit ='"+nom_prod+"' ";
             stm.executeUpdate(req);
              System.out.println("Suppression");
           
        
         
    }
     public  ArrayList<Produit> FindProduit(String rech) throws SQLException  {
       ArrayList<Produit> listprod = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM produit where nomproduit Like '%"+rech+"%' or prix Like '%"+rech+"%' or`quantite` Like '%"+rech+"%' or note Like '%"+rech+"%' or`description`Like '%"+rech+"%' or datevaliditeLike '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         int ref_prod= resultat.getInt("reference");
            String nom_prod= resultat.getString("nomproduit");
           float prix_prod= resultat.getFloat("prix");
            int quantite_prod= resultat.getInt("quantite");
             int rating_prod= resultat.getInt("note");
             String description_prod= resultat.getString("description");
              Date datev_prod= resultat.getDate("datevalidite");
              
           listprod.add(new Produit(ref_prod,nom_prod,prix_prod,quantite_prod,rating_prod,description_prod,datev_prod));
            }
     listprod.forEach(e->System.out.println(e));
 
      return listprod;
    } 
      public  ArrayList<Produit> SortProduit(String crit) throws SQLException  {
       ArrayList<Produit> listprod = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM produit ORDER BY "+crit+" ASC ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
          int ref_prod= resultat.getInt("reference");
          String nom_prod= resultat.getString("nomproduit");
          float prix_prod= resultat.getFloat("prix");
          int quantite_prod= resultat.getInt("quantite");
          int rating_prod= resultat.getInt("note");
          String description_prod= resultat.getString("description");
          Date datev_prod= resultat.getDate("datevalidite");
              
           listprod.add(new Produit(ref_prod,nom_prod,prix_prod,quantite_prod,rating_prod,description_prod,datev_prod));
            }
      
     listprod.forEach(e->System.out.println(e));
 
      return listprod;
    } 
    
    
//    void ajouterAlaBase2(Produit p) {
//         try {
//             
//             String req = "INSERT INTO personne`( `nom, prenom) VALUES (?,?)";
//             PreparedStatement pstm = cnx.prepareStatement(req);
//             pstm.setString(1, p.getNom());
//             pstm.setString(2, p.getPrenom());
//             pstm.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
//         }
//    }

}
