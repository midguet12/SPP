package dataaccess;

import domain.Activity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class ActivityDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public ActivityDAO(){
        dbc = new DataBaseConnection();
    }
    
    public void insertActivity(Activity activity){
        connection = dbc.getConnection();
        String query = "insert into activity values(?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, activity.getId());
            preparedStatement.setString(2, activity.getName());
            preparedStatement.setString(3, activity.getValue());
            preparedStatement.setString(4, activity.getDescription());
            preparedStatement.setDate(5, activity.getUploadDate());
            preparedStatement.setString(6, activity.getIdIntern());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public Activity getActivity(int idActivity){
        Activity activity = null;
        connection = dbc.getConnection();
        String query = "Select * from activity where id_activity = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setInt(1, idActivity);
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            activity = new Activity(
                resultSet.getInt("id_activity"), 
                resultSet.getString("name"),
                resultSet.getString("value"),
                resultSet.getString("description"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"));
                
        } 
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return activity;
    }

    public void updateActivity(int idActivity, Activity activity){
        connection = dbc.getConnection();
        String query = "UPDATE activity SET id_activity = ?, name = ?, value = ?, description = ?, upload_date = ?, id_intern = ? WHERE id_activity = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, activity.getId());
            preparedStatement.setString(2, activity.getName());
            preparedStatement.setString(3, activity.getValue());
            preparedStatement.setString(4, activity.getDescription());
            preparedStatement.setDate(5, activity.getUploadDate());
            preparedStatement.setString(6, activity.getIdIntern());
            
            preparedStatement.setInt(7, idActivity);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }

    public void deleteActivity(int idActivity){
        connection = dbc.getConnection();
        String query = "DELETE FROM activity WHERE id_activity = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idActivity);
            
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
