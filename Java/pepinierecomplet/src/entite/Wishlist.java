/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author raedm
 */
public class Wishlist  {
    private int id_wish;
     private int ref_prod;
    private String nom_prod;
    private float prix_prod;
    private long cin;
    private String dateajout_wish;

    public Wishlist(String nom, int prix,  String date) {
          
        this.nom_prod = nom;
        this.prix_prod = prix;
       
        this.dateajout_wish = date;
    }

    public Wishlist() {
       
    }

   

    public float getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(float prix_prod) {
        this.prix_prod = prix_prod;
    }
    
    

    public int getId_wish() {
        return id_wish;
    }

    public void setId_wish(int id_wish) {
        this.id_wish = id_wish;
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

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public String getDateajout_wish() {
        return dateajout_wish;
    }

    public void setDateajout_wish( String dateajout_wish) {
        this.dateajout_wish = dateajout_wish;
    }

    public Wishlist(int ref_prod, String nom_prod, float prix_prod, long cin,  String dateajout_wish) {
        this.ref_prod = ref_prod;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.cin = cin;
        this.dateajout_wish = dateajout_wish;
    }

    public Wishlist(int id_wish, int ref_prod, String nom_prod, float prix_prod, long cin, String dateajout_wish) {
        this.id_wish = id_wish;
        this.ref_prod = ref_prod;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.cin = cin;
        this.dateajout_wish = dateajout_wish;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "id_wish=" + id_wish + ", ref_prod=" + ref_prod + ", nom_prod=" + nom_prod + ", prix_prod=" + prix_prod + ", cin=" + cin + ", dateajout_wish=" + dateajout_wish + '}';
    }
    
    
   

    

    
    
}
