/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author pc hp
 */
public class Produit {
    private int ref_prod;
private String nomproduit;
private int quantite_prod;
private float prix_prod;
private String description_prod;
private Date datev_prod;
private int rating_prod;
String Saison;
String Imagep;

    public String getImagep() {
        return Imagep;
    }

    public void setImagep(String Imagep) {
        this.Imagep = Imagep;
    }
    public String getSaison() {
        return Saison;
    }

    public void setSaison(String Saison) {
        this.Saison = Saison;
    }

    public int getRef_prod() {
        return ref_prod;
    }

    public void setRef_prod(int ref_prod) {
        this.ref_prod = ref_prod;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getNewline() {
        return Newline;
    }

    public void setNewline(String Newline) {
        this.Newline = Newline;
    }

    public Produit() {
       
    }

    

   

    

    public String getNom_prod() {
        return nomproduit;
    }

    public void setNom_prod(String nom_prod) {
        this.nomproduit = nom_prod;
    }

    public int getQuantite_prod() {
        return quantite_prod;
    }

    public void setQuantite_prod(int quantite_prod) {
        this.quantite_prod = quantite_prod;
    }

    public float getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(float prix_prod) {
        this.prix_prod = prix_prod;
    }

    public String getDescription_prod() {
        return description_prod;
    }

    public void setDescription_prod(String description_prod) {
        this.description_prod = description_prod;
    }

    public Date getDatev_prod() {
        return datev_prod;
    }

    public void setDatev_prod(Date datev_prod) {
        this.datev_prod = datev_prod;
    }

    public int getRating_prod() {
        return rating_prod;
    }

    public void setRating_prod(int rating_prod) {
        this.rating_prod = rating_prod;
    }

    public Produit(int ref_prod, String nomproduit,float prix_prod, int quantite_prod, int rating_prod, String description_prod, Date datev_prod) {
        this.ref_prod = ref_prod;
          this.nomproduit = nomproduit;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.datev_prod = datev_prod;
    }

    public Produit(String nom_prod,float prix_prod, int quantite_prod, int rating_prod, String description_prod, Date datev_prod) {
        this.nomproduit = nom_prod;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.datev_prod = datev_prod;
       
    }
String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return nomproduit+Newline;
               
    }

    
    
}