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
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            int asciiLetter = word.charAt(index);
            answer.append(convertLetter(asciiLetter));
        }
        return answer.toString();
    }

    private static char convertLetter(int asciiLetter) {
        char convertedLetter = ' ';

        if (isSpace(asciiLetter) == true) { // 공백일 경우
            return ' ';
        }
        if (isLower(asciiLetter) == true) { // 소문자일 경우
            convertedLetter = convertLowerCase(asciiLetter);
        }
        if (isUpper(asciiLetter) == true) { // 대문자일 경우
            convertedLetter = convertUpperCase(asciiLetter);
        }
        return convertedLetter;
    }

    private static boolean isSpace(int asciiLetter) {   // 공백일 경우
        return asciiLetter == 32;
    }

    private static boolean isUpper(int asciiLetter) {   // 대문자일 경우

        return asciiLetter >= MIN_ASCII_UPPER_CASE && asciiLetter <= MAX_ASCII_UPPER_CASE;
    }

    private static boolean isLower(int asciiLetter) {   // 소문자일 경우
        return asciiLetter >= MIN_ASCII_LOWER_CASE && asciiLetter <= MAX_ASCII_LOWER_CASE;
    }

    private static char convertUpperCase(int asciiLetter) {
        return (char)(MAX_ASCII_UPPER_CASE - (asciiLetter - MIN_ASCII_UPPER_CASE));
    }

    private static char convertLowerCase(int asciiLetter) {
        return (char)(MAX_ASCII_LOWER_CASE - (asciiLetter - MIN_ASCII_LOWER_CASE));
    }

}
