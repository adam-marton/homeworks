package xyz.codingmentor.quicksort.main;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.quicksort.sort.Quicksort;

/**
 *
 * @author Ádám
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    private Main() {
        //default constructor
    }
    
    public static void main(String[] args) {
        int[] array = { 5, 3, 1, 8, 9, 2, 7, 4, 0, 6 };
        LOGGER.log(Level.INFO, Arrays.toString(array));
        Quicksort.sort(array);
        LOGGER.log(Level.INFO, Arrays.toString(array));
    }
}