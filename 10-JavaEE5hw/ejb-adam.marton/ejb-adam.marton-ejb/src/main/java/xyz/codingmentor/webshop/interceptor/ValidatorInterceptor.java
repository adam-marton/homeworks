package xyz.codingmentor.webshop.interceptor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import xyz.codingmentor.webshop.annotation.Validate;
import xyz.codingmentor.webshop.annotation.ValidatorQualifier;
import xyz.codingmentor.webshop.exception.ValidationException;

/**
 *
 * @author Ádám
 */
@Interceptor
@BeanValidation
public class ValidatorInterceptor {

    @Inject
    @ValidatorQualifier
    private Validator validator;

    @AroundInvoke
    public Object checkMethodParameters(InvocationContext ic) throws Exception {
        Logger.getLogger(ValidatorInterceptor.class.getName())
                .log(Level.INFO, "Checking method: {0}", ic.getMethod().getName());
        if(null != ic.getParameters()) {
            validateParameters(ic.getParameters());
        }
        return ic.proceed();
    }

    private void validateParameters(Object[] parameters) {
        Arrays.asList(parameters)
                .stream()
                .filter(p -> p.getClass().isAnnotationPresent(Validate.class))
                .forEach(p -> validateBean(p));
    }

    private void validateBean(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        Optional<String> errorMessage = violations.stream()
                .map(e -> "Validation error: " + e.getMessage() + " - property: "
                + e.getPropertyPath().toString() + " . ")
                .reduce(String::concat);
        if (errorMessage.isPresent()) {
            throw new ValidationException(errorMessage.get());
        }
    }
}
