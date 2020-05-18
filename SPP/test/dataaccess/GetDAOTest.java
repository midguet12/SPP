package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import utilities.IndexGetter;

public class GetDAOTest {
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
    public void testGetActivity() {
        IndexGetter indexGetter = new IndexGetter();
        ActivityDAO activityDAO = new ActivityDAO();
        Activity activity = activityDAO.getActivity(indexGetter.getActivityID("Homework"));
        
        assertEquals("Testing getActivity() ", "Do Homework", activity.getDescription());
    }
 
    @Test
    public void testGetDocument(){
        IndexGetter indexGetter = new IndexGetter();
        DocumentDAO documentDAO = new DocumentDAO();
        Document document = documentDAO.getDocument(indexGetter.getDocumentID("C:/Documents"));
        
        assertEquals("Testing getDocument", "18012147", document.getIdIntern());
    }
    
    @Test
    public void testGetIntern(){
        InternDAO internDAO = new InternDAO();
        Intern intern = internDAO.getIntern("18012147");
        
        assertEquals("Testing getIntern", "18012147", intern.getIdIntern());
    }
        
    @Test
    public void testGetManager(){  
        IndexGetter indexGetter = new IndexGetter();
        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = managerDAO.getManager(indexGetter.getManagerID("Carlos"));
        
        assertEquals("Testing getManager", "Santana", manager.getMiddlename());
    }
        
    @Test
    public void testGetOrganization(){
        IndexGetter indexGetter = new IndexGetter();
        OrganizationDAO organizationDAO = new OrganizationDAO();
        Organization organization = organizationDAO.getOrganization(indexGetter.getOrganizationID("YouTube"));
                
        assertEquals("Testing getOrganization", "Multimedia", organization.getSector());
    }
        
    @Test
    public void testGetProject(){
        IndexGetter indexGetter = new IndexGetter();
        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getProject(indexGetter.getProjectID("Redes neuronales para PyMEs"));
        
        assertEquals("Testing getProject", "Mejorar la logística de PyMES", project.getDescription());
    }
        
    @Test
    public void testGetReport(){
        IndexGetter indexGetter = new IndexGetter();
        ReportDAO reportDAO = new ReportDAO();
        Report report = reportDAO.getReport(indexGetter.getReportID("C:/Documents"));
        
        assertEquals("Testing getReport", "Reporte mensual Marzo", report.getDescription());
    }
        
    @Test
    public void testGetUser(){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser("18012147");
        
        assertEquals("Testing getUser", "Seth", user.getName());
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
