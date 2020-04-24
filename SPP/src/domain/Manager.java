package domain;

public class Manager {
    private int id;
    private String name;
    private String middlename;
    private String lastname;
    private String position;
    private String eMail;

    public Manager(int id, String name, String middlename, String lastname, String position, String eMail) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.eMail = eMail;
    }

    public Manager(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Manager{" + "id=" + id + ", name=" + name + ", middlename=" + middlename + ", lastname=" + lastname + ", position=" + position + ", eMail=" + eMail + '}';
    }
    
    
}
