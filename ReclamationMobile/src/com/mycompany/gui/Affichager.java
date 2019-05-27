/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Service.ServiceReclamation;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author bhk
 */
public class Affichager {

    Form f;
    Button Oui;
    Button Non;
    SpanLabel lb;
    Button btnsupp;
    Button btnmod;
    TextField tid;
  
    public Affichager(Resources theme) {
        
        f = new Form();
        Oui=new Button("Traite");
        Non=new Button("Non Traite");
        lb = new SpanLabel("");
        tid = new TextField("","tid");
        btnsupp=new Button("supprimer");
        btnmod=new Button("modifier");
        System.out.println("Reclamation"); 
        ServiceReclamation serviceTask=new ServiceReclamation();
       // lb.setText(serviceTask.getList2().toString());
          ArrayList<Reclamation> listass = new ArrayList<>();
          listass=serviceTask.getList2();
          for(Reclamation c:listass)
        {
            addItem(c,theme);
        }
       f.add(Oui);
        f.add(Non);
        f.add(lb);
        
                         Oui.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // lb.setText(serviceTask.getList2().toString());
                ArrayList<Reclamation> listass = new ArrayList<>();
                
                // lb.setText(serviceTask.getList2().toString());
                
                listass=serviceTask.getReclOui();
                for(Reclamation c:listass)
                {
                    addItem(c,theme);
                }
                f.getToolbar().addCommandToRightBar("back", null, (ev)->{ReclamationHome h=new ReclamationHome(theme);
                h.getF().show();
                });
            }
        });
              Non.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // lb.setText(serviceTask.getList2().toString());
                ArrayList<Reclamation> listass = new ArrayList<>();
                
                // lb.setText(serviceTask.getList2().toString());
                
                listass=serviceTask.getRecNon();
                for(Reclamation c:listass)
                {
                    addItem(c,theme);
                }
                f.getToolbar().addCommandToRightBar("back", null, (ev)->{ReclamationHome h=new ReclamationHome(theme);
                h.getF().show();
                });
            }
        });
      //  f.add(tid);
       // f.add(btnsupp);
        //f.add(btnmod);
         
       
        
                
                         
             /*   btnmod.addActionListener((e) -> {
            ServiceReclamation ser = new ServiceReclamation();
          //  Reclamation t1 = new Reclamation(tid.getAsInt(0));
            int idd= tid.getAsInt(0);
        ser.ModifierReclamation(idd);
                lb.setText(serviceReclamation.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm(theme);
          h.getF().show();
          });
        });*/
    }
    public void addItem(Reclamation c, Resources theme)
    {
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
       // ImageViewer img=new ImageViewer(theme.getImage("icon.png"));
        Button b1=new Button("Supprimer");
     //   Button b2=new Button("Modifier");
      //  Button b3=new Button("traite");
        //Button b4=new Button("non traite");
        Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
       Label l3=new Label("Le produit: "+c.getNomproduit());
       Label l4=new Label("sujet "+c.getSujet());
       Label l5=new Label("contenu: "+c.getContenu());
      //  Label l1=new Label("Le type est: "+c.getType());

       
        b1.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            //   Dialog.show("Information Client","Le nom est : "+c.getNom()+"\n"+"le numero est: "+c.getNum(),"YES","NO");//To change body of generated methods, choose Tools | Templates.
           ServiceReclamation serviceass=new ServiceReclamation();
           serviceass.supprimerReclamation(c.getIdreclamation());
           Affichager h=new Affichager(theme);
          h.getF().show();
          // f.removeAll();
           //Affichage();
            }

           
        }); 
     
        
         //c2.add(l1);
        c2.add(l3);
         c2.add(l4);
          c2.add(l5);
       // c1.add(img);
        
        c1.add(c2);
        c1.add(b1);
      //  c1.add(b2);
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
