package dataaccess;

import utilities.datastructure.DataBaseCredentials;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DataBaseConnection {
    private Connection connection = null;    
    
    private DataBaseCredentials db = readConfFile();
    public static DataBaseCredentials readConfFile(){
        String file = "db.conf";
        DataBaseCredentials db = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            
            db = (DataBaseCredentials)reader.readObject();
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return db;
        
    }
    
     
    public void startConnection(){ 
        try{
            connection = DriverManager.getConnection("jdbc:mysql://" + db.getAddress()
                        + ":3306/spp?useUnicode=yes&characterEncoding=UTF-8", 
                        db.getUser(), db.getPassword());

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