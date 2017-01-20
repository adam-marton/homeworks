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