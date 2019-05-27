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
import Utils.MyDBcon;
import entites.Question;



/**
 *
 * @author pc hp
 */
public class QuestionService {
   
    
    Connection cnx;
    
    public QuestionService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

    public int ajouterAlaBaseQuestion(Question q) throws SQLException {
        
             
                int sr=0;

             String req = "INSERT INTO `Question`(`idutilisateur`, `contenu`,`visible`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,q.getIdutilisateur());
             pstm.setString(2,q.getContenu());
             pstm.setInt(3,q.getVisible());
            sr=pstm.executeUpdate();
             return sr;
         
    }
    public  void modifierQuestion(Question q) throws SQLException {
 
             String req = "UPDATE `question` SET `contenu`=? WHERE `idquestion`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,q.getContenu());  
              pstm.setInt(2,q.getIdquestion());     

             pstm.executeUpdate();
             
             
             
        
    }

    public  void SupprimerQuestion(Question q) throws SQLException {
        
             String req = "UPDATE `question` SET `visible`=1 WHERE `idquestion`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,q.getIdquestion());
             pstm.executeUpdate();
             
             String req2 = "UPDATE `Reponse` SET `visible`=1 WHERE `idreponse`=?";
             PreparedStatement pstm2 = cnx . prepareStatement (req2);
             pstm2 . setInt ( 1 , q . getIdquestion());
             pstm2 . executeUpdate ();
             
            
             
             
            
             
         
    }


    public ArrayList<Question> getAllQuestions() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Question";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idquestion= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String contenu= resultat.getString("contenu");
           int visible=resultat.getInt("visible");
           retour.add(new Question(idquestion, idutilisateur,contenu,visible));
            
        }
            
        return retour;
    }
    
    public ArrayList<Question> getQuestionsVisible() throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Question WHERE `visible`=0 ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idquestion= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String contenu= resultat.getString("contenu");
           int visible=resultat.getInt("visible");
           
           retour.add(new Question(idquestion, idutilisateur,contenu,visible));
            
        }
            
        return retour;
    }
      
       public ArrayList<Question> rechercheQuestion(String contenuu ) throws SQLException {
       ArrayList<Question> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM Question WHERE `contenu` LIKE'%"+contenuu+"%'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idquestion= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
           String contenu= resultat.getString("contenu");
           int visible=resultat.getInt("visible");
           retour.add(new Question(idquestion, idutilisateur,contenu,visible));
        }
            
        return retour;
    }
       public ArrayList<Question> afficherQuestionsComplet() throws SQLException
   {    ArrayList<Question> retour = new ArrayList<>();
        
        Statement stm = cnx.createStatement();
        Statement stm1 = cnx.createStatement();
        String req = "SELECT question.contenu,utilisateur.nom FROM question join utilisateur on question.idutilisateur=utilisateur.idutilisateur WHERE `visible`=0";

        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
       String contenu= resultat.getString("contenu");
       String nom= resultat.getString("nom");
         retour.add(new Question(contenu, contenu, nom));
        }
            
     
       
   
        
        return retour;
}
       public Question afficherQuestionParId(int id) throws SQLException
   {    Question retour = new Question();
   
        Statement stm = cnx.createStatement();
        String req = "SELECT idquestion,contenu FROM question WHERE visible=0 AND question.idquestion="+id+"";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
 
       String contenu= resultat.getString("contenu");
       int id_question= resultat.getInt("idquestion");
       String req1 = "SELECT idreponse FROM reponse WHERE reponse.idreponse="+id_question+" ";
       retour=new Question(id_question, contenu);
       
     //  retour=new Question(id_question,titre_question,date_question,contenu_question);
       
            
        }
         return retour;  
    }
}