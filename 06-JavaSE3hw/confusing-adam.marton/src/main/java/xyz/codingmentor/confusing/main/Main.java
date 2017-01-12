package xyz.codingmentor.confusing.main;

import xyz.codingmentor.confusing.analyzer.AnalyzerClass;
import xyz.codingmentor.confusing.analyzer.ClassToAnalyze;

/**
 *
 * @author Ádám
 */
public class Main {
    
    private Main() {
        //default constructor
    }
    
    public static void main(String[] args) {
        AnalyzerClass analyzerClass = new AnalyzerClass();
        analyzerClass.analyze(ClassToAnalyze.class);
    }
}
