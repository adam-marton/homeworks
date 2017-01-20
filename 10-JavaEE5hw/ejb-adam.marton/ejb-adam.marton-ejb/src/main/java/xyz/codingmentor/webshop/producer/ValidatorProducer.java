package xyz.codingmentor.webshop.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.webshop.annotation.ValidatorQualifier;

/**
 *
 * @author Ádám
 */
public class ValidatorProducer {
    
    @Produces @ValidatorQualifier
    public Validator produceValidator() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
}