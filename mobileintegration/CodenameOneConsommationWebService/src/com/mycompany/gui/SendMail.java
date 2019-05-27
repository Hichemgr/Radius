/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Service.ProduitService;

/**
 *
 * @author raedm
 */
public class SendMail {
Button btnmail;
 TextField address;
    TextField sujet;
    TextField message;
Form f;
    public SendMail() {
          f = new Form("Envoyez Mail",new BoxLayout(BoxLayout.Y_AXIS));
           address = new TextField("","Send To");
        sujet = new TextField("","Subject");
        message = new TextField("","Message");
        btnmail = new Button("Suivant");
        f.add(address);
         f.add(sujet);
         f.add(message);
         f.add(btnmail);
          
         btnmail.addActionListener((ActionEvent s) -> {
       
           ProduitService ser=new ProduitService();
           String taddress=address.getText() ;
           String tsujet=sujet.getText() ;
           String tmessage=message.getText() ;
           ser.mail(taddress,tsujet,tmessage);
        });
          f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Home h=new Home();
            h.getF().show();
          });
    }

    public Button getBtnmail() {
        return btnmail;
    }

    public void setBtnmail(Button btnmail) {
        this.btnmail = btnmail;
    }

    public TextField getAddress() {
        return address;
    }

    public void setAddress(TextField address) {
        this.address = address;
    }

    public TextField getSujet() {
        return sujet;
    }

    public void setSujet(TextField sujet) {
        this.sujet = sujet;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
