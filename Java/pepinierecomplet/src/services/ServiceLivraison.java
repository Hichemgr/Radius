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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modals.livraison;
import utile.MyDBcon;

/**
 *
 * @author seifeddinebenfraj
 */
public class ServiceLivraison {
    
    
  
    Connection cnx;
        
        
     public ServiceLivraison() throws SQLException  {
        this.cnx = MyDBcon.getInstance().getCnx();
     
    }
    
    public int ajouterLivraison(livraison l)
    {
        int rs=0;
        String format = "DD/MM/YY H:MM:SS" ;
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        java.util.Date date2 = new java.sql.Date(l.getDate().getTime());
        try {
       String   query = "insert into  livraison (idcommande,Montant,Etat,Date,Adresse,Longitude,Latitude,id_User,nomClient,nomLivreur) values (?,?,?,?,?,?,?,?,?,?)";
       
         PreparedStatement   st = cnx.prepareStatement(query);
            
            st.setInt(1,l.getID_Panier());
            st.setFloat(2, l.getMontant());
            st.setInt(3, l.getEtat());
            st.setDate(4, new java.sql.Date(l.getDate().getTime()));
            st.setString(5, l.getAdresse());
            st.setDouble(6, l.getLongitude());
            st.setDouble(7,l.getLatitude());
            st.setInt(8,l.getId_User());
            st.setString(9, " ");
            st.setString(10, " ");
            
            
            
            
                st.executeUpdate();
            
            
            
            System.out.println("Livraison ajoutée.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs;
        }
    
    public int modiferLivraison(livraison b)
    {
        
        int rs=0;
        String format = "DD/MM/YY H:MM:SS" ;
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        java.util.Date date2 = new java.sql.Date(b.getDate().getTime());
        try {
            PreparedStatement pt = cnx.prepareStatement("update livraison set Montant = ?,Etat = ?,Date = ?,Adresse = ?,Longitude =  ?,Latitude = ?,nomLivreur = ?  where id_Livraison =?");
           
            pt.setFloat(1,b.getMontant());
            pt.setInt(2,b.getEtat());
            pt.setDate(3, (Date) b.getDate());
            pt.setString(4,b.getAdresse());
            pt.setDouble(5,b.getLongitude());
            pt.setDouble(6, b.getLatitude());
            pt.setString(7, b.getNomLivreur());
            pt.setInt(8,b.getID_Livraison());
            
            
            if(date.compareTo(date2)<0){
                rs=pt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }
        return rs;
    }

 public List<livraison> listerLesLivraisons() {
        List<livraison> myList = new ArrayList<>();

        try { 
           String query = "SELECT * from livraison"; 
          PreparedStatement st = cnx.prepareStatement(query);
  
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                livraison p2 = new livraison();
                 int id = rs.getInt(1);
                p2.setID_Livraison(id);
                p2.setID_Pan(rs.getInt(2));
                p2.setMontant(rs.getInt(3));
                p2.setEtat(rs.getInt(4));
                p2.setDate(rs.getDate(5));
                p2.setAdresse(rs.getString(6));
                p2.setLongitude(rs.getDouble(7));
                p2.setLatitude(rs.getDouble(8));
                p2.setId_Us(rs.getInt(9));
                p2.setNomLivreur(rs.getString(11));
    /*User u = new User(rs.getInt(11));
          p2.setID_user(u);     */   
                myList.add(p2);

            }}catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
        return myList;
    }
 
  public List<livraison> LesLivraisonsParUser(int id) {
        List<livraison> myList = new ArrayList<>();
      

        try { 
           String query = "SELECT * from livraison where id_User="+id;
             Statement st = cnx.prepareStatement(query); 
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
               livraison p2 = new livraison();
                 int idl = rs.getInt(1);
                p2.setID_Livraison(idl);
                p2.setID_Pan(rs.getInt(2));
                p2.setMontant(rs.getInt(3));
                p2.setEtat(rs.getInt(4));
                p2.setDate(rs.getDate(5));
                p2.setAdresse(rs.getString(6));
                p2.setLongitude(rs.getDouble(7));
                p2.setLatitude(rs.getDouble(8));
                p2.setId_Us(rs.getInt(9));
    /*User u = new User(rs.getInt(11));
          p2.setID_user(u);     */   
                myList.add(p2);
            }}catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
        return myList;
    }
 public float Montant()
           {float p=0;
        try {
            String query = "SELECT montant from commande where id_commande=1";
            Statement stm=cnx.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())  {
            p=rs.getFloat("montant");
           
        }} catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
        }
 
 public String Adresse(String nom)
           {String p="";
        try {
            String query = "SELECT * from utilisateur where nom="+nom;
            Statement stm=cnx.createStatement();
            
            ResultSet rs = stm.executeQuery(query);
          while(rs.next())  {
            p=rs.getString("adresse");
           
        }} catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
        }
 
  
  
