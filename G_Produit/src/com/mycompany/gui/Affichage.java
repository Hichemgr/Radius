/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Service.ProduitService;
import java.io.IOException;

/**
 *
 * @author raedm
 */
public class Affichage {
   Form f;
    SpanLabel lb;
 Button btnajout;
   
    public Affichage() {
     f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ProduitService serviceProduit=new ProduitService();
        lb.setText(serviceProduit.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("Back", null, (ev)->{
              Home h=new Home();
              h.getF().show();
          });
                        ShareButton sb = new ShareButton();
                        f.add(sb);
         try {
             sb.setIcon(Image.createImage("/fb.png"));
         } catch (IOException ex) {
           //  Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
         }
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
 
                  }

  /**
     *
     * @return f
     */
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }  
}
