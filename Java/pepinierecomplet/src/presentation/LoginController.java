/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.utilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;
import service.utilisateurservice;
import sun.awt.image.ImageAccessException;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LoginController implements Initializable {
   @FXML
   private Button login;
    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
   @FXML
    private TextArea area;
    @FXML
    private Text mail;
    
    @FXML
    private AnchorPane a;
    @FXML
    private ImageView i;
    @FXML
    private Button inscription;
    private Text mdpoublie;
    @FXML
    private Text mdplost;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
     
                try {

                    utilisateurservice us = new utilisateurservice();
                   
                    if((us.rechercherutilisateur(email.getText(),mdp.getText()))&&(us.getetatcompte(email.getText()).equals("on")))
                    {
                        
                       // System.out.println("hetha login: "+s);
                        if(!us.getvalidtioncode(email.getText())){
                            System.out.println("wsel");
                    us.login(email.getText(),mdp.getText());        
                    try {
                        login.getScene().setRoot(FXMLLoader.load(getClass().getResource("admininterface.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }}
                    else
                 {
                     try {
                        login.getScene().setRoot(FXMLLoader.load(getClass().getResource("codevalidation.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                 }}
                        else
                        {
                            if(!us.rechercherutilisateur(email.getText(),mdp.getText())){
                                Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur connection");
		alert.setHeaderText("Erreur de connection");
		alert.setContentText("L'email ou le mot de passe sont incorrects!");
		alert.showAndWait();
                            }
                            else{
                              Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur connection");
		alert.setHeaderText("Erreur de connection");
		alert.setContentText("Le compte est désactivé!");
		alert.showAndWait();
                        }
                    }
                    
               
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
                
                    
                    try {
                        inscription.getScene().setRoot(FXMLLoader.load(getClass().getResource("inscription.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
        });
          
    }    

    @FXML
    private void gotomdp(MouseEvent event) {
         
                    
                    try {
                        mdplost.getScene().setRoot(FXMLLoader.load(getClass().getResource("mdpoublie.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(MdpoublieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
       
    
    
}
