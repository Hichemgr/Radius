/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import java.sql.Date;

/**
 *
 * @author seifeddinebenfraj
 */
public class assisstance {
    
    private int id_assisstance;
    
    private String id_client;
    
    private String id_assisstant;
    
    private Date dateAss;
    
    private String type;

    public assisstance(int id_assisstance, String id_client, String id_assisstant, Date dateAss, String type) {
        this.id_assisstance = id_assisstance;
        this.id_client = id_client;
        this.id_assisstant = id_assisstant;
        this.dateAss = dateAss;
        this.type = type;
    }
    
    

    public assisstance(String id_client, String id_assisstant, Date dateAss, String type) {
        this.id_client = id_client;
        this.id_assisstant = id_assisstant;
        this.dateAss = dateAss;
        this.type = type;
    }
    
    public assisstance(){
        
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

    public Date getDateAss() {
        return dateAss;
    }

    public void setDateAss(Date dateAss) {
        this.dateAss = dateAss;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_assisstance() {
        return id_assisstance;
    }

    public void setId_assisstance(int id_assisstance) {
        this.id_assisstance = id_assisstance;
    }
    
    

    @Override
    public String toString() {
        return "assisstance{" + "id_client=" + id_client + ", id_assisstant=" 
                + id_assisstant + ", dateAss=" + dateAss 
                + ", type=" + type + '}';
    }

    
           
    
    
}
