package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.exception.DeviceIsAlreadyInTheCollectionException;
import xyz.codingmentor.exception.DeviceIsNotInTheCollectionException;

/**
 *
 * @author Ádám
 */
public class DeviceDB {
    private static DeviceDB instance;
    private final Map<String, DeviceEntity> deviceEntities;
    
    private DeviceDB() {
        deviceEntities = new LinkedHashMap<>();
    }
    
    public static DeviceDB getInstance() {
        if(null == instance) {
            instance = new DeviceDB();
        }
        return instance;
    }
    
    public DeviceEntity addDevice(DeviceEntity device) {
        if(!deviceEntities.containsKey(device.getId())) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(0);
            deviceEntities.put(device.getId(), device);
            return deviceEntities.get(device.getId());
        }
        throw new DeviceIsAlreadyInTheCollectionException();
    }
    
    public DeviceEntity editDevice(DeviceEntity device) {
        if(deviceEntities.containsKey(device.getId())) {
            deviceEntities.replace(device.getId(), device);
            return deviceEntities.get(device.getId());
        }
        throw new DeviceIsNotInTheCollectionException();
    }
    
    public DeviceEntity getDevice(String id) {
        if(deviceEntities.containsKey(id)) {
            return deviceEntities.get(id);
        }
        throw new DeviceIsNotInTheCollectionException();
    }
    
    public DeviceEntity deleteDevice(DeviceEntity device) {
        if(deviceEntities.containsKey(device.getId())) {
            return deviceEntities.remove(device.getId());
        }
        throw new DeviceIsNotInTheCollectionException();
    }
    
    public List<DeviceEntity> getAllDevice() {
        return new ArrayList<>(deviceEntities.values());
    }
}