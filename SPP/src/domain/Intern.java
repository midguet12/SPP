package domain;

public class Intern { 
    private int idStudent;
    private String name;
    private String middlename;
    private String lastname;
    private String period;
    private int score;  
        
    public Intern(int idStudent, String name, String middlename, String lastname){
        this.idStudent = idStudent;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public int getIDStudent() {
        return idStudent;
    }

    public void setIDStudent(int idStudent) {
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
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}