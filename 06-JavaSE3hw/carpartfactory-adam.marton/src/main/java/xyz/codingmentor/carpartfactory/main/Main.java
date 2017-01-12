package xyz.codingmentor.carpartfactory.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.carpartfactory.entity.CarPart;
import xyz.codingmentor.carpartfactory.entity.CarPartType;
import xyz.codingmentor.carpartfactory.entity.CarType;
import xyz.codingmentor.carpartfactory.factory.CarPartFactory;

/**
 *
 * @author Ádám
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    private Main() {
        //default constructor
    }
    
    public static void main(String[] args) throws NoSuchFieldException {
        CarPartFactory carPartFactory = new CarPartFactory();
        CarPart part1 = carPartFactory.createPart(CarType.FORD, CarPartType.GEARBOX);
        CarPart part2 = carPartFactory.createPart(CarType.AUDI, CarPartType.ELECTRICWINDOW);
        CarPart part3 = carPartFactory.createPart(CarType.TOYOTA, CarPartType.TURNSIGNAL);
        CarPart part4 = carPartFactory.createPart(CarType.MAZDA, CarPartType.REARWIEWMIRROR);
        part1.checkPartDefect();
        part2.checkPartDefect();
        part3.checkPartDefect();
        part4.checkPartDefect();
        LOGGER.log(Level.INFO, carPartFactory.toString());
    }
}
