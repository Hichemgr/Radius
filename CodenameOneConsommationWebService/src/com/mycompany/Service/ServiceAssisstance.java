/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

/**
 *
 * @author ASUS
 */

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Assisstance;
import com.mycompany.Entite.Task;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServiceAssisstance {

    public void ajoutTask(Assisstance ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        ta.setId_client("6");
     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Assisstance/new?idClient="+ ta.getId_client()+"&idAssisstant="+ta.getId_assisstant()+"&dateass="+ta.getDateass()+"&type="+ta.getType();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public void login(String username,String mdp) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
      //  ta.setId_client("1");
     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
       // String Url = "http://localhost/slim/SMF1/web/app_dev.php/Assisstance/new?idClient="+ ta.getId_client()+"&idAssisstant="+ta.getId_assisstant()+"&dateass="+ta.getDateass()+"&type="+ta.getType();// création de l'URL
         con.setUrl("http://localhost/slim/SMF1/web/app_dev.php/loginm?username=" + username + "&password=" + mdp  );
    //    con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Assisstance> parseListTaskJson(String json) {

        ArrayList<Assisstance> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                //Task e = new Task();
                Assisstance a=new Assisstance();
                float id = Float.parseFloat(obj.get("idAssisstance").toString());

                a.setId_assisstance((int)id);
              
                a.setId_client(obj.get("idClient").toString());
                String b=(obj.get("idAssisstant").toString());
                String daate=(obj.get("dateass").toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                //Date date=null;
                try {
                   // date = sdf.parse("08/03/1988");
                    a.setDateass(sdf.parse(obj.get("dateass").toString()));
                    // java.sql.Date daatee=java.sql.Date.valueOf(daate);
                    //   float ide = Float.parseFloat(obj.get("dateass").toString());
                } catch (ParseException ex) {
                    
                }
               
                a.setType(obj.get("type").toString());
             
                System.out.println(a);
            //    System.out.println("njareeeeb  "+);
                
                listTasks.add(a);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<Assisstance> listTasks = new ArrayList<>();
    
    public ArrayList<Assisstance> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/slim/SMF1/web/app_dev.php/Assisstance/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // ServiceTask ser = new ServiceTask();
                ServiceAssisstance ser = new ServiceAssisstance();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     public void supprimerTask(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion

     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Assisstance/supprimerassisstance?idAssisstance="+id;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

       /* con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });*/
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public void modifTask(int id,String type) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion

     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Assisstance/modifierassisstance?idAssisstance="+id+"&type="+type;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

}

    
