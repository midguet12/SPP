package domain;

public class Intern { 
    private int idStudent;
    private String name;
    private String middlename;
    private String lastname;
    private String gender;
    private String period;
    private String eMail;
    private int score;  
    private int phoneNumber;
    private int idProject;    

    public Intern(int idStudent, String name, String middlename, String lastname, String gender, String period, String eMail, int score, int phoneNumber, int idProject) {
        this.idStudent = idStudent;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.period = period;
        this.eMail = eMail;
        this.score = score;
        this.phoneNumber = phoneNumber;
        this.idProject = idProject;
    }

     public Intern(int idStudent, String name, String middlename, String lastname) {
        this.idStudent = idStudent;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "Intern{" + "idStudent=" + idStudent + ", name=" + name + ", middlename=" + middlename + ", lastname=" + lastname + ", gender=" + gender + ", period=" + period + ", score=" + score + ", phoneNumber=" + phoneNumber + ", idProject=" + idProject + '}';
    }
           
}