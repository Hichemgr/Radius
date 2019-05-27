/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.teknikindustries.bulksms.SMS;

/**
 *
 * @author raedm
 */
public class EnvoyerMessage {
  Form f;
    Button btnsms;
     TextField message;
    TextField num;
    public EnvoyerMessage(){
     f = new Form("Envoyer Un SMS");
     //message = new TextField("","Entrez Le Message");
        num = new TextField("","Entrez Le Num");
    btnsms= new Button("Envoyer SMS");
    f.add(num);
    f.add(btnsms);
    
     btnsms.addActionListener((s)->{
       SMS smstut= new SMS();
      String number=num.getText();
 smstut.SendSMS("raedrebeii","i3jQMTPzgNQ4iQy","Des nouveaux produits sont disponibles visitez notre boutique." ,number, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

        });
      f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Home h=new Home();
          h.getF().show();
          });
    }     
    public Form getF() {
        return f;
    }
  
}
