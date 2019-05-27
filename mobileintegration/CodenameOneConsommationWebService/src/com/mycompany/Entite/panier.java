/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Hichem
 */
public class panier {
   private int idpanier;
    private int idutilisateur;
   private int etat ;
   

    @Override
    public String toString() {
        return "panier{" + "idpanier=" + idpanier + ", idutilisateur=" + idutilisateur + ", etat=" + etat + '}';
    }

    public panier(int idpanier, int idutilisateur, int etat) {
        this.idpanier = idpanier;
        this.idutilisateur = idutilisateur;
        this.etat = etat;
    }
    public panier( int idutilisateur, int etat) {
       // this.idpanier = idpanier;
        this.idutilisateur = idutilisateur;
        this.etat = etat;
    }

    public panier() {
    }

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
}
