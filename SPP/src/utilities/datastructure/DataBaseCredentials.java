package utilities.datastructure;

import java.io.Serializable;

public class DataBaseCredentials implements Serializable {
    private final String address;
    private final String user;
    private final String password;

    public DataBaseCredentials(String address, String user, String password){ 
        this.address = address; 
        this.user = user; 
        this.password = password; 
    } 

    public String getAddress() {
        return address;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
}
