package domain;

public class Coordinator { 
    private String personalNumber;
    private String name;
    private String middlename;
    private String lastname;
    private String gender;
    private String eMail;

    public Coordinator(String personalNumber, String name, String middlename, String lastname, String gender, String eMail) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.eMail = eMail;
    }    

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    @Override
    public String toString() {
        return "Coordinator{" + "personalNumber=" + personalNumber + ", name=" + name + ", middlename=" + middlename + ", lastname=" + lastname + ", gender=" + gender + '}';
    }
     
}