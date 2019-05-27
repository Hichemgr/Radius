/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import com.teknikindustries.bulksms.SMS;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import modals.livraison;
import presentation.ProfilController;
import services.ServiceLivraison;

/**
 * FXML Controller class
 *
 * @author seifeddinebenfraj
 */
public class LivraisonbackController implements Initializable {

     @FXML
    private TableColumn<livraison, Integer> Livraison;
    @FXML
    private TableColumn<livraison, Float> Montant;
    @FXML
    private TableColumn<livraison, String> Etat;
    @FXML
    private TableColumn<livraison, Date> Date;
    @FXML
    private TableColumn<livraison, String> Addresse;
    @FXML
    private TableColumn<livraison, String> Livreur;
    @FXML
    private TableView<livraison> TableLivraison;
    
    private TextField rechliv;
    @FXML
    private TextField findLiv;
    @FXML
    private TextField IDLivFld;
    @FXML
    private TextField MontantFld;
    @FXML
    private TextField AdresseFld;
    @FXML
    private TextField EtatFld;
    @FXML
    private TextField LivreurFld;
    @FXML
    private DatePicker DateFld;
    private ComboBox  users;
    @FXML
    private ComboBox livraisonCMBX;
    @FXML
    private ComboBox livreurCMBX;
    @FXML
    private ImageView baack;

    /**
     * Initializes the controller class.
     */
    
