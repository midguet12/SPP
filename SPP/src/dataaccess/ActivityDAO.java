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
    private String className = this.getClass().getName();
        
    public ActivityDAO(){
        dbc = new DataBaseConnection();
    }
    
    public int insertActivity(Activity activity){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into activity(name, value, description, upload_date, id_intern)"
                     + " values(?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, activity.getName());
            preparedStatement.setString(2, activity.getValue());
            preparedStatement.setString(3, activity.getDescription());
            preparedStatement.setDate(4, activity.getUploadDate());
            preparedStatement.setString(5, activity.getIdIntern());
            
            affectedRows = preparedStatement.executeUpdate();
            
        }
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (NullPointerException ex){
            ExceptionLogger.notify(ex, className);
            System.out.println("Base de datos no disponible, contacte a administrador");
        }
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        
        finally{
            dbc.closeConnection();
        }
        
        return affectedRows;
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
        
        catch (SQLException ex){
            //ExceptionLogger.notify(ex, className);
            
        }
        finally{
            dbc.closeConnection();
        }
        return activity;
    }

    public int updateActivity(int idActivity, Activity activity){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "UPDATE activity SET name = ?, value = ?, description = ?, upload_date = ?,"
                     + " id_intern = ? WHERE id_activity = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, activity.getName());
            preparedStatement.setString(2, activity.getValue());
            preparedStatement.setString(3, activity.getDescription());
            preparedStatement.setDate(4, activity.getUploadDate());
            preparedStatement.setString(5, activity.getIdIntern());
            
            preparedStatement.setInt(6, idActivity);
          
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }

    public int deleteActivity(int idActivity){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM activity WHERE id_activity = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idActivity);
            
            affectedRows = preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }   
}
