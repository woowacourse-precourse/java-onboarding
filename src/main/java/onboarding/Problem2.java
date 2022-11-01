package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String ENGLISH_PATTERN =  "^[a-z]*$";
    public static String solution(String cryptogram) {
        cryptogramLengthValidation(cryptogram.length());
        cryptogramTypeValidation(cryptogram);

        return extractPlainText(cryptogram);
    }
    private static String extractPlainText(String cryptogram) {
        while (checkThisStringisDuplicate(cryptogram)) {
            cryptogram = removeDuplicateCharacter(cryptogram);
        }
        return cryptogram;
    }

    private static Boolean checkThisStringisDuplicate(String answer) {
        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i) == answer.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }
    private static String removeDuplicateCharacter(String cryptogram) {
        int OverlappedCharacterSize = 0;
        String answer = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            char now = cryptogram.charAt(i);
            OverlappedCharacterSize += 1;
            if (isLastIndex(cryptogram, i)) {
                answer = addNonDuplicateCharacter(OverlappedCharacterSize, answer, now);
                break;
            }
            if (isSameWithNextCharacter(cryptogram, i, now)) {
                answer = addNonDuplicateCharacter(OverlappedCharacterSize, answer, now);
                OverlappedCharacterSize = 0;
            }
        }
        return answer;
    }

    private static boolean isLastIndex(String cryptogram, int i) {
        return i == cryptogram.length() - 1;
    }
    private static boolean isSameWithNextCharacter(String cryptogram, int i, char now) {
        return now != cryptogram.charAt(i + 1);
    }
    private static String addNonDuplicateCharacter(int OverlappedCharacterSize, String answer,
        char now) {
        if (isNonDuplicate(OverlappedCharacterSize)) {
            answer += now;
        }
        return answer;
    }
    private static Boolean isNonDuplicate(int OverlappedCharacterSize) {
        if (OverlappedCharacterSize < 2) {
            return true;
        }
        return false;
    }
    private static void cryptogramTypeValidation(String cryptogram) {
        if (!Pattern.matches(ENGLISH_PATTERN, cryptogram)) {
            throw new IllegalArgumentException("영소문자만 입력 가능합니다");
        }
    }

    private static void cryptogramLengthValidation(int cryptogramLength) {
        if (MIN_LENGTH > cryptogramLength || cryptogramLength > MAX_LENGTH) {
            throw new IllegalArgumentException("문자열의 길이는 1 이상 1000 이하만 허용합니다");
        }
    }
}
