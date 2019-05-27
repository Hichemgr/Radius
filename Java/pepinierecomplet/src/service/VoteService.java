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
import entites.Vote;
import entites.Reponse;
import java.util.List;




/**
 *
 * @author pc hp
 */
public class VoteService {
    
     Connection cnx;
    
    public VoteService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

     public void ajouterAlaBaseVote(Vote v)throws SQLException  {
  
             
          
             String req = "INSERT INTO `Vote`(`idutilisateur`, `note`) VALUES (?,?) ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,v.getIdutilisateur());
             pstm.setInt(2,v.getnote());
         
             pstm.executeUpdate();
         
    }
     
      public void supprimeridvote(int idv)  {
              try {
           String req ="DELETE FROM Vote where idvote =?";
           PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1,idv );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
   
          public int nbrVote() throws SQLException
      { 
          int sr=0;
        Statement st = cnx.createStatement();
            String myStatement = "SELECT COUNT(*) FROM Vote ";
            ResultSet rs = st.executeQuery(myStatement);
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
            }
            return num;
      }
         
       public int nbrVote1() throws SQLException
      {
       Statement st = cnx.createStatement();
            String myStatement = "SELECT COUNT(*) FROM Vote WHERE note=1 ";
            ResultSet rs = st.executeQuery(myStatement);
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
            }
            return num;
      }
       public int nbrVote2() throws SQLException
      {
         Statement st = cnx.createStatement();
            String myStatement = "SELECT COUNT(*) FROM Vote WHERE note=2";
            ResultSet rs = st.executeQuery(myStatement);
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
            }
            return num;
      }
        public int nbrVote3() throws SQLException
      {
         Statement st = cnx.createStatement();
            String myStatement = "SELECT COUNT(*) FROM Vote WHERE note=3 ";
            ResultSet rs = st.executeQuery(myStatement);
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
            }
            return num;
      }
         public int nbrVote0() throws SQLException
      {
       Statement st = cnx.createStatement();
            String myStatement = "SELECT COUNT(*) FROM Vote WHERE note=0 ";
            ResultSet rs = st.executeQuery(myStatement);
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
            }

            return num;
      }

   public  ArrayList<Vote> getAllVotes() throws SQLException {
       ArrayList<Vote> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Vote";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
            int idvote= resultat.getInt(1);
           int idutilisateur= resultat.getInt(3);
           int note= resultat.getInt(4);
           retour.add(new Vote(idvote,idutilisateur,note));
            
        }
            
        return retour;
    }
   public  ArrayList<Vote> getAllVotescomplet() throws SQLException {
       ArrayList<Vote> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT utilisateur.nom,vote.note FROM vote join utilisateur on vote.idutilisateur=utilisateur.idutilisateur";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
       String nomv= resultat.getString("nom");
           int note= resultat.getInt(2);
           retour.add(new Vote( nomv, note));
            
        }
            
        return retour;
    }

    
    
}
