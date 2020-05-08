package spp;

import bussineslogic.StringChecker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
//import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import sun.net.ftp.FtpClient;

public class SPP {
    public static void main(String[] args) {
       
        File file = new File("error.log");
        //OutputStream out = new OutputStream();
        
        
        
        FTPClient ftp = new FTPClient();
        
        try{
            String ftpServer = "midguet.ddns.net";
            String user = "spp";
            String password = "Magt2208";
            
            ftp.connect(ftpServer);
            
            
            
            System.out.println(ftp.login(user, password));
            
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory("/mnt/user/spp");
            
            
            
            
            /*FTPFile[] ftpl = ftp.listFiles();
            
            for (FTPFile ff : ftpl) {
                System.out.println(ff.getName());
            }*/
            
            
            
            
            //ftp.retrieveFile("hola.pdf", local);
            
            System.out.println(ftp.storeFile("error.log", new FileInputStream(file)));
            
            
            
            
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

   
}
