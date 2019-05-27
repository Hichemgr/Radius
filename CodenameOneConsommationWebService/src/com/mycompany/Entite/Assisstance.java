/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;





import java.util.Date;
/**
 *
 * @author ASUS
 */
public class Assisstance {
    private int id_assisstance;
    private String id_client;
    private String id_assisstant;
    private Date dateass;
    private String type;

    public Assisstance() {
    }

    public Assisstance(int id_assisstance, String id_client, String id_assisstant, Date dateass, String type) {
        this.id_assisstance = id_assisstance;
        this.id_client = id_client;
        this.id_assisstant = id_assisstant;
        this.dateass = dateass;
        this.type = type;
    }

    public Assisstance(String id_client, String id_assisstant, Date dateass, String type) {
        this.id_client = id_client;
        this.id_assisstant = id_assisstant;
        this.dateass = dateass;
        this.type = type;
    }

    public int getId_assisstance() {
        return id_assisstance;
    }

    public void setId_assisstance(int id_assisstance) {
        this.id_assisstance = id_assisstance;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getId_assisstant() {
        return id_assisstant;
    }

    public void setId_assisstant(String id_assisstant) {
        this.id_assisstant = id_assisstant;
    }

    public Date getDateass() {
        return dateass;
    }

    public void setDateass(Date dateass) {
        this.dateass = dateass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Assisstance{" + "id_assisstance=" + id_assisstance + ", id_client=" + id_client + ", id_assisstant=" + id_assisstant + ", dateass=" + dateass + ", type=" + type + '}';
    }
    
    
}
