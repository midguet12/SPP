package dataaccess;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;


public class ProjectDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;

    public ProjectDAO() {
        databaseConnection = new DataBaseConnection();
    }   
    
    public int insertProject(Project project){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into project(project_name, description, responsabilities, activities,"
                     + " duration, general_objective, metodology, resources, id_manager, id_organization)"
                     + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getResponsabilities());
            preparedStatement.setString(4, project.getActivities());
            preparedStatement.setInt(5, project.getDuration());
            preparedStatement.setString(6, project.getGeneralObjetive());
            preparedStatement.setString(7, project.getMetodology());
            preparedStatement.setString(8, project.getResources());
            preparedStatement.setInt(9, project.getIdManager());
            preparedStatement.setInt(10, project.getIdOrganization());
            
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
    
    public Project getProject(int id){
        connection = databaseConnection.getConnection();
        Project project = null;
            
        try {
            String query = "Select * from project where id_project = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            project = new Project(
                resultSet.getInt("id_project"),
                resultSet.getString("project_name"),
                resultSet.getString("description"),
                resultSet.getString("responsabilities"),
                resultSet.getString("activities"),
                resultSet.getInt("duration"),
                resultSet.getString("general_objective"),
                resultSet.getString("metodology"),
                resultSet.getString("resources"),
                resultSet.getInt("id_manager"),
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
        return project;     
    }
    
    public int updateProject(Project project){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "update project set project_name = ?, description = ?, responsabilities = ?,"
                     + " activities = ?, duration = ?, general_objective = ?, metodology = ?,"
                     + " resources = ?, id_manager = ?, id_organization = ? where id_project = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getResponsabilities());
            preparedStatement.setString(4, project.getActivities());
            preparedStatement.setInt(5, project.getDuration());
            preparedStatement.setString(6, project.getGeneralObjetive());
            preparedStatement.setString(7, project.getMetodology());
            preparedStatement.setString(8, project.getResources());
            preparedStatement.setInt(9, project.getIdManager());
            preparedStatement.setInt(10, project.getIdOrganization());
            
            preparedStatement.setInt(11, project.getId());
            
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
    
    public int deleteProject(int id_project){
         int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "Delete from project where id_project = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_project);
            
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