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
    
    public void insertDocument(Document document){
        connection = dbc.getConnection();
        String query = "insert into document values(?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getIdDocument());
            preparedStatement.setString(2, document.getFilePath());
            preparedStatement.setDate(3, document.getUploadDate());
            preparedStatement.setString(4, document.getIdIntern());
            preparedStatement.setInt(5, document.getDocumentType());

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
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
                resultSet.getInt("document_type"));
                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
        return document;
    }

    public void updateDocument(int idDocument, Document document){
        connection = dbc.getConnection();
        String query = "UPDATE document SET id_document = ?, file_path = ?, upload_date = ?, id_intern = ?, document_type = ? WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getIdDocument());
            preparedStatement.setString(2, document.getFilePath());
            preparedStatement.setDate(3, document.getUploadDate());
            preparedStatement.setString(4, document.getIdIntern());
            preparedStatement.setInt(5, document.getDocumentType());
            
            preparedStatement.setInt(6, idDocument);
          
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            ExceptionLogger.notify(ex.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
            
    public void deleteDocument(int idDocument){
        connection = dbc.getConnection();
        String query = "DELETE FROM document WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDocument);
            
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
