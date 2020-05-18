//Corregir, pequeños errores en el AfterClass
package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import utilities.IndexGetter;

public class UpdateDAOTest {
    @BeforeClass
    public static void setup(){
        IndexGetter indexGetter = new IndexGetter();
        
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", 
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        activityDAO.insertActivity(activity);
        
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "18012147", 1); 
        DocumentDAO documentDAO = new DocumentDAO();
        documentDAO.insertDocument(document);
        
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com",
                "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(user);
        
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 
                9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        reportDAO.insertReport(report);
        
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        internDAO.insertIntern(intern);
        
        Organization organization = new Organization(2, "YouTube", "Multimedia", 
                "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        organizationDAO.insertOrganization(organization);
        
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", 
                "dotcsv@gmail.com", indexGetter.getOrganizationID("YouTube"));
        ManagerDAO managerDAO = new ManagerDAO();
        managerDAO.insertManager(manager);
        
         Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", 
                "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", 
                "Servidores, equipos", indexGetter.getManagerID("Carlos"), indexGetter.getOrganizationID("YouTube"));
        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.insertProject(project);
    }
    
    @Test
    public void testUpdateActivity() {
        IndexGetter indexGetter = new IndexGetter();
        Activity activity = new Activity(indexGetter.getActivityID("Homework"), "Homework", "20 pts", "Do Homework", 
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        activity.setName("Project");
        assertEquals("Testing updateActivity() ", 1, activityDAO.updateActivity(activity));
    }
    
    @Test
    public void testInsertDocument(){
        IndexGetter indexGetter = new IndexGetter();
        Document document = new Document(indexGetter.getDocumentID("C:/Documents"), "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "18012147", 1); 
        DocumentDAO documentDAO = new DocumentDAO();
        
        document.setFilePath("C:/Documents/update");
        assertEquals("Testing updateDocument() ", 1, documentDAO.updateDocument(document));    
    }
    
    @Test
    public void testInsertIntern(){
        Intern intern = new Intern("18012147", "2020A", 9, 1);
        InternDAO internDAO = new InternDAO();
        
        intern.setPeriod("2020B");
        assertEquals("Testing updateIntern() ", 1, internDAO.updateIntern(intern));    
    }
        
    @Test
    public void testInsertManager(){
        IndexGetter indexGetter = new IndexGetter();
        Manager manager = new Manager(indexGetter.getManagerID("Carlos"), "Carlos", "Santana", "Valenzuela", "Director", 
                "dotcsv@gmail.com", indexGetter.getOrganizationID("YouTube"));
        ManagerDAO managerDAO = new ManagerDAO();
        
        manager.setName("Enrique");
        assertEquals("Testing updateManager() ", 1, managerDAO.updateManager(manager));   
    }
        
    @Test
    public void testInsertOrganization(){
        IndexGetter indexGetter = new IndexGetter();
        Organization organization = new Organization(indexGetter.getOrganizationID("YouTube"), "YouTube", "Multimedia", 
                "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        organization.setName("Twitch");
        assertEquals("Testing updateOrganization() ", 1, organizationDAO.updateOrganization(organization));   
    }
        
    @Test
    public void testInsertProject(){
        IndexGetter indexGetter = new IndexGetter();
        Project project = new Project(indexGetter.getProjectID("Redes neuronales para PyMEs"), "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", 
                "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", 
                "Servidores, equipos", indexGetter.getManagerID("Carlos"), indexGetter.getOrganizationID("YouTube"));
        ProjectDAO projectDAO = new ProjectDAO();
        
        project.setName("RN para Pymes");
        assertEquals("Testing updateProject() ", 1, projectDAO.updateProject(project));   
    }
        
    @Test
    public void testInsertReport(){
        IndexGetter indexGetter = new IndexGetter();
        Report report = new Report(indexGetter.getReportID("C:/Documents"), "Mensual", "Reporte mensual Marzo", "C:/Documents", 
                9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");
        ReportDAO reportDAO = new ReportDAO();
        
        report.setReportType("Parcial");
        assertEquals("Testing updateReport() ", 1, reportDAO.updateReport(report));   
    }
        
    @Test
    public void testInsertUser(){
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com", "7468921323", 3);
        UserDAO userDAO = new UserDAO();
        
        user.setName("Noe");
        assertEquals("Testing updateUser() ", 1, userDAO.updateUser(user));   
    }
    
         @AfterClass
    public static void teardown(){
        IndexGetter indexGetter = new IndexGetter();
        
        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.deleteProject(indexGetter.getProjectID("Redes neuronales para PyMEs"));
        
        ManagerDAO managerDAO = new ManagerDAO();
        managerDAO.deleteManager(indexGetter.getManagerID("Carlos"));
        
        OrganizationDAO organizationDAO = new OrganizationDAO();
        organizationDAO.deleteOrganization(indexGetter.getOrganizationID("YouTube"));
        
        InternDAO internDAO = new InternDAO();
        internDAO.deleteIntern("18012147");
        
        ReportDAO reportDAO = new ReportDAO();
        reportDAO.deleteReport(indexGetter.getReportID("C:/Documents"));
        
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser("18012147");
        
        DocumentDAO documentDAO = new DocumentDAO();
        documentDAO.deleteDocument(indexGetter.getDocumentID("C:/Documents"));
        
        ActivityDAO activityDAO = new ActivityDAO();
        activityDAO.deleteActivity(indexGetter.getActivityID("Homework"));
    }
}
