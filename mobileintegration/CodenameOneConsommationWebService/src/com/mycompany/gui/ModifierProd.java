/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ProduitService;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.util.ArrayList;
/**
 *
 * @author raedm
 */
public class ModifierProd {
   Form f;
    TextField id,nom,prix,quantite,description,note,saison;
    Button modifier;
     private Resources theme;
    SpanLabel lb;
     String[] characters = { "Choisir Note","1", "2", "3", "4","5"
     /* cropped */
};
    

    public ModifierProd() {
        
        f = new Form("Modifier Produit",new BoxLayout(BoxLayout.Y_AXIS));
        id = new TextField("", "Id Produit..");
        nom = new TextField("", "Nom Produit..");
        prix = new TextField("", "Prix..");
        quantite = new TextField("", "Quantite..");
         description = new TextField("", "Description..");
          note = new TextField("", "Note..");
           saison = new TextField("", "Saison..");
        modifier = new Button("Modifier");
    
        f.add(id);
        f.add(nom);
        f.add(prix);
        f.add(quantite);
        f.add(description);
        f.add(saison);
        Picker note = new Picker();
note.setStrings(characters);
note.setSelectedString(characters[0]);
note.addActionListener(e -> ToastBar.showMessage("Votre Choix:" + note.getSelectedString(), FontImage.MATERIAL_INFO));
 f.add(note);
 
        
        f.add(modifier);
        ProduitService  sl = new ProduitService();
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{Home h=new Home();
            h.getF().show();
          });
        
       ProduitService serp = new ProduitService();
        modifier.addActionListener((e) -> {
            String rating=note.getSelectedString();
           int rate= Integer.valueOf(rating);
            int idd = id.getAsInt(0);
            Produit t = new Produit(idd,nom.getText(),prix.getAsInt(0) ,quantite.getAsInt(0),rate,description.getText(),saison.getText());
            serp.modifierProduit(t);
             ToastBar.showMessage("Produit Modifie" , FontImage.MATERIAL_INFO);
            
            

        });
         lb = new SpanLabel("");
        f.add(lb);
        ProduitService serviceProduit=new ProduitService();
          lb.setText(serviceProduit.getList2().toString());

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

    public TextField getPrix() {
        return prix;
    }

    public void setPrix(TextField prix) {
        this.prix = prix;
    }

    public TextField getQuantite() {
        return quantite;
    }

    public void setQuantite(TextField quantite) {
        this.quantite = quantite;
    }

    public TextField getDescription() {
        return description;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public TextField getNote() {
        return note;
    }

    public void setNote(TextField note) {
        this.note = note;
    }

    public TextField getSaison() {
        return saison;
    }

    public void setSaison(TextField saison) {
        this.saison = saison;
    }

   

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    } 
}
