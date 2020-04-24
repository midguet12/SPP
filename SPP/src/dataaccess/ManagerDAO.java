package dataaccess;

import domain.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class ManagerDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public ManagerDAO(){
        dbc = new DataBaseConnection();
    }
    
    public void insertManager(Manager manager){
        connection = dbc.getConnection();
        String query = "insert into manager values(?, ?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, manager.getId());
            preparedStatement.setString(2, manager.getName());
            preparedStatement.setString(3, manager.getMiddlename());
            preparedStatement.setString(4, manager.getLastname());
            preparedStatement.setString(5, manager.getPosition());
            preparedStatement.setString(6, manager.geteMail());
            preparedStatement.setInt(8, manager.getIdOrganization());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public Manager getManager(int idManager){
        Manager manager = null;
        connection = dbc.getConnection();
        String query = "Select * from manager where id_manager = '"+ idManager +"';";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);        
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            manager = new Manager(
                resultSet.getInt("id_manager"), 
                resultSet.getString("name"),
                resultSet.getString("middlename"),
                resultSet.getString("lastname"),
                resultSet.getString("position"),
                resultSet.getString("email"),
                resultSet.getInt("id_organization"));
                
        } 
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return manager;
    }

    public void updateManager(int idManager, Manager manager){
        connection = dbc.getConnection();
        String query = "UPDATE manager SET id_manager = ?, name = ?, middlename = ?, lastname  = ?, position = ?, email = ?, id_type = ? WHERE id_manager = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, manager.getId());
            preparedStatement.setString(2, manager.getName());
            preparedStatement.setString(3, manager.getMiddlename());
            preparedStatement.setString(4, manager.getLastname());
            preparedStatement.setString(5, manager.getPosition());
            preparedStatement.setString(6, manager.geteMail());
            preparedStatement.setInt(7, manager.getIdOrganization());
            
            preparedStatement.setInt(8, idManager);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }

    public void deleteManager(int idManager){
        connection = dbc.getConnection();
        String query = "DELETE FROM manager WHERE id_manager = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idManager);
            
            preparedStatement.executeUpdate();
        }
        catch(SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }   
}
