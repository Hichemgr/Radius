/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Service.ServicePromotion;
import com.mycompany.Entite.Promotion;
import static jdk.nashorn.internal.runtime.GlobalFunctions.parseInt;

/**
 *
 * @author ASUS
 */
class Modifier {
    Form f;
    TextField id,nom,pourcentage;
    Button modifier;

    public Modifier() {
        f = new Form();
        String[] characters = { "fleur", "hibiscus", "marguerite", "palnteverte"
     /* cropped */
};


Picker nomproduit = new Picker();
nomproduit.setStrings(characters);
nomproduit.setSelectedString(characters[0]);
nomproduit.addActionListener(e -> ToastBar.showMessage("You picked " + nomproduit.getSelectedString(), FontImage.MATERIAL_INFO));

        id = new TextField("", "id..");
        nom = new TextField("", "nom..");
        pourcentage = new TextField("", "pourcentage..");
        
        modifier = new Button("Modifier");
        
        f.add(id);
        f.add(nom);
        f.add(pourcentage);
        f.add(nomproduit);
        
        f.add(modifier);
        
        ServicePromotion sp = new ServicePromotion();
        
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{HomeFormPromotion h = new HomeFormPromotion();
        h.getF().show();
        });
        
        ServicePromotion ser = new ServicePromotion();
        modifier.addActionListener((e) -> {
            int idd = id.getAsInt(0);
            Promotion p = new Promotion(idd,nom.getText(), pourcentage.getAsInt(0), nomproduit.getSelectedString());
            ser.modifirPromotion(p);
            
            

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
}
