package onboarding;

public class Problem4 {
    private static final int MIN_ASCII_LOWER_CASE = 97;
    private static final int MAX_ASCII_LOWER_CASE = 122;
    private static final int MIN_ASCII_UPPER_CASE = 65;
    private static final int MAX_ASCII_UPPER_CASE = 90;


    public static String solution(String word) {
        return treeFrog(word);
    }

    private static String treeFrog(String word) {
        String answer = "";

        return answer;
    }

    private static char convertLetter(int asciiLetter) {

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
