package onboarding.problem2.domain;

import onboarding.problem2.utils.IndexCalculator;

import java.util.Objects;

public class Cryptogram {
    private static final String DELIMITER = "";
    private static final int NOT_EXIST_OVERLAP_CHARACTER = -1;
    
    private String cryptogram;
    
    public Cryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public boolean decrypt() {
        int overlapStartIndex = IndexCalculator.overlapStartIndex(0, split());
        decryptOneCycle(overlapStartIndex);
        return isOverlapCharacterExist(overlapStartIndex);
    }
    
    private void decryptOneCycle(int overlapStartIndex) {
        while (isOverlapCharacterExist(overlapStartIndex)) {
            final int overlapEndIndex = IndexCalculator.overlapEndIndex(overlapStartIndex, split());
            removeDuplicateCharacters(overlapStartIndex, overlapEndIndex);
            overlapStartIndex = IndexCalculator.overlapStartIndex(overlapStartIndex, split());
        }
    }
    
    private void removeDuplicateCharacters(final int overlapStartIndex, final int overlapEndIndex) {
        cryptogram = cryptogram.substring(0, overlapStartIndex) + cryptogram.substring(overlapEndIndex);
    }
    
    private static boolean isOverlapCharacterExist(final int overlapEndIndex) {
        return overlapEndIndex != NOT_EXIST_OVERLAP_CHARACTER;
    }
    
    private String[] split() {
        return cryptogram.split(DELIMITER);
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
