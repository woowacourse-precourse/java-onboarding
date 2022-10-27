package onboarding.problem2.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Cryptogram {
    private static final String DELIMITER = "";
    
    private final String cryptogram;
    
    public Cryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public int overlapStartIndex() {
        final String[] splitCryptogram = split();
        return IntStream.range(0, splitCryptogram.length - 1)
                .filter(index -> isOverlapStart(splitCryptogram, index))
                .findFirst()
                .orElse(-1);
    }
    
    private boolean isOverlapStart(final String[] splitCryptogram, final int index) {
        return splitCryptogram[index].equals(splitCryptogram[index + 1]);
    }
    
    public int overlapEndIndex(final int overlapStartIndex) {
        final String[] splitCryptogram = split();
        return IntStream.range(overlapStartIndex, splitCryptogram.length - 1)
                .filter(index -> isOverlapEnd(overlapStartIndex, splitCryptogram, index))
                .findFirst()
                .orElse(-1);
    }
    
    private static boolean isOverlapEnd(final int overlapStartIndex, final String[] splitCryptogram, final int index) {
        return !splitCryptogram[overlapStartIndex].equals(splitCryptogram[index]);
    }
    
    private String[] split() {
        return cryptogram.split(DELIMITER);
    }
}
