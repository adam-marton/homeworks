package xyz.codingmentor.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Ádám
 */
@Entity
@IdClass(CarEntityId.class)
public class CarEntity implements Serializable {
    @Id
    private String plate;
    @Id
    private String brand;
    @Enumerated(EnumType.STRING)
    private Color color;

    public CarEntity() {
        //default constructor
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
