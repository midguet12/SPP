package domain;

public class Professor { 
    private String personalNumber;
    private String name;
    private String middlename;
    private String lastname;
    private String turn;
    private String eMail;

    public Professor(String personalNumber, String name, String middlename, String lastname, String turn, String eMail) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.turn = turn;
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

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Professor{" + "personalNumber=" + personalNumber + ", name=" + name + ", middlename=" + middlename + ", lastname=" + lastname + ", turn=" + turn + ", eMail=" + eMail + '}';
    }
    
}