    public void afficher() throws SQLException{
        livraison l = new livraison();
            ServiceLivraison sl1 = new ServiceLivraison();
        
              Livraison.setCellValueFactory(new PropertyValueFactory<>("ID_Livraison"));
              Montant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
              Etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
              Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
              Addresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
              Livreur.setCellValueFactory(new PropertyValueFactory<>("nomLivreur"));

              ObservableList<livraison> data = 
                  FXCollections.observableArrayList(sl1.listerLesLivraisons());
              TableLivraison.setItems(data);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceLivraison li = new ServiceLivraison();
            livraison l = new livraison();
            afficher();
            
            livraisonCMBX.setItems(li.getIdLivraison());
            livreurCMBX.setItems(li.getNomLivreur());
            
            //ServiceLivraison sl = new ServiceLivraison();
            float mon = li.Montant();
            String s=String.valueOf(mon);
            String t=String.valueOf(mon+6);
            //String k;
//            users.set
//            utilisateur k = (utilisateur) users.getSelectionModel().getSelectedItem();
//            String add = k.getNom();
            //System.out.println("id = "+us);
            int a=li.rechercheridutili();
            //String add=String.valueOf(sl.Adresse());
           float m= li.getprixtotale(a);
            //System.out.println(m);
    //        String Mm = String.valueOf(m);
  //          String Tt = String.valueOf(m+6);
//            MontantAJ.setText(Mm);
      //      totalAJ.setText(Tt);
            
            //AdresseAJ.setText(add);
            //ServiceLivraison sl = new ServiceLivraison();
            //String var = sl.getAdresse("connecter");
            //AdresseAJ.setText(var);
            //System.out.println(var);
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

//    private void ajouterLivraison(ActionEvent event) throws SQLException {
//        ServiceLivraison sl = new ServiceLivraison();
//        livraison l = new livraison();
//        String add=AdresseAJ.getText();
//        Date dateaj=java.sql.Date.valueOf(DateAJ.getValue());
//        String tot=totalAJ.getText();
//        float Tot=Float.parseFloat(tot);
//        
//        l.setAdresse(add);
//        l.setDate(dateaj);
//        l.setMontant(Tot);
//        
//        
//      int aj=sl.ajouterLivraison(l);
//      if(aj>0){
//          Alert alert = new Alert(Alert.AlertType.INFORMATION);
//          alert.setTitle("Livraison");
//          alert.setHeaderText("Information");
//          alert.setContentText("La livraison a été ajoutée");
//          alert.showAndWait();
//      }else{
//          Alert alert = new Alert(Alert.AlertType.ERROR);
//          alert.setTitle("Livraison");
//          alert.setHeaderText("Information");
//          alert.setContentText("Erreur : Veuillez vérifier les champs");
//          alert.showAndWait();
//      }
//      afficher();   
//    }
    @FXML
    private void remplirChamps(MouseEvent event) {
           livraison assist = TableLivraison.getSelectionModel().getSelectedItem();
           int idl = assist.getID_Livraison();
           String idL = String.valueOf(idl);
           float mon = assist.getMontant();
           String Mon = String.valueOf(mon);
           java.sql.Date datt = (java.sql.Date) assist.getDate();
           int etat = assist.getEtat();
           String Etat = String.valueOf(etat);
           
           String add = assist.getAdresse();
           String livr = assist.getNomLivreur();
           
           IDLivFld.setText(idL);
           MontantFld.setText(Mon);
           EtatFld.setText(Etat);
           AdresseFld.setText(add);
           DateFld.setValue(datt.toLocalDate());
           LivreurFld.setText(livr);
               }

    @FXML
    private void supprimerLiv(ActionEvent event) throws SQLException {
        ServiceLivraison sl = new ServiceLivraison();
        livraison l = new livraison();
        String idl=IDLivFld.getText();
        int Idl = Integer.parseInt(idl);
        sl.SupprimerLivraison(Idl);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Assisstance");
        alert.setHeaderText("Information");
        alert.setContentText("L'assisstance a été supprimée");
        alert.showAndWait();
        
        IDLivFld.clear();
          MontantFld.clear();
          DateFld.setValue(LocalDate.now());
          EtatFld.clear();
          AdresseFld.clear();
          LivreurFld.clear();
        
        afficher();
    }


    @FXML
    private void RechercherLivraison(KeyEvent event) {
        try {
                ServiceLivraison ps= new ServiceLivraison();
                ArrayList<livraison> personnes = new ArrayList<>();
                //String prod_rech= recherche.getText();
                try {
                    personnes=(ArrayList<livraison>) ps.FindLivraison(findLiv.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(LivraisonbackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObservableList<livraison> obsl = FXCollections.observableArrayList(personnes);
                TableLivraison.setItems(obsl);
                Livraison.setCellValueFactory(new PropertyValueFactory<>("ID_Livraison"));
                Montant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
                Etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
                Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
                Addresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                Livreur.setCellValueFactory(new PropertyValueFactory<>("nomLivreur"));
                
            } catch (SQLException ex) {
                Logger.getLogger(LivraisonbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void modifierLiv(ActionEvent event) throws SQLException {
        ServiceLivraison sl = new ServiceLivraison();
        livraison l = new livraison();
        
        l.setID_Livraison(Integer.parseInt(IDLivFld.getText()));
        l.setMontant(Float.parseFloat(MontantFld.getText()));
        java.util.Date dateaj=java.sql.Date.valueOf(DateFld.getValue());
        l.setDate((java.sql.Date) dateaj);
        l.setEtat(Integer.parseInt(EtatFld.getText()));
        l.setAdresse(AdresseFld.getText());
        l.setNomLivreur(LivreurFld.getText());
        
        
        int aj=sl.modiferLivraison(l);
      if(aj>0){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Livraison");
          alert.setHeaderText("Information");
          alert.setContentText("La livraison a été bien modifée");
          alert.showAndWait();
          
          IDLivFld.clear();
          MontantFld.clear();
          DateFld.setValue(LocalDate.now());
          EtatFld.clear();
          AdresseFld.clear();
          LivreurFld.clear();
         
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
    private void affecterLivreur(ActionEvent event) throws SQLException {
        ServiceLivraison sl = new ServiceLivraison();
        livraison l = new livraison();
        
        
        sl.AffecterLivreur(Integer.valueOf(String.valueOf(livraisonCMBX.getValue())),String.valueOf(livreurCMBX.getValue()));
        sl.StatusLivreur(String.valueOf(livreurCMBX.getValue()), "Occupé");
        sl.EtatLivraison(Integer.valueOf(String.valueOf(livraisonCMBX.getValue())), 1);
        
        livraisonCMBX.getItems().removeAll(livraisonCMBX.getItems());
        livreurCMBX.getItems().removeAll(livreurCMBX.getItems());
        
        livraisonCMBX.setItems(sl.getIdLivraison());
        livreurCMBX.setItems(sl.getNomLivreur());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Livraison");
        alert.setHeaderText("Information");
        alert.setContentText("La livraison a été bien affectée");
        alert.showAndWait();
        
        SMS smsAffect = new SMS();
        smsAffect.SendSMS("seifoun", "Azerty123", "Bonjour, vous avez une livraison. /n Veuillez vérifier votre compte", "+21620542609", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        
        afficher();
        
    }

    @FXML
    private void terminerLivraison(ActionEvent event) throws SQLException {
        ServiceLivraison sl = new ServiceLivraison();
        
        sl.terminerLivraison(Integer.valueOf(IDLivFld.getText()));
        sl.terminerLivreur(LivreurFld.getText());
        livreurCMBX.getItems().removeAll(livreurCMBX.getItems());
        livreurCMBX.setItems(sl.getNomLivreur());
        
        IDLivFld.clear();
          MontantFld.clear();
          DateFld.setValue(LocalDate.now());
          EtatFld.clear();
          AdresseFld.clear();
          LivreurFld.clear();
        
        afficher();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Livraison");
        alert.setHeaderText("Information");
        alert.setContentText("La livraison est bien terminé");
        alert.showAndWait();
        
        
    }

    @FXML
    private void Actualiser(ActionEvent event) throws SQLException {
        ServiceLivraison sl =  new ServiceLivraison();
        afficher();
        livraisonCMBX.setItems(sl.getIdLivraison());
        livreurCMBX.setItems(sl.getNomLivreur());
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
