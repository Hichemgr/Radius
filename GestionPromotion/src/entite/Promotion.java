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
public class Promotion {
    public int idpromotion  ; 
    public String nom ; 
    public  Date datedebut ; 
    public Date datefin ; 
    public int pourcentage ;  
   public String nomproduit ; 
   public float nouveauprix ; 

    public Promotion(String nom, Date datedebut, Date datefin, int pourcentage, String nomproduit) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
    }
    public Promotion(String nom, Date datedebut, Date datefin, int pourcentage, String nomproduit, float nouveauprix) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
        this.nouveauprix = nouveauprix;
    }

    public Promotion(int idpromotion, String nom, Date datedebut, Date datefin, int pourcentage, String nomproduit, float nouveauprix) {
        this.idpromotion = idpromotion;
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = pourcentage;
        this.nomproduit = nomproduit;
        this.nouveauprix = nouveauprix;
    }
    

    public Promotion(int idpromotion, String nom, Date datedebut, Date datefin, int pourcentage, String nomproduit) {
         this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = (int) pourcentage;
        this.nomproduit=nomproduit ; 
    }
    
     public Promotion( String nom,String nomproduit,float n) {
         this.nom = nom;
       this.nouveauprix=n;
        this.nomproduit=nomproduit ; 
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

    public Promotion(String nom, Date datedebut, Date datefin,int pourcentage) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = (int) pourcentage;
    }

    public Promotion(int idpromotion, String nom, Date datedebut, Date datefin, int pourcentage) {
        this.idpromotion = idpromotion;
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.pourcentage = pourcentage;
       
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

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Promotion{" + "idpromotion=" + idpromotion + ", nom=" + nom + ", datedebut=" + datedebut + ", datefin=" + datefin + ", pourcentage=" + pourcentage + '}';
    }

  

  
    
    
}
