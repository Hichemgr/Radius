/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utile.MyDBcon;
import entite.utilisateur;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import utile.cryptpasswords;

/**
 *
 * @author Wadii Chamakhi
 */
public class utilisateurservice {

    Connection cnx;
    
    public utilisateurservice() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }

    public void ajouterutilisateur(utilisateur u) {
         try {
             
             System.out.println("connexion établie");
             Statement stm = cnx.createStatement();
             System.out.println(u.getMotdepasse());
             String req="INSERT INTO `utilisateur`(`cin`, `nom`, `prenom`, `motdepasse`, `adressemail`, `telephone`, `datecreation`, `status`, `role`, `photoprofil`, `nbpoint`,`adresse`) VALUES ('"+u.getCin()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getMotdepasse()+"','"+u.getAdressemail()+"','"+u.getTelephone()+"','"+u.getDatecreation()+"','"+u.getStatus()+"','"+u.getRole()+"','"+u.getPhotoprofil()+"','"+u.getNbpoint()+"','"+u.getAdresse()+"')";
             stm.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void ajouterutilisateur2(utilisateur u) {
         try {
             String req="INSERT INTO `utilisateur`(`cin`, `nom`, `prenom`, `motdepasse`, `adressemail`, `telephone`, `datecreation`, `status`, `role`, `nomcommerce`, `photoprofil`, `nbpoint`,`adresse`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
          //   String req = "INSERT INTO `personne`( `nom`, `prenom`) VALUES (?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, u.getCin());
             pstm.setString(2, u.getNom());
             pstm.setString(3, u.getPrenom());
             pstm.setString(4, u.getMotdepasse());
             pstm.setString(5, u.getAdressemail());
             pstm.setInt(6, u.getTelephone());
             pstm.setDate(7, u.getDatecreation());
             pstm.setString(8, u.getStatus());
             pstm.setString(9, u.getRole());
             pstm.setString(10, u.getNomcommerce());
             pstm.setString(11, u.getPhotoprofil());
             pstm.setInt(12, u.getNbpoint());
             pstm.setString(12,u.getAdresse());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<utilisateur> getAllutilisateur() throws SQLException, NoSuchAlgorithmException {
       ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
           int cin=resultat.getInt("cin");
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String motdepasse = resultat.getString("motdepasse");
           String adressemail = resultat.getString("adressemail");
           int telephone = resultat.getInt("telephone");
           Date datecreation = resultat.getDate("datecreation");
           String status = resultat.getString("status");
           String role = resultat.getString("role");
          // String nomcommerce = resultat.getString("nomcommerce");
           String photoprofil = resultat.getString("photoprofil");
           int nbpoint = resultat.getInt("nbpoint");
           String adresse = resultat.getString("adresse");
           retour.add(new utilisateur(id,cin,nom,prenom,motdepasse,adressemail,telephone,datecreation,status,role,photoprofil,nbpoint,adresse));
            
        }
            
        return retour;
    }
    
       public  ArrayList<utilisateur> rechercheuser(String rech) throws SQLException, NoSuchAlgorithmException  {
       ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` where `cin` Like '%"+rech+"%' or `nom` Like '%"+rech+"%' or`prenom` Like '%"+rech+"%' or `role` Like '%"+rech+"%' or`adressemail`Like '%"+rech+"%' or `telephone`Like '%"+rech+"%' ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
           int cin=resultat.getInt("cin");
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String motdepasse = resultat.getString("motdepasse");
           String adressemail = resultat.getString("adressemail");
           int telephone = resultat.getInt("telephone");
           Date datecreation = resultat.getDate("datecreation");
           String status = resultat.getString("status");
           String role = resultat.getString("role");
          // String nomcommerce = resultat.getString("nomcommerce");
           String photoprofil = resultat.getString("photoprofil");
           int nbpoint = resultat.getInt("nbpoint");
            String adresse = resultat.getString("adresse");
           retour.add(new utilisateur(id,cin,nom,prenom,motdepasse,adressemail,telephone,datecreation,status,role,photoprofil,nbpoint,adresse));
            
        }
            
        return retour;
    }
    
    public void supprimerutilisateur(int cin)
    {
        try {
            
        String req ="DELETE FROM `utilisateur` WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void modifierutilisateur(int cin,String nom,String prenom,String motdepasse,String adressemail,int telephone,String photoprofil,String adresse)
    {
         try {
        String req ="UPDATE `utilisateur` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`adressemail`='"+adressemail+"',`telephone`='"+telephone+"',`photoprofil`='"+photoprofil+"',`adresse`='"+adresse+"' WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
   public boolean rechercherutilisateur(String mail,String mdp) throws SQLException, NoSuchAlgorithmException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
       String s="";
        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
               s = encryption.cryptme(mdp);

        String req = "SELECT * FROM `utilisateur` WHERE `adressemail`='"+mail+"' and `motdepasse`='"+s+"'";
        ResultSet resultat = stm.executeQuery(req);
         return resultat.next();
    }
    
    public void login(String mail,String mdp) throws NoSuchAlgorithmException
    {
        try {
             String s="";
        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
               s = encryption.cryptme(mdp);
        String req ="UPDATE `utilisateur` SET `status`='"+"connecter"+"' WHERE `adressemail`='"+mail+"' and `motdepasse`='"+s+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void activercompteutilisateur(int cin)
    {
        try {
        String req ="UPDATE `utilisateur` SET `status`='"+"on"+"' WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void desactivercompteutilisateur(int cin)
    {
        try {
        String req ="UPDATE `utilisateur` SET `status`='"+"off"+"' WHERE `cin`='"+cin+"'";
        //String req ="DELETE FROM `utilisateur` WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public ArrayList<utilisateur> getAllutilisateurtrier() throws SQLException, NoSuchAlgorithmException {
       ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
           int cin=resultat.getInt("cin");
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String motdepasse = resultat.getString("motdepasse");
           String adressemail = resultat.getString("adressemail");
           int telephone = resultat.getInt("telephone");
           Date datecreation = resultat.getDate("datecreation");
           String status = resultat.getString("status");
           String role = resultat.getString("role");
          // String nomcommerce = resultat.getString("nomcommerce");
           String photoprofil = resultat.getString("photoprofil");
           int nbpoint = resultat.getInt("nbpoint");
            String adresse = resultat.getString("adresse");
           retour.add(new utilisateur(id,cin,nom,prenom,motdepasse,adressemail,telephone,datecreation,status,role,photoprofil,nbpoint,adresse));
            
        }
        
          retour.sort((a,b)->a.getNom().compareTo(b.getNom()));
            return retour;    
    }
    
     public void modifierphotoutilisateur(int cin,String chemin)
    {
        try {
        String req ="UPDATE `utilisateur` SET `photoprofil`='"+chemin+"' WHERE `cin`='"+cin+"'";
        //String req ="DELETE FROM `utilisateur` WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
       public ArrayList<utilisateur> getutilisateurconnecter() throws SQLException, NoSuchAlgorithmException {
           String cinn="connecter";
       ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM utilisateur WHERE `status`='"+cinn+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int id= resultat.getInt(1);
           int cin=resultat.getInt("cin");
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String motdepasse = resultat.getString("motdepasse");
           String adressemail = resultat.getString("adressemail");
           int telephone = resultat.getInt("telephone");
           Date datecreation = resultat.getDate("datecreation");
           String status = resultat.getString("status");
           String role = resultat.getString("role");
          // String nomcommerce = resultat.getString("nomcommerce");
           String photoprofil = resultat.getString("photoprofil");
           int nbpoint = resultat.getInt("nbpoint");
            String adresse = resultat.getString("adresse");
           retour.add(new utilisateur(id,cin,nom,prenom,motdepasse,adressemail,telephone,datecreation,status,role,photoprofil,nbpoint,adresse));
            
        }
            
        return retour;
    }
       
         public String getetatcompte(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `adressemail`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("status");
        }
        System.out.println(s);
        return s;
    }
            public String getmdpuser(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
             mail="connecter";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `status`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("motdepasse");
        }
        System.out.println("fonctiooooooooon"+s);
        return s;
    }
          public void deconnexionutilisateur(String cin)
    {
        try {
        String req ="UPDATE `utilisateur` SET `status`='"+"on"+"' WHERE `status`='"+cin+"'";
        //String req ="DELETE FROM `utilisateur` WHERE `cin`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
          
              public String getmotdepasse(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `adressemail`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("motdepasse");
        }
        System.out.println(s);
        return s;
    }
                  public boolean getvalidtioncode(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `adressemail`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("codevalidation");
        }
        if(s.equals("ok"))
        return false;
        else
            return true;
    }
              
                public void setvalidationcode(String cin,String code)
    {
        try {
        String req ="UPDATE `utilisateur` SET `codevalidation`='"+code+"' WHERE `adressemail`='"+cin+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
                   public void setnewpass(String mdp,String mdpnew)
    {
        try {
        String req ="UPDATE `utilisateur` SET `motdepasse`='"+mdpnew+"' WHERE `motdepasse`='"+mdp+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
                
                 public boolean recherchercode(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `codevalidation`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
         return resultat.next();
    }
                 
                 public String getmailcode(String mail) throws SQLException {
       //ArrayList<utilisateur> retour = new ArrayList<>();
             String s="";
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `utilisateur` WHERE `codevalidation`='"+mail+"'";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          s= resultat.getString("adressemail");
        }
        System.out.println(s);
        return s;
    }
                  public void logincode(String mail)
    {
        try {
        String req ="UPDATE `utilisateur` SET `status`='"+"connecter"+"' WHERE `codevalidation`='"+mail+"'";
        PreparedStatement pstm = cnx.prepareStatement(req);
          pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(utilisateurservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
