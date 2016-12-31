package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.codingmentor.entity.Sex;
import xyz.codingmentor.entity.UserEntity;

/**
 *
 * @author Ádám
 */
public class UserDBTest {
    UserDB userDB;
    UserEntity firstUserEntity;
    UserEntity secondUserEntity;
    Calendar dateOfBirthCalendar;
    Calendar registrationDateCalendar;
    Date dateOfBirth;
    Date registrationDate;
    Date lastModifiedDate;
    
    @Before
    public void setUp() {
        userDB = new UserDB();
        dateOfBirthCalendar = new GregorianCalendar(2000, 1, 2, 3, 4);
        dateOfBirth = dateOfBirthCalendar.getTime();
        registrationDateCalendar = new GregorianCalendar();
        registrationDateCalendar.add(Calendar.SECOND, -2);
        registrationDate = registrationDateCalendar.getTime();
        lastModifiedDate = registrationDate;
        firstUserEntity = new UserEntity.Builder()
                .username("firstTester")
                .password("Abc123")
                .address("1111 Budapest")
                .phone("+36301234567")
                .email("first@tester.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .admin(true)
                .build();
        secondUserEntity = new UserEntity.Builder()
                .username("secondTester")
                .password("Def456")
                .address("3333 Miskolc")
                .phone("06709876543")
                .email("second@tester.org")
                .sex(Sex.FEMALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .admin(false)
                .build();
    }

    @Test
    public void testAddUser() {
        userDB.addUser(firstUserEntity);
        Assert.assertEquals(firstUserEntity, userDB.getUser("firstTester"));
    }

    @Test
    public void testGetUser() {
        userDB.addUser(secondUserEntity);
        UserEntity returnedUserEntity = userDB.getUser(secondUserEntity.getUsername());
        Assert.assertEquals(returnedUserEntity, secondUserEntity);
    }

    @Test
    public void testAuthenticate() {
        userDB.addUser(firstUserEntity);
        userDB.addUser(secondUserEntity);
        Assert.assertEquals(true, userDB.authenticate("firstTester", "Abc123"));
    }

    @Test
    public void testModifyUser() {
        userDB.addUser(firstUserEntity);
        userDB.addUser(secondUserEntity);
        secondUserEntity.setEmail("new@email.net");
        secondUserEntity.setPhone("06209876543");
        UserEntity modifiedUserEntity = userDB.modifyUser(secondUserEntity);
        Assert.assertEquals(modifiedUserEntity, secondUserEntity);
    }

    @Test
    public void testDeleteUser() {
        userDB.addUser(firstUserEntity);
        userDB.addUser(secondUserEntity);
        UserEntity deletedUserEntity = userDB.deleteUser(firstUserEntity);
        Assert.assertEquals(deletedUserEntity, firstUserEntity);
    }

    @Test
    public void testGetAllUser() {
        userDB.addUser(firstUserEntity);
        userDB.addUser(secondUserEntity);
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(firstUserEntity);
        userEntities.add(secondUserEntity);
        List<UserEntity> returnedUserEntities = userDB.getAllUser();
        Assert.assertEquals(returnedUserEntities, userEntities);
    }
    
}
