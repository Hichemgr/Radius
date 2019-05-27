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
//import com.mycompany.Entite.ligneproduit;
//import com.mycompany.Entite.panier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceProduit {



    public ArrayList<Produit> parseListTaskJson(String json) {

        ArrayList<Produit> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Produit e = new Produit();

                float idproduit = Float.parseFloat(obj.get("idproduit").toString());
                 
               String nomproduit = obj.get("nomproduit").toString();
               
                float prix = Float.parseFloat(obj.get("prix").toString());
             
       
                  float quantite = Float.parseFloat(obj.get("quantite").toString());
                    String note = obj.get("note").toString();
                      String description = obj.get("description").toString();
                      
                   e.setIdproduit((int) idproduit);
                    e.setNomproduit(nomproduit);
                     e.setPrix( prix);
               e.setQuantite((int) quantite);
                e.setNote(note);
                 e.setDescription(description);
                
                 System.out.println("broooooooooooooooooooooooo");
                System.out.println(e);
                
                listTasks.add(e);
                
            

            }

        } catch (IOException ex) {
        }
        
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<Produit> listTasks = new ArrayList<>();
    
    public ArrayList<Produit> getListprod(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/untitled/web/app_dev.php/Panier/allProduit");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    

}
