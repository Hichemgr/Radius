/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHECLIENT;

import GRAPHE.QuesReponsesController;
import Service.ReponseService;
import entites.Reponse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc hp
 */
public class ReponsesController implements Initializable {
    @FXML
    private TableView<Reponse> tabq;
    @FXML
    private TableColumn<Reponse, String> nomq;
    @FXML
    private TableColumn<Reponse, String> contenuq;
    @FXML
    private Button retour;
    @FXML
    private Button ajouterRep;
    @FXML
    private TextField rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            ReponseService rf =new ReponseService();
            nomq.setCellValueFactory(new PropertyValueFactory<>("nom"));
            contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reponse> observableArrayList =
                    FXCollections.observableArrayList(rf.getReponseQu());
            tabq.setItems(observableArrayList);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ReponsesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void retour(ActionEvent event) {
          try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("ReClient.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    } catch (IOException ex) {
        Logger.getLogger(ReponsesController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void ajouterRep(ActionEvent event) {
        try {
            String contenu =rep.getText();
            
            Reponse a =new Reponse(contenu);
            ReponseService rf=new ReponseService();
            int aj=rf.ajouterAlaBaseReponse(a);
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
                alert.setTitle(" Reponse");
                alert.setHeaderText("INFORMATIONS");
                alert.setContentText("ERREUR !!");
                alert.showAndWait();
            }
            

            nomq.setCellValueFactory(new PropertyValueFactory<>("nom"));
            contenuq.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            ObservableList<Reponse> observableArrayList =
                    FXCollections.observableArrayList(rf.getReponseQu());
            tabq.setItems(observableArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(ReponsesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
