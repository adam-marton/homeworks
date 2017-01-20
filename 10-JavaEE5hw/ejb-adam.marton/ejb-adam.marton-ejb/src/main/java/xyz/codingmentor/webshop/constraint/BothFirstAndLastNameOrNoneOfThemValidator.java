package xyz.codingmentor.webshop.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.webshop.entity.UserEntity;

/**
 *
 * @author Ádám
 */
public class BothFirstAndLastNameOrNoneOfThemValidator implements 
        ConstraintValidator<BothFirstAndLastNameOrNoneOfThem, UserEntity> {
 
    @Override 
    public void initialize(BothFirstAndLastNameOrNoneOfThem constraintAnnotation) {
        //nothing to initialize
    }
    
    @Override 
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext cvc) {
        if(null != userEntity.getFirstname() && null != userEntity.getLastname()) {
            return true;
        }
        return null == userEntity.getFirstname() && null == userEntity.getLastname();
    }
}
