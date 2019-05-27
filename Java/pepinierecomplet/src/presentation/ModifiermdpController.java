/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.utilisateurservice;
import utile.cryptpasswords;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifiermdpController implements Initializable {
    @FXML
    private TextField mdp;
    @FXML
    private TextField mdpn;
    @FXML
    private TextField mdpn1;
    @FXML
    private ImageView baack;
    @FXML
    private ImageView loogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO
            
    }    

    @FXML
    private void back(MouseEvent event) {
        try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("profil.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ModifiermdpController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void logout(MouseEvent event) {
        try {
               utilisateurservice us = new utilisateurservice();
               us.deconnexionutilisateur("connecter");
               try {
                   loogout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ModifiermdpController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (SQLException ex) {
                        Logger.getLogger(ModifiermdpController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    @FXML
    private void modmdp(MouseEvent event) throws NoSuchAlgorithmException {
        if(!mdpn.getText().equals(mdpn1.getText()))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
		alert.setHeaderText("Erreur mot de passe");
		alert.setContentText("le mot de passe et la verification doivent etre authentique!");
		alert.showAndWait();
        }
        else
        {
            try {
                String s="";
                String c="";
                utilisateurservice us = new utilisateurservice();
                ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
                for(utilisateur e:utilisateurs){
                    s=String.valueOf(e.getMotdepasse());
                        }
                s=us.getmdpuser("fff");
                cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
       c= encryption.cryptme(String.valueOf(mdp.getText()));
                System.out.println("hethi el c "+c);
                System.out.println("hethi el s "+s);
       if(c.equals(s))
       {
           us.setnewpass(c, encryption.cryptme(mdpn.getText()));
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier mot de passe");
		alert.setHeaderText("Le mot de passe a été changer");
	//	alert.setContentText("Mot de passe incorrect!");
		alert.showAndWait();
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
		alert.setHeaderText("Erreur mot de passe");
		alert.setContentText("Mot de passe incorrect!");
		alert.showAndWait();
       }
            } catch (SQLException ex) {
                Logger.getLogger(ModifiermdpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    
}
