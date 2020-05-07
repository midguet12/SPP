package dataaccess;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DataBaseConnection {

    private Connection connection = null;    
    private final String user = null;
    private final String password = null;
    
    public static void writeConfFile(){
        String file = "db.conf";
        DataBase db = new DataBase("midguet.ddns.net","midguet","Magt2208");
        
        
        try {
            FileOutputStream fileOut= new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileOut);
            
            writer.writeObject(db); 
            fileOut.close();
            writer.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
     
    public void startConnection(){ 
        try{
            connection = DriverManager.getConnection("jdbc:mysql://midguet.ddns.net:3306/spp?useUnicode=yes&characterEncoding=UTF-8", user, password);
        }
        catch(SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
    }
    
    public Connection getConnection(){
        startConnection();
        return connection;
    }
    
    public void closeConnection(){ 
        if (connection != null) {
            try{
                if(!connection.isClosed()){
                    connection.close();
                }
            }
            catch(SQLException ex){
                ExceptionLogger.notify(ex, this.getClass().getName());
            }
        }
    }  
}