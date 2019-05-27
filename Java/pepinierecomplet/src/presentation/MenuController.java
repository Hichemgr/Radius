/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuController implements Initializable {
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
    @FXML
    private Button menuDeconnexion;
    @FXML
    private ImageView cata;
    @FXML
    private ImageView promotaswira;
    @FXML
    private ImageView assis;
    @FXML
    private ImageView photoprofil;
    @FXML
    private Label prenom;
    @FXML
    private Label nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            utilisateurservice us = new utilisateurservice();
            ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
            String u="";
            for(utilisateur e:utilisateurs){
                nom.setText(e.getNom());
                prenom.setText(e.getPrenom());
                u=e.getPhotoprofil();
            }
            Image a=new Image("file:C:/wamp64/www/image/"+u);
            photoprofil.setImage(a);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void heznicatalogue(MouseEvent event) {
         
               try {
                   cata.getScene().setRoot(FXMLLoader.load(getClass().getResource("Prods.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
         
    }

    @FXML
    private void heznipromo(MouseEvent event) {
         try {
                   promotaswira.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/listPromotion.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void hezniassis(MouseEvent event) {
          try {
                   assis.getScene().setRoot(FXMLLoader.load(getClass().getResource("/Graphique/AssisstanceFront.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void acceuil(MouseEvent event) {
    }

    @FXML
    private void catalogue(MouseEvent event) {
        try {
                   cata.getScene().setRoot(FXMLLoader.load(getClass().getResource("Prods.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void livraison(MouseEvent event) {
         try {
                   menuService.getScene().setRoot(FXMLLoader.load(getClass().getResource("/Graphique/LivraisonFront.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void promotion(MouseEvent event) {
        try {
                   promotaswira.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/listPromotion.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void reclamation(MouseEvent event) {
         try {
                   menuReclamation.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHECLIENT/RecClient.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void logout(MouseEvent event) {
         try {
               utilisateurservice us = new utilisateurservice();
               us.deconnexionutilisateur("connecter");
               try {
                   menuDeconnexion.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (SQLException ex) {
                        Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    @FXML
    private void goprofil(MouseEvent event) {
                 try {
                   photoprofil.getScene().setRoot(FXMLLoader.load(getClass().getResource("profil.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
}
