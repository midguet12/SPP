package dataaccess;
import exceptionlog.ExceptionLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author SNDD_
 */
public class Practicante {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    private String query = null;
    
    private int matricula;
    protected String password;
    private String name;
    private String lastname;
    private String lastnameM;
    private int personalNumber;
    private int idProyect;

    DataBaseConnection dbc = new DataBaseConnection();
    
    public Practicante(int matricula,String password){
        connection = dbc.startConnection();
        
        try{
            query = "Select * from coordinador where matricula = '"+ String.valueOf(matricula) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
            
            if (verifyPassword(matricula, password)) {
                this.matricula = resultSet.getInt("matricula");
                this.name = resultSet.getString("nombre");
                this.lastname = resultSet.getString("apellido_paterno"); //Asignacion de datos obtenidos a atributos de objeto
                this.lastnameM = resultSet.getString("apellido_materno");
            }            
        } 
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
     
    public Practicante(int matricula, String password, String name, String lastname){
        
        connection = dbc.startConnection();
        password = Encrypter.hasher(password);
        LocalDate localdate = LocalDate.now();
        
        query = "insert into practicante(matricula, contrasena, nombre, apellido_paterno) values(?,?,?,?,?);";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, matricula);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4,lastname);
                        
            int rowsWritten = preparedStatement.executeUpdate();
            
            if (rowsWritten > 0) {
                System.out.println("Escritura exitosa");    
            }           
        } catch(SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }

    }
    
    public boolean verifyPassword(int matricula,String password){
        boolean verification = false;
        dbc.startConnection();
        try{
            query = "Select contrasena from practicante where matricula = '"+ String.valueOf(matricula) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
   
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
             
            this.password = resultSet.getString("contrasena"); //Obtencion de contraseña
                       
            if (this.password.equals(Encrypter.hasher(password))) {
                verification = true;
            }            
        } catch (SQLException e){  
            ExceptionLogger.notify(e.getMessage());
        } finally{
            dbc.closeConnection();
        }                
        return verification;       
    }    
    public String getName(){
        return this.name;
    }
    public void setProyect(int idProyect){
        this.idProyect = idProyect;
        
        dbc.startConnection();
        query = "UPDATE practicante SET id_proyecto = ? WHERE matricula = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.idProyect);
            preparedStatement.setInt(2, this.matricula);
           
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se edito correctamente");
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
}
    
    

