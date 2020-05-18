package dataaccess;

import domain.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class ManagerDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;
        
    public ManagerDAO(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int insertManager(Manager manager){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into manager(name, middlename, lastname, position, email, id_organization)"
                     + " values(?, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getMiddlename());
            preparedStatement.setString(3, manager.getLastname());
            preparedStatement.setString(4, manager.getPosition());
            preparedStatement.setString(5, manager.geteMail());
            preparedStatement.setInt(6, manager.getIdOrganization());
            
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
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }
    public Manager getManager(int idManager){
        Manager manager = null;
        connection = databaseConnection.getConnection();
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
            databaseConnection.closeConnection();
        }
        return manager;
    }

    public int updateManager(Manager manager){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "UPDATE manager SET name = ?, middlename = ?, lastname  = ?, position = ?,"
                     + " email = ?, id_organization = ? WHERE id_manager = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getMiddlename());
            preparedStatement.setString(3, manager.getLastname());
            preparedStatement.setString(4, manager.getPosition());
            preparedStatement.setString(5, manager.geteMail());
            preparedStatement.setInt(6, manager.getIdOrganization());
            
            preparedStatement.setInt(7, manager.getId());
          
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
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }

    public int deleteManager(int idManager){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "DELETE FROM manager WHERE id_manager = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idManager);
            
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
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }   
}
