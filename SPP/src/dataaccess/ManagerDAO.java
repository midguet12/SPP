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
    
    public int insertManager(Manager manager){
        int affectedRows = 0;
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
            
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }
    public Manager getManager(int idManager){
        Manager manager = null;
        connection = dbc.getConnection();
        String query = "Select * from manager where id_manager = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);        
            preparedStatement.setInt(1, idManager);
            
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
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return manager;
    }

    public int updateManager(int idManager, Manager manager){
        int affectedRows = 0;
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
          
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }

    public int deleteManager(int idManager){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM manager WHERE id_manager = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idManager);
            
            affectedRows = preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }   
}
