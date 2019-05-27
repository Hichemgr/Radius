/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHECLIENT;

import GRAPHE.RecUtilisateurController;
import service.ProduitService;
import Service.QuestionService;
import Service.ReclamationService;
import Service.RendezvousService;
import Service.ReponseService;
import Service.UtiliseObjetService;
import Service.VoteService;
import entites.Produit;
import entites.Question;
import entites.Reclamation;
import entites.RendezVous;
import entites.Reponse;
import entites.Vote;
import entites.utiliobjet;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.MenuController;

/**
 * FXML Controller class
 *
 * @author pc hp
 */
public class RecClientController implements Initializable {
@FXML
    private TextField sujetRecc;
    @FXML
    private TextArea contenuRecc;
    @FXML
    private Button AjouterRec;
    
    @FXML
    private TextField sujetRen;
    @FXML
    private TextField lieuRen;
    @FXML
    private Button AjouterRen;
    @FXML
    private DatePicker dateRen;
    @FXML
    private ComboBox referencee;
    @FXML
    private RadioButton ajt0;
    @FXML
    private RadioButton ajt1;
    @FXML
    private RadioButton ajt2;
    @FXML
    private RadioButton ajt3;
    @FXML
    private ToggleGroup voteNote;
    @FXML
    private Button valider;
    @FXML
    private TextField recherche2;
    @FXML
    private Button consulter;
    @FXML
    private TableView<Question> tableauQues;
    @FXML
    private TableColumn<Question, String> columnomq;
    @FXML
    private TableColumn<Question, String> columcontenuu;
    @FXML
    private Button ajouterQues;
    @FXML
    private TextField ajQues;
    private TextField txt_id;
    @FXML
    private TableView<Reponse> tabq;
    @FXML
    private TableColumn<Reponse,String> contenuq;
    @FXML
    private Button modifiq;
    @FXML
    private TextField ajtreponse;
    @FXML
    private Button ajtrepo;
    @FXML
    private TableColumn<Question, Integer> idQ;
    @FXML
    private TextField txt_idQ;
    @FXML
    private Button supprimerreponse;
    @FXML
    private ImageView baack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          
    try {
        ReclamationService pus=new ReclamationService();
        ProduitService us = new ProduitService();
        
        ArrayList<entite.Produit> produits = us.getAllProduit();
         try{
                          QuestionService  afff= new QuestionService();
                            columnomq.setCellValueFactory(new PropertyValueFactory<>("nom"));
                            
                            columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                            idQ.setCellValueFactory(new PropertyValueFactory<>("idquestion"));
                            ObservableList<Question> observableArrayList =
                                    FXCollections.observableArrayList(afff.afficherQuestionsComplet());
                            tableauQues.setItems(observableArrayList);
                        } catch (SQLException ex) {
                            Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
      /*  for(Produit e:produits){
            referencee.getItems().addAll(e);
            
        }
        
        
        referencee.setOnAction(e->{
            System.out.println(referencee.getValue());
        });
        
        */
        referencee.setItems(pus.getNomproduit());
    } catch (SQLException ex) {
        Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
    }
      try {
                                ReponseService rf=new ReponseService();
                                contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                                ObservableList<Reponse> observableArrayList;
                                
                                observableArrayList = FXCollections.observableArrayList(rf.getReponsesvisible());
                                
                                tabq.setItems(observableArrayList);
                            } catch (SQLException ex) {
                                Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               
    }    

    @FXML
    private void AjouterRec(ActionEvent event) throws SQLException {
        
 ReclamationService pr=new ReclamationService();
  Reclamation p =new Reclamation();
 Produit pp =new Produit() ; 
    String contenu =contenuRecc.getText();
        String Sujet =sujetRecc.getText();
        String nomprod=(String) referencee.getSelectionModel().getSelectedItem();
        p.setContenu(contenu);
        p.setSujet(Sujet);
        pp.setNom_prod(nomprod);
 int aj=pr.ajouterAlaBaseReclamation(p,pp);
 if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reclamation");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la Reclamation a été envoyé !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Reclamation");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
        
     
    
    }
    
