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
@Constraint(validatedBy = ColorOfSamsungDeviceValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColorOfSamsungDevice {
    String message() default "{ColorOfSamsungDevice.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
