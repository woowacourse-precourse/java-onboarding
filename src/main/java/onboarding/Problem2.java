package onboarding;

import java.util.stream.IntStream;

public class Problem2 {

    private static final int IS_NOT_DUPLICATE = -1;

    public static String solution(String cryptogram) {
        return deleteDuplicateWord(cryptogram);
    }

    private static String deleteDuplicateWord(String cryptogram) {
        while (true) {
            int duplicateCharacterIndex = checkDuplicateIndex(cryptogram);
            if (duplicateCharacterIndex == IS_NOT_DUPLICATE)
                return cryptogram;

            int index = duplicateCharacterIndex;
            for (; index < cryptogram.length(); index++) {
                if (cryptogram.charAt(duplicateCharacterIndex) == cryptogram.charAt(index)) {
                    continue;
                }
                break;
            }
            cryptogram = cryptogram.substring(0, duplicateCharacterIndex) + cryptogram.substring(index);
        }
    }

    private static int checkDuplicateIndex(String value) {
        return IntStream.range(0, value.length() - 1)
            .filter(i -> value.charAt(i) == value.charAt(i + 1)).findFirst()
            .orElse(IS_NOT_DUPLICATE);
    }
}
