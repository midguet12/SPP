package spp;

import dataaccess.ActivityDAO;
import dataaccess.DataBaseConnection;
import domain.Activity;
import java.util.Calendar;
import utilities.ExceptionLogger;
import utilities.MailSender;

public class SPP {
    public static void main(String[] args) {
        
        /*try{
            System.out.println(Hola);
        } catch (Exception e){
            ExceptionLogger.notify(e,"SPP");
        }*/
        
        //System.out.println(DataBaseConnection.readConfFile().address);
        MailSender.writeConfFile();
        
    }
}
