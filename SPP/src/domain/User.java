package domain;

public class User {
    private String identificator;
    private String password;
    private String userType;

    public User(String identificator, String password, String userType) {
        this.identificator = identificator;
        this.password = password;
        this.userType = userType;
    }
    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "identificator=" + identificator + ", password=" + password + ", userType=" + userType + '}';
    }
       
}
