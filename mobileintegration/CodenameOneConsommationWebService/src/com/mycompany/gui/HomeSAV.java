/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.Service.ServiceReclamation;
import com.mycompany.Entite.Reclamation;
import com.codename1.ui.util.Resources;


/**
 *
 * @author bhk
 */
public class HomeSAV {

    Form f;
    Button btnrec,btnvote;

    public HomeSAV(Resources theme) {
        f = new Form("home");
        btnrec=new Button("Reclamation");
        btnvote=new Button("Vote");
//         ImageViewer img=new ImageViewer(theme.getImage("20.jpg"));
 //    f.add(img);
        f.add(btnrec);
        f.add(btnvote);
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
        btnrec.addActionListener((e)->{
        ReclamationHome a=new ReclamationHome(theme);
        a.getF().show();
        });
        btnvote.addActionListener((e)->{
        VoteHome ab=new VoteHome(theme);
        ab.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }


}
