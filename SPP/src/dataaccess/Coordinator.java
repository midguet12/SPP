/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import dataaccess.DataBaseConnection;


/**
 *
 * @author midgu
 */
public class Coordinator {
    
    public Coordinator(int personalNumber, String password, String name, String lastname){
        DataBaseConnection dbc = new DataBaseConnection();
        password = Encrypter.hasher(password);
        
        dbc.createCoordinator(personalNumber,password, name, lastname);
        
        
    }
    public
}
