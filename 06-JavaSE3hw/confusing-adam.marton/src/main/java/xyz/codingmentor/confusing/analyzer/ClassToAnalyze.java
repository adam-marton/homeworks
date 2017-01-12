package xyz.codingmentor.confusing.analyzer;

import xyz.codingmentor.confusing.annotation.Confusing;

/**
 *
 * @author Ádám
 */
public class ClassToAnalyze {
    private String firstWord;
    private String secondWord;
    private String thirdWord;
    @Confusing
    private int i;

    @Confusing
    public ClassToAnalyze(String asd, String lol, String pls, int kh) {
        this.firstWord = pls;
        this.secondWord = asd;
        this.thirdWord = lol;
        this.i = kh;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }
    
    @Confusing
    public void setSomething(String wot) {
        this.secondWord = wot;
    }

    @Confusing
    public String getAWord() {
        return thirdWord;
    }

    public void setThirdWord(String thirdWord) {
        this.thirdWord = thirdWord;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
