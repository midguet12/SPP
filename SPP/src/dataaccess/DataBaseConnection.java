package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DataBaseConnection {

    private Connection connection = null;    
    private final String user = "midguet";
    private final String password = "Magt2208";
     
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