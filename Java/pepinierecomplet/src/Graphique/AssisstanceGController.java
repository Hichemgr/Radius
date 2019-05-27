/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modals.assisstance;
import modals.livraison;
import org.controlsfx.control.Notifications;
import presentation.ProfilController;
import services.ServiceAssisstance;
import services.ServiceLivraison;

/**
 * FXML Controller class
 *
 * @author seifeddinebenfraj
 */
public class AssisstanceGController implements Initializable {

    @FXML
    private TableView<assisstance> assisstanceTable;
    @FXML
    private TableColumn<assisstance, Integer> idclient;
    @FXML
    private TableColumn<assisstance, Integer> idassisstant;
    @FXML
    private TableColumn<assisstance, String> type;
    private TextField clientField;
    private TextField assissField;
    private TextField typeField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableColumn<?, ?> dateAss;
    @FXML
    private TextField rech;
    @FXML
    private ComboBox assisstantCMBX;
    @FXML
    private ComboBox clientCMBX;
    @FXML
    private ComboBox typeCMBX;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TextField prenomClient;
    @FXML
    private ImageView baack;

    /**
     * Initializes the controller class.
     */
    
    public void afficher(){
        try {
            assisstance a = new assisstance();
            ServiceAssisstance sa1 = new ServiceAssisstance();
            
            id.setCellValueFactory(new PropertyValueFactory<>("id_assisstance"));
            idclient.setCellValueFactory(new PropertyValueFactory<>("id_client"));
            idassisstant.setCellValueFactory(new PropertyValueFactory<>("id_assisstant"));
            dateAss.setCellValueFactory(new PropertyValueFactory<>("dateAss"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            
            ObservableList<assisstance> data1 =
                    FXCollections.observableArrayList(sa1.listerLesAssisstances());
            assisstanceTable.setItems(data1);
        } catch (SQLException ex) {
            Logger.getLogger(AssisstanceGController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
    
    
    public void EmailSender(){
        try{
            String host ="smtp.gmail.com" ;
            String user = "seifeddine.benfraj@esprit.tn";
            String pass = "Seifouun1";
            String to = "seifouun@gmail.com";
            String from = "seifeddine.benfraj@esprit.tn";
            String subject = "Assisstance confirmée";
            String messageText = "Votre demande d'assisstance a été prise en charge Mr/Mme "
                    +prenomClient.getText() +" " +"Merci pour votre confiance."
                    + "  RADIUS GARDEN.";
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceAssisstance sa = new ServiceAssisstance();
            clientCMBX.setItems(sa.getNomClient());
            assisstantCMBX.setItems(sa.getNomAssisstant());
            ObservableList<String> listnom = FXCollections.observableArrayList("Visite","Jardinage","Autre");
            typeCMBX.setItems(listnom);
            //typeCMBX.setItems("Visite","Jardinage");
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(AssisstanceGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }           

    @FXML
    private void ajouterAssisstance(ActionEvent event) throws SQLException {
        ServiceAssisstance sl = new ServiceAssisstance();
        assisstance l = new assisstance();
        //String idc=clientField.getText();
        //int idC = Integer.parseInt(idc);
        String ida= String.valueOf(assisstantCMBX.getValue());
        String idc = prenomClient.getText();
        java.util.Date dateaj=java.sql.Date.valueOf(datePicker.getValue());
        String type= String.valueOf(typeCMBX.getValue());
        
        
        l.setId_client(idc);
        l.setId_assisstant(ida);
        l.setDateAss((Date) dateaj);
        l.setType(type);
        
        if((clientCMBX.getValue() != null) && (assisstantCMBX.getValue() != null) && (typeCMBX.getValue() != null))
        {
            int aj=sl.ajouterAssisstance(l);
      if(aj>0){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Assisstance");
          alert.setHeaderText("Information");
          alert.setContentText("L'assisstance a été ajoutée");
          alert.showAndWait();
          
          EmailSender();
          
          clientCMBX.getItems().removeAll(clientCMBX.getItems());
          assisstantCMBX.getItems().removeAll(assisstantCMBX.getItems());
          typeCMBX.getItems().removeAll(typeCMBX.getItems());
        
          clientCMBX.setItems(sl.getNomClient());
        assisstantCMBX.setItems(sl.getNomAssisstant());
        ObservableList<String> listnom = FXCollections.observableArrayList("Visite","Jardinage","Autre");
            typeCMBX.setItems(listnom);
            datePicker.setValue(LocalDate.now());
            prenomClient.clear();
            
            Notifications notificationBuilder = Notifications.create()
                .title("Assisstance")
                .text("Une nouvelle assisstance a été ajoutée.")
                .graphic(null)
                .hideAfter(javafx.util.Duration.seconds(5))
                .position(Pos.TOP_RIGHT);
                
             notificationBuilder.showConfirm();
            
      }else{
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Assisstance");
          alert.setHeaderText("Information");
          alert.setContentText("Erreur : Veuillez vérifier la date");
          alert.showAndWait();
      }
      
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Assisstance");
          alert.setHeaderText("Information");
          alert.setContentText("Erreur : Veuillez vérifier les champs");
          alert.showAndWait();
        }
      afficher();
      
    }

    @FXML
    private void remplirChamps(MouseEvent event) {
           assisstance assist = assisstanceTable.getSelectionModel().getSelectedItem();
           String idcl = assist.getId_client();
           String idCl = String.valueOf(idcl);
           String idass = assist.getId_assisstant();
           String idAss = String.valueOf(idass);
           Date datt = assist.getDateAss();
           
           String strDate = datt.toString();
           String typp = assist.getType();
           
           clientCMBX.setValue(idCl);
           assisstantCMBX.setValue(idAss);
           typeCMBX.setValue(typp);
           datePicker.setValue(datt.toLocalDate());
               }

    @FXML
    private void supprimerAssisstance(ActionEvent event) throws SQLException {
        ServiceAssisstance sl = new ServiceAssisstance();
        assisstance l = new assisstance();
        assisstance assist = assisstanceTable.getSelectionModel().getSelectedItem();
        
        int idA = assist.getId_assisstance();
        
        sl.SupprimerAssisstance(idA);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Assisstance");
        alert.setHeaderText("Information");
        alert.setContentText("L'assisstance a été supprimée");
        alert.showAndWait();
        clientCMBX.getItems().removeAll(clientCMBX.getItems());
        assisstantCMBX.getItems().removeAll(assisstantCMBX.getItems());
        typeCMBX.getItems().removeAll(typeCMBX.getItems());
        
        clientCMBX.setItems(sl.getNomClient());
        assisstantCMBX.setItems(sl.getNomAssisstant());
        ObservableList<String> listnom = FXCollections.observableArrayList("Visite","Jardinage","Autre");
            typeCMBX.setItems(listnom);
            datePicker.setValue(LocalDate.now());
            
            prenomClient.clear();
        afficher();
    }

    @FXML
    private void modifierAssisstance(ActionEvent event) throws SQLException {
        ServiceAssisstance sl = new ServiceAssisstance();
        assisstance l = new assisstance();
        
        assisstance assist = assisstanceTable.getSelectionModel().getSelectedItem();
        l.setId_assisstance(assist.getId_assisstance());
        l.setId_client(prenomClient.getText());
        l.setId_assisstant(String.valueOf(assisstantCMBX.getValue()));
        java.util.Date dateaj=java.sql.Date.valueOf(datePicker.getValue());
        l.setDateAss((Date) dateaj);
        l.setType(String.valueOf(typeCMBX.getValue()));
        
        
        
        int aj=sl.modifierAssisstance(l);
      if(aj>0){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Livraison");
          alert.setHeaderText("Information");
          alert.setContentText("La livraison a été bien modifée");
          alert.showAndWait();
          
          clientCMBX.getItems().removeAll(clientCMBX.getItems());
        assisstantCMBX.getItems().removeAll(assisstantCMBX.getItems());
        typeCMBX.getItems().removeAll(typeCMBX.getItems());
        
        clientCMBX.setItems(sl.getNomClient());
        assisstantCMBX.setItems(sl.getNomAssisstant());
        ObservableList<String> listnom = FXCollections.observableArrayList("Visite","Jardinage","Autre");
            typeCMBX.setItems(listnom);
        datePicker.setValue(LocalDate.now());
        prenomClient.clear();
      }else{
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Livraison");
          alert.setHeaderText("Information");
          alert.setContentText("Erreur : Veuillez vérifier les champs");
          alert.showAndWait();
      }
        
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Assisstance");
//        alert.setHeaderText("Information");
//        alert.setContentText("L'assisstance a été modifiée");
//        alert.showAndWait();

        
        afficher();
    }

    @FXML
    private void Rechercher(KeyEvent event) {
        try {
                ServiceAssisstance ps= new ServiceAssisstance();
                ArrayList<assisstance> personnes = new ArrayList<>();
                //String prod_rech= recherche.getText();
                try {
                    personnes=(ArrayList<assisstance>) ps.FindAssisstance(rech.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(AssisstanceGController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObservableList<assisstance> obsl = FXCollections.observableArrayList(personnes);
                assisstanceTable.setItems(obsl);
                id.setCellValueFactory(new PropertyValueFactory<>("id_assisstance"));
                idclient.setCellValueFactory(new PropertyValueFactory<>("id_client"));
                idassisstant.setCellValueFactory(new PropertyValueFactory<>("id_assisstant"));
                dateAss.setCellValueFactory(new PropertyValueFactory<>("dateAss"));
                type.setCellValueFactory(new PropertyValueFactory<>("type"));
                
            } catch (SQLException ex) {
                Logger.getLogger(AssisstanceGController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    

    @FXML
    private void afficherPrenom(ActionEvent event) throws SQLException {
        ServiceAssisstance sa = new ServiceAssisstance();
        String prenom = sa.getIdClient(Integer.valueOf(String.valueOf(clientCMBX.getValue())));
        prenomClient.setText(prenom);
    }

    @FXML
    private void back(MouseEvent event) {
        try {
                   baack.getScene().setRoot(FXMLLoader.load(getClass().getResource("/presentation/utilisateurback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    

    
    
  
    
    
    

    
}
