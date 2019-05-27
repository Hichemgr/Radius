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
public class utilisateur {
 int   idutilisateur;			
int cin;		
String nom;			
String prenom;			
String motdepasse;			
String adressemail;		
int telephone;		
Date datecreation;	
String status;			
String role;			
String nomcommerce;		
String photoprofil;			
int nbpoint;

    public utilisateur(int idutilisateur, int cin, String nom, String prenom, String motdepasse, String adressemail, int telephone, Date datecreation, String status, String role, String nomcommerce, String photoprofil, int nbpoint) {
        this.idutilisateur = idutilisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.datecreation = datecreation;
        this.status = status;
        this.role = role;
        this.nomcommerce = nomcommerce;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
    }

    public utilisateur() {
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNomcommerce(String nomcommerce) {
        this.nomcommerce = nomcommerce;
    }

    public void setPhotoprofil(String photoprofil) {
        this.photoprofil = photoprofil;
    }

    public void setNbpoint(int nbpoint) {
        this.nbpoint = nbpoint;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public int getTelephone() {
        return telephone;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getNomcommerce() {
        return nomcommerce;
    }

    public String getPhotoprofil() {
        return photoprofil;
    }

    public int getNbpoint() {
        return nbpoint;
    }
    
}
