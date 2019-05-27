/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Produit {
    int reference ; 
   String nomproduit ; 
   float prix ; 
   int quantite ; 
   float note ; 
   String description ; 
   Date datevalidite ; 

    public Produit(int reference, String nomproduit, float prix, int quantite, float note, String description, Date datevalidite) {
        this.reference = reference;
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.quantite = quantite;
        this.note = note;
        this.description = description;
        this.datevalidite = datevalidite;
    }

    public Produit(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit() {
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(Date datevalidite) {
        this.datevalidite = datevalidite;
    }
   
}
