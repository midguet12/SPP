package dataaccess;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;

    public ProjectDAO() {
        dbc = new DataBaseConnection();
    }
    
    public void insertProject(Project project){
        connection = dbc.getConnection();
        String query = "insert into project values (?,?,?,?,?,?,?,?,?,?);";
        
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
            
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            dbc.closeConnection();
        }
        
        
    }
    
    public Project getProject(int id_project){
        connection = dbc.getConnection();
        Project project = null;
        
       
            
        try {
            String query = "Select * from project";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
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
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dbc.closeConnection();
            
        }
        return project;
      
    }
    
    public void updateProject(int id_project,Project project){
        connection = dbc.getConnection();
        String query = "update project set id_project = ?, project_name = ?, description = ?, responsabilities = ?, activities = ?, duration = ?, general_objective = ?, metodology = ?, resources = ?, id_manager = ?, id_organization = ?";
        
        
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
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dbc.closeConnection();
        }
        
        
        
    }
    
    public void deteleProject(int id_project){
        connection = dbc.getConnection();
        String query = "Delete from project where id_project = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_project);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dbc.closeConnection();
        }
        
        
    }
    
    
    
    
    
    
    
    
}
