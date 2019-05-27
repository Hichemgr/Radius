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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class AdmininterfaceController implements Initializable {

     @FXML
   private Button application;
      @FXML
   private Button back;
    @FXML
    private ImageView photoprofil;
    @FXML
    private Label prenom;
    @FXML
    private Label nom;
    @FXML
    private ImageView logout;
 /*   @FXML
    private ImageView photo;*/
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
             application.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                     
                     
                     
                     try {
                         application.getScene().setRoot(FXMLLoader.load(getClass().getResource("menu.fxml")));
                     } catch (IOException ex) {
                         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
             back.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                     
                     
                     
                     try {
                         back.getScene().setRoot(FXMLLoader.load(getClass().getResource("utilisateurback.fxml")));
                     } catch (IOException ex) {
                         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
             });
         } catch (SQLException ex) {
             Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

    @FXML
    private void logout(MouseEvent event) {
          try {
               utilisateurservice us = new utilisateurservice();
               us.deconnexionutilisateur("connecter");
               try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
}
