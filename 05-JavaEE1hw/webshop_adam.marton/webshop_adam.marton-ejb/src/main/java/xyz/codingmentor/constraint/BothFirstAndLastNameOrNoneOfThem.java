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
@Constraint(validatedBy = BothFirstAndLastNameOrNoneOfThemValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BothFirstAndLastNameOrNoneOfThem {
    String message() default "{BothFirstAndLastNameOrNoneOfThem.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
