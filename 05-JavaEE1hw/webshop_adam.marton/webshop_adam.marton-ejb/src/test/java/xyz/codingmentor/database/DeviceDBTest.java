package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.codingmentor.entity.Color;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.entity.Manufacturer;

/**
 *
 * @author Ádám
 */
public class DeviceDBTest {
    private DeviceEntity firstDeviceEntity;
    private DeviceEntity secondDeviceEntity;
    
    @Before
    public void setUp() {
        firstDeviceEntity = new DeviceEntity.Builder()
                .manufacturer(Manufacturer.HTC)
                .type("GoodOne")
                .price(1000)
                .color(Color.BLUE)
                .count(2)
                .build();
        secondDeviceEntity = new DeviceEntity.Builder()
                .manufacturer(Manufacturer.APPLE)
                .type("A66")
                .price(5000)
                .color(Color.WHITE)
                .count(5)
                .build();
    }

    @Test
    public void testAddDevice() {
        DeviceDB.getInstance().addDevice(firstDeviceEntity);
        Assert.assertEquals(firstDeviceEntity, DeviceDB.getInstance().getDevice(firstDeviceEntity.getId()));
        DeviceDB.getInstance().deleteDevice(firstDeviceEntity);
    }

    @Test
    public void testEditDevice() {
        DeviceDB.getInstance().addDevice(firstDeviceEntity);
        DeviceDB.getInstance().addDevice(secondDeviceEntity);
        secondDeviceEntity.setType("A77");
        secondDeviceEntity.setPrice(7000);
        secondDeviceEntity.setCount(3);
        DeviceEntity modifiedDeviceEntity = DeviceDB.getInstance().editDevice(secondDeviceEntity);
        Assert.assertEquals(modifiedDeviceEntity, secondDeviceEntity);
        DeviceDB.getInstance().deleteDevice(firstDeviceEntity);
        DeviceDB.getInstance().deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testGetDevice() {
        DeviceDB.getInstance().addDevice(secondDeviceEntity);
        DeviceEntity returnedDeviceEntity = DeviceDB.getInstance().getDevice(secondDeviceEntity.getId());
        Assert.assertEquals(secondDeviceEntity, returnedDeviceEntity);
        DeviceDB.getInstance().deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testDeleteDevice() {
        DeviceDB.getInstance().addDevice(firstDeviceEntity);
        DeviceDB.getInstance().addDevice(secondDeviceEntity);
        DeviceEntity deletedDeviceEntity = DeviceDB.getInstance().deleteDevice(firstDeviceEntity);
        Assert.assertEquals(deletedDeviceEntity, firstDeviceEntity);
        DeviceDB.getInstance().deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testGetAllDevice() {
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        deviceEntities.add(firstDeviceEntity);
        deviceEntities.add(secondDeviceEntity);
        DeviceDB.getInstance().addDevice(firstDeviceEntity);
        DeviceDB.getInstance().addDevice(secondDeviceEntity);
        List<DeviceEntity> returnedDeviceEntities = DeviceDB.getInstance().getAllDevice();
        Assert.assertEquals(returnedDeviceEntities, deviceEntities);
        DeviceDB.getInstance().deleteDevice(firstDeviceEntity);
        DeviceDB.getInstance().deleteDevice(secondDeviceEntity);
    }
}
