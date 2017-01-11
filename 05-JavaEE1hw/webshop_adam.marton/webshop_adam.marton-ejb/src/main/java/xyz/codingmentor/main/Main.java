package xyz.codingmentor.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.database.DeviceDBService;
import xyz.codingmentor.database.UserDB;
import xyz.codingmentor.entity.Color;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.entity.Manufacturer;
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
            ObjectMapper mapper = new ObjectMapper(); 
            List<UserEntity> userEntities = mapper.readValue(new File("userEntities.json"),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, UserEntity.class));
            List<DeviceEntity> deviceEntities = mapper.readValue(new File("deviceEntities.json"), 
                    TypeFactory.defaultInstance().constructCollectionType(List.class, DeviceEntity.class));
           
            for(UserEntity u : userEntities) {
                UserDB.getInstance().addUser(u);
            }
            for(DeviceEntity d : deviceEntities) {
                DeviceDB.getInstance().addDevice(d);
            }
            LOGGER.log(Level.INFO, UserDB.getInstance().getAllUser().toString());
            LOGGER.log(Level.INFO, DeviceDB.getInstance().getAllDevice().toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        DeviceDBService deviceDBService = container.instance().select(DeviceDBService.class).get();
        DeviceEntity device = new DeviceEntity.Builder()
                .manufacturer(Manufacturer.HTC)
                .type("GoodOne")
                .price(1000)
                .color(Color.BLUE)
                .count(2)
                .build();
        deviceDBService.addDevice(device);
        LOGGER.log(Level.INFO, deviceDBService.getDevice(device.getId()).toString());
        deviceDBService.deleteDevice(device);
        
        weld.shutdown();
    }
}