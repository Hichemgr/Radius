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
public class Question {
    
    private int idquestion;
    public static int idutilisateur=1;
    private String contenu ;
    private int visible=0;
    private String contenu_reponse;
    private String nom;

    public Question(String contenu, String contenu_reponse, String nom) {
        this.contenu = contenu;
        this.contenu_reponse = contenu_reponse;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

  

    public Question(int idquestion, String contenu) {
        this.idquestion = idquestion;
        this.contenu = contenu;
    }
    
 public Question(int idquestion, String contenu, String contenu_reponse, String nom) {
        this.idquestion = idquestion;
        this.contenu = contenu;
        this.contenu_reponse = contenu_reponse;
        this.nom = nom;
    }


    
    public void setNom(String nom) {
        this.nom = nom;
    }
    

    public Question() {
    }

    public Question( String contenu) {
        this.contenu = contenu;
        
    }

    public Question(int idquestion, int idutilisateur, String contenu,int visible) {
        this.visible=visible;
        this.idquestion = idquestion;
        this.idutilisateur = idutilisateur;
        this.contenu = contenu;
    }

    public Question(int idutilisateur, String contenu,int visible) {
        this.idutilisateur = idutilisateur;
        this.contenu = contenu;
        this.visible=visible;

    }

    public Question(int idquestion, String contenu, String nom) {
        this.idquestion = idquestion;
        this.contenu = contenu;
        this.nom = nom;
    }
    public String getContenu_reponse() {
        return contenu_reponse;
    }

    public void setContenu_reponse(String contenu_reponse) {
        this.contenu_reponse = contenu_reponse;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

 

    public void setIdquestion(int idquestion) {
        this.idquestion = idquestion;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public String toString() {
        return "Question{" + "idquestion=" + idquestion + ", contenu=" + contenu + ", visible=" + visible + ", contenu_reponse=" + contenu_reponse + ", nom=" + nom + '}';
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
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
