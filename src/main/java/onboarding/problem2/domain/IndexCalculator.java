package onboarding.problem2.domain;

import java.util.stream.IntStream;

public class IndexCalculator {
    public static int overlapStartIndex(final String[] splitCryptogram) {
        return IntStream.range(0, splitCryptogram.length - 1)
                .filter(index -> isOverlapStart(splitCryptogram, index))
                .findFirst()
                .orElse(-1);
    }
    
    private static boolean isOverlapStart(final String[] splitCryptogram, final int index) {
        return splitCryptogram[index].equals(splitCryptogram[index + 1]);
    }
    
    public static int overlapEndIndex(final int overlapStartIndex, final String[] splitCryptogram) {
        return IntStream.range(overlapStartIndex, splitCryptogram.length - 1)
                .filter(index -> isOverlapEnd(overlapStartIndex, splitCryptogram, index))
                .findFirst()
                .orElse(-1);
    }
    
    private static boolean isOverlapEnd(final int overlapStartIndex, final String[] splitCryptogram, final int index) {
        return !splitCryptogram[overlapStartIndex].equals(splitCryptogram[index]);
    }
}
