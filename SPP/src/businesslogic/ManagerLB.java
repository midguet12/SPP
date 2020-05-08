package businesslogic;

import dataaccess.ManagerDAO;
import domain.Manager;
import utilities.DataValidator;

public class ManagerLB {
    private final ManagerDAO dao;
    private Manager manager;
        
    public ManagerLB() {
        manager = null;
        dao = new ManagerDAO();
    }

    public int setManager(Manager manager) {
        int aux = 0;
        if(DataValidator.isValid(manager)){
            this.manager = manager;
            aux = 1;
        }
        return aux;
    }
    
    public Manager getManager() {
        return manager;
    }
    
    public int saveNewManager(){
        return dao.insertManager(manager);
    }
   
    public int readManager(int idManager){
        int aux = 0;
        Manager managerAux;
        managerAux = dao.getManager(idManager);
        if(managerAux != null){
           this.manager = managerAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateManager(){
        return dao.updateManager(manager);
    }
    
    public int deleteManager(){
        return dao.deleteManager(manager.getId());
    }
}
