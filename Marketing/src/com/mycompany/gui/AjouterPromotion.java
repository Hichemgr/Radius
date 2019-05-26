/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


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
 * @author ASUS
 */
public class AjouterPromotion {
     Form f;
    TextField tnom;
    TextField tpourcentage;
//        TextField tnomproduit;

    
    Button btnajout ; 
    
    public AjouterPromotion() {
        f = new Form("Ajouter");
          String[] characters = { "fleur", "hibiscus", "marguerite", "palnteverte"
     /* cropped */
};
    
    Picker nomproduit = new Picker();
nomproduit.setStrings(characters);
nomproduit.setSelectedString(characters[0]);
nomproduit.addActionListener(e -> ToastBar.showMessage("You picked " + nomproduit.getSelectedString(), FontImage.MATERIAL_INFO));

      tnom = new TextField("","nom");
        tpourcentage = new TextField("","pourcentage");
//        tnomproduit = new TextField("","nomproduit") ; 
        btnajout = new Button("Ajouter");
        
        f.add(tnom);
        f.add(tpourcentage);
        f.add(nomproduit);
//        f.add(tnomproduit);
        
        
        f.add(btnajout);
         /*****************Button Back*******************/
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
            h.getF().show();
          });
         /***********************************************/
        
        btnajout.addActionListener((e) -> {
            ServicePromotion ser = new ServicePromotion();
            Promotion t = new Promotion( tnom.getText(), tpourcentage.getAsInt(0),nomproduit.getSelectedString());
            ser.ajoutTask(t);
            

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
    

