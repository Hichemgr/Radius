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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.utilisateurservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CodevalidationController implements Initializable {
    @FXML
    private TextField valid;
    @FXML
    private ImageView confirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmcode(MouseEvent event) {
        try {
            utilisateurservice us=new utilisateurservice();
            if(us.recherchercode(valid.getText()))
            {
                String s=us.getmailcode(valid.getText());
                us.logincode(valid.getText());
                us.setvalidationcode(s,"ok");
                
                try {
                    confirm.getScene().setRoot(FXMLLoader.load(getClass().getResource("admininterface.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(CodevalidationController.class.getName()).log(Level.SEVERE, null, ex); 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CodevalidationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
