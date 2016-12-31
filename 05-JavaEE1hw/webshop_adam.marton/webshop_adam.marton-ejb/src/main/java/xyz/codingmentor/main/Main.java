package xyz.codingmentor.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.database.UserDB;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.entity.UserEntity;

/**
 *
 * @author Ádám
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    private Main() {
        //Private constructor because of sonar
    }
    
    public static void main(String[] args) {
        try {
            UserDB userDB = new UserDB();
            DeviceDB deviceDB = new DeviceDB();
            ObjectMapper mapper = new ObjectMapper(); 
            List<UserEntity> userEntities = mapper.readValue(new File("userEntities.json"),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, UserEntity.class));
            List<DeviceEntity> deviceEntities = mapper.readValue(new File("deviceEntities.json"), 
                    TypeFactory.defaultInstance().constructCollectionType(List.class, DeviceEntity.class));
           
            for(UserEntity u : userEntities) {
                userDB.addUser(u);
            }
            for(DeviceEntity d : deviceEntities) {
                deviceDB.addDevice(d);
            }
            LOGGER.log(Level.INFO, userDB.getAllUser().toString());
            LOGGER.log(Level.INFO, deviceDB.getAllDevice().toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
