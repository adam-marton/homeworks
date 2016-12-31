package xyz.codingmentor.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Ádám
 */
@Constraint(validatedBy = ColorOfAppleDeviceValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColorOfAppleDevice {
    String message() default "{ColorOfAppleDevice.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
