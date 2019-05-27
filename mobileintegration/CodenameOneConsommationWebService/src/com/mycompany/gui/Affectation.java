/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Livraison;
import com.mycompany.Service.ServiceLivraison;
import com.mycompany.Service.ServiceLivreur;

/**
 *
 * @author seifeddinebenfraj
 */
public class Affectation {
    Form f;
    SpanLabel lb,lb1,livv,liv;
    TextField idlivraison,idlivreur;
    Button Affecter,Terminer;
    
    public Affectation() {
        f = new Form("Affectation");
        lb = new SpanLabel();
        lb1 = new SpanLabel();
        idlivraison = new TextField("", "ID livraison..");
        idlivreur = new TextField("","ID livreur..");
        livv = new SpanLabel();
        liv = new SpanLabel();
        Affecter = new Button("Affecter");
        Terminer = new Button("Terminer");
        
        f.add(livv);
        f.add(lb);
        f.add(liv);
        f.add(lb1);
        f.add(idlivraison);
        f.add(idlivreur);
        f.add(Affecter);
        f.add(Terminer);
        
        ServiceLivraison sl=new ServiceLivraison();
        ServiceLivreur sl1 = new ServiceLivreur();
        livv.setText("---------LIVRAISON---------");
        lb.setText(sl.getList3().toString());
        liv.setText("---------LIVREUR---------");
        lb1.setText(sl1.getList3().toString());
        
        f.getToolbar().addCommandToLeftBar("<-back", null, (ev)->{HomeFormlib h=new HomeFormlib();
          h.getF().show();
          });
        
        Affecter.addActionListener((e) -> {
            int idd = idlivraison.getAsInt(0);
            String nom = idlivreur.getText();
            sl.AffecterLivreurLivraisons(idd,nom);
            
            livv.setText("---------LIVRAISON---------");
        lb.setText(sl.getList3().toString());
        liv.setText("---------LIVREUR---------");
        lb1.setText(sl1.getList3().toString());

        });
        
        Terminer.addActionListener((e) -> {
            int idd = idlivraison.getAsInt(0);
            String nom = idlivreur.getText();
            sl.TerminerLivraison(idd,nom);
            
            livv.setText("---------LIVRAISON---------");
        lb.setText(sl.getList3().toString());
        liv.setText("---------LIVREUR---------");
        lb1.setText(sl1.getList3().toString());

        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public SpanLabel getLb() {
        return lb;
    }

    public void setLb(SpanLabel lb) {
        this.lb = lb;
    }

    public SpanLabel getLb1() {
        return lb1;
    }

    public void setLb1(SpanLabel lb1) {
        this.lb1 = lb1;
    }

    public TextField getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(TextField idlivraison) {
        this.idlivraison = idlivraison;
    }

    public TextField getIdlivreur() {
        return idlivreur;
    }

    public void setIdlivreur(TextField idlivreur) {
        this.idlivreur = idlivreur;
    }

    public Button getAffecter() {
        return Affecter;
    }

    public void setAffecter(Button Affecter) {
        this.Affecter = Affecter;
    }

}

