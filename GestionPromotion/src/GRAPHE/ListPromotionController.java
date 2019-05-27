/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHE;


import entite.MyBD;
import entite.Promotion;
//import controller.AffichageAjout;
import entite.Produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

import java.util.Locale;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListPromotionController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private ScrollPane pane;
     private ObservableList<Promotion> data;
     Connection cnx;
     @FXML
    private Label nom;
    @FXML
    private Label prenom;
    ObservableList<Promotion> items = FXCollections.observableArrayList();
  //  @FXML
//    private JFXTextField recherchetext;

    /**
     * Initializes the controller class.
     */
       public ObservableList<Promotion> loadPanier() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
//String req="";
         cnx = MyBD.getInstance().getCnx();
      //  listview.getItems().clear();
      
          PreparedStatement pt = cnx.prepareStatement("SELECT promotion.nom,promotion.nomproduit,promotion.nouveauprix FROM `promotion` ");
        //PreparedStatement pt = cnx.prepareStatement("SELECT produit.nom_prod,produit.prix,panier.date_ajout,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=?");
       
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            
            String nom = resultat.getString("nom");
            String nomproduit = resultat.getString("nomproduit");
          //  items.add("Nom:   " + nom);
           // productsNames.add(nom);
            float nouveauprix = resultat.getFloat("nouveauprix");
            //items.add("Prix:   " + Float.toString(prix));
           // Date date = resultat.getDate("date_ajout");
           // int quantite = resultat.getInt("quantite");
            
            //items.add("Quantité:  " + Integer.toString(quantite));
            
//            items.add("*********************************************************");
            Promotion p=new Promotion(nom,nomproduit,nouveauprix);
            items.add(p);
           
        //    listview.getItems().addAll(items);
            

        }
         return items;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        try {
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));
            
            //AffichageAjout aff= new AffichageAjout();
            
           data = loadPanier();
            for ( Promotion d : data) {
                
                try {
                    
                    
                    
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivPromotion.fxml"));
                    Parent root = (Pane) loader.load();
                    DivPromotionController DHC = loader.getController();
                    DHC.LoadValues(d);
                    
                    //   c.setVgap(40);
                    c.getChildren().removeAll();
                    
                    
                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ListPromotionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);
            
                    
                    
                }catch (SQLException ex) {
                    Logger.getLogger(ListPromotionController.class.getName()).log(Level.SEVERE, null, ex);
                }
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
        
     
        
       

    }

   
    

  
     

   
    
}
