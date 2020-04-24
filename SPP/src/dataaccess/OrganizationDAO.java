package dataaccess;

import domain.Organization;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class OrganizationDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public OrganizationDAO(){
        dbc = new DataBaseConnection();
    }
    
    public void insertOrganization(Organization organization){
        connection = dbc.getConnection();
        String query = "insert into organization values(?, ?, ?, ?, ?, ?, ?, ?);"; 
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, organization.getId());
            preparedStatement.setString(2, organization.getName());
            preparedStatement.setString(3, organization.getSector());
            preparedStatement.setString(4, organization.geteMail());
            preparedStatement.setString(5, organization.getPhoneNumber());
            preparedStatement.setInt(6, organization.getIdState());
            preparedStatement.setString(7, organization.getPhoneNumber());
            preparedStatement.setString(8, organization.getAddress());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public Organization getOrganization(String idOrganization){
        Organization organization = null;
        connection = dbc.getConnection();
        String query = "Select * from organization where id_organization = '?';";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);   
            preparedStatement.setString(1, idOrganization);
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            organization = new Organization(
                resultSet.getInt("id_organization"), 
                resultSet.getString("name"),
                resultSet.getString("sector"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getInt("id_state"),
                resultSet.getString("City"), 
                resultSet.getString("Adress"));
                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());

        }
        finally{
            dbc.closeConnection();
        }
        return organization;
    }

    public void updateOrganization(String idOrganization, Organization organization){
        connection = dbc.getConnection();
        String query = "UPDATE organization SET id_organization = ?, name = ?, sector = ?, email = ?, phone_number = ?, id_state = ?, city = ?, adress = ? WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, organization.getId());
            preparedStatement.setString(2, organization.getName());
            preparedStatement.setString(3, organization.getSector());
            preparedStatement.setString(4, organization.geteMail());
            preparedStatement.setString(5, organization.getPhoneNumber());
            preparedStatement.setInt(6, organization.getIdState());
            preparedStatement.setString(7, organization.getCity());
            preparedStatement.setString(8, organization.getAddress());
            
            preparedStatement.setString(9, idOrganization);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }

    public void deleteOrganization(int idOrganization){
        connection = dbc.getConnection();
        String query = "DELETE FROM organization WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrganization);
            
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
