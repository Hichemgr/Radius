/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modals.assisstance;
import utile.MyDBcon;

/**
 *
 * @author seifeddinebenfraj
 */
public class ServiceAssisstance {
    
    Connection cnx;
        
        
     public ServiceAssisstance() throws SQLException  {
        this.cnx = MyDBcon.getInstance().getCnx();
     
    }
     
     public int ajouterAssisstance(assisstance l)
    {
        int rs=0;
        String format = "DD/MM/YY H:MM:SS" ;
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        java.util.Date date2 = new java.sql.Date(l.getDateAss().getTime());
        try {
       String   query = "insert into  assisstance (id_client,id_assisstant,dateAss,type) values (?,?,?,?)";
       
            PreparedStatement   st = cnx.prepareStatement(query);
            
            st.setString(1, l.getId_client());
            st.setString(2,l.getId_assisstant());
            st.setDate(3, l.getDateAss());
            st.setString(4, l.getType());
            
            
            if(date.compareTo(date2)<0){
                rs=st.executeUpdate();
            }
            
            System.out.println("Assisstance ajoutée.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs;
        }

        
     
     public List<assisstance> listerLesAssisstances() {
        List<assisstance> myList = new ArrayList<>();

        try { 
           String query = "SELECT * from assisstance"; 
          PreparedStatement st = cnx.prepareStatement(query);
  
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                assisstance p2 = new assisstance();
                p2.setId_assisstance(rs.getInt(1));
                p2.setId_client(rs.getString(2));
                p2.setId_assisstant(rs.getString(3));
                p2.setDateAss(rs.getDate(4));
                p2.setType(rs.getString(5));
    /*User u = new User(rs.getInt(11));
          p2.setID_user(u);     */   
                myList.add(p2);

            }}catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
        return myList;
    }
     
     
     
     
     
     public List<assisstance> LesLivraisonsParClient(String nom) {
        List<assisstance> myList = new ArrayList<>();
      

        try { 
           String query = "SELECT * from assisstance where id_client='"+nom+"' ";
             Statement st = cnx.prepareStatement(query); 
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
               assisstance p2 = new assisstance();
                p2.setId_assisstance(rs.getInt(1));
                p2.setId_client(rs.getString(2));
                p2.setId_assisstant(rs.getString(3));
                p2.setDateAss(rs.getDate(4));
                p2.setType(rs.getString(5));
                
    /*User u = new User(rs.getInt(11));
          p2.setID_user(u);     */   
                myList.add(p2);
            }}catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
        return myList;
    }
     
     public int modifierAssisstance(assisstance b)
    {
        int rs=0;
        String format = "DD/MM/YY H:MM:SS" ;
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        java.util.Date date2 = new java.sql.Date(b.getDateAss().getTime());
        try {
            PreparedStatement pt = cnx.prepareStatement("UPDATE `assisstance` SET `id_client` = ?, `id_assisstant` = ?, `dateAss` = ?, `type` = ? WHERE `assisstance`.`id_assisstance` = ?;");
           
            pt.setString(1, b.getId_client());
            pt.setString(2,b.getId_assisstant());
            pt.setDate(3,b.getDateAss());
            pt.setString(4,b.getType());
            pt.setInt(5, b.getId_assisstance());
            
            
            if(date.compareTo(date2)<0){
                rs=pt.executeUpdate();
            }
        }   catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }
            return rs;
    }
     
       public  void SupprimerAssisstance(int id)
    {
        try {
            PreparedStatement pt = cnx.prepareStatement("delete  from assisstance  where id_assisstance =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            
        }

}
       
       public  ArrayList<assisstance> FindAssisstance(String rech) throws SQLException  {
       ArrayList<assisstance> listAss = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `assisstance` where `id_assisstance` Like '%"+rech+"%' or `id_client` Like '%"+rech+"%' or `id_assisstant` Like '%"+rech+"%' or`dateAss` Like '%"+rech+"%' or `type` Like '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
            int id_assisstance = resultat.getInt("id_assisstance");
            String id_client= resultat.getString("id_client");
            String id_assisstant= resultat.getString("id_assisstant");
            Date dateAss= resultat.getDate("dateAss");
            String type= resultat.getString("type");
              
              
              
           listAss.add(new assisstance(id_assisstance,id_client,id_assisstant,dateAss,type));
            }
     listAss.forEach(e->System.out.println(e));
 
      return listAss;
    }
       
       public ObservableList<String> getNomClient(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select * from  utilisateur where role = 'client';";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                //listnom.add( rs.getString("nom"));
                listnom.add( rs.getString("cin"));

                //listnom.add(rs.getString("prenom"));
                //listnom.add( rs.getString("idutilisateur"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
       public String getIdClient(int nom){
           String p = "";
           try {
               Statement st = cnx.createStatement();
               String req = "select * from utilisateur where cin = '"+nom+"'";
               ResultSet rs = st.executeQuery(req);
               while(rs.next())  {
            p=rs.getString("nom")+" "+rs.getString("prenom");
           
        }
           } catch (Exception ex) {
               System.out.println("erreur" + ex.getMessage());
           }
        return p;
           
       }
       
       
       public String getPrenomClient(int id){
           String p ="";
           try {
               Statement st = cnx.createStatement();
               String req = "select prenom from utilisateur where idutilisateur = '"+id+"'";
               ResultSet rs = st.executeQuery(req);
               while(rs.next())  {
            p=rs.getString("prenom");
           
        }
           } catch (Exception ex) {
               System.out.println("erreur" + ex.getMessage());
           }
        return p;
           
       }
       
       public ObservableList<String> getNomAssisstant(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select * from  utilisateur where role = 'assisstant' and status = 'disponible';";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add(rs.getString("nom")+" "+rs.getString("prenom"));
                //listnom.add( rs.getString("idutilisateur"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }

    
}
