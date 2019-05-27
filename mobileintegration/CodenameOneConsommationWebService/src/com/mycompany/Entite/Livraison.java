/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author seifeddinebenfraj
 */
public class Livraison {
    private int ID_Livraison;
    public static int ID_Panier=1;
    private int ID_Pan;
    private float Montant;
    private int Etat;
    private Date Date;
    private String Adresse;
    private double Longitude;
    private double Latitude;
    public static int id_User=5;
    private int id_Us;
    private String nomLivreur;
    private String nomClient;

    public Livraison(float Montant, String Adresse, String nomClient) {
        this.Montant = Montant;
        this.Adresse = Adresse;
        this.nomClient = nomClient;
    }

    public Livraison() {
    }

    public Livraison(int ID_Livraison, int ID_Pan, float Montant, int Etat, Date Date, String Adresse, double Longitude, double Latitude, int id_Us, String nomLivreur) {
        this.ID_Livraison = ID_Livraison;
        this.ID_Pan = ID_Pan;
        this.Montant = Montant;
        this.Etat = Etat;
        this.Date = Date;
        this.Adresse = Adresse;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.id_Us = id_Us;
        this.nomLivreur = nomLivreur;
    }

    public Livraison(String Adresse, float Montant, int Etat) {
        this.Adresse = Adresse;
        this.Montant = Montant;
        this.Etat = Etat;
    }

    public Livraison(int ID_Livraison,String Adresse, float Montant, int Etat) {
        this.ID_Livraison = ID_Livraison;
        this.Montant = Montant;
        this.Etat = Etat;
        this.Adresse = Adresse;
    }

    public Livraison(String nomClient, String Adresse) {
        this.Adresse = Adresse;
        this.nomClient = nomClient;
    }
    
    


    public int getID_Livraison() {
        return ID_Livraison;
    }

    public void setID_Livraison(int ID_Livraison) {
        this.ID_Livraison = ID_Livraison;
    }

    public int getID_Panier() {
        return ID_Panier;
    }

    public void setID_Panier(int ID_Panier) {
        this.ID_Panier = ID_Panier;
    }

    public float getMontant() {
        return Montant;
    }

    public void setMontant(float Montant) {
        this.Montant = Montant;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int Etat) {
        this.Etat = Etat;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getID_Pan() {
        return ID_Pan;
    }

    public void setID_Pan(int ID_Pan) {
        this.ID_Pan = ID_Pan;
    }

    public int getId_Us() {
        return id_Us;
    }

    public void setId_Us(int id_Us) {
        this.id_Us = id_Us;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Override
    public String toString() {
        return "Livraison{" + "ID_Livraison=" + ID_Livraison + ", Montant="
                + Montant + ", Etat=" + Etat + ", Adresse=" + Adresse 
                + ", nomLivreur=" + nomLivreur + ", nomClient=" + nomClient + '}';
    }
    
    

    

    
    
    
    
    
}
