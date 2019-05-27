/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author raedm
 */
public class Produit {
  private int ref_prod;
private String nom_prod;
private int quantite_prod;
private float prix_prod;
private String description_prod;
private String saison;
private String imagep;
private int rating_prod;

    public Produit(String nom_prod, float prix_prod, int quantite_prod, int rating_prod, String description_prod, String saison) {
        this.nom_prod = nom_prod;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.saison = saison;
    }

    public Produit(String nom_prod, float prix_prod, String imagep) {
      
          this.nom_prod = nom_prod;
       this.prix_prod = prix_prod;
        
        this.imagep = imagep;
    }

    public Produit(String nom_prod, int quantite_prod) {
       this.nom_prod = nom_prod;
    
         this.quantite_prod = quantite_prod;
    }

    public Produit(int ref_prod, String nom_prod, float prix_prod, int quantite_prod, int rating_prod, String description_prod, String saison) {
        this.ref_prod=ref_prod;
        this.nom_prod = nom_prod;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.saison = saison;
    }

    public String getImagep() {
        return imagep;
    }

    public void setImagep(String imagep) {
        this.imagep = imagep;
    }


    public Produit() {
       
    }

    public Produit(int ref_prod, String nom_prod,float prix_prod, int quantite_prod) {
        this.ref_prod = ref_prod;
        this.nom_prod = nom_prod;
        this.quantite_prod = quantite_prod;
        this.prix_prod = prix_prod;
    }

 

   

    public int getRef_prod() {
        return ref_prod;
    }

    public void setRef_prod(int ref_prod) {
        this.ref_prod = ref_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
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

    public String getSaison() {
        return saison;
    }

    public void setSaison(String Saison) {
      this.saison= Saison;
    }

    public int getRating_prod() {
        return rating_prod;
    }

    public void setRating_prod(int rating_prod) {
        this.rating_prod = rating_prod;
    }

    public Produit(int ref_prod, String nom_prod,float prix_prod, int quantite_prod, int rating_prod, String description_prod, String saison,String imagep) {
        this.ref_prod = ref_prod;
          this.nom_prod = nom_prod;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.saison = saison;
        this.imagep = imagep;
    }

    public Produit(String nom_prod,float prix_prod, int quantite_prod, int rating_prod, String description_prod, String saison,String imagep) {
        this.nom_prod = nom_prod;
       this.prix_prod = prix_prod;
         this.quantite_prod = quantite_prod;
         this.rating_prod = rating_prod;
        this.description_prod = description_prod;
        this.saison = saison;
          this.imagep = imagep;
       
    }
String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return "Nom= "+nom_prod+Newline+
                 "ID= " +ref_prod+Newline;
                
              //"Image= " +imagep+Newline ;
    }
    /******************/
    //String Newlin2e=System.getProperty("line.separator");
    
    public String Aff() {
        return "Nom= "+nom_prod+Newline+
                
                "Prix= "+prix_prod+Newline+
                "Quantite= "+quantite_prod+Newline+
                "Description= "+description_prod+Newline+
                "Saison= "+saison+Newline+
                "Rating= " +rating_prod+Newline;
              //"Image= " +imagep+Newline ;
    }
}
