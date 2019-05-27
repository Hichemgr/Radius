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
public class Promotion {
    public int idpromotion  ; 

    public Promotion(int idpromotion, String nom, int pourcentage, String nomproduit) {
        this.idpromotion = idpromotion;
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
    }
    public String nom ; 
   // public  Date datedebut ; 
    //public Date datefin ; 
    public int pourcentage ;  
   public String nomproduit ; 
   public float nouveauprix ; 
   public String img ; 

    public Promotion(int idpromotion, String nom, int pourcentage, String nomproduit, float nouveauprix, String img) {
        this.idpromotion = idpromotion;
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
        this.nouveauprix = nouveauprix;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Promotion(String nom, int pourcentage, String nomproduit) {
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
    }

    

    

    public float getNouveauprix() {
        return nouveauprix;
    }

    public void setNouveauprix(float nouveauprix) {
        this.nouveauprix = nouveauprix;
    }

    
    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

 



   

    public Promotion() {
    }

   

    

    public int getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

   
String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return "Nom= "+nom+Newline+
                "Pourcentage= "+pourcentage+Newline+
                "Nom Produit= "+nomproduit+Newline ; 
                
              // "Image= " +imagep+Newline ;
    }
   
    
}


  
    
/**
 *
 * @author ASUS
 */
