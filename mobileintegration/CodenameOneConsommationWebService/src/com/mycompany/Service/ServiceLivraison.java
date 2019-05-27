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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.Entite.Livraison;
import java.util.Date;

/**
 *
 * @author seifeddinebenfraj
 */
public class ServiceLivraison {
    public void ajoutLivraison(Livraison ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/livraison/new?nomclient="+ta.getNomClient()+"&Adresse="+ta.getAdresse()+"&montant="+ta.getMontant();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Livraison> parseListLivraisonJson(String json) {

        ArrayList<Livraison> listLivraisons = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

           
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Livraison e = new Livraison();
                
                float ID_Livraison = Float.parseFloat(obj.get("idLivraison").toString());
                float Montant = Float.parseFloat(obj.get("montant").toString());
                //float Etat = Float.parseFloat(obj.get("etat").toString());
                
                e.setID_Livraison((int) ID_Livraison);
                //e.setEtat((int) Etat);
                e.setMontant((int) Montant);
                e.setAdresse(obj.get("adresse").toString());
                
                
                System.out.println(e);
                listLivraisons.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listLivraisons);
        return listLivraisons;

    }
    
    
    ArrayList<Livraison> listLivraisons = new ArrayList<>();
    
    public ArrayList<Livraison> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/all5");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivraison ser = new ServiceLivraison();
                listLivraisons = ser.parseListLivraisonJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivraisons;
    }
    
    ArrayList<Livraison> listLivraisons1 = new ArrayList<>();
    public ArrayList<Livraison> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/allLivraisonDispo");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivraison ser = new ServiceLivraison();
                listLivraisons1 = ser.parseListLivraisonJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivraisons1;
    }
    
    public void supprimerLivraison(int idLivraison)
    {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/deleteliv/"+idLivraison;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    
    }
    
    public void modifierLivraison(Livraison ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/modifier?idLivraison="+ta.getID_Livraison()+"&Montant="+ta.getMontant()+"&Adresse="+ta.getAdresse()+ "&Etat=" + ta.getEtat();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public void AffecterLivreurLivraisons(int ID_Livraison, String nomLivreur) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/AffecterLivreurLivraisons/"+ID_Livraison+"/"+nomLivreur;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public void TerminerLivraison(int ID_Livraison, String nomLivreur) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/TerminerLivraisons/"+ID_Livraison+"/"+nomLivreur;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
