package dataaccess;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class UserDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public UserDAO(){
        dbc = new DataBaseConnection();
    }
    
    public void insertUser(User user){
        connection = dbc.getConnection();
        String query = "insert into user values(?, ?, ?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getIdUser());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMiddlename());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.geteMail());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setInt(8, user.getUserType());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public User getUser(String idUser){
        User user = null;
        connection = dbc.getConnection();
        //String query = "Select * from user where id_user = " +idUser+ ";";        
        String query = "Select * from user LEFT JOIN user_type ON user.id_type = user_type.id_type where id_user = " +idUser+ ";";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
            
            user = new User(
                resultSet.getString("id_user"), 
                resultSet.getString("name"),
                resultSet.getString("middlename"),
                resultSet.getString("lastname"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getString("type"));
                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return user;
    }

    public void updateUser(String idUser, User user){
        connection = dbc.getConnection();
        String query = "UPDATE user SET id_user = ?, name = ?, middlename = ?, lastname  = ?, password = ?, email = ?, phone_number = ?, id_type = ? WHERE id_user = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getIdUser());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMiddlename());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.geteMail());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setInt(8, user.getUserType());
            
            preparedStatement.setString(9, idUser);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }

    public void deleteUser(String idUser){
        connection = dbc.getConnection();
        String query = "DELETE FROM user WHERE id_user = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idUser);
            
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }   
}
