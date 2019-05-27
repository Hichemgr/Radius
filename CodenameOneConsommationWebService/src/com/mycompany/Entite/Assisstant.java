/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author ASUS
 */
public class Assisstant {
    private int id_assisstant;
    private String nom;
    private String prenom;
    private int cin;
    private String etat;

    public Assisstant() {
    }

    public Assisstant(int id_assisstant, String nom, String prenom, int cin, String etat) {
        this.id_assisstant = id_assisstant;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.etat = etat;
    }

    public Assisstant(String nom, String prenom, int cin, String etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.etat = etat;
    }

    public int getId_assisstant() {
        return id_assisstant;
    }

    public void setId_assisstant(int id_assisstant) {
        this.id_assisstant = id_assisstant;
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Assisstant{" + "id_assisstant=" + id_assisstant + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", etat=" + etat + '}';
    }
    
    
}
