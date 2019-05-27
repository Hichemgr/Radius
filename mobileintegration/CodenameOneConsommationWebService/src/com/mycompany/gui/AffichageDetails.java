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
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceLigneproduit;
import java.io.IOException;


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
   

    public AffichageDetails(Produit p,Resources theme) throws IOException {
       
         
          f = new Form();
        setTitle(p.getNom_prod());
         Prod a =new Prod(theme);
        //getToolbar().addCommandToLeftBar("back", null, e -> a.show());
        f.getToolbar().addCommandToRightBar("Back", null, (ev)->{
              // Logger.getLogger(AffichageDetails.class.getName()).log(Level.SEVERE, null, ex);
            Prod h=new Prod(theme);
            h.getF().show();
        });
        
        //getToolbar().addCommandToRightBar("Soumettre", null, e -> a.show());
        
          //s =new Panier(theme ,p);
        //getToolbar().addCommandToOverflowMenu("Panier", null, e->s.show());
 
        f.setLayout(BoxLayout.y());
//                        enc=EncodedImage.createFromImage(theme.getImage("load.png"), false);
         try {
            enc = EncodedImage.create("/load.png");
        } catch (IOException ex) {
        }
                        img=URLImage.createToStorage(enc,"http://localhost/mobile/"+p.getImagep(), "http://localhost/mobile/"+p.getImagep());
                        imgv=new ImageViewer(img);
                        
                       f.add(img);
                        Button ajout=new Button("ajouter au panier");
                       f.add(ajout);
                      
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
                            
                    ajout.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
                Form fod=new Form();
                 ServiceLigneproduit ser = new ServiceLigneproduit();
                  //TextField ip=new TextField(c.getIdpanier());
                TextField v=new TextField("quantite");
                Button bo=new Button("Valider");
                fod.add(bo);
               
                //fod.add(ip);
                 fod.add(v);
                 
                fod.show();
                bo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ser.ajoutLigne(p.getRef_prod(),Integer.valueOf(v.getText()));
                      /*  HomeForm h=new HomeForm();
                          h.getF().show();*/
                        AffichageLigne b=new AffichageLigne();
                        b.getF().show();
                    }
                });
               
                
            }
        });         
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
