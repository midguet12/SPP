package spp;

import dataaccess.ActivityDAO;
import domain.Activity;
import java.util.Calendar;

public class SPP {
    public static void main(String[] args) {
        Activity activity = new Activity(1, "Homework", "20 pts", "Do Homework", new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"s18012147");
        ActivityDAO activityDAO = new ActivityDAO();
        
        activityDAO.insertActivity(activity);
        System.out.println(activityDAO.getActivity(1));
    }
}
