/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.ligneproduit;
import entite.panier;
import entite.Produit;
import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.ligneproduitservice;
import service.panierservice;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author Hichem
 */
public class AjoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button ajouter;
   // private Button panier;
    @FXML
    private TextField quantite;
    @FXML
    private TextField idproduit;
    @FXML
    private Label nom;
    @FXML
    private Label prenom; int idproduit1 ;
    @FXML
    private ImageView panierimg;
    @FXML
    private Button panier2;
    @FXML
    private ImageView photoprofil;
    //@FXML
    //private ComboBox combo;
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
          Image a=new Image("image/cart.png");
            panierimg.setImage(a);
            utilisateurservice us = new utilisateurservice();
            ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
            String u="";
            for(utilisateur e:utilisateurs){
                nom.setText(e.getNom());
                prenom.setText(e.getPrenom());
                System.out.println(nom.getText());
                u=e.getPhotoprofil();
            }
            Image a1=new Image("file:C:/wamp64/www/image/"+u);
             photoprofil.setImage(a1);
            ajouter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    try {
                        
                        panierservice ps = new panierservice();
                        String nom1=nom.getText();
                        String prenom1=prenom.getText();
                        
                        int idutilisateur=ps.rechercheridutili(nom1, prenom1);
                        System.out.println(idutilisateur);
                        idproduit1=Integer.valueOf(idproduit.getText());
                        int quantite1=Integer.valueOf(quantite.getText());
                        
                        
                        //combo.getItems().addAll(Integer.valueOf(ps.getquantite()));
                        
                        // while(ps.rechercherproduit(Integer.valueOf(idproduit.getText())))
                        //{
                        
                        //}
                        
                        
                        int x=ps.rechercherutilisateur(idutilisateur);
                        ligneproduitservice lps= new ligneproduitservice();
                        ligneproduit lp = new ligneproduit(x,idproduit1,quantite1);
                        if(x!=0) //aandou panier el x
                        {
                            if(!ps.rechercherproduit(x,idproduit1))
                            {
                                lps.ajouterauligneproduit(lp);
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Information");
                                alert.setHeaderText("votre produit a été ajouté à votre panier");
                                alert.setContentText("produit ajouté avec succes ");
                                
                                alert.showAndWait();
                                
                            }
                            else
                            {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Information");
                                alert.setHeaderText("produit existant dans votre panier");
                                alert.setContentText("noooooo ");
                                alert.showAndWait();
                                
                            }
                        }
                        else 
                        {
                            if(!ps.rechercherproduit(x,idproduit1)){
                                panierservice pas= new panierservice();
                                panier p = new panier(idutilisateur,0);
                                pas.ajouterAlaBase2(p);
                                int y=ps.rechercherutilisateur(idutilisateur);
                                ligneproduit lp1 = new ligneproduit(y,idproduit1,quantite1);
                                lps.ajouterauligneproduit(lp1);
                                
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Information");
                                alert.setHeaderText("votre produit a été ajouté dans votre nouveau panier");
                                alert.setContentText("produit ajouté avec succes");
                                
                                alert.showAndWait();
                                
                            }
                            else
                            {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Information");
                                alert.setHeaderText("produit existanan");
                                alert.setContentText("noooooo ");
                                alert.showAndWait();
                                
                            }
                            
                        }
                        
                        
                        /*  try {
                        ajouter.getScene().setRoot(FXMLLoader.load(getClass().getResource("affiche.fxml")));
                        } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                    } catch (SQLException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            
            /*    panier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            
            
            
            try {
            panier.getScene().setRoot(FXMLLoader.load(getClass().getResource("affiche.fxml")));
            } catch (IOException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            });*/
            panier2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    
                    
                    try {
                        panier2.getScene().setRoot(FXMLLoader.load(getClass().getResource("ListArticles.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    /*@FXML
    private void verspanier(MouseEvent event) {
        try {
                        panierimg.getScene().setRoot(FXMLLoader.load(getClass().getResource("affiche.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }*/

    @FXML
    private void verspanier(MouseEvent event) {
    }

    
    

    
        
   

    
}
