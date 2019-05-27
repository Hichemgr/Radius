/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.Base;
import entite.Produit;
import entite.Wishlist;
import entite.ligneproduit;
import entite.panier;
import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import service.WishlistService;
import service.ligneproduitservice;
import service.panierservice;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class ProdInfoController implements Initializable {

    @FXML
    private Label nom;
    Connection cnx;
    @FXML
    private Rectangle pic;
    @FXML
    private Label nom_prod;
    @FXML
    private TextArea description_prod;
    @FXML
    private Label prix_prod;
    @FXML
    private Label quantite_prod;
    @FXML
    private Label note_prod;
    @FXML
    private Label saison_prod;
    @FXML
    private Label cin_usr;
    @FXML
    private Label idprod;
    @FXML
    private Button ajouterpanier;
    @FXML
    private Label prenom;
    @FXML
    private ImageView photoprofil;
    @FXML
    private TextField quantite;
    @FXML
    private Button panier2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
       //     Image a=new Image("image/cart.png");
            // panierimg.setImage(a);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    void setData(String nomp,String prixp) {
        try {
            nom_prod.setText(""+nomp);
            prix_prod.setText(""+prixp);
            ////////////////////////////////Get Rest Of Info///////////////////////////
            cnx = Base.getInstance().getCnx();
            
            PreparedStatement pt = cnx.prepareStatement("SELECT *  from produit where nomproduit='"+nomp+"'");
            String prixs="";
            String img="";
            ResultSet resultat = pt.executeQuery();
            while (resultat.next()) {
                int id=resultat.getInt("idproduit");
                String nom = resultat.getString("nomproduit");
               float prixx=Float.valueOf(prixp);
              int quantite = resultat.getInt("quantite");
                int note = resultat.getInt("note");
                String saison = resultat.getString("saison");
               String description = resultat.getString("description");
                img = resultat.getString("imagep");
                 idprod.setText(String.valueOf(id));
                quantite_prod.setText(""+quantite+" Pieces");
                note_prod.setText(""+note+" /5");
                saison_prod.setText(""+saison);
                description_prod.setText(""+description);
                Image imageURI2 = new Image("file:C://wamp64/www/image/" +img);
                pic.setFill(new ImagePattern(imageURI2));
                
                
                
            }
            
            /////////////////////////////////////////////////////////////////////////
            //txt_saisonc.setText(""+saison);
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
}
    
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
    private void AjouterWishlist(ActionEvent event) throws SQLException {
     
       WishlistService pss=new WishlistService() ; 
       Wishlist p =new Wishlist();
String nomprod= nom_prod.getText();

float prixprod = Float.valueOf(prix_prod.getText());
long cin = Long.valueOf(cin_usr.getText());
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
LocalDate dateajout= LocalDate.now(); 
      
String dtajout=dateajout.toString();

         int i=0;
          p.setNom_prod(nomprod);
          
          p.setPrix_prod(prixprod);
          p.setCin(cin);
          p.setDateajout_wish(dtajout);
          
          pss.ajouterWAlaBase(p,cin);
          
          //AfficherProduits(event);
      
}
    private void ShowProduct(MouseEvent event) {
                    try {
                        int ciin;
                        ///////////////////////////////Get Ciin/////////////////////////////////////
                        utilisateurservice us = new utilisateurservice();
                        ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
                        String u="";
                        for(utilisateur e:utilisateurs){
                            ciin=e.getCin();
                            System.out.println(ciin);
                           String cin=String.valueOf(ciin);
                            cin_usr.setText(cin);
                        }
                        ////////////////////////////////////////////////////////////////////////
                        
                        FXMLLoader Loader = new FXMLLoader();
                        Loader.setLocation(getClass().getResource("WishList.fxml"));
                        try {
                            Loader.load();
                        } catch (IOException ex) {
                        }
                        
                        WishListController aff= Loader.getController();
                        //Produit prod = (Produit) tab_prod.getSelectionModel().getSelectedItem();
                        
                        String cin1=cin_usr.getText();
                        
                        //String img=txtitre.getText();
                        // txt_saison.setValue(""+saisonp);
                        aff.setData(cin1);
                        Parent p = Loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(p));
                        stage.show();
                        
                        
                        
                    } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                         
                          
                 
                 }

    @FXML
    private void ajouterpanier(MouseEvent event) throws SQLException, NoSuchAlgorithmException {
       
            ajouterpanier.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    
                    try {
                        
                        panierservice ps = new panierservice();
                        String nom1=nom.getText();
                        String prenom1=prenom.getText();
                        
                        int idutilisateur=ps.rechercheridutili(nom1, prenom1);
                        System.out.println(idutilisateur);
                        int idproduit1=Integer.valueOf(idprod.getText());
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
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Information");
                                alert.setHeaderText("votre produit a été ajouté à votre panier");
                                alert.setContentText("produit ajouté avec succes ");
                                
                                alert.showAndWait();
                                
                            }
                            else
                            {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
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
                                
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Information");
                                alert.setHeaderText("votre produit a été ajouté dans votre nouveau panier");
                                alert.setContentText("produit ajouté avec succes");
                                
                                alert.showAndWait();
                                
                            }
                            else
                            {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
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
         
        } 

    @FXML
    private void gopanier(MouseEvent event) {
        try {
                        panier2.getScene().setRoot(FXMLLoader.load(getClass().getResource("ListArticles.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    }    
    
    

