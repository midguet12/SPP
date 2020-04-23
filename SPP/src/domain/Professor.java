package domain;

public class Professor { 
    private int personalNumber;
    private String name;
    private String middlename;
    private String lastname;
        
    public Professor(int personalNumber, String name, String middlename, String lastname){
        this.personalNumber = personalNumber;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
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
    
}