package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xyz.codingmentor.entity.UserEntity;

/**
 *
 * @author Ádám
 */
public class UserDB {
    private final List<UserEntity> userEntities = new ArrayList<>();
    
    public UserEntity addUser(UserEntity user) {
        Date currentDate = new Date();
        user.setRegistrationDate(currentDate);
        user.setLastModifiedDate(currentDate);
        userEntities.add(user);
        return userEntities.get(userEntities.size()-1);
    }
    
    public UserEntity getUser(String username) {
        for(UserEntity u : userEntities) {
            if(username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
    
    public boolean authenticate(String username, String password) {
        for(UserEntity u : userEntities) {
            if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    public UserEntity modifyUser(UserEntity user) {
        int index = -1;
        for(UserEntity u : userEntities) {
            if(user.getUsername().equals(u.getUsername())) {
                index = userEntities.indexOf(u);
            }
        }
        user.setLastModifiedDate(new Date());
        userEntities.set(index, user);
        return userEntities.get(index);
    }
    
    public UserEntity deleteUser(UserEntity user) {
        int index = userEntities.indexOf(user);
        UserEntity returnUser = userEntities.get(index);
        userEntities.remove(index);
        return returnUser;
    }
    
    public List<UserEntity> getAllUser() {
        return userEntities;
    }
}
