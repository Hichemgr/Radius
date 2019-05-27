/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.Catalogue;
import entite.Catalogue;
import entite.Catalogue;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.CatalogueService;
import service.CatalogueService;
import service.CatalogueService;


/**
 * FXML Controller class
 *
 * @author raedm
 */
public class CatalogueController implements Initializable {
 @FXML
    private TextField   txt_rech;
@FXML
    private TextField   nom_c_sup;
@FXML
private Button sup;
    @FXML
    private TableColumn<Catalogue, Date> datedebut;
    @FXML
    private TableColumn<Catalogue, Date> datefin;
    @FXML
    private TableColumn<Catalogue, String> nomc;
    @FXML
    private TableColumn<Catalogue, String> saisonc;
     @FXML
       private TableView tab_catalogue;     
      @FXML
    private ComboBox<String>txt_saison;
      ObservableList<String> Saisons = FXCollections.observableArrayList("Hiver","Printemps","Ete","Automne");
    @FXML
    private Label titre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_saison.setItems(Saisons);
    }    
     @FXML
    private void goback(MouseEvent event) {
        try {
            System.out.println("Back");
            Parent Pajout = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene Ajout = new Scene(Pajout,1920,1080);
            Stage Sajout = (Stage)((Node) event.getSource()).getScene().getWindow();
            
            Sajout.setScene(Ajout);
            Sajout.show();
        } catch (IOException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void RechercherC(KeyEvent event) {
    try {
            CatalogueService cs=new CatalogueService() ;
            Catalogue c =new Catalogue();
            String c_rech= txt_rech.getText();
            ObservableList<Catalogue> observableArrayList;
            observableArrayList = FXCollections.observableArrayList(cs.FindCatalogue(c_rech));
            tab_catalogue.setItems(observableArrayList);
            nomc.setCellValueFactory(new PropertyValueFactory<>("nom_catalogue"));
            datedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
            datefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
            saisonc.setCellValueFactory(new PropertyValueFactory<>("saison"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void SupprimerC(ActionEvent event) throws SQLException{
    CatalogueService cs=new CatalogueService() ; 
          Catalogue c =new Catalogue();
          String nom_catalogue= nom_c_sup.getText();
      
       sup.setOnAction(e -> {
           
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation");
                  alert.setHeaderText("Really");
                  alert.setContentText("Are You Sure You Want To Delete?");
                  Optional <ButtonType> action = alert.showAndWait();
                  if(action.get()== ButtonType.OK) {
                      cs.SupprimerCatalogue(nom_catalogue);
                      AfficherCatalogues(event);
        }
       });
    }
    
    @FXML
    private void AfficherCatalogues(ActionEvent event){
    try {
            CatalogueService cs=new CatalogueService() ;
            Catalogue c =new Catalogue();
            String c_rech= txt_saison.getValue();
            titre.setText("Cataloge De "+c_rech);
            ObservableList<Catalogue> observableArrayList;
            observableArrayList = FXCollections.observableArrayList(cs.FindCatalogue(c_rech));
            tab_catalogue.setItems(observableArrayList);
            nomc.setCellValueFactory(new PropertyValueFactory<>("nom_catalogue"));
            datedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
            datefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
            saisonc.setCellValueFactory(new PropertyValueFactory<>("saison"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


