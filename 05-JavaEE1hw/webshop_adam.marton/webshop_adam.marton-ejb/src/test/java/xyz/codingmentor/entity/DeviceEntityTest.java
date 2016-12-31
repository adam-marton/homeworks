package xyz.codingmentor.entity;

import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ádám
 */
public class DeviceEntityTest {
    private static ValidatorFactory vf;
    private static Validator validator;
    String id;
    DeviceEntity deviceEntity;
    
    @BeforeClass
    public static void setUpClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
        vf.close();
    }

    @Before
    public void setUp() {
        id = UUID.randomUUID().toString();
        deviceEntity = new DeviceEntity.Builder()
                .id(id)
                .manufacturer(Manufacturer.HTC)
                .type("GoodOne")
                .price(1000)
                .color(Color.BLUE)
                .count(2)
                .build();
    }
    
    @Test
    public void testValidId() {
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidId() {
        String wrongId = "1";
        deviceEntity.setId(wrongId);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongId, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void testValidManufacturer() {
        deviceEntity.setManufacturer(Manufacturer.ONEPLUS);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidManufacturer() {
        Manufacturer wrongManufacturer = null;
        deviceEntity.setManufacturer(wrongManufacturer);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongManufacturer, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void testValidType() {
        deviceEntity.setType("NicePhone12");
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidType() {
        String wrongType = "W7";
        deviceEntity.setType(wrongType);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongType, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void testValidPrice() {
        deviceEntity.setPrice(1);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidPrice() {
        Integer wrongPrice = 0;
        deviceEntity.setPrice(wrongPrice);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongPrice, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void testValidColor() {
        deviceEntity.setColor(Color.GREEN);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidColor() {
        Color wrongColor = null;
        deviceEntity.setColor(wrongColor);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongColor, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void testValidColorOfAppleDevice() {
        deviceEntity.setManufacturer(Manufacturer.APPLE);
        deviceEntity.setColor(Color.BLACK);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidColorOfAppleDevice() {
        deviceEntity.setManufacturer(Manufacturer.APPLE);
        deviceEntity.setColor(Color.PURPLE);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{ColorOfAppleDevice.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void testValidColorOfSamsungDevice() {
        deviceEntity.setManufacturer(Manufacturer.SAMSUNG);
        deviceEntity.setColor(Color.RED);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidColorOfSamsungDevice() {
        deviceEntity.setManufacturer(Manufacturer.SAMSUNG);
        deviceEntity.setColor(Color.GREEN);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{ColorOfSamsungDevice.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void testValidCount() {
        deviceEntity.setCount(0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidCount() {
        Integer wrongCount = -10;
        deviceEntity.setCount(wrongCount);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongCount, violations.iterator().next().getInvalidValue());
    }
}
