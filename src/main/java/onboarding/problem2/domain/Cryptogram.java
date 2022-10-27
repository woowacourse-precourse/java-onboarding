package onboarding.problem2.domain;

import java.util.Objects;

public class Cryptogram {
    private final String cryptogram;
    
    public Cryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public Cryptogram decrypte() {
        return decrypteCryptogram(parseEqualsCharIndex());
    }
    
    private int parseEqualsCharIndex() {
        int equalsCharIndex = -1;
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            equalsCharIndex = getEqualsCharIndex(equalsCharIndex, index);
        }
        
        return equalsCharIndex;
    }
    
    private int getEqualsCharIndex(int equalsCharIndex, final int index) {
        if (isEquals(cryptogram.charAt(index), cryptogram.charAt(index + 1))) {
            equalsCharIndex = index;
        }
        
        return equalsCharIndex;
    }
    
    private boolean isEquals(final char firstChar, final char secondChar) {
        return firstChar == secondChar;
    }
    
    private Cryptogram decrypteCryptogram(final int equalsCharIndex) {
        if (equalsCharIndex != -1) {
            return new Cryptogram(removeEqualsTwoChar(equalsCharIndex));
        }
        
        return this;
    }
    
    private String removeEqualsTwoChar(final int index) {
        return cryptogram.substring(0, index) + cryptogram.substring(index + 2);
    }
    
    public String getCryptogram() {
        return cryptogram;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cryptogram that = (Cryptogram) o;
        return Objects.equals(cryptogram, that.cryptogram);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cryptogram);
    }
    
    @Override
    public String toString() {
        return "Cryptogram{" +
                "cryptogram='" + cryptogram + '\'' +
                '}';
    }
}
