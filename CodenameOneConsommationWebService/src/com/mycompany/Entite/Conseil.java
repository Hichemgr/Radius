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
public class Conseil {
    private int id_conseil;
    private String type;
    private String contenu;

    public Conseil() {
    }

    public Conseil(int id_conseil, String type, String contenu) {
        this.id_conseil = id_conseil;
        this.type = type;
        this.contenu = contenu;
    }

    public Conseil(String type, String contenu) {
        this.type = type;
        this.contenu = contenu;
    }

    public int getId_conseil() {
        return id_conseil;
    }

    public void setId_conseil(int id_conseil) {
        this.id_conseil = id_conseil;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Conseil{" + "id_conseil=" + id_conseil + ", type=" + type + ", contenu=" + contenu + '}';
    }
    
    
    
}
