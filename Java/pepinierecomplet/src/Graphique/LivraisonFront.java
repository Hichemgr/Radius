/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author seifeddinebenfraj
 */
public class LivraisonFront extends Application {
    
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Graphique/LivraisonFront.fxml"));
        Scene sc1 = new Scene(root);
        primaryStage.setScene(sc1);
        primaryStage.setTitle("Livraison");
        primaryStage.show();
    }
    
//    FilteredList<livraison> filteredData = new FilteredList<>(data, e -> true);
//              idSup.setOnKeyReleased(e -> {
//                  idSup.textProperty().addListener((observableValue, oldValue, newValue)->{
//                      filteredData.setPredicate((Predicate<? super livraison>) livraison -> {
//                          if(newValue == null || newValue.isEmpty()){
//                              return true;
//                          } 
//                          String lowerCaseFilter = newValue.toLowerCase();
//                          if(l.getAdresse().contains(newValue)){
//                              return true;
//                          }
//                          return false;
//                      });
//                  });
//                  SortedList<livraison> sortedData = new SortedList<>(filteredData);
//                  sortedData.comparatorProperty().bind(TableLivraison.comparatorProperty());
//                  TableLivraison.setItems(sortedData);
//        });

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
