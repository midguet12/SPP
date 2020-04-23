package dataaccess;

import domain.Coordinator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DataBaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    private String user;
    private String password;
    
    public DataBaseConnection(){
        user = "midguet";
        password = "Magt2208";
    }

    private Connection startConnection(){ //Metodo para iniciar conexion
        try{
            connection = DriverManager.getConnection("jdbc:mysql://midguet.ddns.net:3306/spp?useUnicode=yes&characterEncoding=UTF-8", user, password);
            //Conexion a base de datos, driver + servicio de bd + direccion de servidor + puerto + base de datos + se especifica grupo de caracteres + usuario + contraseña
            statement = connection.createStatement();
        }
        catch(SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        return connection;
    }
    
    private void closeConnection(){ //Metodo para cerrar conexion 
        if (resultSet != null) {
            try {
                resultSet.close();
            } 
            catch (SQLException exception) {
                ExceptionLogger.notify(exception.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } 
            catch (SQLException exception) {
                ExceptionLogger.notify(exception.getMessage());
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } 
            catch (SQLException exception) {
                ExceptionLogger.notify(exception.getMessage());
            }
        }
    }
    
    public void insertCoordinator(Coordinator coord){
        startConnection();
        String query = "insert into coordinador(num_personal, nombre, apellido_paterno) values(?,?,?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1, coord.getPersonalNumber());
            preparedStatement.setString(2, coord.getName() );
            preparedStatement.setString(3, coord.getMiddlename());
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }
    public Coordinator getCoordinator(int personalNumber){
        startConnection();
        Coordinator coord = null;

        try{
            String query = "Select * from coordinador where num_personal = '"+ String.valueOf(personalNumber) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
            
            coord = new Coordinator(
                resultSet.getInt("num_personal"), 
                resultSet.getString("nombre"),
                resultSet.getString("apellido_paterno"),
                resultSet.getString("apellido_materno"));
        } 
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
        return coord;
    }

    public void update(){

        startConnection();

        String query = "UPDATE customers SET name=? WHERE name=?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Midguet");
            preparedStatement.setString(2, "Seth");
           
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se edito correctamente");
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }

    public void delete(){

        startConnection();

        String query = "DELETE FROM customers WHERE name=?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Seth");
            
            int rowsDeleted = preparedStatement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Se elimino correctamente");
            }
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }   
    
}