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
import entites.Question;
import entites.Reclamation;
import entites.RendezVous;
import entites.Vote;
import entites.Reponse;
import java.util.List;


/**
 *
 * @author pc hp
 */
public class ReponseService {
        
    Connection cnx;
    
    public ReponseService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
public int ajouterAlaBaseReponseid(Reponse rep,int id ){
     int aj=0;
              try {
             Question q=new Question();
         Statement stm1 = cnx.createStatement();
        String req1 = "SELECT idquestion FROM Question where idquestion='"+id+"'";
        ResultSet resultat = stm1.executeQuery(req1);
        
           int idquestion= resultat.getInt(1);
        
             String req = "INSERT INTO `Reponse`(`idquestion`, `idutilisateur`, `contenu`,`visible`) VALUES ('"+idquestion+"',?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,rep.getIdquestion());
             pstm.setInt(2,rep.getIdutilisateur());
             pstm.setString(3,rep.getContenu());
             pstm.setInt(4,rep.getVisible());
             aj=pstm.executeUpdate();
         } 
              catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         }return aj;
    }
    public int ajouterAlaBaseReponse(Reponse rep,int id){
     int aj=0;
              try {
             
         
             String req = "INSERT INTO `Reponse`(`idquestion`, `idutilisateur`, `contenu`,`visible`) VALUES (?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,id);
             pstm.setInt(2,rep.getIdutilisateur());
             pstm.setString(3,rep.getContenu());
             pstm.setInt(4,rep.getVisible());
             aj=pstm.executeUpdate();
         } 
              catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         }return aj;
    }
         
    
     public void modifierReponse(String contenu, int idrep) {
        
               try {
                   
             
             String req = "UPDATE `Reponse` SET `contenu`=? WHERE `idreponse`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,contenu);
             pstm.setInt(2,idrep);
             pstm.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
     public void supprimerReponse( Reponse re) throws SQLException {
     
             
             String req = "UPDATE `Reponse` SET `visible`=1 WHERE `idreponse`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,re.getIdreponse());
             pstm.executeUpdate();
        
    }
    

    public ArrayList<Reponse> getAllReponses() throws SQLException {
       ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Reponse";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
            int idreponse= resultat.getInt(1);
           int idquestion= resultat.getInt(2);
           int idutilisateur= resultat.getInt(3);
           String contenu= resultat.getString("contenu");
           int visible=resultat.getInt("visible");
           String nom= resultat.getString("nom");

           

           retour.add(new Reponse(idreponse, idquestion, idutilisateur, contenu, nom));
            
        }
            
        return retour;
    }
    public ArrayList<Reponse> getReponsesvisible() throws SQLException {
       ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Reponse WHERE `visible`=0 ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
            int idreponse= resultat.getInt(1);
           int idquestion= resultat.getInt(2);
           int idutilisateur= resultat.getInt(3);
           String contenu= resultat.getString("contenu");
           int visible=resultat.getInt("visible");
                      String nom= resultat.getString("nom");


           retour.add(new Reponse(idreponse, idquestion, idutilisateur, contenu, nom));
            
        }
            
        return retour;
    }
       public ArrayList<Reponse> getReponseQu() throws SQLException {
       ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
      String req =" SELECT question.nom,reponse.contenu FROM reponse join question on reponse.idquestion=question.idquestion ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           String contenu= resultat.getString("contenu");
                      String nom= resultat.getString("nom");


           retour.add(new Reponse(contenu,nom));
            
        }
            
        return retour;
    }
       ///////////////////////////////////use this///////////////////////////////////////
       public ArrayList<Reponse> getReponseQuid(int id) throws SQLException {
       ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
      String req =" SELECT question.nom,reponse.contenu FROM reponse join question on reponse.idquestion=question.idquestion where question.idquestion='"+id+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           String contenu= resultat.getString("contenu");
                      String nom= resultat.getString("nom");


           retour.add(new Reponse(contenu,nom));
            
        }
            
        return retour;
    }
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       public List<Reponse> fetchall(int id) throws SQLException {
 ArrayList<Reponse> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
 String req = "select * from reponse  WHERE idquestion= '"+id+"' " ;
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
            int idreponse= resultat.getInt(1);
           int idquestion= resultat.getInt(2);
           int idutilisateur= resultat.getInt(3);
           String contenu= resultat.getString("contenu");
           String nom= resultat.getString("nom");


           retour.add(new Reponse(idreponse, idquestion, idutilisateur, contenu, nom));
            
        }
            
        return retour;
    }
    
    
}
