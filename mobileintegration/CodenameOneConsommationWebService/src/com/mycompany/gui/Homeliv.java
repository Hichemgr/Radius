/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.mycompany.Entite.Livraison;
import com.mycompany.Service.ServiceLivraison;

/**
 *
 * @author seifeddinebenfraj
 */
public class Homeliv {
    Form f;
    Button Livraisons,Livreurs;
    
    public Homeliv()
    {
        f = new Form("Home");
        Livraisons = new Button("Livraisons");
        Livreurs = new Button("Livreurs");
        
        f.add(Livraisons);
        f.add(Livreurs);
        
        Livraisons.addActionListener((e) -> {
            HomeFormlib hf = new HomeFormlib();
            hf.getF().show();
        });
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
        Livreurs.addActionListener((e) -> {
            HomeForm1 hf = new HomeForm1();
            hf.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Button getLivraisons() {
        return Livraisons;
    }

    public void setLivraisons(Button Livraisons) {
        this.Livraisons = Livraisons;
    }

    public Button getLivreurs() {
        return Livreurs;
    }

    public void setLivreurs(Button Livreurs) {
        this.Livreurs = Livreurs;
    }
}
