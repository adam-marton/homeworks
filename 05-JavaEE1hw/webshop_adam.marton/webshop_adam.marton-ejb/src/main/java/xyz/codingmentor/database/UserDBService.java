package xyz.codingmentor.database;

import java.util.List;
import javax.interceptor.ExcludeClassInterceptors;
import xyz.codingmentor.entity.UserEntity;
import xyz.codingmentor.interceptor.BeanValidation;

/**
 *
 * @author Ádám
 */
@BeanValidation
public class UserDBService {
    
    public UserDBService() {
        UserDB.getInstance();
    }
    
    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        return UserDB.getInstance().addUser(user);
    }
    
    public UserEntity getUser(String username) {
        return UserDB.getInstance().getUser(username);
    }
    
    public boolean authenticate(String username, String password) {
        return UserDB.getInstance().authenticate(username, password);
    }
    
    public UserEntity modifyUser(UserEntity user) {
        return UserDB.getInstance().modifyUser(user);
    }
    
    public UserEntity deleteUser(UserEntity user) {
        return UserDB.getInstance().deleteUser(user);
    }
    
    public List<UserEntity> getAllUser() {
        return UserDB.getInstance().getAllUser();
    }
    
    public void clearUserDB() {
        UserDB.getInstance().clearUserDB();
    }
}
