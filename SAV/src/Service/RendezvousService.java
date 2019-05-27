/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDBcon;
import entites.Reclamation;
import entites.RendezVous;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
/**
 *
 * @author pc hp
 */
public class RendezvousService {
     Connection cnx;
    private Object sqlDate;
    
    public RendezvousService() throws SQLException {
       cnx = MyDBcon.getInstance().getCnx();
       
        
    }
  public String aujourdhui() {
     return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
}

    public int ajouterAlaBaseRendezvous(RendezVous ren)throws SQLException, ParseException  {
        int rs=0;
          String format = "dd/MM/yy H:mm:ss"; 

java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
java.util.Date date = new java.util.Date(); 

             java.util.Date date2=new java.sql.Date(ren.getDaterendezvous().getTime());
            
            
             String req = "INSERT INTO `rendezvous`( `idutilisateur`, `sujet`, `lieu`, `daterendezvous`,`etat`) VALUES (?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,ren.getIdutilisateur());
             pstm.setString(2,ren.getSujet());
             pstm.setString(3,ren.getLieu());
             pstm.setDate(4,new java.sql.Date(ren.getDaterendezvous().getTime()));
             pstm.setInt(5,ren.getEtat());
             if (date.compareTo(date2)< 0) {
            rs= pstm.executeUpdate();
         } 
              
                     return rs;

    }
    
    public  void modifierRendezVous(RendezVous ren,int idren,String sujet,String lieu,Date daterendezvous)throws SQLException  {
         try {
              String format = "dd/MM/yy H:mm:ss"; 
              java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
              java.util.Date date = new java.util.Date(); 
              java.util.Date date2=new java.sql.Date(ren.getDaterendezvous().getTime());
             String req = "UPDATE `rendezvous` SET `sujet`=?,`lieu`=?,`daterendezvous`=? WHERE `idrendezvous`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1,sujet);
             pstm.setString(2,lieu);
             pstm.setDate(3,daterendezvous);
             pstm.setInt(4,idren);
            if (date.compareTo(date2)< 0) {

             pstm.executeUpdate();
                
         }} catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
         
    }
    public  void supprimerRendezVous(RendezVous r) throws SQLException {
        
             
       
             String req = "UPDATE `rendezvous` SET `etat`=1 WHERE `idrendezvous`=?";
          PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,r.getIdrendezvous());
             pstm.executeUpdate();
             
         
    }
    

    public ArrayList<RendezVous> getAllRendezVouss() throws SQLException {
       ArrayList<RendezVous> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `rendezvous`";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idrendezvous= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
            String sujet = resultat.getString("sujet");
           String lieu= resultat.getString("lieu");
           Date daterendezvous= resultat.getDate("daterendezvous");
           int etat = resultat.getInt("etat");
          
           retour.add(new RendezVous(idrendezvous,idutilisateur,sujet,lieu,daterendezvous,etat));
            
        }
            
        return retour;
    }
    
     public ArrayList<RendezVous> getRendezVousTraite() throws SQLException {
       ArrayList<RendezVous> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM `rendezvous` WHERE `etat`=0";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idrendezvous= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
            String sujet = resultat.getString("sujet");
           String lieu= resultat.getString("lieu");
           Date daterendezvous= resultat.getDate("daterendezvous");
           int etat = resultat.getInt("etat");
          
           retour.add(new RendezVous(idrendezvous,idutilisateur,sujet,lieu,daterendezvous,etat));
            
        }
            
        return retour;
    }
      public ArrayList<RendezVous> rechercheRendezVous(String lieuu) throws SQLException {
       ArrayList<RendezVous> retour = new ArrayList<>();
       Statement stm = cnx.createStatement();
        String req = "SELECT * FROM RendezVous WHERE `lieu` LIKE'%"+lieuu+"%'AND  `etat`=0 ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
           int idrendezvous= resultat.getInt(1);
           int idutilisateur= resultat.getInt(2);
            String sujet = resultat.getString("sujet");
           String lieu= resultat.getString("lieu");
           Date daterendezvous= resultat.getDate("daterendezvous");
           int etat = resultat.getInt("etat");
          
           retour.add(new RendezVous(idrendezvous,idutilisateur,sujet,lieu,daterendezvous,etat));
        }
            
        return retour;
    }

    
        
    
    
}
