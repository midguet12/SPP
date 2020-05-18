package businesslogic;

import dataaccess.ManagerDAO;
import domain.Manager;
import utilities.DataValidator;

public class ManagerLogic {
    private final ManagerDAO dao;
    private Manager manager;
    private boolean isValid;
        
    public ManagerLogic() {
        manager = null;
        dao = new ManagerDAO();
        isValid = false;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    public Manager getManager() {
        return manager;
    }

    public void writeNewManager(){
        dao.insertManager(manager);
    }
   
    public int readManager(int idManager){
        int notNullManager = 1;
        this.manager = dao.getManager(idManager);
        if(this.manager == null){
            notNullManager = 0;
        }

        return notNullManager;
    }
    
    public int updateManager(){
        return dao.updateManager(manager);
    }
    
    public int deleteManager(){
        return dao.deleteManager(manager.getId());
    }
    
    public void addOrganization(int organization){
        this.manager.setIdOrganization(organization);
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.manager)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
