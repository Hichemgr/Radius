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
import com.mycompany.Entite.Assisstance;
import com.mycompany.Entite.Assisstant;
import com.mycompany.Service.ServiceAssisstance;
import com.mycompany.Service.ServiceAssisstant;
import com.mycompany.Service.ServiceTask;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Affichageassisstant {
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bhk
 */

    Form f;
    SpanLabel lb;
       
  
    public Affichageassisstant() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceAssisstant serviceTask=new ServiceAssisstant();
       // lb.setText(serviceTask.getList2().toString());
          ArrayList<Assisstant> listass = new ArrayList<>();
          listass=serviceTask.getList2();
          for(Assisstant c:listass)
        {
            addItem(c);
        }
          //f.show();
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeassisstantForm h=new HomeassisstantForm();
          h.getF().show();
          });
    }
    public void addItem(Assisstant c)
    {
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
       // ImageViewer img=new ImageViewer(theme.getImage("icon.png"));
        Button b1=new Button("Supprimer");
        Button b2=new Button("Modifier");
        Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label l1=new Label("Le nom: "+c.getNom());
        
        Label l2=new Label("La prenom: "+c.getPrenom());
        Label l3=new Label("l'etat : "+c.getEtat());
  
        b1.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            //   Dialog.show("Information Client","Le nom est : "+c.getNom()+"\n"+"le numero est: "+c.getNum(),"YES","NO");//To change body of generated methods, choose Tools | Templates.
           ServiceAssisstant serviceass=new ServiceAssisstant();
           serviceass.supprimerTask(c.getId_assisstant());
           HomeassisstantForm h=new HomeassisstantForm();
          h.getF().show();
          // f.removeAll();
           //Affichage();
            }
        }); 
        b2.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            //   Dialog.show("Information Client","Le nom est : "+c.getNom()+"\n"+"le numero est: "+c.getNum(),"YES","NO");//To change body of generated methods, choose Tools | Templates.
           ServiceAssisstant serviceass=new ServiceAssisstant();
           Form f5=new Form();
           TextField nom=new TextField(c.getNom());
           TextField prenom=new TextField(c.getPrenom());
           Button bmod=new Button("Modifier");
           f5.add(nom);
           f5.add(prenom);
           f5.add(bmod);
           f5.show();
           bmod.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent evt) {
                   serviceass.modifTask(c.getId_assisstant(),nom.getText(),prenom.getText());
                    HomeassisstantForm h=new HomeassisstantForm();
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
        c2.add(l3);
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
