/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.Base;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import entite.Catalogue;
import entite.Produit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
        import service.CatalogueService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class AffecterprodController implements Initializable {
@FXML
    private TextField txt_nomc;
@FXML
    private TextField txt_saisonc;
    @FXML
    private DatePicker date_d_c;
    @FXML
    private DatePicker date_f_c;
    private Button Annuler;
    
    @FXML
            ListView<Catalogue> list=new ListView<>();
             ObservableList<Catalogue> items = FXCollections.observableArrayList();
     @FXML
    private ComboBox<String>txt_saison;
       Connection cnx;
      ObservableList<String> Saisons = FXCollections.observableArrayList("Hiver","Printemps","Ete","Automne");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         txt_saison.setItems(Saisons);
    }    
void setData(String nom,String saison) {
        txt_nomc.setText(""+nom);
         txt_saisonc.setText(""+saison);
         
}

    @FXML
    private void Affecter(ActionEvent event) throws SQLException {
        CatalogueService cs=new CatalogueService() ; 
       Catalogue c =new Catalogue();
       

String nomprod= txt_nomc.getText();
String saisonprod= txt_saisonc.getText() ;
 Date datedebut= java.sql.Date.valueOf(date_d_c.getValue());  
 //DatePicker datefin= date_f_c ; 
 Date datefin = java.sql.Date.valueOf(date_f_c.getValue());
 

c.setNom_catalogue(nomprod);
c.setSaison(saisonprod);
c.setDatedebut(datedebut);
c.setDatefin(datefin);
         
         
          cs.ajouterCatalogue(c);
    }

    @FXML
    private void Annuler(ActionEvent event) {
Stage stage = (Stage) Annuler.getScene().getWindow();
    stage.close();
    }

@FXML
private void Afficher_Catalogue(ActionEvent event ){

try {
    items.clear();
    list.getItems().clear();
      cnx=Base.getInstance().getCnx();
         Statement stmt = cnx.createStatement();
           String saisonc= txt_saison.getValue() ;

            ResultSet resultat = stmt.executeQuery("SELECT * FROM `catalogue` where saison='"+saisonc+"'");
            while (resultat.next()) {
                
                String nom = resultat.getString("nom");
              String saison = resultat.getString("saison");
//                Date debut= resultat.getDate("datedebut");
//                Date fin= resultat.getDate("datefin");
                 
              Catalogue c= new Catalogue(nom,saison);//s,debut,fin);
               items.add(c);
                 list.getItems().clear();
                list.getItems().addAll(items);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdsController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}


    

