/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHE;

import Service.QuestionService;
import Service.ReclamationService;
import Service.RendezvousService;
import Service.ReponseService;
import Service.UtiliseObjetService;
import Service.VoteService;
import Utils.MyDBcon;
import entites.Question;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entites.Reclamation;
import entites.RendezVous;
import entites.Reponse;
import entites.Vote;
import entites.utiliobjet;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc hp
 */
  
public class RecUtilisateurController implements Initializable {
    @FXML
    private TableView<Reclamation> tableaurec;
     @FXML
    private TableColumn<Reclamation, String> nomproduit;
    @FXML
    private TableColumn<Reclamation,String> columsujet;
    @FXML
    private TableColumn<Reclamation,String> columcontenu;
   

          Connection cnx;
    @FXML
    private Button supRec;
    @FXML
    private TableView<RendezVous> tableauren;
    @FXML
    private TableColumn<RendezVous,String> columsujett;
    @FXML
    private TableColumn<RendezVous,String> columlieu;
    @FXML
    private TableColumn<RendezVous,Date> columdate;
    @FXML
    private Button supRen;
    @FXML
    private TableView<Question> tableauQues;
    @FXML
    private TableColumn<Question, String> columcontenuu;
    @FXML
    private Button supQues;
    @FXML
    private TextField ajQues;
    @FXML
    private Button ajouterQues;
    @FXML
    private Button modiq;
    @FXML
    private TableView<Vote> tableauvote;
    @FXML
    private TableColumn<Vote,Integer> columlnote;
    @FXML
    private Label result;
    @FXML
    private Label result0;
    @FXML
    private Label result1;
    @FXML
    private Label result2;
    @FXML
    private Label result3;
    private TextField rechercheRec;
    @FXML
    private TextField recherche;
    @FXML
    private Button consulter;
    private DatePicker recherche1;
    @FXML
    private TextField recherche2;
    @FXML
    private TableColumn<Question, String> columnomq;
    private TableColumn<Vote, Integer> columlnomv;
    @FXML
    private TextField recherchelieu;
    @FXML
    private TableColumn<Vote, Integer> nomv;
    @FXML
    private TextField modifierquestion;
    @FXML
    private Button modifierques;
   
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

                  
                    
                        
                        
                        ReclamationService aff;
                        RendezvousService af;
                        QuestionService afff;
                        VoteService vf;
                        ReponseService rf;
                        UtiliseObjetService obs;
                        int res;
                        
