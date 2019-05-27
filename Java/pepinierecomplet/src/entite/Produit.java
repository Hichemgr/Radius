/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

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
 int idproduit;
    String nomproduit;
    float prix;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    int quantite;
    String note;
    String description;

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
        return "Nom = "+nom_prod+Newline+
                " Prix = "+prix_prod+Newline+
                " Quantite = "+quantite_prod+Newline+
                 "Description = "+description_prod+Newline+
                " Saison= "+saison+Newline+
                "Rating= " +rating_prod+Newline+
               "Image= " +imagep+Newline ;
    }
    
     public Produit(int idproduit, int quantite) {
        this.idproduit = idproduit;
        this.quantite = quantite;
    }

   /* String newligne="\n";
    @Override
    public String toString() {
        return "produit{" + "nomproduit=" + nomproduit +newligne+ ", prix=" + prix +newligne+ ", quantite=" + quantite +newligne+ '}';
    }*/

    public Produit(String nomproduit, float prix, int quantite) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.quantite = quantite;
    }

  /*  public Produit(int idproduit, String nomproduit, float prix, int quantite) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.quantite = quantite;
    }*/
    public Produit(String nomproduit,String description, int quantite , float prix )
    {
        
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.quantite = quantite;
       
        this.description = description;
    }


    
    
}
