package dataaccess;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;


public class ProjectDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;

    public ProjectDAO() {
        dbc = new DataBaseConnection();
    }   
    
    public int insertProject(Project project){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into project values (?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setString(4, project.getResponsabilities());
            preparedStatement.setString(5, project.getActivities());
            preparedStatement.setInt(6, project.getDuration());
            preparedStatement.setString(7, project.getGeneralObjetive());
            preparedStatement.setString(8, project.getMetodology());
            preparedStatement.setString(9, project.getResources());
            preparedStatement.setInt(10, project.getIdManager());
            preparedStatement.setInt(11, project.getIdOrganization());
            
            affectedRows = preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }
    
    public Project getProject(int id){
        connection = dbc.getConnection();
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
        catch (SQLException ex) {
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return project;     
    }
    
    public int updateProject(int id,Project project){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "update project set id_project = ?, project_name = ?, description = ?, responsabilities = ?, activities = ?, duration = ?, general_objective = ?, metodology = ?, resources = ?, id_manager = ?, id_organization = ? where id_project = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setString(4, project.getResponsabilities());
            preparedStatement.setString(5, project.getActivities());
            preparedStatement.setInt(6, project.getDuration());
            preparedStatement.setString(7, project.getGeneralObjetive());
            preparedStatement.setString(8, project.getMetodology());
            preparedStatement.setString(9, project.getResources());
            preparedStatement.setInt(10, project.getIdManager());
            preparedStatement.setInt(11, project.getIdOrganization());
            
            preparedStatement.setInt(12, id);
            
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }     
        return affectedRows;
    }
    
    public int deleteProject(int id_project){
         int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "Delete from project where id_project = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_project);
            
            affectedRows = preparedStatement.executeUpdate();
        } 
        catch (SQLException ex) {
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return affectedRows;
    }
}