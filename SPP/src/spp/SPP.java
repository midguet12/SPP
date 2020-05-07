package spp;

import dataaccess.ActivityDAO;
import dataaccess.DataBaseConnection;
import domain.Activity;
import java.util.Calendar;
import utilities.ExceptionLogger;

public class SPP {
    public static void main(String[] args) {
        
        /*try{
            System.out.println(Hola);
        } catch (Exception e){
            ExceptionLogger.notify(e,"SPP");
        }*/
        DataBaseConnection.writeConfFile();
        
        
    }
}
