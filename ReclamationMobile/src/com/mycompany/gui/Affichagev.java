/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Entite.Vote;
import com.mycompany.Service.ServiceReclamation;
import com.mycompany.Service.ServiceVote;
import java.util.ArrayList;

/**
 *
 * @author pc hp
 */
public class Affichagev {
  Form f;
    SpanLabel lb;
    Label lb1;
    Label count;
    Button mod;
    Label l;
  
    public Affichagev(Resources theme) {
        
        f = new Form();
        lb = new SpanLabel("");
        l=new Label("somme des votes");
        count =new Label("nombre de vote");
        mod=new Button("modifier");
        f.setTitle("Votes");
        //lb1 =new Label("");
        f.add(lb);
       // f.add(l);
       // f.add(count);
     //   f.add(mod);
        //f.add(lb1);
        ServiceVote serviceTask=new ServiceVote();

       // lb.setText(serviceTask.getList2().toString());
          ArrayList<Vote> listass = new ArrayList<>();
          listass=serviceTask.getList2();
          for(Vote c:listass)
        {
            addItem(c,theme);
        }
      
      //  lb.setText(serviceVote.getList2().toString());
        //String a=serviceVote.CountVote();
        // lb1.setText(a);       
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{VoteHome h=new VoteHome(theme);
          h.getF().show();
          });
          
      /*    mod.addActionListener((e)->{
        Modifierv a=new Modifierv(theme);
        a.getF().show();
        });*/
    }
     public void addItem(Vote c, Resources theme)
    {
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
       // ImageViewer img=new ImageViewer(theme.getImage("icon.png"));
       // Button b1=new Button("Supprimer");
       Button b2=new Button("Modifier");
   //     Button b3=new Button("traite");
     //   Button b4=new Button("non traite");
        Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
       Label l3=new Label("Le produit: "+c.getNomproduit());
       Label l4=new Label("note "+c.getNote());
       Label l5=new Label("commentaire: "+c.getCommentaire());
      //  Label l1=new Label("Le type est: "+c.getType());

       
       b2.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
         Modifierv h=new Modifierv(theme);
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
     //   c1.add(b1);
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
