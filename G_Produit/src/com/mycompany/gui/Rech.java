/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.db.Database;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ProduitService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raedm
 */
public class Rech extends Form {
   Form f;
   Form resultat;
    SpanLabel lb;
 Button btnrech;
   TextField tid;
   /********/
   // Form f;
   
    TextField trecherche;
    Button btnrecherche;
    Button btn;
   ProduitService ser=new ProduitService();
   Produit prod=new Produit();
    ArrayList<Produit> produits = new ArrayList<>();
    ///////////////////////////////////////
     private ImageViewer imgv;
    private Image img;
    private EncodedImage enc;
   private Resources theme;
   /**********/
   
    public Rech() {
     f = new Form("Recherche");
        lb = new SpanLabel("");
       /// f.add(lb);
          tid = new TextField("","Nom Produit");
              
         btnrech = new Button("Rechercher Produit");
          f.add(tid);
        f.add(btnrech);
             btnrech.addActionListener((ActionEvent e) -> {
          String rech=tid.getText();
           ProduitService serviceProduit=new ProduitService();
           Produit p=new Produit();
           
        //serviceProduit.rech(rech,prod); 
          resultat=new Form("Resultat");
         lb = new SpanLabel("");
         lb.setText(serviceProduit.rech(rech,p).toString());
       
         resultat.add(lb);
       /***************************************/
   
          resultat.getToolbar().addCommandToRightBar("Back", null, (ev)->{Rech h=new Rech();
          h.getF().show();
          });
         resultat.show();
        });
       
        
          f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Home h=new Home();
          h.getF().show();
          });
    }
   
      
     
    public Form getResultat() {
        return resultat;
    }

    public void setResultat(Form resultat) {
        this.resultat = resultat;
    }

  /**
     *
     * @return f
     */
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }   
}
