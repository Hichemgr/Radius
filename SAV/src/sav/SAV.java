/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sav;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import entites.Question;
import entites.Reclamation;
import entites.RendezVous;
import entites.Vote;
import entites.Reponse;
import entites.Produit;
import Service.ProduitService;

import Service.QuestionService;
import Service.ReclamationService;
import Service.RendezvousService;
import Service.VoteService;
import Service.ReponseService;
import Utils.MyDBcon;
import java.text.ParseException;



/**
 *
 * @author pc hp
 */
public class SAV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        
        
      ReclamationService rs= new ReclamationService();
        Reclamation rec = new Reclamation("sujet","contenu");
       
        RendezvousService rens= new RendezvousService();
        java.sql.Date daterendezvous=new java.sql.Date(119,3,2);
        RendezVous ren = new RendezVous("sujet","lieu",daterendezvous);
        
        QuestionService qs= new QuestionService();
        Question q = new Question("contenu");
 
         ReponseService reps= new ReponseService();
        Reponse rep = new Reponse("contenu");
        
        ProduitService pr =new ProduitService();
                
        java.sql.Date daterende=new java.sql.Date(119,3,2);
        Produit p =new Produit( "hh", 2, 3, 4, "nom", daterende);
    
        VoteService vs= new VoteService();
        Vote v = new Vote(2);
        
                          //-------------- Reclamation----------------------------//
        
        // rs.ajouterAlaBaseReclamation(rec);
      //  rs.modifierReclamation(10,"sujetsu","cooontenu");
       // rs.supprimerReclamation(14);
       // rs.rechercheReclamation(118);
        ArrayList<Reclamation> recherche=rs.rechercheReclamation("jj");
        //recherche.forEach(e->System.out.println(e));

        ArrayList<Reclamation> reclamations = rs.getReclamationsTraite();
        reclamations.forEach(e->System.out.println(e));
        
        
        
                          //-------------- RendezVous----------------------------//

        // rens.ajouterAlaBaseRendezvous(ren);
        //rens.modifierRendezVous(ren,12, "hello", "cava", daterendezvous);
       // rens.supprimerRendezVous(14);
        rens.rechercheRendezVous(null);
           ArrayList<RendezVous> RendezVos = rens.rechercheRendezVous(null);
       //RendezVos.forEach(e->System.out.println(e));
        
        ArrayList<RendezVous> RendezVouss = rens.getRendezVousTraite();
      // RendezVouss.forEach(e->System.out.println(e));
     
                          //-------------- Questions----------------------------//


    // qs.ajouterAlaBaseQuestion(q);
        //qs.SupprimerQuestion(7);
       // qs.modifierQuestion(q);
        
        ArrayList<Question> Questions=qs.getQuestionsVisible();
       // Questions.forEach(e->System.out.println(e));
         ArrayList<Question> Quests=qs.afficherQuestionsComplet();
     //  Quests.forEach(e->System.out.println(e));

        
                              //-------------- Reponse----------------------------//

     
      // reps.ajouterAlaBaseReponse(rep);
       // reps.modifierReponse("modcontenu",4);
      //  reps.supprimerReponse(4);
        
        ArrayList<Reponse> Reponses = reps.getAllReponses();
       // Reponses.forEach(e->System.out.println(e));
        
                             //-------------- Votes----------------------------//


       // vs.ajouterAlaBaseVote(v);
        //vs.supprimeridvote(1);
        //vs.nbrVote1();
       // vs.nbrVote0();
        //vs.nbrVote3();
        //vs.nbrVote2();
       // vs.nbrVote();
        
        ArrayList<Vote> Votes = vs.getAllVotes();
        //Votes.forEach(e->System.out.println(e));
        
        
    }
    
}
