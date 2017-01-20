package xyz.codingmentor.webshop.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ádám
 */
public class UserEntityTest {
    private static ValidatorFactory vf;
    private static Validator validator;
    private Calendar dateOfBirthCalendar;
    private Calendar registrationDateCalendar;
    private Date dateOfBirth;
    private Date registrationDate;
    private Date lastModifiedDate;
    private UserEntity userEntity;
    
    @BeforeClass
    public static void setUpClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
        vf.close();
    }
    
    @Before
    public void setUp() {
        dateOfBirthCalendar = new GregorianCalendar(2000, 1, 2, 3, 4);
        dateOfBirth = dateOfBirthCalendar.getTime();
        registrationDateCalendar = new GregorianCalendar();
        registrationDateCalendar.add(Calendar.SECOND, -2);
        registrationDate = registrationDateCalendar.getTime();
        lastModifiedDate = registrationDate;
        userEntity = new UserEntity.Builder()
                .username("tester")
                .password("Abc123")
                .address("1111 Budapest")
                .phone("+36301234567")
                .email("tester@test.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .admin(false)
                .build();
    }

    @Test
    public void testValidUsername() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidUsername() {
        String wrongUsername = "test";
        userEntity.setUsername(wrongUsername);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongUsername, violations.iterator().next().getInvalidValue());
    }
    
    @Test
    public void testValidPassword() {
        userEntity.setPassword("Abcde+");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidPassword() {
        String wrongPassword = "AbCdEf";
        userEntity.setPassword(wrongPassword);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongPassword, violations.iterator().next().getInvalidValue());
    }
    
    @Test
    public void testValidFirstnameAndLastname() {
        userEntity.setFirstname("Passed");
        userEntity.setLastname("Test");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());        
    }
    
    @Test
    public void testInvalidFirstnameAndLastname() {
        String firstname = "FailedTest";
        userEntity.setFirstname(firstname);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{BothFirstAndLastNameOrNoneOfThem.message}", violations.iterator().next().getMessageTemplate());
    }
    
    @Test
    public void testValidAddress() {
        userEntity.setAddress(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());      
    }
    
    @Test
    public void testInvalidAddress() {
        String invalidAddress = "Budapest 1111";
        userEntity.setAddress(invalidAddress);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(invalidAddress, violations.iterator().next().getInvalidValue());    
    }
    
    @Test
    public void testValidPhone() {
        userEntity.setPhone("06201234567");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidPhone() {
        String invalidPhone = "0620/1234567";
        userEntity.setPhone(invalidPhone);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(invalidPhone, violations.iterator().next().getInvalidValue());    
    }
    
    @Test
    public void testValidEmail() {
        userEntity.setEmail("valid@email.hu");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidEmail() {
        String invalidEmail = "invalid@mail";
        userEntity.setEmail(invalidEmail);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(invalidEmail, violations.iterator().next().getInvalidValue());    
    }
    
    @Test
    public void testValidRegistrationDate() {
        Calendar validRegistrationDateCalendar = new GregorianCalendar(2010, 1, 2);
        Date validRegistrationDate = validRegistrationDateCalendar.getTime();
        userEntity.setRegistrationDate(validRegistrationDate);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidRegistrationDate() {
        Calendar invalidRegistrationDateCalendar = new GregorianCalendar();
        invalidRegistrationDateCalendar.add(Calendar.WEEK_OF_YEAR, 1);
        Date invalidRegistrationDate = invalidRegistrationDateCalendar.getTime();
        userEntity.setRegistrationDate(invalidRegistrationDate);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(invalidRegistrationDate, violations.iterator().next().getInvalidValue());
    }
    
    @Test
    public void testValidLastModifiedDate() {        
        Calendar validLastModifiedDateCalendar = new GregorianCalendar();
        validLastModifiedDateCalendar.add(Calendar.DAY_OF_YEAR, -1);
        Date validModifiedDate = validLastModifiedDateCalendar.getTime();
        userEntity.setRegistrationDate(validModifiedDate);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidLastModifiedDate() {
        Date invalidLastModifiedDate = null;
        userEntity.setLastModifiedDate(invalidLastModifiedDate); 
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(invalidLastModifiedDate, violations.iterator().next().getInvalidValue()); 
    }
    
    @Test
    public void testValidDateOfBirth() {
        userEntity.setDateOfBirth(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void testInvalidDateOfBirth() {
        dateOfBirthCalendar = new GregorianCalendar();
        dateOfBirthCalendar.add(Calendar.YEAR, 3);
        dateOfBirth = dateOfBirthCalendar.getTime();
        userEntity.setDateOfBirth(dateOfBirth);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{BirthDateBeforeRegistrationDate.message}", violations.iterator().next().getMessageTemplate());
    }
}
