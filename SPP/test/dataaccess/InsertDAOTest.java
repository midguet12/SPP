package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import utilities.IndexGetter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsertDAOTest {
     @Test
    public void testInsert1Activity() {
        ActivityDAO activityDAO = new ActivityDAO();
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", 
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");       
        
        assertEquals("Testing insertActivity() ", 1, activityDAO.insertActivity(activity));    
    }
    
    @Test
    public void testInsert2Document(){
        DocumentDAO documentDAO = new DocumentDAO();
        Document document = new Document(1, "C:/Documents", new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                "18012147", 1);   
        
        assertEquals("Testing insertDocument() ", 1, documentDAO.insertDocument(document));    
    }
    
    @Test
    public void testInsert5Intern(){
        InternDAO internDAO = new InternDAO();
        Intern intern = new Intern("18012147", "2020A", 9, 1);      
        
        assertEquals("Testing insertIntern() ", 1, internDAO.insertIntern(intern));    
    }
        
    @Test
    public void testInsert7Manager(){
        IndexGetter indexGetter = new IndexGetter();
        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = new Manager(2, "Carlos", "Santana", "Valenzuela", "Director", 
                "dotcsv@gmail.com", indexGetter.getOrganizationID("YouTube"));        
        
        assertEquals("Testing insertManager() ", 1, managerDAO.insertManager(manager));   
    }
        
    @Test
    public void testInsert6Organization(){
        OrganizationDAO organizationDAO = new OrganizationDAO();
        Organization organization = new Organization(2, "YouTube", "Multimedia", 
                "contact@youtube.com", "0180006565", 30, "Xalapa", "Avila camacho");        
        
        assertEquals("Testing insertOrganization() ", 1, organizationDAO.insertOrganization(organization));   
    }
        
    @Test
    public void testInsert8Project(){
        IndexGetter indexGetter = new IndexGetter();
        ProjectDAO projectDAO = new ProjectDAO();
        Project project = new Project(1, "Redes neuronales para PyMEs", "Mejorar la logística de PyMES", 
                "Elaborar Redes neuronales", "Programar", 10, "Mejorar la logística", "Programar", 
                "Servidores, equipos", indexGetter.getManagerID("Carlos"), indexGetter.getOrganizationID("YouTube"));        
        
        assertEquals("Testing insertProject() ", 1, projectDAO.insertProject(project));   
    }
        
    @Test
    public void testInsert4Report(){
        ReportDAO reportDAO = new ReportDAO();
        Report report = new Report(1, "Mensual", "Reporte mensual Marzo", "C:/Documents", 
                9, new java.sql.Date(Calendar.getInstance().getTime().getTime()), "18012147");        
        
        assertEquals("Testing insertReport() ", 1, reportDAO.insertReport(report));   
    }
        
    @Test
    public void testInsert3User(){
        UserDAO userDAO = new UserDAO();
        User user = new User("18012147", "Seth", "Diaz", "Diaz", "Qwery", "asdasd@gmail.com",
                "7468921323", 3);        
        
        assertEquals("Testing insertUser() ", 1, userDAO.insertUser(user));   
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
