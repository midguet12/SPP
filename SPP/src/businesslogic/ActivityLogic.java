package businesslogic;

import dataaccess.ActivityDAO;
import domain.Activity;
import utilities.DataValidator;

public class ActivityLogic {
    private final ActivityDAO dao;
    private Activity activity;
    private boolean isValid;
        
    public ActivityLogic() {
        activity = null;
        dao = new ActivityDAO();
        isValid = false;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    
    public Activity getActivity() {
        return activity;
    }

    public void writeNewActivity(){
        dao.insertActivity(activity);
    }
   
    public int readActivity(int idActivity){
        int notNullActivity = 1;
        this.activity = dao.getActivity(idActivity);
        if(this.activity == null){
            notNullActivity = 0;
        }

        return notNullActivity;
    }
    
    public int updateActivity(){
        return dao.updateActivity(activity);
    }
    
    public int deleteActivity(){
        return dao.deleteActivity(activity.getId());
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.activity)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
