/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entite.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
import service.utilisateurservice;
//mobile com.codenameone.ui
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UtilisateurbackController implements Initializable {
    @FXML
    private TableView<utilisateur> table;
    @FXML
    private TableColumn<utilisateur, Integer> cin;
    @FXML
    private TableColumn<utilisateur, String> nom;
    @FXML
    private TableColumn<utilisateur, String> prenom;
    @FXML
    private TableColumn<utilisateur, String> mail;
    @FXML
    private TableColumn<utilisateur, Integer> telephone;
    @FXML
    private TableColumn<utilisateur, Date> date;
    @FXML
    private TableColumn<utilisateur, String> role;
    @FXML
    private TableColumn<utilisateur, Integer> nbpoint;
    @FXML
    private ImageView add;
     @FXML
    private TextField nomm;
    @FXML
    private TextField prenomm;
    @FXML
    private TextField cinn;
    @FXML
    private TextField maill;
    @FXML
    private TextField telephonee;
    @FXML
    private PasswordField mdpp;
    @FXML
    private DatePicker datee;
    @FXML
    private ImageView logout;
    @FXML
    private ComboBox Combobox;
    private ComboBox combo;
    @FXML
    private TextField recherche;
      @FXML
    private TextField adresse;
    private ComboBox cobox;
    private ComboBox comba;
    @FXML
    private BarChart<String, Integer> BarChart;
    private Connection connection;
    @FXML
    private Button menuAcceuil;
    @FXML
    private Button menuProduit;
    @FXML
    private Button menuService;
    @FXML
    private Button menuEvenement;
    @FXML
    private Button menuReclamation;
    @FXML
    private Button menuForum;
    @FXML
    private Button menuDeconnexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Combobox.getItems().removeAll(Combobox.getItems());
                        Combobox.getItems().addAll("Assistant", "Livreur");
                        Combobox.getSelectionModel().select("Assistant");
            utilisateurservice ps= new utilisateurservice();
            ArrayList<utilisateur> personnes = new ArrayList<>();
            try {
                personnes=(ArrayList<utilisateur>) ps.getAllutilisateur();
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObservableList<utilisateur> obsl = FXCollections.observableArrayList(personnes);
            table.setItems(obsl);
            cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            mail.setCellValueFactory(new PropertyValueFactory<>("adressemail"));
            telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            date.setCellValueFactory(new PropertyValueFactory<>("datecreation"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
            nbpoint.setCellValueFactory(new PropertyValueFactory<>("nbpoint"));
          
             utilisateurservice us = new utilisateurservice();
            ArrayList<utilisateur> utilisateurs = us.getAllutilisateur();
          
       int x=0;
           /* for(utilisateur e:utilisateurs){
              // prenom.setText(e.getPrenom());
              // telephone.setText(String.valueOf(e.getTelephone())); 
               combo.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());
              
             // x=e.getCin();
               
            }
             combo.getSelectionModel().select("Cin,Nom,Role");
             /*combo.getItems().removeAll(Combobox.getItems());
                        combo.getItems().addAll("Assistant", "Livreur");
                        combo.getSelectionModel().select("Assistant");*/
              /*   for(utilisateur e:utilisateurs){           
               cobox.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());    
            }
             cobox.getSelectionModel().select("Cin,Nom,Role");
             for(utilisateur e:utilisateurs){           
               comba.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());    
            }
             comba.getSelectionModel().select("Cin,Nom,Role");*/
       String query = "SELECT COUNT(idutilisateur),role FROM utilisateur group by role";
		XYChart.Series<String, Integer> series = new XYChart.Series<>();

		try {
			connection = connexionBD();
			//System.out.println("test");
			ResultSet rs = connection.createStatement().executeQuery(query);

			while (rs.next()) {
				series.getData().add(new XYChart.Data<>(rs.getString(2), rs.getInt(1)));
			}
			BarChart.getData().addAll(series);

		} catch (SQLException e) {
			e.printStackTrace();
		}

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void add(MouseEvent event) throws NoSuchAlgorithmException {
             try {
                  
                    utilisateurservice us = new utilisateurservice();
                    int ciin=Integer.valueOf(cinn.getText());
                    String noom=nomm.getText();
                    String prenoom=prenomm.getText();
                     java.sql.Date daate=Date.valueOf(datee.getValue());
                    String mddp=mdpp.getText();
                     String maiil=maill.getText();
                         String adressee=adresse.getText();  
             
                  utilisateur u=new utilisateur(ciin,noom,prenoom,mddp,maill.getText(),Integer.valueOf(telephonee.getText()),daate,"disponible",String.valueOf(Combobox.getValue()),"user.png",0,adressee);
                    us.ajouterutilisateur(u);
                    Notifications notificationBuilder = Notifications.create()
              .title("Employé ajouté")
              .text("succés")
              .graphic(null)
              //.hideAfter(Duration.seconds(5))
              .position(Pos.TOP_RIGHT)
              .onAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
System.out.println("clicked on notification");             
             }
              });
      notificationBuilder.show();
                   
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void logout(MouseEvent event) {
         try {
               utilisateurservice us = new utilisateurservice();
               us.deconnexionutilisateur("connecter");
               try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    private void remove(MouseEvent event) throws NoSuchAlgorithmException {
        try {
               utilisateurservice us = new utilisateurservice();
               String t=String.valueOf(combo.getValue());
               String B=""; 
                B=""+t.substring(0, 8);
                System.out.println(B);
              us.supprimerutilisateur(Integer.valueOf(B));
               combo.getItems().removeAll(combo.getItems());
            ArrayList<utilisateur> utilisateurs = us.getAllutilisateur();
            for(utilisateur e:utilisateurs){
               combo.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());  
            }
             combo.getSelectionModel().select("Cin,Nom,Role");
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression");
		alert.setHeaderText("L'employé a été supprimé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
              /* try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }*/
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    @FXML
    private void rechh(KeyEvent event) throws NoSuchAlgorithmException {
         try {
                utilisateurservice ps= new utilisateurservice();
                ArrayList<utilisateur> personnes = new ArrayList<>();
                //String prod_rech= recherche.getText();
                try {
                    personnes=(ArrayList<utilisateur>) ps.rechercheuser(recherche.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObservableList<utilisateur> obsl = FXCollections.observableArrayList(personnes);
                table.setItems(obsl);
                cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
                nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                mail.setCellValueFactory(new PropertyValueFactory<>("adressemail"));
                telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                date.setCellValueFactory(new PropertyValueFactory<>("datecreation"));
                role.setCellValueFactory(new PropertyValueFactory<>("role"));
                nbpoint.setCellValueFactory(new PropertyValueFactory<>("nbpoint"));
                
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   /* @FXML
    private void rechh(InputMethodEvent event) {
    }*/

   /* @FXML
    private void rechh(InputMethodEvent event) {
    }*/

    private void desactiver(MouseEvent event) throws NoSuchAlgorithmException {
        try {
               utilisateurservice us = new utilisateurservice();
               String t=String.valueOf(cobox.getValue());
               String B=""; 
                B=""+t.substring(0, 8);
                System.out.println(B);
              us.desactivercompteutilisateur(Integer.valueOf(B));
               cobox.getItems().removeAll(cobox.getItems());
            ArrayList<utilisateur> utilisateurs = us.getAllutilisateur();
            for(utilisateur e:utilisateurs){
               cobox.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());  
            }
             cobox.getSelectionModel().select("Cin,Nom,Role");
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Désactivation");
		alert.setHeaderText("Le compte a été désactivé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
              /* try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }*/
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    private void activer(MouseEvent event) throws NoSuchAlgorithmException {
          try {
               utilisateurservice us = new utilisateurservice();
               String t=String.valueOf(comba.getValue());
               String B=""; 
                B=""+t.substring(0, 8);
                System.out.println(B);
              us.activercompteutilisateur(Integer.valueOf(B));
               comba.getItems().removeAll(comba.getItems());
            ArrayList<utilisateur> utilisateurs = us.getAllutilisateur();
            for(utilisateur e:utilisateurs){
               comba.getItems().addAll(e.getCin()+","+e.getNom()+","+e.getRole());  
            }
             comba.getSelectionModel().select("Cin,Nom,Role");
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Activation");
		alert.setHeaderText("Le compte a été activé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
              /* try {
                   logout.getScene().setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }*/
           } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }

    @FXML
    private void supp(MouseEvent event) throws NoSuchAlgorithmException {
        try {
            utilisateurservice us = new utilisateurservice();
            
            us.supprimerutilisateur(table.getSelectionModel().getSelectedItem().getCin());
            //  table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
             ArrayList<utilisateur> personnes = new ArrayList<>();
             personnes=(ArrayList<utilisateur>) us.getAllutilisateur();
            ObservableList<utilisateur> obsl = FXCollections.observableArrayList(personnes);
            table.setItems(obsl);
            cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            mail.setCellValueFactory(new PropertyValueFactory<>("adressemail"));
            telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            date.setCellValueFactory(new PropertyValueFactory<>("datecreation"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
            nbpoint.setCellValueFactory(new PropertyValueFactory<>("nbpoint"));
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Supprimer");
		alert.setHeaderText("L'utilisateur a été supprimé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @FXML
    private void desaaac(MouseEvent event) {
        try {
            utilisateurservice us = new utilisateurservice();
            us.desactivercompteutilisateur(table.getSelectionModel().getSelectedItem().getCin());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Désactivation");
		alert.setHeaderText("Le compte a été désactivé!");
		//alert.setContentText("L'employé a été ajouté!");
		alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void acccc(MouseEvent event) {
        try {
            utilisateurservice us = new utilisateurservice();
            us.activercompteutilisateur(table.getSelectionModel().getSelectedItem().getCin());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Activation");
            alert.setHeaderText("Le compte a été activé!");
            //alert.setContentText("L'employé a été ajouté!");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	private Connection connexionBD() throws SQLException {
		try {
			String dbString =  "jdbc:mysql://127.0.0.1/pepiniere";
			String user = "root";
			String password = "";
			Connection con = DriverManager.getConnection(dbString, user, password);
			System.out.println("Connexion okay");
			return con;
		} catch (SQLException ex) {
			Logger.getLogger(UtilisateurbackController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

    @FXML
    private void acceuil(MouseEvent event) {
            try {
                   menuAcceuil.getScene().setRoot(FXMLLoader.load(getClass().getResource("utilisateurback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void prod(MouseEvent event) {
          try {
                   menuProduit.getScene().setRoot(FXMLLoader.load(getClass().getResource("HomePage.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void commande(MouseEvent event) {
         try {
                   menuService.getScene().setRoot(FXMLLoader.load(getClass().getResource("Backcommande.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void promotion(MouseEvent event) {
         try {
                   menuEvenement.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/PromotionUser.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void reclamation(MouseEvent event) {
        try {
                   menuReclamation.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GRAPHE/recUtilisateur.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void livraison(MouseEvent event) {
        
                try {
                   menuForum.getScene().setRoot(FXMLLoader.load(getClass().getResource("/Graphique/Livraisonback.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void hezniassiss(MouseEvent event) {
      
                 try {
                     menuDeconnexion.getScene().setRoot(FXMLLoader.load(getClass().getResource("/Graphique/AssisstanceG.fxml")));
               } catch (IOException ex) {
                   Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

  
    
}
