package businesslogic;

import dataaccess.ProjectDAO;
import domain.Project;
import utilities.DataValidator;

public class ProjectLogic {
    private final ProjectDAO dao;
    private Project project;
    private boolean isValid;
        
    public ProjectLogic() {
        project = null;
        dao = new ProjectDAO();
        isValid = false;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public Project getProject() {
        return project;
    }

    public void writeNewProject(){
        dao.insertProject(project);
    }
   
    public int readProject(int idProject){
        int notNullProject = 1;
        this.project = dao.getProject(idProject);
        if(this.project == null){
            notNullProject = 0;
        }

        return notNullProject;
    }
    
    public int updateProject(){
        return dao.updateProject(project);
    }
    
    public int deleteProject(){
        return dao.deleteProject(project.getId());
    }
    
    public void addManager(int manager){
        this.project.setIdOrganization(manager);
    }
    public void addOrganization(int organization){
        this.project.setIdOrganization(organization);
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.project)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
