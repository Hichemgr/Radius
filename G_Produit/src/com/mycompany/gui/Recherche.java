/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.Service.ProduitService;

/**
 *
 * @author raedm
 */
public class Recherche {
    Form f;
    SpanLabel lb;
     TextField tid;
public Recherche(){
   f= new Form("Resultat");
        lb = new SpanLabel("");
        
        f.add(lb);
         ToastBar.showMessage("Produit Trouve" , FontImage.MATERIAL_INFO);
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{Home h=new Home();
          h.getF().show();
          });
    
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

