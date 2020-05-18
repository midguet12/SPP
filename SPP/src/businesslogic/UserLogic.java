package businesslogic;

import dataaccess.UserDAO;
import domain.User;
import utilities.DataValidator;

public class UserLogic {
    private final UserDAO dao;
    private User user;
        
    public UserLogic() {
        user = null;
        dao = new UserDAO();
    }

    public int setUser(User user) {
        int aux = 0;
        if(DataValidator.isValid(user)){
            this.user = user;
            aux = 1;
        }
        return aux;
    }
    
    public User getUser() {
        return user;
    }
    
    public int saveNewUser(){
        return dao.insertUser(user);
    }
   
    public int readUser(String idUser){
        int aux = 0;
        User userAux;
        userAux = dao.getUser(idUser);
        if(userAux != null){
           this.user = userAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateUser(){
        return dao.updateUser(user);
    }
    
    public int deleteUser(){
        return dao.deleteUser(user.getIdUser());
    }
}
