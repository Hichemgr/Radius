/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.ligneproduit;
import entite.panier;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import service.ligneproduitservice;
import service.panierservice;
//import Libraries.gluonhq.charm.glisten.control.TextField;
/**
 * FXML Controller class
 *
 * @author Hichem
 */
public class BackcommandeController implements Initializable {
    @FXML
    private TableView<panier> listback;
    @FXML
    private TableColumn<?, ?> idutilisateur;
    @FXML
    private TableColumn<?, ?> idpanier;
    @FXML
    private TableColumn<?, ?> etat;
    //@FXML
    //private TableColumn<?, ?> prixtotale;
   // @FXML
   // private TableColumn<?, ?> prixtotale;
    @FXML
    private TableView<ligneproduit> tableprod;
    @FXML
    private TableColumn<?, ?> idligne;
    @FXML
    private TableColumn<?, ?> idproduit;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TextField rechercher;
    @FXML
    private TableColumn<?, ?> idpanier2;
    @FXML
    private TextField rechercherligne;
    @FXML
    private Button menuAcceuil;
    @FXML
    private Button menuProduit;
    @FXML
    private Button menuService;
    @FXML
    private Button menuEvenement;
    @FXML
    private Button menuReclamation;
    @FXML
    private Button menuForum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {

            panierservice ps= new panierservice();
            ArrayList<panier> paniers = new ArrayList<>();
            try {
                paniers=(ArrayList<panier>) ps.getback();
            } catch (SQLException ex) {
                Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<panier> obsl = FXCollections.observableArrayList(paniers);
            listback.setItems(obsl);
            idpanier.setCellValueFactory(new PropertyValueFactory<>("idpanier"));
            idutilisateur.setCellValueFactory(new PropertyValueFactory<>("idutilisateur"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
           // prixtotale.setCellValueFactory(new PropertyValueFactory<>("5"));
        } catch (SQLException ex) {
            Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {

            panierservice ps= new panierservice();
            ArrayList<ligneproduit> paniers = new ArrayList<>();
            try {
                paniers=(ArrayList<ligneproduit>) ps.getbackprod();
            } catch (SQLException ex) {
                Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<ligneproduit> obsl = FXCollections.observableArrayList(paniers);
            tableprod.setItems(obsl);
            idligne.setCellValueFactory(new PropertyValueFactory<>("idligne"));
            idpanier2.setCellValueFactory(new PropertyValueFactory<>("idpanier"));
            idproduit.setCellValueFactory(new PropertyValueFactory<>("idproduit"));
             quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
           // prixtotale.setCellValueFactory(new PropertyValueFactory<>("5"));
        } catch (SQLException ex) {
            Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void rech(KeyEvent event) {
          try {

            panierservice ps= new panierservice();
            ArrayList<panier> paniers = new ArrayList<>();
            
            try {
                paniers=(ArrayList<panier>) ps.rechercherpanier(rechercher.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<panier> obsl = FXCollections.observableArrayList(paniers);
            listback.setItems(obsl);
            idpanier.setCellValueFactory(new PropertyValueFactory<>("idpanier"));
            idutilisateur.setCellValueFactory(new PropertyValueFactory<>("idutilisateur"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
           // prixtotale.setCellValueFactory(new PropertyValueFactory<>("5"));
        } catch (SQLException ex) {
            Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void rech2(KeyEvent event) {
          try {

            panierservice ps= new panierservice();
            ArrayList<ligneproduit> paniers = new ArrayList<>();
            try {
                paniers=(ArrayList<ligneproduit>) ps.rechercherligne(rechercherligne.getText());
            } catch (SQLException ex) {
                Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<ligneproduit> obsl = FXCollections.observableArrayList(paniers);
            tableprod.setItems(obsl);
            idligne.setCellValueFactory(new PropertyValueFactory<>("idligne"));
            idpanier2.setCellValueFactory(new PropertyValueFactory<>("idpanier"));
            idproduit.setCellValueFactory(new PropertyValueFactory<>("idproduit"));
             quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
           // prixtotale.setCellValueFactory(new PropertyValueFactory<>("5"));
        } catch (SQLException ex) {
            Logger.getLogger(BackcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @FXML
    private void acceuil(MouseEvent event) {
            try {
                   menuAcceuil.getScene().setRoot(FXMLLoader.load(getClass().getResource("utilisateurback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void prod(MouseEvent event) {
          try {
                   menuProduit.getScene().setRoot(FXMLLoader.load(getClass().getResource("HomePage.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void commande(MouseEvent event) {
         try {
                   menuService.getScene().setRoot(FXMLLoader.load(getClass().getResource("Backcommande.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void promotion(MouseEvent event) {
         try {
                   menuEvenement.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/PromotionUser.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void reclamation(MouseEvent event) {
        try {
                   menuReclamation.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/recUtilisateur.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void livraison(MouseEvent event) {
    }

    
    
}
