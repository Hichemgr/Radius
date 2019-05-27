/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entite.MyDBcon;
//import controller.AffichageAjout;
import entite.Produit;
import entite.utilisateur;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static org.apache.commons.lang3.time.FastDateParserSDFTest.data;
import org.apache.commons.net.nntp.Article;
import service.ligneproduitservice;
import service.panierservice;
import java.util.Locale;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.TitledPane;
import service.utilisateurservice;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListArticlesController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private ScrollPane pane;
     private ObservableList<Produit> data;
     Connection cnx;
     @FXML
    private Label nom;
    @FXML
    private Label prenom;
    ObservableList<Produit> items = FXCollections.observableArrayList();
    @FXML
    private Button vider;
    @FXML
    private TextField totale;
    @FXML
    private JFXTextField recherchetext;
    @FXML
    private Button retour;
    @FXML
    private Button pdf;
    @FXML
    private Button stat;

    /**
     * Initializes the controller class.
     */
       public ObservableList<Produit> loadPanier() throws SQLException {
        //list.setItems(items);
//        Statement stm = cnx.createStatement();
//        String req = "SELECT id FROM `fos_user` WHERE `enabled`=1 and `roles`=\"client\"";
//        ResultSet res = stm.executeQuery(req);
//        int id_user = res.getInt(1);
//String req="";
         cnx = MyDBcon.getInstance().getCnx();
      //  listview.getItems().clear();
        String nom1=nom.getText();
               String prenom1=prenom.getText();
                    panierservice ps2= new panierservice();
        int id1=ps2.rechercheridutili(nom1, prenom1);
          PreparedStatement pt = cnx.prepareStatement("SELECT produit.idproduit,produit.nomproduit,produit.description,produit.prix,ligneproduit.quantite FROM `ligneproduit` ,`produit` ,`panier` WHERE panier.idpanier IN (select idpanier from panier where idutilisateur=?)and panier.idpanier=ligneproduit.idpanier and produit.idproduit=ligneproduit.idproduit and panier.etat=?");
        //PreparedStatement pt = cnx.prepareStatement("SELECT produit.nom_prod,produit.prix,panier.date_ajout,ligne_commande.quantite FROM `ligne_commande` ,`produit` ,`panier` WHERE panier.id_panier IN (select id_panier from panier where id_user=?)and panier.id_panier=ligne_commande.id_panier and produit.id_prod=ligne_commande.id_prod and panier.etat=?");
        pt.setInt(1,id1);
       pt.setInt(2, 0);
        ResultSet resultat = pt.executeQuery();
        while (resultat.next()) {
            int id = resultat.getInt("idproduit");
            String nom = resultat.getString("nomproduit");
          //  items.add("Nom:   " + nom);
           // productsNames.add(nom);
            float prix = resultat.getFloat("prix");
            //items.add("Prix:   " + Float.toString(prix));
           // Date date = resultat.getDate("date_ajout");
            int quantite = resultat.getInt("quantite");
            
            //items.add("Quantité:  " + Integer.toString(quantite));
            
//            items.add("*********************************************************");
            Produit p=new Produit(id,nom,prix,quantite);
            items.add(p);
           
        //    listview.getItems().addAll(items);
            

        }
         return items;
        
    }
       
        public void videepanier() throws SQLException {
       
         cnx = MyDBcon.getInstance().getCnx();
       // listview.getItems().clear();
        String nom1=nom.getText();
                    String prenom1=prenom.getText();
                    panierservice ps2= new panierservice();
        int id1=ps2.rechercheridutili(nom1, prenom1);
           System.out.println(id1);
           int id2=ps2.rechercherutilisateur(id1);
       
                         ps2.videpanierbase(id2);
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("votre panier a été vidé");
                        //alert.setContentText("produit ajouté avec succes");

                        alert.showAndWait();
        

        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            utilisateurservice us = new utilisateurservice();
            int idu=0;
            ArrayList<utilisateur> utilisateurs = us.getutilisateurconnecter();
            String u="";
            for(utilisateur e:utilisateurs){
                nom.setText(e.getNom());
                prenom.setText(e.getPrenom());
                idu=e.getIdutilisateur();
                System.out.println(nom.getText());
                u=e.getPhotoprofil();
            }
            //javafx.scene.image.Image a1=new javafx.scene.image.Image("file:C:/wamp64/www/image/"+u);
            //photoprofil.setImage(a1);
            
            
            try {
                TilePane b = new TilePane();
                b.setPadding(new javafx.geometry.Insets(30));
                TilePane c = new TilePane();
                FadeTransition ft = new FadeTransition(Duration.millis(1500));
                
                //AffichageAjout aff= new AffichageAjout();
                ligneproduitservice ps= new ligneproduitservice();
                float h=ps.getprixtotale(idu);
                totale.setText(String.valueOf(h));
                
                data = loadPanier();
                for ( Produit d : data) {
                  
                    try {
                        
                        
                        
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DivArticle.fxml"));
                        Parent root = (Pane) loader.load();
                        DivArticleController DHC = loader.getController();
                        
                        System.out.println("non ");
                        DHC.LoadValues(d);
                        
                        //   c.setVgap(40);
                        c.getChildren().removeAll();
                        
                        
                        c.getChildren().add(root);
                    } catch (IOException ex) {
                        Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                c.setPrefColumns(3);
                c.setPadding(new javafx.geometry.Insets(0));
                c.setHgap(10);
                c.setVgap(80);
                b.getChildren().add(c);
                b.setPrefWidth(1000);
                pane.setContent(b);
                
                
                
            }catch (SQLException ex) {
                Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
            }
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);
            
            
            vider.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event)   {
                    try {
                        //ligneproduit lm=new ligneproduit();
                        videepanier();
                        vider.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
                        
                        
                        
                        
                        
                        //Retour.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
                        
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    } catch (SQLException ex) {
                        Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            
            retour.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    
                    
                    try {
                        retour.getScene().setRoot(FXMLLoader.load(getClass().getResource("ajout.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
        }catch (SQLException ex) {
                    Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
//            ////////// end 9dima////////////
//
////        editicon.setVisible(false);
////        deleteicon.setVisible(false);

    }

    @FXML
    public void RechercheDynamique(KeyEvent event) throws SQLException {
               // AffichageAjout aff= new AffichageAjout();
              //  data=loadPanier();
         FilteredList<Produit> filteredData = new FilteredList<>(data, e -> true);
        recherchetext.setOnKeyReleased(e
                -> {
            recherchetext.textProperty().addListener((ObservableValue<? extends String> ObservableValue, String oldValue, String newValue) -> {
                filteredData.setPredicate((Predicate<? super Produit>) new Predicate<Produit>() {
                    @Override
                    public boolean test(Produit d) {
                        if (newValue == null || newValue.isEmpty()) {
                            
                            return true;

                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return d.getNom_prod().toLowerCase().contains(lowerCaseFilter.subSequence(0, lowerCaseFilter.length()));
                    }
                });
            });
            TilePane b = new TilePane();
        b.setPadding(new javafx.geometry.Insets(30));
        TilePane c = new TilePane();

        for ( Produit d : filteredData) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DivArticle.fxml"));
                Parent root = (Pane) loader.load();
                DivArticleController DHC = loader.getController();
                DHC.LoadValues(d);
               
                //   c.setVgap(40);
                c.getChildren().removeAll();
               
                
                c.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.setPrefColumns(3);
        c.setPadding(new javafx.geometry.Insets(0));
        c.setHgap(10);
        c.setVgap(80);
        b.getChildren().add(c);
        b.setPrefWidth(1000);
        pane.setContent(b);
    });
                }
    
    public void affichetrie(String scvalue, URL url, ResourceBundle rb, String trisq) throws SQLException {

        

    }

    public void trix(String trisq, URL url, ResourceBundle rb) {

      
    
        
    }    

    @FXML
    private void refresh(MouseEvent event) {
         try {
             items.clear();
            TilePane b = new TilePane();
            b.setPadding(new javafx.geometry.Insets(30));
            TilePane c = new TilePane();
            FadeTransition ft = new FadeTransition(Duration.millis(1500));
            
            //AffichageAjout aff= new AffichageAjout();
              ligneproduitservice ps= new ligneproduitservice();
            float h=ps.getprixtotale(11);
             totale.setText(String.valueOf(h));
            
          data = loadPanier();
            for ( Produit d : data) {
                
                try {
                    
                    
                    
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DivArticle.fxml"));
                    Parent root = (Pane) loader.load();
                    DivArticleController DHC = loader.getController();
                    DHC.LoadValues(d);
                    
                    //   c.setVgap(40);
                    c.getChildren().removeAll();
                    
                    
                    c.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.setPrefColumns(3);
            c.setPadding(new javafx.geometry.Insets(0));
            c.setHgap(10);
            c.setVgap(80);
            b.getChildren().add(c);
            b.setPrefWidth(1000);
            pane.setContent(b);
            
                    
                    
                }catch (SQLException ex) {
                    Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
                }
     
    }

    @FXML
    private void pdf(MouseEvent event) throws DocumentException, SQLException, BadElementException, IOException {
        //private void createPDF(ActionEvent event) {
        String nom1=nom.getText();
               String prenom1=prenom.getText();
        
            try {
               // System.out.println("Haouet------------------------------------->"+nom);
                
                
                com.itextpdf.text.Document document = new com.itextpdf.text.Document();
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ASUS\\Desktop/rapport.pdf"));
                document.open();
                document.add(new Paragraph(" Radius Garden ", FontFactory.getFont(FontFactory.TIMES)));
                 //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                //String date=new Date().toString();
                //document.add(new Paragraph(" Date : " + new Date().toString()));
              //  document.add(new Paragraph("-----------------------------------------------------------------"));
               // document.add(new Paragraph("-----------------------------------------------------------------"));
                com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(2);
                com.itextpdf.text.pdf.PdfPCell cell = new com.itextpdf.text.pdf.PdfPCell(new Paragraph("Facture"));
                cell.setColspan(4);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GREEN);
                table.addCell(cell);
             
                table.addCell("nom");
              table.addCell(nom1);
              table.addCell("prenom");
              table.addCell(prenom1);
                for ( Produit d : data) {
                 table.addCell("Produit");
                 table.addCell(d.getNom_prod());
                 table.addCell("Quantite");
                 table.addCell(Float.toString(d.getQuantite_prod()));
                
            }
              ligneproduitservice ps= new ligneproduitservice();
               panierservice ps2= new panierservice();
                
                     int id1=ps2.rechercheridutili(nom1, prenom1);
             float h=ps.getprixtotale(id1);
                //table.addCell("Prenom");
           //    table.addCell(selectedUser.getPrix());
             table.addCell("Date");
              table.addCell(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
              table.addCell("*******************************");
               table.addCell("*******************************");
                table.addCell("Montant Totale");
               table.addCell(Float.toString(h));
               
              Image image = Image.getInstance ("file:C://wamp64/www/image/" +"radius.png"); 
             // image.setAbsolutePosition(50,50);
        //document.add(new Paragraph("test\n  test")); 
        document.add(image);  
            //    table.addCell("email");
         //      table.addCell(selectedUser.getQuantiteStock());
                
           //     table.addCell("email");
                
                //table.addCell(selectedUser.getNom());
                //System.out.println("***************"+selectedUser.getNom().toString());
        
      //  data = loadPanier();
          
                
                    
                    
                    
                    
                 
                    
                    
               
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null, " donnees export avec succes ");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(ListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void stati(MouseEvent event) throws SQLException {
        
        
            
       //   data = loadPanier();
           
               
                for ( Produit d : data) {
            
        int i=100;
       // int j=22;
        Stage primaryStage=new Stage();
        Group root = new Group();
        Scene scene = new Scene(root,500,530);
        primaryStage.setScene(scene);
         
               int a= d.getQuantite_prod();
               int b=d.getRef_prod();
               panierservice ps =new panierservice();
               //   System.out.println(a);
               int h=ps.rechercherquantite(b);
                    System.out.println(h);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Stock totale("+h+")", h),
                new PieChart.Data("quantite("+a+")",a)
        );
              PieChart pieChart =new PieChart(pieChartData);
        TitledPane t4 = new TitledPane("Pie Chart", pieChart);
        Accordion accordion = new Accordion();
        accordion.getPanes().add(t4);
        root.getChildren().add(accordion);
        accordion.setExpandedPane(t4);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Statistique");
        primaryStage.show();
      
        
        }
        
        
        
        
        
        
    }

    @FXML
    private void valider(MouseEvent event) throws SQLException {
                     String nom1=nom.getText();
                    String prenom1=prenom.getText();
                    panierservice ps2= new panierservice();
                    int id1=ps2.rechercheridutili(nom1, prenom1);
                    //System.out.println(id1);
                    int id2=ps2.rechercherutilisateur(id1);
                    ps2.validercommande(id2);
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Commande");
                        alert.setHeaderText("votre commande a été validé");
                        alert.setContentText("Les produits vous seront livrés dans 48h");

                        alert.showAndWait();
        
    }
}
    

  
     

   
    

