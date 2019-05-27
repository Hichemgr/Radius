/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.Entite.Livreur;
import com.mycompany.Service.ServiceLivraison;
import com.mycompany.Service.ServiceLivreur;

/**
 *
 * @author seifeddinebenfraj
 */
public class HomeForm1 {
        Form f;
    TextField nom;
    TextField prenom;
    TextField cin;
    Button btnajout,btnaff,btnmodifier;

    public HomeForm1() {
        f = new Form("Livreur");
        nom = new TextField("","Nom..");
        prenom = new TextField("", "Prenom..");
        cin = new TextField("","Cin..");
        btnajout = new Button("Ajouter");
        btnaff=new Button("Afficher");
        btnmodifier = new Button("Modifier");
        
        f.add(nom);
        f.add(prenom);
        f.add(cin);
        f.add(btnajout);
        f.add(btnaff);
        f.add(btnmodifier);
        
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{Homeliv h = new Homeliv();
        h.getF().show();
        });
        
        btnajout.addActionListener((e) -> {
            ServiceLivreur ser = new ServiceLivreur();
            Livreur t = new Livreur(nom.getText(), prenom.getText(),cin.getAsInt(0));
            ser.ajoutLivreur(t);
            

        });
        btnaff.addActionListener((e)->{
        AffichageLivreur a=new AffichageLivreur();
        a.getF().show();
        });
        
        
        btnmodifier.addActionListener((e)->{
        ModifierLivreur a=new ModifierLivreur();
        a.getF().show();
        });
        
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TextField getPrenom() {
        return prenom;
    }

    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }

    public TextField getCin() {
        return cin;
    }

    public void setCin(TextField cin) {
        this.cin = cin;
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

    public Button getBtnmodifier() {
        return btnmodifier;
    }

    public void setBtnmodifier(Button btnmodifier) {
        this.btnmodifier = btnmodifier;
    }

    
    
}