                        //----------------resultatVotes------------------//
                        try {
                            vf =new VoteService();
                            res = vf.nbrVote();
                            String resu= Integer.toString(res);
                            result.setText(resu);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------resultatNotes0------------------//
                        
                        try {
                            vf =new VoteService();
                            res = vf.nbrVote0();
                            String resu= Integer.toString(res);
                            result0.setText(resu);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------resultatNotes1------------------//
                        
                        try {
                            vf =new VoteService();
                            res = vf.nbrVote1();
                            String resu= Integer.toString(res);
                            result1.setText(resu);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------resultatNotes2------------------//
                        
                        try {
                            vf =new VoteService();
                            res = vf.nbrVote2();
                            String resu= Integer.toString(res);
                            result2.setText(resu);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------resultatNotes3------------------//
                        
                        try {
                            vf =new VoteService();
                            res = vf.nbrVote3();
                            String resu= Integer.toString(res);
                            result3.setText(resu);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------afficherReclamation------------------//
                        
                        
                        try {
                            aff = new ReclamationService();
                            
                            nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
                            columsujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
                            columcontenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                            ObservableList<Reclamation> observableArrayList =
                            FXCollections.observableArrayList(aff.afficherReclamationsComplet());
                            tableaurec.setItems(observableArrayList);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------afficherReNDEZvOUS------------------//
                        
                        try {
                            
                            af= new RendezvousService();
                            
                            columsujett.setCellValueFactory(new PropertyValueFactory<>("sujet"));
                            columlieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                            columdate.setCellValueFactory(new PropertyValueFactory<>("daterendezvous"));
                            ObservableList<RendezVous> observableArrayList =
                                    FXCollections.observableArrayList(af.getRendezVousTraite());
                            tableauren.setItems(observableArrayList);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //----------------afficherQuestions------------------//
                        
                        try{
                            afff= new QuestionService();
                            columnomq.setCellValueFactory(new PropertyValueFactory<>("nom"));
                            
                            columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                            ObservableList<Question> observableArrayList =
                                    FXCollections.observableArrayList(afff.afficherQuestionsComplet());
                            tableauQues.setItems(observableArrayList);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        //----------------afficherVotes------------------//
                        
                        try{
                            
                            vf= new VoteService();
                            nomv.setCellValueFactory(new PropertyValueFactory<>("nomv"));
                            columlnote.setCellValueFactory(new PropertyValueFactory<>("note"));
                            ObservableList<Vote> observableArrayList =
                                    FXCollections.observableArrayList(vf.getAllVotescomplet());
                            tableauvote.setItems(observableArrayList);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
               
                        
                    
                        
                        
                   
                    //----------------resultatNotes0------------------//
    
    }
       
       

                 //----------------supprimerReclamation------------------//


    @FXML
    private void supRec(ActionEvent event) throws SQLException {
          ReclamationService rs = new ReclamationService();
           Reclamation rec=new Reclamation();
            rec= tableaurec.getSelectionModel().getSelectedItem();
            rs.supprimerReclamation(rec);

              columsujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
              columcontenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
          ObservableList<Reclamation> observableArrayList = 
                  FXCollections.observableArrayList(rs.getReclamationsTraite());
            tableaurec.setItems(observableArrayList);
            
    }

                 //----------------supprimerRendezVous------------------//


    @FXML
    private void supRen(ActionEvent event)  {
     
        try {
           RendezvousService rs = new RendezvousService();
           RendezVous ren=new RendezVous();
            ren= tableauren.getSelectionModel().getSelectedItem();
            rs.supprimerRendezVous(ren);

            columsujett.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            columlieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            columdate.setCellValueFactory(new PropertyValueFactory<>("daterendezvous"));
            ObservableList<RendezVous> observableArrayList =
                    FXCollections.observableArrayList(rs.getRendezVousTraite());
            tableauren.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                 //----------------supprimerQuestions------------------//

    @FXML
    private void supQues(ActionEvent event)  {
             try {
        Question question =new Question();
        question= tableauQues.getSelectionModel().getSelectedItem();
        QuestionService qs = new QuestionService();
        qs.SupprimerQuestion(question);
               columnomq.setCellValueFactory(new PropertyValueFactory<>("nom"));
              columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
          ObservableList<Question> observableArrayList = 
                  FXCollections.observableArrayList(qs.getQuestionsVisible());
            tableauQues.setItems(observableArrayList);
        
    } catch (SQLException ex) {
        Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
             
    }

                    //----------------AjouterQuestions------------------//


    @FXML
    private void ajouterQuestion(ActionEvent event) throws SQLException {
       
         String contenu =ajQues.getText();
 
 Question a =new Question(contenu);
 QuestionService af=new QuestionService();
 int aj=af.ajouterAlaBaseQuestion(a);
   
              columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            columnomq.setCellValueFactory(new PropertyValueFactory<>("nom"));

          ObservableList<Question> observableArrayList = 
                  FXCollections.observableArrayList(af.afficherQuestionsComplet());
            tableauQues.setItems(observableArrayList);
 if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la question a été ajouté !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
        
     
    
    }
      
                 //----------------RechercheReclamation------------------//

   
    @FXML
    private void rechercheRec(javafx.scene.input.KeyEvent event) {
         try {
            String idS =recherche.getText();
            
            ReclamationService aff= new ReclamationService();
            aff.rechercheReclamation(idS);

            columsujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            columcontenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reclamation> observableArrayList =
                    FXCollections.observableArrayList(aff.rechercheReclamation(idS));
            
            FXCollections.observableArrayList(aff.getReclamationsTraite());
            tableaurec.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               //----------------ConsulterRep------------------//


    @FXML
    private void consulterQ(ActionEvent event) throws IOException {
        int question= tableauQues.getSelectionModel().getSelectedItem().getIdquestion();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("QuesReponses.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
       
    }
                 //----------------RechercheQuest------------------//

    @FXML
    private void rechercheQ(javafx.scene.input.KeyEvent event) {
        try {
            String idS =recherche2.getText();
            
            QuestionService aff= new QuestionService();
            aff.rechercheQuestion(idS);
            columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Question> observableArrayList =
             FXCollections.observableArrayList(aff.rechercheQuestion(idS));           
            tableauQues.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    

    @FXML
    private void recherchelieu(javafx.scene.input.KeyEvent event) {
             try{
       String idS =recherchelieu.getText();
            
           
            RendezvousService aff= new RendezvousService();
            aff.rechercheRendezVous(idS);
            columsujett.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            columlieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            columdate.setCellValueFactory(new PropertyValueFactory<>("daterendezvous"));
            ObservableList<RendezVous> observableArrayList =
                    FXCollections.observableArrayList(aff.rechercheRendezVous(idS));
            tableauren.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void modifierquestion(ActionEvent event) throws SQLException {
        
          
         Question question=new Question();
                 QuestionService qs = new QuestionService();
                 UtiliseObjetService obs =new UtiliseObjetService();
                 Question q =qs.afficherQuestionParId(obs.getiduserdb().get(0).getId_questiondb());
           modifierquestion. setText (q .getContenu());
                question = new Question(obs.getiduserdb().get(0).getId_questiondb(),modifierques.getText());
                 //  System.out.println(titre.getText());
                 //  System.out.println(contenu.getText());
                 //  System.out.println(obs.getiduserdb().get(0).getId_questiondb());
                qs.modifierQuestion(question);
     /*    
         QuestionService qst = new QuestionService();
        
            
             Question questions= tableauQues.getSelectionModel().getSelectedItem();
        //UO.(question.getId_question());
        utiliobjet ob =new utiliobjet();
        UtiliseObjetService obs=new UtiliseObjetService();
        obs.setidquestiondb(questions.getIdquestion());
         qst.modifierQuestion(questions);
        
         /*  QuestionService qst = new QuestionService();
                 UtiliseObjetService obs =new UtiliseObjetService();
                question = new Question(obs.getiduserdb().get(0).getId_questiondb(),modifierques.getText());
            
            
             
            String contenu=modq.getText();
            Question qq =new Question();
            QuestionService q= new QuestionService();
          int qs= q.modifierQuestion(qq);
*/

            
            columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Question> observableArrayList =
                    FXCollections.observableArrayList(qs.afficherQuestionsComplet());
            tableauQues.setItems(observableArrayList);
       
        
    }

  


   
   
    
    
}
