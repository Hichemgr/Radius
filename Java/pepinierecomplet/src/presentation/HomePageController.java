/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import entite.Base;
import entite.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class HomePageController implements Initializable {
Connection cnx;
    @FXML
    private Button AjP;
    @FXML
    private Button prods;
    private Button menuAcceuil;
    @FXML
    private ImageView baack;

    
    
     @FXML
    private void gotoAjouter(ActionEvent event) throws IOException  {
        System.out.println("Ajouter Accessed");
        Parent Pajout = FXMLLoader.load(getClass().getResource("AjoutP.fxml"));
        Scene Ajout = new Scene(Pajout,1920,1080);
        Stage Sajout = (Stage)((Node) event.getSource()).getScene().getWindow();
           
                Sajout.setScene(Ajout);
                Sajout.show(); 
             
               
    } 
    @FXML
    private void gotocatalogue(ActionEvent event) throws IOException  {
        System.out.println("Catalogue Accessed");
        Parent Pmodif = FXMLLoader.load(getClass().getResource("catalogue.fxml"));
        Scene Modif = new Scene(Pmodif,1920,1080);
        Stage Smodif = (Stage)((Node) event.getSource()).getScene().getWindow();
           
                Smodif.setScene(Modif);
                Smodif.show(); 
             
               
    } 
   
     public  ArrayList<Produit> VerifStocks() throws SQLException  {
       ArrayList<Produit> listprod = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `produit` WHERE quantite<20 ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
            String nom_prod= resultat.getString("nomproduit");
            int quantite_prod= resultat.getInt("quantite");
            
           listprod.add(new Produit(nom_prod,quantite_prod));
           
            }
      return listprod;
     }
    @FXML
    private void gotoProds(ActionEvent event) throws IOException   {
        
             System.out.println("Prods Accessed");
             Parent Pprod = FXMLLoader.load(getClass().getResource("Prods.fxml"));
             Scene Prod = new Scene(Pprod);
             Stage Sprod = (Stage)((Node) event.getSource()).getScene().getWindow();
             
             Sprod.setScene(Prod); 
            Sprod.show();
       
             
               
    } 
        @Override
    public void initialize(URL url, ResourceBundle rb) {
    //ToDo
    } 

    private void acceuil(MouseEvent event) {
            try {
                   menuAcceuil.getScene().setRoot(FXMLLoader.load(getClass().getResource("utilisateurback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void back(MouseEvent event) {
         try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("utilisateurback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

   
        
    }    
    

