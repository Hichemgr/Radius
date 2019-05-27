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
import com.mycompany.Entite.Livreur;
import java.util.Date;

/**
 *
 * @author seifeddinebenfraj
 */
public class ServiceLivreur {
    public void ajoutLivreur(Livreur ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/newLivreur?nom="+ta.getNom()+"&prenom="+ta.getPrenom()+ "&cin=" + ta.getCin();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Livreur> parseListLivreurJson(String json) {

        ArrayList<Livreur> listLivreurs = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

           
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Livreur e = new Livreur();
          
                float cin = Float.parseFloat(obj.get("cin").toString());
                float id_livreur = Float.parseFloat(obj.get("idLivreur").toString());

                e.setId_livreur((int) id_livreur);
                e.setCin((int) cin);
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("prenom").toString());
                
                
                System.out.println(e);
                listLivreurs.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listLivreurs);
        return listLivreurs;

    }
    
    
    ArrayList<Livreur> listLivreurs = new ArrayList<>();
    
    public ArrayList<Livreur> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/allLivreur");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivreur ser = new ServiceLivreur();
                listLivreurs = ser.parseListLivreurJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivreurs;
    }
    
    ArrayList<Livreur> listLivreurs1 = new ArrayList<>();
    
    public ArrayList<Livreur> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/allLivreurDispo");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivreur ser = new ServiceLivreur();
                listLivreurs1 = ser.parseListLivreurJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivreurs1;
    }
    
    public void supprimerLivreur(int idLivreur)
    {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/deleteLivreur/"+idLivreur;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    
    }
    
    public void modifierLivreur(Livreur ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/modifierLivreur?idLivreur="+ta.getId_livreur()+"&nom="+ta.getNom()+"&prenom="+ta.getPrenom()+ "&cin=" + ta.getCin();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
