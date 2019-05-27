/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.Produit;
import entite.Wishlist;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ProduitService;
import service.WishlistService;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class WishListController implements Initializable {

    @FXML
    private TableColumn<Wishlist, String> nomp;
    @FXML
    private TableColumn<Wishlist, Float> prixp;
    @FXML
    private TableColumn<Wishlist, Date> datep;
    @FXML
    private TableView<Wishlist> tab_wish;
    @FXML
    private TextField txt_sup;
    @FXML
    private TextField txt_rech;
    @FXML
    private Button btn_sup;
    @FXML
    private Label cin_usr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            WishlistService wrs = null;
            
            wrs = new WishlistService();
            
            ObservableList<Wishlist> observableArrayList = null;
            
            observableArrayList = FXCollections.observableArrayList(wrs.getWishlist());
            
            tab_wish.setItems(observableArrayList);
            nomp.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
            prixp.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
            
            datep.setCellValueFactory(new PropertyValueFactory<>("dateajout_wish"));
        } catch (SQLException ex) {
            Logger.getLogger(WishListController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
              
    }  
    
    @FXML
    private void goback(MouseEvent event) {
         try {
            System.out.println("Back");
            Parent Pajout = FXMLLoader.load(getClass().getResource("Prods.fxml"));
            Scene Ajout = new Scene(Pajout,1920,1080);
            Stage Sajout = (Stage)((Node) event.getSource()).getScene().getWindow();
            
            Sajout.setScene(Ajout);
            Sajout.show();
        } catch (IOException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
       private void SupprimerW(ActionEvent event) throws SQLException  {
          WishlistService pss=new WishlistService() ; 
          Wishlist p =new Wishlist();
          String nom_prods= txt_sup.getText();
          String cin1=cin_usr.getText();
          long cin=Long.parseLong(cin1);
      
       btn_sup.setOnAction(e -> {
           
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation");
                  alert.setHeaderText("Really");
                  alert.setContentText("Are You Sure You Want To Delete?");
                  Optional <ButtonType> action = alert.showAndWait();
                  if(action.get()== ButtonType.OK) {
                      pss.SupprimerWishlist(cin,nom_prods);
                      AfficherW();
              }
       });
       }
   

                    
                

    @FXML
    private void RechercherWishlist(KeyEvent event) {
    try {
            WishlistService pss=new WishlistService() ;
           Wishlist p =new Wishlist();
            String prod_rech= txt_rech.getText();
           String cin1=cin_usr.getText();
            int cin=Integer.parseInt(cin1);
            ObservableList<Wishlist> observableArrayList;
            observableArrayList = FXCollections.observableArrayList(pss.FindWishlist(prod_rech,cin));
            tab_wish.setItems(observableArrayList);
          
            tab_wish.setItems(observableArrayList);
            nomp.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
            prixp.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
            datep.setCellValueFactory(new PropertyValueFactory<>("dateajout_wish"));
            //tab.refresh();
            // AfficherW();
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void setData(String cin1) {
        
            cin_usr.setText(""+cin1);
        }
    private void getInfo(KeyEvent event) {
        
    }

  private void AfficherW(){
      try {
            WishlistService wrs;
            
            wrs = new WishlistService();
            
            ObservableList<Wishlist> observableArrayList;
            observableArrayList = FXCollections.observableArrayList(wrs.getWishlist());
            
            tab_wish.setItems(observableArrayList);
            nomp.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
            prixp.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
            
            datep.setCellValueFactory(new PropertyValueFactory<>("dateajout_wish"));
        } catch (SQLException ex) {
            Logger.getLogger(WishListController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
  }

    @FXML
    private void getInfo(MouseEvent event) {
          Wishlist p = (Wishlist) tab_wish.getSelectionModel().getSelectedItem();
                   String nompp= p.getNom_prod();
                   
                    txt_sup.setText(""+nompp);
    }
   
}
