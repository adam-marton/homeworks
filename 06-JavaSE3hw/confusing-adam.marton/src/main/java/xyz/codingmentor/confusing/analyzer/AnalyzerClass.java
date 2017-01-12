package xyz.codingmentor.confusing.analyzer;

import xyz.codingmentor.confusing.annotation.Confusing;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ádám
 */
public class AnalyzerClass {
    private static final Logger LOGGER = Logger.getLogger(AnalyzerClass.class.getName());

    public AnalyzerClass() {
        //default constructor
    }

    public void analyze(final Class<?> clazz) {
        analyzeClass(clazz);
        analyzeConstructors(clazz);
        analyzeMethods(clazz);
        analyzeFields(clazz);
    }

    public void analyzeClass(final Class<?> clazz) {
        if (clazz.getClass().isAnnotationPresent(Confusing.class)) {
            LOGGER.log(Level.INFO, "Class name: {0}\nWritten by: {1}\nLast modified: {2}",
                    new Object[]{clazz.getClass().getName(), clazz.getAnnotation(Confusing.class).codeWrittenBy(),
                        clazz.getAnnotation(Confusing.class).lastModified()});
        }
    }

    public void analyzeConstructors(final Class<?> clazz) {
        for (Constructor c : clazz.getConstructors()) {
            if (c.isAnnotationPresent(Confusing.class)) {
                LOGGER.log(Level.INFO, "Constructor name: {0}\nParameters: {1}",
                        new Object[]{c.getName(), Arrays.toString(c.getParameters())});
            }
        }

    }

    public void analyzeMethods(final Class<?> clazz) {
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(Confusing.class)) {
                LOGGER.log(Level.INFO, "Method name: {0}\nWritten by: {1}\nLast modified: {2}",
                        new Object[]{m.getName(), m.getAnnotation(Confusing.class).codeWrittenBy(),
                            m.getAnnotation(Confusing.class).lastModified()});
            }
        }
    }

    public void analyzeFields(final Class<?> clazz) {
        for (Field f : clazz.getFields()) {
            if (f.isAnnotationPresent(Confusing.class)) {
                LOGGER.log(Level.INFO, "Field name: {0}\nWritten by: {1}\nLast modified: {2}",
                        new Object[]{f.getName(), f.getAnnotation(Confusing.class).codeWrittenBy(),
                            f.getAnnotation(Confusing.class).lastModified()});
            }
        }
    }
}
