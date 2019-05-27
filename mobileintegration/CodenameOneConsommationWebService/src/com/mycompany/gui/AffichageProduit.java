/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Produit;
import com.mycompany.Entite.ligneproduit;
import com.mycompany.Service.ServiceLigneproduit;

//import com.mycompany.Service.ServiceLigneproduit;
import com.mycompany.Service.ServiceProduit;
//import com.mycompany.Service.ServicePanier;
import java.util.ArrayList;
//import com.mycompany.Service.ServiceTask;

/**
 *
 * @author bhk
 */
public class AffichageProduit {

    Form f;
    SpanLabel lb;
    SpanLabel lb2;
    
    
    
    
      public void AddItem(Produit c){
         // TextField q=new TextField("Quantite desiré");
        Button ajout=new Button("Ajouter au panier");
           
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
      //  ImageViewer img=new ImageViewer(theme.getImage(c.getImg()));
         Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label l=new Label("idproduit est :"+String.valueOf(c.getRef_prod()));
           Label nom=new Label("le nom est :"+String.valueOf(c.getNom_prod()));
            Label tel=new Label("La quantite est :"+String.valueOf(c.getQuantite_prod()));
          
      
        
         /* ajout.addActionListener((e) -> {
                Form fa = new Form();
               Button val=new Button("valider");
                TextField quanti = new TextField("quantite");
               fa.add(quanti);
        fa.add(ajout);
        fa.show();
        val.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         ServiceLigneproduit ser = new ServiceLigneproduit();
            //ligneproduit t = new ligneproduit();
            ser.ajoutLigne(quanti.getAsInt(0));
                    }
                });
          
            

        });*/
            
             ajout.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
                Form fod=new Form();
                 ServiceLigneproduit ser = new ServiceLigneproduit();
                  //TextField ip=new TextField(c.getIdpanier());
                TextField v=new TextField("quantite");
                Button bo=new Button("Valider");
                fod.add(bo);
               
                //fod.add(ip);
                 fod.add(v);
                fod.show();
                bo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ser.ajoutLigne(c.getRef_prod(),Integer.valueOf(v.getText()));
                      /*  HomeForm h=new HomeForm();
                          h.getF().show();*/
                        AffichageLigne b=new AffichageLigne();
                        b.getF().show();
                    }
                });
               
                
            }
        });
            
            
            
            
            
            c2.add(l);
            c2.add(nom);
            c2.add(tel);
            //c1.add(img);
             c1.add(c2);
            c1.add(ajout);
         //   c1.add(q);
            
           
            f.add(c1);
            f.refreshTheme();
         
    
    
    }
 
  
    public AffichageProduit() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceProduit serviceTask=new ServiceProduit();
      // lb.setText(serviceTask.getList2().toString());
         ArrayList<Produit> ligne = new ArrayList<>();
         ligne=serviceTask.getListprod();
          
          for(Produit c : ligne)
        {
            AddItem(c);
        }
        
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
        
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
