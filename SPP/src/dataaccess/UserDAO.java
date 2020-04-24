package dataaccess;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public User getUser(String idUser){
        connection = dbc.getConnection();
        User user = null;

        try{
            String query = "Select * from user where id_user = '"+ idUser +"';";
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
                resultSet.getInt("id_type"));
                
        } 
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return user;
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
