package xyz.codingmentor.carpartfactory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Ádám
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Defect {
    String author() default "Adam Marton";
    String lastModified() default "2016.12.17.";
    double version() default 1.0;
}
