package xyz.codingmentor.carpartfactory.factory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xyz.codingmentor.carpartfactory.entity.CarPart;
import xyz.codingmentor.carpartfactory.entity.CarPartType;
import xyz.codingmentor.carpartfactory.entity.CarType;

/**
 *
 * @author Ádám
 */
public class CarPartFactory {
    private final Map<Integer, Map<CarPart, Date>> manufacturedParts;
    private Integer serialNumber;

    public CarPartFactory() {
        manufacturedParts = new HashMap<>();
        serialNumber = 1;
    }
    
    public CarPart createPart(CarType carType, CarPartType carPartType) {
        CarPart carPart = new CarPart(carType, carPartType);
        Date actualDate = new Date();
        logManufacture(actualDate, carPart);
        return carPart;
    }
    
    public void logManufacture(Date date, CarPart carPart) {
        Map<CarPart, Date> part = new HashMap<>();
        part.put(carPart, date);
        manufacturedParts.put(serialNumber, part);
        serialNumber++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory log:");
        for(Map.Entry<Integer, Map<CarPart, Date>> part : manufacturedParts.entrySet()) {
            stringBuilder.append("\nSerial number: ").append(part.getKey());
            for(Map.Entry<CarPart, Date> p : part.getValue().entrySet()) {
                stringBuilder.append(p.getKey().toString());
                stringBuilder.append("\nDate: ").append(p.getValue().toString());
            }
        }
        return stringBuilder.toString();
    }
}
