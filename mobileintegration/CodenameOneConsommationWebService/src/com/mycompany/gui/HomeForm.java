/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.Entite.Assisstance;
import com.mycompany.Service.ServiceTask;
import com.mycompany.Entite.Task;
import com.mycompany.Service.ServiceAssisstance;
import java.util.Date;


/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff;
    private Resources theme;

    public HomeForm() {
        f = new Form("Assistance");
        tnom = new TextField("","nom");
        tetat = new TextField("","Type");
        btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
        
        Label l1=new Label("Date Assisstance: ");
        f.add(l1);
        Picker dateassiss=new Picker();
        f.add(dateassiss);
        
        
       // f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        Toolbar to=f.getToolbar();
         
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstance",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstant",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            HomeassisstantForm ha=new HomeassisstantForm();
            ha.getF().show();
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Conseil",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                  HomeconseilForm ha=new HomeconseilForm();
            ha.getF().show();
            
            }
        });
   //      Toolbar t =f.getToolbar();
         /*  Image icon = theme.getImage("background.png"); 
          Container topBar = BorderLayout.east(new Label(icon));
        topBar.add(BorderLayout.SOUTH, new Label("Radius Garden", "SidemenuTagline")); 
        topBar.setUIID("SideCommand");
        to.addComponentToSideMenu(topBar);*/
       


     /*   to.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {new Home().getF().show();});
        to.addMaterialCommandToSideMenu("List des Produits", FontImage.MATERIAL_LIST, e -> {new Prod(theme).getF().show();});
        to.addMaterialCommandToSideMenu("Envoyer SMS", FontImage.MATERIAL_MESSAGE, e -> {new EnvoyerMessage().getF().show();});
         to.addMaterialCommandToSideMenu("Envoyer Mail", FontImage.MATERIAL_MAIL, e -> {new SendMail().getF().show();});
            to.addMaterialCommandToSideMenu("Rechercher", FontImage.MATERIAL_SEARCH, e -> {new Rech().getF().show();});*/
          to.addMaterialCommandToLeftSideMenu("List des Produits", FontImage.MATERIAL_ACCOUNT_BOX,e -> {new Prod(theme).getF().show();}); 
          to.addMaterialCommandToLeftSideMenu("Gestion produit", FontImage.MATERIAL_ACCOUNT_BOX, e -> {new Home().getF().show();}); 

           
          to.addMaterialCommandToLeftSideMenu("panier", FontImage.MATERIAL_ACCOUNT_BOX,new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                   AffichageLigne a=new AffichageLigne();
                    a.getF().show();
                   
                 
            }
        });
          
      
   
  f.getToolbar().addCommandToLeftSideMenu("SAV", null, (ev)->{HomeSAV h=new HomeSAV(theme);
          h.getF().show();
          });
   f.getToolbar().addCommandToLeftSideMenu("Livraison", null, (ev)->{Homeliv h = new Homeliv();
        h.getF().show();
        });

          
          f.getToolbar().addCommandToLeftSideMenu("Promotion", null, (ev)->{HomeFormPromotion h=new HomeFormPromotion();
          h.getF().show();
          });
           to.addMaterialCommandToLeftSideMenu("Catalogue", FontImage.MATERIAL_ACCOUNT_BOX,new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                     AffichageProduit a=new AffichageProduit();
                    a.getF().show();
                   
                   
                 
            }
        });
        btnajout.addActionListener((e) -> {
            ServiceAssisstance ser = new ServiceAssisstance();
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                
                date = dateFormat.parse("14/05/2019");
            } catch (ParseException ex) {
                
            }
            Assisstance t = new Assisstance("1","1",date,tetat.getText());
            ser.ajoutTask(t);
            // hethi kenet f constructeur tnom.getText()

        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
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