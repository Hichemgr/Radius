/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author pc hp
 */
public class Vote {
    public int idvote;
    public int idutilisateur;
    public String nomproduit;
    public int note;
    public String commentaire;

    public Vote(int idvote, int idutilisateur, String nomproduit, int note, String commentaire) {
        this.idvote = idvote;
        this.idutilisateur = idutilisateur;
        this.nomproduit = nomproduit;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Vote(String nomproduit, int note, String commentaire) {
        this.nomproduit = nomproduit;
        this.note = note;
        this.commentaire = commentaire;
    }
 String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return "NomProduit = "+nomproduit+Newline+
                " Note = "+note+Newline+
                " Commentaire= "+commentaire+Newline;
    }
    public int getIdvote() {
        return idvote;
    }

    public void setIdvote(int idvote) {
        this.idvote = idvote;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Vote() {
    }

    public Vote(int idvote, String nomproduit, int note, String commentaire) {
        this.idvote = idvote;
        this.nomproduit = nomproduit;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    
    
}
