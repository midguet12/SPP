package dataaccess;

import domain.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DocumentDAO {
    private final DataBaseConnection dbc;
    private Connection connection;
    private ResultSet resultSet;
        
    public DocumentDAO(){
        dbc = new DataBaseConnection();
    }
    
    public int insertDocument(Document document){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "insert into document(file_path, upload_date, id_intern, id_type)"
                     + " values(?, ?, ?, ?);"; 
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, document.getFilePath());
            preparedStatement.setDate(2, document.getUploadDate());
            preparedStatement.setString(3, document.getIdIntern());
            preparedStatement.setInt(4, document.getDocumentType());

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
    public Document getDocument(int idDocument){
        Document document = null;
        connection = dbc.getConnection();
        String query = "Select * from document where id_document = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);    
            preparedStatement.setInt(1, idDocument);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            document = new Document(
                resultSet.getInt("id_document"), 
                resultSet.getString("file_path"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"),
                resultSet.getInt("id_type"));                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            dbc.closeConnection();
        }
        return document;
    }

    public int updateDocument(int idDocument, Document document){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "UPDATE document SET file_path = ?, upload_date = ?, id_intern = ?,"
                     + " id_type = ? WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, document.getFilePath());
            preparedStatement.setDate(2, document.getUploadDate());
            preparedStatement.setString(3, document.getIdIntern());
            preparedStatement.setInt(4, document.getDocumentType());
            
            preparedStatement.setInt(5, idDocument);
          
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
            
    public int deleteDocument(int idDocument){
        int affectedRows = 0;
        connection = dbc.getConnection();
        String query = "DELETE FROM document WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDocument);
            
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
