/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Service.ServiceTask;
import com.mycompany.Entite.Task;
import com.mycompany.Entite.panier;
import com.mycompany.Service.ServiceLigneproduit;
import com.mycompany.Service.ServicePanier;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom,nomu,passu;
    TextField tetat;
    Button btnajout,btnaff,btrech,btsupprimer,btnpanier;

    public HomeForm() {
        f = new Form("home");
        tnom = new TextField("","idutilisateur");
        tetat = new TextField("","état");
        
         nomu = new TextField("nom");
        passu = new TextField("password");
        
        btnajout = new Button("Se connecter");
        btnaff=new Button("Affichage");
        btrech=new Button("Rechercher");
        btnpanier=new Button("Panier");
       // f.add(btrech);
        //f.add(tnom);
        f.add(nomu);
        f.add(passu);
        //f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        //f.add(btnpanier);
        btnajout.addActionListener((e) -> {
          /*  ServicePanier ser = new ServicePanier();
            panier t = new panier(tnom.getAsInt(0), tetat.getAsInt(0));
            ser.ajoutTask(t);*/
            ServiceLigneproduit s=new ServiceLigneproduit();
            s.connect(nomu.getText(),passu.getText());
            Dialog.show("Bonjour", "connecte en tant que "+nomu.getText(), "Ok","Cancel");
             AffichageProduit h=new AffichageProduit();
                          h.getF().show();
            

        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
        
       /* btnpanier.addActionListener((e)->{
        AffichageLigne a=new AffichageLigne();
        a.getF().show();
        });*/
        
         btrech.addActionListener((e) -> {
          
        });
         
         
            Toolbar t =f.getToolbar();
           
          
          
          t.addMaterialCommandToLeftSideMenu("panier", FontImage.MATERIAL_ACCOUNT_BOX,new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                   AffichageLigne a=new AffichageLigne();
                    a.getF().show();
                   
                 
            }
        });
          
           t.addMaterialCommandToLeftSideMenu("Catalogue", FontImage.MATERIAL_ACCOUNT_BOX,new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                     AffichageProduit a=new AffichageProduit();
                    a.getF().show();
                   
                   
                 
            }
        });
                       
                        
                        
                  
                  
               
           
       /*  btsupprimer.addActionListener((e)->{
        Form supp=new Form();
        TextField t=new TextField();
        supp.add(t);
        //Button ok=new 
        });*/
        
        
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
