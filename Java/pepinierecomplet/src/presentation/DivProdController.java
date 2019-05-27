/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
//
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import entite.produit;
import entite.Base;
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
import entite.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import service.ProduitService;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DivProdController implements Initializable {

    ListView<Produit> list=new ListView<>();
             ObservableList<Produit> items = FXCollections.observableArrayList();
             private ObservableList<Produit> data;
             Connection cnx ;
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
    private Button shwprod;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ////////////////////////////////////////////////////////////////
        
        /////////////////////////////////////////////////////////////////
        
        try {
          
            ProduitService ps = new ProduitService() ;
            ArrayList <Produit> data= ps.getAllProduit();
            for(Produit p : data){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivProd.fxml"));
               // System.out.println(p.getNom_prod());
                txtitre.setText(p.getNom_prod());
                quantite.setText(String.valueOf(p.getPrix_prod())+" Dinars") ;
                Image imageURI2 = new Image("file:C://wamp64/www/image/" +p.getImagep());
                rectangle.setFill(new ImagePattern(imageURI2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DivProdController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
public void LoadValues(Produit e) throws IOException {
        txtitre.setText(e.getNom_prod());
        quantite.setText(String.valueOf(e.getPrix_prod()));
        Image imageURI2 = new Image("file:C://wamp64/www/image/" +e.getImagep()+"");
       rectangle.setFill(new ImagePattern(imageURI2));
      }
public ObservableList<Produit> loadProduit() throws SQLException {
      
         cnx = Base.getInstance().getCnx();
      
          PreparedStatement pt = cnx.prepareStatement("SELECT produit.nomproduit, produit.prix, produit.quantite,produit.imagep  from produit");
        
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            //int id = resultat.getInt("idproduit");
            String nom = resultat.getString("nomproduit");
         
            float prix = resultat.getFloat("prix");
            
            int quantite = resultat.getInt("quantite");
            
            String img=resultat.getString("imagep");
            Produit p=new Produit(nom,prix,img);
            items.add(p);
        }
         return items;
        
    }
   
    @FXML
    private void ShowProduct(MouseEvent event) {
         
    FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("ProdInfo.fxml"));
                    try {
                    Loader.load();
                } catch (IOException ex) {
                 }
               
                ProdInfoController aff= Loader.getController();
                 //Produit prod = (Produit) tab_prod.getSelectionModel().getSelectedItem();
                
                          String nomp=txtitre.getText(); 
                          String prix=quantite.getText(); 
                          //String img=txtitre.getText(); 
                        // txt_saison.setValue(""+saisonp);
                aff.setData(nomp,prix);
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                         
                          
                 
                 }
                            

   
    }

        
        
           
           
    

      
 




    

