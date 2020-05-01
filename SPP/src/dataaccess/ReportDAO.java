package dataaccess;

import domain.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class ReportDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public ReportDAO(){
        dbc = new DataBaseConnection();
    }
    
    public int insertReport(Report report){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into report values(?, ?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(2, report.getReportType());
            preparedStatement.setString(3, report.getDescription());
            preparedStatement.setString(4, report.getFilePath());
            preparedStatement.setInt(5, report.getGrade());
            preparedStatement.setDate(6, report.getUploadDate());
            preparedStatement.setString(7, report.getIdIntern());

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
    public Report getReport(int idReport){
        Report report = null;
        connection = dbc.getConnection();
        String query = "Select * from report where id_report = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReport);
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            report = new Report(
                resultSet.getInt("id_report"), 
                resultSet.getString("id_type"),
                resultSet.getString("description"),
                resultSet.getString("filepath"),
                resultSet.getInt("grade"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"));
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return report;
    }

    public int updateReport(int idReport, Report report){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "UPDATE report SET id_report = ?,  id_type = ?, description = ?, filepath = ?, grade = ?, upload_date = ?, id_intern = ? WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(2, report.getReportType());
            preparedStatement.setString(3, report.getDescription());
            preparedStatement.setString(4, report.getFilePath());
            preparedStatement.setInt(5, report.getGrade());
            preparedStatement.setDate(6, report.getUploadDate());
            preparedStatement.setString(7, report.getIdIntern());
            
            preparedStatement.setInt(8, idReport);
          
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

    public int deleteReport(int idReport){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM report WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReport);
            
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
