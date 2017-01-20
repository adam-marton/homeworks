package xyz.codingmentor.webshop.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.webshop.entity.UserEntity;

/**
 *
 * @author Ádám
 */
public class BirthDateBeforeRegistrationDateValidator implements 
        ConstraintValidator<BirthDateBeforeRegistrationDate, UserEntity> {
 
    @Override 
    public void initialize(BirthDateBeforeRegistrationDate constraintAnnotation) {
        //nothing to initialize
    }
    
    @Override 
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext cvc) {
        if(null == userEntity.getDateOfBirth()) {
            return true;
        }
        return userEntity.getDateOfBirth().before(userEntity.getRegistrationDate());
    }
}