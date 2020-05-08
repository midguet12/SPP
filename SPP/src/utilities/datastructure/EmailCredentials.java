package utilities.datastructure;

import java.io.Serializable;

public class EmailCredentials implements Serializable{
    private final String user;
    private final String password;;
    private final String receiver;
    
    public EmailCredentials(String user, String password, String receiver) {
        this.user = user;
        this.password = password;
        this.receiver = receiver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getReceiver() {
        return receiver;
    }
}
