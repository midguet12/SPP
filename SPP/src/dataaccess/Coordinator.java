/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import dataaccess.DataBaseConnection;
import exceptionlog.ExceptionLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 *
 * @author midgu
 */
public class Coordinator {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    private String query = null;
    
    private int num_personal;
    protected String password;
    private String name;
    private String lastname;
    private String lastnameM;
    private String initialDate;
    private String endingDate;



    DataBaseConnection dbc = new DataBaseConnection();

    
    public Coordinator(int num_personal){
        connection = dbc.startConnection();
        
        try{
            query = "Select * from coordinador where num_personal = '"+ String.valueOf(num_personal) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(0, num_personal);
            
           
            
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //System.out.println(resultSet.getInt("num_personal")+ "," + resultSet.getString("contrasena")+","+resultSet.getString("nombre")+"," + resultSet.getString("apellido_paterno"));
            name = resultSet.getString("nombre");
            System.out.println(name);
            
            
        } 
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    
    
    
    public Coordinator(int personalNumber, String password, String name, String lastname){
        
        connection = dbc.startConnection();
        
        password = Encrypter.hasher(password);
      
        LocalDate localdate = LocalDate.now();
        
        query = "insert into coordinador(num_personal, contrasena, nombre, apellido_paterno, fecha_registro) values(?,?,?,?,?);";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, personalNumber);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4,lastname);
            preparedStatement.setString(5, localdate.toString());
            
            int rowsWritten = preparedStatement.executeUpdate();
            
            if (rowsWritten>0) {
                System.out.println("Escritura exitosa");    
            }
            
            
        } catch(Exception exception){
            //ExceptionLogger.notify(exception.getMessage());
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }

    }
    
    
 
       
        
}
    
    

