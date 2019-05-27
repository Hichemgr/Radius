/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author pc hp
 */
public class Reponse {
    
        private int idreponse;
    public  int idquestion;
    public  static int idutilisateur=1;
    private String contenu ;
    private int visible=0;
    private String nom;

    public Reponse(int idreponse, int idquestion, String contenu) {
        this.idreponse = idreponse;
        this.idquestion = idquestion;
        this.contenu = contenu;
    }

    

    public Reponse(int idreponse, int idquestion, int idutilisateur, String contenu, String nom) {
        this.idreponse = idreponse;
        this.idquestion = idquestion;
        this.idutilisateur = idutilisateur;
        this.contenu = contenu;
        this.nom = nom;
    }

    public Reponse(int idreponse, int idquestion, String contenu, String nom) {
        this.idreponse = idreponse;
        this.idquestion = idquestion;
        this.contenu = contenu;
        this.nom = nom;
    }

    public Reponse(String contenu, String nom) {
        this.contenu = contenu;
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Reponse(String contenu) {
        this.contenu = contenu;
     
    }

    public Reponse() {
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }


    public Reponse(int idreponse, int idquestion, int idutilisateur, String contenu,int visible) {
        this.idreponse = idreponse;
        this.idquestion = idquestion;
        this.idutilisateur = idutilisateur;
        this.contenu = contenu;
                this.visible=visible;

    }

    public Reponse(int idquestion, int idutilisateur, String contenu,int visible) {
        this.idquestion = idquestion;
        this.idutilisateur = idutilisateur;
        this.contenu = contenu;
                this.visible=visible;

    }

    @Override
    public String toString() {
        return "Reponse{" + "idreponse=" + idreponse + ", idquestion=" + idquestion + ", idutilisateur=" + idutilisateur + ", contenu=" + contenu + ", visible=" + visible + '}';
    }

    public void setIdreponse(int idreponse) {
        this.idreponse = idreponse;
    }

    public void setIdquestion(int idquestion) {
        this.idquestion = idquestion;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getIdreponse() {
        return idreponse;
    }

    public int getIdquestion() {
        return idquestion;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public String getContenu() {
        return contenu;
    }
    
    
    
}
