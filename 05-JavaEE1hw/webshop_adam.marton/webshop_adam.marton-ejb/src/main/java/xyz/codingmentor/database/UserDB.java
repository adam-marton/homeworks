package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.entity.UserEntity;
import xyz.codingmentor.exception.UserIsAlreadyInTheCollectionException;
import xyz.codingmentor.exception.UserIsNotInTheCollectionException;

/**
 *
 * @author Ádám
 */
public class UserDB {
    private static UserDB instance;
    private final Map<String, UserEntity> userEntities;
    
    private UserDB() {
        userEntities = new LinkedHashMap<>();
    }
    
    public static UserDB getInstance() {
        if(null == instance) {
            instance = new UserDB();
        }
        return instance;
    }
    
    public UserEntity addUser(UserEntity user) {
        if(!userEntities.containsKey(user.getUsername())) {
            Date currentDate = new Date();
            user.setRegistrationDate(currentDate);
            user.setLastModifiedDate(currentDate);
            userEntities.put(user.getUsername(), user);
            return userEntities.get(user.getUsername());
        }
        throw new UserIsAlreadyInTheCollectionException();
    }
    
    public UserEntity getUser(String username) {
        if(userEntities.containsKey(username)) {
            return userEntities.get(username);
        }
        throw new UserIsNotInTheCollectionException();
    }
    
    public boolean authenticate(String username, String password) {
        return userEntities.containsKey(username) && password.equals(userEntities.get(username).getPassword());
    }
    
    public UserEntity modifyUser(UserEntity user) {
        if(userEntities.containsKey(user.getUsername())) {
            user.setLastModifiedDate(new Date());
            userEntities.replace(user.getUsername(), user);
            return userEntities.get(user.getUsername());
        }
        throw new UserIsNotInTheCollectionException();
    }
    
    public UserEntity deleteUser(UserEntity user) {
        if(userEntities.containsKey(user.getUsername())) {
            return userEntities.remove(user.getUsername());
        }
        throw new UserIsNotInTheCollectionException();
    }
    
    public List<UserEntity> getAllUser() {
        return new ArrayList<>(userEntities.values());
    }
    
    public void clearUserDB() {
        userEntities.clear();
    }
}
