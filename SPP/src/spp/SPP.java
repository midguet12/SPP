package spp;

import businesslogic.UserLogic;
import dataaccess.UserDAO;

public class SPP{             
    public static void main(String[] args) {
        UserDAO userdao = new UserDAO();
        
        System.out.println(userdao.getUser("1814123"));
    }
}
