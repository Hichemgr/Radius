/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ProduitService;



/**
 *
 * @author raedm
 */
public class AjoutP {
       Form f;
    TextField tnom;
    TextField tprix;
    TextField tsaison;
    TextField tquantite;
    TextField tnote;
    TextField tdescription;
    TextField tid;
    Button btnajout,btnaff,btnrech,btnsup;
    String[] characters = { "Choisir Note","1", "2", "3", "4","5"
     /* cropped */
};
    
    public AjoutP(){
     f = new Form("Ajouter Un Produit",new BoxLayout(BoxLayout.Y_AXIS));
     tnom = new TextField("","Nom Produit");
        tprix = new TextField("","Prix");
           tquantite = new TextField("","Quantite");
             tdescription = new TextField("","Description");
        tsaison = new TextField("","Saison");   
              tnote = new TextField("","Note");
              tid = new TextField("","ID");
              
        btnajout = new Button("Ajouter Produit");
      
        f.add(tnom);
        f.add(tprix);
         f.add(tsaison);
           f.add(tquantite);
             f.add(tdescription);
              // f.add(tnote);
             
        
        Picker note = new Picker();
note.setStrings(characters);
note.setSelectedString(characters[0]);
note.addActionListener(e -> ToastBar.showMessage("Votre Choix:" + note.getSelectedString(), FontImage.MATERIAL_INFO));
 f.add(note);
 f.add(btnajout);
//        f.add(btnaff);
//         f.add(btnrech);
//          f.add(tid);
//          f.add(btnsup);

        btnajout.addActionListener((ActionEvent e) -> {
             LocalNotification n = new LocalNotification();
        n.setId("Ajout-notification");
        n.setAlertBody("Produit Ajoute");
        n.setAlertTitle("Success!");
        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis(), // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
            ProduitService ser = new ProduitService();
            Produit prod=new Produit();
            String rating=note.getSelectedString();
           int rate= Integer.valueOf(rating);
            Produit p = new Produit( tnom.getText(),tprix.getAsInt(0) ,tquantite.getAsInt(0),rate,tdescription.getText(),tsaison.getText());                       
            ser.ajoutProduit(p);  
             ToastBar.showMessage("Produit Ajoute" , FontImage.MATERIAL_INFO);
       
         
        
        
        });
        f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Home h=new Home();
            h.getF().show();
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
    public TextField getTprix() {
        return tprix;
    }

    public void setTprix(TextField tprix) {
        this.tprix = tprix;
    }
    public TextField getTquantite() {
        return tquantite;
    }

    public void setTquantite(TextField tquantite) {
        this.tquantite = tquantite;
    }
    public TextField getTnote() {
        return tnote;
    }

    public void setTnote(TextField tnote) {
        this.tnote = tnote;
    }
    public TextField getTdescription() {
        return tdescription;
    }

    public void setTdescription(TextField tdescription) {
        this.tdescription = tdescription;
    }
    public TextField getTsaison() {
        return tsaison;
    }

    public void setTsaison(TextField tsaison) {
        this.tsaison = tsaison;
    }
}
