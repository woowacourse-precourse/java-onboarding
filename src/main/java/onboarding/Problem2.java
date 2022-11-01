package onboarding;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        return findDuplicationLetters(cryptogram);
    }

    private static String findDuplicationLetters(String cryptogram) {
        Set<Integer> duplicationLetterIndexes = new LinkedHashSet<>();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                duplicationLetterIndexes.add(i - 1);
                duplicationLetterIndexes.add(i);
            }
        }

        if (duplicationLetterIndexes.size() != 0) {
            cryptogram = removeDuplicationLetters(cryptogram, duplicationLetterIndexes);
            return findDuplicationLetters(cryptogram);
        }
        return cryptogram;
    }

    private static String removeDuplicationLetters(String cryptogram,
        Set<Integer> duplicationLetterIndexSet) {
        List<Integer> duplicationLetterIndexes = duplicationLetterIndexSet.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        while (!duplicationLetterIndexes.isEmpty()) {
            Integer idx = duplicationLetterIndexes.remove(0);
            cryptogram = cryptogram.substring(0, idx) + cryptogram.substring(idx + 1);
        }
        return cryptogram;
    }
}
