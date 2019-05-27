/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import com.codename1.ui.ComboBox;
import java.util.Map;

/**
 *
 * @author pc hp
 */
public class Reclamation {
     private int idreclamation;
   public  int idutilisateur;
      public  String nomproduit;
    public String sujet;
    public String contenu;
    public String commentaire=" ";
    public int etat;

    public Reclamation(int idreclamation, int idutilisateur, String nomproduit, String sujet, String contenu) {
        this.idreclamation = idreclamation;
        this.idutilisateur = idutilisateur;
        this.nomproduit = nomproduit;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    public Reclamation(String nomproduit, String sujet, String contenu) {
        
        this.nomproduit = nomproduit;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    public Reclamation() {
       }

   
    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdreclamation() {
        return idreclamation;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public String getSujet() {
        return sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public int getEtat() {
        return etat;
    }

    public String getnomproduit() {
        return nomproduit;
    }

    String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return "IdReclamation = "+idreclamation+Newline+
                "NomProduit = "+nomproduit+Newline+
                " Sujet = "+sujet+Newline+
                " Contenu = "+contenu+Newline+
                 "Etat = "+etat+Newline+
                " Commentaire= "+commentaire+Newline;
    }

    public Reclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }
    
  

    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setnomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

  
    
    
}
