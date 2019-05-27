/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modals.assisstance;
import presentation.ProfilController;
import services.ServiceAssisstance;

/**
 * FXML Controller class
 *
 * @author seifeddinebenfraj
 */
public class AssisstanceFrontController implements Initializable {

    @FXML
    private DatePicker DateAss;
    @FXML
    private Button AjAss;
    @FXML
    private TextField AdresseAss;
    @FXML
    private TableView<assisstance> tableAssFront;
    @FXML
    private TableColumn<assisstance,Date> dateAssFront;
    @FXML
    private TableColumn<assisstance,String> TypeAssFront;
    @FXML
    private TableColumn<assisstance,String> nomAssAss;
    @FXML
    private ImageView baack;

    /**
     * Initializes the controller class.
     */
    
    public void EmailSender(){
        try{
            String host ="smtp.gmail.com" ;
            String user = "seifeddine.benfraj@esprit.tn";
            String pass = "Seifouun1";
            String to = "seifouun@gmail.com";
            String from = "seifeddine.benfraj@esprit.tn";
            String subject = "Assisstance confirmée";
            String messageText = "Votre demande d'assisstance a été prise en charge Monsieur/Madame "
                    + "Merci pour votre confiance.     "
                    + "RADIUS GARDEN.";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new java.util.Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void afficher(){
        try {
            assisstance a = new assisstance();
            ServiceAssisstance sa1 = new ServiceAssisstance();
            
            dateAssFront.setCellValueFactory(new PropertyValueFactory<>("dateAss"));
            TypeAssFront.setCellValueFactory(new PropertyValueFactory<>("type"));
            nomAssAss.setCellValueFactory(new PropertyValueFactory<>("id_assisstant"));
            
            String nom = "Griri Hichem";
            ObservableList<assisstance> data1 =
                    FXCollections.observableArrayList(sa1.LesLivraisonsParClient(nom));
            tableAssFront.setItems(data1);
        } catch (SQLException ex) {
            Logger.getLogger(AssisstanceGController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    

    @FXML
    private void ajouterAss(ActionEvent event) {
    }

    @FXML
    private void back(MouseEvent event) {
        try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("/presentation/menu.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
}
