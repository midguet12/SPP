/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.Serializable;

/**
 *
 * @author midgu
 */
public class EmailConf implements Serializable{
    public String user;
    public String password;;
    public String receiver;
    
    public EmailConf(String user, String password, String receiver) {
        this.user = user;
        this.password = password;
        this.receiver = receiver;
        
    }
    
    
}
