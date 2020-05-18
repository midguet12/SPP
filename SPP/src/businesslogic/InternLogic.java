package businesslogic;

import dataaccess.InternDAO;
import domain.Intern;
import utilities.DataValidator;

public class InternLogic {
    private final InternDAO dao;
    private Intern intern;
    private boolean isValid;
        
    public InternLogic() {
        intern = null;
        dao = new InternDAO();
        isValid = false;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }
    
    public Intern getIntern() {
        return intern;
    }

    public void writeNewIntern(){
        dao.insertIntern(intern);
    }
   
    public int readIntern(String idIntern){
        int notNullIntern = 1;
        this.intern = dao.getIntern(idIntern);
        if(this.intern == null){
            notNullIntern = 0;
        }

        return notNullIntern;
    }
    
    public int updateIntern(){
        return dao.updateIntern(intern);
    }
    
    public int deleteIntern(){
        return dao.deleteIntern(intern.getIdIntern());
    }
    
    public void addGrade(int grade){
        this.intern.setGrade(grade);
    }
    
    public void addProject(int project){
        this.intern.setIdProject(project);
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.intern)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