   public  void SupprimerLivraison(int id)
    {
        try {
            PreparedStatement pt = cnx.prepareStatement("delete  from livraison  where id_Livraison =?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            
        }

}
   public  ArrayList<livraison> FindLivraison(String rech) throws SQLException  {
       ArrayList<livraison> listLiv = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `livraison` where `ID_Livraison` Like '%"+rech+"%' or `Montant` Like '%"+rech+"%' or`Etat` Like '%"+rech+"%' or `Date` Like '%"+rech+"%'  or `Adresse`Like '%"+rech+"%' or `nomLivreur` Like '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         int ID_Livraison= resultat.getInt("ID_Livraison");
            float Montant= resultat.getFloat("Montant");
              int Etat= resultat.getInt("Etat");
              Date Date= resultat.getDate("Date");
              String Adresse= resultat.getString("Adresse");
              String nomLivreur = resultat.getString("nomLivreur");
              
              
           listLiv.add(new livraison(ID_Livraison,Montant,Etat,Date,Adresse,nomLivreur));
            }
     listLiv.forEach(e->System.out.println(e));
 
      return listLiv;
    }
   
   public ObservableList<String> getNomClient(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select nom from  utilisateur where role = 'client';";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("nom"));
                //listnom.add( rs.getString("idutilisateur"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
   
   public ObservableList<String> getNomLivreur(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select nom from  utilisateur where role = 'livreur' and status = 'disponible';";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("nom"));
                //listnom.add( rs.getString("idutilisateur"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
   
   public ObservableList<String> getIdLivraison(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select ID_Livraison from livraison where Etat = 0;";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("ID_Livraison"));
                //listnom.add( rs.getString("idutilisateur"));
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
   
   
   
   
   public void AffecterLivreur(int id, String nom){
       try {
        String req ="UPDATE livraison SET `nomLivreur`='"+nom+"' WHERE `ID_Livraison`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public void StatusLivreur(String id, String nom){
       try {
        String req ="UPDATE utilisateur SET `status`='"+nom+"' WHERE `nom`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public void EtatLivraison(int id, int nom){
       try {
        String req ="UPDATE livraison SET `Etat`='"+nom+"' WHERE `ID_Livraison`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public void EtatLivraisonLivreur(String id, int nom){
       try {
        String req ="UPDATE livraison SET `Etat`='"+nom+"' WHERE `nomLivreur`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public String getAdresse(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur WHERE `status`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("adresse");
        }
        System.out.println(s);
        return s;
    }
   
   public void terminerLivraison(int id){
       try {
           String p = " ";
        String req ="UPDATE livraison SET `Etat`= 2, `nomLivreur` = '"+p+"'  WHERE `ID_Livraison`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public void terminerLivreur(String nom){
       try {
          // String p = " ";
        String req ="UPDATE utilisateur SET `status`= 'disponible' WHERE `nom`='"+nom+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public int rechercheridutili() throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur WHERE `status`='connecter' ";
        ResultSet resultat = stm.executeQuery(req);
         while(resultat.next())
         {
             return resultat.getInt("idutilisateur");
         }
         
           return 0;
         
         
    }
   
   public float getprixtotale(int id) throws SQLException {
       //  ArrayList<produit> retour = new ArrayList<>();
        PreparedStatement pt = cnx.prepareStatement("SELECT produit.prix,ligneproduit.quantite FROM ligneproduit ,`produit` ,`panier` WHERE panier.idpanier IN (select idpanier from panier where idutilisateur=?)and panier.idpanier=ligneproduit.idpanier and produit.idproduit=ligneproduit.idproduit and panier.etat=0");
        pt.setInt(1, id);
        ResultSet resultat = pt.executeQuery();
        float prixtotale=0;
        while (resultat.next()) {
            //int id= resultat.getInt(1);
            //  int id_prod = resultat.getInt("id_prod");
            //String nom = resultat.getString("nomproduit");
            
           
            //String description = resultat.getString("description");
            float prix = resultat.getFloat("prix");
            int quantite= resultat.getInt("quantite");
          
           prixtotale+=quantite*prix;
            //retour.add(new produit(description, quantite, prix));
           

        }
          return prixtotale;
          
        
    }
   
   public void LivreurAutomatique(String nom,int id){
       try {
           String p = " ";
        String req ="UPDATE livraison SET `nomLivreur`= '"+nom+"'  `Etat`= 1  WHERE `ID_Livraison`='"+id+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   
   public int getIdLivraisonNomLivreur(String mail) throws SQLException{
       int s=0;
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM livraison WHERE `nomLivreur`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getInt("ID_Livraison");
        }
        System.out.println(s);
        return s;
    }
    
}