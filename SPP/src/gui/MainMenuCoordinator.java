/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author midgu
 */
public class MainMenuCoordinator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
    
        primaryStage.setTitle("Menu principal");
        primaryStage.setHeight(720);
        primaryStage.setWidth(1280);
        
        FileInputStream input = null;
        try{
            input = new FileInputStream("./icons/images.png");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Image image = new Image(input);
        primaryStage.getIcons().add(image);
        
        Button projects = new Button ("Proyectos");
        projects.setStyle("-fx-background-color: #00569F;-fx-text-fill: white;-fx-border-radius: 90;");
        
        Button interns = new Button("Practicantes");
        interns.setStyle("-fx-background-color: #00569F;-fx-text-fill: white;");
        
        Button reports = new Button("Reportes");
        reports.setStyle("-fx-background-color: #00569F;-fx-text-fill: white;");
        
        HBox panel = new HBox();
        panel.getChildren().add(projects);
        panel.getChildren().add(interns);
        panel.getChildren().add(reports);
        panel.setSpacing(10);
        
        panel.setStyle("-fx-background-color: black;");
        Scene scene = new Scene(panel, 1280,720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    
}
