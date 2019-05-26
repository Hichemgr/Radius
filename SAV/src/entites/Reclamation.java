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
public class Reclamation {
     private int idreclamation;
   public static int idutilisateur=12;
      public  String nomproduit;
    public String sujet;
    public String contenu;
    public int etat=0;

    public Reclamation(String nomproduit, String sujet, String contenu) {
        this.nomproduit = nomproduit;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    public Reclamation() {
    }

    public Reclamation(String sujet, String contenu) {
        this.sujet = sujet;
        this.contenu = contenu;
   
    }
  

    public Reclamation(int idutilisateur, String nomproduit, String sujet, String contenu, int etat) {
        this.idutilisateur = idutilisateur;
           this.nomproduit = nomproduit;
        this.sujet = sujet;
        this.contenu = contenu;
        this.etat = etat;
     
    }

    public Reclamation(int idreclamation, int idutilisateur,String nomproduit, String sujet, String contenu, int etat) {
        this.idreclamation = idreclamation;
        this.idutilisateur = idutilisateur;
        this.nomproduit = nomproduit;
        this.sujet = sujet;
        this.contenu = contenu;
        this.etat = etat;
        
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
    
    @Override
    public String toString() {
        return   nomproduit;
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
