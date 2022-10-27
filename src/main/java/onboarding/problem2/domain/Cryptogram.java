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
                .filter(index -> splitCryptogram[index].equals(splitCryptogram[index + 1]))
                .findFirst()
                .orElse(-1);
    }
    
    private String[] split() {
        return cryptogram.split(DELIMITER);
    }
}
