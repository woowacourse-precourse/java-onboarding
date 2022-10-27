package onboarding.problem2.domain;

public class Cryptogram {
    private String cryptogram;
    
    public Cryptogram() {
        this("");
    }
    
    public Cryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public Cryptogram remove() {
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            if (isEquals(cryptogram.charAt(index), cryptogram.charAt(index + 1))) {
                return new Cryptogram(removeEqualsTwoChar(index));
            }
        }
        
        return this;
    }
    
    private boolean isEquals(final char firstChar, final char secondChar) {
        return firstChar == secondChar;
    }
    
    private String removeEqualsTwoChar(final int index) {
        return cryptogram.substring(0, index) + cryptogram.substring(index + 2);
    }
    
    public String getCryptogram() {
        return cryptogram;
    }
}
