package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 1000;
    static final String INPUT_ERROR = "Input Error";
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (!isValidInput(cryptogram)) {
            answer = INPUT_ERROR;
            return answer;
        }
        answer = decodeCryptogram(cryptogram);
        return answer;
    }

    private static String decodeCryptogram(String cryptogram) {
        List<Integer> duplicatedIndexs;
        Boolean isDuplicated = true;

        while (isDuplicated && cryptogram.length() > 0) {
            duplicatedIndexs = getDuplicatedIndexs(cryptogram);
            cryptogram = decodeOneStep(cryptogram, duplicatedIndexs);
            isDuplicated = getIsDuplicated(duplicatedIndexs);
        }
        return cryptogram;
    }

    private static boolean getIsDuplicated(List<Integer> duplicatedIndexs) {
        return !(duplicatedIndexs.isEmpty());
    }

    private static String decodeOneStep(String cryptogram, List<Integer> duplicatedIndexs) {
        String tempCryptogram = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!duplicatedIndexs.contains(i)) {
                tempCryptogram = tempCryptogram + cryptogram.charAt(i);
            }
        }
        return tempCryptogram;
    }

    private static List<Integer> getDuplicatedIndexs(String cryptogram) {
        char temp;
        char presentChar;
        List<Integer> duplicatedIndexs = new ArrayList<>();

        temp = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            presentChar = cryptogram.charAt(i);

            if (temp == presentChar) {
                duplicatedIndexs.add(i - 1);
                while (i < cryptogram.length() && temp == presentChar) {
                    duplicatedIndexs.add(i);
                    i++;
                    if (i < cryptogram.length()) {
                        presentChar = cryptogram.charAt(i);
                    }
                }
            }
            temp = presentChar;
        }
        return duplicatedIndexs;
    }

    private static boolean isValidInput(String cryptogram) {
        return (isNotNull(cryptogram) && isRightLength(cryptogram)
         && isNotConsistedLowerCase(cryptogram));
    }

    private static boolean isNotConsistedLowerCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotNull(String cryptogram) {
        return cryptogram != null;
    }

    private static boolean isRightLength(String cryptogram) {
        return cryptogram.length() >= MIN_LENGTH && cryptogram.length() <= MAX_LENGTH;
    }
}
