package spp;

import dataaccess.UserDAO;
import domain.User;

public class SPP {
    public static void main(String[] args) {
        //User user = new User("s18012147", "Seth", "Diaz", "Diaz", "asdfad", "seth@algo.com", "2283578547", 1);
        User user = new User();
        
        //System.out.println(user);
        
        UserDAO userDAO = new UserDAO();
//        userDAO.insertUser(user);
        
        user = userDAO.getUser("18012193");
        System.out.println(user);
    }
}
