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
    private UserEntity firstUserEntity;
    private UserEntity secondUserEntity;
    private Calendar dateOfBirthCalendar;
    private Calendar registrationDateCalendar;
    private Date dateOfBirth;
    private Date registrationDate;
    private Date lastModifiedDate;
    
    @Before
    public void setUp() {
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
        UserDB.getInstance().addUser(firstUserEntity);
        Assert.assertEquals(firstUserEntity, UserDB.getInstance().getUser("firstTester"));
        UserDB.getInstance().deleteUser(firstUserEntity);
    }

    @Test
    public void testGetUser() {
        UserDB.getInstance().addUser(secondUserEntity);
        UserEntity returnedUserEntity = UserDB.getInstance().getUser(secondUserEntity.getUsername());
        Assert.assertEquals(returnedUserEntity, secondUserEntity);
        UserDB.getInstance().deleteUser(secondUserEntity);
    }

    @Test
    public void testAuthenticate() {
        UserDB.getInstance().addUser(firstUserEntity);
        UserDB.getInstance().addUser(secondUserEntity);
        Assert.assertEquals(true, UserDB.getInstance().authenticate("firstTester", "Abc123"));
        UserDB.getInstance().deleteUser(firstUserEntity);
        UserDB.getInstance().deleteUser(secondUserEntity);
    }

    @Test
    public void testModifyUser() {
        UserDB.getInstance().addUser(firstUserEntity);
        UserDB.getInstance().addUser(secondUserEntity);
        secondUserEntity.setEmail("new@email.net");
        secondUserEntity.setPhone("06209876543");
        UserEntity modifiedUserEntity = UserDB.getInstance().modifyUser(secondUserEntity);
        Assert.assertEquals(modifiedUserEntity, secondUserEntity);
        UserDB.getInstance().deleteUser(firstUserEntity);
        UserDB.getInstance().deleteUser(secondUserEntity);
    }

    @Test
    public void testDeleteUser() {
        UserDB.getInstance().addUser(firstUserEntity);
        UserDB.getInstance().addUser(secondUserEntity);
        UserEntity deletedUserEntity = UserDB.getInstance().deleteUser(firstUserEntity);
        Assert.assertEquals(deletedUserEntity, firstUserEntity);
        UserDB.getInstance().deleteUser(secondUserEntity);
    }

    @Test
    public void testGetAllUser() {
        UserDB.getInstance().addUser(firstUserEntity);
        UserDB.getInstance().addUser(secondUserEntity);
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(firstUserEntity);
        userEntities.add(secondUserEntity);
        List<UserEntity> returnedUserEntities = UserDB.getInstance().getAllUser();
        Assert.assertEquals(returnedUserEntities, userEntities);
        UserDB.getInstance().deleteUser(firstUserEntity);
        UserDB.getInstance().deleteUser(secondUserEntity);
    }
    
}
