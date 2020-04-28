package dataaccess;

import domain.*;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteDAOTest {
    @Test
    public void testDeleteActivity() {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTime().getTime()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        assertEquals("Testing deleteActivity() ", activityDAO.insertActivity(activity), 1);
    }
}
