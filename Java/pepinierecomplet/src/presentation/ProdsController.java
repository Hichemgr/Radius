/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
//////////////////////////////////////////


import presentation.DivProdController;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import entite.Base;
import entite.Produit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class ProdsController implements Initializable {
    Connection cnx ;
    ListView<Produit> list=new ListView<>();
             ObservableList<Produit> items = FXCollections.observableArrayList();
             private ObservableList<Produit> data;
    @FXML
    private ImageView wishlist;
    @FXML
    private ImageView back;
    @FXML
     private ScrollPane pane;
    //private ImageView img_prod;
    private Rectangle img_prod;
     Produit p;
    @FXML
    private ImageView baack;

    /**
     * Initializes the controller class.
     */
//   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));
            
            //AffichageAjout aff= new AffichageAjout();
            
           data = loadProduit();
            for ( Produit d : data) {
                
                try {
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivProd.fxml"));
                    Parent root = (Pane) loader.load();
                    DivProdController DHC = loader.getController();
                    DHC.LoadValues(d);
                    
                    //   c.setVgap(40);
                    c.getChildren().removeAll();
                    
                    
                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ProdsController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ProdsController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }   
//////////////////////////////////////////////////////////////////////////////////////////Load Content////////////////////////////////////////////
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
    //////////////////////////////////////////////////////////////////////////////////////////Load Content////////////////////////////////////////////
    
    @FXML
    private void gotoWishList(MouseEvent event) throws IOException {
    System.out.println("Prods Accessed");
             Parent wlist = FXMLLoader.load(getClass().getResource("WishList.fxml"));
             Scene Wlist = new Scene(wlist,1920,1080);
             Stage Swlist = (Stage)((Node) event.getSource()).getScene().getWindow();
             
             Swlist.setScene(Wlist); 
            Swlist.show();
    }

    @FXML
    private void Goback(MouseEvent event) {
         try {
            System.out.println("Back");
            Parent Pajout = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene Ajout = new Scene(Pajout,1920,1080);
            Stage Sajout = (Stage)((Node) event.getSource()).getScene().getWindow();
            
            Sajout.setScene(Ajout);
            Sajout.show();
        } catch (IOException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back(MouseEvent event) {
          try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("menu.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
}    

