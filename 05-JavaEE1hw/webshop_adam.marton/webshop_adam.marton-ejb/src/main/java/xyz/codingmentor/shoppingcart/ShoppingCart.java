package xyz.codingmentor.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.exception.NotEnoughDeviceOnStockException;

/**
 *
 * @author Ádám
 */
public class ShoppingCart {
    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());
    private final Map<DeviceEntity, Integer> devicesInCart = new HashMap<>();
    private Integer value;
    
    public void addDeviceToCart(String id, Integer quantity) {
        DeviceEntity device = DeviceDB.getInstance().getDevice(id);
        if(quantity <= device.getCount()) {
            devicesInCart.put(device, quantity);
            device.setCount(device.getCount() - quantity);
            DeviceDB.getInstance().editDevice(device);
            value += quantity * device.getPrice();
        }
        throw new NotEnoughDeviceOnStockException("Not enough " 
                + device.getManufacturer() + ", " + device.getType() + " on stock.");
    }
    
    public void deleteDeviceFromCart(String id, Integer quantity) {
        DeviceEntity device = DeviceDB.getInstance().getDevice(id);
        if(quantity < devicesInCart.get(device)) {
            devicesInCart.replace(device, devicesInCart.get(device) - quantity);
            value -= quantity * device.getPrice();
            device.setCount(device.getCount() + quantity);
            DeviceDB.getInstance().editDevice(device);
        }
        value -= devicesInCart.get(device) * device.getPrice();
        device.setCount(device.getCount() + quantity);
        DeviceDB.getInstance().editDevice(device);
        devicesInCart.remove(device);
    }
    
    public void deleteAllDevicesFromCart() {
        for(Map.Entry<DeviceEntity, Integer> d : devicesInCart.entrySet()) {
            DeviceEntity device = DeviceDB.getInstance().getDevice(d.getKey().getId());
            device.setCount(device.getCount() + d.getValue());
            DeviceDB.getInstance().editDevice(device);
        }
        devicesInCart.clear();
        value = 0;
    }
    
    public Integer getCartValue() {
        return value;
    }
    
    public void buyDevicesInCart() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<DeviceEntity, Integer> d : devicesInCart.entrySet()) {
            stringBuilder.append(d.getKey().toString())
                    .append("\nQuantity: ")
                    .append(d.getValue());
        }
        LOGGER.log(Level.INFO, stringBuilder.toString());
        LOGGER.log(Level.INFO, "Cart value: {0}", getCartValue().toString());
        devicesInCart.clear();
    }
}
