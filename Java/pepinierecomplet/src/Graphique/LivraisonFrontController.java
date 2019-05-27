/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import com.teamdev.jxmaps.Duration;
import com.teamdev.jxmaps.LatLng;
import com.teknikindustries.bulksms.SMS;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modals.livraison;
import org.controlsfx.control.Notifications;
import presentation.ProfilController;
import services.ServiceLivraison;
import utils.MapClass;

/**
 * FXML Controller class
 *
 * @author seifeddinebenfraj
 */
public class LivraisonFrontController implements Initializable {

    @FXML
    private Label MontantAJ;
    private ComboBox<String> PanierAJ;
    @FXML
    private DatePicker DateAJ;
    @FXML
    private TextField AdresseAJ;
    @FXML
    private Label totalAJ;
    private TextField rechliv;
    @FXML
    private Button AJ;
    @FXML
    private Label fraisAJ;
    private ComboBox  users;
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
    
    MapClass myMap = new MapClass("");
    LatLng MyLocation = new LatLng();
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            myMap.ShutDownMap();
        try {
            ServiceLivraison li = new ServiceLivraison();
            livraison l = new livraison();
            
//            float mon = li.Montant();
//            String s=String.valueOf(mon);
//            String t=String.valueOf(mon+6);
            
            int a=li.rechercheridutili();
            //String add=String.valueOf(sl.Adresse());
           float m= li.getprixtotale(a);
            
            String Mm = String.valueOf(m);
            String Tt = String.valueOf(m+6);
            MontantAJ.setText(Mm);
            totalAJ.setText(Tt);
            DateAJ.setValue(LocalDate.now());
            //AdresseAJ.setText(add);
            ServiceLivraison sl = new ServiceLivraison();
            String var = sl.getAdresse("connecter");
            AdresseAJ.setText(var);
            System.out.println(var);
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void ajouterLivraison(ActionEvent event) throws SQLException {
        ServiceLivraison sl = new ServiceLivraison();
        livraison l = new livraison();
        String add=AdresseAJ.getText();
        Date dateaj=java.sql.Date.valueOf(DateAJ.getValue());
        String tot=totalAJ.getText();
        float Tot=Float.parseFloat(tot);
        
        l.setAdresse(add);
        l.setDate(dateaj);
        l.setMontant(Tot);
        
//        myMap.SetLocationInMap(MyLocation);
//        l.setLatitude(MyLocation.getLat());
//        l.setLongitude(MyLocation.getLng());
        
        String p = "";
       if(!add.equals(p))
       {
      int aj=sl.ajouterLivraison(l);
     
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Livraison");
          alert.setHeaderText("Information");
          alert.setContentText("La livraison a été ajoutée");
          alert.showAndWait();
          
          AdresseAJ.clear();
          DateAJ.setValue(LocalDate.now());
          
          Notifications notificationBuilder = Notifications.create()
                .title("Assisstance")
                .text("Une nouvelle livraison a été ajoutée.")
                .graphic(null)
                .hideAfter(javafx.util.Duration.seconds(5))
                .position(Pos.TOP_RIGHT);
                
             notificationBuilder.showConfirm();
             
          EmailSender();
   }else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Livraison");
          alert.setHeaderText("Information");
          alert.setContentText("Erreur : Veuillez vérifier les champs");
          alert.showAndWait();
       }
      
      
        
    }

    
    
//    private void getAdress(ActionEvent event) {
//        MapClass myMap1 = new MapClass("");
//        myMap1 = MapClass.LaunchMap("Map");
//    }
    
    

    private void Localiser(ActionEvent event) {
        MapClass myMap = new MapClass("");
        MyLocation = myMap.GetLocationFromMap();
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
