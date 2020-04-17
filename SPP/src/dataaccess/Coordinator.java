package dataaccess;
import exceptionlog.ExceptionLogger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author midg
 */
public class Coordinator {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    private String query = null;
    
    private int num_personal;
    protected String password;
    private String name;
    private String lastname;
    private String lastnameM;
    private Date initialDate;
    private Date endingDate;

    DataBaseConnection dbc = new DataBaseConnection();
    
    public Coordinator(int num_personal,String password){
        connection = dbc.startConnection();
        
        try{
            query = "Select * from coordinador where num_personal = '"+ String.valueOf(num_personal) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(0, num_personal);
            
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
            
            if (verifyPassword(num_personal,password)) {
                this.num_personal = resultSet.getInt("num_personal");
                this.name = resultSet.getString("nombre");
                this.lastname = resultSet.getString("apellido_paterno"); //Asignacion de datos obtenidos a atributos de objeto
                this.lastnameM = resultSet.getString("apellido_materno");
                this.initialDate = resultSet.getDate("fecha_registro");
                this.endingDate = resultSet.getDate("fecha_baja");
            }            
        } 
        catch (SQLException exception){
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }
    }
     
    public Coordinator(int personalNumber, String password, String name, String lastname){
        
        connection = dbc.startConnection();
        password = Encrypter.hasher(password);
        LocalDate localdate = LocalDate.now();
        
        query = "insert into coordinador(num_personal, contrasena, nombre, apellido_paterno, fecha_registro) values(?,?,?,?,?);";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, personalNumber);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4,lastname);
            preparedStatement.setString(5, localdate.toString());
            
            int rowsWritten = preparedStatement.executeUpdate();
            
            if (rowsWritten>0) {
                System.out.println("Escritura exitosa");    
            }           
        } catch(Exception exception){
            ExceptionLogger.notify(exception.getMessage());
            //System.out.println(exception.getMessage());
        }
        finally{
            dbc.closeConnection();
        }

    }
    
    public boolean verifyPassword(int num_personal,String password){
        boolean verification = false;
        dbc.startConnection();
        try{
            query = "Select contrasena from coordinador where num_personal = '"+ String.valueOf(num_personal) +"';";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(0, num_personal);
   
            resultSet = preparedStatement.executeQuery(); //Obtencion de datos de consulta
            resultSet.next();
  
           
            this.password = resultSet.getString("contrasena"); //Obtencion de contraseña
            
           
            if (this.password.equals(Encrypter.hasher(password))) {
                verification = true;
            } else {
                //System.out.println("Contraseña incorrecta");
            }
            
            
        } catch (Exception e){  
            ExceptionLogger.notify(e.getMessage());
        } finally{
            dbc.closeConnection();
        }        
        return verification;       
    }    
    public String getName(){
        return this.name;
    }
 
       
        
}
    
    

