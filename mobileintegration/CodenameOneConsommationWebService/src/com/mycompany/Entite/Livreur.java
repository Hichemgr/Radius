/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author seifeddinebenfraj
 */
public class Livreur {
    int id_livreur,cin,etat;
    String nom,prenom;

    public Livreur() {
        
    }
    
    public Livreur(int id_livreur, int cin, int etat, String nom, String prenom) {
        this.id_livreur = id_livreur;
        this.cin = cin;
        this.etat = etat;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Livreur(int id_livreur, String nom, String prenom, int cin) {
        this.id_livreur = id_livreur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Livreur(String nom, String prenom, int cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;

    }
    

    public int getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Livreur{" + "id_livreur=" + id_livreur + ", cin=" + cin + ", etat=" + etat + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}
