package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import utilities.IndexGetter;
import org.junit.BeforeClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteDAOTest {
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
    public void testDelete8Activity() {
        IndexGetter indexGetter = new IndexGetter();
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing deleteActivity() ", 1, activityDAO.deleteActivity(indexGetter.getActivityID("Homework")));
    }   
    
    @Test
    public void testInsert7Document(){
       IndexGetter indexGetter = new IndexGetter();
        DocumentDAO documentDAO = new DocumentDAO();
        
        assertEquals("Testing deleteActivity() ", 1, documentDAO.deleteDocument(indexGetter.getDocumentID("C:/Documents")));
    }
    
    @Test
    public void testInsert4Intern(){
        IndexGetter indexGetter = new IndexGetter();
        InternDAO internDAO = new InternDAO();
        
        assertEquals("Testing deleteActivity() ", 1, internDAO.deleteIntern("18012147"));
    }
        
    @Test
    public void testInsert2Manager(){
        IndexGetter indexGetter = new IndexGetter();
        ManagerDAO managerDAO = new ManagerDAO();
        
        assertEquals("Testing deleteActivity() ", 1, managerDAO.deleteManager(indexGetter.getManagerID("Carlos")));
    }
        
    @Test
    public void testInsert3Organization(){
        IndexGetter indexGetter = new IndexGetter();
        OrganizationDAO organizationDAO = new OrganizationDAO();
        
        assertEquals("Testing deleteActivity() ", 1, organizationDAO.deleteOrganization(indexGetter.getOrganizationID("YouTube")));
    }
        
    @Test
    public void testInsert1Project(){
        IndexGetter indexGetter = new IndexGetter();
        ProjectDAO projectDAO = new ProjectDAO();
        
        assertEquals("Testing deleteActivity() ", 1, projectDAO.deleteProject(indexGetter.getProjectID("Redes neuronales para PyMEs")));
    }
        
    @Test
    public void testInsert5Report(){
        IndexGetter indexGetter = new IndexGetter();
        ReportDAO reportDAO = new ReportDAO();
        
        assertEquals("Testing deleteActivity() ", 1, reportDAO.deleteReport(indexGetter.getReportID("C:/Documents")));
    }
        
    @Test
    public void testInsert6User(){
        IndexGetter indexGetter = new IndexGetter();
        UserDAO userDAO = new UserDAO();
        
        assertEquals("Testing deleteActivity() ", 1, userDAO.deleteUser("18012147"));
    }
}
