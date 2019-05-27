/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;




import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
//import com.mycompany.Entite.Assisstance;
import com.mycompany.Entite.Assisstant;
import com.mycompany.Entite.Conseil;
import com.mycompany.Service.ServiceAssisstance;
import com.mycompany.Service.ServiceAssisstant;
import com.mycompany.Service.ServiceConseil;
import java.util.Date;
public class HomeconseilForm {
    


/**
 *
 * @author ASUS
 */

    



    Form f;
    TextField tnom,tprenom,tcin;
    TextField tetat,ttype,tcontenu;
    Button btnajout,btnaff;

    public HomeconseilForm() {
        f = new Form("home");
        ttype = new TextField("","Type");
        tcontenu = new TextField("","Contenu");
        
        btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
        
        //Label l1=new Label("Date Assisstance: ");
        //f.add(l1);
       // Picker dateassiss=new Picker();
        //f.add(dateassiss);
        
        
       // f.add(tnom);
       
        f.add(ttype);
        f.add(tcontenu);
        f.add(btnajout);
        f.add(btnaff);
        Toolbar to=f.getToolbar();
         
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstance",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm ha=new HomeForm();
            ha.getF().show();
            
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Assisstant",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeassisstantForm ha=new HomeassisstantForm();
            ha.getF().show();
            
            }
        });
        to.addMaterialCommandToLeftSideMenu("Gestion Conseil",FontImage.MATERIAL_ACCOUNT_BOX, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 HomeconseilForm ha=new HomeconseilForm();
            ha.getF().show();
            
            }
        });
        
        btnajout.addActionListener((e) -> {
            ServiceConseil ser = new ServiceConseil();
           
            Conseil t = new Conseil(ttype.getText(),tcontenu.getText());
            ser.ajoutTask(t);
            // hethi kenet f constructeur tnom.getText()

        });
        btnaff.addActionListener((e)->{
        Affichageconseil a=new Affichageconseil();
        a.getF().show();
        });
     
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
