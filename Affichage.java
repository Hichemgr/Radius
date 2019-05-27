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
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.panier;
import com.mycompany.Service.ServicePanier;
import java.util.ArrayList;
//import com.mycompany.Service.ServiceTask;

/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
    SpanLabel lb2;
    
    public void AddItem(panier c){
        Button modif=new Button("modifier");
           Button supp=new Button("supprimer");
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
      //  ImageViewer img=new ImageViewer(theme.getImage(c.getImg()));
         Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label l=new Label("idpanier est :"+String.valueOf(c.getIdpanier()));
          Label u=new Label("idutilisateur est :"+String.valueOf(c.getIdutilisateur()));
            Label tel=new Label("l'etat :"+String.valueOf(c.getEtat()));
            
            supp.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
              //  Form f=new Form();
                 ServicePanier ser = new ServicePanier();
            
            ser.supprimerpanier(c.getIdpanier()); 
            f.removeAll();
            HomeForm h=new HomeForm();
          h.getF().show();
           
                
                
            }
        });
            modif.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
                Form fod=new Form();
                 ServicePanier ser = new ServicePanier();
                  //TextField ip=new TextField(c.getIdpanier());
                TextField v=new TextField("nouveau etat");
                Button bo=new Button("Valider");
                fod.add(bo);
               
                //fod.add(ip);
                 fod.add(v);
                fod.show();
                bo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ser.Modifierpanier(c.getIdpanier(),Integer.valueOf(v.getText()));
                        HomeForm h=new HomeForm();
                          h.getF().show();
                    }
                });
           // ser.supprimerpanier(c.getIdpanier()); 
//            f.removeAll();
//            HomeForm h=new HomeForm();
//          h.getF().show();
           
                
                
            }
        });
            
            
            
            c2.add(l);
            c2.add(tel);
            c2.add(u);
            //c1.add(img);
             c1.add(c2);
            c1.add(modif);
            c1.add(supp);
           
            f.add(c1);
            f.refreshTheme();
         
    
    
    }
  
    public Affichage() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServicePanier serviceTask=new ServicePanier();
      // lb.setText(serviceTask.getList2().toString());
         ArrayList<panier> pan = new ArrayList<>();
         pan=serviceTask.getList2();
          for(panier c : pan)
        {
            AddItem(c);
        }
           //  f.show();
        //lb.setText(serviceTask.rech(30).toString());
        
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
