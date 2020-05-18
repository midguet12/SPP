import java.io.FileOutputStream; 
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

  
class DataBase implements Serializable { 
	String address;
	String user;
	String password;
	

	public DataBase(String address, String user, String password){ 
        this.address = address; 
        this.user = user; 
        this.password = password; 
        
    } 
  
} 
  
public class Writer { 
	public static void printdata(DataBase a){ 
		System.out.println(a.address);
		System.out.println(a.user);
		System.out.println(a.password);
      
    } 
  
public static void main(String[] args) 
    { 
        String filename = "db.conf"; 
        DataBase data = new DataBase("192.168.1.120", "midguet","Magt2208"); 

        try { 

            FileOutputStream file = new FileOutputStream (filename); 
            ObjectOutputStream out = new ObjectOutputStream (file); 
            
            out.writeObject(data);  

            out.close(); 
            file.close(); 
        
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        }   

        
    } 
} 
