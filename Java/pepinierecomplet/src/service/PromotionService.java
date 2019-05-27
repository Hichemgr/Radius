/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import GRAPHE.PromotionUserController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entite.MyDBcon;
import entite.Promotion;
import entite.Produit ;
import entite.utlisteur ; 
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
/**
 *
 * @author ASUS
 */
public class PromotionService {
       Connection cnx;
    
    public PromotionService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        ComboBox comboobox=new ComboBox()  ; 
                final ObservableList options = FXCollections.observableArrayList() ;
    }
    public  int ajouterAlaBase(Promotion p,Produit po)throws SQLException {
           int sr=0 ; 
              String format = "dd/MM/yy H:mm:ss"; 

java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
java.util.Date date = new java.util.Date(); 

             java.util.Date date1=new java.sql.Date(p.getDatedebut().getTime());
                          java.util.Date date2=new java.sql.Date(p.getDatefin().getTime());

             
             String req = "INSERT INTO `promotion`(`nom`, `datedebut`, `datefin`, `pourcentage`,`nomproduit`) VALUES (?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,p.getNom());
             pstm.setDate(2,p.getDatedebut());
             pstm.setDate(3,p.getDatefin());
             pstm.setFloat(4,p.getPourcentage());
             pstm.setString(5,po.getNomproduit());

             
             
             
            sr= pstm.executeUpdate();
            
            return sr ; 
        
         }
        

            
    
    
    
        public ArrayList<Promotion> getAllPromotion() throws SQLException {
       ArrayList<Promotion> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM promotion ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           String nom = resultat.getString("nom");
           Date datedebut=resultat.getDate("datedebut") ; 
           Date datefin=resultat.getDate("datefin") ;
           int pourcentage= resultat.getInt("pourcentage");
           String nomproduit = resultat.getString("nomproduit");
           Float nouveauprix = resultat.getFloat("nouveauprix") ;
           retour.add(new Promotion(nom, datedebut, datefin, pourcentage, nomproduit, nouveauprix));
            
        }
            
        return retour;
    }
        
         public ArrayList<Promotion> getAllPromotionTrier() throws SQLException {
       ArrayList<Promotion> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM promotion ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idpromotion= resultat.getInt(1);
           String nom = resultat.getString("nom");
           Date datedebut=resultat.getDate("datedebut") ; 
           Date datefin=resultat.getDate("datefin") ;
           int pourcentage= resultat.getInt("pourcentage");
           retour.add(new Promotion(idpromotion,nom,datedebut,datefin,pourcentage));
            
        }
           retour.sort((a,b)->a.getNom().compareTo(b.getNom())) ; 
        return retour;
    }
         /*
        public  void modifier(int idpromotion,String nom,Date datedebut,Date datefin,int pourcentage) {
         try {
             
             System.out.println("modif");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "UPDATE `promotion` SET `nom`='"+nom+"',`datedebut`='"+datedebut+"',`datefin`='"+datefin+"',`pourcentage`='"+pourcentage+"'  WHERE `idpromotion`= '"+idpromotion+"'";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        */
 
   
        
         public  int supprimer(String nom) throws SQLException {
         int sr=0 ; 
             
             System.out.println("suppression");
             Statement stm = cnx.createStatement();
             //String req = "INSERT INTO `panier`( `idpanier`, `idutilisateur` ,`etat` ) VALUES ('"+p.getIdpanier()+"','"+p.getIdutilisateur()+"','"+p.getEtat()+"')";
             String req = "DELETE FROM `promotion` WHERE `nom`= '"+nom+"' ";
            sr= stm.executeUpdate(req);
            return sr ;
        
    }

    public int modifier( String nom, java.util.Date datedebut, java.util.Date datefin, int pourcentage,String nomproduit) throws SQLException {
        
           int sr=0 ;   
             System.out.println("Modification");
             Statement stm = cnx.createStatement();
             String req = "UPDATE `promotion` SET   `datedebut`='"+datedebut+"' , `datefin`='"+datefin+"' , `pourcentage`='"+pourcentage+"', `nomproduit`='"+nomproduit+"' where nom='"+nom+"' ";
           sr=  stm.executeUpdate(req);
           return sr ; 
        
    }
    
      public  ArrayList<Promotion> FindPromotion(String rech) throws SQLException  {
       ArrayList<Promotion> listprom = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `promotion` where `idpromotion` Like '%"+rech+"%' or `nom` Like '%"+rech+"%' or `datedebut` Like '%"+rech+"%' or `datefin` Like '%"+rech+"%'  or `pourcentage`Like '%"+rech+"%'or `nomproduit`Like '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
      while(resultat.next())
        {
         int idpromotion= resultat.getInt("idpromotion");
            String nom= resultat.getString("nom");
              Date datedebut= resultat.getDate("datedebut");
              Date datefin= resultat.getDate("datefin");
              int pourcentage= resultat.getInt("pourcentage");
              
           listprom.add(new Promotion(idpromotion,nom,datedebut,datefin,pourcentage));
            }
     listprom.forEach(e->System.out.println(e));
 
      return listprom;
    } 

    public void supprimer(Promotion po) {
        
    }
    /*public void fillcombobox(){
        ComboBox comboBox=new ComboBox(options) ; 
         try {
           Statement stm;
           
           stm = cnx.createStatement();
           
           String req = "select nomproduit from produit ";
           ResultSet resultat = stm.executeQuery(req);
           while(resultat.next()){
               options.add(resultat.getString("nomproduit")) ;
               
               stm.close();
               resultat.close();
               
               
               
           }  } catch (SQLException ex) {
           Logger.getLogger(PromotionUserController.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    */
    public ObservableList<String> getNomproduit(){
        ObservableList<String> listnom = FXCollections.observableArrayList();
        try {
            Statement st = cnx.createStatement();
            String req = "select nomproduit from  produit ;";
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {
               
               
                listnom.add( rs.getString("nomproduit")) ;
            }

            return listnom;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return null;
        }
    }
  public float  getPrixProduit(String c,int pourcentage){
       float prix=0 ;
       
      

        try {
            Statement st = cnx.createStatement();
            String req = "select prix from  produit where `nomproduit`='"+c+"'" ;
            ResultSet rs = st.executeQuery(req); //retourne un résulat

            while (rs.next()) {    
                prix=rs.getFloat(1); 
            }
            float nvprix=prix-((prix*pourcentage)/100) ; 
         //   System.out.println(nvprix);
            return nvprix ; 
           
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return 0;
        }
  }
      
        
  /*  public void setnouveauprix(String nom ) throws SQLException
    {  
        PromotionService pa =new PromotionService() ; 
           float nouveauprix = pa.CalculerPrix(); 
        try {
        String req ="UPDATE promotion SET `nouveauprix`='"+nouveauprix+"' WHERE `nom`='"+nom+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    */
    
     public  void Envoyera(utlisteur u)throws SQLException {
           try {
             
             String req = "INSERT INTO `send`(`adressemail`, `telephone`) VALUES (?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,u.getAdressemail());
             pstm.setInt(2,u.getTelephone());
             
             
           
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
     
     
      public ArrayList<utlisteur> getAllUser() throws SQLException {
       ArrayList<utlisteur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           
           String adressemail = resultat.getString("adressemail");
            int telephone = resultat.getInt("telephone");
           
           retour.add(new utlisteur(adressemail,telephone)) ; 
            
        }
            
        return retour;
    }
    public void setNouveauprix(Float prix,String nom)
    {
        try {
        String req ="UPDATE promotion SET `nouveauprix`='"+prix+"' WHERE `nom`='"+nom+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    }

   
    
     
    
   


    
    
    
   


    


