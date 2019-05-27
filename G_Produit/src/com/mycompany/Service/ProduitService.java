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
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author raedm
 */
public class ProduitService {
     public void ajoutProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        float prix=p.getPrix_prod();
        int i=0;
         String price = Float.toString(prix);
        String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        i++;
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
       
        
    }
 public ArrayList<Produit> parseListProduit(String json) {

        ArrayList<Produit> names = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Produit p = new Produit();
               
     p.setNom_prod(obj.get("nomproduit").toString());
               
                System.out.println(p);
                names.add(p);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(names);
        return names;

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
                
                float idprod = Float.parseFloat(obj.get("idproduit").toString()); 
                p.setRef_prod((int) idprod);
                
                p.setNom_prod(obj.get("nomproduit").toString());
               
               float prix = Float.parseFloat(obj.get("prix").toString()); 
                p.setPrix_prod((int)prix);
                
               float quantite = Float.parseFloat(obj.get("quantite").toString()); 
                p.setQuantite_prod((int) quantite);
                
                 float note = Float.parseFloat(obj.get("note").toString()); 
                p.setRating_prod((int) note);
                
                p.setSaison(obj.get("saison").toString());
                p.setDescription_prod(obj.get("description").toString());
               p.setImagep(obj.get("imagep").toString());
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
    public ArrayList<Produit> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF/web/app_dev.php/produit/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService pser = new ProduitService();
                listProduit = pser.parseListProduitJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduit;
    }
    ArrayList<Produit> names = new ArrayList<>();
     public ArrayList<Produit> ProductName(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SMF/web/app_dev.php/produit/ProductName");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService pser = new ProduitService();
                names = pser.parseListProduit(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return names;
    }
    public ArrayList<Produit> find(int id){       
        ConnectionRequest con = new ConnectionRequest();
        Produit p= new Produit();
        String Url = "http://localhost/SMF/web/app_dev.php/produit/find/"+id;// création de l'URL
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService pser = new ProduitService();
                listProduit = pser.parseListProduitJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println("Here"+listProduit);
        return listProduit;
        
    }
    public void supprimerProduit(int id) {
        Produit p=new Produit();
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        float prix=p.getPrix_prod();
         String price = Float.toString(prix);
        String Url = "http://localhost/SMF/web/app_dev.php/produit/supprimerProdMob/"+id;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
//    public void rechProduit(int id) {
//      
//        Produit p=new Produit();
//        ProduitService per=new ProduitService();
//        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
//        String Url = "http://localhost/SMF/web/app_dev.php/produit/find/"+id;// création de l'URL
//        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
//
//        con.addResponseListener((e) -> {
//             
//            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
//            System.out.println(str);//Affichage de la réponse serveur sur la console
//            
//        });
//        
//        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
//       
//    }
    
        public ArrayList<Produit>rech(String rech,Produit prod){       
        ConnectionRequest con = new ConnectionRequest();
        Produit p= new Produit();
        String Url = "http://localhost/SMF/web/app_dev.php/produit/findByName/"+rech;// création de l'URL
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ProduitService pser = new ProduitService();
                listProduit = pser.parseListProduitJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println("Here"+listProduit);
        return listProduit;
        
    }
 public void  mail(String mailto,String sujet,String message){
 Message m = new Message(" "+message);
Display.getInstance().sendMessage(new String[]{mailto},sujet,m);
 }
 public void modifierProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        float prix=p.getPrix_prod();
        int i=0;
         String price = Float.toString(prix);
        String Url = "http://localhost/SMF/web/app_dev.php/produit/modifierProdMob?idproduit="+p.getRef_prod()+"&nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        i++;
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
       
        
    }

}