        @FXML
    private void AjouterRen(ActionEvent event) throws SQLException, ParseException {
           String sujet =sujetRen.getText();
           String lieu =lieuRen.getText();
           Date dateren=java.sql.Date.valueOf(dateRen.getValue());

 
            RendezVous a =new RendezVous(sujet, lieu, dateren);
            RendezvousService af=new RendezvousService();
 int aj=af.ajouterAlaBaseRendezvous(a);
 if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RendezVous");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("votre demade de rendez_vous est en cours !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" RendezVous");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Verfier la date !!");
            alert.showAndWait();
        }
        
     
    
    }

 
    @FXML
    private void valider(ActionEvent event) {
   
        RadioButton radio =(RadioButton)voteNote.getSelectedToggle();
       if(this.voteNote.getSelectedToggle().equals(this.ajt1)){
            try {
                Vote a =new Vote(1);
                VoteService af=new VoteService(); 
                af.ajouterAlaBaseVote(a);
            } catch (SQLException ex) {
                Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(this.voteNote.getSelectedToggle().equals(this.ajt0)){
            try {
                Vote a =new Vote(0);
                VoteService af=new VoteService(); 
                af.ajouterAlaBaseVote(a);
            } catch (SQLException ex) {
                Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(this.voteNote.getSelectedToggle().equals(this.ajt2)){
            try {
                Vote a =new Vote(2);
                VoteService af=new VoteService(); 
                af.ajouterAlaBaseVote(a);
            } catch (SQLException ex) {
                Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(this.voteNote.getSelectedToggle().equals(this.ajt3)){
            try {
                Vote a =new Vote(3);
                VoteService af=new VoteService(); 
                af.ajouterAlaBaseVote(a);
            } catch (SQLException ex) {
                Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
   
    }

    @FXML
    private void rechercheQ(KeyEvent event) {
         try {
            String idS =recherche2.getText();
            
            QuestionService aff= new QuestionService();
            aff.rechercheQuestion(idS);
            columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Question> observableArrayList =
             FXCollections.observableArrayList(aff.rechercheQuestion(idS));           
            tableauQues.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void consulterQ(ActionEvent event) throws IOException, SQLException {
        
             String idS= txt_idQ.getText();
             System.out.println("Id from other table"+idS);
            int id=parseInt(idS);
             System.out.println(id);
            ReponseService rf =new ReponseService();
            contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reponse> observableArrayList =
            FXCollections.observableArrayList(rf.getReponseQuid(id));
            tabq.setItems(observableArrayList);
                 // setData(idQ);

    }

    @FXML
    private void ajouterQuestion(ActionEvent event) {
    try {
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
    } catch (SQLException ex) {
        Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
     
    
    }
@FXML
    private void getInfo(MouseEvent event) throws NullPointerException {
        //
                   try {
                          
                   Question q = (Question) tableauQues.getSelectionModel().getSelectedItem();
                   
                   int idq=q.getIdquestion();
                       System.out.println("the id is"+idq);
                   String cont=q.getContenu();
                       System.out.println(cont);
                       txt_idQ.setText(""+String.valueOf(idq)); 
                       ajQues.setText(""+cont); 
                        
                          } catch (NullPointerException ex) {
               
                          }
                 }
    
    @FXML
    private void modifq(ActionEvent event) {
    try {
        QuestionService qst = new QuestionService();
        Question q=new Question();
        String contenu=ajQues.getText();
        q.setContenu(contenu);
        int idq=q.getIdquestion();
        qst.modifierQuestion(q, Integer.valueOf(txt_idQ.getText()));
        columcontenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        ObservableList<Question> observableArrayList =
                FXCollections.observableArrayList(qst.afficherQuestionsComplet());
        tableauQues.setItems(observableArrayList);
    } catch (SQLException ex) {
        Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }

    @FXML
    private void ajtreponse(ActionEvent event) {
         try {
            Reponse a =new Reponse();
            ReponseService af=new ReponseService();
               String contenuu= ajtreponse.getText();
               a.setContenu(contenuu);
            int idr=a.getIdquestion();
            int aj=af.ajouterAlaBaseReponse(a,Integer.valueOf(txt_idQ.getText()));
          
           
            if(aj>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reponse");
                alert.setHeaderText("INFORMATIONS");
                alert.setContentText("la Reponse a été ajouté !!");
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
            contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reponse> observableArrayList =
            FXCollections.observableArrayList(af.getReponseQuid(idr));
            tabq.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(RecClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void supprimerreponse(ActionEvent event) {
         try {
        Reponse rep =new Reponse();
        rep= tabq.getSelectionModel().getSelectedItem();
        ReponseService qs = new ReponseService();
        qs.supprimerReponse(rep);
              contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reponse> observableArrayList =
            FXCollections.observableArrayList(qs.getReponsesvisible());
            tabq.setItems(observableArrayList);
        
    } catch (SQLException ex) {
        Logger.getLogger(RecUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }

    @FXML
    private void back(MouseEvent event) {
                 try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("/presentation/menu.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
}

