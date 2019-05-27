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
public class Catalogue {
    private int id_catalogue;
    private String nom_catalogue;
    private Date datedebut;
    private Date datefin;
    private String saison;

    public Catalogue() {
        
    }

    public Catalogue(String nom_catalogue, String saison, Date datedebut, Date datefin) {
         this.nom_catalogue = nom_catalogue;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.saison = saison;
    }

    public Catalogue(String nom, String saison) {
      this.nom_catalogue = nom;
      this.saison = saison;
    }

    public int getId_catalogue() {
        return id_catalogue;
    }

    public void setId_catalogue(int id_catalogue) {
        this.id_catalogue = id_catalogue;
    }

    public String getNom_catalogue() {
        return nom_catalogue;
    }

    public void setNom_catalogue(String nom_catalogue) {
        this.nom_catalogue = nom_catalogue;
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

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public Catalogue( String nom_catalogue, Date datedebut, Date datefin, String saison) {
      
        this.nom_catalogue = nom_catalogue;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.saison = saison;
    }

    public Catalogue(int id_catalogue, String nom_catalogue, Date datedebut, Date datefin, String saison) {
        this.id_catalogue = id_catalogue;
        this.nom_catalogue = nom_catalogue;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.saison = saison;
    }
String Newline=System.getProperty("line.separator");
    @Override
    public String toString() {
        return "Nom = "+nom_catalogue+Newline+
                //" Date Debut = "+datedebut+Newline+
                //" Date Fin = "+datefin+Newline+
                 
                " Saison= "+saison+Newline;
                
    }
  
    
    
    
}
