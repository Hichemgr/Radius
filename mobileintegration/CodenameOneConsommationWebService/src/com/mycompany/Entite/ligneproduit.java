/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Hichem
 */
public class ligneproduit {
    int idligne ;
    int idpanier;
    int idproduit;
    int quantite;

    public ligneproduit() {
    }

    public ligneproduit(int idligne, int idpanier, int idproduit, int quantite) {
        this.idligne = idligne;
        this.idpanier = idpanier;
        this.idproduit = idproduit;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "ligneproduit{" + "idligne=" + idligne + ", idpanier=" + idpanier + ", idproduit=" + idproduit + ", quantite=" + quantite + '}';
    }

    public int getIdligne() {
        return idligne;
    }

    public void setIdligne(int idligne) {
        this.idligne = idligne;
    }

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
}
