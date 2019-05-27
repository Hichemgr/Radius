/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entite.Produit;
import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import service.panierservice;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DivArticleController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label txtitre;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Label quantite;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TextField nouvquantite;
    Connection cnx;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
   
            
            
                    

    /**
     * Initializes the controller class.
     * @return 
     */
  /*  public ObservableList <String> getquantite(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select quantite from  produit ";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("quantite"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            utilisateurservice us = new utilisateurservice();
            ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
            String u="";
            for(utilisateur e:utilisateurs){
              
                nom.setText(e.getNom());
                prenom.setText(e.getPrenom());
                System.out.println(nom.getText());
                u=e.getPhotoprofil();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
        
    }
public void LoadValues(Produit e) throws IOException {
        txtitre.setText(e.getNom_prod());
 
        
        id.setText(String.valueOf(e.getRef_prod()));
       // System.out.println(e.getIdproduit());
        quantite.setText(String.valueOf(e.getQuantite_prod()));
     //   combo.setItems(getquantite());
        
        
        
       
//        sq.setPadding(new Insets(-10, -10, -10, -10));

       // Image imageURI = new Image("file:C:/wamp64/www/Images/" + e.getImage());
//        circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
        Image imageURI2 = new Image("file:C://wamp64/www/image/"+e.getNom_prod()+".png");
       rectangle.setFill(new ImagePattern(imageURI2));
       // rectangle
      /////////fhemna
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    doubleclick(event, e);
                }

            }
        });
     /*   supprimer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)   {
                supprimerproduit();
               
                
            }
        });*/
        
        
           
           
    

      }
 




 public void doubleclick(MouseEvent event, Produit selectedetab) {
     
    }

    @FXML
    private void supprimerproduit(MouseEvent event) {
         try {
                    panierservice lm=new panierservice();
                    //videepanier();
                     String nom1=nom.getText();
            String prenom1=prenom.getText();
                    // vider.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
                    
                    //int sup=Integer.valueOf(suppid.getText());
                    int idprod=Integer.valueOf(id.getText());
                    //panierservice ps2= new panierservice();
        int id1=lm.rechercheridutili(nom1, prenom1);
           //System.out.println(id1);
           int id2=lm.rechercherutilisateur(id1);
                    //System.out.println(idprod);
                   // String nom1=nom.getText();
                    //String prenom1=prenom.getText();
                    //panierservice ps2= new panierservice();
                     //int id1=ps2.rechercheridutili(nom1, prenom1);
                     //int id2=ps2.rechercherutilisateur(id1);
                    lm.supprimeridproduit(idprod,id2);
                  //  LoadValues(e);
                  // loadPanier();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("produit");
                        alert.setHeaderText("votre produit a été supprimé ");
                    //    alert.setContentText("noooooo ");
                        alert.showAndWait();
                        
                      //  Optional<ButtonType> result = alert.showAndWait();
                      /*  if (result.get() == ButtonType.OK){
                            
                        }*/
                        
                    
                    
                    
                    //Retour.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
                    
                    
                    
   //              } catch (IOException ex) {
     //                   Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void modifierquantite(MouseEvent event) {
        try {
                    panierservice lm=new panierservice();
                     String nom1=nom.getText();
            String prenom1=prenom.getText();
                    //videepanier();
                    // vider.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
            int id1=lm.rechercheridutili(nom1, prenom1);
           //System.out.println(id1);
           int id2=lm.rechercherutilisateur(id1);
                    //int sup=Integer.valueOf(suppid.getText());
                    int idprod=Integer.valueOf(id.getText());
                    int quant=Integer.valueOf(nouvquantite.getText());
                    //System.out.println(idprod);
                   // String nom1=nom.getText();
                    //String prenom1=prenom.getText();
                    //panierservice ps2= new panierservice();
                     //int id1=ps2.rechercheridutili(nom1, prenom1);
                     //int id2=ps2.rechercherutilisateur(id1);
                    lm.modifierquantite(id2,quant,idprod);
                  //  LoadValues(e);
                  // loadPanier();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("produit");
                        alert.setHeaderText("La quantite a été modifié avec succés ");
                    //    alert.setContentText("noooooo ");
                        alert.showAndWait();
                        
                   
                } catch (SQLException ex) {
                    Logger.getLogger(DivArticleController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

   
    
}
