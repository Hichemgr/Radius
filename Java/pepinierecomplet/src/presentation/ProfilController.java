/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.utilisateur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import service.upload;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProfilController implements Initializable {
    @FXML
    private ImageView photoprofil;
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private Button modifier;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button browse;
    File selectedfile;
    @FXML
    private TextField imageTelecharger;
    @FXML
    private TextField adresse;
    @FXML
    private TextField mail;
    @FXML
    private TextField cinval;
    @FXML
    private TextField tejrab;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView back;
    @FXML
    private Button modif2mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
           
        try {
            // TODO
            utilisateurservice us = new utilisateurservice();
            ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
            //cin.setText(utilisateurs.);
            // us.getAllutilisateur();
            String SEPARATEUR ="\"";
            String u="";
            for(utilisateur e:utilisateurs){
                 cinval.setPromptText(String.valueOf(e.getCin()));
               cin.setPromptText(String.valueOf(e.getCin()));
               nom.setText(e.getNom());
               prenom.setText(e.getPrenom());
               telephone.setText(String.valueOf(e.getTelephone())); 
                tejrab.setText(String.valueOf(e.getCin()));   
               adresse.setText(e.getAdresse());
               mail.setText(e.getAdressemail());
               u=e.getPhotoprofil();
                
            }
                 
          
         // Image a=new Image("image/"+u); //el star eli yemchi
          Image a=new Image("file:C:/wamp64/www/image/"+u);
         // System.out.println(a);
        //  System.out.println("http://localhost/Images/" + u);
	//	photoprofil.setImage(new Image("file://"+s));
             photoprofil.setImage(a);  
           // Image imageURI = new Image("file:C:/wamp64/www/image/" + u);
      // photoprofil.setImage(imageURI);
            modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
                try {
               //   int cinn=Integer.valueOf(cinval.getText());
                  //System.out.println(cinn);
                   utilisateurservice us = new utilisateurservice();
                 
      //  for (int i = 0; i < s.length; i++) {
       //     System.out.println(s);
            
     //   }
      
               //    System.out.println( String.valueOf(s));
                 
                 //  System.out.println(s);
                   us.modifierutilisateur(Integer.valueOf(tejrab.getText()), nom.getText(),prenom.getText(),"ffff", mail.getText(), Integer.valueOf(telephone.getText()),imageTelecharger.getText(),adresse.getText());
                       // us.modifierutilisateur(Integer.valueOf(cin.getText()),nom.getText(),prenom.getText(),motdepasse.getText(),mail.getText(),Integer.valueOf(telephone.getText()),imageTelecharger.getText());
                    try {
                        modifier.getScene().setRoot(FXMLLoader.load(getClass().getResource("admininterface.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        } catch (SQLException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
            browse.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    try {
                       FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png")
		);
		selectedfile = fc.showOpenDialog(null);
		if (selectedfile != null) {
                    System.out.println(selectedfile.getName());
                    FileInputStream inp = new FileInputStream(selectedfile.getPath());
                    System.out.println(selectedfile.getName());
                    ImageView a = new ImageView(new Image(inp));
                    a.setFitHeight(54);
                    a.setFitWidth(62);
                    String path_img = selectedfile.getAbsolutePath();
                    upload us = new upload();
                    if (selectedfile.isFile()) {
                        us.upload(selectedfile);
                    }
                    System.out.println(selectedfile.getCanonicalPath());
                    imageTelecharger.setText(selectedfile.getName());
                } else {
			System.out.println("FICHIER erroné");
		}
                    } catch (IOException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
       
        }

    @FXML
    private void logout(MouseEvent event) {
           try {
               utilisateurservice us = new utilisateurservice();
               us.deconnexionutilisateur("connecter");
               try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    @FXML
    private void back(MouseEvent event) {
        
         try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("menu.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void modifmdp2(MouseEvent event) {
        try {
                   modif2mdp.getScene().setRoot(FXMLLoader.load(getClass().getResource("modifiermdp.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    }    
	
    

