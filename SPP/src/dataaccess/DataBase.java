/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.Serializable;

/**
 *
 * @author midgu
 */
public class DataBase implements Serializable {
        public String address;
	public String user;
        public String password;

	public DataBase(String address, String user, String password){ 
            this.address = address; 
            this.user = user; 
            this.password = password; 
        
        } 
    
}
