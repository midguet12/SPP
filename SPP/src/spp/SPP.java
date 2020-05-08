package spp;

import dataaccess.ActivityDAO;

import dataaccess.DocumentDAO;
import dataaccess.InternDAO;
import domain.Activity;
import domain.Document;
import domain.Intern;
import java.util.Calendar;


public class SPP {
    public static void main(String[] args) {
       /* ActivityDAO activity = new ActivityDAO();
        Activity activityn = new Activity("Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        activity.insertActivity(activityn);
        
        Document document = new Document("C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147", 1);
        DocumentDAO documentDAO = new DocumentDAO();
        documentDAO.insertDocument(document);
        */
       
        Intern intern = new Intern("18014123", "2018-2", 5, 2);
        InternDAO internDAO = new InternDAO();
        internDAO.insertIntern(intern);
        
        
        
        
        /*try{
            System.out.println(Hola);
        } catch (Exception e){
            ExceptionLogger.notify(e,"SPP");
        }
        */
        //MailSender.writeConfFile();
        //System.out.println(MailSender.readConfFile().user);
        
        /*
        try{
            if (activity.getActivity(3) == null) {
                System.out.println("No existe estudiante");
            }else{
                Activity activityn = activity.getActivity(3);
                System.out.println(activityn.getValue());
            }
            
            
            
            
            
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }*/
        
       
        
        
       
        
    }
}
