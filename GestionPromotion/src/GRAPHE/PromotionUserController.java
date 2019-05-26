/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPHE;

//import com.teknikindustries.bulksms.SMS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import service.PromotionService;

import entite.MyBD;
import entite.Promotion;
import entite.Produit ; 
import entite.publicite;
import entite.utlisteur;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import service.publiciteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PromotionUserController implements Initializable {

   @FXML
    private TableView<Promotion> tableauPromo;
     @FXML
    private TableColumn<Promotion,String> columnompromo;
    @FXML
    private TableColumn<Promotion,LocalDate> columdatedebut;
    @FXML
    private TableColumn<Promotion,LocalDate> columdatefin;
    @FXML
    private TableColumn<Promotion,Float> columnpourcentage;
    @FXML
    private TableColumn<Promotion,String> columnnomproduit1 ;
    @FXML
    private TableColumn<Promotion, Float> nouveauprixcol;
   
 @FXML
    private TextField suppPromo;
    @FXML
    private Button supPromo;
     @FXML
    private TextField txtnom ;
    @FXML
    private TextField txtpourcentage;
    Connection cnx;
    @FXML
    private DatePicker datedebutField;
    @FXML
    private DatePicker datefinField;
    PromotionService vf;
    @FXML
    private Button ajouterPromotion;
    @FXML
    private Button modifPromo;
      @FXML
    private TextField modifnom;
      @FXML
    private DatePicker modifdatedebut;
      @FXML
    private DatePicker modifdatefin;
      @FXML
    private TextField modifpourcentage;
            @FXML
           
    private TableView<publicite> tableauPub;
     @FXML
    private TableColumn<publicite,String> columnompub;
    @FXML
    private TableColumn<publicite,LocalDate> columdatepub;
    @FXML
    private TableColumn<publicite,String> nomproduit; 
     @FXML
    private Button ajouterPub;
     @FXML
    private TextField txtnompub;
      @FXML
    private DatePicker datefPubField1;
      @FXML
      ComboBox comboPub ; 
      @FXML
    private TextField suppPub;
    @FXML
    private Button supprPub;
    @FXML
    private TextField modifnom1;
    @FXML
    private DatePicker modifdatefin1;
    @FXML
    private Button ActualiserPromo;
    @FXML
    private TextField rechfield;
    @FXML
    private ComboBox combobox ; 
      @FXML
           
    private TableView<utlisteur> tabuser;
      @FXML
    private TableColumn<utlisteur,String> columnmail;
        @FXML
    private TableColumn<utlisteur,Integer> columntel;
    @FXML
    private TextField txtmail;
       @FXML
    private TextField txttelephone;
       @FXML
    private Button envoyer;
    @FXML
    private Button ActualiserPub;
   @FXML
    private ComboBox comboModifProm ; 
    @FXML
    private Button modifPub;
    @FXML
    private ComboBox comboModifPub;
     @FXML
    private TextField pubrech;
      @FXML
    private TableView<Promotion> tabmodifProm ;
      @FXML
    private TableColumn<Promotion,String> nommodif;
    @FXML
    private TableColumn<Promotion,LocalDate> datedebutmodif;
    @FXML
    private TableColumn<Promotion,LocalDate> datefinmodif;
    @FXML
    private TableColumn<Promotion,Float> pourcentagemodif;
    @FXML
    private TableColumn<Promotion,String> nomproduitmodif ;
    @FXML
    private Button envoyerPub;
    @FXML
    private TextField mailPub;
    @FXML
    private TextField telpub;
    @FXML
     private TableView<utlisteur> tabUserPub;
      @FXML
    private TableColumn<utlisteur,String> PubUseradr;
        @FXML
    private TableColumn<utlisteur,Integer> TelUser;
    
    
   @FXML
    private TableView<publicite> tabModifPub  ;
      @FXML
    private TableColumn<publicite,String> modifNomPub;
        @FXML
    private TableColumn<publicite,LocalDate> modifDatePub;
         @FXML
    private TableColumn<publicite,String> modifNomPrPub  ;
          
      
      
 
   
  /*  private ComboBox<Integer> idproduit;*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        publiciteService aff;
        PromotionService af; 
        
        
        
              try {
            af = new PromotionService() ; 
        
           //   columidpromo.setCellValueFactory(new PropertyValueFactory<>("idpromotion"));
              columnompromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
              columdatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              columdatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              columnpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
             columnnomproduit1.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
           nouveauprixcol.setCellValueFactory(new PropertyValueFactory<>("nouveauprix"));
              
          ObservableList<Promotion> observableArrayList = 
                  FXCollections.observableArrayList(af.getAllPromotion());
            tableauPromo.setItems(observableArrayList);
             combobox.setItems(af.getNomproduit());
             comboModifProm.setItems(af.getNomproduit());
            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
              try {
            af = new PromotionService() ; 
        
           //   columidpromo.setCellValueFactory(new PropertyValueFactory<>("idpromotion"));
              nommodif.setCellValueFactory(new PropertyValueFactory<>("nom"));
              datedebutmodif.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              datefinmodif.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              pourcentagemodif.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
              nomproduitmodif.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
              
          ObservableList<Promotion> observableArrayList = 
                  FXCollections.observableArrayList(af.getAllPromotion());
            tabmodifProm.setItems(observableArrayList);
             
            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            aff = new publiciteService();
        
              columnompub.setCellValueFactory(new PropertyValueFactory<>("nompublicite")); 
              columdatepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));

              
              
          ObservableList<publicite> observableArrayList = 
                  FXCollections.observableArrayList(aff.getAllPublicites());
            tableauPub.setItems(observableArrayList);
            comboPub.setItems(aff.getNomproduit());
            comboModifPub.setItems(aff.getNomproduit());
                         

            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
              
        }
         
         
       try {
            aff = new publiciteService();
        
              modifNomPub.setCellValueFactory(new PropertyValueFactory<>("nompublicite")); 
              modifDatePub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              modifNomPrPub.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));

              
              
          ObservableList<publicite> observableArrayList = 
                  FXCollections.observableArrayList(aff.getAllPublicites());
            tabModifPub.setItems(observableArrayList);
            comboPub.setItems(aff.getNomproduit());
            comboModifPub.setItems(aff.getNomproduit());
                         

            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
              
        }
         
          try {
            af = new PromotionService() ; 
        
              columnmail.setCellValueFactory(new PropertyValueFactory<>("adressemail"));
              columntel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
              
              
          ObservableList<utlisteur> observableArrayList = 
                  FXCollections.observableArrayList(af.getAllUser());
            tabuser.setItems(observableArrayList);
           
            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
               try {
            aff = new publiciteService(); 
        
              PubUseradr.setCellValueFactory(new PropertyValueFactory<>("adressemail"));
              TelUser.setCellValueFactory(new PropertyValueFactory<>("telephone"));
              
              
          ObservableList<utlisteur> observableArrayList = 
                  FXCollections.observableArrayList(aff.getAllUser2());
            tabUserPub.setItems(observableArrayList);
           
            } catch (SQLException ex) {
            Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }
   
 
   


    @FXML
    private void supPromo(ActionEvent event) throws SQLException {
  String nomS =suppPromo.getText();
  //int idpromotion =Integer.parseInt(idS);
  String nom =String.valueOf(nomS) ; 
 PromotionService aff= new PromotionService();
  
     int aj= aff.supprimer(nom);
        if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la promotion  a été supprimée !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
               columnompromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
              columdatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              columdatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              columnpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
             columnnomproduit1.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
                        nouveauprixcol.setCellValueFactory(new PropertyValueFactory<>("nouveauprix"));

          ObservableList<Promotion> observableArrayList = 
                  FXCollections.observableArrayList(aff.getAllPromotion());
            tableauPromo.setItems(observableArrayList);
            
    }
   
    @FXML
    private void ajouterPromotion(ActionEvent event) throws SQLException {
    
      PromotionService ps=new PromotionService() ; 
       Promotion p=new Promotion();
       Produit pp=new Produit() ; 
       
String   nom=txtnom.getText() ; 
        Date datedebut = java.sql.Date.valueOf(datedebutField.getValue());
        Date datefin = java.sql.Date.valueOf(datefinField.getValue());
int pourcentage = Integer.parseInt(txtpourcentage.getText());
String nomproduit=(String) combobox.getSelectionModel().getSelectedItem() ; 
//float f=((Float.parseFloat(ps.getPrixProduit())-Float.parseFloat(ps.getPrixProduit())Integer*parseInt(txtpourcentage.getText()))/100);
       
          p.setNom(nom);
        p.setDatedebut((java.sql.Date) datedebut);
        p.setDatefin((java.sql.Date) datefin);
       p.setPourcentage(pourcentage);
       pp.setNomproduit(nomproduit);
       
       
      
                
    int aj=   ps.ajouterAlaBase(p, pp);
    PromotionService pa =new PromotionService() ; 
          float pri= pa.getPrixProduit(String.valueOf(combobox.getValue()),Integer.valueOf(txtpourcentage.getText())) ;
           pa.setNouveauprix(pri,txtnom.getText());
        System.out.println("Promotion Ajouter");
         if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la Promotion  a été ajoutée !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("Date debut doit etre inferieru a date fin!!");
            alert.showAndWait();
        }
    
    }

    @FXML
    private void modifPromo(ActionEvent event) throws SQLException {
        PromotionService pss=new PromotionService(); 
       Promotion po =new Promotion();
       Produit pp=new Produit() ;
       


String nom= modifnom.getText();
Date datedebut= java.sql.Date.valueOf(modifdatedebut.getValue());
Date datefin= java.sql.Date.valueOf(modifdatefin.getValue());
int pourcentage = Integer.valueOf(modifpourcentage.getText());
String nomproduit=(String) comboModifProm.getSelectionModel().getSelectedItem() ; 


        

         int i=0;
          po.setNom(nom);
          po.setDatedebut((java.sql.Date) datedebut);
           po.setDatefin((java.sql.Date) datefin);
           po.setPourcentage(pourcentage);
             pp.setNomproduit(nomproduit);
           
          
         int aj= pss.modifier( nom, datedebut, datefin, pourcentage, nomproduit);
          i++;
          if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la promotion a été modifiée !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
          nommodif.setCellValueFactory(new PropertyValueFactory<>("nom"));
              datedebutmodif.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              datefinmodif.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              pourcentagemodif.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
             nomproduitmodif.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
          ObservableList<Promotion> observableArrayList = 
                  FXCollections.observableArrayList(pss.getAllPromotion());
            tabmodifProm.setItems(observableArrayList);
         
      
       
    }



    @FXML
    private void ActualiserPromo(ActionEvent event) throws SQLException {
        PromotionService af=new PromotionService();
          //   columidpromo.setCellValueFactory(new PropertyValueFactory<>("idpromotion"));
              columnompromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
              columdatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              columdatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              columnpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
              columnnomproduit1.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
                         nouveauprixcol.setCellValueFactory(new PropertyValueFactory<>("nouveauprix"));

              
          ObservableList<Promotion> observableArrayList = 
                  FXCollections.observableArrayList(af.getAllPromotion());
            tableauPromo.setItems(observableArrayList);
        
    }
   
     
     
      
      
    
  
 

    @FXML
    private void reche(KeyEvent event) {
       try {
           PromotionService pss=new PromotionService();
           Promotion p =new Promotion();
           String prom_rech= rechfield.getText();
           
           
           
           ObservableList<Promotion> observableArrayList;
           observableArrayList = FXCollections.observableArrayList(pss.FindPromotion(prom_rech)) ;
           tableauPromo.setItems(observableArrayList);
               columnompromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
              columdatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
              columdatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
              columnpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
             columnnomproduit1.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
                        nouveauprixcol.setCellValueFactory(new PropertyValueFactory<>("nouveauprix"));

       } catch (SQLException ex) {
           Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
   @FXML
    private void remplirChamps(MouseEvent event) {
           Promotion promo = tabmodifProm.getSelectionModel().getSelectedItem();
          
           modifnom.setText(promo.getNom()); 
           modifdatedebut.setValue(promo.getDatedebut().toLocalDate());
           modifdatefin.setValue(promo.getDatefin().toLocalDate());
           modifpourcentage.setText(Integer.toString(promo.getPourcentage()));
           comboModifProm.setValue(promo.getNomproduit());
           
               }

      @FXML
    private void envoyer(ActionEvent event) throws SQLException {
         try {
            String host = "smtp.gmail.com";
            String user = "anas.abdelkafi@esprit.tn";
            String pass = "abdel1997";
            String to = txtmail.getText();
            String from = "alihachem.tahar@esprit.tn";
            String subject = "nouvelles promotions ";
            String messageText = "Des nouvelles promotions sont disponibles vister notre boutique";
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
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
//      SMS smstut= new SMS();
//     String too = txttelephone.getText() ; 
      
    //  smstut.SendSMS("anasabdelkefi","abdel1997" , "Des promotions sont disponibles vistez notre boutique" ,too, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
 
        
           
      
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void supprPub(ActionEvent event) throws SQLException {
         String nomP =suppPub.getText();
  //int idpromotion =Integer.parseInt(idS);
  String nom =String.valueOf(nomP) ; 
 publiciteService af= new publiciteService(); 
  
    int aj=  af.supprimer(nomP);
     if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la publicité  a été supprimée !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
               columnompub.setCellValueFactory(new PropertyValueFactory<>("nompublicite"));
              columdatepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
          ObservableList<publicite> observableArrayList = 
                  FXCollections.observableArrayList(af.getAllPublicites());
            tableauPub.setItems(observableArrayList);
    }

    @FXML
    private void ajouterPub(ActionEvent event) throws SQLException {
         publiciteService pr=new publiciteService(); 
       publicite p=new publicite();
       Produit pp=new Produit() ; 
       
String   nompublicite=txtnompub.getText() ; 
        Date datepub = java.sql.Date.valueOf(datefPubField1.getValue());
String nomprod=(String) comboPub.getSelectionModel().getSelectedItem() ; 
//float f=((Float.parseFloat(ps.getPrixProduit())-Float.parseFloat(ps.getPrixProduit())Integer*parseInt(txtpourcentage.getText()))/100);
       
          p.setNompublicite(nompublicite);
        p.setDatepub((java.sql.Date) datepub);
       pp.setNomproduit(nomprod);
                
   int aj=     pr.ajouterAlaBase(p, pp);
        if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la publicité  a été ajouté !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("verfier la date !!");
            alert.showAndWait();
        }
        
    
    }

    @FXML
    private void combobox (ActionEvent event)   {
        }

  

    @FXML
    private void comboPub(ActionEvent event) {
    }

    @FXML
    private void ActualiserPub(ActionEvent event) throws SQLException {
         publiciteService aff=new publiciteService();
              columnompub.setCellValueFactory(new PropertyValueFactory<>("nompublicite"));
              columdatepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));

              
          ObservableList<publicite> observableArrayList = 
                  FXCollections.observableArrayList(aff.getAllPublicites());
            tableauPub.setItems(observableArrayList);
    }

    @FXML
    private void comboModifProm(ActionEvent event) {
    }

    @FXML
    private void modifPub(ActionEvent event) throws SQLException {
         publiciteService pss=new publiciteService(); 
       publicite po =new publicite();
       Produit pp=new Produit() ;
       


String nompublicite= modifnom1.getText();
Date datepub= java.sql.Date.valueOf(modifdatefin1.getValue());
String nomproduit=(String) comboModifPub.getSelectionModel().getSelectedItem() ; 


        

         int i=0;
          po.getNompublicite() ; 
          po.setDatepub((java.sql.Date) datepub);
             pp.setNomproduit(nomproduit);
           
          
        int aj=  pss.modifier(nompublicite, (java.sql.Date) datepub, nomproduit);
          i++;
           if(aj>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Publicité");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("la publicité  a été modifié !!");
            alert.showAndWait();
            //getAll(event);
        }
        else{
            
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Question");
            alert.setHeaderText("INFORMATIONS");
            alert.setContentText("ERREUR !!");
            alert.showAndWait();
        }
           modifNomPub.setCellValueFactory(new PropertyValueFactory<>("nompublicite")); 
              modifDatePub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              modifNomPrPub.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));

              
              
          ObservableList<publicite> observableArrayList = 
                  FXCollections.observableArrayList(pss.getAllPublicites());
            tabModifPub.setItems(observableArrayList);
            
        
    }

    @FXML
    private void comboModifPub(ActionEvent event) {
    }

    @FXML
    private void recherche(KeyEvent event) {
        try {
           publiciteService pss=new publiciteService();
          publicite p =new publicite();
           String pub_rech= pubrech.getText();
           
           
           
           ObservableList<publicite> observableArrayList;
           observableArrayList = FXCollections.observableArrayList(pss.FindPub(pub_rech)) ;
           tableauPub.setItems(observableArrayList);
           columnompub.setCellValueFactory(new PropertyValueFactory<>("nompublicite"));
              columdatepub.setCellValueFactory(new PropertyValueFactory<>("datepub"));
              nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
             
       } catch (SQLException ex) {
           Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }

    @FXML
    private void envoyerPub(ActionEvent event) {
              try {
            String host = "smtp.gmail.com";
            String user = "anas.abdelkafi@esprit.tn";
            String pass = "abdel1997";
            String to = mailPub.getText();
            String from = "anas.abdelkafi@esprit.tn";
            String subject = "Des nouveaux produits  ";
            String messageText = "Des nouveaux produits sont disponibles, vister notre boutique";
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
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        
//      SMS smstut= new SMS();
//   String aa = telpub.getText() ; 
//      
//    // smstut.SendSMS("anasabdelkefi","abdel1997", "Des promotions sont disponibles vistez notre boutique" ,"+21621646533", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
// smstut.SendSMS("anas4547","21646533","Des promotions sont disponibles vistez notre boutique" ,aa, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
//       
//           
      
   
    }


    

    @FXML
    private void RemplirUser(MouseEvent event) {
        utlisteur uti = tabuser.getSelectionModel().getSelectedItem();
          
           txtmail.setText(uti.getAdressemail()); 
          
           txttelephone.setText(Integer.toString(uti.getTelephone()));
    }

    @FXML
    private void remplirchampPub(MouseEvent event) {
          publicite publ = tabModifPub.getSelectionModel().getSelectedItem();
          
           modifnom1.setText(publ.getNompublicite()); 
         modifdatefin1.setValue(publ.getDatepub().toLocalDate());
           comboModifPub.setValue(publ.getNomproduit());
    }

   
    }
       
          
      


