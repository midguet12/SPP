package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class UpdateDAOTest {
    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        activity.setName("Project");
        assertEquals("Testing updateActivity() ", 1, activityDAO.updateActivity(1, activity));
    }
    
    @Test
    public void testInsertDocument(){
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147", 1);
        DocumentDAO documentDAO = new DocumentDAO();
        
        document.setFilePath("C:/Documents/update");
        assertEquals("Testing updateDocument() ", 1, documentDAO.updateDocument(1, document));    
    }
    
    @Test
    public void testInsertIntern(){
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        
        intern.setPeriod("2020B");
        assertEquals("Testing updateIntern() ", 1, internDAO.updateIntern("18012147", intern));    
    }
        
    @Test
    public void testInsertManager(){
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", "dotcsv@gmail.com", 1);
        ManagerDAO managerDAO = new ManagerDAO();
        
        manager.setName("Enrique");
        assertEquals("Testing updateManager() ", 1, managerDAO.updateManager(2, manager));   
    }
        
    @Test
    public void testInsertOrganization(){
        Organization organization = new Organization(2, "YouTube", "Multimedia", "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        organization.setName("Twitch");
        assertEquals("Testing updateOrganization() ", 1, organizationDAO.updateOrganization(2, organization));   
    }
        
    @Test
    public void testInsertProject(){
        Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", "Servidores, equipos", 2, 2);
        ProjectDAO projectDAO = new ProjectDAO();
        
        project.setName("RN para Pymes");
        assertEquals("Testing updateProject() ", 1, projectDAO.updateProject(1, project));   
    }
        
    @Test
    public void testInsertReport(){
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        
        report.setReportType("Parcial");
        assertEquals("Testing updateReport() ", 1, reportDAO.updateReport(1, report));   
    }
        
    @Test
    public void testInsertUser(){
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com", "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        
        user.setName("Noe");
        assertEquals("Testing updateUser() ", 1, userDAO.updateUser("18012147", user));   
    }
}
