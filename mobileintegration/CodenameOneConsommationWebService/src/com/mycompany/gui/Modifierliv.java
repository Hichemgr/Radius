/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Entite.Livraison;
import com.mycompany.Service.ServiceLivraison;
/**
 *
 * @author seifeddinebenfraj
 */
class Modifierliv {
    Form f;
    TextField id,montant,etat,adresse;
    Button modifier;

    public Modifierliv() {
        f = new Form();
        id = new TextField("", "id..");
        montant = new TextField("", "montant..");
        etat = new TextField("", "etat..");
        adresse = new TextField("", "adresse..");
        modifier = new Button("Modifier");
        
        f.add(id);
        f.add(adresse);
        f.add(montant);
        f.add(etat);
        
        f.add(modifier);
        
        ServiceLivraison sl = new ServiceLivraison();
        
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{HomeFormlib h = new HomeFormlib();
        h.getF().show();
        });
        
        ServiceLivraison ser = new ServiceLivraison();
        modifier.addActionListener((e) -> {
            int idd = id.getAsInt(0);
            Livraison t = new Livraison(idd,adresse.getText(), montant.getAsInt(0), etat.getAsInt(0));
            ser.modifierLivraison(t);
            Message m = new Message("Livraison modifiée");
        Display.getInstance().sendMessage(new String[]{"seifeddine.benfraj@esprit.tn"}, "Livraison", m);
            
            

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

    public TextField getMontant() {
        return montant;
    }

    public void setMontant(TextField montant) {
        this.montant = montant;
    }

    public TextField getEtat() {
        return etat;
    }

    public void setEtat(TextField etat) {
        this.etat = etat;
    }

    public TextField getAdresse() {
        return adresse;
    }

    public void setAdresse(TextField adresse) {
        this.adresse = adresse;
    }

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }
    
    
    
    
}
