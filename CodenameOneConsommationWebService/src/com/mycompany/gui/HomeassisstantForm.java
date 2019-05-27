/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ShareButton;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
//import com.mycompany.Entite.Assisstance;
import com.mycompany.Entite.Assisstant;
import com.mycompany.Service.ServiceAssisstance;
import com.mycompany.Service.ServiceAssisstant;
import com.teknikindustries.bulksms.SMS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author ASUS
 */
public class HomeassisstantForm {
    



    Form f;
    TextField tnom,tprenom,tcin;
    TextField tetat;
    Button btnajout,btnaff,btnrech;

    public HomeassisstantForm() {
        f = new Form("home");
        tnom = new TextField("","Nom");
        tprenom = new TextField("","Prenom");
        tcin= new TextField("","Cin");
        tetat = new TextField("","Etat");
        btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
        TextField recha=new TextField("","Id assisstant");
        btnrech=new Button("recherche");
        
   //     recha.addDataChangedListener(new ActionEvent(recha));
        
        //Label l1=new Label("Date Assisstance: ");
        //f.add(l1);
       // Picker dateassiss=new Picker();
        //f.add(dateassiss);
        
        
       // f.add(tnom);
        f.add(tnom);
        f.add(tprenom);
        f.add(tcin);
        f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        f.add(recha);
        f.add(btnrech);
        btnrech.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
             
                ServiceAssisstant as=new ServiceAssisstant();
    //    System.out.println("iddddddddddddddddddddddddd"+id+"\n");
           ArrayList<Assisstant> listTasksfind = new ArrayList<>();
           listTasksfind=as.getrechList2(Integer.valueOf(recha.getText()));
            
            for(Assisstant c:listTasksfind)
        {
            
          Dialog.show("ok","Le nom est: "+c.getNom()+"\n Le prenom est: "+c.getPrenom()+"\n L'etat est: "+c.getEtat(), "YES", "NO");
        }

            }
        });
        Toolbar to=f.getToolbar();
         
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstance",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm ha=new HomeForm();
            ha.getF().show();
            
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstant",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Conseil",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 HomeconseilForm ha=new HomeconseilForm();
            ha.getF().show();
            
            }
        });
        Button mai=new Button("Envoyer mail");
         Button maisms=new Button("Envoyer SMS");
        
       
          mai.addActionListener((e) -> {
             Message m = new Message("Nouveau contrat");
                    Display.getInstance().sendMessage(new String[]{"mohamedslim.koubaa@esprit.tn"}, "Assistance", m);
              


        });
      f.add(mai);
      maisms.addActionListener((e) -> {
            
              

SMS smsText = new SMS();
        smsText.SendSMS("slim1997","mamatan1", "\n Assistant : \n L'assistant a été ajouter " , "+21652377888", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

        });
      f.add(maisms);
        btnajout.addActionListener((e) -> {
            ServiceAssisstant ser = new ServiceAssisstant();
           
            Assisstant t = new Assisstant(tnom.getText(),tprenom.getText(),Integer.valueOf(tcin.getText()),tetat.getText());
            ser.ajoutTask(t);
            // hethi kenet f constructeur tnom.getText()

        });
        btnaff.addActionListener((e)->{
        Affichageassisstant a=new Affichageassisstant();
        a.getF().show();
        });
             ShareButton sb = new ShareButton();
        f.add(sb);
          //  sb.setIcon(Image.createImage("/fb.png"));
        
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
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }
     

}
