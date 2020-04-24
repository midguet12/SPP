package domain;

public class Organization {
    int id;
    private String name;
    private String sector;
    private String eMail;
    private String phoneNumber;
    private int State;
    private String city;
    private String address;

    public Organization(int id, String name, String sector, String eMail, String phoneNumber, int State, String city, String address) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.State = State;
        this.city = city;
        this.address = address;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", sector=" + sector + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber + ", State=" + State + ", city=" + city + ", address=" + address + '}';
    }
    
}
