package xyz.codingmentor.jpa.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Ádám
 */
@Embeddable
public class Repairer implements Serializable {
    private String name;
    private String address;

    public Repairer() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
