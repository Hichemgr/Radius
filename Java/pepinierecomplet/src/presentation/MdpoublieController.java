/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MdpoublieController implements Initializable {
    @FXML
    private TextField mail;
    @FXML
    private ImageView mailing;
    @FXML
    private ImageView retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgotpass(MouseEvent event) {
        try {
            utilisateurservice us=new utilisateurservice();  
            mailer.sendMail(String.valueOf(mail.getText()),"Récupération mot de passe","Bonjour,\nVotre nouveau mot de passe est: "+us.getmotdepasse(mail.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Récupération mot de passe");
		alert.setHeaderText("Mail envoyé avec succés!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(MdpoublieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back(MouseEvent event) {
         try {
                   retour.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(MdpoublieController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
}
