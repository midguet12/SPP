package dataaccess;

import domain.Activity;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityDAOTest {
  
//    public ActivityDAOTest() {
//        activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
//        activityDAO = new ActivityDAO();
//    }

    @Test
    public void testInsertActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing insertActivity() ", 1, activityDAO.insertActivity(activity));    
    }

    @Test
    public void testGetActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing getActivity() ", "Homework", activityDAO.getActivity(1).getName());
    }

    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        activity.setName("Project");
        assertEquals("Testing updateActivity() ", 1, activityDAO.insertActivity(activity));
    }

    @Test
    public void testDeleteActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing deleteActivity() ", activityDAO.insertActivity(activity), 1);
    }
    
}
