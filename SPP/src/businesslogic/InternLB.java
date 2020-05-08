package businesslogic;

import dataaccess.InternDAO;
import domain.Intern;
import utilities.DataValidator;

public class InternLB {
    private final InternDAO dao;
    private Intern intern;
        
    public InternLB() {
        intern = null;
        dao = new InternDAO();
    }

    public int setIntern(Intern intern) {
        int aux = 0;
        if(DataValidator.isValid(intern)){
            this.intern = intern;
            aux = 1;
        }
        return aux;
    }
    
    public Intern getIntern() {
        return intern;
    }
    
    public int saveNewIntern(){
        return dao.insertIntern(intern);
    }
   
    public int readIntern(String idIntern){
        int aux = 0;
        Intern internAux;
        internAux = dao.getIntern(idIntern);
        if(internAux != null){
           this.intern = internAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateIntern(){
        return dao.updateIntern(intern);
    }
    
    public int deleteIntern(){
        return dao.deleteIntern(intern.getIdIntern());
    }
}
