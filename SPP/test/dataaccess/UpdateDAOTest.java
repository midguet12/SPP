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
        assertEquals("Testing updateActivity() ", 1, activityDAO.insertActivity(activity));
    }
}
