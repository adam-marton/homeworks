package xyz.codingmentor.confusing.annotation;

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
@Target( {
    ElementType.TYPE,
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.CONSTRUCTOR } )
@Documented
public @interface Confusing {
    String codeWrittenBy() default "Code Writer";
    String lastModified() default "2016.12.17.";
    double version() default 1.0;    
}
