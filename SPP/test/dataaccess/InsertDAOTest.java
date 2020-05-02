package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class InsertDAOTest {
    @Test
    public void testInsertActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing insertActivity() ", 1, activityDAO.insertActivity(activity));    
    }
    
    @Test
    public void testInsertDocument(){
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147", 1);
        DocumentDAO documentDAO = new DocumentDAO();
        
        assertEquals("Testing insertDocument() ", 1, documentDAO.insertDocument(document));    
    }
    
    @Test
    public void testInsertIntern(){
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        
        assertEquals("Testing insertIntern() ", 1, internDAO.insertIntern(intern));    
    }
        
    @Test
    public void testInsertManager(){
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", "dotcsv@gmail.com", 1);
        ManagerDAO managerDAO = new ManagerDAO();
        
        assertEquals("Testing insertManager() ", 1, managerDAO.insertManager(manager));   
    }
        
    @Test
    public void testInsertOrganization(){
        Organization organization = new Organization(2, "YouTube", "Multimedia", "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        assertEquals("Testing insertOrganization() ", 1, organizationDAO.insertOrganization(organization));   
    }
        
    @Test
    public void testInsertProject(){
        Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", "Servidores, equipos", 2, 2);
        ProjectDAO projectDAO = new ProjectDAO();
        
        assertEquals("Testing insertProject() ", 1, projectDAO.insertProject(project));   
    }
        
    @Test
    public void testInsertReport(){
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        
        assertEquals("Testing insertReport() ", 1, reportDAO.insertReport(report));   
    }
        
    @Test
    public void testInsertUser(){
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com", "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        
        assertEquals("Testing insertUser() ", 1, userDAO.insertUser(user));   
    }
}
