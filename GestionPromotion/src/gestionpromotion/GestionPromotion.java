/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpromotion;
import entite.Promotion;
import entite.Produit ; 
import java.sql.Date;
import java.util.ArrayList;
import service.PromotionService;
import java.sql.SQLException;
import entite.publicite ; 
import service.publiciteService ; 

/**
 *
 * @author ASUS
 */
public class GestionPromotion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SQLException {
        PromotionService ps= new PromotionService();
       java.sql. Date datedebut=new java.sql. Date(119,2,24) ; 
        java.sql.Date datefin=new java.sql. Date(120,12,06) ;
          Promotion p = new Promotion("Hiver",datedebut,datefin,20);
          Promotion p1 = new Promotion("H",datedebut,datefin,50);

          
        //ps.ajouterAlaBase(p);
              //  ps.ajouterAlaBase(p1);

        // ps.modifier(p, "hello", datedebut, datefin, 40);
        
         
          // ps.supprimer(147);
         ArrayList<Promotion> promotions = ps.getAllPromotion();
        promotions.forEach(e->System.out.println(e));
        // TODO code application logic here
                publiciteService pp= new publiciteService();

        Date datepub=new Date(2019,02,14) ;
        publicite pb=new publicite(88,"hohoh", "plante", datepub) ; 
                publicite pb1=new publicite(147,"hohodh", "plante", datepub) ; 

         
       // pp.ajouterAlaBase(pb1);
        //
        //pp.modifier(88, "hihih", "plante", datepub);
        
        //pp.supprimer(147);
          //ArrayList<publicite> publicites = pp.getAllPublicite();
       // publicites.forEach(e->System.out.println(e));
      // ps.CalculerPrix();
       
    }
    
}
