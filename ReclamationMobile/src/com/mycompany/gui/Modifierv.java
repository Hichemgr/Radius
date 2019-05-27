/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Vote;
import com.mycompany.Service.ServiceVote;

/**
 *
 * @author pc hp
 */
class Modifierv {
    
    Form f;
    TextField id,nomproduit,note,commentaire;
    Button modifier;
    RadioButton bt1;
    RadioButton bt2;
    RadioButton bt3;
    RadioButton bt4;
    RadioButton bt5;
    ButtonGroup bg ;

    public Modifierv(Resources theme) {
        f = new Form();
        id = new TextField("", "id..");
        nomproduit = new TextField("", "nomproduit..");
        commentaire = new TextField("", "commentaire..");
        modifier = new Button("Modifier");
        bt1=new RadioButton("1");
        bt2=new RadioButton("2");
        bt3=new RadioButton("3");
        bt4=new RadioButton("4");
        bt5=new RadioButton("5");
        bg=new ButtonGroup(bt1, bt2, bt3,bt4,bt5);
        
        f.add(id);
        f.add(nomproduit);
       // f.add(notee);
        f.add(bt1);
        f.add(bt2);
        f.add(bt3);
        f.add(bt4);
        f.add(bt5);
        f.add(commentaire);
        
        f.add(modifier);
        f.show();
        
        ServiceVote sl = new ServiceVote();
        
        f.getToolbar().addCommandToLeftBar("<-Back", null, (ev)->{HomeSAV h = new HomeSAV(theme);
        h.getF().show();
        });
        
        ServiceVote ser = new ServiceVote();
        modifier.addActionListener((e) -> {
            int idd = id.getAsInt(0);
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
            Vote t = new Vote(idd,nomproduit.getText(),note, commentaire.getText());
            ser.ModifierVote(t);     
            
         Dialog.show("Valider", "votre Vote a ete modifier ","ok","cancel");
        });
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeSAV h=new HomeSAV(theme);
          h.getF().show();
          });
        
    }

    public TextField getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(TextField nomproduit) {
        this.nomproduit = nomproduit;
    }

    public TextField getNote() {
        return note;
    }

    public void setNote(TextField note) {
        this.note = note;
    }

    public TextField getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(TextField commentaire) {
        this.commentaire = commentaire;
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

    public TextField getId() {
        return id;
    }

    public void setId(TextField id) {
        this.id = id;
    }



    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }
}