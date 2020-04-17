package dataaccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import exceptionlog.ExceptionLogger;

//Hasher
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

/**
 *
 * @author midg
 */
public class DataBaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    private String user;
    private String password;
    
    public DataBaseConnection(){
        user = "midguet";
        password = "Magt2208";
    }

    private void startConnection(){ //Metodo para iniciar conexion
        try{
            connection = DriverManager.getConnection("jdbc:mysql://midguet.ddns.net:3306/spp?useUnicode=yes&characterEncoding=UTF-8", user, password);
            //Conexion a base de datos, driver + servicio de bd + direccion de servidor + puerto + base de datos + se especifica grupo de caracteres + usuario + contraseña
            statement = connection.createStatement();
        }
        catch(SQLException exception){
            String e = exception.getMessage();
            System.out.println(e);
            ExceptionLogger.notify(e);
        }
    }
    
    private void closeConnection(){ //Metodo para cerrar conexion 
        if (resultSet != null) {
            try {
                resultSet.close();
            } 
            catch (SQLException exception) {
                System.out.println(exception.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } 
                catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } 
                catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            //System.out.println("Coneccion cerrada");
    }    

    public void create(){

        startConnection();

        String query = "INSERT INTO customers (name, address) VALUES (?, ?)"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query); //Se convierte consulta a declaracion
            preparedStatement.setString(1, "Seth"); //Siendo declaracion, defines el valor del interrogante de acuerdo a su posicion con estos metodos
            preparedStatement.setString(2, "Coatepec");
           
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Se agregó correctamente");
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }

    public void read(){

        startConnection();

        try{
            resultSet = statement.executeQuery("Select * from customers");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name")+ "," + resultSet.getString("address"));
            }
        } 
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }

    public void update(){

        startConnection();

        String query = "UPDATE customers SET name=? WHERE name=?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Midguet");
            preparedStatement.setString(2, "Seth");
           
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se edito correctamente");
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }

    public void delete(){

        startConnection();

        String query = "DELETE FROM customers WHERE name=?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Seth");
            
            int rowsDeleted = preparedStatement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Se elimino correctamente");
            }
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    }
    
    public void createCoordinator(int personalNumber, String password, String name, String lastname){
        
        LocalDate localdate = LocalDate.now();
        
        String query = "insert into coordinador(num_personal, contrasena, nombre, apellido_paterno, fecha_registro) values(?,?,?,?,?)";
        startConnection();
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
            System.out.println(exception.getMessage());
            ExceptionLogger.notify(exception.getMessage());
        }
        finally{
            closeConnection();
        }
    
        
        
        
        
        
    }
    
    
}