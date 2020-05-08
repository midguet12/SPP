package businesslogic;

import dataaccess.ActivityDAO;
import domain.Activity;
import utilities.DataValidator;

public class ActivityLB {
    private final ActivityDAO dao;
    private Activity activity;
        
    public ActivityLB() {
        activity = null;
        dao = new ActivityDAO();
    }

    public int setActivity(Activity activity) {
        int aux = 0;
        if(DataValidator.isValid(activity)){
            this.activity = activity;
            aux = 1;
        }
        return aux;
    }
    
    public Activity getActivity() {
        return activity;
    }
    
    public int saveNewActivity(){
        return dao.insertActivity(activity);
    }
   
    public int readActivity(int idActivity){
        int aux = 0;
        Activity activityAux;
        activityAux = dao.getActivity(idActivity);
        if(activityAux != null){
           this.activity = activityAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateActivity(){
        return dao.updateActivity(activity);
    }
    
    public int deleteActivity(){
        return dao.deleteActivity(activity.getId());
    }
}
