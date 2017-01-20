package xyz.codingmentor.webshop.database;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.codingmentor.webshop.entity.Color;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.entity.Manufacturer;

/**
 *
 * @author Ádám
 */
public class DeviceDBTest {
    private DeviceEntity firstDeviceEntity;
    private DeviceEntity secondDeviceEntity;
    private DeviceDB deviceDB;
    
    @Before
    public void setUp() {
        deviceDB = new DeviceDB();
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
        deviceDB.addDevice(firstDeviceEntity);
        Assert.assertEquals(firstDeviceEntity, deviceDB.getDevice(firstDeviceEntity.getId()));
        deviceDB.deleteDevice(firstDeviceEntity);
    }

    @Test
    public void testEditDevice() {
        deviceDB.addDevice(firstDeviceEntity);
        deviceDB.addDevice(secondDeviceEntity);
        secondDeviceEntity.setType("A77");
        secondDeviceEntity.setPrice(7000);
        secondDeviceEntity.setCount(3);
        DeviceEntity modifiedDeviceEntity = deviceDB.editDevice(secondDeviceEntity);
        Assert.assertEquals(modifiedDeviceEntity, secondDeviceEntity);
        deviceDB.deleteDevice(firstDeviceEntity);
        deviceDB.deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testGetDevice() {
        deviceDB.addDevice(secondDeviceEntity);
        DeviceEntity returnedDeviceEntity = deviceDB.getDevice(secondDeviceEntity.getId());
        Assert.assertEquals(secondDeviceEntity, returnedDeviceEntity);
        deviceDB.deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testDeleteDevice() {
        deviceDB.addDevice(firstDeviceEntity);
        deviceDB.addDevice(secondDeviceEntity);
        DeviceEntity deletedDeviceEntity = deviceDB.deleteDevice(firstDeviceEntity);
        Assert.assertEquals(deletedDeviceEntity, firstDeviceEntity);
        deviceDB.deleteDevice(secondDeviceEntity);
    }

    @Test
    public void testGetAllDevice() {
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        deviceEntities.add(firstDeviceEntity);
        deviceEntities.add(secondDeviceEntity);
        deviceDB.addDevice(firstDeviceEntity);
        deviceDB.addDevice(secondDeviceEntity);
        List<DeviceEntity> returnedDeviceEntities = deviceDB.getAllDevices();
        Assert.assertEquals(returnedDeviceEntities, deviceEntities);
        deviceDB.deleteDevice(firstDeviceEntity);
        deviceDB.deleteDevice(secondDeviceEntity);
    }
}
