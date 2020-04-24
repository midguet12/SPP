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
    
    public void insertReport(Report report){
        connection = dbc.getConnection();
        String query = "insert into report values(?, ?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(2, report.getReportType());
            preparedStatement.setString(3, report.getDescription());
            preparedStatement.setString(4, report.getFilePath());
            preparedStatement.setInt(5, report.getScore());
            preparedStatement.setDate(6, report.getUploadDate());
            preparedStatement.setString(7, report.getIdIntern());

            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
    public Report getReport(int idReport){
        Report report = null;
        connection = dbc.getConnection();
        String query = "Select * from report where id_report = '"+ idReport +"';";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);        
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            report = new Report(
                resultSet.getInt("id_report"), 
                resultSet.getString("report_type"),
                resultSet.getString("description"),
                resultSet.getString("filepath"),
                resultSet.getInt("score"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"));
                
        } 
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return report;
    }

    public void updateReport(int idReport, Report report){
        connection = dbc.getConnection();
        String query = "UPDATE report SET id_report = ?,  report_type = ?, description = ?, file_path = ?, score = ?, upload_date = ?, id_intern = ? WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(2, report.getReportType());
            preparedStatement.setString(2, report.getDescription());
            preparedStatement.setString(4, report.getFilePath());
            preparedStatement.setInt(4, report.getScore());
            preparedStatement.setDate(6, report.getUploadDate());
            preparedStatement.setString(7, report.getIdIntern());
            
            preparedStatement.setInt(8, idReport);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }

    public void deleteReport(int idReport){
        connection = dbc.getConnection();
        String query = "DELETE FROM report WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReport);
            
            preparedStatement.executeUpdate();
        }
        catch(SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }   
}