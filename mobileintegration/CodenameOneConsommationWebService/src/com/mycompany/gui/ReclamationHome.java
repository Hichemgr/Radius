/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceReclamation;
import com.mycompany.Entite.Reclamation;
import com.teknikindustries.bulksms.SMS;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ReclamationHome {

    Form f;
    Label tnomproduit;
    TextField tsuejt;
    TextField tcontenu;
    TextField tetat;
    TextField tcommentaire;
    Button btnajout,btnaff;
    Picker p;
    

    public ReclamationHome(Resources theme) {
        f = new Form("Reclamation");
        tnomproduit = new Label("nomproduit");
        tetat = new TextField("","état");
        tsuejt = new TextField("","tsuejt");
        tcontenu = new TextField("","tcontenu");
        tcommentaire = new TextField("","tcommentaire");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
       p = new Picker();
//       ImageViewer img=new ImageViewer(theme.getImage("18.jpg"));
     //f.add(img);
        f.add(tnomproduit);
        f.add(p);
       // f.add(tetat);
        f.add(tsuejt);
        f.add(tcontenu);
        //f.add(tcommentaire);
        f.add(btnajout);
        f.add(btnaff);
        
         String[] characters = { "fleur", "hibiscus", "marguerite", "palnteverte"
     /* cropped */
};



p.setStrings(characters);
p.setSelectedString(characters[0]);
p.addActionListener(e -> ToastBar.showMessage("You picked " + p.getSelectedString(), FontImage.MATERIAL_INFO));
  f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeSAV h=new HomeSAV(theme);
          h.getF().show();
          });
  
        btnajout.addActionListener((e) -> {
            ServiceReclamation ser = new ServiceReclamation();
        

            Reclamation t = new Reclamation(p.getSelectedString(),tsuejt.getText(),tcontenu.getText());
            SMS smsText = new SMS();
      //    smsText.SendSMS("abidkadi", "12312312", "votre reclamation est en cours", "+21625236224", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0") ;           
        ser.ajoutReclamation(t);
            Dialog.show("Valider", "votre reclamation a ete envoyer ","ok","cancel");

        });

        
        btnaff.addActionListener((e)->{
        Affichager a=new Affichager(theme);
        a.getF().show();
        });
    }


  
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getTnomproduit() {
        return tnomproduit;
    }

    public void setTnomproduit(Label tnomproduit) {
        this.tnomproduit = tnomproduit;
    }

    public Picker getP() {
        return p;
    }

    public void setP(Picker p) {
        this.p = p;
    }

    

    public TextField getTsuejt() {
        return tsuejt;
    }

    public void setTsuejt(TextField tsuejt) {
        this.tsuejt = tsuejt;
    }

    public TextField getTcontenu() {
        return tcontenu;
    }

    public void setTcontenu(TextField tcontenu) {
        this.tcontenu = tcontenu;
    }

    public TextField getTetat() {
        return tetat;
    }

    public void setTetat(TextField tetat) {
        this.tetat = tetat;
    }

    public TextField getTcommentaire() {
        return tcommentaire;
    }

    public void setTcommentaire(TextField tcommentaire) {
        this.tcommentaire = tcommentaire;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }

  
}
