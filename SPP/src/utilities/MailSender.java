package utilities;

import utilities.datastructure.EmailCredentials;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static utilities.ExceptionLogger.writeException;

public class MailSender {
    private static EmailCredentials email = readConfFile();
    private static String sender;
    private static String password;
    private static String receiver;
    
    
    public static void writeConfFile(){
        String file = "email.conf";
        EmailCredentials email = new EmailCredentials("exceptionsSPP@gmail.com","03042020asd","midguet12@hotmail.com");
        
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileOut);
            
            writer.writeObject(email); 
            fileOut.close();
            writer.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static EmailCredentials readConfFile(){
        String file = "email.conf";
        EmailCredentials email = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            
            email = (EmailCredentials)reader.readObject();
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return email;
        
    }
    
    
    private static Session prepareEMail(){
        Properties smtpPropierties = new Properties();
        smtpPropierties.setProperty("mail.smtp.host", "smtp.gmail.com");
        smtpPropierties.setProperty("mail.smtp.starttls.enable", "true");
        smtpPropierties.setProperty("mail.smtp.port", "587");
        smtpPropierties.setProperty("mail.smtep.auth", "true");
        
        sender = email.getUser();
        password = email.getPassword();
        receiver = email.getReceiver();
        
        Session eMailSession = Session.getDefaultInstance(smtpPropierties);
        
        return eMailSession;
    }
    
    public static void sendEMail(String eMailTitle, String eMailBody){
        Session eMailSession = prepareEMail();
        
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
            
        } catch (AddressException ex) {
            writeException(ex, "utilities.ExceptionLogger");
        } catch (MessagingException ex) {
            writeException(ex, "utilities.ExceptionLogger");
        }
    }
}
