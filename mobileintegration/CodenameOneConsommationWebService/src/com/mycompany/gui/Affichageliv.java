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
import com.mycompany.Service.ServiceLivraison;

/**
 *
 * @author bhk
 */
public class Affichageliv {

    Form f;
    SpanLabel lb;
    TextField idtxt;
    Button delete;
  
    public Affichageliv() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        idtxt = new TextField("","id..");
        delete = new Button("Supprimer");
        
        f.add(idtxt);
        f.add(delete);
        ServiceLivraison sl=new ServiceLivraison();
        lb.setText(sl.getList2().toString());
        
          f.getToolbar().addCommandToLeftBar("<-back", null, (ev)->{HomeFormlib h=new HomeFormlib();
          h.getF().show();
          });
          
          delete.addActionListener((e) -> {
            ServiceLivraison ser = new ServiceLivraison();
            int idd = idtxt.getAsInt(0);
            sl.supprimerLivraison(idd);
            lb.setText(sl.getList2().toString());
            

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
    
    public TextField getIdtxt() {
        return idtxt;
    }

    public void setIdtxt(TextField idtxt) {
        this.idtxt = idtxt;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

}
