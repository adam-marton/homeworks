package xyz.codingmentor.webshop.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;
import xyz.codingmentor.webshop.database.DeviceDB;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.exception.NotEnoughDeviceOnStockException;

/**
 *
 * @author Ádám
 */
@Stateful
@StatefulTimeout(value = 2000, unit = TimeUnit.SECONDS)
public class ShoppingCart implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());
    private final Map<String, DeviceEntity> devicesInCart = new HashMap<>();
    private Integer value = 0;
    
    @Inject
    private transient DeviceDB deviceDB;
    
    public void addDeviceToCart(String id, Integer quantity) {
        DeviceEntity device = deviceDB.getDevice(id);
        if(quantity > device.getCount()) {
            throw new NotEnoughDeviceOnStockException("Not enough " 
                    + device.getManufacturer() + ", " + device.getType() + " on stock.");
        }
        DeviceEntity deviceToCart = new DeviceEntity(device);
        if(!devicesInCart.containsKey(id)) {
            deviceToCart.setCount(quantity);
            devicesInCart.put(deviceToCart.getId(), deviceToCart);
        }
        else {
            devicesInCart.get(id).setCount(devicesInCart.get(id).getCount() + quantity);
        }
        device.setCount(device.getCount() - quantity);
        value += quantity * device.getPrice();
    }
    
    public void deleteDeviceFromCart(String id, Integer quantity) {
        if(!devicesInCart.containsKey(id)) {
            throw new IllegalArgumentException("Not an existing device!");
        }
        DeviceEntity device = deviceDB.getDevice(id);
        if(quantity < devicesInCart.get(id).getCount()) {
            devicesInCart.get(id).setCount(devicesInCart.get(id).getCount() - quantity);
            value -= quantity * devicesInCart.get(id).getPrice();
            device.setCount(device.getCount() + quantity);
        }
        else {
            value -= devicesInCart.get(id).getCount() * devicesInCart.get(id).getPrice();
            device.setCount(device.getCount() + devicesInCart.get(id).getCount());
            devicesInCart.remove(id);
        }
    }
    
    @Remove
    public void deleteAllDevicesFromCart() {
        for(Map.Entry<String, DeviceEntity> d : devicesInCart.entrySet()) {
            DeviceEntity device = deviceDB.getDevice(d.getValue().getId());
            device.setCount(device.getCount() + d.getValue().getCount());
        }
        value = 0;
    }
    
    public Integer getCartValue() {
        return value;
    }
    
    public List<DeviceEntity> getCart() {
        return new ArrayList<>(devicesInCart.values());
    }
    
    @Remove
    public List<DeviceEntity> buyDevicesInCart() {
        LOGGER.log(Level.INFO, "You successfully bought the items!");
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, DeviceEntity> d : devicesInCart.entrySet()) {
            stringBuilder.append(d.getValue().toString());
        }
        LOGGER.log(Level.INFO, stringBuilder.toString());
        LOGGER.log(Level.INFO, "Items bought: {0}", devicesInCart.size());
        LOGGER.log(Level.INFO, "Cart value: {0}", getCartValue().toString());
        return getCart();
    }
}
