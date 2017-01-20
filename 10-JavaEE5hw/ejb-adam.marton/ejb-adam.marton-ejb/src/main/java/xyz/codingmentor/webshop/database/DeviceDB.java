package xyz.codingmentor.webshop.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.exception.DeviceIsAlreadyInTheCollectionException;
import xyz.codingmentor.webshop.exception.DeviceIsNotInTheCollectionException;
import xyz.codingmentor.webshop.interceptor.ValidatorInterceptor;

/**
 *
 * @author Ádám
 */
@Singleton
@Interceptors(ValidatorInterceptor.class)
public class DeviceDB {
    private static final String DEVICE_ID = "User with username: ";
    private static final String EXIST = " is already exist!";
    private static final String NOT_EXIST = " is not exist!";
    private final Map<String, DeviceEntity> deviceEntities = new LinkedHashMap<>();

    @ExcludeClassInterceptors
    public DeviceEntity addDevice(DeviceEntity device) {
        if(!deviceEntities.containsKey(device.getId())) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(0);
            deviceEntities.put(device.getId(), device);
            return deviceEntities.get(device.getId());
        }
        throw new DeviceIsAlreadyInTheCollectionException(DEVICE_ID + device.getId() + EXIST);
    }
    
    public DeviceEntity editDevice(DeviceEntity device) {
        if(deviceEntities.containsKey(device.getId())) {
            deviceEntities.replace(device.getId(), device);
            return deviceEntities.get(device.getId());
        }
        throw new DeviceIsNotInTheCollectionException(DEVICE_ID + device.getId() + NOT_EXIST);
    }
    
    public DeviceEntity getDevice(String id) {
        if(deviceEntities.containsKey(id)) {
            return deviceEntities.get(id);
        }
        throw new DeviceIsNotInTheCollectionException(DEVICE_ID + id + NOT_EXIST);
    }
    
    public DeviceEntity deleteDevice(DeviceEntity device) {
        if(deviceEntities.containsKey(device.getId())) {
            return deviceEntities.remove(device.getId());
        }
        throw new DeviceIsNotInTheCollectionException(DEVICE_ID + device.getId() + NOT_EXIST);
    }
    
    public List<DeviceEntity> getAllDevices() {
        return new ArrayList<>(deviceEntities.values());
    }
}