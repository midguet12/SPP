package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteDAOTest {
    @Test
    public void testDeleteActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing deleteActivity() ", 1, activityDAO.deleteActivity(1));
    }   
    
    @Test
    public void testInsertDocument(){
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147", 1);
        DocumentDAO documentDAO = new DocumentDAO();
        
        assertEquals("Testing deleteActivity() ", 1, documentDAO.deleteDocument(1));
    }
    
    @Test
    public void testInsertIntern(){
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        
        assertEquals("Testing deleteActivity() ", 1, internDAO.deleteIntern("18012147"));
    }
        
    @Test
    public void testInsertManager(){
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", "dotcsv@gmail.com", 1);
        ManagerDAO managerDAO = new ManagerDAO();
        
        assertEquals("Testing deleteActivity() ", 1, managerDAO.deleteManager(2));
    }
        
    @Test
    public void testInsertOrganization(){
        Organization organization = new Organization(2, "YouTube", "Multimedia", "contact@youtube.com", "0180006565", 32, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        assertEquals("Testing deleteActivity() ", 1, organizationDAO.deleteOrganization(2));
    }
        
    @Test
    public void testInsertProject(){
        Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", "Servidores, equipos", 0, 0);
        ProjectDAO projectDAO = new ProjectDAO();
        
        assertEquals("Testing deleteActivity() ", 1, projectDAO.deleteProject(1));
    }
        
    @Test
    public void testInsertReport(){
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        
        assertEquals("Testing deleteActivity() ", 1, reportDAO.deleteReport(1));
    }
        
    @Test
    public void testInsertUser(){
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com", "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        
        assertEquals("Testing deleteActivity() ", 1, userDAO.deleteUser("18012147"));
    }
}
