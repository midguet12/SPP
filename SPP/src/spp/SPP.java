package spp;


import java.io.File;
import java.io.FileInputStream;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import utilities.FileClient;




public class SPP extends Application{   
    
    @Override    
    public void start(Stage primaryStage){
        
        primaryStage.setTitle("Descargar archivo");
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
        
        Button upload = new Button ("Descargar archivo");
        upload.setStyle("-fx-background-color: #00569F;-fx-text-fill: white;-fx-border-radius: 90;");
        
        FileChooser fileChooser = new FileChooser();
        FileClient fileClient = new FileClient();
        
        
        upload.setOnAction(
            new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                    
                    
                    
                    File file = fileChooser.showSaveDialog(primaryStage);
                   
                    
                    fileClient.getFile(file);
                    
                }
            }
        );
    
        
        HBox panel = new HBox();
        panel.getChildren().add(upload);
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(10);
        
        panel.setStyle("-fx-background-color: black;");
        Scene scene = new Scene(panel, 1280,720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }
        
    public static void main(String[] args) {
        
        launch(args);
        
        
        
        
    }
}
