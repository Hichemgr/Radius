/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDBcon;
import entites.Produit;
import entites.Reclamation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author pc hp
 */
public class ReclamationService {
     Connection cnx;
    
    public ReclamationService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

    public int ajouterAlaBaseReclamation(Reclamation rec,Produit po)throws SQLException  {
        
             
             
             int rs=0;
             String req = "INSERT INTO `reclamation`(`idutilisateur`, `nomproduit`, `sujet`, `contenu`, `etat`) VALUES (?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,rec.getIdutilisateur());
             pstm.setString(2,po.getNom_prod());
             pstm.setString(3,rec.getSujet());
             pstm.setString(4,rec.getContenu());
             pstm.setInt(5,rec.getEtat());
            rs= pstm.executeUpdate();
           
         
             
          return rs;
    }
     
    public  void modifierReclamation(int idrec,String sujet,String contenu) {
        
           try {
             
             String req = "UPDATE `Reclamation` SET `sujet`=?,`contenu`=? WHERE `idreclamation`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,sujet);
             pstm.setString(2,contenu);
             pstm.setInt(3, idrec);
             pstm.executeUpdate();
            
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         }
      
    }
  
      
       public ArrayList<Reclamation> rechercheReclamation(String sujett ) throws SQLException {
       ArrayList<Reclamation> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Reclamation WHERE `sujet` LIKE'%"+sujett+"%' AND  `etat`=0";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idreclamation= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String nomproduitl= resultat.getString("nomproduit");
            String sujet = resultat.getString("sujet");
           String contenu= resultat.getString("contenu");
           int etat = resultat.getInt("etat");
          
           retour.add(new Reclamation(idreclamation, idutilisateur,nomproduitl, sujet,contenu,etat));
            
        }
            
        return retour;
    }
        
    public   void supprimerReclamation(Reclamation r) throws SQLException {
      
             String req = "UPDATE `Reclamation` SET `etat`=1 WHERE `idreclamation`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, r.getIdreclamation());
             pstm.executeUpdate();
            
        
         
    }
    

    public ArrayList<Reclamation> getAllReclamations() throws SQLException {
       ArrayList<Reclamation> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Reclamation";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idreclamation= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String nomproduitl= resultat.getString("nomproduit");
            String sujet = resultat.getString("sujet");
           String contenu= resultat.getString("contenu");
           int etat = resultat.getInt("etat");
          
           retour.add(new Reclamation(idreclamation, idutilisateur,nomproduitl, sujet,contenu,etat));
            
        }
            
        return retour;
    }
    public ArrayList<Reclamation> getReclamationsTraite() throws SQLException {
       ArrayList<Reclamation> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Reclamation WHERE `etat`=0";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idreclamation= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String nomproduitl= resultat.getString("nomproduit");
            String sujet = resultat.getString("sujet");
           String contenu= resultat.getString("contenu");
           int etat = resultat.getInt("etat");
          
           retour.add(new Reclamation(idreclamation, idutilisateur,nomproduitl, sujet,contenu,etat));
            
        }
            
        return retour;
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
       public ArrayList<Reclamation> afficherReclamationsComplet() throws SQLException
   {    ArrayList<Reclamation> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT reclamation.sujet,reclamation.contenu,utilisateur.nom FROM reclamation join utilisateur on reclamation.idutilisateur=utilisateur.idutilisateur WHERE `etat`=0";

        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
         String sujet= resultat.getString("sujet");

       String contenu= resultat.getString("contenu");
       String nom= resultat.getString("nom");
                  retour.add(new Reclamation(sujet,contenu, nom));

        }
         return retour;

}}
