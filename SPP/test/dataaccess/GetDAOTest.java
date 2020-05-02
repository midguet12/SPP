package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetDAOTest {
    @Test
    public void testGetActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing getActivity() ", "Homework", activityDAO.getActivity(1).getName());
    }
 
    @Test
    public void testGetDocument(){
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147", 1);
        DocumentDAO documentDAO = new DocumentDAO();
        
        assertEquals("Testing getDocument", "18012147", documentDAO.getDocument(1).getIdIntern());
    }
    
    @Test
    public void testGetIntern(){
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        
        assertEquals("Testing getIntern", "18012147", internDAO.getIntern("18012147").getIdIntern());
    }
        
    @Test
    public void testGetManager(){        
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", "dotcsv@gmail.com", 1);
        ManagerDAO managerDAO = new ManagerDAO();
        
        assertEquals("Testing getManager", "Carlos", managerDAO.getManager(2).getName());
    }
        
    @Test
    public void testGetOrganization(){
        Organization organization = new Organization(2, "YouTube", "Multimedia", "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        assertEquals("Testing getOrganization", "YouTube", organizationDAO.getOrganization(2).getName());
    }
        
    @Test
    public void testGetProject(){
        Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", "Servidores, equipos", 2, 2);
        ProjectDAO projectDAO = new ProjectDAO();
        
        assertEquals("Testing getProject", "Redes neuronales para PyMEs", projectDAO.getProject(1).getName());
    }
        
    @Test
    public void testGetReport(){
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        
        assertEquals("Testing getReport", "Reporte mensual Marzo", reportDAO.getReport(1).getDescription());
    }
        
    @Test
    public void testGetUser(){
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com", "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        
        assertEquals("Testing getUser", "Seth", userDAO.getUser("18012147").getName());
    }    
}
