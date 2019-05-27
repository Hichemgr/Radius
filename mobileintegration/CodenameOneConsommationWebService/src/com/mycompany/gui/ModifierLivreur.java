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
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Entite.Livraison;
import com.mycompany.Entite.Livreur;
import com.mycompany.Service.ServiceLivraison;
import com.mycompany.Service.ServiceLivreur;
/**
 *
 * @author seifeddinebenfraj
 */
class ModifierLivreur {
    Form f;
    TextField id,nom,prenom,cin;
    Button modifier;

    public ModifierLivreur() {
        f = new Form();
        id = new TextField("", "id..");
        nom = new TextField("", "nom..");
        prenom = new TextField("", "prenom..");
        cin = new TextField("", "cin..");
        modifier = new Button("Modifier");
        
        f.add(id);
        f.add(nom);
        f.add(prenom);
        f.add(cin);
        
        f.add(modifier);
        
        ServiceLivraison sl = new ServiceLivraison();
        
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{HomeForm1 h = new HomeForm1();
        h.getF().show();
        });
        
        ServiceLivreur ser = new ServiceLivreur();
        modifier.addActionListener((e) -> {
            int idd = id.getAsInt(0);
            Livreur t = new Livreur(idd,nom.getText(), prenom.getText(), cin.getAsInt(0));
            ser.modifierLivreur(t);
            
            

        });
        
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getId() {
        return id;
    }

    public void setId(TextField id) {
        this.id = id;
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

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

 
    
}
