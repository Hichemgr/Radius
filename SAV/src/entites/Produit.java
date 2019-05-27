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
public class Produit {

    public Produit(String nomproduit) {
        this.nomproduit = nomproduit;
    }
    private int idproduit;
private String nomproduit;
private int quantite_prod;
private float prix_prod;
private String description_prod;
private Date datev_prod;
private int rating_prod;

    public Produit() {
       
    }

    

   

    public int getidproduit() {
        return idproduit;
    }

    public void setidproduit(int ref_prod) {
        this.idproduit = ref_prod;
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
        this.idproduit = ref_prod;
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