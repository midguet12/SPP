package dataaccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DataBaseConnection {

    private Connection connection = null;    
    
    private DataBase db = readConfFile();
    
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
    
    public static DataBase readConfFile(){
        String file = "db.conf";
        DataBase db = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            
            db = (DataBase)reader.readObject();
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return db;
        
    }
    
     
    public void startConnection(){ 
        try{
            
            connection = DriverManager.getConnection("jdbc:mysql://"+db.address+":3306/spp?useUnicode=yes&characterEncoding=UTF-8", db.user,db.password);

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