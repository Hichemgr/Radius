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
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.utilisateurservice;



import java.util.Optional;
//import  org.security.crypto.bcrypt.BCrypt;

 



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InscriptionController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField mail;
    @FXML
    private TextField telephone;
    @FXML
    private TextField adresse;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button inscription;
    @FXML
    private DatePicker date;
    @FXML
    private PasswordField mdp2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           System.out.println("ok");
                try {
                  int mai=0;//mail
                  int mai2=0;
                  int c=0;//cin
                  int n=0;//nom
                  int p=0;//prenom
                  int t=0;//telephone
                  int m=0;//mot de passe
                  int m3=0;//mot de passe
                  int m2=0;//confirmez mot de passe
                  String emaill=mail.getText();
                 // java.sql.Date daatee=Date.valueOf(date.getValue());
     //   LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //datelyoum


                    char[] s=cin.getText().toCharArray();//cin
                    char[] sn=nom.getText().toCharArray(); //nom
                    char[] sp=prenom.getText().toCharArray(); //prenom
                    char[] st=telephone.getText().toCharArray(); //tel
                     char[] sm=mdp.getText().toCharArray(); //mot de passe
                   //       String format = "dd/MM/yy H:mm:ss"; 

//java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
//java.util.Date date = new java.util.Date(); 
              
                     if(!mdp.getText().equals(mdp2.getText()))
                     {
                         m2++;
                     }
                     if(cin.getText().equals(""))
                         c++;
                     if(nom.getText().equals(""))
                         n++;
                     if(prenom.getText().equals(""))
                         p++;
                     if(telephone.getText().equals(""))
                         t++;
                     if(mdp.getText().equals(""))
                         m++;
                   if(!emaill.contains("@"))
                       mai++;
                   if(!emaill.contains("."))
                       mai++;
                  
                    for(int i=0;i<s.length;i++)
                    {
                       if(!Character.isDigit(s[i]))
                           c++;
                    }
                    for(int i=0;i<st.length;i++)
                    {
                       if(!Character.isDigit(st[i]))
                           t++;
                    }
                   
                     for(int i=0;i<sn.length;i++)
                    {
                       if(Character.isDigit(sn[i]))
                           n++;
                    }
                      for(int i=0;i<sp.length;i++)
                    {
                       if(Character.isDigit(sp[i]))
                           p++;
                    }
                       for(int i=0;i<sm.length;i++)
                    {      
                       if(!Character.isDigit(sm[i]))
                           m++;
                       if(Character.isUpperCase(sm[i]))
                           m3++;
                    }
                       System.out.println("9balcondition");
                      if(mai==0){
                          System.out.println("okcondition");
                    utilisateurservice us = new utilisateurservice();
                    int cinn=Integer.valueOf(cin.getText());
                    
                    String noom=nom.getText();
                    String prenoom=prenom.getText();
                    java.sql.Date daate=Date.valueOf(date.getValue());
                    String mdpp=mdp.getText();
                    String adressee=adresse.getText();
                    System.out.println(daate);
                    
                   // String maiil
                            //date.getValue();
                   // date daate=
                    
          //            String hashed=BCrypt.hashpw(mdpp, BCrypt.gensalt());
                        System.out.println("wseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeel");
                  utilisateur u=new utilisateur(cinn,noom,prenoom,mdpp,mail.getText(),Integer.valueOf(telephone.getText()),daate,"on","client","user.png",0,adressee);
                    us.ajouterutilisateur(u);
                   // us.login(mail.getText(),mdpp);
                    us.setvalidationcode(mail.getText(),"q2uvd75d");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inscription");
		alert.setHeaderText("Inscription validé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
                 mailer.sendMail(String.valueOf(mail.getText()),"Code d'activation","Bonjour,\nVotre code est: q2uvd75d");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Code d'activation");
		alert1.setHeaderText("Mail envoyé avec succés!");
		//alert.setContentText("L'employé a été ajouté!");
		alert1.showAndWait();
                    try {
                        inscription.getScene().setRoot(FXMLLoader.load(getClass().getResource("codevalidation.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                      }
                      else
                      {
                                  /*     String format = "dd/MM/yy H:mm:ss"; 

java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
java.util.Date date = new java.util.Date(); 

             java.util.Date date2=new java.sql.Date(date.getTime());
                                        
             if (date.compareTo(date2)> 0)
             {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Erreur date");
		alert.setContentText("Veuillez vérifier le champ date!");
		alert.showAndWait();
             }*/
                          if(mai!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Adresse mail invalid");
		alert.setContentText("L'adresse mail doit contenir un . et un @!");
		alert.showAndWait();
                      }
                           if(c!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Cin invalid");
		alert.setContentText("Le Cin doit contenir 8 nombres!");
		alert.showAndWait();
                      }
                           if(n!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Nom invalid");
		alert.setContentText("Le nom doit contenir 8 nombres!");
		alert.showAndWait();
                      }
                           if(p!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Prenom invalid");
		alert.setContentText("Le prenom doit contenir que des lettres!");
		alert.showAndWait();
                      }
                             if(t!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Telephone invalid");
		alert.setContentText("Le telephone doit contenir que des chiffres!");
		alert.showAndWait();
                      }
                             if((m==0)||(m3==0)){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Mot de passe invalid");
		alert.setContentText("Le mot de passe doit contenir au moin 1 lettre majuscule et 1 chiffre!");
		alert.showAndWait();
                      }
                                  if(m2!=0){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'incription");
		alert.setHeaderText("Confirmation mot de passe invalid");
		alert.setContentText("Le mot de passe et la confirmation doivent etre égaux!");
		alert.showAndWait();
                      }
                      }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }    
    
}
