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
import com.mycompany.Entite.Vote;
import com.mycompany.Entite.Vote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc hp
 */
public class ServiceVote {

    public void ajoutVote(Vote ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/ajoutVoteMob?nomproduit=" + ta.getNomproduit() + "&note=" + ta.getNote() + "&commentaire=" + ta.getCommentaire();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public float CountVote() {
        float total = 0;
        ArrayList<Float> notes;
        notes = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/CountVoteMob";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    events.put("notes", events.remove("root"));
                    // System.out.println("events: " + events);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("notes");

                    for (Map<String, Object> obj : list) {

                        // Evenement event = new Evenement();
                        float moy = Float.parseFloat(obj.get("Moyenne").toString());

                        notes.add(moy);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        for (int i = 0; i < notes.size(); i++) {

            total += notes.get(i);
        }
        return total;
    }

    public ArrayList<Vote> parseListVoteJson(String json) {

        ArrayList<Vote> listVotes = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> Votes = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) Votes.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Vote e = new Vote();

                float idvote = Float.parseFloat(obj.get("idvote").toString());
                float idutilisateur = Float.parseFloat(obj.get("idutilisateur").toString());
                float note = Float.parseFloat(obj.get("note").toString());

                //e.setIdreclamation((int) idreclamation);
                e.setNote((int) note);
                //e.setEtat((int) etat);
                e.setNomproduit(obj.get("nomproduit").toString());
                e.setCommentaire(obj.get("commentaire").toString());
                //e.setCommentaire(obj.get("commentaire").toString());

                System.out.println(e);

                listVotes.add(e);

            }

        } catch (IOException ex) {
        }

        /*
         A ce niveau on a pu récupérer une liste des tâches à partir
         de la base de données à travers un service web
        
         */
        System.out.println(listVotes);
        return listVotes;

    }

    ArrayList<Vote> listVotes = new ArrayList<>();

    public ArrayList<Vote> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF1/web/app_dev.php/afficherVoteMob");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceVote ser = new ServiceVote();
                listVotes = ser.parseListVoteJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVotes;
    }

    public void ModifierVote(Vote ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SMF1/web/app_dev.php/modifierVote?idvote=" + ta.getIdvote() + "&nomproduit=" + ta.getNomproduit() + "&note=" + ta.getNote() + "&commentaire=" + ta.getCommentaire();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
