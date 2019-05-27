/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Base;
import entite.Catalogue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raedm
 */
public class CatalogueService {
   Connection cnx;
    
    public CatalogueService() throws SQLException {
       cnx = Base.getInstance().getCnx();
       
        
    }

   public  void ajouterCatalogue(Catalogue c) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             String req = "INSERT INTO `catalogue`(`nom`,`datedebut`,`datefin`,`saison` ) VALUES ('"+c.getNom_catalogue()+"','"+c.getDatedebut()+"','"+c.getDatefin()+"','"+c.getSaison()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(CatalogueService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public ArrayList<Catalogue> GetCatalogue(String saisonc) throws SQLException {
       ArrayList<Catalogue> lcatalogue = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM catalogue where saison='"+saisonc+"' ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_catalogue= resultat.getInt("idcatalogue");
           String nom_catalogue=resultat.getString("nom");
            Date datedebut= resultat.getDate("datedebut");
            
           Date datefin= resultat.getDate("datefin");
           String saison= resultat.getString("saison");
          
           lcatalogue.add(new Catalogue(id_catalogue,nom_catalogue,datedebut,datefin,saison));
            
        }
            
        return lcatalogue;
    }
    
    public  void ModifierCatalogue(int id_catalogue, String nom_catalogue, Date datedebut, Date datefin, String saison) {
         try {
             
             System.out.println("modif");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `catalogue`( `idcatalogue`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdcatalogue()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `catalogue` SET `idcatalogue`= '"+id_catalogue+"' ,`nom`= '"+nom_catalogue+"',`datedebut`= '"+datedebut+"',`datefin`='"+datefin+"',`saison`= '"+saison+"'  WHERE `idcatalogue`= '"+id_catalogue+"'";
             stm.executeUpdate(req);
         } 
         catch (SQLException ex) {
             Logger.getLogger(CatalogueService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public  void SupprimerCatalogue(String idcatalogue) {
         try {
             
             
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `catalogue`( `idcatalogue`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdcatalogue()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "DELETE FROM `catalogue` WHERE `nom`= '"+idcatalogue+"' ";
             stm.executeUpdate(req);
             System.out.println("suppression");
         } catch (SQLException ex) {
             Logger.getLogger(CatalogueService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public ArrayList<Catalogue> FindCatalogue(String rech) throws SQLException {
       ArrayList<Catalogue> lcatalogue = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `catalogue` where `nom` Like '%"+rech+"%' or `datedebut` Like '%"+rech+"%' or`datefin` Like '%"+rech+"%' or `saison` Like '%"+rech+"%'  ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id_catalogue= resultat.getInt("idcatalogue");
           String nom_catalogue=resultat.getString("nom");
            Date datedebut= resultat.getDate("datedebut");
           Date datefin= resultat.getDate("datefin");
           String saison= resultat.getString("saison");
      
           lcatalogue.add(new Catalogue(id_catalogue,nom_catalogue,datedebut,datefin,saison));
            
        }
            
        return lcatalogue;
    }
}
