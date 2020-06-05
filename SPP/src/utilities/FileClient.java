package utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

public class FileClient {
    
    String serverPath = "/FTP";
    String user = "upload";
    String server = "midguetg.ddns.net";
    String password = "Magt2208";

    
    String path = "/FTP";
    File file = new File("hola.pdf");
    
    FTPClient ftp = new FTPClient();
    
    
        

    public FileClient(){
        try {
            ftp.connect(server);
            
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public boolean insertFile(){
        
        boolean b = false;
        
        try {
            
            ftp.login(user, password);
            
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory(path);
                
            b = ftp.storeFile("hola.pdf",  new FileInputStream(file));
            
        } catch (IOException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
        
    }
    
    public boolean getFile(){
        boolean b = false;
        
        OutputStream out;
        try {
            System.out.println("hola");
            b = ftp.login(user, password);
            
            
            
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory(path);
            
            out = new BufferedOutputStream(new FileOutputStream(file));
            b = ftp.retrieveFile(file.getName(), out);
            out.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return b;
        
    }
    
    
}
