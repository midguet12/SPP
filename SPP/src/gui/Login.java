/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author midgu
 */
public class Login extends Application{
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        primaryStage.setTitle("Sistema de practicas profesionales");
        primaryStage.setHeight(600);
        primaryStage.setWidth(300);
        
        FileInputStream input = null;
        
        try{
            input = new FileInputStream("./icons/images.png");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        
        primaryStage.getIcons().add(image);
        
        
        TextField user = new TextField();
        user.setStyle("-fx-background-color: black;-fx-text-fill: white; -fx-border-color: white ; -fx-border-width: 1px ;");
        user.setMaxWidth(200);
        user.setPromptText("Usuario");
     
        
        
        PasswordField password = new PasswordField();
        password.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-border-color: white ; -fx-border-width: 1px ;");
        password.setMaxWidth(200);
        password.setPromptText("Contraseña");
        
        
        Button button = new Button ("Iniciar sesion");
        button.setStyle("-fx-background-color: #2196F3;-fx-text-fill: white;");
        
        
      

        VBox panel = new VBox();
        panel.setStyle("-fx-background-color: black");
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(8);
        
        panel.getChildren().add(imageView);
        panel.getChildren().add(user);
        panel.getChildren().add(password);
        panel.getChildren().add(button);
        
      
        
        
             
        
        Scene scene = new Scene(panel, 300, 300);
        //scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
