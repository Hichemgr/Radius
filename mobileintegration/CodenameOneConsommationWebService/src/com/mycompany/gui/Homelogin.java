/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Assisstance;
import com.mycompany.Service.ServiceAssisstance;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Homelogin {
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bhk
 */


    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff;

    public Homelogin(Form f, TextField tnom, TextField tetat, Button btnajout, Button btnaff) {
        this.f = f;
        this.tnom = tnom;
        this.tetat = tetat;
        this.btnajout = btnajout;
        this.btnaff = btnaff;
    }
    
    

    public Homelogin() {
        f = new Form("home");
        tnom = new TextField("","Username");
        tetat = new TextField("","Mot de passe");
        btnajout = new Button("Se connecter");
     //   btnaff=new Button("Affichage");
        
       tetat.setConstraint(TextField.PASSWORD);
        
        
        f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
      //  f.add(btnaff);
      
        btnajout.addActionListener((e) -> {
            ServiceAssisstance ser = new ServiceAssisstance();
          ser.login(tnom.getText(),tetat.getText());
          Dialog.show("Login","Bonjour vous etez connecter en tant que "+tnom.getText(),"OK",null);
              HomeForm ha=new HomeForm();
            ha.getF().show();
           // Assisstance t = new Assisstance("1","1",date,tetat.getText());
            //ser.ajoutTask(t);
            // hethi kenet f constructeur tnom.getText()

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
