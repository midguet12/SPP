package domain;

public class Intern{ 
    private String idInter;
    private String period;
    private int grade;
    private int idProject;

    public Intern(String idInter, String period, int grade, int idProject) {
        this.idInter = idInter;
        this.period = period;
        this.grade = grade;
        this.idProject = idProject;
    }

    public String getIdInter() {
        return idInter;
    }

    public void setIdInter(String idInter) {
        this.idInter = idInter;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "Intern{" + "idInter=" + idInter + ", period=" + period + ", grade=" + grade + ", idProject=" + idProject + '}';
    }
    
    
}