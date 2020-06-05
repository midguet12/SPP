package spp;

import dataaccess.UserDAO;
import domain.User;
import utilities.FileClient;

public class SPP {
    public static void main(String[] args) {
        /*UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser("18012193");
        System.out.println(user);
        
        */
        
        
        FileClient ftp = new FileClient();
        
        
        
        
        System.out.println(ftp.getFile());
        
        
        
        
    }
}
