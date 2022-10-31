package onboarding;

public class Problem4 {
    private static final int MIN_ASCII_LOWER_CASE = 97;
    private static final int MAX_ASCII_LOWER_CASE = 122;
    private static final int MIN_ASCII_UPPER_CASE = 65;
    private static final int MAX_ASCII_UPPER_CASE = 90;


    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String treeFrog(String word) {
        for (int index = 0; index < word.length(); index++) {
            int asciiLetter = (int) word.charAt(index);

        }
    }

    private static char convertLetter(int asciiLetter) {
        if (validateRightInput(asciiLetter) == false){
            return // error
        }

    }

    private static boolean validateRightInput(int asciiLetter) {
        if (isSpace(asciiLetter) && isLower(asciiLetter) && isUpper(asciiLetter)) {
            return true;
        }
        return false;
    }

    private static boolean isSpace(int asciiLetter) {
        if (asciiLetter == 32) {
            return true;
        }
        return false;
    }

    private static boolean isUpper(int asciiLetter) {
        if (asciiLetter >= MIN_ASCII_UPPER_CASE && asciiLetter <= MAX_ASCII_UPPER_CASE) {   // 대문자일 경우
            return true;
        }
        return false;
    }

    private static boolean isLower(int asciiLetter) {
        if (asciiLetter >= MIN_ASCII_LOWER_CASE && asciiLetter <= MAX_ASCII_LOWER_CASE) {   // 대문자일 경우
            return true;
        }
        return false;
    }

}
