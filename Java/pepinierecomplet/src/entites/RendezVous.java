/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author pc hp
 */
public class RendezVous {
    private int idrendezvous;
    public static int idutilisateur=1;
    private String sujet;
      private String lieu;
    private Date daterendezvous;  
    private int etat=0;

    public RendezVous() {
    }

    public RendezVous(String sujet, String lieu, Date daterendezvous) {
        this.sujet = sujet;
        this.lieu = lieu;
        this.daterendezvous = daterendezvous;
        
    }

    @Override
    public String toString() {
        return "RendezVous{" + "idrendezvous=" + idrendezvous + ", idutilisateur=" + idutilisateur + ", sujet=" + sujet + ", lieu=" + lieu + ", daterendezvous=" + daterendezvous + ", etat=" + etat + '}';
    }

    public void setIdrendezvous(int idrendezvous) {
        this.idrendezvous = idrendezvous;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDaterendezvous(Date daterendezvous) {
        this.daterendezvous = daterendezvous;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getIdrendezvous() {
        return idrendezvous;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public String getSujet() {
        return sujet;
    }

    public String getLieu() {
        return lieu;
    }

    public Date getDaterendezvous() {
        return daterendezvous;
    }

    public int getEtat() {
        return etat;
    }

    public RendezVous(int idutilisateur, String sujet, String lieu, Date daterendezvous, int etat) {
        this.idutilisateur = idutilisateur;
        this.sujet = sujet;
        this.lieu = lieu;
        this.daterendezvous = daterendezvous;
        this.etat = etat;
    }

    public RendezVous(int idrendezvous, int idutilisateur, String sujet, String lieu, Date daterendezvous, int etat) {
        this.idrendezvous = idrendezvous;
        this.idutilisateur = idutilisateur;
        this.sujet = sujet;
        this.lieu = lieu;
        this.daterendezvous = daterendezvous;
        this.etat = etat;
    }

    public void setTime(Date parse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int get(int DATE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            	

}
