/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
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
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ProduitService;

/**
 *
 * @author raedm
 */
public class Home {
   Form f;
    private Resources theme;
    Button btnajout,btnaff,btnrech,btnsup,btnmail,btnsms,btnmodifier;

    public Home() {
        f = new Form("Gestion Produit");
      /****************************ToolBar********************/
      
      f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        theme = UIManager.initNamedTheme("/theme", "Theme");
        Toolbar tb = f.getToolbar();
        Image icon = theme.getImage("background.png"); 
       
        Container topBar = BorderLayout.east(new Label(icon));
        topBar.add(BorderLayout.SOUTH, new Label("Radius Garden", "SidemenuTagline")); 
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
       
tb.addMaterialCommandToLeftSideMenu("Home",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm ha=new HomeForm();
            ha.getF().show();
            
            }
        });

       // tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, );
        tb.addMaterialCommandToSideMenu("List des Produits", FontImage.MATERIAL_LIST, e -> {new Prod(theme).getF().show();});
        tb.addMaterialCommandToSideMenu("Envoyer SMS", FontImage.MATERIAL_MESSAGE, e -> {new EnvoyerMessage().getF().show();});
         tb.addMaterialCommandToSideMenu("Envoyer Mail", FontImage.MATERIAL_MAIL, e -> {new SendMail().getF().show();});
           // tb.addMaterialCommandToSideMenu("Rechercher", FontImage.MATERIAL_SEARCH, e -> {new Rech().getF().show();});
        //tb.addMaterialCommandToSideMenu("Ajouter evenement ", FontImage.MATERIAL_EVENT, e -> {new Evenements(theme).show();});
       
              // tb.addMaterialCommandToSideMenu("maps", FontImage.MATERIAL_EVENT, e -> {new GoogleMap().getHi().show();
      /*******************************************************/
              
        btnajout = new Button("Ajouter Produit");
        btnaff=new Button("Afficher Produit");
        btnrech=new Button("Rechercher Produit");
        btnsup=new Button("Supprimer Produit");
        btnmail=new Button("Envoyer Mail");
        btnsms=new Button("Envoyer SMS");
         btnmodifier=new Button("Modifier Produit");
       
        f.add(btnajout);
        //f.add(btnaff);
         //f.add(btnrech);
          f.add(btnsup);
          //f.add(btnmail);
          f.add(btnmodifier);
          
          //f.add(btnsms);
          
          
       btnajout.addActionListener((s)->{
        AjoutP p=new AjoutP();
        p.getF().show();
        });
        btnaff.addActionListener((s)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
    
//     btnrech.addActionListener((ActionEvent s) -> {
//        Rech a=new Rech();
//        a.getF().show();
////            ProduitService ser = new ProduitService();
////            Produit prod=new Produit();
////            //Produit p = new Produit( tnom.getText(),tprix.getAsInt(0) ,tquantite.getAsInt(0),tnote.getAsInt(0),tdescription.getText(),tsaison.getText());
////           int id=tid.getAsInt(0);
////            ser.find(id);
//            
//
//        });
     btnsup.addActionListener((s)->{
        SupProd a=new SupProd();
        a.getF().show();
        });
     btnsms.addActionListener((s)->{
        EnvoyerMessage p=new EnvoyerMessage();
        p.getF().show();
        });
     btnmodifier.addActionListener((s)->{
        ModifierProd a=new ModifierProd();
        a.getF().show();
        });
    
     
//      btnsup.addActionListener((ActionEvent e) -> {
//         SupProd a=new SupProd();
//        a.getF().show();
//        });
//            ProduitService ser = new ProduitService();
//           Produit prod=new Produit();
//            //Produit p = new Produit( tnom.getText(),tprix.getAsInt(0) ,tquantite.getAsInt(0),tnote.getAsInt(0),tdescription.getText(),tsaison.getText());
//            int id=tid.getAsInt(0);
//            ser.supprimerProduit(id);
          
            

    
    
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }


 
}
