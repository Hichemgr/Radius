/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.Entite.Vote;
import com.mycompany.Service.ServiceVote;
import com.codename1.ui.RadioButton;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc hp
 */
public class VoteHome {
        Form f;
    Label tnomproduit;
    Label tnote;
    TextField tcommentaire;
    Label notee;
        RadioButton bt1;
    RadioButton bt2;
    RadioButton bt3;
    RadioButton bt4;
    RadioButton bt5;
    ButtonGroup bg ;
    Button btnajout,btnaff;
    TextField tid;
     Picker cp ;

    public VoteHome(Resources theme) {
        f = new Form("Vote");
           ServiceVote p=new ServiceVote();
       float s= p.CountVote();
       cp =new Picker();
        tnomproduit =new Label("Nom du produit");
        tnote = new Label(String.valueOf(s),"Somme des votes ");
        tcommentaire = new TextField("","tcommentaire");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        bt1=new RadioButton("1");
        bt2=new RadioButton("2");
        bt3=new RadioButton("3");
        bt4=new RadioButton("4");
        bt5=new RadioButton("5");
        notee=new Label("Somme des votes :");
        bg=new ButtonGroup(bt1, bt2, bt3,bt4,bt5);
        bt3.setSelected(true);
         
        f.add(notee);
        f.add(tnote);
        ImageViewer img=new ImageViewer(theme.getImage("18.jpg"));
     f.add(img);
        f.add(tnomproduit);
        f.add(cp);
       // f.add(tnomproduit);
        
         String[] characters = { "fleur", "hibiscus", "marguerite", "palnteverte"
     /* cropped */
};



cp.setStrings(characters);
cp.setSelectedString(characters[0]);
cp.addActionListener(e -> ToastBar.showMessage("You picked " + cp.getSelectedString(), FontImage.MATERIAL_INFO));
        f.add(tcommentaire);
        f.add(bt1);
        f.add(bt2);
        f.add(bt3);
        f.add(bt4);
        f.add(bt5);
       

        //f.add(tcommentaire);
        f.add(btnajout);
        
        f.add(btnaff);
        bg.addActionListener(e -> ToastBar.showMessage("You selected " + (bg.getSelectedIndex() + 1), FontImage.MATERIAL_INFO));

  f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeSAV h=new HomeSAV(theme);
          h.getF().show();
          });

        btnajout.addActionListener((e) -> {
            ServiceVote ser = new ServiceVote();
            //int note=tnote.getAsInt(0);
            int note=0;
            if(bt1.isSelected())
            {note=1;}
            if(bt2.isSelected())
            {note=2;}
            if(bt3.isSelected())
            {note=3;}
            if(bt4.isSelected())
            {note=4;}
            if(bt5.isSelected())
            {note=5;}
            
            Vote t = new Vote(cp.getSelectedString(),note,tcommentaire.getText());
            
            ser.ajoutVote(t);
            Dialog.show("Valider", "votre Vote a ete ajouter ","ok","cancel");

        });
     
         
        btnaff.addActionListener((e)->{
        Affichagev a=new Affichagev(theme);
        a.getF().show();
        });
    }

    public RadioButton getBt1() {
        return bt1;
    }

    public void setBt1(RadioButton bt1) {
        this.bt1 = bt1;
    }

    public RadioButton getBt2() {
        return bt2;
    }

    public void setBt2(RadioButton bt2) {
        this.bt2 = bt2;
    }

    public RadioButton getBt3() {
        return bt3;
    }

    public void setBt3(RadioButton bt3) {
        this.bt3 = bt3;
    }

    public RadioButton getBt4() {
        return bt4;
    }

    public void setBt4(RadioButton bt4) {
        this.bt4 = bt4;
    }

    public RadioButton getBt5() {
        return bt5;
    }

    public void setBt5(RadioButton bt5) {
        this.bt5 = bt5;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void setBg(ButtonGroup bg) {
        this.bg = bg;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getTnomproduit() {
        return tnomproduit;
    }

    public void setTnomproduit(Label tnomproduit) {
        this.tnomproduit = tnomproduit;
    }

    public Picker getCp() {
        return cp;
    }

    public void setCp(Picker cp) {
        this.cp = cp;
    }

  

    public Label getTnote() {
        return tnote;
    }

    public void setTnote(Label tnote) {
        this.tnote = tnote;
    }

    public Label getNotee() {
        return notee;
    }

    public void setNotee(Label notee) {
        this.notee = notee;
    }

    

    public TextField getTcommentaire() {
        return tcommentaire;
    }

    public void setTcommentaire(TextField tcommentaire) {
        this.tcommentaire = tcommentaire;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }

    public TextField getTid() {
        return tid;
    }

    public void setTid(TextField tid) {
        this.tid = tid;
    }

   

}
