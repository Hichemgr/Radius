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
public class publicite {
    int idpublicite ; 
    String nompublicite ; 
    String type ; 
    Date datepub ; 
    String nomprod ; 
 public publicite(int idpublicite, String nompublicite, Date datepub, String nomproduit) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.datepub = datepub;
        this.nomprod = nomproduit;
    }
    public publicite(String nompublicite, Date datepub, String nomproduit) {
        this.nompublicite = nompublicite;
        this.datepub = datepub;
        this.nomprod = nomproduit;
    }

    public String getNomproduit() {
        return nomprod;
    }

    public void setNomproduit(String nomproduit) {
        this.nomprod = nomproduit;
    }

    public publicite(int idpublicite, String nompublicite, String type, Date datepub) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.type = type;
        this.datepub = datepub;
    }

    public publicite(String nompublicite, String type, Date datepub) {
        this.nompublicite = nompublicite;
        this.type = type;
        this.datepub = datepub;
    }

    public publicite() {
        
    }

    public publicite(int idpublicite, String nompublicite, Date datepub) {
          this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
          this.datepub = datepub;
    }

    public int getIdpublicite() {
        return idpublicite;
    }

    public void setIdpublicite(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public String getNompublicite() {
        return nompublicite;
    }

    public void setNompublicite(String nompublicite) {
        this.nompublicite = nompublicite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatepub() {
        return datepub;
    }

    public void setDatepub(Date datepub) {
        this.datepub = datepub;
    }

    @Override
    public String toString() {
        return "publicite{" + "idpublicite=" + idpublicite + ", nompublicite=" + nompublicite + ", type=" + type + ", datepub=" + datepub + '}';
    }
    
    
}
