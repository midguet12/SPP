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
    
    public int insertOrganization(Organization organization){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into organization(name, sector, email, phone_number, id_state, city, address)"
                     + " values(?, ?, ?, ?, ?, ?, ?);"; 
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, organization.getName());
            preparedStatement.setString(2, organization.getSector());
            preparedStatement.setString(3, organization.geteMail());
            preparedStatement.setString(4, organization.getPhoneNumber());
            preparedStatement.setInt(5, organization.getIdState());
            preparedStatement.setString(6, organization.getPhoneNumber());
            preparedStatement.setString(7, organization.getAddress());
            
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
    public Organization getOrganization(int idOrganization){
        Organization organization = null;
        connection = dbc.getConnection();
        String query = "Select * from organization where id_organization = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);   
            preparedStatement.setInt(1, idOrganization);
            
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
                resultSet.getString("Address"));                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return organization;
    }

    public int updateOrganization(int idOrganization, Organization organization){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "UPDATE organization SET name = ?, sector = ?, email = ?, phone_number = ?,"
                     + " id_state = ?, city = ?, address = ? WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, organization.getName());
            preparedStatement.setString(2, organization.getSector());
            preparedStatement.setString(3, organization.geteMail());
            preparedStatement.setString(4, organization.getPhoneNumber());
            preparedStatement.setInt(5, organization.getIdState());
            preparedStatement.setString(6, organization.getCity());
            preparedStatement.setString(7, organization.getAddress());
            
            preparedStatement.setInt(8, idOrganization);
          
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

    public int deleteOrganization(int idOrganization){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM organization WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrganization);
            
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
