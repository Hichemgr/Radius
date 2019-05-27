/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHE;

//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import entite.produit;
import entite.Produit;
import entite.Promotion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//import service.panierservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DivPromotionController implements Initializable {

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
    private Label nomProd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void LoadValues(Promotion e) throws IOException {
        txtitre.setText(e.getNom());
        
        
        nomProd.setText(String.valueOf(e.getNomproduit()));
       // System.out.println(e.getIdproduit()).
        quantite.setText(String.valueOf(e.getNouveauprix()));
      
        
       
//        sq.setPadding(new Insets(-10, -10, -10, -10));

      // Image imageURI = new Image("file:C://wamp64/www/image/" + e.getNomproduit()+".png");
     //  file:C://wamp64/www/image/" +"radius.png"
//        circle.setFill(new ImagePattern(imageURI));
//       qualite.setRating(e.getMoyqualite());
       Image imageURI2 = new Image("file:C://wamp64/www/image/" +e.getNomproduit()+".png");
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
 




 public void doubleclick(MouseEvent event, Promotion selectedetab) {
      /*  if (event.getClickCount() == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/ProfilHotel.fxml"));
                Parent root = loader.load();
                ProfilHotelController DDC = loader.getController();
                DDC.Reviewslist(selectedetab);
                DDC.RestoProfil(selectedetab.getId());
                FXMLLoader loade = new FXMLLoader(getClass().getResource("../Views/HomePage.fxml"));
                Parent roo = loade.load();
                HomePageController Dhp = loade.getController();
                Stage ss=new Stage();
                Scene sc = new Scene(root);
                ss.setScene(sc);
                ss.setWidth(1288);
                ss.setHeight(750);
                
                
                ss.show();

            } catch (IOException | SQLException ex) {
                Logger.getLogger(ListrestoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }

   
    
}
