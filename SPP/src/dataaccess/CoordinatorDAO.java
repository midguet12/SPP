package dataaccess;

import domain.Coordinator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinatorDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public CoordinatorDAO(){
        dbc = new DataBaseConnection();
    }
    
    public void insertCoordinator(Coordinator coord){
        connection = dbc.getConnection();
        String query = "insert into coordinador(num_personal, nombre, apellido_paterno) values(?,?,?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, coord.getPersonalNumber());
            preparedStatement.setString(2, coord.getName() );
            preparedStatement.setString(3, coord.getMiddlename());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public Coordinator getCoordinator(int personalNumber){
        connection = dbc.getConnection();
        Coordinator coord = null;

        try{
            String query = "Select * from coordinador where num_personal = '"+ String.valueOf(personalNumber) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
            
            coord = new Coordinator(
                resultSet.getString("num_personal"), 
                resultSet.getString("nombre"),
                resultSet.getString("apellido_paterno"),
                resultSet.getString("apellido_materno"));
        } 
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return coord;
    }

//    public void update(){
//
//        dbc.startConnection();
//
//        String query = "UPDATE customers SET name=? WHERE name=?";
//        
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "Midguet");
//            preparedStatement.setString(2, "Seth");
//           
//            int rowsInserted = preparedStatement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Se edito correctamente");
//            }
//        }
//        catch (SQLException exception){
//            System.out.println(exception.getMessage());
//        }
//        finally{
//            dbc.closeConnection();
//        }
//    }
//
//    public void delete(){
//
//        dbc.startConnection();
//
//        String query = "DELETE FROM customers WHERE name=?";
//        
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,"Seth");
//            
//            int rowsDeleted = preparedStatement.executeUpdate();
//            if(rowsDeleted>0){
//                System.out.println("Se elimino correctamente");
//            }
//        }
//        catch(SQLException exception){
//            System.out.println(exception.getMessage());
//        }
//        finally{
//            dbc.closeConnection();
//        }
//    }   
}
