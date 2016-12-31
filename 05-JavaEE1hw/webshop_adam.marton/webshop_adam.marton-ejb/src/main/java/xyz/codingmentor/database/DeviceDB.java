package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import xyz.codingmentor.entity.DeviceEntity;

/**
 *
 * @author Ádám
 */
public class DeviceDB {
    private final List<DeviceEntity> deviceEntities = new ArrayList<>();
    
    public DeviceEntity addDevice(DeviceEntity device) {
        String id = UUID.randomUUID().toString();
        device.setId(id);
        device.setCount(0);
        deviceEntities.add(device);
        return deviceEntities.get(deviceEntities.size()-1);
    }
    
    public DeviceEntity editDevice(DeviceEntity device) {
        int index = -1;
        for(DeviceEntity d : deviceEntities) {
            if(device.getId().equals(d.getId())) {
                index = deviceEntities.indexOf(d);
            }
        }
        deviceEntities.set(index, device);
        return deviceEntities.get(index);
    }
    
    public DeviceEntity getDevice(String id) {
        for(DeviceEntity d : deviceEntities) {
            if(id.equals(d.getId())) {
                return d;
            }
        }
        return null;
    }
    
    public DeviceEntity deleteDevice(DeviceEntity device) {
        int index = deviceEntities.indexOf(device);
        DeviceEntity returnDevice = deviceEntities.get(index);
        deviceEntities.remove(index);
        return returnDevice;
    }
    
    public List<DeviceEntity> getAllDevice() {
        return deviceEntities;
    }
}