/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.Service.ServicePromotion;
import com.mycompany.Entite.Promotion;
//import com.teknikindustries.bulksms.SMS;
import java.io.IOException;



/**
 *
 * @author bhk
 */
public class HomeFormPromotion {

    Form f;
//    TextField tnom;
//    TextField tpourcentage;
//        TextField tnomproduit;

    
    Button btnaff,btnmail,Share,SMS,afficher;
    private Resources theme;

    public HomeFormPromotion() {
        
//        String[] characters = { "fleur", "hibiscus", "marguerite", "palnteverte"
//     /* cropped */
//};


//Picker nomproduit = new Picker();
//nomproduit.setStrings(characters);
//nomproduit.setSelectedString(characters[0]);
//nomproduit.addActionListener(e -> ToastBar.showMessage("You picked " + nomproduit.getSelectedString(), FontImage.MATERIAL_INFO));

f = new Form("Promotion");
      /****************************ToolBar********************/
      
      f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        theme = UIManager.initNamedTheme("/theme", "Theme");
        Toolbar tb = f.getToolbar();
        Image icon = theme.getImage("background.png"); 
               ImageViewer img = new ImageViewer(theme.getImage("logo.png"));

        Container topBar = BorderLayout.east(new Label(icon));
        topBar.add(BorderLayout.SOUTH, new Label("Radius Garden", "SidemenuTagline")); 
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
       
f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
        tb.addMaterialCommandToSideMenu("Ajouter",  FontImage.MATERIAL_ADD, e -> {new AjouterPromotion().getF().show();});
        tb.addMaterialCommandToSideMenu("Modifier", FontImage.MATERIAL_EDIT, e -> {new Modifier().getF().show();});
        
        tb.addMaterialCommandToSideMenu("Afficher", FontImage.MATERIAL_VIEW_LIST, e -> {new AffichagePromotion().getF().show();});
        //tb.addMaterialCommandToSideMenu("Envoyer SMS", FontImage.MATERIAL_LIST, e -> {new EnvoyerMessage().getF().show();});
         ///tb.addMaterialCommandToSideMenu("Envoyer Mail", FontImage.MATERIAL_LIST, e -> {new EnvoyerMessage().getF().show();});
       //  tb.addMaterialCommandToSideMenu("List Demande", FontImage.MATERIAL_LIST, e -> {new AffichageDemande().getF().show();});
        //tb.addMaterialCommandToSideMenu("Ajouter evenement ", FontImage.MATERIAL_EVENT, e -> {new Evenements(theme).show();});
       
              // tb.addMaterialCommandToSideMenu("maps", FontImage.MATERIAL_EVENT, e -> {new GoogleMap().getHi().show();
      /*******************************************************/
       // f = new Form("Promotion");
//        tnom = new TextField("","nom");
//        tpourcentage = new TextField("","pourcentage");
//        tnomproduit = new TextField("","nomproduit") ; 
      // btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
        btnmail=new Button(" Mail ") ;
        Share=new Button("Share") ; 
        SMS=new Button("SMS") ; 
        afficher=new Button("aff") ; 
        //btnmodifier=new Button("Modifier") ; 
        //f.add(tnom);
       // f.add(tpourcentage);
     //  f.add(nomproduit);
//        f.add(tnomproduit);
        
        
        //f.add(btnajout);
        //f.add(btnaff);
       f.add(btnmail) ;
        f.add(Share) ; 
        f.add(SMS) ;
        f.add(afficher) ; 
       // f.add(btnmodifier) ; 
        
     /*  btnajout.addActionListener((e) -> {
            ServicePromotion ser = new ServicePromotion();
            Promotion t = new Promotion( tnom.getText(), tpourcentage.getAsInt(0),nomproduit.getSelectedString());
            ser.ajoutTask(t);
            

        });
        */
        btnaff.addActionListener((e)->{
        AffichagePromotion a=new AffichagePromotion();
        a.getF().show();
        });
       
        
ShareButton sb = new ShareButton();
  f.add(sb);
    sb.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
               //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                  Dialog.show("Bonjour", "Partagé dans votre profil", "Ok","Cancel");

             
           FacebookShare fb = new FacebookShare("EAACEdEose0cBADaFLZCAbsGVYR1lBgQu8OpZCINLwoZCi4PADr6s4YEP6oQOqw2Uswb126nohapF5M62jyOiIoAMUBT7U4mW2Vi5NqjGjPBVyHhMsCEgjBkSUmPHokShjZBZAbL1DX3KwJFpqmzzgRm1WM8lehZCc0VpnGHNrSeUZBRpuhSTSjCHklTsLDc5MDu1XtncM6VHgZDZD");
                 try {
                     fb.share("Russia 2018 Project .. Be ready .. !");
                 } catch (IOException ex) {
                 }
           
           
             
             }
         });
     
         btnmail.addActionListener((e) -> {
            SendMail a=new SendMail();
        a.getF().show(); 
            
    }); 
         afficher.addActionListener((ActionEvent e) -> {
            Prom a=new Prom(theme);
        a.getF().show(); 
            
    }); 
//SMS.addActionListener((e) -> {
//      SMS smsText = new SMS();
    // smsText.SendSMS("abdel1997 ","anas1997" , "Des promotions sont disponibles vistez notre boutique" ,"+21621646533", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");;
//});
//            btnmodifier.addActionListener((e)->{
//        Modifier a=new Modifier();
//        a.getF().show();
//        });
}


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

//    public TextField getTnom() {
//        return tnom;
//    }
//
//    public void setTnom(TextField tnom) {
//        this.tnom = tnom;
//    }

}

/**
 *
 * @author ASUS
 */

