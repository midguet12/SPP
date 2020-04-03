package PON EL NOMBRE DEL PACKAGE;

package congress;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ExceptionLogger{
    public static void writeException(String errorLine){
        FileWriter logFile = null;
        PrintWriter writeLog;
        LocalDateTime timeNow;

        try{
            logFile = new FileWriter("log.txt", true);
            writeLog = new PrintWriter(logFile);
            
            timeNow = LocalDateTime.now();
            writeLog.println(timeNow + " - " + errorLine);
        } 
        catch (IOException exeption) {
             System.out.println(exeption.getMessage());
        } 
        finally {
            try {
                if (null != logFile){
                    logFile.close();
                }
            } 
            catch (IOException exeption) {
                System.out.println(exeption.getMessage());
            } 
        }
    }
    public static void notify(String errorLine){
        FileWriter logFile = null;
        PrintWriter writeLog;
        LocalDateTime timeNow;

        try{
            logFile = new FileWriter("log.txt", true);
            writeLog = new PrintWriter(logFile);
            
            timeNow = LocalDateTime.now();
            writeLog.println(timeNow + " - " + errorLine);
            sendEMail("something went wrong at " + timeNow, errorLine);

        } 
        catch (IOException exeption) {
             System.out.println(exeption.getMessage());
        } 
        finally {
            try {
                if (null != logFile){
                    logFile.close();
                }
            } 
            catch (IOException exeption) {
                System.out.println(exeption.getMessage());
            } 
        }
    }
    public static void sendEMail(String eMailTitle, String eMailBody){
        Properties smtpPropierties = new Properties();
        smtpPropierties.setProperty("mail.smtp.host", "smtp.gmail.com");
        smtpPropierties.setProperty("mail.smtp.starttls.enable", "true");
        smtpPropierties.setProperty("mail.smtp.port", "587");
        smtpPropierties.setProperty("mail.smtep.auth", "true");
              
        Session eMailSession = Session.getDefaultInstance(smtpPropierties);
        String sender = "exeptionsspp@gmail.com";
        String password = "######";
        String receiver = "seth261099@gmail.com";
        String title = eMailTitle;
        String message = eMailBody;
        
        MimeMessage mail = new MimeMessage(eMailSession);
        try {
            mail.setFrom(new InternetAddress(sender));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mail.setSubject(title);
            mail.setText(message);
            
            Transport transporter = eMailSession.getTransport("smtp");
            transporter.connect(sender,password);
            transporter.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transporter.close();          
            
        } catch (AddressException exeption) {
            writeException(exeption.getMessage());
        } catch (MessagingException exeption) {
            writeException(exeption.getMessage());
        }
    }
} 