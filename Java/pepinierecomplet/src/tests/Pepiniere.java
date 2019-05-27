/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modals.livraison;
import modals.assisstance;
import services.ServiceLivraison;
import services.ServiceAssisstance;

/**
 *
 * @author seifeddinebenfraj
 */
public class Pepiniere {

    public static void main(String[] args) throws SQLException {
        //livraison l1 = new livraison(5, 1200, 1, "2018-05-11", "rue", 12, 13, 2);
        java.sql.Date dateliv=new java.sql.Date(119, 10, 10);
        //livraison l1 = new livraison(1400, 0, dateliv, "khadijaabid");
        
        ServiceLivraison sl = new ServiceLivraison();
        //sl.ajouterLivraison(l1);
        
        //assisstance a1 = new assisstance(2, 4, "12-12-2019", "JJJ");
        
        //ServiceAssisstance sa1 = new ServiceAssisstance();
        //sa1.ajouterAssisstance(a1);
        //sa1.modifierAssisstance(a1);
        /*sa1.SupprimerAssisstance(1);
        
         livraison l2 = new livraison(21,1, 700, 2, "2017-09-11", "seifeddine", 1000, 146453, 2);
        ServiceLivraison s1 = new ServiceLivraison();
        //s1.ajouterLivraison(l2);
        //s1.modiferLivraison(l2);
        System.out.println("***********************toutes les livraisons******************************");
        List<livraison> myList1 = new ArrayList<>();
        myList1=s1.listerLesLivraisons();
          for(livraison b :myList1)
        {
            System.out.println(b);
        }
          
          System.out.println("***********************toutes les assisstances******************************");
        List<assisstance> myList3 = new ArrayList<>();
        myList3=sa1.listerLesAssisstances();
          for(assisstance b :myList3)
        {
            System.out.println(b);
        }
          
                     System.out.println("*********************** livraisons par user******************************");

           List<livraison> myList2 = new ArrayList<>();
        myList2=s1.LesLivraisonsParUser(2);
          for(livraison b :myList2)
        {
            System.out.println(b);
        }
          
          System.out.println("*********************** ASSISSTANCES par ASSISSTANT******************************");

           List<assisstance> myList4 = new ArrayList<>();
        myList4=sa1.LesLivraisonsParAssisstant(1);
          for(assisstance b :myList4)
        {
            System.out.println(b);
        }
          
          //s1.SupprimerLivraison(21);
          
          //s1.LesLivraisonsParUser(2);
          
    */
        
    
    }
   
}
