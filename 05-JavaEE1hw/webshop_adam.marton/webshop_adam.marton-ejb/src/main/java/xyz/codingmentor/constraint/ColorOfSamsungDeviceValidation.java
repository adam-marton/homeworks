package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.entity.Color;
import xyz.codingmentor.entity.DeviceEntity;
import xyz.codingmentor.entity.Manufacturer;

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
