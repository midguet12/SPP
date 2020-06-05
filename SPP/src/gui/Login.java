/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dataaccess.Encrypter;
import dataaccess.UserDAO;
import domain.User;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import utilities.StringChecker;

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
        
        Label alertLabel = new Label("");
        alertLabel.setStyle("-fx-text-fill: red;");
        
        Button button = new Button ("Iniciar sesion");
        button.setStyle("-fx-background-color: #2196F3;-fx-text-fill: white;");

        
        
        button.setOnAction(
            new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                    String userlogin = user.getCharacters().toString();
                    String accesskey = password.getCharacters().toString();
                    String encryptedKey;
                    
                    alertLabel.setText("");
                    
                    if(!userlogin.equals("") && !accesskey.equals("")){
                        UserDAO userDAO = new UserDAO();
                        User username = userDAO.getUser(userlogin);
                        
                        if(!username.getIdUser().equals("Not found")){
                            encryptedKey = username.getPassword();
                            accesskey = Encrypter.hasher(accesskey);

                            if(accesskey.equals(encryptedKey)){
                                alertLabel.setText("Bienvenido");
                            }
                        }
                        else{
                            alertLabel.setText("Los datos de aceso son incorrectos.");
                        }
                    }
                    else{
                        alertLabel.setText("Los campos no pueden estar vacíos.");
                    }
                }
            }
        );
        
        VBox panel = new VBox();
        panel.setStyle("-fx-background-color: black");
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(8);
        panel.getChildren().add(imageView);
        panel.getChildren().add(user);
        panel.getChildren().add(password);
        panel.getChildren().add(alertLabel);
        panel.getChildren().add(button);
        
        Scene scene = new Scene(panel, 300, 300);
        //scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        System.out.println("Login");
        launch(args);
    }
    
}
