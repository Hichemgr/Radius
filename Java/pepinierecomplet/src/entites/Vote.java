/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author pc hp
 */
public class Vote {
     private int idvote;
    public static  int idutilisateur=1;
    private int note;
        private String nomv;

    public void setNote(int note) {
        this.note = note;
    }

    public void setNomv(String nomv) {
        this.nomv = nomv;
    }

    public Vote( String nomv,int note) {
        this.note = note;
        this.nomv = nomv;
    }

    public int getNote() {
        return note;
    }

    public String getNomv() {
        return nomv;
    }


    public Vote() {
    }

    public Vote(int idvote, int note) {
        this.idvote = idvote;
        this.note = note;
    }
    

    @Override
    public String toString() {
        return "Vote{" + "idvote=" + idvote + ", idutilisateur=" + idutilisateur + ", note=" + note + '}';
    }

    public Vote(int note) {
        this.note = note;
    }

    public Vote(int idvote, int idutilisateur ,int note) {
        this.idvote = idvote;
        this.idutilisateur = idutilisateur;
        this.note = note;

    }

   

     public void setInote(int note) {
        this.note = note;
    }
    public void setIdvote(int idvote) {
        this.idvote = idvote;
    }

  
    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdvote() {
        return idvote;
    }

   

    public int getIdutilisateur() {
        return idutilisateur;
    }
     public int getnote() {
        return note;
    }
    
    
}
