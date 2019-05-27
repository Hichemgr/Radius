/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
//import com.mycompany.Entite.ligneproduit;
import com.mycompany.Entite.panier;
import com.mycompany.Service.ServiceLigneproduit;
import com.teknikindustries.bulksms.SMS;
import java.io.IOException;
//import com.mycompany.Service.ServicePanier;
import java.util.ArrayList;
//import com.mycompany.Service.ServiceTask;

/**
 *
 * @author bhk
 */
public class AffichageLigne {

    Form f;
    SpanLabel lb;
    SpanLabel lb2;
    
    
    
    
      public void AddItem(Produit c){
        Button modif=new Button("modifier");
         Resources theme;
          theme = UIManager.initFirstTheme("/theme");
           Button supp=new Button("supprimer");
            ImageViewer img=new ImageViewer(theme.getImage(c.getNom_prod()+".png"));
              
        Container c1=new Container(new BoxLayout(BoxLayout.X_AXIS));
      //  ImageViewer img=new ImageViewer(theme.getImage(c.getImg()));
         Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label l=new Label("Nom produit :"+String.valueOf(c.getNom_prod()));
          //Label l=new Label("Nom produit :"+String.valueOf(c.getNomproduit()));
          Label prix=new Label("Le prix :"+String.valueOf(c.getPrix_prod()));
         
            Label tel=new Label("La quantite est :"+String.valueOf(c.getQuantite_prod()));
            
              Label totale=new Label("Le Totale est :"+String.valueOf(c.getQuantite_prod()*c.getPrix_prod())+"dt");
            
            
            
            supp.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
              //  Form f=new Form();
                 ServiceLigneproduit ser = new ServiceLigneproduit();
            
           ser.supprimerLigne(c.getRef_prod()); ////supppppppppppprriiiiiiiiiiiiimer
            f.removeAll();
            HomeForm h=new HomeForm();
          h.getF().show();
           
                
                
            }
        });
            modif.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              //  Dialog.show(String.valueOf(c.getIdpanier()),String.valueOf(c.getEtat()),"yes","no");
                Form fod=new Form();
                 ServiceLigneproduit ser = new ServiceLigneproduit();
                  //TextField ip=new TextField(c.getIdpanier());
                TextField v=new TextField("nouvelle quantite");
                Button bo=new Button("Valider");
                fod.add(bo);
               
                //fod.add(ip);
                 fod.add(v);
                fod.show();
                bo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       ser.ModifierLigne(c.getRef_prod(),Integer.valueOf(v.getText()));
                        HomeForm h=new HomeForm();
                          h.getF().show();
                    }
                });
           // ser.supprimerpanier(c.getIdpanier()); 
//            f.removeAll();
//            HomeForm h=new HomeForm();
//          h.getF().show();
           
                
                
            }
        });
            
            
            
            c2.add(l);
            c2.add(tel);
            c2.add(prix);
            c2.add(totale);
            //c1.add(img);
            c2.add(img);
             c1.add(c2);
            c2.add(modif);
           // c1.add(img);
            c2.add(supp);
           
            f.add(c1);
            f.refreshTheme();
         
    
    
    }
 
  
    public AffichageLigne() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceLigneproduit serviceTask=new ServiceLigneproduit();
      // lb.setText(serviceTask.getList2().toString());
         ArrayList<Produit> ligne = new ArrayList<>();
         ligne=serviceTask.getListLigne();
          
          for(Produit c : ligne)
        {
            AddItem(c);
        }
          float to=serviceTask.getTotal(2);
        Label t=new Label("Totale de la commande :"+to+"dt");
        Button valc =new Button ("valider votre commande");
        
          valc.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       serviceTask.valider(2);
                        Homeliv h=new Homeliv();
                          h.getF().show();
                    }
                });
          
           Button mail =new Button ("Envoyer un e-mail");
          mail.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         Message m = new Message("une nouvelle commande a été effectue avec succeés\n"+"totale de la commande est :"+to+"dt");
                    Display.getInstance().sendMessage(new String[]{"hichem.griri@esprit.tn"}, "Commande", m);
                    }
                });
          
           Button sms =new Button ("Envoyer un SMS");
          sms.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        

        SMS smsText = new SMS();
        smsText.SendSMS("mobile2019","mobile2019", "\n votre commande a été effectue avec sucees avec un montant de :"+to+" dt"  , "+21653625844", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                    }
                });
          
          
          Button pay=new Button ("payer avec carte");
          pay.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        PaymentForm pf=new PaymentForm();
                  pf.show();
                        

       
                    }
                });
        
               ShareButton sb = new ShareButton();
               f.add(sb);
  //  sb.setIcon(Image.createImage("/fb.png"));
    sb.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
               //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                  Dialog.show("Bonjour", "Partagé dans votre profil", "Ok","Cancel");

             
           FacebookShare fb = new FacebookShare("EAACEdEose0cBADaFLZCAbsGVYR1lBgQu8OpZCINLwoZCi4PADr6s4YEP6oQOqw2Uswb126nohapF5M62jyOiIoAMUBT7U4mW2Vi5NqjGjPBVyHhMsCEgjBkSUmPHokShjZBZAbL1DX3KwJFpqmzzgRm1WM8lehZCc0VpnGHNrSeUZBRpuhSTSjCHklTsLDc5MDu1XtncM6VHgZDZD");
                 try {
                     fb.share("Russia 2018 Project .. Be ready .. !");
                 } catch (IOException ex) {
                 }
           
           
             
             }
         });
        f.add(t);
        f.add(valc);  
         f.add(mail); 
         f.add(pay);
        
         f.add(sms);
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
