/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Promotion;
import com.mycompany.Service.ServicePromotion;

import java.util.ArrayList;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
       
  
    public Affichage() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServicePromotion serviceTask=new ServicePromotion();
       // lb.setText(serviceTask.getList2().toString());
          ArrayList<Promotion> listass = new ArrayList<>();
          listass=serviceTask.getList2();
          for(Promotion c:listass)
        {
            addItem(c);
        }
          //f.show();
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }
    public void addItem(Promotion c)
    {
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
       // ImageViewer img=new ImageViewer(theme.getImage("icon.png"));
        Button b1=new Button("Supprimer");
        Button b2=new Button("Modifier");
        Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label l2=new Label("L'id est: "+c.getIdpromotion());
        Label l1=new Label("Le Pourcentage est: "+c.getPourcentage());
        Label l3=new Label("Nom Produit: "+c.getNomproduit());

       
        b1.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            //   Dialog.show("Information Client","Le nom est : "+c.getNom()+"\n"+"le numero est: "+c.getNum(),"YES","NO");//To change body of generated methods, choose Tools | Templates.
           ServicePromotion serviceass=new ServicePromotion();
           serviceass.supprimerCommentaire(c.getIdpromotion());
           HomeForm h=new HomeForm();
          h.getF().show();
          // f.removeAll();
           //Affichage();
            }
        }); 
        b2.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            //   Dialog.show("Information Client","Le nom est : "+c.getNom()+"\n"+"le numero est: "+c.getNum(),"YES","NO");//To change body of generated methods, choose Tools | Templates.
           ServicePromotion serviceass=new ServicePromotion();
           Form f5=new Form();
           TextField modtype=new TextField(c.getPourcentage());
           Button bmod=new Button("Modifier");
           f5.add(modtype);
           f5.add(bmod);
           f5.show();
           bmod.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                   //serviceass.modifirPromotion(c.getIdpromotion(),modtype.getText());
                    HomeForm h=new HomeForm();
          h.getF().show();
               }
           });
           
           
          // f.removeAll();
           //Affichage();
            }
        }); 
        
        
        //c2.add(l);
        //c2.add(tel);
        c2.add(l1);
        c2.add(l2);
        c2.add(l3) ; 
       // c1.add(img);
        
        c1.add(c2);
        c1.add(b1);
        c1.add(b2);
    //    c1.setLeadComponent(l1);
        f.add(c1);
        f.refreshTheme();
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
