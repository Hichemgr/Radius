/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.Entite.Livraison;
import com.mycompany.Service.ServiceLigneproduit;
import com.mycompany.Service.ServiceLivraison;
import com.teknikindustries.bulksms.SMS;

/**
 *
 * @author seifeddinebenfraj
 */
public class HomeFormlib {
        Form f;
    TextField tadresse;
    TextField tmontant;
    TextField tetat;
    Button btnajout,btnaff,btnmodifier,btnaffecter,payer;

    public HomeFormlib() {
        f = new Form("Livraisons");
        tadresse = new TextField("","Adresse");
        tmontant = new TextField("", "Nom Client");
        tetat = new TextField("","état");
        btnajout = new Button("Ajouter");
        btnaff=new Button("Afficher");
        btnmodifier = new Button("Modifier");
        btnaffecter = new Button("Affecter");
        payer = new Button("Payer");
        
        f.add(tmontant);
        f.add(tadresse);
        //f.add(tetat);
        //f.add(btnajout);
        f.add(payer);
        f.add(btnaff);
        f.add(btnmodifier);
        f.add(btnaffecter);
         ServiceLigneproduit serviceTask=new ServiceLigneproduit();
          float to=serviceTask.getTotal(2);
        Label totalt=new Label("Totale de la commande :"+to+"dt");
        f.add(totalt);
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{Homeliv h = new Homeliv();
        h.getF().show();
        });
        
        
        btnaff.addActionListener((e)->{
        Affichageliv a=new Affichageliv();
        a.getF().show();
        });
        
        
        btnmodifier.addActionListener((e)->{
        Modifierliv a=new Modifierliv();
        a.getF().show();
        
        });
        
        
        btnaffecter.addActionListener((e)->{
            Affectation a = new Affectation();
            a.getF().show();
        });
        
        payer.addActionListener((e)->{
            ServiceLivraison ser = new ServiceLivraison();
            Livraison t = new Livraison(to,tmontant.getText(), tadresse.getText());
            ser.ajoutLivraison(t);
            
            SMS smsText = new SMS();
         //   smsText.SendSMS("seifoun123","codenameone", "\n votre livraison a été effectue avec sucees avec un montant de :50 dt"  , "+24552497", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

           
       PaymentForm pf=new PaymentForm();
        pf.show();
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tadresse;
    }

    public void setTnom(TextField tnom) {
        this.tadresse = tnom;
    }

    public TextField getTmontant() {
        return tmontant;
    }

    public void setTmontant(TextField tmontant) {
        this.tmontant = tmontant;
    }

    public TextField getTetat() {
        return tetat;
    }

    public void setTetat(TextField tetat) {
        this.tetat = tetat;
    }
    
}
