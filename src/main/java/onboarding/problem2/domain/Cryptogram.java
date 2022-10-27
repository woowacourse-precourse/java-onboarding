package onboarding.problem2.domain;

public class Cryptogram {
    private static final String DELIMITER = "";
    
    private final String cryptogram;
    
    public Cryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public Cryptogram decrypte() {
        final int overlapStartIndex = IndexCalculator.overlapStartIndex(split());
        final int overlapEndIndex = IndexCalculator.overlapEndIndex(overlapStartIndex, split());
        
        return new Cryptogram(cryptogram.substring(0, overlapStartIndex) + cryptogram.substring(overlapEndIndex));
    }
    
    private String[] split() {
        return cryptogram.split(DELIMITER);
    }
    
    public String getCryptogram() {
        return cryptogram;
    }
}
