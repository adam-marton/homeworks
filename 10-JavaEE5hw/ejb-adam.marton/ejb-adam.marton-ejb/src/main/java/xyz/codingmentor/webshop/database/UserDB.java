package xyz.codingmentor.webshop.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.webshop.entity.UserEntity;
import xyz.codingmentor.webshop.exception.UserIsAlreadyInTheCollectionException;
import xyz.codingmentor.webshop.exception.UserIsNotInTheCollectionException;
import xyz.codingmentor.webshop.interceptor.ValidatorInterceptor;

/**
 *
 * @author Ádám
 */
@Singleton
@Interceptors(ValidatorInterceptor.class)
public class UserDB {
    private static final String USERNAME = "User with username: ";
    private static final String EXIST = " is already exist!";
    private static final String NOT_EXIST = " is not exist!";
    private final Map<String, UserEntity> userEntities = new LinkedHashMap<>();
    
    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        if(!userEntities.containsKey(user.getUsername())) {
            Date currentDate = new Date();
            user.setRegistrationDate(currentDate);
            user.setLastModifiedDate(currentDate);
            userEntities.put(user.getUsername(), user);
            return userEntities.get(user.getUsername());
        }
        throw new UserIsAlreadyInTheCollectionException(USERNAME + user.getUsername() + EXIST);
    }
    
    public UserEntity getUser(String username) {
        if(userEntities.containsKey(username)) {
            return userEntities.get(username);
        }
        throw new UserIsNotInTheCollectionException(USERNAME + username + NOT_EXIST);
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
        throw new UserIsNotInTheCollectionException(USERNAME + user.getUsername() + NOT_EXIST);
    }
    
    public UserEntity deleteUser(UserEntity user) {
        if(userEntities.containsKey(user.getUsername())) {
            return userEntities.remove(user.getUsername());
        }
        throw new UserIsNotInTheCollectionException(USERNAME + user.getUsername() + NOT_EXIST);
    }
    
    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(userEntities.values());
    }
}
