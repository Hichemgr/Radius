/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Produit;
import com.mycompany.Entite.Reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc hp
 */
public class ServiceReclamation {
    public void ajoutReclamation(Reclamation ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/ajoutReclamationMob?nomproduit="+ta.getnomproduit()+"&sujet="+ta.getSujet()+"&contenu="+ta.getContenu();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Reclamation> parseListReclamationJson(String json) {

        ArrayList<Reclamation> listReclamations = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

           
          
            Map<String, Object> Reclamations = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) Reclamations.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Reclamation e = new Reclamation();

                float idreclamation = Float.parseFloat(obj.get("idreclamation").toString());
                float idutilisateur = Float.parseFloat(obj.get("idutilisateur").toString());
                 float etat = Float.parseFloat(obj.get("etat").toString());

               e.setIdreclamation((int) idreclamation);
               // e.setIdutilisateur((int) idutilisateur);
                e.setEtat((int) etat);
                e.setNomproduit(obj.get("nomproduit").toString());
                e.setSujet(obj.get("sujet").toString());
                e.setContenu(obj.get("contenu").toString());
                //e.setCommentaire(obj.get("commentaire").toString());
                
                System.out.println(e);
                
                listReclamations.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listReclamations);
        return listReclamations;

    }
    
    
    ArrayList<Reclamation> listReclamations = new ArrayList<>();
    
    public ArrayList<Reclamation> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/afficherReclamationMob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation ser = new ServiceReclamation();
                listReclamations = ser.parseListReclamationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReclamations;
    }
     public ArrayList<Reclamation> getReclOui(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/AfficherOuiReclamationMob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation ser = new ServiceReclamation();
                listReclamations = ser.parseListReclamationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReclamations;
    }
      public ArrayList<Reclamation> getRecNon(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/AfficherNonReclamationMob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation ser = new ServiceReclamation();
                listReclamations = ser.parseListReclamationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReclamations;
    }
    
    public void supprimerReclamation(int idreclamation) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/SupprimerReclamationMob/" +idreclamation;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    public void ModifierReclamation(int idreclamation) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/ModifierReclamationMob/" +idreclamation;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    public ArrayList<Produit> parseListProduitJson(String json) {

        ArrayList<Produit> listProduit = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Produit p = new Produit();

                p.setNom_prod(obj.get("nomproduit").toString());
               
                System.out.println(p);
                
                listProduit.add(p);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listProduit);
        return listProduit;

    }

   ArrayList<Produit> listProduit = new ArrayList<>();
    public ArrayList<Produit> getListprod(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/afficherProd");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation pser = new ServiceReclamation();
                listProduit = pser.parseListProduitJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduit;
    }
   
}
