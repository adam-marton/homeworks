package xyz.codingmentor.webshop.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.entity.UserEntity;

/**
 *
 * @author Ádám
 */
@Startup
@Singleton
public class DBFiller {
    private static final Logger LOGGER = Logger.getLogger(DBFiller.class.getName());
    @Inject
    private UserDB userDB;
    @Inject
    private DeviceDB deviceDB;
    
    @PostConstruct
    private void fillUpDB() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassLoader classLoader = getClass().getClassLoader();
            List<UserEntity> userEntities = mapper.readValue(new File(classLoader.getResource("userEntities.json").getFile()),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, UserEntity.class));
            List<DeviceEntity> deviceEntities = mapper.readValue(new File(classLoader.getResource("deviceEntities.json").getFile()),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, DeviceEntity.class));

            for (UserEntity u : userEntities) {
                userDB.addUser(u);
            }
            for (DeviceEntity d : deviceEntities) {
                deviceDB.addDevice(d);
                d.setCount(20);
            }
            LOGGER.log(Level.INFO, userDB.getAllUsers().toString());
            LOGGER.log(Level.INFO, deviceDB.getAllDevices().toString());
        } catch (IOException ex) {
            Logger.getLogger(DBFiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
