package businesslogic;

import dataaccess.UserDAO;
import domain.User;
import utilities.DataValidator;

public class UserLogic {
    private final UserDAO dao;
    private User user;
    private boolean isValid;
        
    public UserLogic() {
        user = null;
        dao = new UserDAO();
        isValid = false;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

    public void writeNewUser(){
        dao.insertUser(user);
    }
   
    public int readUser(String idUser){
        int notNullUser = 1;
        this.user = dao.getUser(idUser);
        if(this.user == null){
            notNullUser = 0;
        }

        return notNullUser;
    }
    
    public int updateUser(){
        return dao.updateUser(user);
    }
    
    public int deleteUser(){
        return dao.deleteUser(user.getIdUser());
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.user)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
