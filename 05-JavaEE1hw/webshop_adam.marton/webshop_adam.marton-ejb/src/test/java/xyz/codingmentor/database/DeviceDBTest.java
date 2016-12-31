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
    DeviceDB deviceDB;
    DeviceEntity firstDeviceEntity;
    DeviceEntity secondDeviceEntity;
    
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
    }

    @Test
    public void testGetDevice() {
        deviceDB.addDevice(secondDeviceEntity);
        DeviceEntity returnedDeviceEntity = deviceDB.getDevice(secondDeviceEntity.getId());
        Assert.assertEquals(secondDeviceEntity, returnedDeviceEntity);
    }

    @Test
    public void testDeleteDevice() {
        deviceDB.addDevice(firstDeviceEntity);
        deviceDB.addDevice(secondDeviceEntity);
        DeviceEntity deletedDeviceEntity = deviceDB.deleteDevice(firstDeviceEntity);
        Assert.assertEquals(deletedDeviceEntity, firstDeviceEntity);
    }

    @Test
    public void testGetAllDevice() {
        deviceDB.addDevice(firstDeviceEntity);
        deviceDB.addDevice(secondDeviceEntity);
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        deviceEntities.add(firstDeviceEntity);
        deviceEntities.add(secondDeviceEntity);
        List<DeviceEntity> returnedDeviceEntities = deviceDB.getAllDevice();
        Assert.assertEquals(returnedDeviceEntities, deviceEntities);
    }
}
