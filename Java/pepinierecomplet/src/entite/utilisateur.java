/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

//import java.util.Date;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import utile.cryptpasswords;


/**
 *
 * @author ASUS
 */
public class utilisateur {
            private int idutilisateur;
            private int cin;
            private String nom;
            private String prenom;
            private String motdepasse;
            private String adressemail;
            private int telephone;
            private Date datecreation;
            private String status;
            private String role;
            private String nomcommerce;
            private String photoprofil;
            private int nbpoint;
            //private String ;
            private String adresse;

    public utilisateur() {
    }

    public utilisateur(int idutilisateur, int cin, String nom, String prenom, String motdepasse, String adressemail, int telephone, Date datecreation, String status, String role, String nomcommerce, String photoprofil, int nbpoint,String adresse) throws NoSuchAlgorithmException {
         cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        this.idutilisateur = idutilisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = encryption.cryptme(motdepasse);
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.datecreation = datecreation;
        this.status = status;
        this.role = role;
        this.nomcommerce = nomcommerce;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
        this.adresse=adresse;
    }

    public utilisateur(int cin, String nom, String prenom, String motdepasse, String adressemail, int telephone, Date datecreation, String status, String role, String photoprofil, int nbpoint,String adresse) throws NoSuchAlgorithmException {
        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = encryption.cryptme(motdepasse);
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.datecreation = datecreation;
        this.status = status;
        this.role = role;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
        this.adresse=adresse;
    }

    public utilisateur(int idutilisateur, int cin, String nom, String prenom, String motdepasse, String adressemail, int telephone, Date datecreation, String status, String role, String photoprofil, int nbpoint,String adresse) throws NoSuchAlgorithmException {
         cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        this.idutilisateur = idutilisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = encryption.cryptme(motdepasse);
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.datecreation = datecreation;
        this.status = status;
        this.role = role;
        this.photoprofil = photoprofil;
        this.nbpoint = nbpoint;
        this.adresse=adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

   

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
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

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
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

   
   /* public void setDate(java.util.Date d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public String toString() {
        return "utilisateur{" + "idutilisateur=" + idutilisateur + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", motdepasse=" + motdepasse + ", adressemail=" + adressemail + ", telephone=" + telephone + ", datecreation=" + datecreation + ", status=" + status + ", role=" + role + ", nomcommerce=" + nomcommerce + ", photoprofil=" + photoprofil + ", nbpoint=" + nbpoint + ", adresse=" + adresse + '}';
    }
            
}
