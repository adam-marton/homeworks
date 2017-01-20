package xyz.codingmentor.webshop.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.webshop.entity.Color;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.entity.Manufacturer;

/**
 *
 * @author Ádám
 */
public class ColorOfSamsungDeviceValidation implements 
        ConstraintValidator<ColorOfSamsungDevice, DeviceEntity> {
 
    @Override 
    public void initialize(ColorOfSamsungDevice constraintAnnotation) {
        //nothing to initialize
    }
    
    @Override 
    public boolean isValid(DeviceEntity deviceEntity, ConstraintValidatorContext cvc) {
        return !(Manufacturer.SAMSUNG == deviceEntity.getManufacturer() &&
                Color.GREEN == deviceEntity.getColor());
    }
}
