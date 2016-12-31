package xyz.codingmentor.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.BirthDateBeforeRegistrationDate;
import xyz.codingmentor.constraint.BothFirstAndLastNameOrNoneOfThem;

/**
 *
 * @author Ádám
 */
@BothFirstAndLastNameOrNoneOfThem
@BirthDateBeforeRegistrationDate
public class UserEntity {
    @NotNull
    @Size(min = 6)
    private String username;
    @NotNull
    @Size(min = 6)
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*"), 
        @Pattern(regexp = ".*[A-Z].*"), 
        @Pattern(regexp = ".*[0-9=+<>.,].*")
    })
    private String password;
    private String firstname;
    private String lastname;
    @Pattern(regexp = "^[0-9]{4}.*")
    private String address;
    @Pattern(regexp = "^(06|\\+36)[0-9]{9}")
    private String phone;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z-.]+$")
    private String email;
    private Sex sex;
    @NotNull
    @Past
    private Date registrationDate;
    @NotNull
    @Past
    private Date lastModifiedDate;
    private Date dateOfBirth;
    private boolean admin;

    public UserEntity() {
        //default constructor for Json
    }

    private UserEntity(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.sex = builder.sex;
        this.registrationDate = builder.registrationDate;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public static class Builder {
        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String address;
        private String phone;
        private String email;
        private Sex sex;
        private Date registrationDate;
        private Date lastModifiedDate;
        private Date dateOfBirth;
        private boolean admin;
        
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        
        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }
        
        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }
        
        public Builder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }
        
        public Builder lastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }
        
        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }
        
        public UserEntity build() {
            return new UserEntity(this);
        }
    }

    @Override
    public String toString() {
        return "\nUserEntity: " + "username=" + username + ", password=" + password + 
                ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + 
                ", phone=" + phone + ", email=" + email + ", sex=" + sex + 
                ", registrationDate=" + registrationDate + ", lastModifiedDate=" + lastModifiedDate + 
                ", dateOfBirth=" + dateOfBirth + ", admin=" + admin;
    }
}
