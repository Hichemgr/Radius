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
import com.mycompany.Entite.Assisstant;
import com.mycompany.Entite.Conseil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceConseil {
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the ed
/**
 *
 * @author bhk
 */

    public void ajoutTask(Conseil ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
       // ta.setId_client("1");
     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Conseil/newconseil?type="+ ta.getType()+"&contenu="+ta.getContenu();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Conseil> parseListTaskJson(String json) {

        ArrayList<Conseil> listTasks = new ArrayList<>();

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
                Conseil a=new Conseil();
                float id = Float.parseFloat(obj.get("idConseil").toString());

                a.setId_conseil((int)id);
              
                a.setType(obj.get("type").toString());
                a.setContenu(obj.get("contenu").toString());
            
               // String b=(obj.get("prenom").toString());
          //      String daate=(obj.get("dateass").toString());
               
               
            //    a.setType(obj.get("type").toString());
             
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
    
    
    ArrayList<Conseil> listTasks = new ArrayList<>();
    
    public ArrayList<Conseil> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/slim/SMF1/web/app_dev.php/Conseil/allconseil");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // ServiceTask ser = new ServiceTask();
                ServiceConseil ser = new ServiceConseil();
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
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Conseil/supprimerconseil?idConseil="+id;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

       /* con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });*/
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public void modifTask(int id,String type,String contenu) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion

     //   String Url = "http://localhost//slim/SMF1/web/app_dev.php/Assisstance/new?id_client="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        //String Url = "http://localhost/SMF/web/app_dev.php/produit/new?nomproduit="+ p.getNom_prod()+"&prix="+p.getPrix_prod()+"&quantite="+p.getQuantite_prod()+"&description="+p.getDescription_prod()+"&saison="+p.getSaison()+"&note="+p.getRating_prod()+"&imagep="+p.getImagep();
        String Url = "http://localhost/slim/SMF1/web/app_dev.php/Conseil/modifierconseil?idConseil="+id+"&type="+type+"&contenu="+contenu;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}



    


