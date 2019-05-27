/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ProduitService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raedm
 */
public class SupProd {
    ProduitService ser=new ProduitService();
    ArrayList<Produit> names = new ArrayList<>();
   Form f;
   Button btnsup;
   TextField tid;
   private Resources theme;
    SpanLabel lb;
        ////////////////////////////////////////////////////////

    public SupProd() {
        f= new Form("Suppression");
           //////////////////////NameBox///////////////////////////
        ProduitService ser=new ProduitService();
        
/*********************/
 


tid = new TextField("","Id Produit");
         btnsup = new Button("Supprimer Produit");
          f.add(tid);
        f.add(btnsup);
          lb = new SpanLabel("");
        f.add(lb);
        ProduitService serviceProduit=new ProduitService();
          lb.setText(serviceProduit.getList2().toString());
       // f.add(name);
             btnsup.addActionListener((ActionEvent e) -> {
          
           Produit prod=new Produit();
//ProduitService ser = new ProduitService();
            int id=tid.getAsInt(0);
            ser.supprimerProduit(id);
             ToastBar.showMessage("Produit Supprimme" , FontImage.MATERIAL_INFO);
      });
     f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Home h=new Home();
          h.getF().show();
          });
     
       List<Produit> list = new ArrayList<>();

        list=ser.getList2();
         for (Produit p : list) {
            f.add(addItem(p,theme));
        }
         
         
}
     public Container addItem(Produit p , Resources theme ) {
        //Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.y());
        Label lnom = new Label(p.getNom_prod());
       String id= String.valueOf(p.getRef_prod());
        Label lid = new Label(id);
        //lnom.setAlignment(CENTER);
        
                      
        /************************************************/
        
      return cnt2;
      
     }
        
    
    
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }  
}
