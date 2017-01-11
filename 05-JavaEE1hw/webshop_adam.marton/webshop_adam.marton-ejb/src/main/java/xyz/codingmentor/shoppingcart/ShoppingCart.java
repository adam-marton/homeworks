package xyz.codingmentor.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.entity.DeviceEntity;

/**
 *
 * @author Ádám
 */
public class ShoppingCart {
    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());
    private final Map<DeviceEntity, Integer> devicesInCart = new HashMap<>();
    private Integer value;
    
    public void addDeviceToCart(String id, Integer quantity) {
        devicesInCart.put(DeviceDB.getInstance().getDevice(id), quantity);
        DeviceDB.getInstance()
                .getDevice(id)
                .setCount(DeviceDB.getInstance().getDevice(id).getCount() - quantity);
        value += DeviceDB.getInstance().getDevice(id).getPrice();
    }
    
    public void deleteDeviceFromCart(String id, Integer quantity) {
        if(quantity < devicesInCart.get(DeviceDB.getInstance().getDevice(id))) {
            devicesInCart.replace(DeviceDB.getInstance().getDevice(id), 
                    devicesInCart.get(DeviceDB.getInstance().getDevice(id)) - quantity);
        }
        devicesInCart.remove(DeviceDB.getInstance().getDevice(id));
        value -= DeviceDB.getInstance().getDevice(id).getPrice();
    }
    
    public void deleteAllDevicesFromCart() {
        for(Map.Entry<DeviceEntity, Integer> device : devicesInCart.entrySet()) {
            DeviceDB.getInstance()
                    .getDevice(device.getKey().getId())
                    .setCount(DeviceDB.getInstance().getDevice(device.getKey().getId()).getCount() + device.getValue());
        }
        devicesInCart.clear();
        value = 0;
    }
    
    public Integer getCartValue() {
        return value;
    }
    
    public void buyDevicesInCart() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<DeviceEntity, Integer> device : devicesInCart.entrySet()) {
            stringBuilder.append(device.getKey().toString())
                    .append("Quantity: ")
                    .append(device.getValue());
        }
        LOGGER.log(Level.INFO, stringBuilder.toString());
        LOGGER.log(Level.INFO, "Cart value: {0}", getCartValue().toString());
        devicesInCart.clear();
    }
}
