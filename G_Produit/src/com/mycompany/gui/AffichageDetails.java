/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.db.Database;
import com.codename1.io.FileSystemStorage;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;

/**
 *
 * @author raedm
 */
 public class AffichageDetails {

    Form f;
    Label lb_nom;
    Label lb_prix;
    Label lb_quantite;
    Label lb_saison;
    Label lb_note;
     Label lb_description;
    //Image img;
    Image scaledPhotoImage;
    Button btnDemande;
     private ImageViewer imgv;
    private Image img;
    private EncodedImage enc;
    private Slider slider ;
    Database db;
    SpanLabel lb;
    CheckBox box;
   

    public AffichageDetails(Produit p,Resources theme) {
       
         
          f = new Form();
        setTitle(p.getNom_prod());
         Prod a =new Prod(theme);
        //getToolbar().addCommandToLeftBar("back", null, e -> a.show());
        f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Prod h=new Prod(theme);
          h.getF().show();
          });
        
        //getToolbar().addCommandToRightBar("Soumettre", null, e -> a.show());
        
          //s =new Panier(theme ,p);
        //getToolbar().addCommandToOverflowMenu("Panier", null, e->s.show());
 
        f.setLayout(BoxLayout.y());
                        enc=EncodedImage.createFromImage(theme.getImage("load.png"), false);
                        img=URLImage.createToStorage(enc,"http://localhost/Mobile/"+p.getImagep(), "http://localhost/Mobile/"+p.getImagep());
                        imgv=new ImageViewer(img);
                        
                       f.add(img);
                      
                         Label ldesc= new Label("Description: "+p.getDescription_prod());
                         Label lprix= new Label("Prix: "+p.getPrix_prod());
                           Label lquan= new Label("Quantite: "+p.getQuantite_prod());
                            Label lsais= new Label("Saison: "+p.getSaison());
                             Label lnote= new Label("Note: "+p.getRating_prod());
//                       ldesc.setAlignment();
//                       lprix.setAlignment(CENTER);
//                       lquan.setAlignment(CENTER);
//                       lsais.setAlignment(CENTER);
//                       lnote.setAlignment(CENTER);
                        f.add(lprix);
                         f.add(lquan);
                        f. add(ldesc);
                        f. add(lsais);
                         f.add(lnote);
                       f.show();
        
        
    }  
    public Form getF() {
        return f;
    }
}
