package spp;


import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utilities.PDFCreator;






public class SPP extends Application{   
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Generar pdf");
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
        
        TextField text = new TextField();
        text.setStyle("-fx-background-color: black;-fx-text-fill: white; -fx-border-color: white ; -fx-border-width: 1px ;");
        text.setMaxWidth(200);
        text.setPromptText("Ingresar texto");
        
        Button generate = new Button ("Generar PDF");
        generate.setStyle("-fx-background-color: #00569F;-fx-text-fill: white;-fx-border-radius: 90;");
        
        
        generate.setOnAction(
            new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                    
                    PDFCreator.create("Prueba.pdf","Hola, este programa creo un pdf");
                    
                }
            }
        );
        
        
        HBox panel = new HBox();
        panel.getChildren().add(generate);
        panel.setStyle("-fx-background-color: black;");
        panel.setAlignment(Pos.CENTER);
        Scene scene = new Scene(panel, 1280,720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    
        
    public static void main(String[] args) {
        
       
        
        
            
        
        launch(args);
        
        
        
        
    }
}
