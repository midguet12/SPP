package dataaccess;

import domain.Activity;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityDAOTest {
    private final Activity activity;
    private final ActivityDAO activityDAO;
    
    public ActivityDAOTest() {

    }

    @Test
    public void testInsertActivity() {
        
        assertEquals("Testing insertActivity() ", activityDAO.insertActivity(activity), 1);
    }

//    @Test
//    public void testGetActivity() {
//    }
//
//    @Test
//    public void testUpdateActivity() {
//    }
//
//    @Test
//    public void testDeleteActivity() {
//    }
//    
}
