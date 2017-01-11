package xyz.codingmentor.database;

import java.util.List;
import javax.interceptor.ExcludeClassInterceptors;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.interceptor.BeanValidation;

/**
 *
 * @author Ádám
 */
@BeanValidation
public class DeviceDBService {
    
    public DeviceDBService() {
        DeviceDB.getInstance();
    }
    
    @ExcludeClassInterceptors
    public DeviceEntity addDevice(DeviceEntity device) {
        return DeviceDB.getInstance().addDevice(device);
    }
    
    public DeviceEntity editDevice(DeviceEntity device) {
        return DeviceDB.getInstance().editDevice(device);
    }
    
    public DeviceEntity getDevice(String id) {
        return DeviceDB.getInstance().getDevice(id);
    }
    
    public DeviceEntity deleteDevice(DeviceEntity device) {
        return DeviceDB.getInstance().deleteDevice(device);
    }
    
    public List<DeviceEntity> getAllDevice() {
        return DeviceDB.getInstance().getAllDevice();
    }
    
    public void clearDeviceDB() {
        DeviceDB.getInstance().clearDeviceDB();
    }
}