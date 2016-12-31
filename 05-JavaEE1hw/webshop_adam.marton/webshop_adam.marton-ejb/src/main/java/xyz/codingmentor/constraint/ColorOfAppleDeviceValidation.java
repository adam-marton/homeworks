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
public class ColorOfAppleDeviceValidation implements 
        ConstraintValidator<ColorOfAppleDevice, DeviceEntity> {
 
    @Override 
    public void initialize(ColorOfAppleDevice constraintAnnotation) {
        //nothing to initialize
    }
    
    @Override 
    public boolean isValid(DeviceEntity deviceEntity, ConstraintValidatorContext cvc) {
        return !(Manufacturer.APPLE == deviceEntity.getManufacturer() && 
                (Color.BLACK != deviceEntity.getColor() && Color.WHITE != deviceEntity.getColor()));
    }
}