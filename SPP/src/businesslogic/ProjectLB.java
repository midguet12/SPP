package businesslogic;

import dataaccess.ProjectDAO;
import domain.Project;
import utilities.DataValidator;

public class ProjectLB {
    private final ProjectDAO dao;
    private Project project;
        
    public ProjectLB() {
        project = null;
        dao = new ProjectDAO();
    }

    public int setProject(Project project) {
        int aux = 0;
        if(DataValidator.isValid(project)){
            this.project = project;
            aux = 1;
        }
        return aux;
    }
    
    public Project getProject() {
        return project;
    }
    
    public int saveNewProject(){
        return dao.insertProject(project);
    }
   
    public int readProject(int idProject){
        int aux = 0;
        Project projectAux;
        projectAux = dao.getProject(idProject);
        if(projectAux != null){
           this.project = projectAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateProject(){
        return dao.updateProject(project);
    }
    
    public int deleteProject(){
        return dao.deleteProject(project.getId());
    }
}
