/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.db.Database;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Promotion;
import com.mycompany.Service.ServicePromotion;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Prom extends Form{
    Form f;
    SpanLabel lb,test;
    //TextField trecherche;
   // Button btnrecherche;
    Button btn;
    ServicePromotion ser=new ServicePromotion();
   Promotion prom=new Promotion();
    ArrayList<Promotion> promotions = new ArrayList<>();
    ///////////////////////////////////////
     private ImageViewer imgv;
    private Image img;
    private EncodedImage enc;
    
    
    
    public Prom( Resources theme) {
        
    f = new Form("Promotions");
    f.setLayout(BoxLayout.y());
        f.getToolbar().addCommandToRightBar("Back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
        
        
         List<Promotion> list = new ArrayList<>();

        list=ser.getList2();
         for (Promotion p : list) {
            f.add(addItem(p,theme));
        }
        
      
    
        /***********************************************************************************************/
        
        
        
    }
     public Container addItem(Promotion p , Resources theme ) {
        //Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.y());
        Label lnom = new Label(p.getNomproduit());
        lnom.setAlignment(CENTER);
       // String url = "http://localhost/mobile/" + p.getImg();
                      enc=EncodedImage.createFromImage(theme.getImage("fleur.png"), false);
                        img=URLImage.createToStorage(enc,"http://localhost/mobile/"+p.getImg(),"http://localhost/mobile/"+p.getImg());
                        imgv=new ImageViewer(img);
        cnt2.add(imgv).add(lnom);
        /************************************************/
//        ConnectionRequest con = new ConnectionRequest();
//                con.setUrl("http://localhost/Mobile/getDetails.php?id="+p.getRef_prod());
               
//                   con.addResponseListener(new ActionListener<NetworkEvent>() {
//                    @Override
//                    public void actionPerformed(NetworkEvent evt) {
//
//                        String response = new String(con.getResponseData());
//                        p.setDescription_prod(response);}
//                   }
//                   );
//                      NetworkManager.getInstance().addToQueue(con);  
//                      
//                       imgv.addPointerReleasedListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                 AffichageDetails d =new AffichageDetails(p,theme);
//               d.show();
//            }
//        }
//        );
      return cnt2;
      
     }
        
        
        
        /**********************************************************/
//        f.add(lb);
//         
//         ser=new ProduitService();
//         
//         
//          int mm = Display.getInstance().convertToPixels(3);
//  EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
//
//         
//        ArrayList<Map<String, Object>> data = new ArrayList<>();
//        ////////////////////////Affichage/////////////
//          
//         ProduitService ProduitService=new ProduitService();
//         
//         for (Produit p :ProduitService.getList2()) {
//             String nomp=p.getNom_prod();
//             String prix=String.valueOf(p.getPrix_prod()) ;
//            String image = p.getImagep();
//             additem(nomp,prix,image);
//             
//         }
    
    
 
     
//     public void additem(String nomp,String prix,String image){
//        Container c1 =new Container(new BoxLayout(BoxLayout.X_AXIS));
//        
//        String path ="http://localhost/Mobile/"+image;
//        
//         System.out.println(image);
//        Image setimg=FileEncodedImage.create(path,400,400);
//        ImageViewer img=new ImageViewer(setimg);
//        
//        Container c2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
//        Label titre1=new Label(nomp);
//        Label message1=new Label(prix);
//        
//       
//        
//        c2.add(titre1);
//        c2.add(message1);
//        c1.add(img);
//        c1.add(c2);
//        f.add(c1);
//        f.refreshTheme();
//        f.show();
//     }
        /////////////////////////////////////////////////
//for(int i =0;i<produits.size();i++)
//{   
//     /************************Code Image alt****************/
//    
//       ////////////////////////////////////////////////////////
//    
//    
//    //System.out.println(imagep);
// String filePath ="file:///C:/wamp64/www/SMF/web/ressources/images/"+imagep;
// String imagep=produits.get(i).getImagep();
//       
//       
//        if (path != null) {
//            try {
//                String pathToBeStored;
//                pathToBeStored = FileSystemStorage.getInstance().getAppHomePath() + System.currentTimeMillis();
//                //Image img;
//                \
//    //String filePath ="/file:"+produits.get(i).getI
//                 int displayHeight = Display.getInstance().getDisplayHeight();
//    //Image scaledPhotoImage = img.scaled(-1, displayHeight / 2);
//    data.add(createListEntry("Nom: "+produits.get(i).getNom_prod(),img,"Prix: "+String.valueOf(produits.get(i).getPrix_prod())));    
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//        }   
//}
//DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
//MultiList ml = new MultiList(model);
//ml.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent evt) {
//                          
//                 System.out.println(ml.getSelectedItem());
//             }
//         });
//f.add(BorderLayout.CENTER, ml);
//ml.addActionListener((ActionListener) (ActionEvent evt) -> {
//    
//      AffichageDetails h = new AffichageDetails(produits.get(ml.getSelectedIndex()));
//        h.getF().show();
//         });
//    }
//     private Map<String, Object> createListEntry(String titre,Image icon, String price) {
//    Map<String, Object> entry = new HashMap<>();
//    
//    entry.put("Line1", titre);
//    entry.put("Line2", icon);
//    entry.put("Line3", price);
//    return entry;
//    }
      
  

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

//    public TextField getTrecherche() {
//        return trecherche;
//    }
//
//    public void setTrecherche(TextField trecherche) {
//        this.trecherche = trecherche;
//    }
//
//    public Button getBtnrecherche() {
//        return btnrecherche;
//    }
//
//    public void setBtnrecherche(Button btnrecherche) {
//        this.btnrecherche = btnrecherche;
//    }

    
    

  

}