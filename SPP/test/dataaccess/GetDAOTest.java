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
    }
    
    @Test
    public void testGetIntern(){
    }
        
    @Test
    public void testGetManager(){
    }
        
    @Test
    public void testGetOrganization(){
    }
        
    @Test
    public void testGetProject(){
    }
        
    @Test
    public void testGetReport(){
    }
        
    @Test
    public void testGetUser(){
    }    
}
