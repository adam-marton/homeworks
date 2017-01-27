package xyz.codingmentor.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ádám
 */
@Entity
public class Owner implements Serializable {
    @Id
    private String id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String phone;
    @OneToOne(mappedBy = "owner")
    private CarPark carPark;

    public Owner() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", phone=" + phone + ", carPark=" + carPark + '}';
    }
}
