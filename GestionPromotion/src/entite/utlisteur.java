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
public class utlisteur {
    int idutiisateur ; 
    int cin ; 
    String nom ; 
    String prenom ; 
    String motdepasse ; 
    String adressemail ; 

    public utlisteur() {
    }

    @Override
    public String toString() {
        return "utlisteur{" + "idutiisateur=" + idutiisateur + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", motdepasse=" + motdepasse + ", adressemail=" + adressemail + ", telephone=" + telephone + ", datedecreation=" + datedecreation + ", status=" + status + ", role=" + role + ", nomcommerce=" + nomcommerce + ", photoprofil=" + photoprofil + ", nbpoint=" + nbpoint + '}';
    }

    public int getIdutiisateur() {
        return idutiisateur;
    }

    public void setIdutiisateur(int idutiisateur) {
        this.idutiisateur = idutiisateur;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDatedecreation() {
        return datedecreation;
    }

    public void setDatedecreation(Date datedecreation) {
        this.datedecreation = datedecreation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNomcommerce() {
        return nomcommerce;
    }

    public void setNomcommerce(String nomcommerce) {
        this.nomcommerce = nomcommerce;
    }

    public String getPhotoprofil() {
        return photoprofil;
    }

    public void setPhotoprofil(String photoprofil) {
        this.photoprofil = photoprofil;
    }

    public int getNbpoint() {
        return nbpoint;
    }

    public void setNbpoint(int nbpoint) {
        this.nbpoint = nbpoint;
    }

    public utlisteur(String adressemail, int telephone) {
        this.adressemail = adressemail;
        this.telephone = telephone;
    }

    public utlisteur(int idutiisateur, int cin, String nom, String prenom, String motdepasse, String adressemail, int telephone, Date datedecreation, String status, String role, String nomcommerce, String photoprofil, int nbpoint) {
        this.idutiisateur = idutiisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.datedecreation = datedecreation;
        this.status = status;
        this.role = role;
        this.nomcommerce = nomcommerce;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
    }
    int telephone ; 
    Date datedecreation ; 
    String status ; 
    String role ;
    String nomcommerce ; 
    String photoprofil ; 
    int nbpoint ; 

    public utlisteur(int idutiisateur, int cin, String nom, String prenom, String motdepasse, int telephone, Date datedecreation, String status, String role, String nomcommerce, String photoprofil, int nbpoint) {
        this.idutiisateur = idutiisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.telephone = telephone;
        this.datedecreation = datedecreation;
        this.status = status;
        this.role = role;
        this.nomcommerce = nomcommerce;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
    }
    
}
