package dataaccess;

import domain.Intern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class InternDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public InternDAO(){
        dbc = new DataBaseConnection();
    }
    
    public int insertIntern(Intern intern){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into intern values(?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, intern.getIdIntern());
            preparedStatement.setString(2, intern.getPeriod());
            preparedStatement.setInt(3, intern.getGrade());
            preparedStatement.setInt(4, intern.getIdProject());
            
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
    public Intern getIntern(String idIntern){
        Intern intern = null;
        connection = dbc.getConnection();
        String query = "Select * from intern where id_intern = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1, idIntern);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            intern = new Intern(
                resultSet.getString("id_intern"), 
                resultSet.getString("period"),
                resultSet.getInt("grade"),
                resultSet.getInt("id_project"));                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return intern;
    }

    public int updateIntern(String idIntern, Intern intern){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "UPDATE intern SET id_intern = ?, period = ?, grade = ?, id_project = ? WHERE id_intern = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, intern.getIdIntern());
            preparedStatement.setString(2, intern.getPeriod());
            preparedStatement.setInt(3, intern.getGrade());
            preparedStatement.setInt(4, intern.getIdProject());
            
            preparedStatement.setString(5, idIntern);
          
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

    public int deleteIntern(String idIntern){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM intern WHERE id_intern = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idIntern);
            
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
