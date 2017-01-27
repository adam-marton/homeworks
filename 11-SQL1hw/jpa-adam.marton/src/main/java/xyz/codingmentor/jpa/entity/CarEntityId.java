package xyz.codingmentor.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ádám
 */
public class CarEntityId implements Serializable {
    private String plate;
    private String brand;

    public CarEntityId() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.plate);
        hash = 97 * hash + Objects.hashCode(this.brand);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarEntityId other = (CarEntityId) obj;
        if (!Objects.equals(this.plate, other.plate)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        return true;
    }
}
