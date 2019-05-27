/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import org.controlsfx.control.Notifications;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.tabp;
import service.ProduitService;
import entite.upload;
//////////////////////////////////////////

import entite.Produit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static org.apache.xalan.xsltc.compiler.util.Type.Element;

/**
 * FXML Controller class
 *
 * @author raedm
 */
public class AjoutPController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txt_nomp;
    @FXML
    private TextField txt_quantitep;
    @FXML
     private TextField txt_prixp;
     @FXML
    private TextField txt_notep ;
    @FXML
    private TextField txt_descriptionp;
    Connection cnx;
    @FXML
    private Button AjouterProduit;
    ProduitService ps;
     @FXML
    private TableColumn<Produit, String>nom_prod;
    @FXML
    private TableColumn<Produit, Float> prix_prod;
    @FXML
    private TableColumn<Produit, Integer> quantite_prod;
    @FXML
    private TableColumn<Produit, Integer> note_prod;
    @FXML
    private TableColumn<Produit, String> description_prod;
    @FXML
    private TableColumn<Produit, String>saison_prod;
    @FXML
     private Button btn_aff; 
     @FXML
       private TableView tab_prod; 
     @FXML
    private ComboBox<String> txt_saison;
     @FXML
  
    private TextField nom_prod_sup;
     @FXML
    private TextField   txt_rech;
 @FXML
            private Button sup;
 @FXML
    private Button browse;
    File selectedfile;
    @FXML
    private TextField imageTelecharger;
      ObservableList<String> Saisons = FXCollections.observableArrayList("Hiver","Printemps","Ete","Automne");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ////////////////////////////////////////////////////////////////////browse/////////////////////////////////////////////////
        browse.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    FileChooser fc = new FileChooser();
                    fc.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png")
                    );
                    selectedfile = fc.showOpenDialog(null);
                    if (selectedfile != null) {
                        FileInputStream inp = null;
                        try {
                            System.out.println(selectedfile.getName());
                            inp = new FileInputStream(selectedfile.getPath());
                            System.out.println(selectedfile.getName());
                            ImageView a = new ImageView(new javafx.scene.image.Image(inp));
                            a.setFitHeight(54);
                            a.setFitWidth(62);
                            String path_img = selectedfile.getAbsolutePath();
                            upload us = new upload();
                            if (selectedfile.isFile()) {
                                us.upload(selectedfile);
                            }  try {
                                System.out.println(selectedfile.getCanonicalPath());
                            } catch (IOException ex) {
                                Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            imageTelecharger.setText(selectedfile.getName());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                inp.close();
                            } catch (IOException ex) {
                                Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        System.out.println("FICHIER erroné");
                    }
                }
            });
       
        
        //////////////////////////////////////////////////////////////////////browse//////////////////////////////////////////////////////
          txt_saison.setItems(Saisons);
        ProduitService prs = null;
        try {
            prs = new ProduitService();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
        }
             // nom_prod.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
     ObservableList<Produit> observableArrayList = null;
        try {
            observableArrayList = FXCollections.observableArrayList(prs.getAllProduit());
        } catch (SQLException ex) {
            Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
        }
             tab_prod.setItems(observableArrayList);
               nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
               prix_prod.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
               quantite_prod.setCellValueFactory(new PropertyValueFactory<>("quantite_prod"));
               description_prod.setCellValueFactory(new PropertyValueFactory<>("description_prod"));
               saison_prod.setCellValueFactory(new PropertyValueFactory<>("saison"));
               note_prod.setCellValueFactory(new PropertyValueFactory<>("rating_prod"));
             
               tab_prod.setItems(observableArrayList);
        
            
            ////////////////////////////////////////////////////////////////////////////////
        
        
    
                   
                    
                        } 
    private void AfficherProduits(ActionEvent event) throws SQLException  {
    
   try {
         ProduitService prs= new ProduitService();
         ObservableList<Produit> observableArrayList;
         observableArrayList = FXCollections.observableArrayList(prs.getAllProduit());
         tab_prod.setItems(observableArrayList);
         nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
         prix_prod.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
         quantite_prod.setCellValueFactory(new PropertyValueFactory<>("quantite_prod"));
         description_prod.setCellValueFactory(new PropertyValueFactory<>("description_prod"));
        saison_prod.setCellValueFactory(new PropertyValueFactory<>("saison"));
         note_prod.setCellValueFactory(new PropertyValueFactory<>("rating_prod"));
     } catch (SQLException ex) {
         Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
     }
                
  } 
    
    @FXML
    private void ModifierProduits(ActionEvent event) throws SQLException {
        
      
       ProduitService pss=new ProduitService() ; 
       Produit p =new Produit();
       

String nomprod= txt_nomp.getText();
int quantiteprod = Integer.valueOf(txt_quantitep.getText());
float prixprod = Float.valueOf(txt_prixp.getText());
int ratingprod = Integer.valueOf(txt_notep.getText());
String  descriptionprod=txt_descriptionp.getText() ; 
String saisonprod= txt_saison.getValue() ;
      String image=  imageTelecharger.getText();

         int i=0;
          p.setNom_prod(nomprod);
          p.setQuantite_prod(quantiteprod);
          p.setPrix_prod(prixprod);
          p.setRating_prod(ratingprod);
          p.setDescription_prod(descriptionprod);
          p.setSaison(saisonprod);
         
          pss.ModifierProduit(nomprod,prixprod,quantiteprod,ratingprod,descriptionprod, saisonprod);
          i++;
          if(i!=0)
          
             System.out.println("Produit Modifie");   
          else{
         System.out.println("Error"); 
          }
          AfficherProduits(event);
      
}
    
    @FXML
    private void AjouterProduit(ActionEvent event) throws SQLException {
        


       ProduitService pss=new ProduitService() ; 
       Produit p =new Produit();
       

String nomprod= txt_nomp.getText();
int quantiteprod = Integer.valueOf(txt_quantitep.getText());
float prixprod = Float.valueOf(txt_prixp.getText());
int ratingprod = Integer.valueOf(txt_notep.getText());
String  descriptionprod=txt_descriptionp.getText() ; 
String saisonprod= txt_saison.getValue() ;
String imageprod= imageTelecharger.getText() ;
        

         int i=0;
          p.setNom_prod(nomprod);
          p.setQuantite_prod(quantiteprod);
          p.setPrix_prod(prixprod);
          p.setRating_prod(ratingprod);
          p.setDescription_prod(descriptionprod);
          p.setSaison(saisonprod);
         p.setImagep(imageprod);
          pss.ajouterAlaBase(p);
          
          AfficherProduits(event);
      
}
  

    @FXML
    private void goback(MouseEvent event) {
         try {
            System.out.println("Back");
            Parent Pajout = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene Ajout = new Scene(Pajout,1920,1080);
            Stage Sajout = (Stage)((Node) event.getSource()).getScene().getWindow();
            
            Sajout.setScene(Ajout);
            Sajout.show();
        } catch (IOException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @FXML
       private void SupprimerProduit(ActionEvent event) throws SQLException  {
          ProduitService pss=new ProduitService() ; 
          Produit p =new Produit();
          String nom_prods= nom_prod_sup.getText();
      
       sup.setOnAction(e -> {
           
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation");
                  alert.setHeaderText("Really");
                  alert.setContentText("Are You Sure You Want To Delete?");
                  Optional <ButtonType> action = alert.showAndWait();
                  if(action.get()== ButtonType.OK)
                  try {
                      pss.SupprimerProduit(nom_prods);
                      AfficherProduits(event);
                  } catch (SQLException ex) {
                      Logger.getLogger(AjoutPController.class.getName()).log(Level.SEVERE, null, ex);
                  }
       });
       }
   
// 
    @FXML
    private void getInfo(MouseEvent event) throws NullPointerException {
        //tab_prod.setOnMouseClicked(MouseEvent event){
                   //String test= tab_prod.getSelectionModel().getSelectedItem().getNom_prod;
                   try {
                          
                   Produit p = (Produit) tab_prod.getSelectionModel().getSelectedItem();
                   String nomp= p.getNom_prod();
                   float prix=p.getPrix_prod() ;
                   String prixp= Float.toString(prix);
                   int quantite=p.getQuantite_prod();
                   String quantitep=Integer.toString(quantite);
                   int note=p.getRating_prod();
                   String notep=Integer.toString(note);
                   String descriptionp=p.getDescription_prod();
                   String saisonp=p.getSaison();
                    txt_nomp.setText(""+nomp); 
                     txt_prixp.setText(""+prixp); 
                      txt_quantitep.setText(""+quantitep); 
                       txt_notep.setText(""+notep); 
                        txt_descriptionp.setText(""+descriptionp); 
                         txt_saison.setValue(saisonp);
                          } catch (NullPointerException ex) {
               
                          }
                 }
                    
                

    @FXML
    private void AffecterProuit(ActionEvent event) throws NullPointerException, IOException {
    
                 FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("affecterprod.fxml"));
                    try {
                    Loader.load();
                } catch (IOException ex) {
                 }
               
                AffecterprodController aff= Loader.getController();
                 Produit prod = (Produit) tab_prod.getSelectionModel().getSelectedItem();
                 try {
                   String nomp= prod.getNom_prod();
                      String saisonp=prod.getSaison();   
                      if (nomp==null && saisonp==null){
                    
                  btn_aff.setOnAction(e -> {
                  Alert alert = new Alert(Alert.AlertType.WARNING );
                  alert.setTitle("Error");
                  alert.setContentText("Selectionnez Un Produit Dans Le Tableau Des Produits Et Puis Clicker Affecter");
                  Optional <ButtonType> action = alert.showAndWait();
                  if(action.get()== ButtonType.OK)
                  alert.close();
                                                    }); }
                       else
                         {
                             txt_nomp.setText(""+nomp); 
                         txt_saison.setValue(""+saisonp);
                aff.setData(nomp,saisonp);
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                         }
                            } catch (NullPointerException ex) {
                 
                 }
                            
                         
                         
                        
                         }
     @FXML
    private void RechercherProduits(KeyEvent event) {
    try {
            ProduitService pss=new ProduitService() ;
            Produit p =new Produit();
            String prod_rech= txt_rech.getText();
            
            
            
            ObservableList<Produit> observableArrayList;
            observableArrayList = FXCollections.observableArrayList(pss.FindProduit(prod_rech));
            tab_prod.setItems(observableArrayList);
            nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
            prix_prod.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
            quantite_prod.setCellValueFactory(new PropertyValueFactory<>("quantite_prod"));
            description_prod.setCellValueFactory(new PropertyValueFactory<>("description_prod"));
            saison_prod.setCellValueFactory(new PropertyValueFactory<>("saison"));
            note_prod.setCellValueFactory(new PropertyValueFactory<>("rating_prod"));
            //tab.refresh();
        } catch (SQLException ex) {
            Logger.getLogger(ProdInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
   private void GPDF(ActionEvent  event) throws FileNotFoundException, DocumentException, SQLException, IOException{
      

    OutputStream file = new FileOutputStream(new File("C:\\Users\\raedm\\Desktop\\Exported PDF\\Test.pdf")) ;
         Document document = new Document();
         
         PdfWriter.getInstance(document, file);
         ProduitService prs= new ProduitService();
            ObservableList<Produit> List;
              List = FXCollections.observableArrayList(prs.getAllProduit());
              
       
               PdfPTable tabp= new PdfPTable(6); 
             
      com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new Paragraph("Produits"));
                cell.setColspan(6);
                //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GREEN);
                tabp.addCell(cell);
                tabp.addCell("nom");
                 tabp.addCell("prix");
                  tabp.addCell("quantite");
                   tabp.addCell("rating");
                    tabp.addCell("description");
                    tabp.addCell("saison");
   for (int i= 0; i< tab_prod.getItems().size();i++){
   String nom = List.get(i).getNom_prod();
       tabp.addCell(nom);
       float prix = List.get(i).getPrix_prod();
       String prixs= Float.toString(prix);
       
   tabp.addCell(prixs);
   int quantite = List.get(i).getQuantite_prod() ;
   String quantites= Integer.toString(quantite);
   tabp.addCell(quantites);
   int note = List.get(i).getRating_prod() ;
    String notes= Integer.toString(note);
   tabp.addCell(notes);
   String description = List.get(i).getDescription_prod() ;
   tabp.addCell(description);
   String saison = List.get(i).getSaison() ;
   tabp.addCell(saison);

 
      document.open();   
      
   document.add(tabp);         
     
 }
   document.close();
            }
}

    
    
    
    
    
    

   

    

