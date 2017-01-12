package xyz.codingmentor.carpartfactory.entity;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.carpartfactory.annotation.Defect;

/**
 *
 * @author Ádám
 */
public class CarPart {
    private static final Logger LOGGER = Logger.getLogger(CarPart.class.getName());
    private CarType carType;
    private CarPartType carPartType;

    public CarPart(CarType carType, CarPartType carPartType) {
        this.carType = carType;
        this.carPartType = carPartType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarPartType getCarPartType() {
        return carPartType;
    }

    public void setCarPartType(CarPartType carPartType) {
        this.carPartType = carPartType;
    }
    
    public void checkPartDefect() throws NoSuchFieldException {
        if(carPartType.getClass().getField(carPartType.name()).isAnnotationPresent(Defect.class)) {
            LOGGER.log(Level.WARNING, "{0}: {1}; this part is defected!",
                    new Object[]{this.carType.toString(), this.carPartType.toString()});
        }
        else {
            LOGGER.log(Level.INFO, "{0}: {1}; this part is perfect!", 
                    new Object[]{this.carType.toString(), this.carPartType.toString()});
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.carType);
        hash = 71 * hash + Objects.hashCode(this.carPartType);
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
        final CarPart other = (CarPart) obj;
        if (this.carType != other.carType) {
            return false;
        }
        if (this.carPartType != other.carPartType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nCar type: " + carType + " Part type: " + carPartType;
    }
}
